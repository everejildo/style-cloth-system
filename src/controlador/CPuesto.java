package controlador;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexion.ConexionBDSQLServer;
import modelo.MPuesto;

public class CPuesto {
	public static Connection Conexion = null;
	public static String sql;
	public static ResultSet ResultSet = null;
	public static PreparedStatement sentencia;
	
	public void anadirPuesto(MPuesto puesto) {
		// Validación de los datos del cliente no estén vacíos
		if (puesto.getNombre().isEmpty() || puesto.getDepartamento().isEmpty() || puesto.getTurno().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nombre, Departamento y Turno son campo obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
			return; // Salimos del método si hay algún campo vacío
		}
		sentencia = null;
		Conexion = ConexionBDSQLServer.GetConexion();

		sql = "INSERT INTO puesto (nombre, sueldo, departamento, turno) VALUES (?, ?, ?, ?)";

		try {
			sentencia = Conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			sentencia.setString(1, puesto.getNombre());
			sentencia.setBigDecimal(2, puesto.getSueldo());
			sentencia.setString(3, puesto.getDepartamento());
			sentencia.setString(4, puesto.getTurno());

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
			JOptionPane.showMessageDialog(null, "Error al añadir el puesto", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void eliminarPuesto(int idPuesto) {
		PreparedStatement sentencia = null;// Variable PreparedStatement
		// Se genear una variables que optiene la conexion a la base de Datos
		Conexion = ConexionBDSQLServer.GetConexion();

		sql = "DELETE FROM puesto WHERE idpuesto = ?";

		try {
			sentencia = Conexion.prepareStatement(sql);
			sentencia.setInt(1, idPuesto);

			int filasAfectadas = sentencia.executeUpdate();

			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Información Eliminada", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Puesto no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Error de SQL: " + e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al eliminar el Puesto", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void actualizarPuesto(String nombre, BigDecimal sueldo, String departamento, String turno, int idPuesto) {
		// validar nombre, apellido y correo
		if (nombre.isEmpty() || departamento.isEmpty() || turno.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nombre y apellido son obligatorios", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		PreparedStatement sentencia = null;
		Connection Conexion = null;

		sql = "UPDATE puesto SET nombre = ?, sueldo = ?, departamento = ?, turno = ? WHERE idpuesto = ?";

		try {
			Conexion = ConexionBDSQLServer.GetConexion();
			sentencia = Conexion.prepareStatement(sql);
			sentencia.setString(1, nombre);
			sentencia.setBigDecimal(2, sueldo);
			sentencia.setString(3, departamento);
			sentencia.setString(4, turno);
			sentencia.setInt(5, idPuesto);

			int filasAfectadas = sentencia.executeUpdate();

			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Puesto actualizado con éxito.", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Puesto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Error de SQL: " + e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al actualizar el puesto.", "Error", JOptionPane.ERROR_MESSAGE);
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
	
	public List<MPuesto> obtenerPuesto() {
		List<MPuesto> listaPuestos = new ArrayList<>();
		Connection conexion = ConexionBDSQLServer.GetConexion();
		String sql = "SELECT * FROM puesto";
		
		try (PreparedStatement PS = conexion.prepareStatement(sql); ResultSet RS = PS.executeQuery()) {
			while (RS.next()) {
				// Extraer datos de cada fila
				int idPuesto = RS.getInt("idpuesto");
				String nombre = RS.getString("nombre");
				BigDecimal sueldo = RS.getBigDecimal("sueldo");
				String departamento = RS.getString("departamento");
				String turno = RS.getString("turno");
				
				// Crear objeto MClientes y añadirlo a la lista
				MPuesto puesto = new MPuesto(idPuesto, nombre, sueldo, departamento, turno);
				listaPuestos.add(puesto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaPuestos;
	}
}
