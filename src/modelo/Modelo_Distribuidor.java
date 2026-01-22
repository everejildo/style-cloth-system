package modelo;

public class Modelo_Distribuidor {
    private int IDdistribuidor;
    private String Nombre;
    private String Apelldio_P;
    private String Apellido_M;
    private String Matricula;
    private String Contraseña;
    private String Telefono;
    private String Direccion;
    private String Coperativa;

    // Constructor con todos los campos
    public Modelo_Distribuidor(int IDdistribuidor, String Nombre, String Apelldio_P, String Apellido_M, 
                               String Matricula, String Contraseña, String Telefono, String Direccion, String Coperativa) {
        this.IDdistribuidor = IDdistribuidor;
        this.Nombre = Nombre;
        this.Apelldio_P = Apelldio_P;
        this.Apellido_M = Apellido_M;
        this.Matricula = Matricula;
        this.Contraseña = Contraseña;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.Coperativa = Coperativa;
    }

    // Constructor sin ID (para crear nuevos registros)
    public Modelo_Distribuidor(String Nombre, String Apelldio_P, String Apellido_M, String Matricula, String Contraseña, String Telefono, String Direccion, String Coperativa) {
        this.Nombre = Nombre;
        this.Apelldio_P = Apelldio_P;
        this.Apellido_M = Apellido_M;
        this.Matricula = Matricula;
        this.Contraseña = Contraseña;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.Coperativa = Coperativa;
    }
    public Modelo_Distribuidor(String Nombre, String Apelldio_P, String Apellido_M, String Matricula, String Telefono, String Direccion, String Coperativa) {
        this.Nombre = Nombre;
        this.Apelldio_P = Apelldio_P;
        this.Apellido_M = Apellido_M;
        this.Matricula = Matricula;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.Coperativa = Coperativa;
    }
    
    public Modelo_Distribuidor(String Matricula, String Contraseña) {
        this.Matricula = Matricula;
        this.Contraseña = Contraseña;
    }

    // Getters y Setters para cada campo
    public int getIDdistribuidor() {
        return IDdistribuidor;
    }

    public void setIDdistribuidor(int IDdistribuidor) {
        this.IDdistribuidor = IDdistribuidor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido_Paterno() {
        return Apelldio_P;
    }

    public void setApellido_Paterno(String Apellido_Paterno) {
        this.Apelldio_P = Apellido_Paterno;
    }

    public String getApellido_Materno() {
        return Apellido_M;
    }

    public void setApellido_Materno(String Apellido_Materno) {
        this.Apellido_M = Apellido_Materno;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCooperativa() {
        return Coperativa;
    }

    public void setCooperativa(String Cooperativa) {
        this.Coperativa = Cooperativa;
    }
}
