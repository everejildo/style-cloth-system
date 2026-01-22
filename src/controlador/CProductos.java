package controlador;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import conexion.ConexionBDSQLServer;
import modelo.MProducto;

public class CProductos {
	public static Connection Conexion = null;
	public static String sql;

	public void anadirProducto(MProducto productos) {
		PreparedStatement sentencia = null;// Variable PreparedStatement
		// Se genear una variables que optiene la conexion a la base de Datos
		Conexion = ConexionBDSQLServer.GetConexion();

		//sql = "INSERT INTO productos (idProducto, nombre, descripcion, tipo, talla, precio, fechaIngreso, stock, genero, idProveedor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		sql = "INSERT INTO productos  (nombre, descripcion, tipo, talla, precio, fechaIngreso, stock, genero) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			sentencia = Conexion.prepareStatement(sql);
			//sentencia.setInt(1, productos.getIdProducto());
			sentencia.setString(1, productos.getNombre());
			sentencia.setString(2, productos.getDescripcion());
			sentencia.setString(3, productos.getTipo());
			sentencia.setString(4, productos.getTalla());
			sentencia.setBigDecimal(5, productos.getPrecio());
			sentencia.setDate(6, new Date(productos.getFechaRegistro().getTime()));
			sentencia.setInt(7, productos.getStock());
			sentencia.setString(8, productos.getGenero());
			//sentencia.setInt(10, productos.getIdProveedor());
			
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
			JOptionPane.showMessageDialog(null, "Error al añadir el producto", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void eliminarProducto(int idProducto) {
		PreparedStatement sentencia = null;
		Conexion = ConexionBDSQLServer.GetConexion();

		sql = "DELETE FROM productos WHERE idProducto = ?";

		try {
			sentencia = Conexion.prepareStatement(sql);
			sentencia.setInt(1, idProducto);

			int filasAfectadas = sentencia.executeUpdate();

			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Información Eliminada", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Producto no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Error de SQL: " + e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al eliminar el producto", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actualizarProducto(String nombre, String descripcion, String tipo, String talla, BigDecimal precio,
			int stock, String genero, /*int idProveedor,*/ int idProducto) {
		if (nombre.isEmpty() || descripcion.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Estos campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		PreparedStatement sentencia = null;
		Connection Conexion = null;

		//sql = "UPDATE productos SET nombre = ?, descripcion = ?, tipo = ?, talla = ?, precio = ?, stock = ?, genero = ?, idProveedor = ? WHERE idProducto = ?";
		sql = "UPDATE productos SET nombre = ?, descripcion = ?, tipo = ?, talla = ?, precio = ?, stock = ?, genero = ? WHERE idProducto = ?";

		try {
			Conexion = ConexionBDSQLServer.GetConexion();
			sentencia = Conexion.prepareStatement(sql);
			sentencia.setString(1, nombre);
			sentencia.setString(2, descripcion);
			sentencia.setString(3, tipo);
			sentencia.setString(4, talla);
			sentencia.setBigDecimal(5, precio);
			sentencia.setInt(6, stock);
			sentencia.setString(7, genero);
			//sentencia.setInt(8, idProveedor);
			sentencia.setInt(8, idProducto);

			int filasAfectadas = sentencia.executeUpdate();

			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Producto actualizado con éxito.", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Error de SQL: " + e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al actualizar el producto.", "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			try {
				if (sentencia != null)
					sentencia.close();
				if (Conexion != null)
					Conexion.close();
			} catch (SQLException ex) {
				System.err.println("Error al cerrar recursos: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}

	public List<MProducto> obtenerProductos() {
		List<MProducto> listaProductos = new ArrayList<>();
		Connection conexion = ConexionBDSQLServer.GetConexion();
		String sql = "SELECT * FROM productos";

		try (PreparedStatement sentencia = conexion.prepareStatement(sql); ResultSet rs = sentencia.executeQuery()) {
			while (rs.next()) {
				int idProducto = rs.getInt("idProducto");
				String nombre = rs.getString("nombre");
				String descripcion = rs.getString("descripcion");
				String tipo = rs.getString("tipo");
				String talla = rs.getString("talla");
				BigDecimal precio = rs.getBigDecimal("precio");
				Date fechaRegistro = rs.getDate("fechaIngreso");
				int stock = rs.getInt("stock");
				String genero = rs.getString("genero");
				//int idProveedor = rs.getInt("idProveedor");

				MProducto producto = new MProducto(idProducto, nombre, descripcion, tipo, talla, precio, fechaRegistro,
						stock, genero/*, idProveedor*/);
				listaProductos.add(producto);
			}

		} catch (SQLException e) {
			System.err.println("Error de SQL: " + e.getMessage());
			e.printStackTrace();
		}

		return listaProductos;
	}
	
	public static DefaultComboBoxModel<String> cmbBxTipoProducto(){
		// Se inicializa un objeto de tipo DefaultComboBoxModel
				DefaultComboBoxModel<String> DatosJcombox = new DefaultComboBoxModel<String>();

				try {
					Statement conectar = ConexionBDSQLServer.GetConexion().createStatement();
					ResultSet rs = conectar.executeQuery("SELECT * FROM tipoProducto");

					// Se ingresa un dato blanco en el primer campo del Combox
					DatosJcombox.addElement("Seleccione una opción");
					while (rs.next()) {
						// se llena con todos los elementos devueltos de la tabal de Combox
						DatosJcombox.addElement(rs.getString("tipo"));
					}
					rs.close();
					conectar.close();

				} catch (SQLException e) {
					System.err.println(e.getMessage());
					JOptionPane.showMessageDialog(null, "Error al consultar los tipos", "Error", JOptionPane.ERROR_MESSAGE);
					DatosJcombox = null;
				}

				return DatosJcombox;

	}
	
	public static DefaultComboBoxModel<String> cmbBxTallaProducto(){
		// Se inicializa un objeto de tipo DefaultComboBoxModel
				DefaultComboBoxModel<String> DatosJcombox = new DefaultComboBoxModel<String>();

				try {
					Statement conectar = ConexionBDSQLServer.GetConexion().createStatement();
					ResultSet rs = conectar.executeQuery("SELECT * FROM tallaProducto");

					// Se ingresa un dato blanco en el primer campo del Combox
					DatosJcombox.addElement("Seleccione una opción");
					while (rs.next()) {
						// se llena con todos los elementos devueltos de la tabal de Combox
						DatosJcombox.addElement(rs.getString("talla"));
					}
					rs.close();
					conectar.close();

				} catch (SQLException e) {
					System.err.println(e.getMessage());
					JOptionPane.showMessageDialog(null, "Error al consultar las tallas", "Error", JOptionPane.ERROR_MESSAGE);
					DatosJcombox = null;
				}

				return DatosJcombox;

	}
	
	public static DefaultComboBoxModel<String> cmbBxGeneroProducto(){
		// Se inicializa un objeto de tipo DefaultComboBoxModel
				DefaultComboBoxModel<String> DatosJcombox = new DefaultComboBoxModel<String>();

				try {
					Statement conectar = ConexionBDSQLServer.GetConexion().createStatement();
					ResultSet rs = conectar.executeQuery("SELECT * FROM generoroducto");

					// Se ingresa un dato blanco en el primer campo del Combox
					DatosJcombox.addElement("Seleccione una opción");
					while (rs.next()) {
						// se llena con todos los elementos devueltos de la tabal de Combox
						DatosJcombox.addElement(rs.getString("genero"));
					}
					rs.close();
					conectar.close();

				} catch (SQLException e) {
					System.err.println(e.getMessage());
					JOptionPane.showMessageDialog(null, "Error al consultar los generos", "Error", JOptionPane.ERROR_MESSAGE);
					DatosJcombox = null;
				}

				return DatosJcombox;
	}
}
