package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexion.ConexionBDSQLServer;
import modelo.MVentasDetalle;

public class CVentaDetalle {
	public static Connection Conexion = null;
	public static String sql;
	
	public void anadirVentas(MVentasDetalle ventaDetalle) {
	    PreparedStatement sentencia = null;
	    Connection conexion = null;
	    double precioProducto = 0;
	    int totalVentaActual = 0;

	    // Conexión a la base de datos
	    conexion = ConexionBDSQLServer.GetConexion();

	    try {
	        // 1. Obtener el precio del producto
	        String sqlObtenerPrecio = "SELECT precio FROM productos WHERE idProducto = ?";
	        sentencia = conexion.prepareStatement(sqlObtenerPrecio);
	        sentencia.setInt(1, ventaDetalle.getIdProducto());
	        ResultSet rsPrecio = sentencia.executeQuery();
	        if (rsPrecio.next()) {
	            precioProducto = rsPrecio.getDouble("precio");
	        }

	        // 2. Insertar la nueva venta detalle
	        String sqlInsertarVentaDetalle = "INSERT INTO ventas_detalle (idVenta, idProducto, cantidad) VALUES (?, ?, ?)";
	        sentencia = conexion.prepareStatement(sqlInsertarVentaDetalle);
	        sentencia.setInt(1, ventaDetalle.getIdVenta());
	        sentencia.setInt(2, ventaDetalle.getIdProducto());
	        sentencia.setInt(3, ventaDetalle.getCantidad());
	        int filasAfectadas = sentencia.executeUpdate();

	        if (filasAfectadas > 0) {
	            // 3. Calcular el total de la venta detalle (precio del producto * cantidad)
	            double subtotal = precioProducto * ventaDetalle.getCantidad();

	            // 4. Obtener el total actual de la venta
	            String sqlObtenerTotal = "SELECT total FROM ventas WHERE idVenta = ?";
	            sentencia = conexion.prepareStatement(sqlObtenerTotal);
	            sentencia.setInt(1, ventaDetalle.getIdVenta());
	            ResultSet rsTotal = sentencia.executeQuery();
	            if (rsTotal.next()) {
	                totalVentaActual = rsTotal.getInt("total");
	            }

	            // 5. Actualizar el total de la venta sumando el nuevo subtotal
	            String sqlActualizarTotal = "UPDATE ventas SET total = ? WHERE idVenta = ?";
	            sentencia = conexion.prepareStatement(sqlActualizarTotal);
	            sentencia.setDouble(1, totalVentaActual + subtotal);
	            sentencia.setInt(2, ventaDetalle.getIdVenta());
	            int filasActualizadas = sentencia.executeUpdate();

	            if (filasActualizadas > 0) {
	                JOptionPane.showMessageDialog(null, "Venta detalle añadida y total de venta actualizado.", "Información",
	                        JOptionPane.INFORMATION_MESSAGE);
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Error al insertar venta detalle", "Error",
	                    JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error al añadir la venta detalle", "Error", JOptionPane.ERROR_MESSAGE);
	    } finally {
	        try {
	            if (sentencia != null)
	                sentencia.close();
	            if (conexion != null)
	                conexion.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	public void anadirVenta(MVentasDetalle ventaDetalle) {
		PreparedStatement sentencia = null;// Variable PreparedStatement
		// Se genear una variables que optiene la conexion a la base de Datos
		Conexion = ConexionBDSQLServer.GetConexion();

		sql = "INSERT INTO ventas_detalle (idVenta, idProducto, cantidad) VALUES (?, ?, ?)";

		try {
			sentencia = Conexion.prepareStatement(sql);
			sentencia.setInt(1, ventaDetalle.getIdVenta());
			sentencia.setInt(2, ventaDetalle.getIdProducto());
			sentencia.setInt(3, ventaDetalle.getCantidad());
			//sentencia.setInt(4, ventaDetalle.getPrecio());

			// Ejecutar la inserción en SQL
			int filasAfectadas = sentencia.executeUpdate();

			// Verificar si la inserción fue exitosa
			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Información Guardada", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Error, verifica los datos ingresados", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			// Manejo de errores SQL
			System.err.println("Error de SQL: " + e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al añadir la productos a la venta", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actualizarVenta(int newidVenta, int newidProducto ,int idVenta, int idProducto, int cantidad) {
		PreparedStatement sentencia = null;
		Connection Conexion = null;

		sql = "UPDATE ventas_detalle SET idVenta = ?, idProducto = ?, cantidad = ? WHERE idVenta = ? AND idProducto = ?";

		try {
			Conexion = ConexionBDSQLServer.GetConexion();
			sentencia = Conexion.prepareStatement(sql);

			sentencia.setInt(1, newidVenta);
			sentencia.setInt(2, newidProducto);
			sentencia.setInt(3, cantidad);
			sentencia.setInt(4, idVenta);
			sentencia.setInt(5, idProducto);

			int filasAfectadas = sentencia.executeUpdate();

			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Información actualizada exitosamente.");
			} else {
				JOptionPane.showMessageDialog(null, "No se encontró la venta con los IDs proporcionados.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al actualizar la venta: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			// Cerrar los recursos
			try {
				if (sentencia != null)
					sentencia.close();
				if (Conexion != null)
					Conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void eliminarVenta(int idVenta, int idProducto) {
		PreparedStatement sentencia = null;
		Conexion = ConexionBDSQLServer.GetConexion();

		sql = "DELETE FROM ventas WHERE idVenta = ? AND idProducto = ?";

		try {
			sentencia = Conexion.prepareStatement(sql);
			sentencia.setInt(1, idVenta);
			sentencia.setInt(2, idProducto);

			int filasAfectadas = sentencia.executeUpdate();

			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Información Eliminada", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Datos no encontrados", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Error de SQL: " + e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al eliminar", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public List<MVentasDetalle> obtenerVentasDetalle() {
		List<MVentasDetalle> listaVentaDetalle = new ArrayList<>();
		Conexion = ConexionBDSQLServer.GetConexion();
		sql = "SELECT * FROM ventas_detalle";
		
		try (PreparedStatement PS = Conexion.prepareStatement(sql); ResultSet RS = PS.executeQuery()) {
			while (RS.next()) {
				
				int idVenta = RS.getInt("idVenta");
				int idProducto = RS.getInt("idProducto");
				int cantidad = RS.getInt("cantidad");
				//int precio = RS.getInt("precio");

				MVentasDetalle ventaDetalle = new MVentasDetalle(idVenta, idProducto, cantidad);
				listaVentaDetalle.add(ventaDetalle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaVentaDetalle;
	}
}
