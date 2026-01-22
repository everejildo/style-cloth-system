--------------------------------------------------------------CREACION DEL USUARIO----------------------------------------------------------------------------------------------------------------------------------


---Creacion de login
create login Style_Cloth1 with password = 'cloth123';

--Dar permisos al login(user) / asignar un usuario a la base de datos 
use bd_tiendaropa
create user Style_Cloth1 for login Style_Cloth1
alter role db_datareader add member Style_Cloth1
alter role db_datawriter add member Style_Cloth1

--Dar rol de backup 
use bd_tiendaropa
go 
alter role db_backupoperator add member Style_Cloth1
go 

--Dar permiso de ejecucion
use bd_tiendaropa
grant execute to Style_Cloth1;


-----------------------------------------------------------TABLAS DE LA BASE DE DATOS--------------------------------------------------------------------------------------------------------------------------------

-- Tabla de empleados
CREATE TABLE empleado (
    idEmpleado INT IDENTITY PRIMARY KEY,
    nombre VARCHAR(30),
    apellido VARCHAR(30),
    fechaNac DATE,
    direccion VARCHAR(200),
    telefono VARCHAR(10) CHECK (LEN(telefono) = 10),
    correo VARCHAR(70),
    rfc VARCHAR(20) CHECK (DATALENGTH(rfc) = 13),
	puesto VARCHAR (200)
);

-- Tabla de usuarios
CREATE TABLE usuario (
    idUsuario INT PRIMARY KEY,
    correo VARCHAR(70),
    contraseña VARCHAR(30),
    idEmpleado INT, -- FOREIGN KEY
    fechaRegistro DATE,
    telefono VARCHAR(10) CHECK (LEN(telefono) = 10),
    estado VARCHAR(10),
    ultimoLogin DATE CHECK (ultimoLogin <> GETDATE()),
    CONSTRAINT fk_empleado FOREIGN KEY (idEmpleado) REFERENCES empleado(idEmpleado)
);

-- Tabla de productos
CREATE TABLE productos (
    idProducto INT IDENTITY PRIMARY KEY,
    nombre VARCHAR(50),
    descripcion VARCHAR(100),
    tipo VARCHAR(50),
    talla VARCHAR(10),
    genero VARCHAR(50),
    precio DECIMAL(10, 2),
    stock INT,
    fechaIngreso DATE
);

-- Tabla de clientes
CREATE TABLE clientes (
    idCliente INT IDENTITY PRIMARY KEY,
    nombre VARCHAR(30),
    apellido VARCHAR(50),
    telefono VARCHAR(10) CHECK (LEN(telefono) = 10) NULL,
    correo VARCHAR(70) NULL,
    direccion VARCHAR(200) NULL,
    numCompras INT,
    fecharegistro DATE
);

-- Tabla de proveedores
CREATE TABLE proveedores (
    idProveedor INT IDENTITY PRIMARY KEY,
    nombre VARCHAR(30),
    apellido VARCHAR(50),
    telefono VARCHAR(10) CHECK (LEN(telefono) = 10),
    correo VARCHAR(70),
    direccion VARCHAR(200),
    idEmpresa INT -- FOREIGN KEY (si hay una tabla de empresas, esta columna debe referirse a ella)
);

-- Tabla de ventas
CREATE TABLE ventas (
    idVenta INT IDENTITY PRIMARY KEY,
    fecha DATETIME,
    idEmpleado INT, -- FOREIGN KEY
    idCliente INT, -- FOREIGN KEY
    total DECIMAL(10, 2),
    metodoPago VARCHAR(30),
    CONSTRAINT fk_empleado_venta FOREIGN KEY (idEmpleado) REFERENCES empleado(idEmpleado),
    CONSTRAINT fk_cliente_venta FOREIGN KEY (idCliente) REFERENCES clientes(idCliente)
);

-- Tabla de detalles de ventas
CREATE TABLE ventas_detalle (
    idVenta INT NOT NULL, -- FOREIGN KEY
    idProducto INT NOT NULL, -- FOREIGN KEY
    cantidad INT,
    precio DECIMAL(10, 2),
    CONSTRAINT pk_ventas_detalle PRIMARY KEY (idVenta, idProducto),
    CONSTRAINT fk_venta_detalle FOREIGN KEY (idVenta) REFERENCES ventas(idVenta),
    CONSTRAINT fk_producto_detalle FOREIGN KEY (idProducto) REFERENCES productos(idProducto)
);

