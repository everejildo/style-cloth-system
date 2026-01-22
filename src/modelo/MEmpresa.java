package modelo;

public class MEmpresa {
	private int idEmpresa;
	private String nombreE;
	private String telefonoE;
	private String correoE;
	
	// Constructor
	public MEmpresa (int idEmpresa, String nombre, String telefono, String correo) {
		this.idEmpresa = idEmpresa;
		this.nombreE = nombre;
        this.telefonoE = telefono;
        this.correoE = correo;
	}
	public MEmpresa (String nombre, String telefono, String correo) {
		this.nombreE = nombre;
        this.telefonoE = telefono;
        this.correoE = correo;
	}
	public MEmpresa (int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
	public int getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getNombre() {
		return nombreE;
	}
	public void setNombre(String nombre) {
		this.nombreE = nombre;
	}
	public String getTelefono() {
		return telefonoE;
	}
	public void setTelefono(String telefono) {
		this.telefonoE = telefono;
	}
	public String getCorreo() {
		return correoE;
	}
	public void setCorreo(String correo) {
		this.correoE = correo;
	}
	
	
}
