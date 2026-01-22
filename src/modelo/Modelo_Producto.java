package modelo;

public class Modelo_Producto {
    private String tipo;
    private String color;
    private double precio;
    private int idPescador;
    private int idDistribuidor;
    private double peso;
    private String nombreCooperativa;
    private double cantidadKg;

    // Constructor vacío
    public Modelo_Producto() {
    }

    // Constructor con parámetros
    public Modelo_Producto(String tipo, String color, double precio, int idPescador, int idDistribuidor, double peso, String nombreCooperativa, double cantidadKg) {
        this.tipo = tipo;
        this.color = color;
        this.precio = precio;
        this.idPescador = idPescador;
        this.idDistribuidor = idDistribuidor;
        this.peso = peso;
        this.nombreCooperativa = nombreCooperativa;
        this.cantidadKg = cantidadKg;
    }

    // Getters y Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdPescador() {
        return idPescador;
    }

    public void setIdPescador(int idPescador) {
        this.idPescador = idPescador;
    }

    public int getIdDistribuidor() {
        return idDistribuidor;
    }

    public void setIdDistribuidor(int idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getNombreCooperativa() {
        return nombreCooperativa;
    }

    public void setNombreCooperativa(String nombreCooperativa) {
        this.nombreCooperativa = nombreCooperativa;
    }

    public double getCantidadKg() {
        return cantidadKg;
    }

    public void setCantidadKg(double cantidadKg) {
        this.cantidadKg = cantidadKg;
    }
}