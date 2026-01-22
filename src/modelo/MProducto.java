package modelo;

import java.math.BigDecimal;
import java.util.Date;

public class MProducto {
	private int idProducto;
	private String nombre;
	private String descripcion;
	private String tipo;
	private String talla;
	private BigDecimal precio;
	private Date fechaRegistro;
	private int stock;
	private String genero;
	//private int idProveedor;
	
	// Constructor
	public MProducto (String nombre, String descripcion, String tipo, String talla, BigDecimal precio, Date fechaRegistro, int stock, String genero, /*int idProveedor,*/ int idProducto) {
		this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.talla = talla;
        this.precio = precio;
        this.fechaRegistro = fechaRegistro;
        this.stock = stock;
        this.genero = genero;
        //this.idProveedor = idProveedor;
        this.idProducto = idProducto;
	}
	public MProducto (int idProducto, String nombre, String descripcion, String tipo, String talla, BigDecimal precio, Date fechaRegistro, int stock, String genero/*,  int idProveedor*/) {
		this.idProducto = idProducto;
		this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.talla = talla;
        this.precio = precio;
        this.fechaRegistro = fechaRegistro;
        this.stock = stock;
        this.genero = genero;
        //this.idProveedor = idProveedor;
	}
	public MProducto (String nombre, String descripcion, String tipo, String talla, BigDecimal precio, Date fechaRegistro, int stock, String genero/*, int idProveedor*/) {
		this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.talla = talla;
        this.precio = precio;
        this.fechaRegistro = fechaRegistro;
        this.stock = stock;
        this.genero = genero;
        //this.idProveedor = idProveedor;
	}
	public MProducto (int idProducto, String nombre, String descripcion, String tipo, String talla, BigDecimal precio, Date fechaRegistro, int stock) {
		this.idProducto = idProducto;
		this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.talla = talla;
        this.precio = precio;
        this.fechaRegistro = fechaRegistro;
        this.stock = stock;
	}
	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTalla() {
		return talla;
	}
	public void setTalla(String talla) {
		this.talla = talla;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	/*
	public int getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}*/
}