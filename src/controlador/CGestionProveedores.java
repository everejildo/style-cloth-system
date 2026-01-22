package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexion.ConexionBDSQLServer;
import modelo.MProveedores;

public class CGestionProveedores {
	public static Connection Conexion = null;
	public static String sql;
	public static ResultSet ResultSet = null;
	public static PreparedStatement sentencia;
	// public int ID;

	public void anadirProveedor(MProveedores proveedor) {
		String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

		// Validación de los datos del cliente no estén vacíos
		if (proveedor.getNombre().isEmpty() || proveedor.getApellido().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nombre y apellido son obligatorios", "Error",
					JOptionPane.ERROR_MESSAGE);
			return; // Salimos del método si hay algún campo vacío
		}
		// Validación del formato del correo
		if (!proveedor.getCorreo().matches(regex)) {
			JOptionPane.showMessageDialog(null, "El formato del correo electrónico es inválido", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		sentencia = null;
		Conexion = ConexionBDSQLServer.GetConexion();

		sql = "INSERT INTO proveedores (nombre, apellido, telefono, correo, direccion, idEmpresa) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			sentencia = Conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			sentencia.setString(1, proveedor.getNombre());
			sentencia.setString(2, proveedor.getApellido());
			sentencia.setString(3, proveedor.getTelefono());
			sentencia.setString(4, proveedor.getCorreo());
			sentencia.setString(5, proveedor.getDireccion());
			sentencia.setInt(6, proveedor.getIdEmpresa());

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
			JOptionPane.showMessageDialog(null, "Error al añadir el proveedor", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void eliminarProveedor(int idProveedor) {
		PreparedStatement sentencia = null;// Variable PreparedStatement
		// Se genear una variables que optiene la conexion a la base de Datos
		Conexion = ConexionBDSQLServer.GetConexion();

		try {

			sql = "DELETE FROM proveedores WHERE idProveedor = ?";
			sentencia = Conexion.prepareStatement(sql);
			sentencia.setInt(1, idProveedor);

			int filasAfectadas = sentencia.executeUpdate();

			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Información Eliminada", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Proveedor no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Error de SQL: " + e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al eliminar el proveedor", "Error", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void actualizarCliente(int idProveedor, String nombre, String apellido, String telefono, String correo,
			String direccion, int idEmpresa) {
		// validar nombre, apellido y correo
		String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		if (nombre.isEmpty() || apellido.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nombre y apellido son obligatorios", "Error",
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

		sql = "UPDATE proveedores SET nombre = ?, apellido = ?, telefono = ?, correo = ?, direccion = ?, idEmpresa = ? WHERE idProveedor = ?";

		try {
			Conexion = ConexionBDSQLServer.GetConexion();
			sentencia = Conexion.prepareStatement(sql);
			sentencia.setString(1, nombre);
			sentencia.setString(2, apellido);
			sentencia.setString(3, telefono);
			sentencia.setString(4, correo);
			sentencia.setString(5, direccion);
			sentencia.setInt(6, idEmpresa);
			sentencia.setInt(7, idProveedor);

			int filasAfectadas = sentencia.executeUpdate();

			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Proveedor actualizado con éxito.", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Proveedor no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Error de SQL: " + e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al actualizar el proveedor.", "Error", JOptionPane.ERROR_MESSAGE);
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

	public List<MProveedores> mostrarProveedores() {
		List<MProveedores> listaProveedores = new ArrayList<>();
		Conexion = ConexionBDSQLServer.GetConexion();
		sql = "SELECT idProveedor, nombre, apellido, telefono, correo, direccion, idEmpresa FROM proveedores";
		try {
			sentencia = Conexion.prepareStatement(sql);
			ResultSet rs = sentencia.executeQuery();

			while (rs.next()) {
				int idProveedor = rs.getInt("idProveedor");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String telefono = rs.getString("telefono");
				String correo = rs.getString("correo");
				String direccion = rs.getString("direccion");
				int idEmpresa = rs.getInt("idEmpresa");

				MProveedores proveedor = new MProveedores(idProveedor, nombre, apellido, telefono, correo, direccion,
						idEmpresa);
				listaProveedores.add(proveedor);
			}
		} catch (SQLException e) {
			System.err.println("Error de SQL: " + e.getMessage());
			e.printStackTrace();
		}
		return listaProveedores;
	}

}
