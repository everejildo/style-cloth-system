package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexion.ConexionBDSQLServer2;
import modelo.Modelo_Prestamos;


public class Controlador_Prestamos {
    
	// Conexión a la base de datos
		private Connection Conexion;
		private String sql;

		public void crearPrestamo(Modelo_Prestamos Prestamos) {
        // Validar que al menos un checkbox esté seleccionado
        if (Prestamos.getDinero() <= 0 || Prestamos.getGasolina().isEmpty() || Prestamos.getHielo().isEmpty() || Prestamos.getCarnada().isEmpty() || Prestamos.getCooperativa().isEmpty()) {
        	JOptionPane.showMessageDialog(null, "Todos los datos son obligatorios y deben ser válidos", "Error",
					JOptionPane.ERROR_MESSAGE);
            return ;
        }

        // Intentar obtener la conexión a la base de datos
        try {
			Conexion = ConexionBDSQLServer2.GetConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}

        // Verificar si la conexión es nula
        if (Conexion == null) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Connection conexion = null;
		try {
			conexion = ConexionBDSQLServer2.GetConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        sql = "INSERT INTO Prestamos (Gasolina, Hielo, Carnada, Dinero, Coperativa) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            // Asignar los valores a la consulta SQL
            
        	sentencia.setString(1, Prestamos.getGasolina());
        	sentencia.setString(2, Prestamos.getHielo());
        	sentencia.setString(3, Prestamos.getCarnada());
        	sentencia.setDouble(4, Prestamos.getDinero());
        	sentencia.setString(5, Prestamos.getCooperativa());

            // Ejecutar la inserción en la base de datos
            int filasAfectadas = sentencia.executeUpdate();

            // Verificar si la inserción fue exitosa
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Préstamo registrado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
                return ;
            } else {
                JOptionPane.showMessageDialog(null, "Error, no se pudo registrar el préstamo", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al añadir préstamo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return ;
        }
    }

}