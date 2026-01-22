package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexion.ConexionBDSQLServer;
import modelo.MmetodopagoVentas;

public class CmetodopagoVentas {
	public static Connection Conexion = null;
	public static String sql;
	public static ResultSet ResultSet = null;
	public static PreparedStatement sentencia;

	public void anadirMetodoPago(MmetodopagoVentas metodoPago) {
		// agg validacionde que no esta vacio
		sentencia = null;
		Conexion = ConexionBDSQLServer.GetConexion();

		sql = "INSERT INTO metodopagoVentas (metodoPago) VALUES (?)";

		try {
			sentencia = Conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			sentencia.setString(1, metodoPago.getMetodoPago());

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
			JOptionPane.showMessageDialog(null, "Error al añadir el método de pago", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void eliminarMetodoPago(int idmetodopagoVentas) {
		PreparedStatement sentencia = null;// Variable PreparedStatement
		// Se genear una variables que optiene la conexion a la base de Datos
		Conexion = ConexionBDSQLServer.GetConexion();

		sql = "DELETE FROM metodopagoVentas WHERE idMetPag0 = ?";

		try {
			sentencia = Conexion.prepareStatement(sql);
			sentencia.setInt(1, idmetodopagoVentas);

			int filasAfectadas = sentencia.executeUpdate();

			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Información Eliminada", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Información no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Error de SQL: " + e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al eliminar el método de pago", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actualizarMetodoPago(String metodoPago, int idmetodopagoVentas) {
		// validar que tenga algo
		if (metodoPago.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Este campo es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		PreparedStatement sentencia = null;
		Connection Conexion = null;

		sql = "UPDATE metodopagoVentas SET metodoPago = ? WHERE idMetPag0 = ?";

		try {
			Conexion = ConexionBDSQLServer.GetConexion();
			sentencia = Conexion.prepareStatement(sql);
			sentencia.setString(1, metodoPago);
			sentencia.setInt(2, idmetodopagoVentas);

			int filasAfectadas = sentencia.executeUpdate();

			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Información actualizada con éxito.", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Campo no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Error de SQL: " + e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			try {
				if (sentencia != null)
					sentencia.close();
				if (Conexion != null)
					Conexion.close();
			} catch (SQLException ex) {
				System.err.println("Error al cerrar recursos: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}

	public List<MmetodopagoVentas> obtenerMetodoPago() {
		List<MmetodopagoVentas> listaMetodoPago = new ArrayList<>();
		Connection conexion = ConexionBDSQLServer.GetConexion();
		String sql = "SELECT * FROM metodopagoVentas";

		try (PreparedStatement PS = conexion.prepareStatement(sql); ResultSet RS = PS.executeQuery()) {
			while (RS.next()) {
				// Extraer datos de cada fila
				int idmetodopagoVentas = RS.getInt("idMetPag0");
				String metodoPago = RS.getString("metodoPago");

				// Crear objeto MClientes y añadirlo a la lista
				MmetodopagoVentas metodosPago = new MmetodopagoVentas(idmetodopagoVentas, metodoPago);
				listaMetodoPago.add(metodosPago);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaMetodoPago;
	}
}
