package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexion.ConexionBDSQLServer;
import modelo.MEmpresa;

public class CGestionEmpresa {
	public static Connection Conexion = null;
	public static String sql;
	public static ResultSet ResultSet = null;
	public static PreparedStatement sentencia;

	public void anadirEmpresa(MEmpresa empresa) {
		String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

		// Validación de los datos del cliente no estén vacíos
		if (empresa.getNombre().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nombre es obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
			return; // Salimos del método si hay algún campo vacío
		}
		// Validación del formato del correo
		if (!empresa.getCorreo().matches(regex)) {
			JOptionPane.showMessageDialog(null, "El formato del correo electrónico es inválido", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		sentencia = null;
		Conexion = ConexionBDSQLServer.GetConexion();

		sql = "INSERT INTO empresa (nombre, telefono, correo) VALUES (?, ?, ?)";

		try {
			sentencia = Conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			sentencia.setString(1, empresa.getNombre());
			sentencia.setString(2, empresa.getTelefono());
			sentencia.setString(3, empresa.getCorreo());

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
			JOptionPane.showMessageDialog(null, "Error al añadir la empresa", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void eliminarEmpresa(int idEmpresa) {
		PreparedStatement sentencia = null;
		Conexion = ConexionBDSQLServer.GetConexion();

		try {

			sql = "DELETE FROM empresa WHERE idEmpresa = ?";
			sentencia = Conexion.prepareStatement(sql);
			sentencia.setInt(1, idEmpresa);

			int filasAfectadas = sentencia.executeUpdate();

			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Información Eliminada", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Empresa no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Error de SQL: " + e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al eliminar la empresa", "Error", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void actualizarEmpresa(int idEmpresa, String nombre, String telefono, String correo) {
		// validar nombre, apellido y correo
		String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		if (nombre.isEmpty() || telefono.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nombre y teléfono son obligatorios", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (!correo.matches(regex)) {
			JOptionPane.showMessageDialog(null, "El formato del correo electrónico es inválido", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		PreparedStatement sentencia = null;
		Connection Conexion = null;

		sql = "UPDATE empresa SET nombre = ?, telefono = ?, correo = ? WHERE idEmpresa = ?";

		try {
			Conexion = ConexionBDSQLServer.GetConexion();
			sentencia = Conexion.prepareStatement(sql);
			sentencia.setString(1, nombre);
			sentencia.setString(2, telefono);
			sentencia.setString(3, correo);
			sentencia.setInt(4, idEmpresa);

			int filasAfectadas = sentencia.executeUpdate();

			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Empresa actualizado con éxito.", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Empresa no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Error de SQL: " + e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al actualizar la empresa.", "Error", JOptionPane.ERROR_MESSAGE);
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

	public List<MEmpresa> mostrarEmpresa() {
		List<MEmpresa> listaEmpresa = new ArrayList<>();
		Conexion = ConexionBDSQLServer.GetConexion();
		sql = "SELECT idEmpresa, nombre, telefono, correo FROM empresa";
		try {
			sentencia = Conexion.prepareStatement(sql);
			ResultSet rs = sentencia.executeQuery();

			while (rs.next()) {
				int idEmpresa = rs.getInt("idEmpresa");
				String nombre = rs.getString("nombre");
				String telefono = rs.getString("telefono");
				String correo = rs.getString("correo");

				MEmpresa empresa = new MEmpresa(idEmpresa, nombre, telefono, correo);
				listaEmpresa.add(empresa);
			}
		} catch (SQLException e) {
			System.err.println("Error de SQL: " + e.getMessage());
			e.printStackTrace();
		}
		return listaEmpresa;
	}
	
}
