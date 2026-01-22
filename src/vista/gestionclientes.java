package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
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
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import controlador.CGestionClientes;
import modelo.MClientes;

public class gestionclientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFldNombreCliente;
	private JTextField txtFldApellidoCliente;
	private JTextField txtFldTelefonoCliente;
	private JButton btnNuevoCliente;
	private JButton btnAtras;
	private JLabel lblDireccionCliente;
	private JLabel lblFechaCliente;
	private JDateChooser dtChsrRegistroCliente;
	private JButton btnGuardarCliente;
	private JButton btnActualizarCliente;
	private JButton btnEliminarCliente;
	private JButton btnLimpiarCliente;
	private JLabel lblGuardarProducto;
	private JLabel lblActualizarProducto;
	private JLabel lblBorrarProducto;
	private JLabel lblLimpiarProducto;
	private JLabel lblVisitaCliente;
	private JTextField txtFldCorreoCliente;
	private JTextField txtFldDireccionCliente;
	private JTextField txtFldVisitaCliente;
	private DefaultTableModel modeloTabla;
	private JTable tablaClientes;
	private static Locale idioma;
	private static ResourceBundle et;
	private CGestionClientes controladorClientes;
	private JButton btnModificarUpdate;
	private int idClienteSeleccionado = -1;
	private Date hoy;
	private JLabel lblModificar;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionclientes frame = new gestionclientes(idioma);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public gestionclientes(Locale idioma) {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(gestionclientes.class.getResource("/imagenes/v914-ning-21a.png")));
		// Internacionalización
		gestionclientes.idioma = idioma;
		et = ResourceBundle.getBundle("properties/dic", idioma);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 656);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 244, 244));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblGestionClientes = new JLabel(et.getString("gestionclientes"));
		lblGestionClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionClientes.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblGestionClientes.setBounds(10, 30, 935, 40);
		contentPane.add(lblGestionClientes);

		JLabel lblNombreCliente = new JLabel(et.getString("nombrecliente"));
		lblNombreCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreCliente.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNombreCliente.setBounds(20, 127, 256, 20);
		contentPane.add(lblNombreCliente);

		txtFldNombreCliente = new JTextField();
		txtFldNombreCliente.setBounds(20, 150, 256, 20);
		contentPane.add(txtFldNombreCliente);
		txtFldNombreCliente.setColumns(10);
		txtFldNombreCliente.setEnabled(false);

		JLabel lblApellidoCliente = new JLabel(et.getString("apellidocliente"));
		lblApellidoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidoCliente.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblApellidoCliente.setBounds(20, 180, 256, 20);
		contentPane.add(lblApellidoCliente);

		txtFldApellidoCliente = new JTextField();
		txtFldApellidoCliente.setColumns(10);
		txtFldApellidoCliente.setBounds(20, 203, 256, 20);
		contentPane.add(txtFldApellidoCliente);
		txtFldApellidoCliente.setEnabled(false);

		JLabel lblTelefonoCliente = new JLabel(et.getString("telefonocliente"));
		lblTelefonoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefonoCliente.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblTelefonoCliente.setBounds(20, 233, 256, 20);
		contentPane.add(lblTelefonoCliente);

		txtFldTelefonoCliente = new JTextField();
		txtFldTelefonoCliente.setColumns(10);
		txtFldTelefonoCliente.setBounds(20, 256, 256, 20);
		contentPane.add(txtFldTelefonoCliente);
		txtFldTelefonoCliente.setEnabled(false);

		btnNuevoCliente = new JButton("");
		btnNuevoCliente.setVerticalAlignment(SwingConstants.TOP);
		btnNuevoCliente.setIcon(new ImageIcon(gestionclientes.class.getResource("/imagenes/anadir.png")));
		btnNuevoCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNuevoCliente.setBounds(363, 80, 30, 30);
		contentPane.add(btnNuevoCliente);
		btnNuevoCliente.setOpaque(false);
		btnNuevoCliente.setContentAreaFilled(false);
		btnNuevoCliente.setBorderPainted(false);

		btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(gestionclientes.class.getResource("/imagenes/angulo-circulo-izquierda.png")));
		btnAtras.setOpaque(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		btnAtras.setBounds(10, 10, 38, 33);
		contentPane.add(btnAtras);

		JLabel lblCorreoCliente = new JLabel(et.getString("correocliente"));
		lblCorreoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreoCliente.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblCorreoCliente.setBounds(20, 286, 256, 20);
		contentPane.add(lblCorreoCliente);

		lblDireccionCliente = new JLabel(et.getString("direccioncliente"));
		lblDireccionCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccionCliente.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblDireccionCliente.setBounds(20, 339, 256, 20);
		contentPane.add(lblDireccionCliente);

		lblFechaCliente = new JLabel(et.getString("fecharegistrocliente"));
		lblFechaCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaCliente.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblFechaCliente.setBounds(20, 445, 256, 20);
		contentPane.add(lblFechaCliente);

		hoy = new Date();
		
		dtChsrRegistroCliente = new JDateChooser();
		dtChsrRegistroCliente.setDateFormatString("dd/MM/yyyy");
		dtChsrRegistroCliente.setDate(hoy);
		dtChsrRegistroCliente.setMaxSelectableDate(hoy);
		dtChsrRegistroCliente.setMinSelectableDate(hoy);
		dtChsrRegistroCliente.setBounds(20, 468, 256, 20);
		contentPane.add(dtChsrRegistroCliente);
		dtChsrRegistroCliente.setEnabled(false);
		// Deshabilitar la edición del campo de texto del JDateChooser
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dtChsrRegistroCliente.getDateEditor();
		editor.setEditable(false);

		btnGuardarCliente = new JButton("");
		btnGuardarCliente.setIcon(new ImageIcon(gestionclientes.class.getResource("/imagenes/salvar.png")));
		btnGuardarCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGuardarCliente.setBounds(432, 80, 30, 30);
		contentPane.add(btnGuardarCliente);
		btnGuardarCliente.setOpaque(false);
		btnGuardarCliente.setContentAreaFilled(false);
		btnGuardarCliente.setBorderPainted(false);
		btnGuardarCliente.setEnabled(false);

		btnActualizarCliente = new JButton("");
		btnActualizarCliente
				.setIcon(new ImageIcon(gestionclientes.class.getResource("/imagenes/actualizar-flecha.png")));
		btnActualizarCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnActualizarCliente.setBounds(501, 80, 30, 30);
		contentPane.add(btnActualizarCliente);
		btnActualizarCliente.setOpaque(false);
		btnActualizarCliente.setContentAreaFilled(false);
		btnActualizarCliente.setBorderPainted(false);

		btnEliminarCliente = new JButton("");
		btnEliminarCliente.setToolTipText("Seleccionar en la tabla especificamente el campo ID");
		btnEliminarCliente.setIcon(new ImageIcon(gestionclientes.class.getResource("/imagenes/borrar (1).png")));
		btnEliminarCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEliminarCliente.setBounds(570, 80, 30, 30);
		contentPane.add(btnEliminarCliente);
		btnEliminarCliente.setOpaque(false);
		btnEliminarCliente.setContentAreaFilled(false);
		btnEliminarCliente.setBorderPainted(false);

		btnLimpiarCliente = new JButton("");
		btnLimpiarCliente.setIcon(new ImageIcon(gestionclientes.class.getResource("/imagenes/escoba.png")));
		btnLimpiarCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLimpiarCliente.setBounds(639, 80, 30, 30);
		contentPane.add(btnLimpiarCliente);
		btnLimpiarCliente.setOpaque(false);
		btnLimpiarCliente.setContentAreaFilled(false);
		btnLimpiarCliente.setBorderPainted(false);
		
		btnModificarUpdate = new JButton();
		btnModificarUpdate.setIcon(new ImageIcon(gestionclientes.class.getResource("/imagenes/boligrafo-cuadrado.png")));
		btnModificarUpdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnModificarUpdate.setBounds(708, 80, 30, 30);
		contentPane.add(btnModificarUpdate);
		btnModificarUpdate.setEnabled(false);
		btnModificarUpdate.setOpaque(false);
		btnModificarUpdate.setContentAreaFilled(false);
		btnModificarUpdate.setBorderPainted(false);

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

		lblVisitaCliente = new JLabel(et.getString("visitascliente"));
		lblVisitaCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblVisitaCliente.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblVisitaCliente.setBounds(20, 392, 256, 20);
		contentPane.add(lblVisitaCliente);

		txtFldCorreoCliente = new JTextField();
		txtFldCorreoCliente.setColumns(10);
		txtFldCorreoCliente.setBounds(20, 309, 256, 20);
		contentPane.add(txtFldCorreoCliente);
		txtFldCorreoCliente.setEnabled(false);

		txtFldDireccionCliente = new JTextField();
		txtFldDireccionCliente.setColumns(10);
		txtFldDireccionCliente.setBounds(20, 362, 256, 20);
		contentPane.add(txtFldDireccionCliente);
		txtFldDireccionCliente.setEnabled(false);

		txtFldVisitaCliente = new JTextField();
		txtFldVisitaCliente.setColumns(10);
		txtFldVisitaCliente.setBounds(20, 415, 256, 20);
		contentPane.add(txtFldVisitaCliente);
		txtFldVisitaCliente.setEnabled(false);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(300, 150, 640, 344);
		contentPane.add(scrollPane);

		modeloTabla = new DefaultTableModel();
		modeloTabla.setColumnIdentifiers(new String[] { et.getString("idcliente"), et.getString("nombrecliente"),
				et.getString("apellidocliente"), et.getString("telefonoclientes"), et.getString("correoclientes"),
				et.getString("direccionclientes"), et.getString("visitascliente"),
				et.getString("fecharegistrocliente") });
		tablaClientes = new JTable();
		tablaClientes.setModel(modeloTabla);
		scrollPane.setViewportView(tablaClientes);
	
		// Manejador
		ManejadorBotones EscuchadorBotones = new ManejadorBotones();
		ManejadorKey KeyBotones = new ManejadorKey();

		// Botones
		btnAtras.addActionListener(EscuchadorBotones);
		btnNuevoCliente.addActionListener(EscuchadorBotones);
		btnGuardarCliente.addActionListener(EscuchadorBotones);
		btnActualizarCliente.addActionListener(EscuchadorBotones);
		btnEliminarCliente.addActionListener(EscuchadorBotones);
		btnLimpiarCliente.addActionListener(EscuchadorBotones);
		btnModificarUpdate.addActionListener(EscuchadorBotones);

		// BotonesValidaciones
		txtFldNombreCliente.addKeyListener(KeyBotones);
		txtFldApellidoCliente.addKeyListener(KeyBotones);
		txtFldTelefonoCliente.addKeyListener(KeyBotones);
		txtFldCorreoCliente.addKeyListener(KeyBotones);
		txtFldDireccionCliente.addKeyListener(KeyBotones);
		txtFldVisitaCliente.addKeyListener(KeyBotones);

		// Inicializar controlador
		controladorClientes = new CGestionClientes();
		mostrarTablaClientes();

	}

	public class ManejadorBotones implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			if (evento.getSource().equals(btnAtras)) {
				// Regresar al menu
				menuprincipal gestionclientes = new menuprincipal(idioma);
				gestionclientes.setVisible(true);
				dispose();
			}
			if (evento.getSource().equals(btnNuevoCliente)) {
				// Habilitar campos de agg información
				habilitarCampos();
				btnNuevoCliente.setEnabled(false);
				btnGuardarCliente.setEnabled(true);
				btnEliminarCliente.setEnabled(false);
				btnActualizarCliente.setEnabled(false);
				btnLimpiarCliente.setEnabled(true);
				btnModificarUpdate.setEnabled(false);
			}
			if (evento.getSource().equals(btnGuardarCliente)) {
				// Guardar datos en BD
				guardarCliente();
				// Actualizar tabla
				mostrarTablaClientes();
				// Limpiar campos
				limpiarCampos();
				// Desabilitar campos de agg información
				deshabilitarCampos();
				// Deshabilitar btnGuardar
				btnNuevoCliente.setEnabled(true);
				btnGuardarCliente.setEnabled(false);
				btnEliminarCliente.setEnabled(true);
				btnActualizarCliente.setEnabled(true);
				btnLimpiarCliente.setEnabled(false);
				btnModificarUpdate.setEnabled(false);
			}
			if (evento.getSource().equals(btnActualizarCliente)) {
				// Habilitar campos de agg información
				habilitarCampos();
				// Cargar datos del cliente seleccionado
				seleccionarID();
				// Deshabilitar btnGuardar y habilitar btnModificar
				btnNuevoCliente.setEnabled(false);
				btnGuardarCliente.setEnabled(false);
				btnEliminarCliente.setEnabled(false);
				btnActualizarCliente.setEnabled(false);
				btnLimpiarCliente.setEnabled(true);
				btnModificarUpdate.setEnabled(true);
			}
			if (evento.getSource().equals(btnModificarUpdate)) {
				// Guardar cambios realizados
				modificarCliente();
				// Actualizar tabla
				mostrarTablaClientes();
				// Limpiar campos
				limpiarCampos();
				// Deshabilitar campos y botones
				deshabilitarCampos();
				btnNuevoCliente.setEnabled(true);
				btnGuardarCliente.setEnabled(false);
				btnEliminarCliente.setEnabled(true);
				btnActualizarCliente.setEnabled(true);
				btnLimpiarCliente.setEnabled(false);
				btnModificarUpdate.setEnabled(false);
			}
			if (evento.getSource().equals(btnEliminarCliente)) {
				eliminarCliente();
				// Actualizar la tabla después de eliminar
				mostrarTablaClientes();
			}
			if (evento.getSource().equals(btnLimpiarCliente)) {
				// Limpiar campos
				limpiarCampos();

				JOptionPane.showMessageDialog(null, et.getString("btnLimpiar"));
			}
		}
	}

	private void limpiarCampos() {
		// Limpiar campos
		txtFldNombreCliente.setText("");
		txtFldApellidoCliente.setText("");
		txtFldTelefonoCliente.setText("");
		txtFldCorreoCliente.setText("");
		txtFldDireccionCliente.setText("");
		txtFldVisitaCliente.setText("");
		dtChsrRegistroCliente.setDate(hoy);
	}

	private void habilitarCampos() {
		// Habilitar campos de agg información
		txtFldNombreCliente.setEnabled(true);
		txtFldApellidoCliente.setEnabled(true);
		txtFldTelefonoCliente.setEnabled(true);
		txtFldCorreoCliente.setEnabled(true);
		txtFldDireccionCliente.setEnabled(true);
		txtFldVisitaCliente.setEnabled(true);
		dtChsrRegistroCliente.setEnabled(true);
	}

	private void deshabilitarCampos() {
		// Habilitar campos de agg información
		txtFldNombreCliente.setEnabled(false);
		txtFldApellidoCliente.setEnabled(false);
		txtFldTelefonoCliente.setEnabled(false);
		txtFldCorreoCliente.setEnabled(false);
		txtFldDireccionCliente.setEnabled(false);
		txtFldVisitaCliente.setEnabled(false);
		dtChsrRegistroCliente.setEnabled(false);
	}

	private void guardarCliente() {
		// Guardar datos en bd
		String nombre = txtFldNombreCliente.getText();
		String apellido = txtFldApellidoCliente.getText();
		String telefono = txtFldTelefonoCliente.getText();
		String correo = txtFldCorreoCliente.getText();
		String direccion = txtFldDireccionCliente.getText();
		Date fechaRegistro = dtChsrRegistroCliente.getDate();
		int numCompras = 1;

		MClientes cliente = new MClientes( nombre, apellido, telefono, correo, direccion, fechaRegistro, numCompras);
		controladorClientes.anadirCliente(cliente);
	}

	private void seleccionarID() {
		int filaSeleccionada = tablaClientes.getSelectedRow();
		if (filaSeleccionada >= 0) {
			idClienteSeleccionado = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
			txtFldNombreCliente.setText((String) modeloTabla.getValueAt(filaSeleccionada, 1));
			txtFldApellidoCliente.setText((String)modeloTabla.getValueAt(filaSeleccionada, 2));
			txtFldTelefonoCliente.setText((String)modeloTabla.getValueAt(filaSeleccionada, 3));
			txtFldCorreoCliente.setText((String)modeloTabla.getValueAt(filaSeleccionada, 4));
			txtFldDireccionCliente.setText((String)modeloTabla.getValueAt(filaSeleccionada, 5));
			//txtFldVisitaCliente.setText((String)modeloTabla.getValueAt(filaSeleccionada, 6));
			//dtChsrRegistroCliente.setDate((Date)modeloTabla.getValueAt(filaSeleccionada, 7));
		} else {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente.");
		}
	}

	private void modificarCliente() {
		if (idClienteSeleccionado != -1) {
			String nombre = txtFldNombreCliente.getText();
			String apellido = txtFldApellidoCliente.getText();
			String telefono = txtFldTelefonoCliente.getText();
			String correo = txtFldCorreoCliente.getText();
			String direccion = txtFldDireccionCliente.getText();

			controladorClientes.actualizarCliente(idClienteSeleccionado, nombre, apellido, telefono, correo, direccion);
		} else {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente para modificar.");
		}
	}

	private void eliminarCliente() {
		int filaSeleccionada = tablaClientes.getSelectedRow();
		int idCliente = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
		controladorClientes.eliminarCliente(idCliente);
	}
	
	private void mostrarTablaClientes() {
		// Limpiar la tabla actual
		modeloTabla.setRowCount(0);

		// Obtener clientes del controlador
		List<MClientes> clientes = controladorClientes.obtenerClientes();

		// Añadir clientes a la tabla
		for (MClientes cliente : clientes) {
			modeloTabla.addRow(new Object[] { cliente.getIdCliente(), cliente.getNombre(), cliente.getApellido(),
					cliente.getTelefono(), cliente.getCorreo(), cliente.getDireccion(), cliente.getNumCompras(), cliente.getFechaRegistro() });
		}
	}

	public class ManejadorKey implements KeyListener {
		public void keyTyped(KeyEvent event) {
			if (event.getSource().equals(txtFldNombreCliente)) {
				int key = event.getKeyChar();
				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean space = key == 32;
				if (!(mayusculas || minusculas || space)) {
					event.consume();
				}
			}
			if (event.getSource().equals(txtFldApellidoCliente)) {
				int key = event.getKeyChar();
				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean space = key == 32;
				if (!(mayusculas || minusculas || space)) {
					event.consume();
				}
			}
			if (event.getSource().equals(txtFldTelefonoCliente)) {
				int key = event.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;
				if (!(numeros)) {
					event.consume();
				}
				if (txtFldTelefonoCliente.getText().trim().length() == 10) {
					event.consume();
				}
			}
			if (event.getSource().equals(txtFldCorreoCliente)) {
				int key = event.getKeyChar();
				boolean minusculas = key >= 97 && key <= 122;
				boolean arroba = key == 64;
				boolean numeros = key >= 48 && key <= 57;
				boolean punto = key == 46;
				boolean guionbajo = key == 95;
				if (!(minusculas || arroba || numeros || punto || guionbajo)) {
					event.consume();
				}
			}
			if (event.getSource().equals(txtFldDireccionCliente)) {
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
			if (event.getSource().equals(txtFldVisitaCliente)) {
				int key = event.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;
				if (!(numeros)) {
					event.consume();
				}
			}
		}

		public void keyPressed(KeyEvent e) {

		}

		public void keyReleased(KeyEvent e) {

		}
	}
}
