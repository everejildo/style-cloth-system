package conexion;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestSQLServer {

	// Variable que permite realizar la conexi�n a la base de datos
	public static Connection Conexion = null;
	// Variables globales que se obtendran valores desde archivo propeties
	private static String usuario;
	private static String pwd;
	private static String db;
	private static String ip;
	private static String jdbc;
	private static String port;
	private static String NombreServer;

	public static void GetParametros() {
		usuario = "Style_Cloth1";
		pwd = "cloth123";
		db = "bd_tiendaropa";
		NombreServer = "dbo";
		jdbc = "jdbc:sqlserver";
		port = "1433";
		ip = "localhost";

	}

	public static void GetConexion() {
		// Se ejecuta el metodo que optiene los parametros de el archivo propertie
		GetParametros();
		try {

			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// esta cadena permite determinar configuraciones basi
			String DbUrl = jdbc + "://" + ip + "\\" + NombreServer + ";databaseName=" + db + ";";
			System.out.println(DbUrl);
			DbUrl = jdbc + "://" + ip + ":" + port + ";" + "databaseName=" + db + ";";
			System.out.println(DbUrl);

			Conexion = DriverManager.getConnection(DbUrl, usuario, pwd);

			if (Conexion != null) {

				DatabaseMetaData dm = Conexion.getMetaData();

				System.out.println("Driver Nombre: " + dm.getDriverName());

				System.out.println("Driver version: " + dm.getDriverVersion());

				System.out.println("Product name: " + dm.getDatabaseProductName());

				System.out.println("Product version: " + dm.getDatabaseProductVersion());

				// System.out.println("Alumno Juan Jaime Fuentes");

			}
		} catch (SQLException ex) {
			System.out.println("Error." + ex.getMessage());
		}

		try {
			Conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		GetConexion();

	}

}
