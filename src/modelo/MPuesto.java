package modelo;

import java.math.BigDecimal;

public class MPuesto {
	private int idPuesto;
	private String nombre;
	private BigDecimal sueldo;
	private String departamento;
	private String turno;
	
	// Constructores
	public MPuesto (int idPuesto, String nombre, BigDecimal sueldo, String departamento, String turno) {
		this.idPuesto = idPuesto;
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.departamento = departamento;
		this.turno = turno;
	}
	public MPuesto (String nombre, BigDecimal sueldo, String departamento, String turno) {
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.departamento = departamento;
		this.turno = turno;
	}
	public MPuesto (String nombre, BigDecimal sueldo, String departamento, String turno, int idPuesto) {
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.departamento = departamento;
		this.turno = turno;
		this.idPuesto = idPuesto;
	}
	
	public int getIdPuesto() {
		return idPuesto;
	}
	public void setIdPuesto(int idPuesto) {
		this.idPuesto = idPuesto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getSueldo() {
		return sueldo;
	}
	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	
}
