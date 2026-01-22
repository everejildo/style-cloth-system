package modelo;

public class Modelo_VentaDetalle {


    private String tipo;
    private int idVenta;
    private double cantidad;
    private double precioUnitario;
    private double descuento;
    private double impuesto;

    // Constructor vacío
    public Modelo_VentaDetalle() {
    }

    // Constructor con parámetros
    public Modelo_VentaDetalle(String tipo, int idVenta, double cantidad, double precioUnitario, double descuento, double impuesto) {
        this.tipo = tipo;
        this.idVenta = idVenta;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.descuento = descuento;
        this.impuesto = impuesto;
    }

    // Getters y Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }
}