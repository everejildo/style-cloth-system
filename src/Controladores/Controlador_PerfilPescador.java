package Controladores;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.ConexionBDSQLServer2;
import modelo.Modelo_Prestamos;
import modelo.Modelo_Venta;

public class Controlador_PerfilPescador {
	public static Connection Conexion = null;
	public static String sql;
	public static ResultSet ResultSet = null;
	public static PreparedStatement sentencia;
	
	public static List<Modelo_Prestamos> tablaPrestamos() {
	    List<Modelo_Prestamos> listaPrestamos = new ArrayList<>();
	    try {
			Conexion = ConexionBDSQLServer2.GetConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String sql = "SELECT idprestamos, Coperativa, Gasolina, hielo, carnada, dinero FROM Prestamos";

	    try (PreparedStatement PS = Conexion.prepareStatement(sql); ResultSet RS = PS.executeQuery()) {
	        while (RS.next()) {
	            // Extraer datos de cada fila
	            int idprestamos = RS.getInt("idprestamos");
	            String Coperativa = RS.getString("Coperativa");
	            String Gasolina = RS.getString("Gasolina");
	            String hielo = RS.getString("hielo");
	            String carnada = RS.getString("carnada");
	            Double dinero = RS.getDouble("dinero");

	            // Crear objeto MClientes y añadirlo a la lista
	            Modelo_Prestamos prestamo = new Modelo_Prestamos(idprestamos, Coperativa, Gasolina, hielo, carnada, dinero);
	            listaPrestamos.add(prestamo);
	        }
	    } catch (SQLException e) {
	        System.err.println("Error fetching prestamos: " + e.getMessage());
	    }
	    return listaPrestamos;
	}
	
	public static List<Modelo_Venta> tablaVenta() {
	    List<Modelo_Venta> listaVentas = new ArrayList<>();
	    try {
			Conexion = ConexionBDSQLServer2.GetConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String sql = "select IDventa, Cantidad, PrecioTotal, Coperativa, IDproducto from Ventas";

	    try (PreparedStatement PS = Conexion.prepareStatement(sql); ResultSet RS = PS.executeQuery()) {
	        while (RS.next()) {
	            // Extraer datos de cada fila
	            int IDventa = RS.getInt("IDventa");
	            Double Cantidad = RS.getDouble("Cantidad");
	            Double PrecioTotal = RS.getDouble("PrecioTotal");
	            String Coperativa = RS.getString("Coperativa");
	            String IDproducto = RS.getString("IDproducto");

	            // Crear objeto MClientes y añadirlo a la lista
	            Modelo_Venta venta = new Modelo_Venta(IDventa, Cantidad, PrecioTotal, Coperativa, IDproducto);
	            listaVentas.add(venta);
	        }
	    } catch (SQLException e) {
	        System.err.println("Error fetching prestamos: " + e.getMessage());
	    }
	    return listaVentas;
	}
}
