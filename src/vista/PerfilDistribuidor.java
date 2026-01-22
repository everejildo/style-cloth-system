package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador_PerfilDistribuidor;
import modelo.Modelo_Venta;

public class PerfilDistribuidor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton_1;
	private JButton btnNewButton;
	private JTable tabla;
	private Locale Idioma;
	private static ResourceBundle et;
	private DefaultTableModel modeloTablaV2;
	private JTable tablaVentas;

	private JComboBox<String> comboBoxCoperativa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilDistribuidor frame = new PerfilDistribuidor();
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
	public PerfilDistribuidor() {

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
		lblNewLabel.setBounds(226, 29, 176, 13);
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

		JScrollPane scrollPane_Ventas = new JScrollPane((Component) null);
		scrollPane_Ventas.setBounds(50, 190, 590, 240);
		contentPane.add(scrollPane_Ventas);

		modeloTablaV2 = new DefaultTableModel();
		modeloTablaV2
				.setColumnIdentifiers(new String[] { "ID", "Cantidad", "Precio Total", "Cooperativa", "ID Producto" });

		tablaVentas = new JTable();
		tablaVentas.setModel(modeloTablaV2);
		scrollPane_Ventas.setViewportView(tablaVentas);

		JLabel lblNewLabel_1 = new JLabel("");
		//lblNewLabel_1.setIcon(new ImageIcon(PerfilPescador.class.getResource("/Imaggenes/gente (2) (1).png")));
		lblNewLabel_1.setBounds(33, 14, 155, 142);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		//lblNewLabel_2.setIcon(new ImageIcon(PerfilDistribuidor.class.getResource("/Imaggenes/I2bL (2).gif")));
		lblNewLabel_2.setBounds(0, 0, 707, 566);
		contentPane.add(lblNewLabel_2);
		// MANEJADOR
		ManejadorBotones escuchadorBotones = new ManejadorBotones();

		// BOTONES
		btnNewButton_1.addActionListener(escuchadorBotones);
		btnNewButton.addActionListener(escuchadorBotones);
		
		mostrarTablaVentas();
	}

	// CLASE MANEJADOR
	public class ManejadorBotones implements ActionListener {
		public void actionPerformed(ActionEvent eventoBotones) {
			/*
			 * if (eventoBotones.getSource().equals(btnNewButton_1)) { ProveedorVenta
			 * PerfilDistribuidor = new ProveedorVenta();
			 * PerfilDistribuidor.setVisible(true); dispose(); } if
			 * (eventoBotones.getSource().equals(btnNewButton)) { Login2 PerfilDistribuidor
			 * = new Login2(); PerfilDistribuidor.setVisible(true); dispose();
			 */

		}

	}

	private void mostrarTablaVentas() {
		// Limpiar la tabla actual
		modeloTablaV2.setRowCount(0);

		// Obtener clientes del controlador
		List<Modelo_Venta> listaVentas = Controlador_PerfilDistribuidor.tablaVenta();

		// Añadir clientes a la tabla
		for (Modelo_Venta ProveedorVenta : listaVentas) {
			modeloTablaV2.addRow(new Object[] { ProveedorVenta.getIdVenta(), ProveedorVenta.getCantidad(),
					ProveedorVenta.getPrecioTotal(), ProveedorVenta.getCooperativa(), ProveedorVenta.getIdProducto() });
		}
	}

}