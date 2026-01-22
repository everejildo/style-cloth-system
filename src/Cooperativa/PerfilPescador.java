package Cooperativa;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controladores.Controlador_PerfilPescador;
import modelo.Modelo_Prestamos;
import modelo.Modelo_Venta;

public class PerfilPescador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton_Vender;
	private JButton btnNewButton_Prestamo;
	private DefaultTableModel modeloTablaP;
	private JTable tablaPrestamos;
	private DefaultTableModel modeloTablaV;
	private JTable tablaVentas;
	private JButton btnCerrar;
	private JTable tabla;
	private Locale Idioma;
	private static ResourceBundle et;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilPescador frame = new PerfilPescador();
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
	public PerfilPescador() {
		Idioma = Locale.getDefault();

		// Ahora en ingles americano
		// Idioma = new Locale("en","US");
		Idioma = new Locale("es", "MX");
		et = ResourceBundle.getBundle("properties/dic", Idioma);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 574);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(et.getString("perfilpescador"));
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBackground(new Color(213, 238, 249));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(226, 29, 132, 13);
		contentPane.add(lblNewLabel);

		btnCerrar = new JButton(et.getString("regresar"));
		btnCerrar.setBackground(new Color(0, 128, 255));
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		btnCerrar.setBounds(570, 10, 105, 21);
		contentPane.add(btnCerrar);

		btnNewButton_Vender = new JButton(et.getString("vender"));
		btnNewButton_Vender.setBackground(new Color(0, 128, 255));
		btnNewButton_Vender.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_Vender.setBounds(37, 494, 113, 21);
		contentPane.add(btnNewButton_Vender);

		btnNewButton_Prestamo = new JButton(et.getString("prestamo"));
		btnNewButton_Prestamo.setBackground(new Color(0, 128, 255));
		btnNewButton_Prestamo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_Prestamo.setBounds(533, 494, 132, 21);
		contentPane.add(btnNewButton_Prestamo);

		JScrollPane scrollPane_Prestamos = new JScrollPane(tabla);
		scrollPane_Prestamos.setBounds(37, 189, 610, 133);
		contentPane.add(scrollPane_Prestamos);

		modeloTablaP = new DefaultTableModel();
		modeloTablaP
				.setColumnIdentifiers(new String[] { "ID", "Cooperativa", "Gasolina", "Hielo", "Carnada", "Dinero" });

		tablaPrestamos = new JTable();
		tablaPrestamos.setModel(modeloTablaP);
		scrollPane_Prestamos.setViewportView(tablaPrestamos);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new
		ImageIcon(PerfilPescador.class.getResource("/Imaggenes/gente (2) (1).png")));
		lblNewLabel_1.setBounds(33, 14, 155, 142);
		contentPane.add(lblNewLabel_1);

		JScrollPane scrollPane_Ventas = new JScrollPane((Component) null);
		scrollPane_Ventas.setBounds(37, 342, 610, 142);
		contentPane.add(scrollPane_Ventas);

		modeloTablaV = new DefaultTableModel();
		modeloTablaV
				.setColumnIdentifiers(new String[] { "ID", "Cantidad", "Precio Total", "Cooperativa", "ID Producto" });

		tablaVentas = new JTable();
		tablaVentas.setModel(modeloTablaV);
		scrollPane_Ventas.setViewportView(tablaVentas);

		JLabel lblNewLabel_2 = new JLabel("");
		scrollPane_Ventas.setRowHeaderView(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(213, 238, 249));

		// MANEJADOR
		ManejadorBotones escuchadorBotones = new ManejadorBotones();

		// BOTONES
		
		btnCerrar.addActionListener(escuchadorBotones);

		// Mostrar contenido de tablas
		mostrarTablaPrestamos();
		mostrarTablaVentas();
	}

	// CLASE MANEJADOR
	public class ManejadorBotones implements ActionListener {
		public void actionPerformed(ActionEvent eventoBotones) {

			if (eventoBotones.getSource().equals(btnCerrar)) {
				Menu PerfilPescador = new Menu();
				PerfilPescador.setVisible(true);
				dispose();
			}

		}
	}

	private void mostrarTablaPrestamos() {
		// Limpiar la tabla actual
		modeloTablaP.setRowCount(0);

		// Obtener clientes del controlador
		List<Modelo_Prestamos> listaPrestamos = Controlador_PerfilPescador.tablaPrestamos();

		// Añadir clientes a la tabla
		for (Modelo_Prestamos prestamo : listaPrestamos) {
			modeloTablaP.addRow(new Object[] { prestamo.getIdprestamos(), prestamo.getCooperativa(),
					prestamo.getGasolina(), prestamo.getHielo(), prestamo.getCarnada(), prestamo.getDinero() });
		}
	}

	private void mostrarTablaVentas() {
		// Limpiar la tabla actual
		modeloTablaV.setRowCount(0);

		// Obtener clientes del controlador
		List<Modelo_Venta> listaVentas = Controlador_PerfilPescador.tablaVenta();

		// Añadir clientes a la tabla
		for (Modelo_Venta venta : listaVentas) {
			modeloTablaV.addRow(new Object[] { venta.getIdVenta(), venta.getCantidad(), venta.getPrecioTotal(),
					venta.getCooperativa(), venta.getIdProducto() });
		}
	}
}

