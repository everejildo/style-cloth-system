package controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexion.ConexionBDSQLServer;
import modelo.MUsuario;

public class CRegistro {
    public static Connection Conexion = null;
    public static String sql;

    public void registrousuario(MUsuario usuario) {
    	String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

		// Validación de los datos del cliente no estén vacíos
		
		// Validación del formato del correo
		if (!usuario.getCorreo().matches(regex)) {
			JOptionPane.showMessageDialog(null, "El formato del correo electrónico es inválido", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
    	
    	PreparedStatement sentencia = null;
        ResultSet resultado = null;

        // Obtener conexión a la base de datos
        Conexion = ConexionBDSQLServer.GetConexion();

        // Consulta SQL para verificar si el idUsuario ya existe
        sql = "SELECT idUsuario FROM usuario WHERE idUsuario = ?";

        try {
            sentencia = Conexion.prepareStatement(sql);
            sentencia.setInt(1, usuario.getIdUsuario());
            resultado = sentencia.executeQuery();

            // Verificar si el idUsuario ya existe
            if (resultado.next()) {
                JOptionPane.showMessageDialog(null, "El número de usuario ya está en uso. Elija otro número.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Cerrar la consulta anterior
            resultado.close();
            sentencia.close();

            // Consulta SQL para insertar un nuevo usuario
            sql = "INSERT INTO usuario (correo, contraseña, idEmpleado, telefono, estado, ultimoLogin, idUsuario) VALUES (?, ?, ?, ?, ?, ?, ?)";
            sentencia = Conexion.prepareStatement(sql);
            sentencia.setString(1, usuario.getCorreo());
            sentencia.setString(2, usuario.getContraseña());
            sentencia.setInt(3, usuario.getIdEmpleado());
            sentencia.setString(4, usuario.getTelefono());
            sentencia.setString(5, usuario.getEstado());
            sentencia.setDate(6, new Date(usuario.getUltimoLogin().getTime()));
            sentencia.setInt(7, usuario.getIdUsuario());
            
            // Ejecutar la inserción en SQL
            int filasAfectadas = sentencia.executeUpdate();

            // Verificar si la inserción fue exitosa
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Registro exitoso", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error, verifica los datos ingresados", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            // Manejo de errores SQL
            System.err.println("Error de SQL: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al crear el usuario", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cerrar recursos
            try {
                if (resultado != null) resultado.close();
                if (sentencia != null) sentencia.close();
                if (Conexion != null) Conexion.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar los recursos: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
