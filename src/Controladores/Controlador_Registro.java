package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexion.ConexionBDSQLServer;
import modelo.Modelo_Pescador;

public class Controlador_Registro {
	public static Connection Conexion = null;
	public static String sql;
	public static ResultSet ResultSet = null;
	public static PreparedStatement sentencia;

	public void anadirPescador(Modelo_Pescador pescador) {
		// Validación de los datos del cliente no estén vacíos
		if (pescador.getNombre().isEmpty() || pescador.getApellido_Paterno().isEmpty()
				|| pescador.getApellido_Materno().isEmpty() || pescador.getMatricula().isEmpty()
				|| pescador.getCooperativa().isEmpty() || pescador.getContraseña().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Todos los datos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
		}

		sentencia = null;
		Conexion = ConexionBDSQLServer.GetConexion();

		sql = "INSERT INTO Pescador (Nombre, Apelldio_P, Apellido_M, Maticula_Panga, Coperativa, Contraseña) VALUES (?, ?, ?, ?, ?,?)";

		try {
			sentencia = Conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			sentencia.setString(1, pescador.getNombre());
			sentencia.setString(2, pescador.getApellido_Paterno());
			sentencia.setString(3, pescador.getApellido_Materno());
			sentencia.setString(4, pescador.getMatricula());
			sentencia.setString(5, pescador.getCooperativa());
			sentencia.setString(6, pescador.getContraseña());

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
			JOptionPane.showMessageDialog(null, "Error al añadir Pescador", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void eliminarPescador(int IDpescador) {
		PreparedStatement sentencia = null;
		Conexion = ConexionBDSQLServer.GetConexion();

		try {

			sql = "DELETE FROM Pescador WHERE IDpescador = ?";
			sentencia = Conexion.prepareStatement(sql);
			sentencia.setInt(1, IDpescador);

			int filasAfectadas = sentencia.executeUpdate();

			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Información Eliminada", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Pescador no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Error de SQL: " + e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al eliminar el pescador", "Error", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void actualizarPescador(int IDpescador, String Nombre, String Apellido_Paterno, String Apellido_Materno,
			String Matricula, String Coperativa, String Contraseña) {
		// validar nombre, apellido y correo

		if (Nombre.isEmpty() || Apellido_Paterno.isEmpty() || Apellido_Materno.isEmpty() || Matricula.isEmpty()
				|| Coperativa.isEmpty() || Contraseña.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nombre y Matricula son obligatorios", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

			sql = "UPDATE Pescador SET Nombre = ?, Apelldio_P = ?, Apellido_M = ?, Maticula_Panga = ?, Coperativa = ?, Contraseña = ? WHERE IDpescador = ?";

			try {
				Conexion = ConexionBDSQLServer.GetConexion();
				sentencia = Conexion.prepareStatement(sql);
				sentencia.setString(1, Nombre);
				sentencia.setString(2, Apellido_Paterno);
				sentencia.setString(3, Apellido_Materno);
				sentencia.setString(4, Matricula);
				sentencia.setString(5, Coperativa);
				sentencia.setString(6, Contraseña);
				sentencia.setInt(7, IDpescador);

				int filasAfectadas = sentencia.executeUpdate();

				if (filasAfectadas > 0) {
					JOptionPane.showMessageDialog(null, "Información actualizado con éxito.", "Información",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Pescador no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException e) {
				System.err.println("Error de SQL: " + e.getMessage());
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al actualizar el pescador.", "Error",
						JOptionPane.ERROR_MESSAGE);
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
	
	public List<Modelo_Pescador> mostrarPescador() {
		List<Modelo_Pescador> listaPescador = new ArrayList<>();
		Conexion = ConexionBDSQLServer.GetConexion();
		sql = "SELECT IDpescador, Nombre, Apelldio_P, Apellido_M, Maticula_Panga, Coperativa FROM Pescador";
		try {
			sentencia = Conexion.prepareStatement(sql);
			ResultSet rs = sentencia.executeQuery();

			while (rs.next()) {
				int idpescador = rs.getInt("IDpescador");
				String nombre = rs.getString("Nombre");
				String paterno = rs.getString("Apelldio_P");
				String materno = rs.getString("Apellido_M");
				String matricula = rs.getString("Maticula_Panga");
				String Coperativa = rs.getString("Coperativa");

				Modelo_Pescador pescador = new Modelo_Pescador(idpescador, nombre, paterno, materno, matricula ,Coperativa );
				listaPescador.add(pescador);
			}
		} catch (SQLException e) {
			System.err.println("Error de SQL: " + e.getMessage());
			e.printStackTrace();
		}
		return listaPescador;
	}

	

	
}
