package Cooperativa;

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

import Controladores.Controlador_Login;
import modelo.Modelo_Pescador;


public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_Matriculap;
	private JTextField textField_Contraseña;
	public Object btnNewButton;
	private JButton ingre;
	
	
	private Locale Idioma;
	private static ResourceBundle et;
	private JLabel lblNewLabel;
	private JButton btnNewButton_Cerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		
		/// Inicializar Variables para Internacionalizacion
				// Obtener el idioma por defecto del sistema
				// (de la maquina virtual Java)
				Idioma = Locale.getDefault();

				// Ahora en ingles americano
				//Idioma = new Locale("en","US");
				Idioma = new Locale("es","MX");
				//Idioma = new Locale("es");

				// Obtener los recursos desde el archivo <properties/dic>
				// en funcion del idioma <locale>
				et = ResourceBundle.getBundle("properties/dic", Idioma);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 567);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(156, 243, 233));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCooperativa = new JLabel(et.getString("cooperativa"));
		lblCooperativa.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 20));
		lblCooperativa.setBounds(205, 10, 162, 40);
		contentPane.add(lblCooperativa);
		
		JLabel lblNewLabel_iniciarS = new JLabel(et.getString("iniciarsesión"));
		lblNewLabel_iniciarS.setForeground(new Color(0, 0, 255));
		lblNewLabel_iniciarS.setBackground(new Color(0, 0, 255));
		lblNewLabel_iniciarS.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_iniciarS.setBounds(240, 103, 105, 34);
		contentPane.add(lblNewLabel_iniciarS);
		
		JLabel lblNewLabel_MatriculaP = new JLabel(et.getString("matricula"));
		lblNewLabel_MatriculaP.setForeground(new Color(0, 64, 128));
		lblNewLabel_MatriculaP.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_MatriculaP.setBounds(38, 182, 94, 29);
		contentPane.add(lblNewLabel_MatriculaP);
		
		textField_Matriculap = new JTextField();
		textField_Matriculap.setBounds(142, 175, 301, 45);
		contentPane.add(textField_Matriculap);
		textField_Matriculap.setColumns(10);
		
		textField_Matriculap.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        JTextField textField = (JTextField) e.getSource();
		        if (!Character.isDigit(c) || textField.getText().length() >= 12) {
		            e.consume(); // Evita que se escriban caracteres no numéricos o se exceda el límite de 18 caracteres
		        }
		    }
		});
		
		
		
		JLabel lblNewLabel_Contraseña = new JLabel(et.getString("contraseña"));
		lblNewLabel_Contraseña.setForeground(new Color(0, 64, 128));
		lblNewLabel_Contraseña.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_Contraseña.setBounds(38, 266, 94, 34);
		contentPane.add(lblNewLabel_Contraseña);
		
		textField_Contraseña = new JTextField();
		textField_Contraseña.setBounds(142, 268, 151, 34);
		contentPane.add(textField_Contraseña);
		textField_Contraseña.setColumns(10);
		

		
	
		
		ingre = new JButton(et.getString("ingresar"));
		ingre.setForeground(new Color(0, 128, 192));
		ingre.setBackground(new Color(47, 230, 207));
		ingre.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 17));
		ingre.setBounds(515, 462, 105, 40);
		contentPane.add(ingre);
		
		JPanel panel = new JPanel();
		panel.setBounds(455, 10, 201, 196);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\encin\\Downloads\\Captura de pantalla 2024-07-01 095219.png"));
		lblNewLabel.setBounds(0, 0, 201, 196);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(31, 104, 170, 92);
		panel.add(panel_1);
		
		btnNewButton_Cerrar = new JButton("Salir");
		btnNewButton_Cerrar.setForeground(new Color(0, 128, 192));
		btnNewButton_Cerrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_Cerrar.setBackground(new Color(0, 255, 255));
		btnNewButton_Cerrar.setBounds(41, 470, 129, 32);
		contentPane.add(btnNewButton_Cerrar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/Imaggenes/524e5b556e4cff3fe16ae8ab7cfd696b (1).gif")));
		lblNewLabel_1.setBounds(0, 0, 668, 530);
		contentPane.add(lblNewLabel_1);
		
		
		// MANEJADOR
        ManejadorBotones escuchadorBotones = new ManejadorBotones();

        // BOTONES
        ingre.addActionListener(escuchadorBotones);
        btnNewButton_Cerrar.addActionListener(escuchadorBotones);
    }

    // CLASE MANEJADOR
    public class ManejadorBotones implements ActionListener {
        public void actionPerformed(ActionEvent eventoBotones) {
            if (eventoBotones.getSource().equals(ingre)) {
            	String matricula = textField_Matriculap.getText().trim();
				String contraseña = textField_Contraseña.getText().trim();

				if (!matricula.isEmpty() && !contraseña.isEmpty()) {
					Modelo_Pescador pescador = new Modelo_Pescador(matricula, contraseña);
					pescador.setMatricula(matricula);
					pescador.setContraseña(contraseña);

					Controlador_Login controlador = new Controlador_Login();
					boolean matriculaExistente = controlador.verificarLoginPescador(pescador);
					if (matriculaExistente) {
                Menu Login = new Menu();
                Login.setVisible(true);
                dispose();
            }
            if (eventoBotones.getSource().equals(btnNewButton_Cerrar)) {
                entrada Login = new entrada();
                Login.setVisible(true);
                dispose();
		
	}
    }}
    
}
    }
}
