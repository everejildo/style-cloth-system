package vista;

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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class menuprincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnGProducto;
	private JButton btnGClientes;
	private JButton btnGProveedores;
	private JButton btnConfig;
	private JButton btnRVentas;
	private JButton btnLogOut;
	public static Locale idioma;
	private static ResourceBundle et;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuprincipal frame = new menuprincipal(idioma);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	public menuprincipal(Locale idioma) {
		//Internacionalización
		menuprincipal.idioma=idioma;
		et = ResourceBundle.getBundle("properties/dic", idioma);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMenPrincipal = new JLabel(et.getString("menuprincipal"));
		lblMenPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenPrincipal.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblMenPrincipal.setBounds(10, 71, 935, 40);
		contentPane.add(lblMenPrincipal);

		btnGProducto = new JButton(et.getString("productosmenu"));
		btnGProducto.setIcon(new ImageIcon(menuprincipal.class.getResource("/imagenes/agregar-producto.png")));
		btnGProducto.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnGProducto.setBounds(288, 130, 379, 55);
		contentPane.add(btnGProducto);

		btnGClientes = new JButton(et.getString("clientesmenu"));
		btnGClientes.setIcon(new ImageIcon(menuprincipal.class.getResource("/imagenes/cliente.png")));
		btnGClientes.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnGClientes.setBounds(288, 195, 379, 55);
		contentPane.add(btnGClientes);

		btnRVentas = new JButton(et.getString("ventasmenu"));
		btnRVentas.setIcon(new ImageIcon(menuprincipal.class.getResource("/imagenes/carrito-de-compras.png")));
		btnRVentas.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnRVentas.setBounds(288, 260, 379, 55);
		contentPane.add(btnRVentas);

		btnGProveedores = new JButton(et.getString("proveedoresmenu"));
		btnGProveedores.setIcon(new ImageIcon(menuprincipal.class.getResource("/imagenes/receptor.png")));
		btnGProveedores.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnGProveedores.setBounds(288, 325, 379, 55);
		contentPane.add(btnGProveedores);

		btnConfig = new JButton(et.getString("confmenu"));
		btnConfig.setIcon(new ImageIcon(menuprincipal.class.getResource("/imagenes/engranajes.png")));
		btnConfig.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnConfig.setBounds(288, 390, 379, 55);
		contentPane.add(btnConfig);

		btnLogOut = new JButton(et.getString("logoutmenu"));
		btnLogOut.setIcon(new ImageIcon(menuprincipal.class.getResource("/imagenes/cerrar-sesion.png")));
		btnLogOut.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnLogOut.setBounds(288, 455, 379, 55);
		contentPane.add(btnLogOut);

		JLabel lblNewLabel = new JLabel(et.getString("version"));
		lblNewLabel.setForeground(new Color(128, 128, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(288, 520, 379, 13);
		contentPane.add(lblNewLabel);

		// Manejador
		ManejadorBotones EscuchadorBotones = new ManejadorBotones();

		// Botones
		btnGProducto.addActionListener(EscuchadorBotones);
		btnGClientes.addActionListener(EscuchadorBotones);
		btnRVentas.addActionListener(EscuchadorBotones);
		btnGProveedores.addActionListener(EscuchadorBotones);
		btnConfig.addActionListener(EscuchadorBotones);
		btnLogOut.addActionListener(EscuchadorBotones);
	}

	public class ManejadorBotones implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			if (evento.getSource().equals(btnGProducto)) {
				gestionproductos menuprincipal = new gestionproductos(idioma);
				menuprincipal.setVisible(true);
				dispose();
			}
			if (evento.getSource().equals(btnGClientes)) {
				gestionclientes menuprincipal = new gestionclientes(idioma);
				menuprincipal.setVisible(true);
				dispose();
			}
			if (evento.getSource().equals(btnRVentas)) {
				registroventas menuprincipal = new registroventas(idioma);
				menuprincipal.setVisible(true);
				dispose();
			}
			if (evento.getSource().equals(btnGProveedores)) {
				gestionproveedores menuprincipal = new gestionproveedores(idioma);
				menuprincipal.setVisible(true);
				dispose();
			}
			if (evento.getSource().equals(btnConfig)) {
				configuracion menuprincipal = new configuracion(idioma);
				menuprincipal.setVisible(true);
				dispose();
			}
			if (evento.getSource().equals(btnLogOut)) {
				// agregar splash
				logout menuprincipal = new logout();
				menuprincipal.setVisible(true);
				dispose();
			}
		}

	}
}
