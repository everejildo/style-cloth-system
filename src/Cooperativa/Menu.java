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
import javax.swing.border.EmptyBorder;

import Controladores.Controlador_Registro;
import Cooperativa.Registro.ManejadorBotones;

import javax.swing.ImageIcon;

public class Menu extends JFrame {
	private JButton btnNewButton_Reg;
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton_p;
	
	private JButton btnNewButton_1;
	private JButton btnNewButton_V;
	private JButton btnNewButton_Res;
	private JButton btnNewButton_Regresar;
	private JButton btnNewButton_PP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
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
		
		btnNewButton_Reg = new JButton("Registrar y  Modificar (P).");
		btnNewButton_Reg.setForeground(new Color(0, 128, 192));
		btnNewButton_Reg.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_Reg.setBackground(new Color(0, 255, 255));
		btnNewButton_Reg.setBounds(38, 81, 237, 59);
		contentPane.add(btnNewButton_Reg);
		
		
		
	
		
		btnNewButton_1 = new JButton("Prestamos.");
		btnNewButton_1.setBounds(38, 201, 237, 59);
		btnNewButton_1.setForeground(new Color(0, 128, 192));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBackground(new Color(0, 255, 255));
		contentPane.add(btnNewButton_1);
		
		btnNewButton_V = new JButton("Venta.");
		btnNewButton_V.setBounds(328, 201, 245, 59);
		btnNewButton_V.setForeground(new Color(0, 128, 192));
		btnNewButton_V.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_V.setBackground(new Color(0, 255, 255));
		contentPane.add(btnNewButton_V);
		
		btnNewButton_Res = new JButton("Respaldo");
		btnNewButton_Res.setBounds(38, 305, 237, 59);
		btnNewButton_Res.setForeground(new Color(0, 128, 192));
		btnNewButton_Res.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_Res.setBackground(new Color(0, 255, 255));
		contentPane.add(btnNewButton_Res);
		
		btnNewButton_Regresar = new JButton("Regresar");
		btnNewButton_Regresar.setBounds(468, 31, 105, 21);
		btnNewButton_Regresar.setForeground(new Color(0, 128, 192));
		btnNewButton_Regresar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_Regresar.setBackground(new Color(0, 255, 255));
		contentPane.add(btnNewButton_Regresar);
		
		btnNewButton_PP = new JButton("Perfil Pescador");
		btnNewButton_PP.setBounds(338, 81, 235, 59);
		btnNewButton_PP.setForeground(new Color(0, 128, 192));
		btnNewButton_PP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_PP.setBackground(new Color(0, 255, 255));
		contentPane.add(btnNewButton_PP);
		
		
		// MANEJADOR
				ManejadorBotones escuchadorBotones = new ManejadorBotones();

				// BOTONES
				
				btnNewButton_Reg.addActionListener(escuchadorBotones);
				btnNewButton_1.addActionListener(escuchadorBotones);
				btnNewButton_Res.addActionListener(escuchadorBotones);
				btnNewButton_V.addActionListener(escuchadorBotones);
				btnNewButton_Regresar.addActionListener(escuchadorBotones);
				btnNewButton_PP.addActionListener(escuchadorBotones);
				
				
				

			}

			// CLASE MANEJADOR
			public class ManejadorBotones implements ActionListener {
				public void actionPerformed(ActionEvent eventoBotones) {
					if (eventoBotones.getSource().equals(btnNewButton_Reg)) {
						Registro Menu = new Registro();
						Menu.setVisible(true);
						dispose();
					}
					
					if (eventoBotones.getSource().equals(btnNewButton_1)) {
							Prestamos  Menu = new Prestamos();
							Menu.setVisible(true);
							dispose();
					}
				
				   if (eventoBotones.getSource().equals(btnNewButton_Res)) {
						respaldo1  Menu = new respaldo1();
						Menu.setVisible(true);
						dispose();
				   }
						
				   if (eventoBotones.getSource().equals(btnNewButton_V)) {
							venta  Menu = new venta();
							Menu.setVisible(true);
							dispose();
				  
				   }
					
				   if (eventoBotones.getSource().equals(btnNewButton_Regresar)) {
							Login  Menu = new Login();
							Menu.setVisible(true);
							dispose();
				   }
					
				   if (eventoBotones.getSource().equals(btnNewButton_PP)) {
							PerfilPescador  Menu = new PerfilPescador();
							Menu.setVisible(true);
							dispose();
				  
					
				}
        
    }
			}
			
}

