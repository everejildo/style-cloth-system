package otrasvistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btndivision;
	private JButton btn5;
	private JButton btn6;
	private JButton btnmult;
	private JButton btn8;
	private JButton btn7;
	private JButton btn9;
	private JButton btnc;
	private JButton btnborrar;
	private JButton btn0;
	private JButton btnsuma;
	private JTextField pantalle;
	private JButton btnpunto;
	private JButton btnigual;
	private String ValorP;
	private JButton btn4;
	private JButton btnresta;
	private String valor1;
	private String valor2;
	private double resultado;
	private boolean bsuma;
	private boolean bresta;
	private boolean bdivison;
	private boolean bmult;
	private boolean bborrar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the frame.

	public Calculadora() {
		
		// Validacion de variables de apoyo
		bsuma = false;
		bresta = false;
		bdivison = false;
		bmult = false;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btn1 = new JButton("1");
		btn1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn1.setActionCommand("1");
		btn1.setBounds(28, 110, 85, 40);
		contentPane.add(btn1);

		btn2 = new JButton("2");
		btn2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn2.setBounds(124, 110, 85, 40);
		contentPane.add(btn2);

		btn3 = new JButton("3");
		btn3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn3.setBounds(219, 110, 85, 40);
		contentPane.add(btn3);

		btndivision = new JButton("÷");
		btndivision.setFont(new Font("Tahoma", Font.BOLD, 14));
		btndivision.setBounds(314, 110, 85, 40);
		contentPane.add(btndivision);

		btn4 = new JButton("4");
		btn4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn4.setBounds(28, 160, 85, 40);
		contentPane.add(btn4);

		btn5 = new JButton("5");
		btn5.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn5.setBounds(124, 160, 85, 40);
		contentPane.add(btn5);

		btn6 = new JButton("6");
		btn6.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn6.setBounds(219, 160, 85, 40);
		contentPane.add(btn6);

		btnmult = new JButton("x");
		btnmult.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnmult.setBounds(314, 160, 85, 40);
		contentPane.add(btnmult);

		btn7 = new JButton("New button");
		btn7.setBounds(28, 179, 85, 21);
		contentPane.add(btn7);

		btn8 = new JButton("8");
		btn8.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn8.setBounds(124, 210, 85, 40);
		contentPane.add(btn8);

		btn9 = new JButton("9");
		btn9.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn9.setBounds(219, 210, 85, 40);
		contentPane.add(btn9);

		btnresta = new JButton("-");
		btnresta.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnresta.setBounds(314, 210, 85, 40);
		contentPane.add(btnresta);

		btnc = new JButton("7");
		btnc.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnc.setBounds(28, 210, 85, 40);
		contentPane.add(btnc);

		btnborrar = new JButton("C");
		btnborrar.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnborrar.setBounds(28, 260, 39, 40);
		contentPane.add(btnborrar);

		btn0 = new JButton("0");
		btn0.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn0.setBounds(124, 261, 85, 40);
		contentPane.add(btn0);

		btnsuma = new JButton("+");
		btnsuma.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnsuma.setBounds(314, 260, 85, 40);
		contentPane.add(btnsuma);

		btnigual = new JButton("=");
		btnigual.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnigual.setBounds(219, 261, 85, 40);
		contentPane.add(btnigual);

		btnpunto = new JButton("•");
		btnpunto.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnpunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnpunto.setBounds(74, 261, 39, 39);
		contentPane.add(btnpunto);

		pantalle = new JTextField();
		pantalle.setEditable(false);
		pantalle.setHorizontalAlignment(SwingConstants.RIGHT);
		pantalle.setBounds(28, 21, 371, 78);
		contentPane.add(pantalle);
		pantalle.setColumns(10);

		// Inicializo el escuchador para los botones
		ManejadorBotones EscuchadorBotones = new ManejadorBotones();
		btn1.addActionListener(EscuchadorBotones);
		btn2.addActionListener(EscuchadorBotones);
		btn3.addActionListener(EscuchadorBotones);
		btn4.addActionListener(EscuchadorBotones);
		btn5.addActionListener(EscuchadorBotones);
		btn6.addActionListener(EscuchadorBotones);
		btn7.addActionListener(EscuchadorBotones);
		btn8.addActionListener(EscuchadorBotones);
		btn9.addActionListener(EscuchadorBotones);
		btn0.addActionListener(EscuchadorBotones);
		btnsuma.addActionListener(EscuchadorBotones);
		btnresta.addActionListener(EscuchadorBotones);
		btnmult.addActionListener(EscuchadorBotones);
		btndivision.addActionListener(EscuchadorBotones);
		btnpunto.addActionListener(EscuchadorBotones);
		btnigual.addActionListener(EscuchadorBotones);
		btnborrar.addActionListener(EscuchadorBotones);
		
		// Inicializo el
	}

	private class ManejadorBotones implements ActionListener {

		public void actionPerformed(ActionEvent EventoBotones) {
			
			if (EventoBotones.getSource().equals(btn1)) {
				ValorP = pantalle.getText().trim() + "1";
				pantalle.setText(ValorP);
			}
			if (EventoBotones.getSource().equals(btn2)) {
				ValorP = pantalle.getText().trim() + "2";
				pantalle.setText(ValorP);
			}
			if (EventoBotones.getSource().equals(btn3)) {
				ValorP = pantalle.getText().trim() + "3";
				pantalle.setText(ValorP);
			}
			if (EventoBotones.getSource().equals(btn4)) {
				ValorP = pantalle.getText().trim() + "4";
				pantalle.setText(ValorP);
			}
			if (EventoBotones.getSource().equals(btn5)) {
				ValorP = pantalle.getText().trim() + "5";
				pantalle.setText(ValorP);
			}
			if (EventoBotones.getSource().equals(btn6)) {
				ValorP = pantalle.getText().trim() + "6";
				pantalle.setText(ValorP);
			}
			if (EventoBotones.getSource().equals(btn7)) {
				ValorP = pantalle.getText().trim() + "7";
				pantalle.setText(ValorP);
			}
			if (EventoBotones.getSource().equals(btn8)) {
				ValorP = pantalle.getText().trim() + "8";
				pantalle.setText(ValorP);
			}
			if (EventoBotones.getSource().equals(btn9)) {
				ValorP = pantalle.getText().trim() + "9";
				pantalle.setText(ValorP);
			}
			if (EventoBotones.getSource().equals(btn0)) {
				ValorP = pantalle.getText().trim() + "0";
				pantalle.setText(ValorP);
			}
			if (EventoBotones.getSource().equals(btnpunto)) {
				if(pantalle.getText().indexOf(".") == -1) {
				ValorP = pantalle.getText().trim() + ".";
				pantalle.setText(ValorP);
				//pantalle.setText(".");
				}
			}
			if (EventoBotones.getSource().equals(btnborrar)) {
				//Limpiar pantalla
				pantalle.setText("");
			}
		// OPERACIONES
			//  BOTON SUMA
			if (EventoBotones.getSource().equals(btnsuma)) {
				valor1 = pantalle.getText();
				pantalle.setText("");
				bsuma = true;
				bresta = false;
				bdivison = false;
				bmult = false;
			}
			// BOTON RESTA
			if (EventoBotones.getSource().equals(btnresta)) {
				valor1 = pantalle.getText();
				pantalle.setText("");
				bsuma = false;
				bresta = true;
				bdivison = false;
				bmult = false;
			}
			// BOTON MULTIPLICACIÓN
			if (EventoBotones.getSource().equals(btnmult)) {
				valor1 = pantalle.getText();
				pantalle.setText("");
				bsuma = false;
				bresta = false;
				bdivison = false;
				bmult = true;
			}
			// BOTON DIVISION
			if (EventoBotones.getSource().equals(btndivision)) {
				valor1 = pantalle.getText();
				pantalle.setText("");
				bsuma = false;
				bresta = false;
				bdivison = true;
				bmult = false;
			}
			// BOTON IGUAL
			if (EventoBotones.getSource().equals(btnigual)) {
				// RESULTADO SUMA
				if (bsuma==true) {
					resultado = Double.parseDouble(valor1) + Double.parseDouble(pantalle.getText());
					pantalle.setText(Double.toString(resultado));
					bsuma = false;
					bresta = false;
					bdivison = false;
					bmult = false;
				}
				// RESULTADO RESTA
				if (bresta==true) {
					resultado = Double.parseDouble(valor1) - Double.parseDouble(pantalle.getText());
					pantalle.setText(Double.toString(resultado));
					bsuma = false;
					bresta = false;
					bdivison = false;
					bmult = false;
				}
				// RESULTADO MULTIPLICACIÓN
				if (bmult==true) {
					resultado = Double.parseDouble(valor1) * Double.parseDouble(pantalle.getText());
					pantalle.setText(Double.toString(resultado));
					bsuma = false;
					bresta = false;
					bdivison = false;
					bmult = false;
				}
				// RESULTADO DIVISION
				if (bdivison==true) {
					resultado = Double.parseDouble(valor1) / Double.parseDouble(pantalle.getText());
					pantalle.setText(Double.toString(resultado));
					bsuma = false;
					bresta = false;
					bdivison = false;
					bmult = false;
				}
			}
		}
	}
}
