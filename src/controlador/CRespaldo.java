package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexion.ConexionBDSQLServer;

public class CRespaldo {
	public static Connection Conexion = null;
	public static String sql;
	
	public void execPA(String ruta) {
		try {
			// Se crea una variable de tipo conexión para prepara los elemntos utilizar el
			// el procedimiento
			
			// Conecta con la base de datos
			Conexion = ConexionBDSQLServer.GetConexion();
			// se prepara al procedimiento almacenado
			CallableStatement cst = Conexion.prepareCall("{call pa_backup_bd2 (?)}");

			// Parametro 1 del procedimiento almacenado
			cst.setString(1, ruta);

			// Ejecuta el procedimiento almacenado asignando el resultado a la variable
			// resul set
			cst.execute();

			Conexion.close();
			
			JOptionPane.showMessageDialog(null, "Respaldo realizado exitosamente.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al realizar el respaldo", "Error", JOptionPane.ERROR_MESSAGE);

		}
	}
}
