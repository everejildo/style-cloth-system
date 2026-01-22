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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.CLogin;
import modelo.MUsuario;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField tf_usuario;
	private JLabel usuario;
	private JLabel password;
	private JButton btn_registro;
	private JButton btn_iniciarsesion;
	private JPasswordField pswdFld;
	private JLabel lblNewLabel;
	private Locale idioma;
	private static ResourceBundle et;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public login() {
		// Internacionalización
		idioma = Locale.getDefault();
		et = ResourceBundle.getBundle("properties/dic", idioma);
		
		setForeground(new Color(255, 255, 255));
		setTitle("Ropa Online");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 602);
		panel = new JPanel();
		panel.setBackground(new Color(244, 244, 244));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panel);
		panel.setLayout(null);

		usuario = new JLabel(et.getString("usuario"));
		usuario.setHorizontalAlignment(SwingConstants.CENTER);
		usuario.setFont(new Font("Bahnschrift", Font.BOLD, 22));
		usuario.setBounds(10, 232, 937, 29);
		panel.add(usuario);

		password = new JLabel(et.getString("contrasena"));
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setFont(new Font("Bahnschrift", Font.BOLD, 22));
		password.setBounds(10, 318, 937, 36);
		panel.add(password);

		tf_usuario = new JTextField();
		tf_usuario.setToolTipText("Solo puedes utilizar letras minusculas y numeros");
		tf_usuario.setBounds(313, 264, 330, 29);
		panel.add(tf_usuario);
		tf_usuario.setColumns(10);

		btn_iniciarsesion = new JButton(et.getString("iniciarsesion"));
		btn_iniciarsesion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_iniciarsesion.setBounds(313, 437, 330, 29);
		panel.add(btn_iniciarsesion);

		btn_registro = new JButton(et.getString("registrate"));
		btn_registro.setForeground(new Color(0, 128, 255));
		btn_registro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_registro.setBounds(497, 164, 99, 23);
		panel.add(btn_registro);
		btn_registro.setOpaque(false);
		btn_registro.setOpaque(false);
		btn_registro.setContentAreaFilled(false);
		btn_registro.setBorderPainted(false);

		JLabel lblInicioDeSesin = new JLabel(et.getString("iniciodesesion"));
		lblInicioDeSesin.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicioDeSesin.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblInicioDeSesin.setBounds(10, 122, 937, 47);
		panel.add(lblInicioDeSesin);

		JLabel lblETPV = new JLabel(et.getString("estuprimeravez"));
		lblETPV.setHorizontalAlignment(SwingConstants.RIGHT);
		lblETPV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblETPV.setBounds(374, 164, 146, 23);
		panel.add(lblETPV);

		pswdFld = new JPasswordField();
		pswdFld.setBounds(313, 357, 330, 29);
		panel.add(pswdFld);

		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/imagenes/circulo-de-usuario.png")));
		lblNewLabel.setBounds(10, 10, 937, 116);
		panel.add(lblNewLabel);

		// Manejador
		ManejadorBotones EscuchadorBotones = new ManejadorBotones();
		ManejadorKey KeyBotones = new ManejadorKey();

		// Botones
		btn_iniciarsesion.addActionListener(EscuchadorBotones);
		btn_registro.addActionListener(EscuchadorBotones);

		// Validaciopnes
		tf_usuario.addKeyListener(KeyBotones);
		pswdFld.addKeyListener(KeyBotones);
	}

	public class ManejadorBotones implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			if (evento.getSource().equals(btn_iniciarsesion)) {
				String idUsuarioText = tf_usuario.getText().trim();
				String contraseña = new String(pswdFld.getPassword()).trim();

				// Validar que no haya campos vacios
				if (!idUsuarioText.isEmpty() && !contraseña.isEmpty()) {
					int idUsuario = Integer.parseInt(idUsuarioText);

					// Intaciar modelo y controlador
					MUsuario usuario = new MUsuario();
					usuario.setIdUsuario(idUsuario);
					usuario.setContraseña(contraseña);

					CLogin controlador = new CLogin();
					boolean loginValido = controlador.verificarLogin(usuario);
					if (loginValido) {
						menuprincipal menu = new menuprincipal(idioma);
						menu.setVisible(true);
						dispose();
					}

				} else {
					JOptionPane.showMessageDialog(null, "Por favor completar todos los datos.");
				}
			}
			if (evento.getSource().equals(btn_registro)) {
				registro login = new registro(idioma);
				login.setVisible(true);
				dispose();
			}
		}

	}

	public class ManejadorKey implements KeyListener {
		public void keyTyped(KeyEvent event) {
			if (event.getSource().equals(tf_usuario)) {
				int key = event.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;
				if (!(numeros)) {
					event.consume();
				}
			}
			if (event.getSource().equals(pswdFld)) {
				int key = event.getKeyChar();
				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean numeros = key >= 48 && key <= 57;
				if (!(minusculas || mayusculas || numeros)) {
					event.consume();
				}

			}
		}

		public void keyPressed(KeyEvent event) {
			if (event.getKeyCode() == KeyEvent.VK_ENTER) {
				btn_iniciarsesion.doClick();
			}
		}

		public void keyReleased(KeyEvent event) {
		}

	}
}
