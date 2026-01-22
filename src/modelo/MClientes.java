package modelo;

import java.util.Date;

public class MClientes {
	private int idCliente;
	private String nombre;
	private String apellido;
	private String telefono;
	private String correo;
	private String direccion;
	private Date fechaRegistro;
	private int numCompras;
	
	 // Constructor con parámetros
    public MClientes(String nombre, String apellido, String telefono, String correo, String direccion, Date fechaRegistro, int numCompras) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.fechaRegistro = fechaRegistro;
        this.numCompras = numCompras;
    }
    public MClientes(int idCliente, String nombre, String apellido, String telefono, String correo, String direccion, Date fechaRegistro, int numCompras) {
    	this.idCliente = idCliente;
    	this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.fechaRegistro = fechaRegistro;
        this.numCompras = numCompras;
    }
    public MClientes(int idCliente, String nombre, String apellido, String telefono, String correo, String direccion, Date fechaRegistro) {
    	this.idCliente = idCliente;
    	this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.fechaRegistro = fechaRegistro;
    }
    public MClientes(String nombre, String apellido, String telefono, String correo, String direccion) {
    	this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }
    
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public int getNumCompras() {
		return numCompras;
	}
	public void setNumCompras(int numCompras) {
		this.numCompras = numCompras;
	}

	
}
