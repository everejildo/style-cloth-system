package otrasvistas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textPais;
	private JTextField textEstado;
	private JTextField textMail;
	private JTextField textTelefono;
	private JPasswordField pwdContraseña;
	private JPasswordField pswConfCont;
	private JTextField textAGO1;
	private JTextField textAGO2;
	private JTextField textAGO3;
	private JTextField textCan01;
	private JTextField textCan02;
	private JTextField textCan03;
	private JComboBox comboBoxDominio;
	private JButton btnCancelarIP;
	private JButton btnGuardarIP;
	private JButton btnCancelarIM;
	private JButton btnGuardarIM;
	private JButton btnCancelarTyC;
	private JButton btnGuardarTyC;
	private JRadioButton rdbtnGM;
	private JTextField textAlb01;
	private JTextField textAlb02;
	private JTextField textAlb03;
	private JRadioButton rdbtnCAN;
	private JRadioButton rdbtnAG;
	private JRadioButton rdbtnALB;
	private JDateChooser dateChooser;
	private JScrollBar scrollBar;
	private JComboBox comboBoxSexo;
	private JCheckBox chckbxTyC;
	private JCheckBox chckbxSpam;
	private JSpinner spinnerGM01;
	private JSpinner spinnerGM02;
	private JSpinner spinnerGM03;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana.class.getResource("/imagenes/logomini.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 882);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnCancelarIP = new JButton("Cancelar");
		btnCancelarIP.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelarIP.setToolTipText("Cancelar y salir");
		btnCancelarIP.setBounds(504, 214, 103, 25);
		contentPane.add(btnCancelarIP);

		btnGuardarIP = new JButton("Guardar");
		btnGuardarIP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardarIP.setToolTipText("Guarda información y skip");
		btnGuardarIP.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGuardarIP.setBounds(504, 179, 103, 25);
		contentPane.add(btnGuardarIP);

		JLabel lblInformPers = new JLabel("INFORMACIÓN PERSONAL");
		lblInformPers.setFont(new Font("CocogooseProTrial Darkmode", Font.PLAIN, 17));
		lblInformPers.setBounds(20, 75, 262, 25);
		contentPane.add(lblInformPers);

		JLabel lblNombre = new JLabel("Nombre(s):");
		lblNombre.setFont(new Font("Consolas", Font.BOLD, 14));
		lblNombre.setBounds(30, 107, 103, 13);
		contentPane.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido(s):");
		lblApellido.setFont(new Font("Consolas", Font.BOLD, 14));
		lblApellido.setBounds(30, 130, 103, 13);
		contentPane.add(lblApellido);

		JLabel lblFecNac = new JLabel("Fecha de Nacimiento:");
		lblFecNac.setFont(new Font("Consolas", Font.BOLD, 14));
		lblFecNac.setBounds(30, 156, 166, 13);
		contentPane.add(lblFecNac);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Consolas", Font.BOLD, 14));
		lblSexo.setBounds(30, 179, 62, 13);
		contentPane.add(lblSexo);

		JLabel lblPais = new JLabel("Pais:");
		lblPais.setFont(new Font("Consolas", Font.BOLD, 14));
		lblPais.setBounds(30, 202, 160, 13);
		contentPane.add(lblPais);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Consolas", Font.BOLD, 14));
		lblEstado.setBounds(30, 225, 62, 13);
		contentPane.add(lblEstado);

		JLabel lblCorreo = new JLabel("E-mail:");
		lblCorreo.setFont(new Font("Consolas", Font.BOLD, 14));
		lblCorreo.setBounds(30, 248, 62, 13);
		contentPane.add(lblCorreo);

		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setFont(new Font("Consolas", Font.BOLD, 14));
		lblTelefono.setBounds(30, 271, 76, 13);
		contentPane.add(lblTelefono);

		JLabel lblPwd = new JLabel("Contraseña:");
		lblPwd.setFont(new Font("Consolas", Font.BOLD, 14));
		lblPwd.setBounds(30, 294, 97, 13);
		contentPane.add(lblPwd);

		JLabel lblPwdConf = new JLabel("Confirmar contraseña:");
		lblPwdConf.setFont(new Font("Consolas", Font.BOLD, 14));
		lblPwdConf.setBounds(30, 317, 178, 13);
		contentPane.add(lblPwdConf);

		JLabel lblInformacinDePago = new JLabel("TÉRMINOS Y CONDICIONES");
		lblInformacinDePago.setFont(new Font("CocogooseProTrial Darkmode", Font.PLAIN, 17));
		lblInformacinDePago.setBounds(20, 744, 262, 25);
		contentPane.add(lblInformacinDePago);

		btnCancelarTyC = new JButton("Cancelar");
		btnCancelarTyC.setToolTipText("Cancelar y salir");
		btnCancelarTyC.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelarTyC.setBounds(504, 780, 103, 25);
		contentPane.add(btnCancelarTyC);

		btnGuardarTyC = new JButton("Guardar");
		btnGuardarTyC.setToolTipText("Guarda información y skip");
		btnGuardarTyC.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGuardarTyC.setBounds(504, 745, 103, 25);
		contentPane.add(btnGuardarTyC);

		JLabel lblIntMusc = new JLabel("INTERESES MUSICALES");
		lblIntMusc.setFont(new Font("CocogooseProTrial Darkmode", Font.PLAIN, 17));
		lblIntMusc.setBounds(20, 340, 262, 25);
		contentPane.add(lblIntMusc);

		JLabel lblGeneroOpc1 = new JLabel("Opción 1:");
		lblGeneroOpc1.setFont(new Font("Consolas", Font.BOLD, 14));
		lblGeneroOpc1.setBounds(40, 398, 76, 13);
		contentPane.add(lblGeneroOpc1);

		JLabel lblGeneroOpc2 = new JLabel("Opción 2:");
		lblGeneroOpc2.setFont(new Font("Consolas", Font.BOLD, 14));
		lblGeneroOpc2.setBounds(40, 421, 76, 13);
		contentPane.add(lblGeneroOpc2);

		JLabel lblGeneroOpc3 = new JLabel("Opción 3:");
		lblGeneroOpc3.setFont(new Font("Consolas", Font.BOLD, 14));
		lblGeneroOpc3.setBounds(40, 444, 76, 13);
		contentPane.add(lblGeneroOpc3);

		JLabel lblArtOpc1 = new JLabel("Opción 1:");
		lblArtOpc1.setFont(new Font("Consolas", Font.BOLD, 14));
		lblArtOpc1.setBounds(40, 490, 76, 13);
		contentPane.add(lblArtOpc1);

		JLabel lblArtOpc2 = new JLabel("Opción 2:");
		lblArtOpc2.setFont(new Font("Consolas", Font.BOLD, 14));
		lblArtOpc2.setBounds(40, 513, 76, 13);
		contentPane.add(lblArtOpc2);

		JLabel lblArtOpc3 = new JLabel("Opción 3:");
		lblArtOpc3.setFont(new Font("Consolas", Font.BOLD, 14));
		lblArtOpc3.setBounds(40, 536, 76, 13);
		contentPane.add(lblArtOpc3);

		JLabel lblCanOpc1 = new JLabel("Opción 1:");
		lblCanOpc1.setFont(new Font("Consolas", Font.BOLD, 14));
		lblCanOpc1.setBounds(40, 582, 76, 13);
		contentPane.add(lblCanOpc1);

		JLabel lblCanOpc2 = new JLabel("Opción 2:");
		lblCanOpc2.setFont(new Font("Consolas", Font.BOLD, 14));
		lblCanOpc2.setBounds(40, 605, 76, 13);
		contentPane.add(lblCanOpc2);

		JLabel lblCanOpc3 = new JLabel("Opción 3:");
		lblCanOpc3.setFont(new Font("Consolas", Font.BOLD, 14));
		lblCanOpc3.setBounds(40, 628, 76, 13);
		contentPane.add(lblCanOpc3);

		textNombre = new JTextField();
		textNombre.setToolTipText("Solo ingresar letras (mayus-minus)");
		textNombre.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				int key = evt.getKeyChar();
				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean espacio = key == 32;
				if (!(minusculas || mayusculas || espacio)) {
					evt.consume();
				}
			}
		});
		textNombre.setBounds(112, 103, 344, 19);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		textApellido = new JTextField();
		textApellido.setToolTipText("Solo ingresar letras (mayus-minus)");
		textApellido.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				int key = evt.getKeyChar();
				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean espacio = key == 32;
				if (!(minusculas || mayusculas || espacio)) {
					evt.consume();
				}
			}
		});
		textApellido.setColumns(10);
		textApellido.setBounds(134, 126, 322, 19);
		contentPane.add(textApellido);

		textPais = new JTextField();
		textPais.setToolTipText("Solo ingresar letras (mayus-minus)");
		textPais.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				int key = evt.getKeyChar();
				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean espacio = key == 32;
				if (!(minusculas || mayusculas || espacio)) {
					evt.consume();
				}
			}
		});
		textPais.setColumns(10);
		textPais.setBounds(71, 198, 385, 19);
		contentPane.add(textPais);

		textEstado = new JTextField();
		textEstado.setToolTipText("Solo ingresar letras (mayus-minus)");
		textEstado.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				int key = evt.getKeyChar();
				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean espacio = key == 32;
				if (!(minusculas || mayusculas || espacio)) {
					evt.consume();
				}
			}
		});
		textEstado.setColumns(10);
		textEstado.setBounds(88, 221, 368, 19);
		contentPane.add(textEstado);

		textMail = new JTextField();
		textMail.setToolTipText("Solo ingresar nombre del usuario (nada después del @)");
		textMail.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				String texto = textMail.getText();
				texto = texto.replaceAll("[!/&%$=)]", "");
				textMail.setText(texto);
				if (textMail.getText().length() > 49) {
					evt.consume();
				}
			}
		});
		textMail.setColumns(10);
		textMail.setBounds(88, 244, 244, 19);
		contentPane.add(textMail);

		comboBoxDominio = new JComboBox();
		comboBoxDominio.setModel(new DefaultComboBoxModel(new String[] { "Seleccione una opción", "hotmail.com",
				"gmail.com", "upve.edu.mx", "outlook.com", "icloud.com" }));
		comboBoxDominio.setBounds(359, 243, 97, 21);
		contentPane.add(comboBoxDominio);

		JLabel lblarroba = new JLabel("@");
		lblarroba.setFont(new Font("Consolas", Font.BOLD, 14));
		lblarroba.setBounds(342, 248, 14, 13);
		contentPane.add(lblarroba);

		textTelefono = new JTextField();
		textTelefono.setToolTipText("Solo ingresar 10 números");
		textTelefono.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				int key = evt.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;
				if (!numeros) {
					evt.consume();
				}
				if (textTelefono.getText().trim().length() == 10) {
					evt.consume();
				}
			}
		});
		textTelefono.setColumns(10);
		textTelefono.setBounds(112, 267, 344, 19);
		contentPane.add(textTelefono);

		pwdContraseña = new JPasswordField();
		pwdContraseña.setToolTipText("Ingresar una contraseña segura");
		pwdContraseña.setBounds(126, 290, 330, 19);
		contentPane.add(pwdContraseña);

		pswConfCont = new JPasswordField();
		pswConfCont.setToolTipText("Corrobora que sea la misma contraseña");
		pswConfCont.setBounds(202, 313, 254, 19);
		contentPane.add(pswConfCont);

		chckbxTyC = new JCheckBox(" Yo acepto todos los términos y condiciones.");
		chckbxTyC.setFont(new Font("Consolas", Font.BOLD, 14));
		chckbxTyC.setBounds(35, 775, 421, 21);
		contentPane.add(chckbxTyC);

		chckbxSpam = new JCheckBox(" Deseo recibir correos con publicidad.");
		chckbxSpam.setFont(new Font("Consolas", Font.BOLD, 14));
		chckbxSpam.setBounds(35, 798, 421, 21);
		contentPane.add(chckbxSpam);

		scrollBar = new JScrollBar();
		scrollBar.setBounds(642, 10, 17, 835);
		contentPane.add(scrollBar);

		scrollBar.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				// Obtener el valor actual del JScrollBar
				int scrollValue = scrollBar.getValue();

				// Establecer la posición de la ventana en función del valor del JScrollBar
				contentPane.setLocation(contentPane.getX(), -scrollValue);
			}
		});

		// Asegúrate de que el contentPane pueda recibir el enfoque para escuchar
		// eventos de teclado
		contentPane.setFocusable(true);

		contentPane.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				int scrollValue = scrollBar.getValue();
				int scrollIncrement = scrollBar.getBlockIncrement(1); // Obtén el incremento de desplazamiento

				// Si se presiona la tecla de flecha hacia arriba
				if (keyCode == KeyEvent.VK_UP) {
					scrollBar.setValue(scrollValue - scrollIncrement); // Disminuye el valor del scrollBar
				}
				// Si se presiona la tecla de flecha hacia abajo
				else if (keyCode == KeyEvent.VK_DOWN) {
					scrollBar.setValue(scrollValue + scrollIncrement); // Aumenta el valor del scrollBar
				}
			}
		});

		textAGO1 = new JTextField();
		textAGO1.setEnabled(false);
		textAGO1.setColumns(10);
		textAGO1.setBounds(112, 486, 344, 19);
		contentPane.add(textAGO1);

		textAGO2 = new JTextField();
		textAGO2.setEnabled(false);
		textAGO2.setColumns(10);
		textAGO2.setBounds(112, 509, 344, 19);
		contentPane.add(textAGO2);

		textAGO3 = new JTextField();
		textAGO3.setEnabled(false);
		textAGO3.setColumns(10);
		textAGO3.setBounds(112, 532, 344, 19);
		contentPane.add(textAGO3);

		textCan01 = new JTextField();
		textCan01.setEnabled(false);
		textCan01.setColumns(10);
		textCan01.setBounds(112, 578, 344, 19);
		contentPane.add(textCan01);

		textCan02 = new JTextField();
		textCan02.setEnabled(false);
		textCan02.setColumns(10);
		textCan02.setBounds(112, 601, 344, 19);
		contentPane.add(textCan02);

		textCan03 = new JTextField();
		textCan03.setEnabled(false);
		textCan03.setColumns(10);
		textCan03.setBounds(112, 624, 344, 19);
		contentPane.add(textCan03);

		btnCancelarIM = new JButton("Cancelar");
		btnCancelarIM.setToolTipText("Cancelar y salir");
		btnCancelarIM.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelarIM.setBounds(504, 573, 103, 25);
		contentPane.add(btnCancelarIM);

		btnGuardarIM = new JButton("Guardar");
		btnGuardarIM.setToolTipText("Guarda información y skip");
		btnGuardarIM.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGuardarIM.setBounds(504, 527, 103, 25);
		contentPane.add(btnGuardarIM);

		JButton imgLogo = new JButton("");
		imgLogo.setForeground(UIManager.getColor("CheckBox.background"));
		imgLogo.setIcon(new ImageIcon(Ventana.class.getResource("/imagenes/logoletras3.png")));
		imgLogo.setBounds(20, 10, 459, 62);
		contentPane.add(imgLogo);

		rdbtnGM = new JRadioButton("Género Musical");
		rdbtnGM.setFont(new Font("Consolas", Font.BOLD, 14));
		rdbtnGM.setBounds(20, 372, 238, 23);
		contentPane.add(rdbtnGM);

		rdbtnAG = new JRadioButton("Artistas/Grupos");
		rdbtnAG.setFont(new Font("Consolas", Font.BOLD, 14));
		rdbtnAG.setBounds(20, 464, 176, 23);
		contentPane.add(rdbtnAG);

		rdbtnCAN = new JRadioButton("Canciones");
		rdbtnCAN.setFont(new Font("Consolas", Font.BOLD, 14));
		rdbtnCAN.setBounds(20, 556, 176, 23);
		contentPane.add(rdbtnCAN);

		rdbtnALB = new JRadioButton("Álbum");
		rdbtnALB.setFont(new Font("Consolas", Font.BOLD, 14));
		rdbtnALB.setBounds(20, 649, 176, 23);
		contentPane.add(rdbtnALB);

		textAlb01 = new JTextField();
		textAlb01.setEnabled(false);
		textAlb01.setColumns(10);
		textAlb01.setBounds(112, 671, 344, 19);
		contentPane.add(textAlb01);

		JLabel lblCanOpc1_1 = new JLabel("Opción 1:");
		lblCanOpc1_1.setFont(new Font("Consolas", Font.BOLD, 14));
		lblCanOpc1_1.setBounds(40, 675, 76, 13);
		contentPane.add(lblCanOpc1_1);

		JLabel lblCanOpc2_1 = new JLabel("Opción 2:");
		lblCanOpc2_1.setFont(new Font("Consolas", Font.BOLD, 14));
		lblCanOpc2_1.setBounds(40, 698, 76, 13);
		contentPane.add(lblCanOpc2_1);

		textAlb02 = new JTextField();
		textAlb02.setEnabled(false);
		textAlb02.setColumns(10);
		textAlb02.setBounds(112, 694, 344, 19);
		contentPane.add(textAlb02);

		JLabel lblCanOpc3_1 = new JLabel("Opción 3:");
		lblCanOpc3_1.setFont(new Font("Consolas", Font.BOLD, 14));
		lblCanOpc3_1.setBounds(40, 721, 76, 13);
		contentPane.add(lblCanOpc3_1);

		textAlb03 = new JTextField();
		textAlb03.setEnabled(false);
		textAlb03.setColumns(10);
		textAlb03.setBounds(112, 717, 344, 19);
		contentPane.add(textAlb03);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(191, 149, 265, 20);
		contentPane.add(dateChooser);

		comboBoxSexo = new JComboBox();
		comboBoxSexo.setModel(new DefaultComboBoxModel(
				new String[] { "Seleccione una opción", "Hombre", "Mujer", "Prefiero no especificar" }));
		comboBoxSexo.setBounds(88, 173, 368, 21);
		contentPane.add(comboBoxSexo);

		spinnerGM01 = new JSpinner();
		spinnerGM01.setModel(new SpinnerListModel(
				new String[] { "Seleccione el primer genero", "Pop", "Latin", "Latin Pop", "Rock", "R&B", "Reggaeton",
						"Folk", "Jazz", "Country", "Cl\u00E1sica", "Funk", "K-POP", "Reggae", "Metal", "Regional",
						"Salsa", "Bachata", "Cumbia", "Hip-hop", "Trap", "Urbano", "Electr\u00F3nica" }));
		spinnerGM01.setEnabled(false);
		spinnerGM01.setBounds(112, 394, 344, 20);
		contentPane.add(spinnerGM01);

		spinnerGM02 = new JSpinner();
		spinnerGM02.setModel(new SpinnerListModel(
				new String[] { "Seleccione el segundo genero", "Pop", "Latin", "Latin Pop", "Rock", "R&B", "Reggaeton",
						"Folk", "Jazz", "Country", "Cl\u00E1sica", "Funk", "K-POP", "Reggae", "Metal", "Regional",
						"Salsa", "Bachata", "Cumbia", "Hip-hop", "Trap", "Urbano", "Electr\u00F3nica" }));
		spinnerGM02.setEnabled(false);
		spinnerGM02.setBounds(112, 417, 344, 20);
		contentPane.add(spinnerGM02);

		spinnerGM03 = new JSpinner();
		spinnerGM03.setModel(new SpinnerListModel(
				new String[] { "Seleccione el tercer genero", "Pop", "Latin", "Latin Pop", "Rock", "R&B", "Reggaeton",
						"Folk", "Jazz", "Country", "Cl\u00E1sica", "Funk", "K-POP", "Reggae", "Metal", "Regional",
						"Salsa", "Bachata", "Cumbia", "Hip-hop", "Trap", "Urbano", "Electr\u00F3nica" }));
		spinnerGM03.setEnabled(false);
		spinnerGM03.setBounds(112, 440, 344, 20);
		contentPane.add(spinnerGM03);

		// Crear Variable Escuchadora
		ManejadorBotones EscuchadorBotones = new ManejadorBotones();

		// Botones
		btnCancelarIP.addActionListener(EscuchadorBotones);
		btnGuardarIP.addActionListener(EscuchadorBotones);
		btnCancelarIM.addActionListener(EscuchadorBotones);
		btnGuardarIM.addActionListener(EscuchadorBotones);
		btnCancelarTyC.addActionListener(EscuchadorBotones);
		btnGuardarTyC.addActionListener(EscuchadorBotones);

		// RadioBottons
		rdbtnGM.addActionListener(EscuchadorBotones);
		rdbtnAG.addActionListener(EscuchadorBotones);
		rdbtnCAN.addActionListener(EscuchadorBotones);
		rdbtnALB.addActionListener(EscuchadorBotones);

		//

		// Crear Escuchador Para Lista Cambios
		// MListaCambios EscuchadorCambios = new MListaCambios();
		// chckbxTyC.addChangeListener(EscuchadorCambios);
		// chckbxSpam.addChangeListener(EscuchadorCambios);

		// Crear un escuchador de tipo KeyListener para un JTexfile
		// ManejadorTeclado EscuchadorTeclado = new ManejadorTeclado();
		// txtCapturaElNombre.addKeyListener(EscuchadorTeclado);
	}

	// Se crea una clase manejadora que permitira el uso de los componentes
	public class ManejadorBotones implements ActionListener {

		public void actionPerformed(ActionEvent Eventos) {
			// Informacion Persona
			if (Eventos.getSource().equals(btnCancelarIP)) {
				JOptionPane.showMessageDialog(null, "Se canceló el proceso");
				// Limpiar textFiel
				textNombre.setText("");
				textApellido.setText("");
				textPais.setText("");
				textEstado.setText("");
				textMail.setText("");
				textTelefono.setText("");
				pwdContraseña.setText("");
				pswConfCont.setText("");

				// Limpiar los ComboBox
				comboBoxSexo.setSelectedIndex(0);
				comboBoxDominio.setSelectedIndex(0);

				// Limpiar el JDateChooser
				dateChooser.setDate(null);
			}
			if (Eventos.getSource().equals(btnGuardarIP)) {

				boolean validaciones = true;

				// Validar que los textField no esten vacios
				if (textNombre.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "No se ha ingresado el Nombre");
					validaciones = false;
				}
				if (textApellido.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "No se ha ingresado el Apellido");
					validaciones = false;
				}
				if (textPais.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "No se ha ingresado el Pais");
					validaciones = false;
				}
				if (textEstado.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "No se ha ingresado el Estado");
					validaciones = false;
				}
				if (textMail.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "No se ha ingresado el Correo");
					validaciones = false;
				}
				if (textTelefono.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "No se ha ingresado el Telefono");
					validaciones = false;
				} else if (textTelefono.getText().length() <= 9) {
					JOptionPane.showMessageDialog(null, "Necesita que su numero cuente con 10 digitos");
					validaciones = false;
				}

				// Validacion que no esten vacios el dateChooser
				if (dateChooser.getDate() == null) {
					JOptionPane.showMessageDialog(null, "Seleccione una fecha de nacimiento válida");
					validaciones = false;
				}

				// Validacion que no esten vacios y que coincidan los JPasswordField
				if (pwdContraseña.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "No se ha ingresado una Contraseña");
					validaciones = false;
				}
				if (pswConfCont.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "No se ha confirmado la Contraseña");
					validaciones = false;
				}
				String contraseña = new String(pwdContraseña.getPassword());
				String confContraseña = new String(pswConfCont.getPassword());

				if (!contraseña.equals(confContraseña)) {
					JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
					validaciones = false;
				}

				// Validar que no esten vacios los comboBox
				String sex = comboBoxSexo.getSelectedItem().toString();
				if (sex.equals("Seleccione una opción")) {
					JOptionPane.showMessageDialog(null, "Seleccione un valor para Sexo");
					validaciones = false;
				}
				String dom = comboBoxDominio.getSelectedItem().toString();
				if (dom.equals("Seleccione una opción")) {
					JOptionPane.showMessageDialog(null, "Seleccione un Dominio para su Correo");
					validaciones = false;
				}
				if (validaciones) {
					JOptionPane.showMessageDialog(null, "Información Validada y Guardada Correctamente");
				}
				// JOptionPane.showMessageDialog(null, "Información Completa y Guardada");
			}

			// Intereses Musicales
			if (Eventos.getSource().equals(btnGuardarIM)) {

				//Variables
				boolean validaciones = true;
				String valorSpinner1 = (String) spinnerGM01.getValue();
				String valorSpinner2 = (String) spinnerGM02.getValue();
				String valorSpinner3 = (String) spinnerGM03.getValue();

				// Validar el valor del JSpinner spinnerGM
				if (valorSpinner1 == "Seleccione el primer genero") {
					JOptionPane.showMessageDialog(null, "Aún no selecciona su primer genero");
					validaciones = false;
				}
				if (valorSpinner2 == "Seleccione el segundo genero") {
					JOptionPane.showMessageDialog(null, "Aún no selecciona su segundo genero");
					validaciones = false;
				}
				if (valorSpinner3 == "Seleccione el tercer genero") {
					JOptionPane.showMessageDialog(null, "Aún no selecciona su tercer genero");
					validaciones = false;
				}
				if (valorSpinner1 == valorSpinner2) {
					JOptionPane.showMessageDialog(null, "Seleciona una opción difente");
					validaciones = false;
				}
				if (valorSpinner2 == valorSpinner3) {
					JOptionPane.showMessageDialog(null, "Seleciona una opción difente");
					validaciones = false;
				}
				if (valorSpinner1 == valorSpinner3) {
					JOptionPane.showMessageDialog(null, "Seleciona una opción difente");
					validaciones = false;
				}

				// Validar textField Artista/Grupo, Canciones y Album
				
				if (textAGO1.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Ingrese su primer opción de Artista/Grupo");
					validaciones = false;
				}
				if (textAGO2.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Ingrese su segunda opción de Artista/Grupo");
					validaciones = false;	
				}
				if (textAGO3.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Ingrese su tercer opción de Artista/Grupo");
					validaciones = false;
				}
				if (textCan01.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Ingrese su primer opción de Canción");
					validaciones = false;
				}
				if (textCan02.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Ingrese su segunda opción de Cancion");
					validaciones = false;	
				}
				if (textCan03.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Ingrese su tercer opción de Cancion");
					validaciones = false;
				}
				if (textAlb01.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Ingrese su primer opción de Album");
					validaciones = false;
				}
				if (textAlb02.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Ingrese su segunda opción de Album");
					validaciones = false;
				}
				if (textAlb03.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Ingrese su tercer opción de Album");
					validaciones = false;
				}
				if (validaciones) {
					JOptionPane.showMessageDialog(null, "Información Guardada Correctamente");
				}
				
			}
			if (Eventos.getSource().equals(btnCancelarIM)) {

			}

			// Terminos y Condiciones
			if (Eventos.getSource().equals(btnCancelarTyC)) {
				JOptionPane.showMessageDialog(null, "Se canceló el proceso");
			}
			if (Eventos.getSource().equals(btnGuardarTyC)) {

				boolean validaciones = true;

				// Validar que los chckBox no estén deseleccionados
				if (!chckbxTyC.isSelected()) {
					JOptionPane.showMessageDialog(null, "No puedes continuar si no aceptas los términos y condiciones");
					validaciones = false;
				}
				if (!chckbxSpam.isSelected()) {
					JOptionPane.showMessageDialog(null,
							"¿Estás seguro que no deceas recibir correos con la novedades?");
				}

				if (validaciones) {
					JOptionPane.showMessageDialog(null, "     Información Guardada Correctamente     "
													  + "\n Para más actualizaciones espere a CORTE 2"
													  + "\n                   ¡GRACIAS!                ");
				}
			}

			// Activar Intereses Musicales
			if (Eventos.getSource().equals(rdbtnGM)) {
				if (rdbtnGM.isSelected()) {
					spinnerGM01.setEnabled(true);
					spinnerGM02.setEnabled(true);
					spinnerGM03.setEnabled(true);
				} else {
					spinnerGM01.setEnabled(false);
					spinnerGM02.setEnabled(false);
					spinnerGM03.setEnabled(false);
				}
			}
			if (Eventos.getSource().equals(rdbtnAG)) {
				if (rdbtnAG.isSelected()) {
					textAGO1.setEnabled(true);
					textAGO2.setEnabled(true);
					textAGO3.setEnabled(true);
				} else {
					textAGO1.setEnabled(false);
					textAGO2.setEnabled(false);
					textAGO3.setEnabled(false);
				}
			}
			if (Eventos.getSource().equals(rdbtnCAN)) {
				if (rdbtnCAN.isSelected()) {
					textCan01.setEnabled(true);
					textCan02.setEnabled(true);
					textCan03.setEnabled(true);
				} else {
					textCan01.setEnabled(false);
					textCan02.setEnabled(false);
					textCan03.setEnabled(false);
				}
			}
			if (Eventos.getSource().equals(rdbtnALB)) {
				if (rdbtnALB.isSelected()) {
					textAlb01.setEnabled(true);
					textAlb02.setEnabled(true);
					textAlb03.setEnabled(true);
				} else {
					textAlb01.setEnabled(false);
					textAlb02.setEnabled(false);
					textAlb03.setEnabled(false);
				}
			}
		}

	}
}
