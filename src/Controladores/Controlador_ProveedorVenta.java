package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Cooperativa.ProveedorVenta;
import conexion.ConexionBDSQLServer2;
import modelo.Modelo_Venta;

public class Controlador_ProveedorVenta {

    // Conexión a la base de datos
    private Connection Conexion;
    private String sql;

    // Método para manejar la venta
    public void realizarVenta(ProveedorVenta vista) {
    	
    	
        // Obtener los datos de la vista
        String producto = vista.getComboBoxProductos().getSelectedItem().toString();
        String cooperativa = vista.getComboBox_cooperativa().getSelectedItem().toString();
        double cantidad;
        double precioTotal;

        try {
            cantidad = Double.parseDouble(vista.getTextField_cantidad().getText());
            precioTotal = Double.parseDouble(vista.getTextField_precio().getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor ingresa valores numéricos válidos para la cantidad y el precio.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar que los campos no estén vacíos
        if (producto.isEmpty() || cooperativa.isEmpty() || cantidad <= 0 || precioTotal <= 0) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios y deben ser válidos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear el modelo de venta
        Modelo_Venta venta = new Modelo_Venta(producto, cantidad, cooperativa, precioTotal);

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
                JOptionPane.showMessageDialog(null, "Venta completada", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error, verifica los datos ingresados", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexión o al insertar datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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