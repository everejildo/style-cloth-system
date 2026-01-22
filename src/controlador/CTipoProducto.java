package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexion.ConexionBDSQLServer;
import modelo.MTipoProductos;

public class CTipoProducto {
	public static Connection Conexion = null;
	public static String sql;
	public static ResultSet ResultSet = null;
	public static PreparedStatement sentencia;
	
	public void anadirTipo(MTipoProductos tipo) {
		sentencia = null;
		Conexion = ConexionBDSQLServer.GetConexion();

		sql = "INSERT INTO tipoProducto (tipo) VALUES (?)";

		try {
			sentencia = Conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			sentencia.setString(1, tipo.getTipo());

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
			JOptionPane.showMessageDialog(null, "Error al añadir el tipo", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void eliminarTipo(int idtipoProductos) {
		PreparedStatement sentencia = null;// Variable PreparedStatement
		// Se genear una variables que optiene la conexion a la base de Datos
		Conexion = ConexionBDSQLServer.GetConexion();

		sql = "DELETE FROM tipoProducto WHERE idtipoProd = ?";

		try {
			sentencia = Conexion.prepareStatement(sql);
			sentencia.setInt(1, idtipoProductos);

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
			JOptionPane.showMessageDialog(null, "Error al eliminar el tipo", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void actualizarTipo(String tipo, int idtipoProductos) {
		// validar que tenga algo
		if (tipo.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Este campo es obligatorio", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		PreparedStatement sentencia = null;
		Connection Conexion = null;

		sql = "UPDATE tipoProducto SET tipo = ? WHERE idtipoProd = ?";

		try {
			Conexion = ConexionBDSQLServer.GetConexion();
			sentencia = Conexion.prepareStatement(sql);
			sentencia.setString(1, tipo);
			sentencia.setInt(2, idtipoProductos);

			int filasAfectadas = sentencia.executeUpdate();

			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Información actualizada con éxito.", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Campos no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Error de SQL: " + e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al actualizar el tipo.", "Error", JOptionPane.ERROR_MESSAGE);
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
	
	public List<MTipoProductos> obtenerTipo() {
		List<MTipoProductos> listaTipos = new ArrayList<>();
		Connection conexion = ConexionBDSQLServer.GetConexion();
		String sql = "SELECT * FROM tipoProducto";
		
		try (PreparedStatement PS = conexion.prepareStatement(sql); ResultSet RS = PS.executeQuery()) {
			while (RS.next()) {
				// Extraer datos de cada fila
				int idtipoProductos = RS.getInt("idtipoProd");
				String tipo = RS.getString("tipo");
				
				// Crear objeto MClientes y añadirlo a la lista
				MTipoProductos tipos = new MTipoProductos(idtipoProductos, tipo);
				listaTipos.add(tipos);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaTipos;
	}
}
