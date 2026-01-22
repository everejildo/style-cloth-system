package modelo;

public class MTallaProducto {
	private int idtallaProductos;
	private String talla;
	
	// Constructor
	public MTallaProducto (int idtallaProductos, String talla){
		this.idtallaProductos = idtallaProductos;
		this.talla = talla;
	}
	public MTallaProducto (String talla) {
		this.talla = talla;
	}
	
	
	public int getIdtallaProductos() {
		return idtallaProductos;
	}
	public void setIdtallaProductos(int idtallaProductos) {
		this.idtallaProductos = idtallaProductos;
	}
	public String getTalla() {
		return talla;
	}
	public void setTalla(String talla) {
		this.talla = talla;
	}
	
	
}
