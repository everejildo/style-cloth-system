package modelo;

public class MGeneroProducto {
	private int idgeneroroductos;
	private String genero;
	
	// Constructores
	public MGeneroProducto (int idgeneroroductos, String genero){
		this.idgeneroroductos = idgeneroroductos;
		this.genero = genero;
	}
	public MGeneroProducto (String genero) {
		this.genero = genero;
	}
	
	public int getIdgeneroproductos() {
		return idgeneroroductos;
	}
	public void setIdgeneroproductos(int idgeneroroductos) {
		this.idgeneroroductos = idgeneroroductos;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
}