-- Tabla de compras
CREATE TABLE compras (
    idCompra INT IDENTITY PRIMARY KEY,
    fecha DATETIME,
    idEmpleado INT, -- FOREIGN KEY
    idProveedor INT, -- FOREIGN KEY
    total DECIMAL(10, 2),
    CONSTRAINT fk_empleado_compra FOREIGN KEY (idEmpleado) REFERENCES empleado(idEmpleado),
    CONSTRAINT fk_proveedor_compra FOREIGN KEY (idProveedor) REFERENCES proveedores(idProveedor)
);

-- Tabla de detalles de compras
CREATE TABLE compras_detalle (
    idCompra INT NOT NULL, -- FOREIGN KEY
    idProducto INT NOT NULL, -- FOREIGN KEY
    cantidad INT,
    precio DECIMAL(10, 2),
    estado VARCHAR(20),
    CONSTRAINT pk_compras_detalle PRIMARY KEY (idCompra, idProducto),
    CONSTRAINT fk_compra_detalle FOREIGN KEY (idCompra) REFERENCES compras(idCompra),
    CONSTRAINT fk_producto_compra_detalle FOREIGN KEY (idProducto) REFERENCES productos(idProducto)
);


 --------------------------------------------------------------------COMBO BOX--------------------------------------------------------------------------------------------------


create table empresass (
 idEmpresa int identity primary key,
 nombre varchar(50),
 telefono varchar(50) check (len(telefono) = 10),
 correo varchar(70)
 )

create table tipoProducto (
idTipoProd int identity primary key,
tipo varchar(50)
)

create table tallaProducto (
idTallaProd int identity primary key,
talla varchar(50)
)

create table generoroducto (
idGenProd int identity primary key,
genero varchar(50)
)

create table metodoPagoVentas (
idMetPag0 int identity primary key,
metodoPago varchar(50)
)

create table idiomaConf (
idIdiomaConf int identity primary key,
idioma varchar(50)
)


create table puesto (
    idpuesto int identity primary key,
    nombre varchar(30),
    descripcion varchar(100),
    sueldo numeric(7,2),
    departamento varchar(50),
    turno varchar(15)
);

----------------------------------------------------------PA_BACKUP_BD2------------------------------------------------------------------------------------------------------------

create proc pa_backup_bd2 @ruta nvarchar(100)
as
begin
	DECLARE @rutaCompleta NVARCHAR(200)
    
    SET @rutaCompleta = @ruta + 'bd_tiendaropa' + '.bak'
	
	BACKUP DATABASE bd_tiendaropa
	TO  DISK = @rutaCompleta
	WITH NOFORMAT, NOINIT,  
	NAME = 'bd_tiendaropa', SKIP, NOREWIND, NOUNLOAD,  STATS = 10

end

exec pa_backup_bd2 'D:\bakup\'

-----------------------------------------------------------AUDITORIAS----------------------------------------------------------------------------------------------------------


---Creacion de la tabla Auditorias
create table Auditorias (
AuditoriaID int identity primary key,
FechaHora datetime,
Tabla varchar(30),
Movimiento varchar(30),
Usuario varchar(50),
App varchar(20),
Host varchar(20),
RegistroAnterior varchar(max),
RegistroNuevo varchar(max)
)
---Auditando la tabla clientes 
create trigger tr_auditorias_clientes
on clientes
after insert, update, delete
as
begin
	-- declarar varibles para los datos de la tabla
	declare @rNuevo varchar(max), @rAnterior varchar(max)
	declare @usuario varchar(50), @app varchar(20), @host varchar(20)

	-- agregar informacion a las variables
	select @rNuevo = (select * from inserted for json auto)
	select @rAnterior = (select * from deleted for json auto)
	set @usuario = system_user
	set @app = app_name()
	set @host = host_name()
	
	-- si es insert
	if exists (select * from inserted) and not exists (select * from deleted)
	begin
		
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'clientes', 'Insert', @usuario, @app, @host, null, @rNuevo)
		select * from Auditorias
	end
	-- si es update
	if exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'clientes', 'Update', @usuario, @app, @host, @rAnterior, @rNuevo)
		select * from Auditorias
	end
	-- si es delete
	if not exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'clientes', 'Delete', @usuario, @app, @host, @rAnterior, null)
		select * from Auditorias
	end
