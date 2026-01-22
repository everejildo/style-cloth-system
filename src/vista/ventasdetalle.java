package vista;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controlador.CVentaDetalle;
import modelo.MVentasDetalle;

public class ventasdetalle extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private static Locale idioma;
	private static ResourceBundle et;
	private static int idVentaSeleccionada;
	private JTextField txtFldVentaProducto;
	private JTextField txtFldVentaDetalle;
	private JTextField txtFldCantidadProductos;
	private DefaultTableModel modeloTabla;
	private JTable tablaVentasDetalle;
	private JButton btnNuevoVD;
	private JButton btnGuardarVD;
	private JButton btnActualizarVD;
	private JButton btnEliminarVD;
	private JButton btnLimpiarVD;
	private JButton btnModificarVD;
	private JButton btnAtras;
	private CVentaDetalle controladorVentaDetalle;
	private int idVentaSeleccionado = -1;
	private int idProdSeleccionado = -1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventasdetalle frame = new ventasdetalle(idioma, idVentaSeleccionada);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ventasdetalle(Locale idioma, int idVentaSeleccionada) {
		// Internacionalización
		ventasdetalle.idioma = idioma;
		et = ResourceBundle.getBundle("properties/dic", idioma);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel(et.getString("tituloventasdetalle"));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblTitulo.setBounds(10, 30, 935, 40);
		contentPane.add(lblTitulo);

		btnNuevoVD = new JButton("");
		btnNuevoVD.setIcon(new ImageIcon(ventasdetalle.class.getResource("/imagenes/anadir.png")));
		btnNuevoVD.setVerticalAlignment(SwingConstants.TOP);
		btnNuevoVD.setOpaque(false);
		btnNuevoVD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNuevoVD.setContentAreaFilled(false);
		btnNuevoVD.setBorderPainted(false);
		btnNuevoVD.setBounds(388, 73, 30, 30);
		contentPane.add(btnNuevoVD);

		btnGuardarVD = new JButton("");
		btnGuardarVD.setIcon(new ImageIcon(ventasdetalle.class.getResource("/imagenes/salvar.png")));
		btnGuardarVD.setOpaque(false);
		btnGuardarVD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGuardarVD.setEnabled(false);
		btnGuardarVD.setContentAreaFilled(false);
		btnGuardarVD.setBorderPainted(false);
		btnGuardarVD.setBounds(457, 73, 30, 30);
		contentPane.add(btnGuardarVD);

		JLabel lblNuevoVD = new JLabel(et.getString("nuevo"));
		lblNuevoVD.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoVD.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblNuevoVD.setBounds(368, 103, 70, 20);
		contentPane.add(lblNuevoVD);

		JLabel lblGuardarVD = new JLabel(et.getString("guardar"));
		lblGuardarVD.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuardarVD.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblGuardarVD.setBounds(437, 103, 70, 20);
		contentPane.add(lblGuardarVD);

		JLabel lblIdVenta = new JLabel(et.getString("idventavd"));
		lblIdVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdVenta.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblIdVenta.setBounds(20, 143, 300, 20);
		contentPane.add(lblIdVenta);

		JLabel lblIdProducto = new JLabel(et.getString("idproductovd"));
		lblIdProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdProducto.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblIdProducto.setBounds(330, 143, 300, 20);
		contentPane.add(lblIdProducto);

		txtFldVentaProducto = new JTextField();
		txtFldVentaProducto.setEnabled(false);
		txtFldVentaProducto.setColumns(10);
		txtFldVentaProducto.setBounds(330, 166, 300, 20);
		contentPane.add(txtFldVentaProducto);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 195, 920, 410);
		contentPane.add(scrollPane);

		modeloTabla = new DefaultTableModel();
		modeloTabla.setColumnIdentifiers(
				new String[] { et.getString("idventa"), et.getString("idproductovd"), et.getString("cantidadvd") });
		tablaVentasDetalle = new JTable();
		tablaVentasDetalle.setModel(modeloTabla);
		scrollPane.setViewportView(tablaVentasDetalle);

		txtFldVentaDetalle = new JTextField();
		txtFldVentaDetalle.setEnabled(false);
		txtFldVentaDetalle.setColumns(10);
		txtFldVentaDetalle.setBounds(20, 166, 300, 20);
		contentPane.add(txtFldVentaDetalle);

		txtFldVentaDetalle.setText(String.valueOf(idVentaSeleccionada));

		txtFldCantidadProductos = new JTextField();
		txtFldCantidadProductos.setEnabled(false);
		txtFldCantidadProductos.setColumns(10);
		txtFldCantidadProductos.setBounds(640, 166, 300, 20);
		contentPane.add(txtFldCantidadProductos);

		JLabel lblCantidadProductos = new JLabel(et.getString("cantidadvd"));
		lblCantidadProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadProductos.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblCantidadProductos.setBounds(640, 143, 300, 20);
		contentPane.add(lblCantidadProductos);

		btnActualizarVD = new JButton("");
		btnActualizarVD.setIcon(new ImageIcon(ventasdetalle.class.getResource("/imagenes/actualizar-flecha.png")));
		btnActualizarVD.setOpaque(false);
		btnActualizarVD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnActualizarVD.setContentAreaFilled(false);
		btnActualizarVD.setBorderPainted(false);
		btnActualizarVD.setBounds(537, 73, 30, 30);
		contentPane.add(btnActualizarVD);

		JLabel lblActualizar = new JLabel(et.getString("actualizar"));
		lblActualizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualizar.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblActualizar.setBounds(517, 103, 70, 20);
		contentPane.add(lblActualizar);

		btnEliminarVD = new JButton("");
		btnEliminarVD.setIcon(new ImageIcon(ventasdetalle.class.getResource("/imagenes/borrar (1).png")));
		btnEliminarVD.setOpaque(false);
		btnEliminarVD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEliminarVD.setContentAreaFilled(false);
		btnEliminarVD.setBorderPainted(false);
		btnEliminarVD.setBounds(606, 73, 30, 30);
		contentPane.add(btnEliminarVD);

		JLabel lblEliminar = new JLabel(et.getString("borrar"));
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblEliminar.setBounds(586, 103, 70, 20);
		contentPane.add(lblEliminar);

		btnLimpiarVD = new JButton("");
		btnLimpiarVD.setIcon(new ImageIcon(ventasdetalle.class.getResource("/imagenes/escoba.png")));
		btnLimpiarVD.setOpaque(false);
		btnLimpiarVD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLimpiarVD.setContentAreaFilled(false);
		btnLimpiarVD.setBorderPainted(false);
		btnLimpiarVD.setBounds(675, 73, 30, 30);
		contentPane.add(btnLimpiarVD);

		JLabel lblLimpiar = new JLabel(et.getString("limpiar"));
		lblLimpiar.setHorizontalAlignment(SwingConstants.CENTER);
		lblLimpiar.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblLimpiar.setBounds(655, 103, 70, 20);
		contentPane.add(lblLimpiar);

		btnModificarVD = new JButton();
		btnModificarVD.setIcon(new ImageIcon(ventasdetalle.class.getResource("/imagenes/boligrafo-cuadrado.png")));
		btnModificarVD.setOpaque(false);
		btnModificarVD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnModificarVD.setEnabled(false);
		btnModificarVD.setContentAreaFilled(false);
		btnModificarVD.setBorderPainted(false);
		btnModificarVD.setBounds(744, 73, 30, 30);
		contentPane.add(btnModificarVD);

		btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(registroventas.class.getResource("/imagenes/angulo-circulo-izquierda.png")));
		btnAtras.setOpaque(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		btnAtras.setBounds(10, 10, 38, 33);
		contentPane.add(btnAtras);

		JLabel lblModificar_1 = new JLabel(et.getString("modify"));
		lblModificar_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificar_1.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblModificar_1.setBounds(724, 103, 70, 20);
		contentPane.add(lblModificar_1);

		controladorVentaDetalle = new CVentaDetalle();
		mostrarTablaVentasDetalle();

		// Manejadores
		ManejadorBotones EscuchadorBotones = new ManejadorBotones();
		ManejadorListSelection EscuchadorList = new ManejadorListSelection();

		// Escuchadores
		btnAtras.addActionListener(EscuchadorBotones);
		btnNuevoVD.addActionListener(EscuchadorBotones);
		btnGuardarVD.addActionListener(EscuchadorBotones);
		btnActualizarVD.addActionListener(EscuchadorBotones);
		btnEliminarVD.addActionListener(EscuchadorBotones);
		btnLimpiarVD.addActionListener(EscuchadorBotones);
		btnModificarVD.addActionListener(EscuchadorBotones);

		tablaVentasDetalle.getSelectionModel().addListSelectionListener(EscuchadorList);
	}

	public class ManejadorBotones implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			if (evento.getSource().equals(btnAtras)) {
				registroventas ventasdetalle = new registroventas(idioma);
				ventasdetalle.setVisible(true);
				dispose();
			}
			if (evento.getSource().equals(btnNuevoVD)) {
				habilitarCampos();
				btnNuevoVD.setEnabled(false);
				btnGuardarVD.setEnabled(true);
				btnEliminarVD.setEnabled(false);
				btnActualizarVD.setEnabled(false);
				btnLimpiarVD.setEnabled(true);
				btnModificarVD.setEnabled(false);
			}
			if (evento.getSource().equals(btnGuardarVD)) {
				guardarVentaDetalle();
				mostrarTablaVentasDetalle();
				limpiarCampos();
				deshabilitarCampos();
				btnNuevoVD.setEnabled(true);
				btnGuardarVD.setEnabled(false);
				btnEliminarVD.setEnabled(true);
				btnActualizarVD.setEnabled(true);
				btnLimpiarVD.setEnabled(false);
				btnModificarVD.setEnabled(false);
			}
			if (evento.getSource().equals(btnActualizarVD)) {
				habilitarCampos();
				SeleccionarIDs();
				btnNuevoVD.setEnabled(false);
				btnGuardarVD.setEnabled(false);
				btnEliminarVD.setEnabled(false);
				btnActualizarVD.setEnabled(false);
				btnLimpiarVD.setEnabled(true);
				btnModificarVD.setEnabled(true);
			}
			if (evento.getSource().equals(btnEliminarVD)) {
				eliminarVentaDetalle();
				mostrarTablaVentasDetalle();
			}
			if (evento.getSource().equals(btnLimpiarVD)) {
				limpiarCampos();
			}
			if (evento.getSource().equals(btnModificarVD)) {
				modificarVentaDetalle();
				mostrarTablaVentasDetalle();
				limpiarCampos();
				deshabilitarCampos();
				btnNuevoVD.setEnabled(true);
				btnGuardarVD.setEnabled(false);
				btnEliminarVD.setEnabled(true);
				btnActualizarVD.setEnabled(true);
				btnLimpiarVD.setEnabled(false);
				btnModificarVD.setEnabled(false);
			}

		}

	}

	public class ManejadorListSelection implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent event) {
			// Asegúrate de que no se esté ajustando (para evitar llamadas múltiples)
			if (!event.getValueIsAdjusting()) {
				// Verifica si hay una fila seleccionada
				int selectedRow = tablaVentasDetalle.getSelectedRow();
				if (selectedRow != -1) {
					// Obtén el valor de la primera columna de la fila seleccionada (ID de la venta)
					String idVenta = tablaVentasDetalle.getValueAt(selectedRow, 0).toString();
					// Coloca el valor en el JTextField txtFldVentaDetalle
					txtFldVentaDetalle.setText(idVenta);
				}
			}
		}
	}

	// public class ManejadorKey

	private void habilitarCampos() {
		txtFldVentaDetalle.setEnabled(true);
		txtFldVentaProducto.setEnabled(true);
		txtFldCantidadProductos.setEnabled(true);
	}

	private void deshabilitarCampos() {
		txtFldVentaDetalle.setEnabled(false);
		txtFldVentaProducto.setEnabled(false);
		txtFldCantidadProductos.setEnabled(false);
	}

	private void limpiarCampos() {
		txtFldVentaDetalle.setText(String.valueOf(idVentaSeleccionada));
		txtFldVentaProducto.setText("");
		txtFldCantidadProductos.setText("");
	}

	private void guardarVentaDetalle() {
			String idVentaString = txtFldVentaDetalle.getText().trim();
			String idProductoString = txtFldVentaProducto.getText().trim();
			String cantidadString = txtFldCantidadProductos.getText().trim();

			// Verifica que los campos no estén vacíos
			if (idVentaString.isEmpty() || idProductoString.isEmpty() || cantidadString.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Todos los campos deben estar completos.");
				return;
			}

			int idVenta = Integer.parseInt(idVentaString);
			int idProducto = Integer.parseInt(idProductoString);
			int cantidad = Integer.parseInt(cantidadString);

			MVentasDetalle ventadetalle = new MVentasDetalle(idVenta, idProducto, cantidad);
			controladorVentaDetalle.anadirVentas(ventadetalle);
	}

	private void eliminarVentaDetalle() {
		int filaSeleccionada = tablaVentasDetalle.getSelectedRow();
		int idVentaDetalle = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
		int idVentaProducto = (int) modeloTabla.getValueAt(filaSeleccionada, 1);
		controladorVentaDetalle.eliminarVenta(idVentaDetalle, idVentaProducto);
	}

	private void SeleccionarIDs() {
		int filaSeleccionada = tablaVentasDetalle.getSelectedRow();
		if (filaSeleccionada >= 0) {
			idVentaSeleccionado = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
			idProdSeleccionado = (int) modeloTabla.getValueAt(filaSeleccionada, 1);
			txtFldCantidadProductos.setText(String.valueOf(modeloTabla.getValueAt(filaSeleccionada, 2)));
		} else {
			JOptionPane.showMessageDialog(this, "Debe seleccionar una fila.");
		}
	}

	private void modificarVentaDetalle() {
		if (idVentaSeleccionado != -1 || idProdSeleccionado != -1) {
			int idVenta = Integer.parseInt(txtFldVentaDetalle.getText().trim());
			int idProducto = Integer.parseInt(txtFldVentaProducto.getText().trim());
			int cantidad = Integer.parseInt(txtFldCantidadProductos.getText().trim());

			controladorVentaDetalle.actualizarVenta(idVentaSeleccionado, idProdSeleccionado, idVenta, idProducto,
					cantidad);
		} else {
			JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para modificar.");
		}
	}

	public List<MVentasDetalle> mostrarTablaVentasDetalle() {
		// Limpiar la tabla actual
		modeloTabla.setRowCount(0);

		// Obtener clientes del controlador
		List<MVentasDetalle> listaVentasDetalle = controladorVentaDetalle.obtenerVentasDetalle();

		// Añadir clientes a la tabla
		for (MVentasDetalle ventadetalle : listaVentasDetalle) {
			modeloTabla.addRow(new Object[] { ventadetalle.getIdVenta(), ventadetalle.getIdProducto(),
					ventadetalle.getCantidad() });
		}
		return listaVentasDetalle;
	}
}
