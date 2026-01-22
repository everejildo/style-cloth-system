package modelo;

public class MTipoProductos {
	private int idtipoProductos;
	private String tipo;
	
	// Constructores
	public MTipoProductos (int idtipoProductos, String tipo){
		this.idtipoProductos = idtipoProductos;
		this.tipo = tipo;
	}
	public MTipoProductos (String tipo) {
		this.tipo = tipo;
	}
	
	public int getIdtipoProductos() {
		return idtipoProductos;
	}
	public void setIdtipoProductos(int idtipoProductos) {
		this.idtipoProductos = idtipoProductos;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
