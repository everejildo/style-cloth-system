package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexion.ConexionBDSQLServer2;
import modelo.Modelo_Pescador;

public class Controlador_Login {
    public static Connection Conexion = null;
    public static String sql;

    // Verificar las credenciales de login
    public boolean verificarLoginPescador(Modelo_Pescador usuario) {
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        // Obtener conexión a la base de datos
        try {
			Conexion = ConexionBDSQLServer2.GetConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Cambia esto según tu conexión

        // Consulta SQL para verificar el usuario distribuidor
        sql = "SELECT * FROM Pescador WHERE Maticula_Panga = ? AND Contraseña = ?";

        try {
            sentencia = Conexion.prepareStatement(sql);
            sentencia.setString(1, usuario.getMatricula()); // Matricula
            sentencia.setString(2, usuario.getContraseña()); // Contraseña

            // Ejecutar la consulta
            resultado = sentencia.executeQuery();

            // Verificar si se encontró un distribuidor con las credenciales proporcionadas
            if (resultado.next()) {
                JOptionPane.showMessageDialog(null, "Login exitoso", "Información",
                        JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Matrícula o contraseña incorrecta", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al verificar el login", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            // Cerrar los recursos
            try {
                if (resultado != null) resultado.close();
                if (sentencia != null) sentencia.close();
                if (Conexion != null) Conexion.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
    }
}