end

---Auditando la tabla compras

create trigger tr_auditorias_compras
on compras
after insert, update, delete
as
begin
	-- declarar varibles para los datos de la tabla
	declare @rNuevo varchar(max), @rAnterior varchar(max)
	declare @usuario varchar(50), @app varchar(20), @host varchar(20)

	-- agregar informacion a las variables
	select @rNuevo = (select * from inserted for json auto)
	select @rAnterior = (select * from deleted for json auto)
	set @usuario = system_user
	set @app = app_name()
	set @host = host_name()
	
	-- si es insert
	if exists (select * from inserted) and not exists (select * from deleted)
	begin
		
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'compras', 'Insert', @usuario, @app, @host, null, @rNuevo)
		select * from Auditorias
	end
	-- si es update
	if exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'compras', 'Update', @usuario, @app, @host, @rAnterior, @rNuevo)
		select * from Auditorias
	end
	-- si es delete
	if not exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'compras', 'Delete', @usuario, @app, @host, @rAnterior, null)
		select * from Auditorias
	end
end

---Auditando la tabla compras_detalle


create trigger tr_auditorias_compras_detalle
on compras_detalle
after insert, update, delete
as
begin
	-- declarar varibles para los datos de la tabla
	declare @rNuevo varchar(max), @rAnterior varchar(max)
	declare @usuario varchar(50), @app varchar(20), @host varchar(20)

	-- agregar informacion a las variables
	select @rNuevo = (select * from inserted for json auto)
	select @rAnterior = (select * from deleted for json auto)
	set @usuario = system_user
	set @app = app_name()
	set @host = host_name()
	
	-- si es insert
	if exists (select * from inserted) and not exists (select * from deleted)
	begin
		
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'compras_detalle', 'Insert', @usuario, @app, @host, null, @rNuevo)
		select * from Auditorias
	end
	-- si es update
	if exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'compras_detalle', 'Update', @usuario, @app, @host, @rAnterior, @rNuevo)
		select * from Auditorias
	end
	-- si es delete
	if not exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'compras_detalle', 'Delete', @usuario, @app, @host, @rAnterior, null)
		select * from Auditorias
	end
end

---Auditando la tabla empleado


create trigger tr_auditorias_empleado
on empleado
after insert, update, delete
as
begin
	-- declarar varibles para los datos de la tabla
	declare @rNuevo varchar(max), @rAnterior varchar(max)
	declare @usuario varchar(50), @app varchar(20), @host varchar(20)

	-- agregar informacion a las variables
	select @rNuevo = (select * from inserted for json auto)
	select @rAnterior = (select * from deleted for json auto)
	set @usuario = system_user
	set @app = app_name()
	set @host = host_name()
	
	-- si es insert
	if exists (select * from inserted) and not exists (select * from deleted)
	begin
		
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'empleado', 'Insert', @usuario, @app, @host, null, @rNuevo)
		select * from Auditorias
	end
	-- si es update
	if exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'cempleado', 'Update', @usuario, @app, @host, @rAnterior, @rNuevo)
		select * from Auditorias
	end
	-- si es delete
	if not exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'empleado', 'Delete', @usuario, @app, @host, @rAnterior, null)
		select * from Auditorias
	end
end

---Auditando la tabla empresa

