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

import Controladores.Controlador_Registro;
import modelo.Modelo_Pescador;

public class ModificadorP extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	private JButton btnNewButton_Modificar;
	private JButton btnNewButton_Atras;
	private JTable tabla;
	private DefaultTableModel modeloTabla;
	private JButton btnNewButton_Eliminar;
	private Controlador_Registro controladorPescador;
	private int idSeleccionado;
	private JLabel lblNewLabel_4;
	private JTextField textField_3;
	private JLabel lblNewLabel_5;
	private JTextField textField_4;
	private JLabel lblNewLabel_6;
	private JTextField textField_5;
	private JButton btnNewButton;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificadorP frame = new ModificadorP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ModificadorP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarPescador();
				mostrarPescador();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(510, 456, 85, 21);
		contentPane.add(btnNewButton);
		
		textField_3 = new JTextField();
		textField_3.setBounds(354, 102, 105, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(329, 141, 121, 19);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(105, 141, 115, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Matricula");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(230, 144, 76, 13);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_5 = new JLabel("Apellido_M");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(20, 143, 82, 13);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_4 = new JLabel("Apellido_P:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(268, 105, 76, 13);
		contentPane.add(lblNewLabel_4);

		btnNewButton_Atras = new JButton("Atras.");
		btnNewButton_Atras.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_Atras.setBackground(new Color(0, 255, 255));
		btnNewButton_Atras.setBounds(20, 33, 96, 21);
		contentPane.add(btnNewButton_Atras);

		btnNewButton_Modificar = new JButton("Actualizar");
		btnNewButton_Modificar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_Modificar.setBounds(230, 450, 105, 30);
		contentPane.add(btnNewButton_Modificar);

		btnNewButton_Modificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seleccionarID();
			}
		});

		textField = new JTextField();
		textField.setBounds(150, 102, 108, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(115, 175, 105, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(339, 175, 111, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nombre Pescador:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(20, 104, 114, 13);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Contraseña.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(20, 177, 96, 13);
		contentPane.add(lblNewLabel_1);
	
		btnNewButton_Eliminar = new JButton("Eliminar Pescador");
		btnNewButton_Eliminar.setBackground(new Color(0, 255, 255));
		btnNewButton_Eliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_Eliminar.setBounds(493, 10, 136, 21);
		contentPane.add(btnNewButton_Eliminar);
		
		btnNewButton_Eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	seleccionarID();
            	eliminarPescador();
            	mostrarPescador();
            }
        });
		

		JLabel lblNewLabel_2 = new JLabel("Cooperativa");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(230, 177, 114, 13);
		contentPane.add(lblNewLabel_2);

		// Crear la tabla de proveedores
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("	ID Pescador");
		modeloTabla.addColumn("Nombre ");
		modeloTabla.addColumn("Apelido Paterno");
		modeloTabla.addColumn("Apelido Materno");
		modeloTabla.addColumn("Matricula");
		modeloTabla.addColumn("Cooperativa");

		tabla = new JTable(modeloTabla);
		

		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(20, 240, 590, 200);
		contentPane.add(scrollPane);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(
				new ImageIcon(ModificadorP.class.getResource("/Imaggenes/524e5b556e4cff3fe16ae8ab7cfd696b (1).gif")));
		lblNewLabel_3.setBounds(0, 0, 631, 495);
		contentPane.add(lblNewLabel_3);
		// MANEJADOR
		ManejadorBotones escuchadorBotones = new ManejadorBotones();

		// BOTONES
		btnNewButton_Atras.addActionListener(escuchadorBotones);
		
		controladorPescador = new Controlador_Registro();
		mostrarPescador();
	}

	// CLASE MANEJADOR
	public class ManejadorBotones implements ActionListener {
		public void actionPerformed(ActionEvent eventoBotones) {
			if (eventoBotones.getSource().equals(btnNewButton_Atras)) {
				Registro ModificadorP = new Registro();
				ModificadorP.setVisible(true);
				dispose();
			}
		}
	}
	
	
	private void seleccionarID() {
	    int filaSeleccionada = tabla.getSelectedRow();
	    if (filaSeleccionada >= 0) {
	        // Obtener el ID del pescador de la primera columna
	        idSeleccionado = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
	        
	        // Asignar los valores de las columnas correspondientes a los campos de texto
	        textField.setText((String) modeloTabla.getValueAt(filaSeleccionada, 1));  // Nombre
	        textField_3.setText((String) modeloTabla.getValueAt(filaSeleccionada, 2)); // Apellido_P
	        textField_4.setText((String) modeloTabla.getValueAt(filaSeleccionada, 3)); // Apellido_M
	        textField_5.setText((String) modeloTabla.getValueAt(filaSeleccionada, 4)); // Matricula
	        textField_2.setText((String) modeloTabla.getValueAt(filaSeleccionada, 5)); // Cooperativa

	        // Imprimir valores para depuración
	        System.out.println("Fila seleccionada: " + filaSeleccionada);
	        System.out.println("ID: " + idSeleccionado);
	        System.out.println("Nombre: " + textField.getText());
	        System.out.println("Apellido_P: " + textField_3.getText());
	        System.out.println("Apellido_M: " + textField_4.getText());
	        System.out.println("Matricula: " + textField_5.getText());
	        System.out.println("Cooperativa: " + textField_2.getText());
	        
	        // Limpiar campo de contraseña al seleccionar un pescador
	        textField_1.setText("");
	    } else {
	        JOptionPane.showMessageDialog(this, "Debe seleccionar algún campo.");
	    }
	}
	
	private void eliminarPescador() {
		int filaSeleccionada = tabla.getSelectedRow();
		int idpescador = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
		controladorPescador.eliminarPescador(idpescador);

	}
	
	private void actualizarPescador() {
		if (idSeleccionado != -1) {
			String nombre = textField.getText();
			String paterno = textField_3.getText();
			String materno = textField_4.getText();
			String matricula = textField_5.getText();
			String contraseña = textField_1.getText();
			String cooperativa = textField_2.getText();
			
			controladorPescador.actualizarPescador(idSeleccionado, nombre, paterno, materno, matricula, contraseña, cooperativa);
		} else {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un pescador para modificar.");
		}

	}
	
	private void mostrarPescador() {
		List<Modelo_Pescador> listaPescador = controladorPescador.mostrarPescador();
		modeloTabla.setRowCount(0); // Limpiar la tabla antes de llenarla

		for (Modelo_Pescador pescador : listaPescador) {
			Object[] fila = { pescador.getIDpescador(), pescador.getNombre(),
					pescador.getApellido_Paterno(), pescador.getApellido_Materno(),
					pescador.getMatricula(), pescador.getCooperativa()};
			modeloTabla.addRow(fila);
		}

	}
}