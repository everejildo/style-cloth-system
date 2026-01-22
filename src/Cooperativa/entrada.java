package Cooperativa;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class entrada extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnEDistribuidor;
	private JButton btnEPescador;
	
	private Locale Idioma;
	private static ResourceBundle et;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					entrada frame = new entrada();
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
	public entrada() {
		
		
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
	
	
	
		setBackground(new Color(128, 128, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 574);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(entrada.class.getResource("/Imaggenes/gente (1).png")));
		lblNewLabel_1.setBounds(257, 28, 182, 189);
		contentPane.add(lblNewLabel_1);
		
		btnEPescador = new JButton(et.getString("entrarcomopescador"));
		btnEPescador.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnEPescador.setBackground(new Color(213, 238, 249));
		btnEPescador.setBounds(48, 275, 271, 96);
		contentPane.add(btnEPescador);
		
		btnEDistribuidor = new JButton(et.getString("entrarcomodistribuidor"));
		btnEDistribuidor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnEDistribuidor.setBackground(new Color(213, 238, 249));
		btnEDistribuidor.setBounds(366, 275, 271, 96);
		contentPane.add(btnEDistribuidor);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(entrada.class.getResource("/Imaggenes/524e5b556e4cff3fe16ae8ab7cfd696b (1).gif")));
		lblNewLabel.setBounds(0, -12, 706, 553);
		contentPane.add(lblNewLabel);
		
		
		 // MANEJADOR
        ManejadorBotones escuchadorBotones = new ManejadorBotones();

        // BOTONES
        btnEPescador.addActionListener(escuchadorBotones);
        btnEDistribuidor.addActionListener(escuchadorBotones);
    }

    // CLASE MANEJADOR
    public class ManejadorBotones implements ActionListener {
        public void actionPerformed(ActionEvent eventoBotones) {
            if (eventoBotones.getSource().equals(btnEPescador)) {
                Login entrada = new Login();
                entrada.setVisible(true);
                dispose();
            }
            
            if (eventoBotones.getSource().equals(btnEDistribuidor)) {
                Login2 entrada2 = new Login2();
				entrada2.setVisible(true);
                dispose();
            
        }
        
        
    }
}
}
		
	


	