create trigger tr_auditorias_empresa
on empresa
after insert, update, delete
as
begin
	-- declarar varibles para los datos de la tabla
	declare @rNuevo varchar(max), @rAnterior varchar(max)
	declare @usuario varchar(50), @app varchar(20), @host varchar(20)

	-- agregar informacion a las variables
	select @rNuevo = (select * from inserted for json auto)
	select @rAnterior = (select * from deleted for json auto)
	set @usuario = system_user
	set @app = app_name()
	set @host = host_name()
	
	-- si es insert
	if exists (select * from inserted) and not exists (select * from deleted)
	begin
		
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'empresa', 'Insert', @usuario, @app, @host, null, @rNuevo)
		select * from Auditorias
	end
	-- si es update
	if exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'empresa', 'Update', @usuario, @app, @host, @rAnterior, @rNuevo)
		select * from Auditorias
	end
	-- si es delete
	if not exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'empresa', 'Delete', @usuario, @app, @host, @rAnterior, null)
		select * from Auditorias
	end
end

---Auditando la tabla generoroductos

create trigger tr_auditorias_generoroducto
on generoroducto
after insert, update, delete
as
begin
	-- declarar varibles para los datos de la tabla
	declare @rNuevo varchar(max), @rAnterior varchar(max)
	declare @usuario varchar(50), @app varchar(20), @host varchar(20)

	-- agregar informacion a las variables
	select @rNuevo = (select * from inserted for json auto)
	select @rAnterior = (select * from deleted for json auto)
	set @usuario = system_user
	set @app = app_name()
	set @host = host_name()
	
	-- si es insert
	if exists (select * from inserted) and not exists (select * from deleted)
	begin
		
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'generoroducto', 'Insert', @usuario, @app, @host, null, @rNuevo)
		select * from Auditorias
	end
	-- si es update
	if exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'generoroducto', 'Update', @usuario, @app, @host, @rAnterior, @rNuevo)
		select * from Auditorias
	end
	-- si es delete
	if not exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'generoroducto', 'Delete', @usuario, @app, @host, @rAnterior, null)
		select * from Auditorias
	end
end

---Auditando la tabla metodopagoVentas


create trigger tr_auditorias_metodopagoVentas
on metodopagoVentas
after insert, update, delete
as
begin
	-- declarar varibles para los datos de la tabla
	declare @rNuevo varchar(max), @rAnterior varchar(max)
	declare @usuario varchar(50), @app varchar(20), @host varchar(20)

	-- agregar informacion a las variables
	select @rNuevo = (select * from inserted for json auto)
	select @rAnterior = (select * from deleted for json auto)
	set @usuario = system_user
	set @app = app_name()
	set @host = host_name()
	
	-- si es insert
	if exists (select * from inserted) and not exists (select * from deleted)
	begin
		
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'metodopagoVentas', 'Insert', @usuario, @app, @host, null, @rNuevo)
		select * from Auditorias
	end
	-- si es update
	if exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'metodopagoVentas', 'Update', @usuario, @app, @host, @rAnterior, @rNuevo)
		select * from Auditorias
	end
	-- si es delete
	if not exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'metodopagoVentas', 'Delete', @usuario, @app, @host, @rAnterior, null)
		select * from Auditorias
	end
end

---Auditando la tabla productos

create trigger tr_auditorias_productos
on productos
after insert, update, delete
as
begin
	-- declarar varibles para los datos de la tabla
	declare @rNuevo varchar(max), @rAnterior varchar(max)
	declare @usuario varchar(50), @app varchar(20), @host varchar(20)

	-- agregar informacion a las variables
	select @rNuevo = (select * from inserted for json auto)
	select @rAnterior = (select * from deleted for json auto)
	set @usuario = system_user
	set @app = app_name()
	set @host = host_name()
	
	-- si es insert
	if exists (select * from inserted) and not exists (select * from deleted)
	begin
		
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'productos', 'Insert', @usuario, @app, @host, null, @rNuevo)
		select * from Auditorias
	end
	-- si es update
	if exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'productos', 'Update', @usuario, @app, @host, @rAnterior, @rNuevo)
		select * from Auditorias
	end
	-- si es delete
	if not exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'productos', 'Delete', @usuario, @app, @host, @rAnterior, null)
		select * from Auditorias
	end
end

---Auditando la tabla proveedores

