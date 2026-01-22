package Cooperativa;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ResgistroDis extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnNewButton_Registrar;
	private JButton btnNewButton_RegistrarD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public ResgistroDis() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro.");
		lblNewLabel.setForeground(new Color(0, 128, 192));
		lblNewLabel.setBackground(new Color(0, 128, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(309, 45, 113, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_NombreD = new JLabel("Nombre Distribuidor:");
		lblNewLabel_NombreD.setForeground(new Color(0, 128, 192));
		lblNewLabel_NombreD.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_NombreD.setBounds(57, 134, 134, 36);
		contentPane.add(lblNewLabel_NombreD);
		
		JLabel lblNewLabel_ApellidoP = new JLabel("Apellido_P:");
		lblNewLabel_ApellidoP.setForeground(new Color(0, 128, 192));
		lblNewLabel_ApellidoP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_ApellidoP.setBounds(89, 201, 118, 36);
		contentPane.add(lblNewLabel_ApellidoP);
		
		JLabel lblNewLabel_ApellidoM = new JLabel("Apellido_M:");
		lblNewLabel_ApellidoM.setForeground(new Color(0, 128, 192));
		lblNewLabel_ApellidoM.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_ApellidoM.setBounds(89, 263, 118, 36);
		contentPane.add(lblNewLabel_ApellidoM);
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 128, 128));
		textField.setBackground(new Color(191, 235, 255));
		textField.setBounds(217, 136, 167, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(0, 128, 128));
		textField_1.setBackground(new Color(191, 235, 255));
		textField_1.setBounds(217, 201, 167, 36);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(0, 128, 128));
		textField_2.setBackground(new Color(191, 235, 255));
		textField_2.setBounds(217, 263, 167, 29);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		btnNewButton_Registrar = new JButton("Registrar.");
		btnNewButton_Registrar.setForeground(new Color(0, 128, 128));
		btnNewButton_Registrar.setBackground(new Color(128, 255, 255));
		btnNewButton_Registrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_Registrar.setBounds(217, 464, 167, 36);
		contentPane.add(btnNewButton_Registrar);
		
		JLabel lblNewLabel_Matrciula = new JLabel("Matricula:");
		lblNewLabel_Matrciula.setForeground(new Color(0, 128, 192));
		lblNewLabel_Matrciula.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_Matrciula.setBounds(89, 313, 102, 32);
		contentPane.add(lblNewLabel_Matrciula);
		
		textField_3 = new JTextField();
		textField_3.setForeground(new Color(0, 128, 128));
		textField_3.setBackground(new Color(191, 235, 255));
		textField_3.setBounds(217, 309, 167, 36);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_IngresarC = new JLabel("Ingresar Contraseña:");
		lblNewLabel_IngresarC.setForeground(new Color(0, 128, 192));
		lblNewLabel_IngresarC.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_IngresarC.setBounds(89, 368, 136, 29);
		contentPane.add(lblNewLabel_IngresarC);
		
		textField_4 = new JTextField();
		textField_4.setForeground(new Color(0, 128, 128));
		textField_4.setBackground(new Color(191, 235, 255));
		textField_4.setBounds(244, 361, 155, 36);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		
		
		
		JLabel lblNewLabel_IngresarN = new JLabel("Ingresar de Nuevo:");
		lblNewLabel_IngresarN.setForeground(new Color(0, 128, 192));
		lblNewLabel_IngresarN.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_IngresarN.setBounds(89, 413, 129, 29);
		contentPane.add(lblNewLabel_IngresarN);
		
		textField_5 = new JTextField();
		textField_5.setForeground(new Color(0, 128, 128));
		textField_5.setBackground(new Color(191, 235, 255));
		textField_5.setBounds(232, 413, 167, 36);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		btnNewButton_RegistrarD = new JButton("Registrar.");
		btnNewButton_RegistrarD.setBackground(new Color(0, 255, 255));
		btnNewButton_RegistrarD.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_RegistrarD.setBounds(244, 472, 155, 36);
		contentPane.add(btnNewButton_RegistrarD);}
	

	// MANEJADOR
    ManejadorBotones escuchadorBotones = new ManejadorBotones();

    // BOTONES
   // btnNewButton_RegistrarD.addActionListener(escuchadorBotones);
    
 // CLASE MANEJADOR
    public class ManejadorBotones implements ActionListener {
    	public void actionPerformed(ActionEvent eventoBotones) {
    		if (eventoBotones.getSource().equals(btnNewButton_RegistrarD)) {
    			Login RegistroDis = new Login();
    			RegistroDis.setVisible(true);
    			dispose();
    		}
    	}
    }
}

