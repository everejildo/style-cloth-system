package controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import conexion.ConexionBDSQLServer;
import modelo.MVentas;

public class CRegistroVentas {
	public static Connection Conexion = null;
	public static String sql;

	public void anadirVenta(MVentas venta) {
		PreparedStatement sentencia = null;// Variable PreparedStatement
		// Se genear una variables que optiene la conexion a la base de Datos
		Conexion = ConexionBDSQLServer.GetConexion();

		sql = "INSERT INTO ventas (fecha, idEmpleado, metodoPago, idCliente, total) VALUES (?, ?, ?, ?, ?)";

		try {
			sentencia = Conexion.prepareStatement(sql);
			sentencia.setDate(1, new Date(venta.getFecha().getTime()));
			sentencia.setInt(2, venta.getIdEmple());
			sentencia.setString(3, venta.getMetodoPago());
			sentencia.setInt(4, venta.getIdCliente());
			sentencia.setInt(5, venta.getTotal());

			// Ejecutar la inserción en SQL
			int filasAfectadas = sentencia.executeUpdate();

			// Verificar si la inserción fue exitosa
			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Información Guardada", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Error, verifica los datos ingresados", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			// Manejo de errores SQL
			System.err.println("Error de SQL: " + e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al añadir la venta", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actualizarVenta(int idVenta, int idCliente, String metodoPago, int idEmple) {
		PreparedStatement sentencia = null;
		Connection Conexion = null;

		//sql = "UPDATE ventas SET idEmpleado = ?, metodopago = ?, idCliente = ?, total = ? WHERE idVenta = ?";
		sql = "UPDATE ventas SET idEmpleado = ?, metodopago = ?, idCliente = ? WHERE idVenta = ?";
		
		try {
			Conexion = ConexionBDSQLServer.GetConexion();
			sentencia = Conexion.prepareStatement(sql);

			sentencia.setInt(1, idEmple);
			sentencia.setString(2, metodoPago);
			sentencia.setInt(3, idCliente);
			//sentencia.setInt(4, total);
			sentencia.setInt(4, idVenta);

			int filasAfectadas = sentencia.executeUpdate();

			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Información actualizada exitosamente.");
			} else {
				JOptionPane.showMessageDialog(null, "No se encontró la venta con el ID proporcionado.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al actualizar la venta: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			// Cerrar los recursos
			try {
				if (sentencia != null)
					sentencia.close();
				if (Conexion != null)
					Conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void eliminarVenta(int idVenta) {
		PreparedStatement sentencia = null;
		Conexion = ConexionBDSQLServer.GetConexion();

		sql = "DELETE FROM ventas WHERE idVenta = ?";

		try {
			sentencia = Conexion.prepareStatement(sql);
			sentencia.setInt(1, idVenta);

			int filasAfectadas = sentencia.executeUpdate();

			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Información Eliminada", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Venta no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Error de SQL: " + e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al eliminar la venta", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public List<MVentas> obtenerVentas() {
		List<MVentas> listaVentas = new ArrayList<>();
		Conexion = ConexionBDSQLServer.GetConexion();
		sql = "SELECT * FROM ventas";

		try (PreparedStatement PS = Conexion.prepareStatement(sql); ResultSet RS = PS.executeQuery()) {
			while (RS.next()) {
				// Extraer datos de cada fila
				int idVenta = RS.getInt("idVenta");
				Date fecha = RS.getDate("fecha");
				int idCliente = RS.getInt("idCliente");
				int total = RS.getInt("total");
				String metodoPago = RS.getString("metodoPago");
				int idEmple = RS.getInt("idEmpleado");

				// Crear objeto MClientes y añadirlo a la lista
				MVentas venta = new MVentas(idVenta, fecha, idCliente, total, metodoPago, idEmple);
				listaVentas.add(venta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaVentas;
	}

	public static DefaultComboBoxModel<String> cmbBxMetodoPago(){
		// Se inicializa un objeto de tipo DefaultComboBoxModel
				DefaultComboBoxModel<String> DatosJcombox = new DefaultComboBoxModel<String>();

				try {
					Statement conectar = ConexionBDSQLServer.GetConexion().createStatement();
					ResultSet rs = conectar.executeQuery("SELECT * FROM metodopagoVentas");

					// Se ingresa un dato blanco en el primer campo del Combox
					DatosJcombox.addElement("Seleccione una opción");
					while (rs.next()) {
						// se llena con todos los elementos devueltos de la tabal de Combox
						DatosJcombox.addElement(rs.getString("metodoPago"));
					}
					rs.close();
					conectar.close();

				} catch (SQLException e) {
					System.err.println(e.getMessage());
					JOptionPane.showMessageDialog(null, "Error al consultar Profesiones", "Error", JOptionPane.ERROR_MESSAGE);
					DatosJcombox = null;
				}

				return DatosJcombox;

	}
}
