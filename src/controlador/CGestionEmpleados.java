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
import modelo.MEmpleado;

public class CGestionEmpleados {
	public static Connection Conexion = null;
	public static String sql;
	public static ResultSet ResultSet = null;
	public static PreparedStatement sentencia;

	public void anadirEmpleado(MEmpleado empleado) {
		String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

		// Validación de los datos del cliente no estén vacíos
		if (empleado.getNombre().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nombre es obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
			return; // Salimos del método si hay algún campo vacío
		}
		// Validación del formato del correo
		if (!empleado.getCorreo().matches(regex)) {
			JOptionPane.showMessageDialog(null, "El formato del correo electrónico es inválido", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		sentencia = null;
		Conexion = ConexionBDSQLServer.GetConexion();

		sql = "INSERT INTO empleado (nombre, apellido, direccion, telefono, correo, rfc, fechaNac, puesto) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			sentencia = Conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			sentencia.setString(1, empleado.getNombre());
			sentencia.setString(2, empleado.getApellido());
			sentencia.setString(3, empleado.getDireccion());
			sentencia.setString(4, empleado.getTelefono());
			sentencia.setString(5, empleado.getCorreo());
			sentencia.setString(6, empleado.getRfc());
			sentencia.setDate(7, new Date(empleado.getFechaRegistro().getTime()));
			sentencia.setString(8, empleado.getPuesto());

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
			JOptionPane.showMessageDialog(null, "Error al añadir al empleado", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void eliminarEmpleado(int idEmple) {
		PreparedStatement sentencia = null;// Variable PreparedStatement
		// Se genear una variables que optiene la conexion a la base de Datos
		Conexion = ConexionBDSQLServer.GetConexion();

		sql = "DELETE FROM empleado WHERE idEmpleado = ?";

		try {
			sentencia = Conexion.prepareStatement(sql);
			sentencia.setInt(1, idEmple);

			int filasAfectadas = sentencia.executeUpdate();

			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Información Eliminada", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Empleado no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Error de SQL: " + e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al eliminar el empleado", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actualizarEmpleado(int idEmple, String nombre, String apellido, String direccion, String telefono,
			String correo, String rfc, String puesto) {
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

		sql = "UPDATE empleado SET nombre = ?, apellido = ?, direccion = ?, telefono = ?, correo = ?, rfc = ?, puesto = ? WHERE idEmpleado = ?";

		try {
			Conexion = ConexionBDSQLServer.GetConexion();
			sentencia = Conexion.prepareStatement(sql);
			sentencia.setString(1, nombre);
			sentencia.setString(2, apellido);
			sentencia.setString(3, direccion);
			sentencia.setString(4, telefono);
			sentencia.setString(5, correo);
			sentencia.setString(6, rfc);
			//sentencia.setDate(7, fechaRegistro);
			sentencia.setString(7, puesto);
			sentencia.setInt(8, idEmple);

			int filasAfectadas = sentencia.executeUpdate();

			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Empleado actualizado con éxito.", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Empleado no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Error de SQL: " + e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al actualizar el empleado.", "Error", JOptionPane.ERROR_MESSAGE);
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

	public List<MEmpleado> obtenerEmpleados() {
		List<MEmpleado> listaEmpleados = new ArrayList<>();
		Connection conexion = ConexionBDSQLServer.GetConexion();
		String sql = "SELECT * FROM empleado";
		
		try (PreparedStatement PS = conexion.prepareStatement(sql); ResultSet RS = PS.executeQuery()) {
			while (RS.next()) {
				// Extraer datos de cada fila
				int idEmple = RS.getInt("idEmpleado");
				String nombre = RS.getString("nombre");
				String apellido = RS.getString("apellido");
				String direccion = RS.getString("direccion");
				String telefono = RS.getString("telefono");
				String correo = RS.getString("correo");
				String rfc = RS.getString("rfc");
				Date fechaRegistro = RS.getDate("fechaNac");
				String puesto = RS.getString("puesto");
				
				// Crear objeto MClientes y añadirlo a la lista
				MEmpleado empleado = new MEmpleado(idEmple, nombre, apellido, direccion, telefono, correo, rfc, fechaRegistro, puesto);
				listaEmpleados.add(empleado);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaEmpleados;
	}
	
	public static DefaultComboBoxModel<String> cmbBxPuesto(){
		// Se inicializa un objeto de tipo DefaultComboBoxModel
				DefaultComboBoxModel<String> DatosJcombox = new DefaultComboBoxModel<String>();

				try {
					Statement conectar = ConexionBDSQLServer.GetConexion().createStatement();
					ResultSet rs = conectar.executeQuery("SELECT * FROM puesto");

					// Se ingresa un dato blanco en el primer campo del Combox
					DatosJcombox.addElement("Seleccione una opción");
					while (rs.next()) {
						// se llena con todos los elementos devueltos de la tabal de Combox
						DatosJcombox.addElement(rs.getString("nombre"));
					}
					rs.close();
					conectar.close();

				} catch (SQLException e) {
					System.err.println(e.getMessage());
					JOptionPane.showMessageDialog(null, "Error al consultar los puestos", "Error", JOptionPane.ERROR_MESSAGE);
					DatosJcombox = null;
				}

				return DatosJcombox;
	}
}
