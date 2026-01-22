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
import Controladores.Controlador_Repaldo;

public class respaldo1 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField_ruta;   // Campo para la ruta del respaldo

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    respaldo1 frame = new respaldo1();
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
    public respaldo1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 365, 531);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        // Campo de texto para la ruta del respaldo
        textField_ruta = new JTextField();
        textField_ruta.setBackground(new Color(192, 192, 192));
        textField_ruta.setBounds(72, 216, 204, 31);
        contentPane.add(textField_ruta);
        textField_ruta.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Ruta del Respaldo");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1.setBounds(72, 193, 150, 13);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("SQL");
        lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
        lblNewLabel_2.setBounds(155, 33, 90, 44);
        contentPane.add(lblNewLabel_2);
        
        JButton btnNewButton_Respaldo = new JButton("Respaldar");
        btnNewButton_Respaldo.setBackground(new Color(255, 128, 128));
        btnNewButton_Respaldo.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton_Respaldo.setBounds(124, 294, 121, 44);
        contentPane.add(btnNewButton_Respaldo);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(respaldo1.class.getResource("/Imaggenes/SQL (3).gif")));
        lblNewLabel_3.setBounds(0, 0, 351, 494);
        contentPane.add(lblNewLabel_3);
        
        JButton btnNewButton_Atras = new JButton("Atras");
        btnNewButton_Atras.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton_Atras.setBackground(new Color(255, 128, 128));
        btnNewButton_Atras.setBounds(0, 10, 85, 21);
        contentPane.add(btnNewButton_Atras);
        
        

        // Acción del botón para hacer el respaldo
        btnNewButton_Respaldo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	realizarBackup();
            }
        });
    }

    private void realizarBackup() {
		String ruta = textField_ruta.getText();  // Obtener la ruta del JTextField
		Controlador_Repaldo controladorRespaldo = new Controlador_Repaldo();
	    controladorRespaldo.execPA(ruta);  // Pasar la ruta al procedimiento almacenado  
	    
	}

}