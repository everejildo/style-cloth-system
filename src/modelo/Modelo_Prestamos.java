package modelo;

public class Modelo_Prestamos {
	private int idprestamos;
    private String gasolina;
    private String hielo;
    private String carnada;
    private double dinero;
    private String cooperativa;
    private int IDpescador;

    // Constructor
    public Modelo_Prestamos(int idprestamos, String gasolina, String hielo, String carnada, double dinero, String cooperativa, int IDpescador) {
        this.gasolina = gasolina;
        this.hielo = hielo;
        this.carnada = carnada;
        this.dinero = dinero;
        this.cooperativa = cooperativa;
        this.IDpescador = IDpescador;
    }
    public Modelo_Prestamos(int idprestamos, String cooperativa,String gasolina, String hielo, String carnada, double dinero) {
        this.idprestamos = idprestamos;
    	this.gasolina = gasolina;
        this.hielo = hielo;
        this.carnada = carnada;
        this.dinero = dinero;
        this.cooperativa = cooperativa;
    }
  
    public Modelo_Prestamos( String hielo, String gasolina, String carnada, String cooperativa, double dinero) {
    	
    	this.gasolina = gasolina;
        this.hielo = hielo;
        this.carnada = carnada;
        this.dinero = dinero;
        this.cooperativa = cooperativa;
	}

	// Getters y Setters
    public String getGasolina() {
        return gasolina;
    }

    public void setGasolina(String gasolina) {
        this.gasolina = gasolina;
    }

    public String getHielo() {
        return hielo;
    }

    public void setHielo(String hielo) {
        this.hielo = hielo;
    }

    public String getCarnada() {
        return carnada;
    }

    public void setCarnada(String carnada) {
        this.carnada = carnada;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public String getCooperativa() {
        return cooperativa;
    }

    public void setCooperativa(String cooperativa) {
        this.cooperativa = cooperativa;
    }

    public int getIDpescador() {
        return IDpescador;
    }

    public void setIDpescador(int IDpescador) {
        this.IDpescador = IDpescador;
    }
    
    public void setidprestamos(int idprestamos) {
        this.setIdprestamos(idprestamos);
    }

	public int getIdprestamos() {
		return idprestamos;
	}

	public void setIdprestamos(int idprestamos) {
		this.idprestamos = idprestamos;
	}
}