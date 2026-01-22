package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.Controlador_Login2;
import modelo.Modelo_Distribuidor;

public class Login2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_Matricula2;
	private JTextField textField_Contraseña2;
	private JButton btnNewButton;

	private Locale Idioma;
	private static ResourceBundle et;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login2 frame = new Login2();
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
	public Login2() {

		/// Inicializar Variables para Internacionalizacion
		// Obtener el idioma por defecto del sistema
		// (de la maquina virtual Java)
		Idioma = Locale.getDefault();

		// Ahora en ingles americano
		// Idioma = new Locale("en","US");
		Idioma = new Locale("es", "MX");
		// Idioma = new Locale("es");

		// Obtener los recursos desde el archivo <properties/dic>
		// en funcion del idioma <locale>
		et = ResourceBundle.getBundle("properties/dic", Idioma);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 577);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(41, 214, 197));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(et.getString("cooperativa"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(211, 27, 139, 34);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(et.getString("iniciarsesión"));
		lblNewLabel_1.setForeground(new Color(0, 64, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(211, 142, 102, 27);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_MatriculaD = new JLabel(et.getString("matriculad"));
		lblNewLabel_MatriculaD.setForeground(new Color(0, 0, 160));
		lblNewLabel_MatriculaD.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_MatriculaD.setBounds(29, 237, 80, 13);
		contentPane.add(lblNewLabel_MatriculaD);

		textField_Matricula2 = new JTextField();
		textField_Matricula2.setBounds(126, 225, 248, 40);
		contentPane.add(textField_Matricula2);
		textField_Matricula2.setColumns(10);

		textField_Matricula2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				JTextField textField = (JTextField) e.getSource();
				if (!Character.isDigit(c) || textField.getText().length() >= 15) {
					e.consume(); // Evita que se escriban caracteres no numéricos o se exceda el límite de 18
									// caracteres
				}
			}
		});

		JLabel lblNewLabel_Contraseña = new JLabel(et.getString("contraseña"));
		lblNewLabel_Contraseña.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_Contraseña.setForeground(new Color(0, 0, 160));
		lblNewLabel_Contraseña.setBounds(29, 321, 80, 15);
		contentPane.add(lblNewLabel_Contraseña);

		textField_Contraseña2 = new JTextField();
		textField_Contraseña2.setBounds(126, 313, 188, 34);
		contentPane.add(textField_Contraseña2);
		textField_Contraseña2.setColumns(10);

		textField_Contraseña2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				JTextField textField = (JTextField) e.getSource();

				// Verifica si la longitud actual es igual a 10
				if (textField.getText().length() >= 10) {
					e.consume(); // Evita que se exceda el límite de 10 caracteres
				}
			}
		});

		btnNewButton = new JButton(et.getString("entrar"));
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setBounds(547, 506, 85, 21);
		contentPane.add(btnNewButton);

		JPanel panel = new JPanel();
		panel.setBounds(409, 56, 201, 196);
		contentPane.add(panel);
		panel.setLayout(null);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\encin\\Downloads\\Captura de pantalla 2024-07-01 095219.png"));
		lblNewLabel_2.setBounds(0, 0, 201, 196);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		//lblNewLabel_3.setIcon(new ImageIcon(Login2.class.getResource("/Imaggenes/524e5b556e4cff3fe16ae8ab7cfd696b (1).gif")));
		lblNewLabel_3.setBounds(0, 0, 680, 563);
		contentPane.add(lblNewLabel_3);

		// MANEJADOR
		ManejadorBotones escuchadorBotones = new ManejadorBotones();

		// BOTONES
		btnNewButton.addActionListener(escuchadorBotones);

	}

	// CLASE MANEJADOR
	public class ManejadorBotones implements ActionListener {
		public void actionPerformed(ActionEvent eventoBotones) {
			if (eventoBotones.getSource().equals(btnNewButton)) {
				String matricula = textField_Matricula2.getText().trim();
				String contraseña = textField_Contraseña2.getText().trim();

				if (!matricula.isEmpty() && !contraseña.isEmpty()) {
					Modelo_Distribuidor distribuidor = new Modelo_Distribuidor(matricula, contraseña);
					distribuidor.setMatricula(matricula);
					distribuidor.setContraseña(contraseña);

					Controlador_Login2 controlador = new Controlador_Login2();
					boolean matriculaExistente = controlador.verificarLoginDistribuidor(distribuidor);
					if (matriculaExistente) {
						PerfilDistribuidor Login2 = new PerfilDistribuidor();
						Login2.setVisible(true);
						dispose();
					}
				}

			}

		}
	}

}
