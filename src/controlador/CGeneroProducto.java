package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexion.ConexionBDSQLServer;
import modelo.MGeneroProducto;

public class CGeneroProducto {
	public static Connection Conexion = null;
	public static String sql;
	public static ResultSet ResultSet = null;
	public static PreparedStatement sentencia;

	public void anadirGenero(MGeneroProducto genero) {
		// agg validacionde que no esta vacio
		sentencia = null;
		Conexion = ConexionBDSQLServer.GetConexion();

		sql = "INSERT INTO generoroducto (genero) VALUES (?)";

		try {
			sentencia = Conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			sentencia.setString(1, genero.getGenero());

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
			JOptionPane.showMessageDialog(null, "Error al añadir el género", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void eliminarGenero(int idgeneroroductos) {
		PreparedStatement sentencia = null;// Variable PreparedStatement
		// Se genear una variables que optiene la conexion a la base de Datos
		Conexion = ConexionBDSQLServer.GetConexion();

		sql = "DELETE FROM generoroducto WHERE idGenProd = ?";

		try {
			sentencia = Conexion.prepareStatement(sql);
			sentencia.setInt(1, idgeneroroductos);

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
			JOptionPane.showMessageDialog(null, "Error al eliminar el género", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actualizarGenero(String genero, int idgeneroroductos) {
		// validar que tenga algo
		if (genero.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Este campo es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		PreparedStatement sentencia = null;
		Connection Conexion = null;

		sql = "UPDATE generoroducto SET genero = ? WHERE idGenProd = ?";

		try {
			Conexion = ConexionBDSQLServer.GetConexion();
			sentencia = Conexion.prepareStatement(sql);
			sentencia.setString(1, genero);
			sentencia.setInt(2, idgeneroroductos);

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
			JOptionPane.showMessageDialog(null, "Error al actualizar el género.", "Error", JOptionPane.ERROR_MESSAGE);
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

	public List<MGeneroProducto> obtenerGenero() {
		List<MGeneroProducto> listaGenero = new ArrayList<>();
		Connection conexion = ConexionBDSQLServer.GetConexion();
		String sql = "SELECT * FROM generoroducto";

		try (PreparedStatement PS = conexion.prepareStatement(sql); ResultSet RS = PS.executeQuery()) {
			while (RS.next()) {
				// Extraer datos de cada fila
				int idgeneroroductos = RS.getInt("idGenProd");
				String genero = RS.getString("genero");

				// Crear objeto MClientes y añadirlo a la lista
				MGeneroProducto generos = new MGeneroProducto(idgeneroroductos, genero);
				listaGenero.add(generos);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaGenero;
	}
}
