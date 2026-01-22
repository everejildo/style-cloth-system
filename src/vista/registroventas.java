package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import controlador.CRegistroVentas;
import modelo.MVentas;

public class registroventas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFldEmpleRVenta;
	private JTextField txtFldClienteRVenta;
	private JButton btnAtras;
	//private JTextField txtFldTotalRVenta;
	private DefaultTableModel modeloTabla;
	private JTable tablaVentas;
	private JComboBox cmbBxMetodoPagoRVenta;
	private JDateChooser dtChsrFechaRVenta;
	private JButton btnAggMetodoPago;
	private JButton btnAgregarProductos;
	private JButton btnLimpiarVenta;
	private JButton btnEliminarVenta;
	private JButton btnActualizarVenta;
	private JButton btnGuardarVenta;
	private JButton btnNuevoVenta;
	private static Locale idioma;
	private static ResourceBundle et;
	private List<Map<String, Object>> ventas = new ArrayList<>();
	private JLabel lblProductosRVenta;
	private CRegistroVentas controladorRegistroVentas;
	private Date hoy;
	private JButton btnModificarVenta;
	private JLabel lblModificar;
	private int idSeleccionado = -1;
	private int idVentaSeleccionada = -1;
	private DefaultComboBoxModel<String> DatosJcombox;
	//private JButton btnCalcularTotal;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registroventas frame = new registroventas(idioma);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public registroventas(Locale idioma) {
		// Internacionalización
		registroventas.idioma = idioma;
		et = ResourceBundle.getBundle("properties/dic", idioma);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 540);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 244, 244));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel(et.getString("registroventas"));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblTitulo.setBounds(10, 30, 935, 40);
		contentPane.add(lblTitulo);

		JLabel lblFechaRVenta = new JLabel(et.getString("fechaventa"));
		lblFechaRVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaRVenta.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblFechaRVenta.setBounds(20, 150, 256, 20);
		contentPane.add(lblFechaRVenta);

		JLabel lblEmpleRVenta = new JLabel(et.getString("idempleadov"));
		lblEmpleRVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpleRVenta.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblEmpleRVenta.setBounds(20, 203, 256, 20);
		contentPane.add(lblEmpleRVenta);

		txtFldEmpleRVenta = new JTextField();
		txtFldEmpleRVenta.setColumns(10);
		txtFldEmpleRVenta.setBounds(20, 226, 256, 20);
		contentPane.add(txtFldEmpleRVenta);
		txtFldEmpleRVenta.setEnabled(false);

		JLabel lblClienteRVenta = new JLabel(et.getString("idclientev"));
		lblClienteRVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblClienteRVenta.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblClienteRVenta.setBounds(20, 256, 256, 20);
		contentPane.add(lblClienteRVenta);

		txtFldClienteRVenta = new JTextField();
		txtFldClienteRVenta.setColumns(10);
		txtFldClienteRVenta.setBounds(20, 279, 256, 20);
		contentPane.add(txtFldClienteRVenta);
		txtFldClienteRVenta.setEnabled(false);

		btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(registroventas.class.getResource("/imagenes/angulo-circulo-izquierda.png")));
		btnAtras.setOpaque(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		btnAtras.setBounds(10, 10, 38, 33);
		contentPane.add(btnAtras);

		JLabel lblMetodoPagoRVenta = new JLabel(et.getString("metodopago"));
		lblMetodoPagoRVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblMetodoPagoRVenta.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblMetodoPagoRVenta.setBounds(20, 309, 256, 20);
		contentPane.add(lblMetodoPagoRVenta);

	/*	JLabel lblTotalRVenta = new JLabel(et.getString("totalventa" + ""));
		lblTotalRVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalRVenta.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblTotalRVenta.setBounds(20, 415, 256, 20);
		contentPane.add(lblTotalRVenta);

		txtFldTotalRVenta = new JTextField();
		txtFldTotalRVenta.setEditable(false);
		txtFldTotalRVenta.setHorizontalAlignment(SwingConstants.CENTER);
		txtFldTotalRVenta.setEnabled(false);
		txtFldTotalRVenta.setColumns(10);
		txtFldTotalRVenta.setBounds(46, 437, 230, 20);
		contentPane.add(txtFldTotalRVenta);
	*/
		hoy = new Date();

		dtChsrFechaRVenta = new JDateChooser();
		dtChsrFechaRVenta.setDateFormatString("dd/MM/yyyy");
		dtChsrFechaRVenta.setDate(hoy);
		dtChsrFechaRVenta.setMaxSelectableDate(hoy);
		dtChsrFechaRVenta.setMinSelectableDate(hoy);
		dtChsrFechaRVenta.setBounds(20, 173, 256, 20);
		contentPane.add(dtChsrFechaRVenta);
		dtChsrFechaRVenta.setEnabled(false);
		// Deshabilitar la edición del campo de texto del JDateChooser
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dtChsrFechaRVenta.getDateEditor();
		editor.setEditable(false);

		// Se inicializa una Variable tipo DefaultComboBoxModel que contendra los datos
		// de la tabla del comboBox
		DatosJcombox = new DefaultComboBoxModel<String>();
		// Se Manda a llamar a la consulta de Datos de la Tabla y nos la devuelve en el
		// Objeto
		DatosJcombox = CRegistroVentas.cmbBxMetodoPago();

		cmbBxMetodoPagoRVenta = new JComboBox<String>(DatosJcombox);
		cmbBxMetodoPagoRVenta.setEnabled(false);
		cmbBxMetodoPagoRVenta.setBounds(20, 332, 230, 20);
		contentPane.add(cmbBxMetodoPagoRVenta);

		btnNuevoVenta = new JButton("");
		btnNuevoVenta.setIcon(new ImageIcon(registroventas.class.getResource("/imagenes/anadir.png")));
		btnNuevoVenta.setVerticalAlignment(SwingConstants.TOP);
		btnNuevoVenta.setOpaque(false);
		btnNuevoVenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNuevoVenta.setContentAreaFilled(false);
		btnNuevoVenta.setBorderPainted(false);
		btnNuevoVenta.setBounds(388, 80, 30, 30);
		contentPane.add(btnNuevoVenta);

		JLabel lblNuevoProducto = new JLabel(et.getString("nuevo"));
		lblNuevoProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoProducto.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblNuevoProducto.setBounds(368, 110, 70, 20);
		contentPane.add(lblNuevoProducto);

		btnGuardarVenta = new JButton("");
		btnGuardarVenta.setIcon(new ImageIcon(registroventas.class.getResource("/imagenes/salvar.png")));
		btnGuardarVenta.setOpaque(false);
		btnGuardarVenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGuardarVenta.setContentAreaFilled(false);
		btnGuardarVenta.setBorderPainted(false);
		btnGuardarVenta.setBounds(457, 80, 30, 30);
		contentPane.add(btnGuardarVenta);
		btnGuardarVenta.setEnabled(false);

		JLabel lblGuardarProducto = new JLabel(et.getString("guardar"));
		lblGuardarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuardarProducto.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblGuardarProducto.setBounds(437, 110, 70, 20);
		contentPane.add(lblGuardarProducto);

		btnActualizarVenta = new JButton("");
		btnActualizarVenta.setIcon(new ImageIcon(registroventas.class.getResource("/imagenes/actualizar-flecha.png")));
		btnActualizarVenta.setOpaque(false);
		btnActualizarVenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnActualizarVenta.setContentAreaFilled(false);
		btnActualizarVenta.setBorderPainted(false);
		btnActualizarVenta.setBounds(526, 80, 30, 30);
		contentPane.add(btnActualizarVenta);

		JLabel lblActualizarProducto = new JLabel(et.getString("actualizar"));
		lblActualizarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualizarProducto.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblActualizarProducto.setBounds(506, 110, 70, 20);
		contentPane.add(lblActualizarProducto);

		btnEliminarVenta = new JButton("");
		btnEliminarVenta.setIcon(new ImageIcon(registroventas.class.getResource("/imagenes/borrar (1).png")));
		btnEliminarVenta.setOpaque(false);
		btnEliminarVenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEliminarVenta.setContentAreaFilled(false);
		btnEliminarVenta.setBorderPainted(false);
		btnEliminarVenta.setBounds(595, 80, 30, 30);
		contentPane.add(btnEliminarVenta);

		JLabel lblBorrarProducto = new JLabel(et.getString("borrar"));
		lblBorrarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrarProducto.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblBorrarProducto.setBounds(575, 110, 70, 20);
		contentPane.add(lblBorrarProducto);

		btnLimpiarVenta = new JButton("");
		btnLimpiarVenta.setIcon(new ImageIcon(registroventas.class.getResource("/imagenes/escoba.png")));
		btnLimpiarVenta.setOpaque(false);
		btnLimpiarVenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLimpiarVenta.setContentAreaFilled(false);
		btnLimpiarVenta.setBorderPainted(false);
		btnLimpiarVenta.setBounds(664, 80, 30, 30);
		contentPane.add(btnLimpiarVenta);

		JLabel lblLimpiarProducto = new JLabel(et.getString("limpiar"));
		lblLimpiarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblLimpiarProducto.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblLimpiarProducto.setBounds(644, 110, 70, 20);
		contentPane.add(lblLimpiarProducto);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(300, 150, 640, 344);
		contentPane.add(scrollPane);

		modeloTabla = new DefaultTableModel();
		modeloTabla.setColumnIdentifiers(
				new String[] { et.getString("idventa"), et.getString("fechaventa"), et.getString("idclientevt"),
						et.getString("totalventa"), et.getString("metodopago"), et.getString("idempleadovt") });
		tablaVentas = new JTable();
		tablaVentas.setModel(modeloTabla);
		scrollPane.setViewportView(tablaVentas);
		tablaVentas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					int selectedRow = tablaVentas.getSelectedRow();
					if (selectedRow != -1) {
						// Capturamos el ID de la venta seleccionada
						idVentaSeleccionada = Integer.parseInt(tablaVentas.getValueAt(selectedRow, 0).toString());
						// Ahora puedes usar esta variable en otros métodos
					}
				}
			}
		});

		btnAgregarProductos = new JButton(et.getString("btnAggProd"));
		btnAgregarProductos.setBounds(20, 382, 256, 25);
		contentPane.add(btnAgregarProductos);

		btnAggMetodoPago = new JButton("");
		btnAggMetodoPago.setIcon(new ImageIcon(registroventas.class.getResource("/imagenes/capa-mas.png")));
		btnAggMetodoPago.setBounds(252, 332, 23, 23);
		contentPane.add(btnAggMetodoPago);
		btnAggMetodoPago.setOpaque(false);
		btnAggMetodoPago.setContentAreaFilled(false);
		btnAggMetodoPago.setBorderPainted(false);

		lblProductosRVenta = new JLabel(et.getString("productoventa"));
		lblProductosRVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductosRVenta.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblProductosRVenta.setBounds(20, 362, 256, 20);
		contentPane.add(lblProductosRVenta);

		btnModificarVenta = new JButton();
		btnModificarVenta.setIcon(new ImageIcon(gestionclientes.class.getResource("/imagenes/boligrafo-cuadrado.png")));
		btnModificarVenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnModificarVenta.setBounds(733, 80, 30, 30);
		contentPane.add(btnModificarVenta);
		btnModificarVenta.setEnabled(false);
		btnModificarVenta.setOpaque(false);
		btnModificarVenta.setContentAreaFilled(false);
		btnModificarVenta.setBorderPainted(false);

		lblModificar = new JLabel(et.getString("modify"));
		lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificar.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblModificar.setBounds(713, 110, 70, 20);
		contentPane.add(lblModificar);
		
	/*	btnCalcularTotal = new JButton("");
		btnCalcularTotal.setIcon(new ImageIcon(registroventas.class.getResource("/imagenes/usd-circulo (1).png")));
		btnCalcularTotal.setBounds(20, 436, 23, 23);
		contentPane.add(btnCalcularTotal);
		btnCalcularTotal.setOpaque(false);
		btnCalcularTotal.setContentAreaFilled(false);
		btnCalcularTotal.setBorderPainted(false);
	*/
		// Manejadoresa
		ManejadorBotones EscuchadorBotones = new ManejadorBotones();
		ManejadorKey KeyBotones = new ManejadorKey();

		// Botones
		btnAtras.addActionListener(EscuchadorBotones);
		btnAggMetodoPago.addActionListener(EscuchadorBotones);
		btnAgregarProductos.addActionListener(EscuchadorBotones);
		btnNuevoVenta.addActionListener(EscuchadorBotones);
		btnLimpiarVenta.addActionListener(EscuchadorBotones);
		btnGuardarVenta.addActionListener(EscuchadorBotones);
		btnEliminarVenta.addActionListener(EscuchadorBotones);
		btnActualizarVenta.addActionListener(EscuchadorBotones);
		btnModificarVenta.addActionListener(EscuchadorBotones);
		//btnCalcularTotal.addActionListener(EscuchadorBotones);

		// Validar
		cmbBxMetodoPagoRVenta.addKeyListener(KeyBotones);
		txtFldEmpleRVenta.addKeyListener(KeyBotones);
		txtFldClienteRVenta.addKeyListener(KeyBotones);
		dtChsrFechaRVenta.addKeyListener(KeyBotones);
		//txtFldTotalRVenta.addKeyListener(KeyBotones);

		controladorRegistroVentas = new CRegistroVentas();
		mostrarTablaVentas();
	}

	public class ManejadorBotones implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			if (evento.getSource().equals(btnAtras)) {
				menuprincipal registroventas = new menuprincipal(idioma);
				registroventas.setVisible(true);
				dispose();
			}
			if (evento.getSource().equals(btnAggMetodoPago)) {
				metodopagoVentas registroventas = new metodopagoVentas(idioma);
				registroventas.setVisible(true);
				dispose();
			}
			if (evento.getSource().equals(btnAgregarProductos)) {
				if (idVentaSeleccionada != -1) {
					// Abre la ventana ventasdetalle con el ID seleccionado
					ventasdetalle ventanaDetalle = new ventasdetalle(idioma, idVentaSeleccionada);
					ventanaDetalle.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Seleccione una venta primero.");
				}
			}
			if (evento.getSource().equals(btnNuevoVenta)) {
				habilitarCampos();
				btnNuevoVenta.setEnabled(false);
				btnGuardarVenta.setEnabled(true);
				btnEliminarVenta.setEnabled(false);
				btnActualizarVenta.setEnabled(false);
				btnLimpiarVenta.setEnabled(true);
				btnModificarVenta.setEnabled(false);
			}
			if (evento.getSource().equals(btnLimpiarVenta)) {
				limpiarCampos();
			}
			if (evento.getSource().equals(btnGuardarVenta)) {
				guardarVenta();
				mostrarTablaVentas();
				limpiarCampos();
				deshabilitarCampos();
				btnNuevoVenta.setEnabled(true);
				btnGuardarVenta.setEnabled(false);
				btnEliminarVenta.setEnabled(true);
				btnActualizarVenta.setEnabled(true);
				btnLimpiarVenta.setEnabled(false);
				btnModificarVenta.setEnabled(false);
			}
			if (evento.getSource().equals(btnEliminarVenta)) {
				eliminarVenta();
				mostrarTablaVentas();
			}
			if (evento.getSource().equals(btnActualizarVenta)) {
				habilitarCampos();
				SeleccionarID();
				btnNuevoVenta.setEnabled(false);
				btnGuardarVenta.setEnabled(false);
				btnEliminarVenta.setEnabled(false);
				btnActualizarVenta.setEnabled(false);
				btnLimpiarVenta.setEnabled(true);
				btnModificarVenta.setEnabled(true);
			}
			if (evento.getSource().equals(btnModificarVenta)) {
				modificarVenta();
				mostrarTablaVentas();
				limpiarCampos();
				deshabilitarCampos();
				btnNuevoVenta.setEnabled(true);
				btnGuardarVenta.setEnabled(false);
				btnEliminarVenta.setEnabled(true);
				btnActualizarVenta.setEnabled(true);
				btnLimpiarVenta.setEnabled(false);
				btnModificarVenta.setEnabled(false);
			}
			/*if(evento.getSource().equals(btnCalcularTotal)) {
				calcularTotal();
			}*/
		}
	}

	public class ManejadorKey implements KeyListener {
		public void keyTyped(KeyEvent event) {
			if (event.getSource().equals(txtFldEmpleRVenta)) {
				int key = event.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;
				if (!(numeros)) {
					event.consume();
				}
			}
			if (event.getSource().equals(txtFldClienteRVenta)) {
				int key = event.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;
				if (!(numeros)) {
					event.consume();
				}
			}
			/*if (event.getSource().equals(txtFldTotalRVenta)) {
				char key = event.getKeyChar();
				boolean numeros = (key >= '0' && key <= '9') || key == '.';
				if (key == '.' && txtFldTotalRVenta.getText().contains(".")) {
					numeros = false;
				}
				if (!numeros) {
					event.consume();
				}
			}*/
		}

		public void keyPressed(KeyEvent e) {
		}

		public void keyReleased(KeyEvent e) {
		}
	}

	private void habilitarCampos() {
		dtChsrFechaRVenta.setEnabled(true);
		txtFldEmpleRVenta.setEnabled(true);
		txtFldClienteRVenta.setEnabled(true);
		cmbBxMetodoPagoRVenta.setEnabled(true);
		btnAgregarProductos.setEnabled(true);
	}

	private void deshabilitarCampos() {
		dtChsrFechaRVenta.setEnabled(false);
		txtFldEmpleRVenta.setEnabled(false);
		txtFldClienteRVenta.setEnabled(false);
		cmbBxMetodoPagoRVenta.setEnabled(false);
		btnAgregarProductos.setEnabled(true);
	}

	private void limpiarCampos() {
		dtChsrFechaRVenta.setDate(hoy);
		txtFldEmpleRVenta.setText("");
		txtFldClienteRVenta.setText("");
		cmbBxMetodoPagoRVenta.setSelectedIndex(0);
	}

	private void guardarVenta() {
		// Obtener los valores de los campos
		Date fecha = dtChsrFechaRVenta.getDate();
		String idEmpleStr = txtFldEmpleRVenta.getText().trim();
		String metodoPago = cmbBxMetodoPagoRVenta.getSelectedItem().toString();
		String idClienteStr = txtFldClienteRVenta.getText().trim();
		String totalStr = "0";

		// Validar que los campos no estén vacíos o no seleccionados
		if (fecha == null || idEmpleStr.isEmpty() || metodoPago.equals("Selecciona una opción")
				|| idClienteStr.isEmpty() || totalStr.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		int idEmple = Integer.parseInt(idEmpleStr);
		int idCliente = Integer.parseInt(idClienteStr);
		int total = Integer.parseInt(totalStr);

		MVentas venta = new MVentas(fecha, idEmple, metodoPago, idCliente, total);
		controladorRegistroVentas.anadirVenta(venta);
	}

	private void SeleccionarID() {
		int filaSeleccionada = tablaVentas.getSelectedRow();
		if (filaSeleccionada >= 0) {
			idSeleccionado = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
			// dtChsrFechaRVenta.setDate((Date) modeloTabla.getValueAt(filaSeleccionada,
			// 1));
			txtFldClienteRVenta.setText(String.valueOf(modeloTabla.getValueAt(filaSeleccionada, 2)));
			//txtFldTotalRVenta.setText(String.valueOf(modeloTabla.getValueAt(filaSeleccionada, 3)));
			// cmbBxMetodoPagoRVenta.setText((String)(modeloTabla.getValueAt(filaSeleccionada,
			// 4));
			txtFldEmpleRVenta.setText(String.valueOf(modeloTabla.getValueAt(filaSeleccionada, 5)));
		} else {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente.");
		}
	}

	private void modificarVenta() {
		if (idSeleccionado != -1) {
			int idCliente = Integer.parseInt(txtFldClienteRVenta.getText().trim());
			//int total = Integer.parseInt(txtFldTotalRVenta.getText().trim());
			int idEmple = Integer.parseInt(txtFldEmpleRVenta.getText().trim());
			String metodoPago = cmbBxMetodoPagoRVenta.getSelectedItem().toString();

			controladorRegistroVentas.actualizarVenta(idSeleccionado, idCliente, metodoPago, idEmple);
		} else {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente para modificar.");
		}
	}

	private void eliminarVenta() {
		int filaSeleccionada = tablaVentas.getSelectedRow();
		int idVenta = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
		controladorRegistroVentas.eliminarVenta(idVenta);
	}

	private void mostrarTablaVentas() {
		// Limpiar la tabla actual
		modeloTabla.setRowCount(0);

		// Obtener clientes del controlador
		List<MVentas> listaVentas = controladorRegistroVentas.obtenerVentas();

		// Añadir clientes a la tabla
		for (MVentas venta : listaVentas) {
			modeloTabla.addRow(new Object[] { venta.getIdVenta(), venta.getFecha(), venta.getIdCliente(),
					venta.getTotal(), venta.getMetodoPago(), venta.getIdEmple() });
		}
	}

	/*private void calcularTotal() {
		int filaSeleccionada = tablaVentas.getSelectedRow();
	    if (filaSeleccionada == -1) {
	        JOptionPane.showMessageDialog(this, "Debe seleccionar una venta primero.");
	        return;
	    }

	    // Obtener el idCliente de la fila seleccionada
	    int idCliente = (int) modeloTabla.getValueAt(filaSeleccionada, 2);

	    // Sumar los totales de todas las ventas con el mismo idCliente
	    int totalVentas = 0;
	    for (int i = 0; i < modeloTabla.getRowCount(); i++) {
	        int cliente = (int) modeloTabla.getValueAt(i, 2);
	        int total = (int) modeloTabla.getValueAt(i, 3);
	        if (cliente == idCliente) {
	            totalVentas += total;
	        }
	    }

	    // Mostrar el total calculado en el campo de texto
	    txtFldTotalRVenta.setText(String.valueOf(totalVentas));
	}*/
}