package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexion.ConexionBDSQLServer;
import modelo.Modelo_Distribuidor;

public class Controlador_RegistroD {
    public static Connection Conexion = null;
    public static String sql;
    public static ResultSet ResultSet = null;
    public static PreparedStatement sentencia;

    public void anadirDistribuidor(Modelo_Distribuidor distribuidor) {
        // Validación de los datos del distribuidor no estén vacíos
        if (distribuidor.getNombre().isEmpty() || distribuidor.getApellido_Paterno().isEmpty()
                || distribuidor.getApellido_Materno().isEmpty() || distribuidor.getMatricula().isEmpty()
                || distribuidor.getContraseña().isEmpty() || distribuidor.getTelefono().isEmpty()
                || distribuidor.getDireccion().isEmpty() || distribuidor.getCooperativa().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los datos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        sentencia = null;
        Conexion = ConexionBDSQLServer.GetConexion();

        sql = "INSERT INTO Distribuidores (Nombre, Apelldio_P, Apellido_M, Matricula, Contraseña, Telefono, Direccion, Coperativa) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            sentencia = Conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            sentencia.setString(1, distribuidor.getNombre());
            sentencia.setString(2, distribuidor.getApellido_Paterno());
            sentencia.setString(3, distribuidor.getApellido_Materno());
            sentencia.setString(4, distribuidor.getMatricula());
            sentencia.setString(5, distribuidor.getContraseña());
            sentencia.setString(6, distribuidor.getTelefono());
            sentencia.setString(7, distribuidor.getDireccion());
            sentencia.setString(8, distribuidor.getCooperativa());

            // Ejecutar la inserción en SQL
            int filasAfectadas = sentencia.executeUpdate();

            // Verificar si la inserción fue exitosa
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Información Guardada", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error, verifica los datos ingresados", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            // Manejo de errores SQL
            System.err.println("Error de SQL: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al añadir Distribuidor", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarDistribuidor(int IDdistribuidor) {
        PreparedStatement sentencia = null;
        Conexion = ConexionBDSQLServer.GetConexion();

        try {
            sql = "DELETE FROM Distribuidores WHERE IDdistribuidor = ?";
            sentencia = Conexion.prepareStatement(sql);
            sentencia.setInt(1, IDdistribuidor);

            int filasAfectadas = sentencia.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Información Eliminada", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Distribuidor no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al eliminar el distribuidor", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarDistribuidor(int IDdistribuidor, String Nombre, String Apellido_P, String Apellido_M,
            String Matricula, String Contraseña, String Telefono, String Direccion, String Coperativa) {
        // Validación de los datos
        if (Nombre.isEmpty() || Apellido_P.isEmpty() || Apellido_M.isEmpty() || Matricula.isEmpty()
         || Contraseña.isEmpty() || Telefono.isEmpty() || Direccion.isEmpty() || Coperativa.isEmpty()) {
         JOptionPane.showMessageDialog(null, "Todos los datos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
         return;
         }

         sql = "UPDATE Distribuidores SET Nombre = ?, Apelldio_P = ?, Apellido_M = ?, Matricula = ?, Contraseña = ?, Telefono = ?, Direccion = ?, Coperativa = ? WHERE IDdistribuidor = ?";

         try {
         Conexion = ConexionBDSQLServer.GetConexion();
         sentencia = Conexion.prepareStatement(sql);
         sentencia.setString(1, Nombre);
         sentencia.setString(2, Apellido_P);
         sentencia.setString(3, Apellido_M);
         sentencia.setString(4, Matricula);
         sentencia.setString(5, Contraseña);
         sentencia.setString(6, Telefono);
         sentencia.setString(7, Direccion);
         sentencia.setString(8, Coperativa);
         sentencia.setInt(9, IDdistribuidor);

         int filasAfectadas = sentencia.executeUpdate();

         if (filasAfectadas > 0) {// Verificar si la inserción fue exitosa
                 JOptionPane.showMessageDialog(null, "Información Actualizada", "Información", JOptionPane.INFORMATION_MESSAGE);
         } else {
          JOptionPane.showMessageDialog(null, "Distribuidor no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
           }
         } catch (SQLException e) {
         System.err.println("Error de SQL: " + e.getMessage());
         e.printStackTrace();
         JOptionPane.showMessageDialog(null, "Error al actualizar el distribuidor.", "Error", JOptionPane.ERROR_MESSAGE);
         } finally {
            try {
           if (sentencia != null) sentencia.close();
           if (Conexion != null) Conexion.close();
             } catch (SQLException ex) {
            System.err.println("Error al cerrar recursos: " + ex.getMessage());
            ex.printStackTrace();
         }
    }
}

    public List<Modelo_Distribuidor> mostrarDistribuidor() {
        List<Modelo_Distribuidor> listaDistribuidor = new ArrayList<>();
        Conexion = ConexionBDSQLServer.GetConexion();
        sql = "SELECT IDdistribuidor, Nombre, Apelldio_P, Apellido_M, Matricula, Contraseña, Telefono, Direccion, Coperativa FROM Distribuidores";

        try {
            sentencia = Conexion.prepareStatement(sql);
            ResultSet rs = sentencia.executeQuery();

            while (rs.next()) {
                int idDistribuidor = rs.getInt("IDdistribuidor");
                String nombre = rs.getString("Nombre");
                String apellidoP = rs.getString("Apelldio_P");
                String apellidoM = rs.getString("Apellido_M");
                String matricula = rs.getString("Matricula");
                String contraseña = rs.getString("Contraseña");
                String telefono = rs.getString("Telefono");
                String direccion = rs.getString("Direccion");
                String coperativa = rs.getString("Coperativa");

                Modelo_Distribuidor distribuidor = new Modelo_Distribuidor(idDistribuidor, nombre, apellidoP, apellidoM, matricula, contraseña, telefono, direccion, coperativa);
                listaDistribuidor.add(distribuidor);
            }
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
            e.printStackTrace();
        }
        return listaDistribuidor;
    }
    
	}

	
	

