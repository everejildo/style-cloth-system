package Cooperativa;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Cooperativa.Menu.ManejadorBotones;

import javax.swing.JLabel;
import javax.swing.JButton;

public class Menu2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton_V;
	private JButton btnNewButton_R;
	private JButton btnNewButton_P;
	private JButton btnNewButton_Pr;
	private JButton btnNewButton_Rs;
	private JButton btnNewButton_Regresar;
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu2 frame = new Menu2();
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
	public Menu2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setForeground(new Color(0, 64, 128));
		lblNewLabel.setBounds(10, 10, 71, 27);
		contentPane.add(lblNewLabel);
		
		btnNewButton_R = new JButton("Registrar y  Modificar (D).");
		btnNewButton_R.setForeground(new Color(0, 128, 192));
		btnNewButton_R.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_R.setBackground(new Color(0, 255, 255));
		btnNewButton_R.setBounds(38, 81, 237, 59);
		contentPane.add(btnNewButton_R);
		
		
		
		btnNewButton_P = new JButton("Perfil Distribuidor.");
		btnNewButton_P.setBounds(328, 81, 237, 59);
		btnNewButton_P.setForeground(new Color(0, 128, 128));
		btnNewButton_P.setBackground(new Color(0, 255, 255));
		btnNewButton_P.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnNewButton_P);
		
		
		
		btnNewButton_V = new JButton("Venta.");
		btnNewButton_V.setBounds(328, 201, 245, 59);
		btnNewButton_V.setForeground(new Color(0, 128, 192));
		btnNewButton_V.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_V.setBackground(new Color(0, 255, 255));
		contentPane.add(btnNewButton_V);
		
		btnNewButton_Rs = new JButton("Respaldo");
		btnNewButton_Rs.setBounds(38, 201, 237, 59);
		btnNewButton_Rs.setForeground(new Color(0, 128, 192));
		btnNewButton_Rs.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_Rs.setBackground(new Color(0, 255, 255));
		contentPane.add(btnNewButton_Rs);
		
		btnNewButton_Regresar = new JButton("Regresar");
		btnNewButton_Regresar.setBounds(462, 16, 103, 21);
		btnNewButton_Regresar.setForeground(new Color(0, 128, 192));
		btnNewButton_Regresar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_Regresar.setBackground(new Color(0, 255, 255));
		contentPane.add(btnNewButton_Regresar);
		
		

		// MANEJADOR
				ManejadorBotones escuchadorBotones = new ManejadorBotones();

				// BOTONES
				
				btnNewButton_R.addActionListener(escuchadorBotones);
				
				btnNewButton_Rs.addActionListener(escuchadorBotones);
				btnNewButton_V.addActionListener(escuchadorBotones);
				btnNewButton_Regresar.addActionListener(escuchadorBotones);
				btnNewButton_P.addActionListener(escuchadorBotones);
				
				
				

			}

			// CLASE MANEJADOR
			public class ManejadorBotones implements ActionListener {
				public void actionPerformed(ActionEvent eventoBotones) {
					if (eventoBotones.getSource().equals(btnNewButton_R)) {
						RegistroDis Menu = new RegistroDis();
						Menu.setVisible(true);
						dispose();
					}
					
				
				   if (eventoBotones.getSource().equals(btnNewButton_Rs)) {
						respaldo1  Menu = new respaldo1();
						Menu.setVisible(true);
						dispose();
				   }
						
				   if (eventoBotones.getSource().equals(btnNewButton_V)) {
							ProveedorVenta  Menu = new ProveedorVenta();
							Menu.setVisible(true);
							dispose();
				  
				   }
					
				   if (eventoBotones.getSource().equals(btnNewButton_Regresar)) {
							Login2  Menu = new Login2();
							Menu.setVisible(true);
							dispose();
				   }
					
				   if (eventoBotones.getSource().equals(btnNewButton_P)) {
							PerfilDistribuidor  Menu = new PerfilDistribuidor();
							Menu.setVisible(true);
							dispose();
				  
					
				}
        
    }
			}
			

        
    }


