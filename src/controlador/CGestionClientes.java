package controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Locale;
//import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import conexion.ConexionBDSQLServer;
import modelo.MClientes;

public class CGestionClientes {
	public static Connection Conexion = null;
	public static String sql;

	public void anadirCliente(MClientes cliente) {
		String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

		// Validación de los datos del cliente no estén vacíos
		if (cliente.getNombre().isEmpty() || cliente.getApellido().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nombre y apellido son obligatorios", "Error",
					JOptionPane.ERROR_MESSAGE);
			return; // Salimos del método si hay algún campo vacío
		}
		// Validación del formato del correo
		if (!cliente.getCorreo().matches(regex)) {
			JOptionPane.showMessageDialog(null, "El formato del correo electrónico es inválido", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		PreparedStatement sentencia = null;// Variable PreparedStatement
		// Se genear una variables que optiene la conexion a la base de Datos
		Conexion = ConexionBDSQLServer.GetConexion();

		sql = "INSERT INTO clientes (nombre, apellido, telefono, correo, direccion, fechaRegistro, numCompras) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			sentencia = Conexion.prepareStatement(sql);
			sentencia.setString(1, cliente.getNombre());
			sentencia.setString(2, cliente.getApellido());
			sentencia.setString(3, cliente.getTelefono());
			sentencia.setString(4, cliente.getCorreo());
			sentencia.setString(5, cliente.getDireccion());
			sentencia.setDate(6, new Date(cliente.getFechaRegistro().getTime()));
			sentencia.setInt(7, cliente.getNumCompras());

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
			JOptionPane.showMessageDialog(null, "Error al añadir al cliente", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void eliminarCliente(int idCliente) {
		PreparedStatement sentencia = null;// Variable PreparedStatement
		// Se genear una variables que optiene la conexion a la base de Datos
		Conexion = ConexionBDSQLServer.GetConexion();

		sql = "DELETE FROM clientes WHERE idCliente = ?";

		try {
			sentencia = Conexion.prepareStatement(sql);
			sentencia.setInt(1, idCliente);

			int filasAfectadas = sentencia.executeUpdate();

			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Información Eliminada", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Cliente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Error de SQL: " + e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al eliminar cliente", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actualizarCliente(int idCliente, String nombre, String apellido, String telefono, String correo,
			String direccion) {
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

		sql = "UPDATE clientes SET nombre = ?, apellido = ?, telefono = ?, correo = ?, direccion = ? WHERE idCliente = ?";

		try {
			Conexion = ConexionBDSQLServer.GetConexion();
			sentencia = Conexion.prepareStatement(sql);
			sentencia.setString(1, nombre);
			sentencia.setString(2, apellido);
			sentencia.setString(3, telefono);
			sentencia.setString(4, correo);
			sentencia.setString(5, direccion);
			sentencia.setInt(6, idCliente);

			int filasAfectadas = sentencia.executeUpdate();

			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Cliente actualizado con éxito.", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Cliente no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Error de SQL: " + e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al actualizar el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
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

	public List<MClientes> obtenerClientes() {
		List<MClientes> clientes = new ArrayList<>();
		Connection conexion = ConexionBDSQLServer.GetConexion();
		String sql = "SELECT * FROM clientes";
		
		try (PreparedStatement PS = conexion.prepareStatement(sql); ResultSet RS = PS.executeQuery()) {
			while (RS.next()) {
				// Extraer datos de cada fila
				int idCliente = RS.getInt("idCliente");
				String nombre = RS.getString("nombre");
				String apellido = RS.getString("apellido");
				String telefono = RS.getString("telefono");
				String correo = RS.getString("correo");
				String direccion = RS.getString("direccion");
				Date fechaRegistro = RS.getDate("fechaRegistro");
				int numCompras = RS.getInt("numCompras");
				// Crear objeto MClientes y añadirlo a la lista
				MClientes cliente = new MClientes(idCliente, nombre, apellido, telefono, correo, direccion,
						fechaRegistro, numCompras);
				clientes.add(cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}
}
