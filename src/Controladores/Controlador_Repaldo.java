package Controladores;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexion.ConexionBDSQLServer;

public class Controlador_Repaldo {
	
	public static Connection Conexion = null;
	public static String sql;
	
	public void execPA(String ruta) {
		try {
			//
			//
			
			//
			Conexion = ConexionBDSQLServer.GetConexion();
			//
			CallableStatement cst = Conexion.prepareCall("{call Pa_Respaldo (?)}");
		  //
			cst.setString(1, ruta);
			//
			cst.execute();
			Conexion.close();
			
		
				JOptionPane.showMessageDialog(null, "Respaldo realizado" );
						
		} catch (SQLException e) {
			System.out.println("Error: " + e);
			JOptionPane.showMessageDialog(null, "Errror al realizar el respaldo", "Error", JOptionPane.ERROR_MESSAGE );
		}
	}

}