create trigger tr_auditorias_proveedores
on proveedores
after insert, update, delete
as
begin
	-- declarar varibles para los datos de la tabla
	declare @rNuevo varchar(max), @rAnterior varchar(max)
	declare @usuario varchar(50), @app varchar(20), @host varchar(20)

	-- agregar informacion a las variables
	select @rNuevo = (select * from inserted for json auto)
	select @rAnterior = (select * from deleted for json auto)
	set @usuario = system_user
	set @app = app_name()
	set @host = host_name()
	
	-- si es insert
	if exists (select * from inserted) and not exists (select * from deleted)
	begin
		
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'proveedores', 'Insert', @usuario, @app, @host, null, @rNuevo)
		select * from Auditorias
	end
	-- si es update
	if exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'proveedores', 'Update', @usuario, @app, @host, @rAnterior, @rNuevo)
		select * from Auditorias
	end
	-- si es delete
	if not exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'proveedores', 'Delete', @usuario, @app, @host, @rAnterior, null)
		select * from Auditorias
	end
end

---Auditando la tabla puesto

create trigger tr_auditorias_puesto
on puesto
after insert, update, delete
as
begin
	-- declarar varibles para los datos de la tabla
	declare @rNuevo varchar(max), @rAnterior varchar(max)
	declare @usuario varchar(50), @app varchar(20), @host varchar(20)

	-- agregar informacion a las variables
	select @rNuevo = (select * from inserted for json auto)
	select @rAnterior = (select * from deleted for json auto)
	set @usuario = system_user
	set @app = app_name()
	set @host = host_name()
	
	-- si es insert
	if exists (select * from inserted) and not exists (select * from deleted)
	begin
		
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'puesto', 'Insert', @usuario, @app, @host, null, @rNuevo)
		select * from Auditorias
	end
	-- si es update
	if exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'puesto', 'Update', @usuario, @app, @host, @rAnterior, @rNuevo)
		select * from Auditorias
	end
	-- si es delete
	if not exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'puesto', 'Delete', @usuario, @app, @host, @rAnterior, null)
		select * from Auditorias
	end
end

---Auditando la tabla tallaProductos

create trigger tr_auditorias_tallaProducto
on tallaProducto
after insert, update, delete
as
begin
	-- declarar varibles para los datos de la tabla
	declare @rNuevo varchar(max), @rAnterior varchar(max)
	declare @usuario varchar(50), @app varchar(20), @host varchar(20)

	-- agregar informacion a las variables
	select @rNuevo = (select * from inserted for json auto)
	select @rAnterior = (select * from deleted for json auto)
	set @usuario = system_user
	set @app = app_name()
	set @host = host_name()
	
	-- si es insert
	if exists (select * from inserted) and not exists (select * from deleted)
	begin
		
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'tallaProducto', 'Insert', @usuario, @app, @host, null, @rNuevo)
		select * from Auditorias
	end
	-- si es update
	if exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'tallaProducto', 'Update', @usuario, @app, @host, @rAnterior, @rNuevo)
		select * from Auditorias
	end
	-- si es delete
	if not exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'tallaProducto', 'Delete', @usuario, @app, @host, @rAnterior, null)
		select * from Auditorias
	end
end

---Auditando la tabla tipoProductos


create trigger tr_auditorias_tipoProducto
on tipoProducto
after insert, update, delete
as
begin
	-- declarar varibles para los datos de la tabla
	declare @rNuevo varchar(max), @rAnterior varchar(max)
	declare @usuario varchar(50), @app varchar(20), @host varchar(20)

	-- agregar informacion a las variables
	select @rNuevo = (select * from inserted for json auto)
	select @rAnterior = (select * from deleted for json auto)
	set @usuario = system_user
	set @app = app_name()
	set @host = host_name()
	
	-- si es insert
	if exists (select * from inserted) and not exists (select * from deleted)
	begin
		
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'tipoProducto', 'Insert', @usuario, @app, @host, null, @rNuevo)
		select * from Auditorias
	end
	-- si es update
	if exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'tipoProducto', 'Update', @usuario, @app, @host, @rAnterior, @rNuevo)
		select * from Auditorias
	end
	-- si es delete
	if not exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'tipoProducto', 'Delete', @usuario, @app, @host, @rAnterior, null)
		select * from Auditorias
	end
end

---Auditando la tabla usuario


