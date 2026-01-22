package modelo;

public class MVentasDetalle {
	private int idVenta;
	private int idProducto;
	private int cantidad;
	private int precio;
	
	// Contructor
	public MVentasDetalle (int idVenta, int idProducto, int cantidad, int precio) {
		this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precio = precio;
	}
	public MVentasDetalle (int idVenta, int idProducto, int cantidad) {
		this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
	}
	
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
}
