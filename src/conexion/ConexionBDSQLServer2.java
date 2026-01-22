package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBDSQLServer2 {

    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=bd_tiendaropa";
    private static final String USER = "sa";
    private static final String PASSWORD = "admin123";

    public static Connection GetConexion() throws SQLException {
        try {
            // Cargar el driver de SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Establecer la conexión con la base de datos
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver de la base de datos.");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.out.println("Error al establecer la conexión con la base de datos.");
            e.printStackTrace();
            throw e;
        }
    }
}
