package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexion.ConexionBDSQLServer;
import modelo.MUsuario;

// Clase que permite el acceso a la BD
public class CLogin {
	public static Connection Conexion = null;
	public static String sql;
	
	// Verificar que el login y password estén en la base de datos
	// y estén anidados
	public boolean verificarLogin(MUsuario usuario) {
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        // Obtener conexión a la base de datos
        Conexion = ConexionBDSQLServer.GetConexion(); // sqlserver

        // Consulta SQL para verificar el usuario
        sql = "SELECT * FROM usuario WHERE idUsuario = ? AND contraseña = ?";

        try {
            sentencia = Conexion.prepareStatement(sql);
            sentencia.setInt(1, usuario.getIdUsuario());
            sentencia.setString(2, usuario.getContraseña());

            // Ejecutar la consulta
            resultado = sentencia.executeQuery();

            // Verificar si se encontró un usuario con las credenciales proporcionadas
            if (resultado.next()) {
                // Usuario encontrado
                JOptionPane.showMessageDialog(null, "Login exitoso", "Información",
                        JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                // Usuario no encontrado
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            // Manejo de errores SQL
            System.err.print("Error de SQL " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al verificar el login, verifique la consola para ver el error", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            // Cerrar recursos
            try {
                if (resultado != null) resultado.close();
                if (sentencia != null) sentencia.close();
                if (Conexion != null) Conexion.close();
            } catch (SQLException e) {
                System.err.print("Error al cerrar los recursos " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}