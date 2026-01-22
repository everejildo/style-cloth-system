package modelo;

public class Modelo_Cooperativa {
	 private String nombreCooperativa;
	    private int idPescador;
	    private int trabajadores;
	    private int idDistribuidor;
	    private int directivos;
	    private String productos;

	    // Constructor
	    public Modelo_Cooperativa(String nombreCooperativa, int idPescador, int trabajadores, int idDistribuidor, int directivos, String productos) {
	        this.nombreCooperativa = nombreCooperativa;
	        this.idPescador = idPescador;
	        this.trabajadores = trabajadores;
	        this.idDistribuidor = idDistribuidor;
	        this.directivos = directivos;
	        this.productos = productos;
	    }

	    // Getters and Setters
	    public String getNombreCooperativa() {
	        return nombreCooperativa;
	    }

	    public void setNombreCooperativa(String nombreCooperativa) {
	        this.nombreCooperativa = nombreCooperativa;
	    }

	    public int getIdPescador() {
	        return idPescador;
	    }

	    public void setIdPescador(int idPescador) {
	        this.idPescador = idPescador;
	    }

	    public int getTrabajadores() {
	        return trabajadores;
	    }

	    public void setTrabajadores(int trabajadores) {
	        this.trabajadores = trabajadores;
	    }

	    public int getIdDistribuidor() {
	        return idDistribuidor;
	    }

	    public void setIdDistribuidor(int idDistribuidor) {
	        this.idDistribuidor = idDistribuidor;
	    }

	    public int getDirectivos() {
	        return directivos;
	    }

	    public void setDirectivos(int directivos) {
	        this.directivos = directivos;
	    }

	    public String getProductos() {
	        return productos;
	    }

	    public void setProductos(String productos) {
	        this.productos = productos;
	    }
	}