package modelo;

public class MProveedores {
	private int idProveedor;
	private String nombre;
	private String apellido;
	private String telefono;
	private String correo;
	private String direccion;
	private int idEmpresa;
	
	// Constructor
	public MProveedores (int idProveedor, String nombre, String apellido, String telefono, String correo, String direccion, int idEmpresa) {
		this.idProveedor = idProveedor;
		this.nombre = nombre;
		this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.idEmpresa = idEmpresa;
	}
	public MProveedores (String nombre, String apellido, String telefono, String correo, String direccion, int idEmpresa) {
		this.nombre = nombre;
		this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.idEmpresa = idEmpresa;
	}
	public MProveedores ( String nombre, String apellido, String telefono, String correo, int idEmpresa) {
		this.nombre = nombre;
		this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.idEmpresa = idEmpresa;
	}
	public MProveedores ( String nombre, String apellido, String telefono, String correo) {
		this.nombre = nombre;
		this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
	}
	public MProveedores ( String nombre, String telefono, String correo) {
		this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
	}
	
	public int getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
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
	public int getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
	
}
