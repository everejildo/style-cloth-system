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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controladores.Controlador_Prestamos;
import modelo.Modelo_Prestamos;

public class Prestamos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JTextField textField_Dinero;
	private JTextField textField_Gasolina;
	private JTextField textField_Hielo;
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private JButton btnNewButton_atras;

	private Locale Idioma;
	private static ResourceBundle et;
	private JButton btnNewButton_Pedir;
	private JButton btnNewButton_Cancelar;
	private JButton btnNewButton_Copperativa;
	private JCheckBox chckbxHielo;
	private JCheckBox chckbxGasolina;
	private JCheckBox chckbxCarnada;
	private JComboBox<String> comboBox_Carnada;
	private JComboBox comboBoxCooperativa;
	private JCheckBox chckbxDinero;
	private Controlador_Prestamos controladorPrestamos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prestamos frame = new Prestamos();
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
	public Prestamos() {

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

		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 581);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPrestamos = new JLabel(et.getString("prestamos"));
		lblPrestamos.setForeground(new Color(128, 255, 255));
		lblPrestamos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblPrestamos.setBounds(235, 42, 85, 30);
		contentPane.add(lblPrestamos);

		btnNewButton_Copperativa = new JButton(et.getString("cooperativa"));
		btnNewButton_Copperativa.setBackground(new Color(0, 128, 255));
		btnNewButton_Copperativa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_Copperativa.setBounds(37, 363, 141, 41);
		contentPane.add(btnNewButton_Copperativa);

		comboBoxCooperativa = new JComboBox();
		comboBoxCooperativa.setBackground(new Color(121, 188, 255));
		comboBoxCooperativa.setBounds(37, 414, 141, 21);
		contentPane.add(comboBoxCooperativa);

		btnNewButton_Copperativa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Llenar el ComboBox con productos de Cooperativa
				comboBoxCooperativa.removeAllItems(); // Limpiar items existentes
				comboBoxCooperativa.addItem("Los changos");
				comboBoxCooperativa.addItem("Islote del Mero");
				comboBoxCooperativa.addItem("3 Yacos");
			}
		});

		btnNewButton_Pedir = new JButton(et.getString("pedir"));
		btnNewButton_Pedir.setBackground(new Color(121, 188, 255));
		btnNewButton_Pedir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_Pedir.setBounds(37, 507, 103, 21);
		contentPane.add(btnNewButton_Pedir);

		btnNewButton_Cancelar = new JButton(et.getString("cancelar"));
		btnNewButton_Cancelar.setBackground(new Color(121, 188, 255));
		btnNewButton_Cancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_Cancelar.setBounds(559, 508, 105, 21);
		contentPane.add(btnNewButton_Cancelar);
		
		// Aquí va el nuevo ActionListener para btnCancelar
		btnNewButton_Cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpiar los campos de texto
            	textField_Hielo.setText("");
            	textField_Gasolina.setText("");
            	textField_Dinero.setText("");

                // Deseleccionar los checkboxes
            	chckbxHielo.setSelected(false);
            	chckbxGasolina.setSelected(false);
            	chckbxDinero.setSelected(false);
            	chckbxCarnada.setSelected(false);

                // Vaciar los combo boxes
            	comboBox_Carnada.removeAllItems();
                comboBoxCooperativa.removeAllItems();

                // Mostrar un mensaje confirmando la cancelación
                JOptionPane.showMessageDialog(null, "Venta cancelada y todos los datos han sido borrados.");
            }
        });

		btnNewButton_atras = new JButton(et.getString("atras"));
		btnNewButton_atras.setBackground(new Color(121, 188, 255));
		btnNewButton_atras.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_atras.setBounds(541, 36, 105, 21);
		contentPane.add(btnNewButton_atras);

		JLabel lblNewLabel_imagen = new JLabel(et.getString("imagen"));
		lblNewLabel_imagen.setIcon(new ImageIcon(Prestamos.class.getResource("/Imaggenes/gente (2) (1).png")));
		lblNewLabel_imagen.setBounds(25, 23, 152, 148);
		contentPane.add(lblNewLabel_imagen);

		chckbxHielo = new JCheckBox(et.getString("hielokg"));
		chckbxHielo.setBackground(new Color(0, 128, 255));
		chckbxHielo.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxHielo.setBounds(46, 250, 93, 36);
		contentPane.add(chckbxHielo);

		textField_Hielo = new JTextField();
		textField_Hielo.setBackground(new Color(202, 228, 255));
		textField_Hielo.setBounds(145, 250, 96, 36);
		contentPane.add(textField_Hielo);
		textField_Hielo.setColumns(10);

		textField_Hielo.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					e.consume(); // Evita que se escriban caracteres no numéricos
				}
			}
		});

		chckbxGasolina = new JCheckBox(et.getString("gasolina"));
		chckbxGasolina.setBackground(new Color(0, 128, 255));
		chckbxGasolina.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxGasolina.setBounds(265, 250, 103, 36);
		contentPane.add(chckbxGasolina);

		textField_Gasolina = new JTextField();
		textField_Gasolina.setBackground(new Color(202, 228, 255));
		textField_Gasolina.setBounds(395, 252, 96, 36);
		contentPane.add(textField_Gasolina);
		textField_Gasolina.setColumns(10);

		textField_Gasolina.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					e.consume(); // Evita que se escriban caracteres no numéricos
				}
			}
		});

		chckbxCarnada = new JCheckBox(et.getString("carnada"));
		chckbxCarnada.setBackground(new Color(0, 128, 255));
		chckbxCarnada.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		chckbxCarnada.setBounds(523, 250, 141, 36);
		contentPane.add(chckbxCarnada);

		comboBox_Carnada = new JComboBox<>();
		comboBox_Carnada.setBackground(new Color(121, 188, 255));
		comboBox_Carnada.setBounds(523, 292, 141, 21);
		contentPane.add(comboBox_Carnada);

		chckbxCarnada.addActionListener(e -> {
			if (chckbxCarnada.isSelected()) {
				comboBox_Carnada.addItem("Camaron");
				comboBox_Carnada.addItem("Jaiba");
				comboBox_Carnada.addItem("Pescado");
			} else {
				comboBox_Carnada.removeAllItems();
			}
		});

		chckbxDinero = new JCheckBox(et.getString("dinero"));
		chckbxDinero.setBackground(new Color(0, 128, 255));
		chckbxDinero.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxDinero.setBounds(265, 403, 103, 41);
		contentPane.add(chckbxDinero);

		textField_Dinero = new JTextField();
		textField_Dinero.setBackground(new Color(202, 228, 255));
		textField_Dinero.setBounds(395, 404, 96, 41);
		contentPane.add(textField_Dinero);
		textField_Dinero.setColumns(10);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Prestamos.class.getResource("/Imaggenes/I2bL (2).gif")));
		lblNewLabel.setBounds(0, 0, 699, 544);
		contentPane.add(lblNewLabel);

		textField_Dinero.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					e.consume(); // Evita que se escriban caracteres no numéricos
				}
			}
		});

		// MANEJADOR
		ManejadorBotones escuchadorBotones = new ManejadorBotones();

		// BOTONES
		btnNewButton_atras.addActionListener(escuchadorBotones);

		// Agregar ActionListener a los botones "Pedir" y "Cancelar"
		btnNewButton_Pedir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarPrestamo();
				
			}
			
		});

		btnNewButton_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Préstamo cancelado");
			}
		});
		
		controladorPrestamos = new Controlador_Prestamos();
	}

	protected void registrarPrestamo() {
		//System.out.println("Entró al método");
		try {
			//System.out.println("try/catch");
	    	// Verificar que haya un producto y una cooperativa seleccionados
	        if (comboBoxCooperativa.getSelectedItem() == null) {
	            JOptionPane.showMessageDialog(null, "Por favor selecciona un producto y una cooperativa.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	        if (chckbxHielo.isSelected()) {
        	    // Si el checkbox está seleccionado, validamos el JTextField
        	    if (textField_Hielo.getText().isEmpty()) {
        	        JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor para el hielo.");
        	    }
        	}
        	if (chckbxGasolina.isSelected()) {
        	    // Si el checkbox está seleccionado, validamos el JTextField
        	    if (textField_Gasolina.getText().isEmpty()) {
        	        JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor para la gasolina.");
        	    }
        	}
        	if (chckbxDinero.isSelected()) {
        	    // Si el checkbox está seleccionado, validamos el JTextField
        	    if (textField_Dinero.getText().isEmpty()) {
        	        JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor para el dinero.");
        	    }
        	}
        	if (chckbxCarnada.isSelected()) {
        	    // Si el checkbox está seleccionado, validamos el JTextField
        	    if (comboBoxCooperativa.getSelectedItem() == null) {
        	        JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor para un valor para la carnada.");
        	    }
        	}
        	System.out.println("Validó todos los campos");
	        
	        String hielo = textField_Hielo.getText();
	        //System.out.println("Hielo: "+hielo);
	        String gasolina = textField_Gasolina.getText();
	        //System.out.println("Gasolina: "+gasolina);
	        String cooperativa = comboBoxCooperativa.getSelectedItem().toString();
	        //System.out.println("Cooperativa: "+cooperativa);
	        String carnada = comboBox_Carnada.getSelectedItem().toString();
	        //System.out.println("Carnada: "+carnada);
	        double dinero = Double.parseDouble(textField_Dinero.getText());
	        //System.out.println("Dinero: "+dinero);

	        Modelo_Prestamos Prestamos = new Modelo_Prestamos( hielo, gasolina, carnada, cooperativa, dinero);
	        controladorPrestamos.crearPrestamo(Prestamos);
	    	} catch (NumberFormatException e) {
	            // Mostrar mensajes de error si ocurre una excepción de formato numérico
	            JOptionPane.showMessageDialog(null, "Por favor ingresa valores numéricos válidos para las cantidades y el dinero.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	}

	// CLASE MANEJADOR
	public class ManejadorBotones implements ActionListener {
		public void actionPerformed(ActionEvent eventoBotones) {
			
			 if (eventoBotones.getSource().equals(btnNewButton_atras)) { 
			  Menu Prestamos = new Menu(); 
			  Prestamos.setVisible(true); 
			  dispose(); }
			 
		}

		public void NumberForma(NumberFormatException e1) {

			JOptionPane.showMessageDialog(null,
					"Por favor ingresa valores numéricos válidos para las cantidades y el dinero.", "Error",
					JOptionPane.ERROR_MESSAGE);

			JOptionPane.showMessageDialog(null, "Por favor selecciona unacarnada y una cooperativa.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}