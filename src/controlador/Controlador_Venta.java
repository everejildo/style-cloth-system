package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexion.ConexionBDSQLServer2;
import modelo.Modelo_Venta;

public class Controlador_Venta {

	// Conexión a la base de datos
	private Connection Conexion;
	private String sql;

	public void crearVenta(Modelo_Venta venta) {
		// Validación de los datos del cliente no estén vacíos
		if (venta.getIdProducto().isEmpty() || venta.getCantidad() <= 0 || venta.getCooperativa().isEmpty()
				|| venta.getPrecioTotal() <= 0) {
			JOptionPane.showMessageDialog(null, "Todos los datos son obligatorios y deben ser válidos", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

        // Intentar obtener la conexión a la base de datos
        try {
			Conexion = ConexionBDSQLServer2.GetConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Verificar si la conexión es nula
        if (Conexion == null) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Preparar la sentencia SQL para insertar los datos
        sql = "INSERT INTO Ventas (IDproducto, Cantidad, PrecioTotal, Coperativa) VALUES (?, ?, ?, ?)";
        try (PreparedStatement sentencia = Conexion.prepareStatement(sql)) {
            // Establecer los valores en la sentencia
            sentencia.setString(1, venta.getIdProducto());
            sentencia.setDouble(2, venta.getCantidad());
            sentencia.setDouble(3, venta.getPrecioTotal());
            sentencia.setString(4, venta.getCooperativa());

            // Ejecutar la inserción
            int filasAfectadas = sentencia.executeUpdate();

            // Verificar si la inserción fue exitosa
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Información Guardada", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error, verifica los datos ingresados", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexión o al insertar datos: " + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            // Cerrar la conexión
            if (Conexion != null) {
                try {
                    Conexion.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}