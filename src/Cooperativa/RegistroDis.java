package Cooperativa;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controladores.Controlador_RegistroD;
import modelo.Modelo_Distribuidor;

public class RegistroDis extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_Nombre;
	private JTextField textField_ApellidoP;
	private JTextField textField_ApellidoM;
	private JTextField textField_Matricula;
	private JTextField textField_Contraseña;
	private JTextField textField_Telefono;
	private JTextField textField_Direccion;
	private JTextField textField_Coperativa;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JButton btnAtras;
	private Controlador_RegistroD controladorDistribuidor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroDis frame = new RegistroDis();
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
	public RegistroDis() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnAtras = new JButton("Atras");
		btnAtras.setBackground(new Color(0, 255, 255));
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAtras.setBounds(34, 10, 85, 21);
		contentPane.add(btnAtras);

		JLabel lblTitulo = new JLabel("Registro Distribuidor");
		lblTitulo.setForeground(new Color(0, 128, 192));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblTitulo.setBounds(211, 1, 200, 36);
		contentPane.add(lblTitulo);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(0, 128, 192));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(89, 109, 118, 36);
		contentPane.add(lblNombre);

		JLabel lblApellidoP = new JLabel("Apellido Paterno:");
		lblApellidoP.setForeground(new Color(0, 128, 192));
		lblApellidoP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellidoP.setBounds(89, 155, 118, 36);
		contentPane.add(lblApellidoP);

		JLabel lblApellidoM = new JLabel("Apellido Materno:");
		lblApellidoM.setForeground(new Color(0, 128, 192));
		lblApellidoM.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellidoM.setBounds(89, 201, 118, 36);
		contentPane.add(lblApellidoM);

		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setForeground(new Color(0, 128, 192));
		lblMatricula.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMatricula.setBounds(89, 247, 102, 32);
		contentPane.add(lblMatricula);

		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setForeground(new Color(0, 128, 192));
		lblContraseña.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContraseña.setBounds(89, 296, 102, 32);
		contentPane.add(lblContraseña);

		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setForeground(new Color(0, 128, 192));
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefono.setBounds(89, 338, 102, 32);
		contentPane.add(lblTelefono);

		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setForeground(new Color(0, 128, 192));
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDireccion.setBounds(89, 390, 102, 32);
		contentPane.add(lblDireccion);

		JLabel lblCoperativa = new JLabel("Coperativa:");
		lblCoperativa.setForeground(new Color(0, 128, 192));
		lblCoperativa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCoperativa.setBounds(89, 432, 102, 32);
		contentPane.add(lblCoperativa);

		textField_Nombre = new JTextField();
		textField_Nombre.setForeground(new Color(0, 128, 128));
		textField_Nombre.setBackground(new Color(191, 235, 255));
		textField_Nombre.setBounds(211, 111, 167, 36);
		contentPane.add(textField_Nombre);
		textField_Nombre.setColumns(10);

		textField_ApellidoP = new JTextField();
		textField_ApellidoP.setForeground(new Color(0, 128, 128));
		textField_ApellidoP.setBackground(new Color(191, 235, 255));
		textField_ApellidoP.setBounds(211, 157, 167, 36);
		contentPane.add(textField_ApellidoP);
		textField_ApellidoP.setColumns(10);

		textField_ApellidoM = new JTextField();
		textField_ApellidoM.setForeground(new Color(0, 128, 128));
		textField_ApellidoM.setBackground(new Color(191, 235, 255));
		textField_ApellidoM.setBounds(211, 203, 167, 36);
		contentPane.add(textField_ApellidoM);
		textField_ApellidoM.setColumns(10);

		textField_Matricula = new JTextField();
		textField_Matricula.setForeground(new Color(0, 128, 128));
		textField_Matricula.setBackground(new Color(191, 235, 255));
		textField_Matricula.setBounds(211, 247, 167, 36);
		contentPane.add(textField_Matricula);
		textField_Matricula.setColumns(10);

		textField_Contraseña = new JTextField();
		textField_Contraseña.setForeground(new Color(0, 128, 128));
		textField_Contraseña.setBackground(new Color(191, 235, 255));
		textField_Contraseña.setBounds(211, 296, 167, 36);
		contentPane.add(textField_Contraseña);
		textField_Contraseña.setColumns(10);

		textField_Telefono = new JTextField();
		textField_Telefono.setForeground(new Color(0, 128, 128));
		textField_Telefono.setBackground(new Color(191, 235, 255));
		textField_Telefono.setBounds(211, 342, 167, 36);
		contentPane.add(textField_Telefono);
		textField_Telefono.setColumns(10);

		textField_Direccion = new JTextField();
		textField_Direccion.setForeground(new Color(0, 128, 128));
		textField_Direccion.setBackground(new Color(191, 235, 255));
		textField_Direccion.setBounds(211, 390, 167, 36);
		contentPane.add(textField_Direccion);
		textField_Direccion.setColumns(10);

		textField_Coperativa = new JTextField();
		textField_Coperativa.setForeground(new Color(0, 128, 128));
		textField_Coperativa.setBackground(new Color(191, 235, 255));
		textField_Coperativa.setBounds(211, 436, 167, 36);
		contentPane.add(textField_Coperativa);
		textField_Coperativa.setColumns(10);

		btnRegistrar = new JButton("Registrar.");
		btnRegistrar.setForeground(new Color(0, 128, 128));
		btnRegistrar.setBackground(new Color(128, 255, 255));
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistrar.setBounds(440, 430, 167, 36);
		contentPane.add(btnRegistrar);

		btnRegistrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				registrarDistribuidor();
			}
		});

		btnModificar = new JButton("Modificar.");
		btnModificar.setBackground(new Color(0, 255, 255));
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModificar.setBounds(509, 10, 113, 21);
		contentPane.add(btnModificar);

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Registro.class.getResource("/Imaggenes/524e5b556e4cff3fe16ae8ab7cfd696b (1).gif")));
		lblFondo.setBounds(0, 0, 666, 530);
		contentPane.add(lblFondo);

		// MANEJADOR
		ManejadorBotones escuchadorBotones = new ManejadorBotones();

		// BOTONES
		btnAtras.addActionListener(escuchadorBotones);
		btnModificar.addActionListener(escuchadorBotones);

		controladorDistribuidor = new Controlador_RegistroD();
	}

	// CLASE MANEJADOR
	public class ManejadorBotones implements ActionListener {
		public void actionPerformed(ActionEvent eventoBotones) {
			if (eventoBotones.getSource().equals(btnAtras)) {
				Menu2 RegistroDis = new Menu2();
				RegistroDis.setVisible(true);
				dispose();
			}

			if (eventoBotones.getSource().equals(btnModificar)) {
				ModificadorD RegistroDis = new ModificadorD();
				RegistroDis.setVisible(true);
				dispose();
			}
		}
	}

	private void registrarDistribuidor() {
		String nombre = textField_Nombre.getText();
		System.out.println("Nombre: "+ nombre);
		String paterno = textField_ApellidoP.getText();
		System.out.println("paterno: "+ paterno);
		String materno = textField_ApellidoM.getText();
		System.out.println("materno: "+ materno);
		String matricula = textField_Matricula.getText();
		System.out.println("matricula: "+ matricula);
		String contraseña = textField_Contraseña.getText();
		System.out.println("contraseña: "+ contraseña);
		String telefono = textField_Telefono.getText();
		System.out.println("telefono: "+ telefono);
		String direccion = textField_Direccion.getText();
		System.out.println("direccion: "+ direccion);
		String coperativa = textField_Coperativa.getText();
		System.out.println("coperativa: "+ coperativa);

		Modelo_Distribuidor distribuidor = new Modelo_Distribuidor( nombre, paterno, materno, matricula, contraseña, telefono, direccion, coperativa);
		controladorDistribuidor.anadirDistribuidor(distribuidor);
	}
}



