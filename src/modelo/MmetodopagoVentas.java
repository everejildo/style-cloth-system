package modelo;

public class MmetodopagoVentas {
	private int idmetodopagoVentas;
	private String metodoPago;
	
	// Constructores
	public MmetodopagoVentas (int idmetodopagoVentas, String metodoPago){
		this.idmetodopagoVentas = idmetodopagoVentas;
		this.metodoPago = metodoPago;
	}
	public MmetodopagoVentas (String metodoPago) {
		this.metodoPago = metodoPago;
	}
	
	
	public int getIdmetodopagoVentas() {
		return idmetodopagoVentas;
	}
	public void setIdmetodopagoVentas(int idmetodopagoVentas) {
		this.idmetodopagoVentas = idmetodopagoVentas;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	
	
}