create trigger tr_auditorias_usuario
on usuario
after insert, update, delete
as
begin
	-- declarar varibles para los datos de la tabla
	declare @rNuevo varchar(max), @rAnterior varchar(max)
	declare @usuario varchar(50), @app varchar(20), @host varchar(20)

	-- agregar informacion a las variables
	select @rNuevo = (select * from inserted for json auto)
	select @rAnterior = (select * from deleted for json auto)
	set @usuario = system_user
	set @app = app_name()
	set @host = host_name()
	
	-- si es insert
	if exists (select * from inserted) and not exists (select * from deleted)
	begin
		
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'usuario', 'Insert', @usuario, @app, @host, null, @rNuevo)
		select * from Auditorias
	end
	-- si es update
	if exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'usuario', 'Update', @usuario, @app, @host, @rAnterior, @rNuevo)
		select * from Auditorias
	end
	-- si es delete
	if not exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'usuario', 'Delete', @usuario, @app, @host, @rAnterior, null)
		select * from Auditorias
	end
end

---Auditando la tabla ventas

create trigger tr_auditorias_ventas
on ventas
after insert, update, delete
as
begin
	-- declarar varibles para los datos de la tabla
	declare @rNuevo varchar(max), @rAnterior varchar(max)
	declare @usuario varchar(50), @app varchar(20), @host varchar(20)

	-- agregar informacion a las variables
	select @rNuevo = (select * from inserted for json auto)
	select @rAnterior = (select * from deleted for json auto)
	set @usuario = system_user
	set @app = app_name()
	set @host = host_name()
	
	-- si es insert
	if exists (select * from inserted) and not exists (select * from deleted)
	begin
		
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'ventas', 'Insert', @usuario, @app, @host, null, @rNuevo)
		select * from Auditorias
	end
	-- si es update
	if exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'ventas', 'Update', @usuario, @app, @host, @rAnterior, @rNuevo)
		select * from Auditorias
	end
	-- si es delete
	if not exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'ventas', 'Delete', @usuario, @app, @host, @rAnterior, null)
		select * from Auditorias
	end
end

---Auditando la tabla ventas_detalle

create trigger tr_auditorias_ventas_detalle
on ventas_detalle
after insert, update, delete
as
begin
	-- declarar varibles para los datos de la tabla
	declare @rNuevo varchar(max), @rAnterior varchar(max)
	declare @usuario varchar(50), @app varchar(20), @host varchar(20)

	-- agregar informacion a las variables
	select @rNuevo = (select * from inserted for json auto)
	select @rAnterior = (select * from deleted for json auto)
	set @usuario = system_user
	set @app = app_name()
	set @host = host_name()
	
	-- si es insert
	if exists (select * from inserted) and not exists (select * from deleted)
	begin
		
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'ventas_detalle', 'Insert', @usuario, @app, @host, null, @rNuevo)
		select * from Auditorias
	end
	-- si es update
	if exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'ventas_detalle', 'Update', @usuario, @app, @host, @rAnterior, @rNuevo)
		select * from Auditorias
	end
	-- si es delete
	if not exists (select * from inserted) and exists (select * from deleted)
	begin
		insert into Auditorias (fechaHora, tabla, movimiento, usuario, app, host, RegistroAnterior, RegistroNuevo)
		values (GETDATE(), 'ventas_detalle', 'Delete', @usuario, @app, @host, @rAnterior, null)
		select * from Auditorias
	end
end

----PRUEBA DE LAS AUDITORIAS_TRIGGERS

-- Insertar datos en clientes
INSERT INTO clientes (Nombre, correo, telefono) 
VALUES ('everardo', 'juan.perez@example.com', '1234567898');

-- Actualizar datos en clientes
UPDATE clientes 
SET Telefono = '1234567892' 
WHERE Nombre = 'everardo';

-- Eliminar datos en clientes
DELETE FROM clientes 
WHERE Nombre = 'everardo';

select * from clientes
select * from empleado
select * from usuario
insert into empleado values ('Ever', 'Lopez', getdate(), 'VGF', '6677753051', '220120061@upve.edu.mx', 'LOIE040225HU3')
insert into usuario (idUsuario, contraseña, idEmpleado) values (0, 'admin', 1)