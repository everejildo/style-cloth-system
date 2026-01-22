package Cooperativa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import Cooperativa.Login.ManejadorBotones;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.ImageIcon;

import java.util.Locale;


public class proveedor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton_1;
	private JButton btnNewButton;
	
	private Locale Idioma;
	private static ResourceBundle et;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JCheckBox chckbxNewCheckBox;
	private JComboBox<String> comboBoxCoperativa;
	private JTextPane textPane;
	private JTextPane textPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					proveedor frame = new proveedor();
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
	public proveedor() {
		
		
		
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
	        setBounds(100, 100, 717, 549);
	        contentPane = new JPanel();
	        contentPane.setBackground(new Color(128, 255, 128));
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	        setContentPane(contentPane);
	        contentPane.setLayout(null);
	        
	        JLabel lblNewLabel = new JLabel(et.getString("perfildistribuidor"));
	        lblNewLabel.setForeground(new Color(0, 64, 128));
	        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	        lblNewLabel.setBounds(226, 29, 132, 13);
	        contentPane.add(lblNewLabel);
	        
	        btnNewButton = new JButton(et.getString("cerrarsesión"));
	        btnNewButton.setBackground(new Color(136, 196, 255));
	        btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
	        btnNewButton.setBounds(570, 10, 105, 21);
	        contentPane.add(btnNewButton);
	        
	        btnNewButton_1 = new JButton(et.getString("vender"));
	        btnNewButton_1.setBackground(new Color(136, 196, 255));
	        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
	        btnNewButton_1.setBounds(55, 481, 114, 21);
	        contentPane.add(btnNewButton_1);
	        
	        btnNewButton_2 = new JButton(et.getString("ventas"));
	        btnNewButton_2.setBackground(new Color(0, 128, 255));
	        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
	        btnNewButton_2.setBounds(37, 188, 132, 32);
	        contentPane.add(btnNewButton_2);
	        
	        btnNewButton_3 = new JButton(et.getString("productos"));
	        btnNewButton_3.setBackground(new Color(0, 128, 255));
	        btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
	        btnNewButton_3.setBounds(291, 188, 139, 32);
	        contentPane.add(btnNewButton_3);
	        
	        chckbxNewCheckBox = new JCheckBox(et.getString("cooperativa"));
	        chckbxNewCheckBox.setBackground(new Color(0, 128, 255));
			chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
			chckbxNewCheckBox.setBounds(543, 188, 132, 32);
			contentPane.add(chckbxNewCheckBox);
			
			comboBoxCoperativa = new JComboBox<>();
			comboBoxCoperativa.setBackground(new Color(198, 226, 255));
	        comboBoxCoperativa.setBounds(537, 228, 143, 30);
	        contentPane.add(comboBoxCoperativa);
	        
	        chckbxNewCheckBox.addActionListener(e -> {
	            if (chckbxNewCheckBox.isSelected()) {
	                comboBoxCoperativa.addItem("Los changos");
	                comboBoxCoperativa.addItem("Islote del Mero");
	                comboBoxCoperativa.addItem("3 Yacos");
	            } else {
	                comboBoxCoperativa.removeAllItems();
	            }
	        });
			
	        
	        textPane = new JTextPane();
	        textPane.setBackground(new Color(198, 226, 255));
	        textPane.setBounds(37, 243, 132, 151);
	        contentPane.add(textPane);
	        
	        
	        textPane_1 = new JTextPane();
	        textPane_1.setBackground(new Color(198, 226, 255));
	        textPane_1.setBounds(291, 243, 139, 151);
	        contentPane.add(textPane_1);
	        
	      
	        
	        JLabel lblNewLabel_1 = 
	        		new JLabel("");
	        lblNewLabel_1.setIcon(new ImageIcon(PerfilPescador.class.getResource("/Imaggenes/gente (2) (1).png")));
	        lblNewLabel_1.setBounds(33, 14, 155, 142);
	        contentPane.add(lblNewLabel_1);
	        
	        JLabel lblNewLabel_2 = new JLabel("");
	        lblNewLabel_2.setIcon(new ImageIcon(proveedor.class.getResource("/Imaggenes/I2bL (2).gif")));
	        lblNewLabel_2.setBounds(0, 0, 707, 566);
	        contentPane.add(lblNewLabel_2);
	        
	        // Añadir ActionListener al botón "Ventas"
	        btnNewButton_2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Aquí puedes agregar el código para obtener información de ventas y mostrarla en el textPane
	                String ventasInfo = "Venta 1: Producto A\nVenta 2: Producto B\nVenta 3: Producto C";
	                textPane.setText(ventasInfo);
	                
	                
	            }
	        });
	     // Añadir ActionListener al botón "Productos"
	        btnNewButton_3.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Aquí puedes agregar el código para obtener información de productos vendidos y mostrarla en el textPane
	                String productosInfo = "Productos:\n\n";
	                productosInfo += "Camaron\n";
	                productosInfo += "Pescado\n";
	                productosInfo += "Jaiba\n";
	                productosInfo += "Caracol";
	                textPane_1.setText(productosInfo);
	            }
	        });
	     // MANEJADOR
	        ManejadorBotones escuchadorBotones = new ManejadorBotones();

	        // BOTONES
	        btnNewButton_1.addActionListener(escuchadorBotones);
	        btnNewButton.addActionListener(escuchadorBotones);
	        
	    }

	    // CLASE MANEJADOR
	    public class ManejadorBotones implements ActionListener {
	        public void actionPerformed(ActionEvent eventoBotones) {
	            if (eventoBotones.getSource().equals(btnNewButton_1)) {
	                ProveedorVenta proveedor = new ProveedorVenta();
	                proveedor.setVisible(true);
	                dispose();
	            }
	            if (eventoBotones.getSource().equals(btnNewButton)) {
	                Login2 proveedor = new Login2();
	                proveedor.setVisible(true);
	                dispose();
	            
	        }
			
		}
	    }
	}