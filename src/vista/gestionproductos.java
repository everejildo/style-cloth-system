package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import controlador.CProductos;
import controlador.CRegistroVentas;
import modelo.MProducto;

public class gestionproductos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFldNombreProducto;
	private JTextField txtFldPrecioProducto;
	private JButton btnNuevoProducto;
	private JButton btnAtras;
	private JLabel lblTipoProducto;
	//private JLabel lblProveedorProducto;
	//private JTextField txtFldProveedorProducto;
	private JLabel lblFechaProducto;
	private JDateChooser dtChsrRegistroProducto;
	private JButton btnGuardarProducto;
	private JButton btnActualizarProducto;
	private JButton btnEliminarProducto;
	private JButton btnLimpiarProducto;
	private JLabel lblDescrpcin;
	private JLabel lblGuardarProducto;
	private JLabel lblActualizarProducto;
	private JLabel lblBorrarProducto;
	private JLabel lblLimpiarProducto;
	private JComboBox cmbBxTipoProducto;
	private JSpinner spinnerStockProducto;
	private JTextPane txtPnDescripcionProducto;
	private JLabel lblTalla;
	private JComboBox cmbBxTallaProducto;
	private JLabel lblGenero;
	private JComboBox cmbBxGeneroProducto;
	private JTable tablaProductos;
	private DefaultTableModel modeloTabla;
	private static Locale idioma;
	private static ResourceBundle et;
	private JButton btnTipoProducto;
	private CProductos controladorProductos;
	private JButton btnModificarUpdate;
	//private JLabel lblidProducto;
	//private JTextField txtFldIdProducto;
	private int idSeleccionado = -1;
	private JLabel lblModificar;
	//private JButton btnAggProveedor;
	private JButton btnTallaProducto;
	private JButton btnGeneroProducto;
	private DefaultComboBoxModel<String> DatosTipo;
	private DefaultComboBoxModel<String> DatosTalla;
	private DefaultComboBoxModel<String> DatosGenero;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionproductos frame = new gestionproductos(idioma);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public gestionproductos(Locale idioma) {
		// Internacionalización
		gestionproductos.idioma = idioma;
		et = ResourceBundle.getBundle("properties/dic", idioma);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 570);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 244, 244));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblGestionProductos = new JLabel(et.getString("gestiondeproductos"));
		lblGestionProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionProductos.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblGestionProductos.setBounds(10, 30, 935, 40);
		contentPane.add(lblGestionProductos);

		JLabel lblNombreProducto = new JLabel(et.getString("nombreproductos"));
		lblNombreProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreProducto.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNombreProducto.setBounds(28, 150, 256, 20);
		contentPane.add(lblNombreProducto);

		txtFldNombreProducto = new JTextField();
		txtFldNombreProducto.setColumns(10);
		txtFldNombreProducto.setBounds(28, 173, 256, 20);
		contentPane.add(txtFldNombreProducto);
		txtFldNombreProducto.setEnabled(false);

		JLabel lblPrecioUnitario = new JLabel(et.getString("preciounitarioproductos"));
		lblPrecioUnitario.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioUnitario.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblPrecioUnitario.setBounds(28, 203, 256, 20);
		contentPane.add(lblPrecioUnitario);

		txtFldPrecioProducto = new JTextField();
		txtFldPrecioProducto.setColumns(10);
		txtFldPrecioProducto.setBounds(28, 226, 256, 20);
		contentPane.add(txtFldPrecioProducto);
		txtFldPrecioProducto.setEnabled(false);

		btnNuevoProducto = new JButton("");
		btnNuevoProducto.setVerticalAlignment(SwingConstants.TOP);
		btnNuevoProducto.setIcon(new ImageIcon(gestionproductos.class.getResource("/imagenes/anadir.png")));
		btnNuevoProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNuevoProducto.setBounds(363, 80, 30, 30);
		contentPane.add(btnNuevoProducto);
		btnNuevoProducto.setOpaque(false);
		btnNuevoProducto.setContentAreaFilled(false);
		btnNuevoProducto.setBorderPainted(false);

		btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(gestionproductos.class.getResource("/imagenes/angulo-circulo-izquierda.png")));
		btnAtras.setOpaque(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		btnAtras.setBounds(10, 10, 38, 33);
		contentPane.add(btnAtras);

		JLabel lblStockProducto = new JLabel(et.getString("cantidadproductos"));
		lblStockProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblStockProducto.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblStockProducto.setBounds(28, 256, 256, 20);
		contentPane.add(lblStockProducto);

		lblTipoProducto = new JLabel(et.getString("tipoproductos"));
		lblTipoProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoProducto.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblTipoProducto.setBounds(28, 309, 256, 20);
		contentPane.add(lblTipoProducto);

		// Se inicializa una Variable tipo DefaultComboBoxModel que contendra los datos
		// de la tabla del comboBox
		DatosTipo = new DefaultComboBoxModel<String>();
		// Se Manda a llamar a la consulta de Datos de la Tabla y nos la devuelve en el
		// Objeto
		DatosTipo = CProductos.cmbBxTipoProducto();

		cmbBxTipoProducto = new JComboBox<String>(DatosTipo);
		cmbBxTipoProducto.setBounds(28, 332, 230, 20);
		contentPane.add(cmbBxTipoProducto);
		cmbBxTipoProducto.setEnabled(false);

/*		lblProveedorProducto = new JLabel(et.getString("proveedorproductos"));
		lblProveedorProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblProveedorProducto.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblProveedorProducto.setBounds(29, 445, 256, 20);
		contentPane.add(lblProveedorProducto);

		txtFldProveedorProducto = new JTextField();
		txtFldProveedorProducto.setColumns(10);
		txtFldProveedorProducto.setBounds(29, 468, 230, 20);
		contentPane.add(txtFldProveedorProducto);
		txtFldProveedorProducto.setEnabled(false);*/

		lblFechaProducto = new JLabel(et.getString("fecharegistroproductos"));
		lblFechaProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaProducto.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblFechaProducto.setBounds(28, 415, 256, 20);
		contentPane.add(lblFechaProducto);

		dtChsrRegistroProducto = new JDateChooser();
		dtChsrRegistroProducto.setBounds(28, 438, 256, 20);
		contentPane.add(dtChsrRegistroProducto);
		dtChsrRegistroProducto.setEnabled(false);
		// Deshabilitar la edición del campo de texto del JDateChooser
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dtChsrRegistroProducto.getDateEditor();
		editor.setEditable(false);

		btnGuardarProducto = new JButton("");
		btnGuardarProducto.setIcon(new ImageIcon(gestionproductos.class.getResource("/imagenes/salvar.png")));
		btnGuardarProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGuardarProducto.setBounds(432, 80, 30, 30);
		contentPane.add(btnGuardarProducto);
		btnGuardarProducto.setOpaque(false);
		btnGuardarProducto.setContentAreaFilled(false);
		btnGuardarProducto.setBorderPainted(false);
		btnGuardarProducto.setEnabled(false);

		btnActualizarProducto = new JButton("");
		btnActualizarProducto
				.setIcon(new ImageIcon(gestionproductos.class.getResource("/imagenes/actualizar-flecha.png")));
		btnActualizarProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnActualizarProducto.setBounds(501, 80, 30, 30);
		contentPane.add(btnActualizarProducto);
		btnActualizarProducto.setOpaque(false);
		btnActualizarProducto.setContentAreaFilled(false);
		btnActualizarProducto.setBorderPainted(false);

		btnEliminarProducto = new JButton("");
		btnEliminarProducto.setIcon(new ImageIcon(gestionproductos.class.getResource("/imagenes/borrar (1).png")));
		btnEliminarProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEliminarProducto.setBounds(570, 80, 30, 30);
		contentPane.add(btnEliminarProducto);
		btnEliminarProducto.setOpaque(false);
		btnEliminarProducto.setContentAreaFilled(false);
		btnEliminarProducto.setBorderPainted(false);

		btnLimpiarProducto = new JButton("");
		btnLimpiarProducto.setIcon(new ImageIcon(gestionproductos.class.getResource("/imagenes/escoba.png")));
		btnLimpiarProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLimpiarProducto.setBounds(639, 80, 30, 30);
		contentPane.add(btnLimpiarProducto);
		btnLimpiarProducto.setOpaque(false);
		btnLimpiarProducto.setContentAreaFilled(false);
		btnLimpiarProducto.setBorderPainted(false);

		btnModificarUpdate = new JButton();
		btnModificarUpdate
				.setIcon(new ImageIcon(gestionclientes.class.getResource("/imagenes/boligrafo-cuadrado.png")));
		btnModificarUpdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnModificarUpdate.setBounds(708, 80, 30, 30);
		contentPane.add(btnModificarUpdate);
		btnModificarUpdate.setEnabled(false);
		btnModificarUpdate.setOpaque(false);
		btnModificarUpdate.setContentAreaFilled(false);
		btnModificarUpdate.setBorderPainted(false);

		spinnerStockProducto = new JSpinner();
		spinnerStockProducto.setBounds(28, 279, 256, 20);
		contentPane.add(spinnerStockProducto);
		spinnerStockProducto.setEnabled(false);

		lblDescrpcin = new JLabel(et.getString("descripcion"));
		lblDescrpcin.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescrpcin.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblDescrpcin.setBounds(28, 468, 256, 20);
		contentPane.add(lblDescrpcin);

		txtPnDescripcionProducto = new JTextPane();
		txtPnDescripcionProducto.setDropMode(DropMode.INSERT);
		txtPnDescripcionProducto.setBounds(29, 491, 256, 20);
		contentPane.add(txtPnDescripcionProducto);
		txtPnDescripcionProducto.setEnabled(false);

		JLabel lblNuevoProducto = new JLabel(et.getString("nuevo"));
		lblNuevoProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoProducto.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblNuevoProducto.setBounds(343, 110, 70, 20);
		contentPane.add(lblNuevoProducto);

		lblGuardarProducto = new JLabel(et.getString("guardar"));
		lblGuardarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuardarProducto.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblGuardarProducto.setBounds(412, 110, 70, 20);
		contentPane.add(lblGuardarProducto);

		lblActualizarProducto = new JLabel(et.getString("actualizar"));
		lblActualizarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualizarProducto.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblActualizarProducto.setBounds(481, 110, 70, 20);
		contentPane.add(lblActualizarProducto);

		lblBorrarProducto = new JLabel(et.getString("borrar"));
		lblBorrarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrarProducto.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblBorrarProducto.setBounds(550, 110, 70, 20);
		contentPane.add(lblBorrarProducto);

		lblLimpiarProducto = new JLabel(et.getString("limpiar"));
		lblLimpiarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblLimpiarProducto.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblLimpiarProducto.setBounds(619, 110, 70, 20);
		contentPane.add(lblLimpiarProducto);

		lblModificar = new JLabel(et.getString("modify"));
		lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificar.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblModificar.setBounds(688, 110, 70, 20);
		contentPane.add(lblModificar);

		lblTalla = new JLabel(et.getString("tallaproductos"));
		lblTalla.setHorizontalAlignment(SwingConstants.CENTER);
		lblTalla.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblTalla.setBounds(28, 362, 120, 20);
		contentPane.add(lblTalla);

		DatosTalla = new DefaultComboBoxModel<String>();
		DatosTalla = CProductos.cmbBxTallaProducto();
		
		cmbBxTallaProducto = new JComboBox(DatosTalla);
		cmbBxTallaProducto.setToolTipText("");
		cmbBxTallaProducto.setBounds(28, 385, 100, 20);
		contentPane.add(cmbBxTallaProducto);
		cmbBxTallaProducto.setEnabled(false);

		lblGenero = new JLabel(et.getString("generoproductos"));
		lblGenero.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenero.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblGenero.setBounds(164, 362, 120, 20);
		contentPane.add(lblGenero);

		DatosGenero = new DefaultComboBoxModel<String>();
		DatosGenero = CProductos.cmbBxGeneroProducto();
		
		cmbBxGeneroProducto = new JComboBox(DatosGenero);
		cmbBxGeneroProducto.setBounds(164, 385, 100, 20);
		contentPane.add(cmbBxGeneroProducto);
		cmbBxGeneroProducto.setEnabled(false);

		// Crear la tabla de productos
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn(et.getString("codigoproductos"));
		modeloTabla.addColumn(et.getString("nombreproductos"));
		modeloTabla.addColumn(et.getString("descripcion"));
		modeloTabla.addColumn(et.getString("tipoproductos"));
		modeloTabla.addColumn(et.getString("tallaproductos"));
		modeloTabla.addColumn(et.getString("preciounitarioproductos"));
		modeloTabla.addColumn(et.getString("fecharegistroproductos"));
		modeloTabla.addColumn(et.getString("existencia"));
		modeloTabla.addColumn(et.getString("generoproductos"));
		//modeloTabla.addColumn(et.getString("proveedorproductos"));

		tablaProductos = new JTable(modeloTabla);
		JScrollPane scrollPane = new JScrollPane(tablaProductos);
		scrollPane.setBounds(320, 150, 600, 361);
		contentPane.add(scrollPane);

		btnTipoProducto = new JButton("");
		btnTipoProducto.setIcon(new ImageIcon(registroventas.class.getResource("/imagenes/capa-mas.png")));
		btnTipoProducto.setBounds(262, 332, 23, 23);
		contentPane.add(btnTipoProducto);
		btnTipoProducto.setEnabled(true);
		btnTipoProducto.setOpaque(false);
		btnTipoProducto.setContentAreaFilled(false);
		btnTipoProducto.setBorderPainted(false);
/*
		lblidProducto = new JLabel(et.getString("codigoproductos"));
		lblidProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblidProducto.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblidProducto.setBounds(29, 127, 256, 20);
		contentPane.add(lblidProducto);

		txtFldIdProducto = new JTextField();
		txtFldIdProducto.setEnabled(false);
		txtFldIdProducto.setColumns(10);
		txtFldIdProducto.setBounds(29, 150, 256, 20);
		contentPane.add(txtFldIdProducto);

		btnAggProveedor = new JButton("");
		btnAggProveedor.setIcon(new ImageIcon(gestionproductos.class.getResource("/imagenes/capa-mas.png")));
		btnAggProveedor.setOpaque(false);
		btnAggProveedor.setEnabled(false);
		btnAggProveedor.setContentAreaFilled(false);
		btnAggProveedor.setBorderPainted(false);
		btnAggProveedor.setBounds(263, 468, 23, 23);
		contentPane.add(btnAggProveedor);
*/
		btnTallaProducto = new JButton("");
		btnTallaProducto.setIcon(new ImageIcon(gestionproductos.class.getResource("/imagenes/capa-mas.png")));
		btnTallaProducto.setOpaque(false);
		btnTallaProducto.setEnabled(true);
		btnTallaProducto.setContentAreaFilled(false);
		btnTallaProducto.setBorderPainted(false);
		btnTallaProducto.setBounds(129, 384, 23, 23);
		contentPane.add(btnTallaProducto);

		btnGeneroProducto = new JButton("");
		btnGeneroProducto.setIcon(new ImageIcon(gestionproductos.class.getResource("/imagenes/capa-mas.png")));
		btnGeneroProducto.setOpaque(false);
		btnGeneroProducto.setEnabled(true);
		btnGeneroProducto.setContentAreaFilled(false);
		btnGeneroProducto.setBorderPainted(false);
		btnGeneroProducto.setBounds(262, 384, 23, 23);
		contentPane.add(btnGeneroProducto);

		// Manejador
		ManejadorBotones EscuchadorBotones = new ManejadorBotones();
		ManejadorKey KeyBotones = new ManejadorKey();

		// Botones
		btnAtras.addActionListener(EscuchadorBotones);
		btnNuevoProducto.addActionListener(EscuchadorBotones);
		btnGuardarProducto.addActionListener(EscuchadorBotones);
		btnActualizarProducto.addActionListener(EscuchadorBotones);
		btnModificarUpdate.addActionListener(EscuchadorBotones);
		btnEliminarProducto.addActionListener(EscuchadorBotones);
		btnLimpiarProducto.addActionListener(EscuchadorBotones);
		btnTipoProducto.addActionListener(EscuchadorBotones);
		btnTallaProducto.addActionListener(EscuchadorBotones);
		btnGeneroProducto.addActionListener(EscuchadorBotones);
		//btnAggProveedor.addActionListener(EscuchadorBotones);

		// Validaciones
		//txtFldIdProducto.addKeyListener(KeyBotones);
		txtFldNombreProducto.addKeyListener(KeyBotones);
		txtFldPrecioProducto.addKeyListener(KeyBotones);
		//txtFldProveedorProducto.addKeyListener(KeyBotones);
		spinnerStockProducto.addKeyListener(KeyBotones);
		txtPnDescripcionProducto.addKeyListener(KeyBotones);

		controladorProductos = new CProductos();
		mostrarTablaProductos();
	}

	public class ManejadorBotones implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			if (evento.getSource().equals(btnAtras)) {
				menuprincipal gestionproductos = new menuprincipal(idioma);
				gestionproductos.setVisible(true);
				dispose();
			}
			if (evento.getSource().equals(btnTipoProducto)) {
				tipoProducto gestionproductos = new tipoProducto(idioma);
				gestionproductos.setVisible(true);
				dispose();
			}
			if (evento.getSource().equals(btnTallaProducto)) {
				tallaProducto gestionproductos = new tallaProducto(idioma);
				gestionproductos.setVisible(true);
				dispose();
			}
			if (evento.getSource().equals(btnGeneroProducto)) {
				generoProducto gestionproductos = new generoProducto(idioma);
				gestionproductos.setVisible(true);
				dispose();
			}
			/*if (evento.getSource().equals(btnAggProveedor)) {
				gestionproveedoresProducto gestionproductos = new gestionproveedoresProducto(idioma);
				gestionproductos.setVisible(true);
				dispose();
			}*/
			if (evento.getSource().equals(btnNuevoProducto)) {
				habilitarCampos();
				btnNuevoProducto.setEnabled(false);
				btnGuardarProducto.setEnabled(true);
				btnEliminarProducto.setEnabled(false);
				btnActualizarProducto.setEnabled(false);
				btnLimpiarProducto.setEnabled(true);
				btnModificarUpdate.setEnabled(false);
			}
			if (evento.getSource().equals(btnGuardarProducto)) {
				guardarProducto();
				// Limpiar campos despues de guardar datos
				limpiarCampos();
				deshabilitarCampos();
				mostrarTablaProductos();
				btnNuevoProducto.setEnabled(true);
				btnGuardarProducto.setEnabled(false);
				btnEliminarProducto.setEnabled(true);
				btnActualizarProducto.setEnabled(true);
				btnLimpiarProducto.setEnabled(false);
				btnModificarUpdate.setEnabled(false);
			}
			if (evento.getSource().equals(btnActualizarProducto)) {
				habilitarCampos();
				seleccionarID();
				btnNuevoProducto.setEnabled(false);
				btnGuardarProducto.setEnabled(false);
				btnEliminarProducto.setEnabled(false);
				btnActualizarProducto.setEnabled(false);
				btnLimpiarProducto.setEnabled(true);
				btnModificarUpdate.setEnabled(true);
			}
			if (evento.getSource().equals(btnModificarUpdate)) {
				modificarProducto();
				mostrarTablaProductos();
				limpiarCampos();
				deshabilitarCampos();
				btnNuevoProducto.setEnabled(true);
				btnGuardarProducto.setEnabled(false);
				btnEliminarProducto.setEnabled(true);
				btnActualizarProducto.setEnabled(true);
				btnLimpiarProducto.setEnabled(false);
				btnModificarUpdate.setEnabled(false);
			}
			if (evento.getSource().equals(btnEliminarProducto)) {
				eliminarProducto();
				mostrarTablaProductos();
			}
			if (evento.getSource().equals(btnLimpiarProducto)) {
				limpiarCampos();
				JOptionPane.showMessageDialog(null, et.getString("btnLimpiar"));
			}
		}
	}

	public class ManejadorKey implements KeyListener {
		public void keyTyped(KeyEvent event) {
			/*if (event.getSource().equals(txtFldIdProducto)) {
				int key = event.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;
				if (!(numeros)) {
					event.consume();
				}
			}*/
			if (event.getSource().equals(txtFldNombreProducto)) {
				int key = event.getKeyChar();
				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean numeros = key >= 48 && key <= 57;
				boolean space = key == 32;
				if (!(minusculas || mayusculas || numeros || space)) {
					event.consume();
				}
			}
			if (event.getSource().equals(txtFldPrecioProducto)) {
				int key = event.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;
				boolean punto = key == 46;
				if (!(numeros || punto)) {
					event.consume();
				}
			}
			/*if (event.getSource().equals(txtFldProveedorProducto)) {
				int key = event.getKeyChar();
				// boolean mayusculas = key >= 65 && key <= 90;
				// boolean minusculas = key >= 97 && key <= 122;
				boolean numeros = key >= 48 && key <= 57;
				if (!(numeros)) {
					event.consume();
				}
			}*/
			if (event.getSource().equals(spinnerStockProducto)) {
				int key = event.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;
				if (!(numeros)) {
					event.consume();
				}
			}
			if (event.getSource().equals(txtPnDescripcionProducto)) {
				int key = event.getKeyChar();
				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean numeros = key >= 48 && key <= 57;
				boolean punto = key == 46;
				boolean coma = key == 44;
				boolean space = key == 32;
				if (!(numeros || mayusculas || minusculas || punto || coma || space)) {
					event.consume();
				}
			}
		}

		public void keyPressed(KeyEvent event) {

		}

		public void keyReleased(KeyEvent event) {

		}
	}

	/*
	 * private void agregarTipoRopaPersonalizado() { // Cuadro de diálogo para
	 * ingresar nuevo método de pago String nuevoMetodoPago =
	 * JOptionPane.showInputDialog(this, "Ingrese un nuevo (prenda) de ropa:");
	 * 
	 * // Validar que se haya ingresado algo if (nuevoMetodoPago != null &&
	 * !nuevoMetodoPago.trim().isEmpty()) { // Agregar el nuevo método de pago al
	 * JComboBox DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>)
	 * cmbBxTipoProducto.getModel(); model.addElement(nuevoMetodoPago);
	 * 
	 * // Seleccionar la nueva opción agregada
	 * cmbBxTipoProducto.setSelectedItem(nuevoMetodoPago); } else {
	 * JOptionPane.showMessageDialog(this,
	 * "Debe ingresar un un tipo de ropa válido."); } }
	 */

	private void limpiarCampos() {
		// Limpiar campos
		//txtFldIdProducto.setText("");
		txtFldNombreProducto.setText("");
		txtFldPrecioProducto.setText("");
		spinnerStockProducto.setValue(0);
		cmbBxTipoProducto.setSelectedIndex(0);
		cmbBxTallaProducto.setSelectedIndex(0);
		cmbBxGeneroProducto.setSelectedIndex(0);
		//txtFldProveedorProducto.setText("");
		dtChsrRegistroProducto.setDate(null);
		txtPnDescripcionProducto.setText("");
	}

	private void habilitarCampos() {
		// Habilitar campos de agg información
		//txtFldIdProducto.setEnabled(true);
		txtFldNombreProducto.setEnabled(true);
		txtFldPrecioProducto.setEnabled(true);
		spinnerStockProducto.setEnabled(true);
		cmbBxTipoProducto.setEnabled(true);
		cmbBxTallaProducto.setEnabled(true);
		cmbBxGeneroProducto.setEnabled(true);
		//txtFldProveedorProducto.setEnabled(true);
		dtChsrRegistroProducto.setEnabled(true);
		txtPnDescripcionProducto.setEnabled(true);
		btnTipoProducto.setEnabled(true);
		//btnAggProveedor.setEnabled(true);
	}

	private void deshabilitarCampos() {
		// Deshabilitar campos despues de guardar
		//txtFldIdProducto.setEnabled(false);
		txtFldNombreProducto.setEnabled(false);
		txtFldPrecioProducto.setEnabled(false);
		spinnerStockProducto.setEnabled(false);
		cmbBxTipoProducto.setEnabled(false);
		cmbBxTallaProducto.setEnabled(false);
		cmbBxGeneroProducto.setEnabled(false);
		//txtFldProveedorProducto.setEnabled(false);
		dtChsrRegistroProducto.setEnabled(false);
		txtPnDescripcionProducto.setEnabled(false);
		btnTipoProducto.setEnabled(false);
		//btnAggProveedor.setEnabled(false);
	}

	private void guardarProducto() {
		String nombre = txtFldNombreProducto.getText();
		String descripcion = txtPnDescripcionProducto.getText();
		String tipo = cmbBxTipoProducto.getSelectedItem().toString();
		String talla = cmbBxTallaProducto.getSelectedItem().toString();
		BigDecimal precio = new BigDecimal(txtFldPrecioProducto.getText());
		Date registroProducto = dtChsrRegistroProducto.getDate();
		int stock = Integer.parseInt(spinnerStockProducto.getValue().toString());
		String genero = cmbBxGeneroProducto.getSelectedItem().toString();
		//int idProveedor = Integer.parseInt(txtFldProveedorProducto.getText());
		//int idProducto = Integer.parseInt(txtFldIdProducto.getText());

		MProducto producto = new MProducto(nombre, descripcion, tipo, talla, precio, registroProducto, stock, genero/*,
				idProveedor, idProducto*/);
		controladorProductos.anadirProducto(producto);
	}

	private void seleccionarID() {
		int filaSeleccionada = tablaProductos.getSelectedRow();
		if (filaSeleccionada >= 0) {
			idSeleccionado = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
			//txtFldIdProducto.setEnabled(false);
			//txtFldIdProducto.setText(String.valueOf(modeloTabla.getValueAt(filaSeleccionada, 0)));
			txtFldNombreProducto.setText((String) modeloTabla.getValueAt(filaSeleccionada, 1));
			txtPnDescripcionProducto.setText((String) modeloTabla.getValueAt(filaSeleccionada, 2));
			cmbBxTipoProducto.setSelectedItem(modeloTabla.getValueAt(filaSeleccionada, 3));
			cmbBxTallaProducto.setSelectedItem(modeloTabla.getValueAt(filaSeleccionada, 4));
			txtFldPrecioProducto.setText(modeloTabla.getValueAt(filaSeleccionada, 5).toString());
			// dtChsrRegistroProducto.setDate((Date)
			// modeloTabla.getValueAt(filaSeleccionada, 6));
			spinnerStockProducto.setValue((int) modeloTabla.getValueAt(filaSeleccionada, 7));
			cmbBxGeneroProducto.setSelectedItem(modeloTabla.getValueAt(filaSeleccionada, 8));
			//txtFldProveedorProducto.setText(String.valueOf(modeloTabla.getValueAt(filaSeleccionada, 9)));
		} else {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un producto.");
		}
	}

	private void modificarProducto() {
		if (idSeleccionado != -1) {
			String nombre = txtFldNombreProducto.getText();
			String descripcion = txtPnDescripcionProducto.getText();
			BigDecimal precio = new BigDecimal(txtFldPrecioProducto.getText());
			String genero = (String) cmbBxGeneroProducto.getSelectedItem();
			String tipo = (String) cmbBxTipoProducto.getSelectedItem();
			String talla = (String) cmbBxTallaProducto.getSelectedItem();
			int stock = (int) spinnerStockProducto.getValue();
			// Date fechaRegistro = dtChsrRegistroProducto.getDate();
			//int idProveedor = Integer.parseInt(txtFldProveedorProducto.getText());

			controladorProductos.actualizarProducto(nombre, descripcion, tipo, talla, precio, stock, genero,
					/*idProveedor,*/ idSeleccionado);
		} else {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente para modificar.");
		}
	}

	private void eliminarProducto() {
		int filaSeleccionada = tablaProductos.getSelectedRow();
		int idCliente = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
		controladorProductos.eliminarProducto(idCliente);
	}

	private void mostrarTablaProductos() {
		// Limpiar la tabla actual
		modeloTabla.setRowCount(0);

		// Obtener clientes del controlador
		List<MProducto> listaProductos = controladorProductos.obtenerProductos();

		// Añadir clientes a la tabla
		for (MProducto productos : listaProductos) {
			modeloTabla.addRow(new Object[] { productos.getIdProducto(), productos.getNombre(),
					productos.getDescripcion(), productos.getTipo(), productos.getTalla(), productos.getPrecio(),
					productos.getFechaRegistro(), productos.getStock(), productos.getGenero()/*,
					productos.getIdProveedor()*/ });
		}
	}
}
