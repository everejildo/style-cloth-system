package modelo;

public class Modelo_Pescador {
	private int IDpescador;
	private String Nombre;
	private String Apellido_Paterno;
	private String Apellido_Materno;
	private String Matricula;
	private String Cooperativa;
	private String Contraseña;
	
	public Modelo_Pescador (int IDpescador, String Nombre, String Apellido_Paterno, String Apellido_Materno, String Matricula, String Cooperativa, String Contraseña) {
		this.IDpescador = IDpescador;
		this.Nombre = Nombre;
		this.Apellido_Paterno = Apellido_Paterno;
		this.Apellido_Materno = Apellido_Materno;
		this.Matricula = Matricula;
		this.Cooperativa = Cooperativa;
		this.Contraseña = Contraseña;
	}
	public Modelo_Pescador (int IDpescador, String Nombre, String Apellido_Paterno, String Apellido_Materno, String Matricula, String Cooperativa) {
		this.IDpescador = IDpescador;
		this.Nombre = Nombre;
		this.Apellido_Paterno = Apellido_Paterno;
		this.Apellido_Materno = Apellido_Materno;
		this.Matricula = Matricula;
		this.Cooperativa = Cooperativa;
	}
	public Modelo_Pescador (String Nombre, String Apellido_Paterno, String Apellido_Materno, String Matricula, String Cooperativa, String Contraseña) {
		this.Nombre = Nombre;
		this.Apellido_Paterno = Apellido_Paterno;
		this.Apellido_Materno = Apellido_Materno;
		this.Matricula = Matricula;
		this.Cooperativa = Cooperativa;
		this.Contraseña = Contraseña;
	}
	
	public Modelo_Pescador ( String Matricula, String Contraseña) {
	
		
		this.Matricula = Matricula;
	
		this.Contraseña = Contraseña;
	}
	
	public int getIDpescador() {
		return IDpescador;
	}
	public void setIDpescador(int iDpescador) {
		IDpescador = iDpescador;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido_Paterno() {
		return Apellido_Paterno;
	}
	public void setApellido_Paterno(String apellido_Paterno) {
		Apellido_Paterno = apellido_Paterno;
	}
	public String getApellido_Materno() {
		return Apellido_Materno;
	}
	public void setApellido_Materno(String apellido_Materno) {
		Apellido_Materno = apellido_Materno;
	}
	public String getMatricula() {
		return Matricula;
	}
	public void setMatricula(String matricula) {
		Matricula = matricula;
	}
	public String getContraseña() {
		return Contraseña;
	}
	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}
	
	public String getCooperativa() {
		return Cooperativa;
	}

	public void setCooperativa(String cooperativa) {
		Cooperativa = cooperativa;
	}
}