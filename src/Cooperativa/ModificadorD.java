package Cooperativa;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controladores.Controlador_RegistroD;
import modelo.Modelo_Distribuidor;

public class ModificadorD extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField_Nombre;
    private JTextField textField_Apellido_P;
    private JTextField textField_Apellido_M;
    private JTextField textField_Matricula;
    private JTextField textField_Contraseña;
    private JTextField textField_Telefono;
    private JTextField textField_Direccion;
    private JTextField textField_Coperativa;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnAtras;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private Controlador_RegistroD controladorDistribuidor;
    private int idSeleccionado = -1; // Inicializar como -1 para indicar que no se ha seleccionado ninguna fila
    
    private JButton btnNewButton_1;
    private JLabel lblNewLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ModificadorD frame = new ModificadorD();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ModificadorD() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 645, 532);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        btnNewButton_1 = new JButton("Guardar");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarDistribuidor();
                mostrarDistribuidor();
            }
        });
        btnNewButton_1.setBounds(508, 455, 85, 21);
        contentPane.add(btnNewButton_1);

        // Crear y agregar componentes
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNombre.setBounds(10, 60, 100, 20);
        contentPane.add(lblNombre);

        textField_Nombre = new JTextField();
        textField_Nombre.setBounds(94, 62, 150, 20);
        contentPane.add(textField_Nombre);

        JLabel lblApellidoP = new JLabel("Apellido Paterno:");
        lblApellidoP.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblApellidoP.setBounds(280, 60, 114, 20);
        contentPane.add(lblApellidoP);

        textField_Apellido_P = new JTextField();
        textField_Apellido_P.setBounds(404, 62, 150, 20);
        contentPane.add(textField_Apellido_P);

        JLabel lblApellidoM = new JLabel("Apellido Materno:");
        lblApellidoM.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblApellidoM.setBounds(10, 100, 114, 20);
        contentPane.add(lblApellidoM);

        textField_Apellido_M = new JTextField();
        textField_Apellido_M.setBounds(144, 102, 150, 20);
        contentPane.add(textField_Apellido_M);

        JLabel lblMatricula = new JLabel("Matricula:");
        lblMatricula.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblMatricula.setBounds(304, 100, 100, 20);
        contentPane.add(lblMatricula);

        textField_Matricula = new JTextField();
        textField_Matricula.setBounds(384, 102, 107, 20);
        contentPane.add(textField_Matricula);

        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblContraseña.setBounds(10, 141, 85, 20);
        contentPane.add(lblContraseña);

        textField_Contraseña = new JTextField();
        textField_Contraseña.setBounds(120, 143, 150, 20);
        contentPane.add(textField_Contraseña);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTelefono.setBounds(280, 141, 100, 20);
        contentPane.add(lblTelefono);

        textField_Telefono = new JTextField();
        textField_Telefono.setBounds(354, 143, 150, 20);
        contentPane.add(textField_Telefono);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblDireccion.setBounds(10, 185, 74, 20);
        contentPane.add(lblDireccion);

        textField_Direccion = new JTextField();
        textField_Direccion.setBounds(94, 187, 150, 20);
        contentPane.add(textField_Direccion);

        JLabel lblCoperativa = new JLabel("Cooperativa:");
        lblCoperativa.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblCoperativa.setBounds(280, 185, 100, 20);
        contentPane.add(lblCoperativa);

        textField_Coperativa = new JTextField();
        textField_Coperativa.setBounds(380, 187, 150, 20);
        contentPane.add(textField_Coperativa);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(249, 450, 120, 30);
        btnActualizar.addActionListener(e -> {
            seleccionarID();
            mostrarDistribuidor();
        });
        contentPane.add(btnActualizar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(484, 10, 120, 30);
        btnEliminar.addActionListener(e -> {
            seleccionarID();
            eliminarDistribuidor();
            mostrarDistribuidor();
        });
        contentPane.add(btnEliminar);

        btnAtras = new JButton("Atrás");
        btnAtras.setBounds(10, 10, 100, 30);
        btnAtras.addActionListener(e -> {
            // Regresar a la ventana anterior
            dispose();
        });
        contentPane.add(btnAtras);

        // Crear la tabla de distribuidores
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID Distribuidor");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellido Paterno");
        modeloTabla.addColumn("Apellido Materno");
        modeloTabla.addColumn("Teléfono");
        modeloTabla.addColumn("Matricula");
        modeloTabla.addColumn("Dirección");
        modeloTabla.addColumn("Cooperativa");

        tabla = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(20, 240, 590, 200);
        contentPane.add(scrollPane);
        
        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(ModificadorD.class.getResource("/Imaggenes/524e5b556e4cff3fe16ae8ab7cfd696b (1).gif")));
        lblNewLabel.setBounds(0, 0, 631, 495);
        contentPane.add(lblNewLabel);

        // Inicializar el controlador de distribuidores
        controladorDistribuidor = new Controlador_RegistroD();
        
        // Mostrar los distribuidores al iniciar la ventana
        mostrarDistribuidor();
    }

    // CLASE MANEJADOR
    public class ManejadorBotones implements ActionListener {
        public void actionPerformed(ActionEvent eventoBotones) {
            if (eventoBotones.getSource().equals(btnAtras)) {
                RegistroDis ModificadorD = new RegistroDis();
                ModificadorD.setVisible(true);
                dispose();
            }
        }
    }

    private void seleccionarID() {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada >= 0) {
            idSeleccionado = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
            textField_Nombre.setText((String) modeloTabla.getValueAt(filaSeleccionada, 1));
            textField_Apellido_P.setText((String) modeloTabla.getValueAt(filaSeleccionada, 2));
            textField_Apellido_M.setText((String) modeloTabla.getValueAt(filaSeleccionada, 3));
            textField_Matricula.setText((String) modeloTabla.getValueAt(filaSeleccionada, 4));
            textField_Telefono.setText((String) modeloTabla.getValueAt(filaSeleccionada, 5));
            textField_Direccion.setText((String) modeloTabla.getValueAt(filaSeleccionada, 6));
            textField_Coperativa.setText((String) modeloTabla.getValueAt(filaSeleccionada, 7));
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar algún campo.");
        }
    }

    private void eliminarDistribuidor() {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada >= 0) {
            int idDistribuidor = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
            controladorDistribuidor.eliminarDistribuidor(idDistribuidor);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar algún distribuidor para eliminar.");
        }
    }

    private void actualizarDistribuidor() {
        if (idSeleccionado != -1) {
            String nombre = textField_Nombre.getText();
            String paterno = textField_Apellido_P.getText();
            String materno = textField_Apellido_M.getText();
            String matricula = textField_Matricula.getText();
            String contraseña = textField_Contraseña.getText();
            String telefono = textField_Telefono.getText();
            String direccion = textField_Direccion.getText();
            String cooperativa = textField_Coperativa.getText();
            controladorDistribuidor.actualizarDistribuidor(idSeleccionado, nombre, paterno, materno, telefono, direccion, matricula, contraseña, cooperativa);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un distribuidor para modificar.");
        }
    }
    
    private void mostrarDistribuidor() {
        List<Modelo_Distribuidor> listaDistribuidor = controladorDistribuidor.mostrarDistribuidor();
        modeloTabla.setRowCount(0); // Limpiar la tabla antes de llenarla

        for (Modelo_Distribuidor distribuidor : listaDistribuidor) {
            Object[] fila = { distribuidor.getIDdistribuidor(), distribuidor.getNombre(),
                    distribuidor.getApellido_Paterno(), distribuidor.getApellido_Materno(),
                    distribuidor.getMatricula(), distribuidor.getTelefono(), distribuidor.getDireccion(), distribuidor.getCooperativa() };
            modeloTabla.addRow(fila);
        }
    }
}
