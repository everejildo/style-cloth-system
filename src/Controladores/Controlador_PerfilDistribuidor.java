package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Cooperativa.PerfilDistribuidor;
import conexion.ConexionBDSQLServer2;
import modelo.Modelo_Venta;

public class Controlador_PerfilDistribuidor {
    private PerfilDistribuidor vista;
    public static Connection Conexion = null;
    public static String sql;
    public static ResultSet ResultSet = null;
    public static PreparedStatement sentencia;

       

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
	            Modelo_Venta ProveedorVenta = new Modelo_Venta(IDventa, Cantidad, PrecioTotal, Coperativa, IDproducto);
	            listaVentas.add(ProveedorVenta);
	        }
	    } catch (SQLException e) {
	        System.err.println("Error fetching prestamos: " + e.getMessage());
	    }
	    return listaVentas;
	}



    public class CerrarSesionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lógica para cerrar sesión
            int respuesta = JOptionPane.showConfirmDialog(vista, "¿Seguro que quieres cerrar sesión?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                // Redirigir a la pantalla de login o salir de la aplicación
                vista.dispose();
                // Implementar lógica de redirección
            }
        }
    }

    public class VenderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lógica para realizar venta
            JOptionPane.showMessageDialog(vista, "Iniciando el proceso de venta...", "Venta", JOptionPane.INFORMATION_MESSAGE);
            // Redirigir a la ventana de ventas
        }
    }
}
