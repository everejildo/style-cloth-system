package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.CRegistro;
import modelo.MUsuario;

public class registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFldCorreo;
	private JButton btnAtras;
	private JButton btnRegistrar;
	private JCheckBox chckbxTyC;
	private JPasswordField pwdFld_contra;
	private JPasswordField pwdFld_confContra;
	private JLabel lblimgusuario;
	private JTextField txtFldUsuario;
	private JLabel lblpwdConf;
	private static Locale idioma;
	private ResourceBundle et;
	private JTextField textFieldEmpleadoID;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro frame = new registro(idioma);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public registro(Locale idioma) {
		// Internacionalización
		registro.idioma = idioma;
		et = ResourceBundle.getBundle("properties/dic", idioma);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 602);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 244, 244));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(et.getString("nuevousuario"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 115, 935, 40);
		contentPane.add(lblNewLabel);
		
		btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(gestionclientes.class.getResource("/imagenes/angulo-circulo-izquierda.png")));
		btnAtras.setOpaque(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		btnAtras.setBounds(10, 10, 38, 33);
		contentPane.add(btnAtras);

		btnRegistrar = new JButton(et.getString("registrar"));
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRegistrar.setBounds(368, 495, 216, 23);
		contentPane.add(btnRegistrar);

		JLabel correo = new JLabel(et.getString("correoelectronico"));
		correo.setHorizontalAlignment(SwingConstants.CENTER);
		correo.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		correo.setBounds(10, 168, 935, 23);
		contentPane.add(correo);

		JLabel usuario_r = new JLabel(et.getString("usuarioregistro"));
		usuario_r.setHorizontalAlignment(SwingConstants.CENTER);
		usuario_r.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		usuario_r.setBounds(10, 223, 935, 23);
		contentPane.add(usuario_r);

		JLabel contraseña = new JLabel(et.getString("contrasenaregistro"));
		contraseña.setHorizontalAlignment(SwingConstants.CENTER);
		contraseña.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		contraseña.setBounds(10, 333, 935, 23);
		contentPane.add(contraseña);

		chckbxTyC = new JCheckBox(et.getString("aceptarTyC"));
		chckbxTyC.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxTyC.setBounds(346, 440, 216, 23);
		contentPane.add(chckbxTyC);

		txtFldCorreo = new JTextField();
		txtFldCorreo.setBounds(348, 191, 256, 20);
		contentPane.add(txtFldCorreo);
		txtFldCorreo.setColumns(10);

		pwdFld_contra = new JPasswordField();
		pwdFld_contra.setBounds(348, 356, 256, 20);
		contentPane.add(pwdFld_contra);

		pwdFld_confContra = new JPasswordField();
		pwdFld_confContra.setBounds(348, 411, 256, 20);
		contentPane.add(pwdFld_confContra);

		txtFldUsuario = new JTextField();
		txtFldUsuario.setColumns(10);
		txtFldUsuario.setBounds(348, 246, 256, 20);
		contentPane.add(txtFldUsuario);

		JLabel lblimgagregar = new JLabel("");
		lblimgagregar.setIcon(new ImageIcon(registro.class.getResource("/imagenes/agregar.png")));
		lblimgagregar.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgagregar.setBounds(479, 58, 58, 55);
		contentPane.add(lblimgagregar);

		lblpwdConf = new JLabel(et.getString("idempleadov"));
		lblpwdConf.setHorizontalAlignment(SwingConstants.CENTER);
		lblpwdConf.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblpwdConf.setBounds(10, 388, 935, 23);
		contentPane.add(lblpwdConf);

		lblimgusuario = new JLabel("");
		lblimgusuario.setIcon(new ImageIcon(registro.class.getResource("/imagenes/circulo-de-usuario.png")));
		lblimgusuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgusuario.setBounds(10, 10, 937, 116);
		contentPane.add(lblimgusuario);
		
		JLabel empleadoID = new JLabel(et.getString("confirmarcontrasena"));
		empleadoID.setHorizontalAlignment(SwingConstants.CENTER);
		empleadoID.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		empleadoID.setBounds(10, 278, 935, 23);
		contentPane.add(empleadoID);
		
		textFieldEmpleadoID = new JTextField();
		textFieldEmpleadoID.setColumns(10);
		textFieldEmpleadoID.setBounds(348, 301, 256, 20);
		contentPane.add(textFieldEmpleadoID);

		// Manejador
		ManejadorBotones EscuchadorBotones = new ManejadorBotones();
		ManejadorKey KeyBotones = new ManejadorKey();

		// Botones
		btnAtras.addActionListener(EscuchadorBotones);
		btnRegistrar.addActionListener(EscuchadorBotones);

		// Validaciones
		txtFldCorreo.addKeyListener(KeyBotones);
		pwdFld_contra.addKeyListener(KeyBotones);
		pwdFld_confContra.addKeyListener(KeyBotones);
		txtFldUsuario.addKeyListener(KeyBotones);
		textFieldEmpleadoID.addKeyListener(KeyBotones);
	}

	public class ManejadorBotones implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			if (evento.getSource().equals(btnAtras)) {
				// Regresar al inicio
				login registro = new login();
				registro.setVisible(true);
				dispose();
			}
			if (evento.getSource().equals(btnRegistrar)) {
				// Validar que no haya campos vacios
				if (txtFldCorreo.getText().isEmpty() || txtFldUsuario.getText().isEmpty()
						|| pwdFld_contra.getPassword().length == 0 || pwdFld_confContra.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "Por favor completar todos los datos.");
					return;
				}

				// Validar que las contraseñas coindicen
				String contraseña = new String(pwdFld_contra.getPassword());
				String confContraseña = new String(pwdFld_confContra.getPassword());
				if (!contraseña.equals(confContraseña)) {
					JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
					return;
				}

				// Valiar que se hayan aceptado los TyC
				if (!chckbxTyC.isSelected()) {
					JOptionPane.showMessageDialog(null,
							"No puedes continuar si no aceptas los términos y condiciones.");
					return;
				}
				// Llamar al método registrarUsuario() si todo está correcto
	            registrarUsuario();
	            
	            // Regresa a al frame principal
				login registro = new login();
				registro.setVisible(true);
				dispose();
			}
		}

	}

	public class ManejadorKey implements KeyListener {
		public void keyTyped(KeyEvent event) {
			if (event.getSource().equals(txtFldCorreo)) {
				int key = event.getKeyChar();
				boolean minusculas = key >= 97 && key <= 122;
				boolean numeros = key >= 48 && key <= 57;
				boolean arroba = key == 64;
				boolean guionBajo = key == 95;
				boolean punto = key == 46;
				if (!(minusculas || arroba || numeros || guionBajo || punto)) {
					event.consume();
				}
			}
			if (event.getSource().equals(pwdFld_contra)) {
				int key = event.getKeyChar();
				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean numeros = key >= 48 && key <= 57;
				if (!(minusculas || mayusculas || numeros)) {
					event.consume();
				}
			}
			if (event.getSource().equals(pwdFld_confContra)) {
				int key = event.getKeyChar();
				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean numeros = key >= 48 && key <= 57;
				if (!(minusculas || mayusculas || numeros)) {
					event.consume();
				}
			}
			if (event.getSource().equals(txtFldUsuario)) {
				int key = event.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;
				if (!(numeros)) {
					event.consume();
				}
			}
			if (event.getSource().equals(textFieldEmpleadoID)) {
				int key = event.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;
				if (!(numeros)) {
					event.consume();
				}
			}
		}

		public void keyPressed(KeyEvent event) {
		}

		public void keyReleased(KeyEvent event) {
		}

	}
	public void registrarUsuario() {
		String correo = txtFldCorreo.getText();
		String usuario = txtFldUsuario.getText();
		String contraseña = new String(pwdFld_contra.getPassword());
		String confContraseña = new String(pwdFld_confContra.getPassword());
		int idEmpleado = Integer.parseInt(textFieldEmpleadoID.getText().trim());
		
		if (correo.isEmpty() || usuario.isEmpty() || contraseña.isEmpty() || confContraseña.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Advertencia", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		if (!contraseña.equals(confContraseña)) {
			JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Advertencia", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		MUsuario nuevoUsuario = new MUsuario();
		nuevoUsuario.setCorreo(correo);
		nuevoUsuario.setIdUsuario(Integer.parseInt(usuario)); // Asegúrate de que el campo usuario sea un número
		nuevoUsuario.setContraseña(contraseña);
		nuevoUsuario.setIdEmpleado(idEmpleado); // Ajusta esto según sea necesario
		nuevoUsuario.setTelefono("0000000000"); // Ajusta esto según sea necesario
		nuevoUsuario.setEstado("activo"); // Ajusta esto según sea necesario
		nuevoUsuario.setUltimoLogin(new java.util.Date()); // Fecha actual
		
		CRegistro controlador = new CRegistro();
		controlador.registrousuario(nuevoUsuario);
	}
}