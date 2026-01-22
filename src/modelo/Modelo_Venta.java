package modelo;
import java.util.Date;

public class Modelo_Venta {
    private int idVenta;
    private Date fecha;
    private int idPescador;
    private String idProducto;
    private int idDistribuidor;
    private double cantidad;
    private double precioTotal;
    private String cooperativa;
    
 // Constructor con parámetros
    public Modelo_Venta(int idVenta, String idProducto,double cantidad, double precioTotal, String cooperativa) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
        this.cooperativa = cooperativa;
    }
    public Modelo_Venta(int idVenta, double cantidad, double precioTotal, String cooperativa, String idProducto) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
        this.cooperativa = cooperativa;
    }

    public Modelo_Venta(String idProducto, double cantidad, String cooperativa, double precio) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioTotal = precio;
        this.cooperativa = cooperativa;
	}

	// Getters y Setters
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

    public int getIdPescador() {
        return idPescador;
    }

    public void setIdPescador(int idPescador) {
        this.idPescador = idPescador;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdDistribuidor() {
        return idDistribuidor;
    }

    public void setIdDistribuidor(int idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getCooperativa() {
        return cooperativa;
    }

    public void setCooperativa(String cooperativa) {
        this.cooperativa = cooperativa;
    }
}