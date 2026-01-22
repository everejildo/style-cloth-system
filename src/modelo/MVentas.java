package modelo;

import java.util.Date;

public class MVentas {
	private int idVenta;
	private Date fecha;
	private int idCliente;
	private int total;
	private String metodoPago;
	private int idEmple;
	
	// Constructor
	public MVentas (int idVenta, Date fecha, int idCliente, int total, String metodoPago, int idEmple) {
		this.idVenta = idVenta;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.total = total;
        this.metodoPago = metodoPago;
        this.idEmple = idEmple;
	}
	public MVentas (int idVenta, Date fecha, int idCliente, String metodoPago, int idEmple) {
		this.idVenta = idVenta;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.metodoPago = metodoPago;
        this.idEmple = idEmple;
	}
	public MVentas (int idVenta, int idCliente, int total, String metodoPago, int idEmple) {
		this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.total = total;
        this.metodoPago = metodoPago;
        this.idEmple = idEmple;
	}
	public MVentas (int idVenta, int idCliente, String metodoPago, int idEmple) {
		this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.metodoPago = metodoPago;
        this.idEmple = idEmple;
	}
	public MVentas (Date fecha, int idEmple, String metodoPago, int idCliente, int total) {
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.metodoPago = metodoPago;
        this.total = total;
        this.idEmple = idEmple;
	}
	public MVentas (Date fecha, int idEmple, String metodoPago, int idCliente) {
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.metodoPago = metodoPago;
        this.idEmple = idEmple;
	}
	
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	public int getIdEmple() {
		return idEmple;
	}
	public void setIdEmple(int idEmple) {
		this.idEmple = idEmple;
	}
	
	
}
