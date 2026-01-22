package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

import controlador.CGestionProveedores;
import modelo.MProveedores;

public class gestionproveedores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFldNombreProveedor;
	private JButton btnAtras;
	private JLabel lblTelefonoProveedor;
	private JTextField txtFldTelefonoProveedor;
	private JLabel lblDireccionProveedor;
	private JTextField txtFldDireccionProveedor;
	private JLabel lblCorreoDelProveedor;
	private JTextField txtFldCorreoProveedor;
	private JButton btnNuevoProducto;
	private JLabel lblNuevoProducto;
	private JButton btnGuardarProducto;
	private JLabel lblGuardarProducto;
	private JButton btnActualizarProducto;
	private JLabel lblActualizarProducto;
	private JButton btnEliminarProducto;
	private JLabel lblBorrarProducto;
	private JButton btnLimpiarProducto;
	private JLabel lblLimpiarProducto;
	private JTable tablaP;
	private static Locale idioma;
	private static ResourceBundle et;
	private JTextField txtFldApellidoProveedor;
	private CGestionProveedores controladorEmpresa;
	private CGestionProveedores controladorProveedor;
	private DefaultTableModel modeloTablaP;
	private DefaultTableModel modeloTablaE;
	private int idSeleccionado = -1;
	private JTextField txtFldIdEmpresa;
	private JButton btnModificarProveedor;
	private JButton btnAggEmpresa;
	private JLabel lblNombre;
	// private boolean primerUsoNuevo = true;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionproveedores frame = new gestionproveedores(idioma);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public gestionproveedores(Locale idioma) {
		// Por qué se agregan dos proveedores?
		// Internacionalización
		gestionproveedores.idioma = idioma;
		et = ResourceBundle.getBundle("properties/dic", idioma);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 602);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 244, 244));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblGestionProveedores = new JLabel(et.getString("gestionproveedores"));
		lblGestionProveedores.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionProveedores.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblGestionProveedores.setBounds(10, 30, 935, 40);
		contentPane.add(lblGestionProveedores);

		JLabel lblApellidoProveedor = new JLabel(et.getString("apellidoproveedor"));
		lblApellidoProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidoProveedor.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblApellidoProveedor.setBounds(27, 215, 256, 20);
		contentPane.add(lblApellidoProveedor);

		txtFldNombreProveedor = new JTextField();
		txtFldNombreProveedor.setBounds(27, 173, 256, 20);
		contentPane.add(txtFldNombreProveedor);
		txtFldNombreProveedor.setColumns(10);
		txtFldNombreProveedor.setEnabled(false);

		btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(gestionproveedores.class.getResource("/imagenes/angulo-circulo-izquierda.png")));
		btnAtras.setBounds(10, 10, 39, 33);
		contentPane.add(btnAtras);
		btnAtras.setOpaque(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);

		lblTelefonoProveedor = new JLabel(et.getString("telefonoproveedor"));
		lblTelefonoProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefonoProveedor.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblTelefonoProveedor.setBounds(27, 280, 256, 20);
		contentPane.add(lblTelefonoProveedor);

		txtFldTelefonoProveedor = new JTextField();
		txtFldTelefonoProveedor.setColumns(10);
		txtFldTelefonoProveedor.setBounds(27, 303, 256, 20);
		contentPane.add(txtFldTelefonoProveedor);
		txtFldTelefonoProveedor.setEnabled(false);

		lblDireccionProveedor = new JLabel(et.getString("direccionempresa"));
		lblDireccionProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccionProveedor.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblDireccionProveedor.setBounds(27, 345, 256, 20);
		contentPane.add(lblDireccionProveedor);

		txtFldDireccionProveedor = new JTextField();
		txtFldDireccionProveedor.setColumns(10);
		txtFldDireccionProveedor.setBounds(27, 368, 256, 20);
		contentPane.add(txtFldDireccionProveedor);
		txtFldDireccionProveedor.setEnabled(false);

		lblCorreoDelProveedor = new JLabel(et.getString("correoproveedor"));
		lblCorreoDelProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreoDelProveedor.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblCorreoDelProveedor.setBounds(27, 410, 256, 20);
		contentPane.add(lblCorreoDelProveedor);

		txtFldCorreoProveedor = new JTextField();
		txtFldCorreoProveedor.setColumns(10);
		txtFldCorreoProveedor.setBounds(27, 433, 256, 20);
		contentPane.add(txtFldCorreoProveedor);
		txtFldCorreoProveedor.setEnabled(false);

		btnNuevoProducto = new JButton("");
		btnNuevoProducto.setIcon(new ImageIcon(gestionproveedores.class.getResource("/imagenes/anadir.png")));
		btnNuevoProducto.setVerticalAlignment(SwingConstants.TOP);
		btnNuevoProducto.setOpaque(false);
		btnNuevoProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNuevoProducto.setContentAreaFilled(false);
		btnNuevoProducto.setBorderPainted(false);
		btnNuevoProducto.setBounds(388, 80, 30, 30);
		contentPane.add(btnNuevoProducto);

		lblNuevoProducto = new JLabel(et.getString("nuevo"));
		lblNuevoProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoProducto.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblNuevoProducto.setBounds(368, 110, 70, 20);
		contentPane.add(lblNuevoProducto);

		btnGuardarProducto = new JButton("");
		btnGuardarProducto.setIcon(new ImageIcon(gestionproveedores.class.getResource("/imagenes/salvar.png")));
		btnGuardarProducto.setOpaque(false);
		btnGuardarProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGuardarProducto.setEnabled(false);
		btnGuardarProducto.setContentAreaFilled(false);
		btnGuardarProducto.setBorderPainted(false);
		btnGuardarProducto.setBounds(457, 80, 30, 30);
		contentPane.add(btnGuardarProducto);

		lblGuardarProducto = new JLabel(et.getString("guardar"));
		lblGuardarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuardarProducto.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblGuardarProducto.setBounds(437, 110, 70, 20);
		contentPane.add(lblGuardarProducto);

		btnActualizarProducto = new JButton("");
		btnActualizarProducto
				.setIcon(new ImageIcon(gestionproveedores.class.getResource("/imagenes/actualizar-flecha.png")));
		btnActualizarProducto.setOpaque(false);
		btnActualizarProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnActualizarProducto.setContentAreaFilled(false);
		btnActualizarProducto.setBorderPainted(false);
		btnActualizarProducto.setBounds(526, 80, 30, 30);
		contentPane.add(btnActualizarProducto);

		lblActualizarProducto = new JLabel(et.getString("actualizar"));
		lblActualizarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualizarProducto.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblActualizarProducto.setBounds(506, 110, 70, 20);
		contentPane.add(lblActualizarProducto);

		btnEliminarProducto = new JButton("");
		btnEliminarProducto.setIcon(new ImageIcon(gestionproveedores.class.getResource("/imagenes/borrar (1).png")));
		btnEliminarProducto.setOpaque(false);
		btnEliminarProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEliminarProducto.setContentAreaFilled(false);
		btnEliminarProducto.setBorderPainted(false);
		btnEliminarProducto.setBounds(595, 80, 30, 30);
		contentPane.add(btnEliminarProducto);

		lblBorrarProducto = new JLabel(et.getString("borrar"));
		lblBorrarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrarProducto.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblBorrarProducto.setBounds(575, 110, 70, 20);
		contentPane.add(lblBorrarProducto);

		btnLimpiarProducto = new JButton("");
		btnLimpiarProducto.setIcon(new ImageIcon(gestionproveedores.class.getResource("/imagenes/escoba.png")));
		btnLimpiarProducto.setOpaque(false);
		btnLimpiarProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLimpiarProducto.setContentAreaFilled(false);
		btnLimpiarProducto.setBorderPainted(false);
		btnLimpiarProducto.setBounds(664, 80, 30, 30);
		contentPane.add(btnLimpiarProducto);

		lblLimpiarProducto = new JLabel(et.getString("limpiar"));
		lblLimpiarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblLimpiarProducto.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblLimpiarProducto.setBounds(644, 110, 70, 20);
		contentPane.add(lblLimpiarProducto);

		// Crear la tabla de proveedores
		modeloTablaP = new DefaultTableModel();
		modeloTablaP.addColumn(et.getString("idproveedor"));
		modeloTablaP.addColumn(et.getString("nombreproveedor"));
		modeloTablaP.addColumn(et.getString("apellidoproveedor"));
		modeloTablaP.addColumn(et.getString("telefonoproveedor"));
		modeloTablaP.addColumn(et.getString("correoproveedor"));
		modeloTablaP.addColumn(et.getString("direccionempresa"));
		modeloTablaP.addColumn(et.getString("idempresa"));

		tablaP = new JTable(modeloTablaP);

		JScrollPane scrollPaneP = new JScrollPane(tablaP);
		scrollPaneP.setBounds(310, 150, 630, 400);
		contentPane.add(scrollPaneP);

		txtFldApellidoProveedor = new JTextField();
		txtFldApellidoProveedor.setEnabled(false);
		txtFldApellidoProveedor.setColumns(10);
		txtFldApellidoProveedor.setBounds(27, 238, 256, 20);
		contentPane.add(txtFldApellidoProveedor);

		JLabel lblIdEmpresa = new JLabel(et.getString("idempresa"));
		lblIdEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdEmpresa.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblIdEmpresa.setBounds(27, 475, 256, 20);
		contentPane.add(lblIdEmpresa);

		txtFldIdEmpresa = new JTextField();
		txtFldIdEmpresa.setEnabled(false);
		txtFldIdEmpresa.setColumns(10);
		txtFldIdEmpresa.setBounds(27, 498, 230, 20);
		contentPane.add(txtFldIdEmpresa);
		
		btnModificarProveedor = new JButton("");
		btnModificarProveedor.setIcon(new ImageIcon(gestionproveedores.class.getResource("/imagenes/boligrafo-cuadrado.png")));
		btnModificarProveedor.setOpaque(false);
		btnModificarProveedor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnModificarProveedor.setEnabled(false);
		btnModificarProveedor.setContentAreaFilled(false);
		btnModificarProveedor.setBorderPainted(false);
		btnModificarProveedor.setBounds(733, 80, 30, 30);
		contentPane.add(btnModificarProveedor);
		
		JLabel lblModificarProveedor = new JLabel(et.getString("modify"));
		lblModificarProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarProveedor.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblModificarProveedor.setBounds(713, 110, 70, 20);
		contentPane.add(lblModificarProveedor);
		
		btnAggEmpresa = new JButton("");
		btnAggEmpresa.setIcon(new ImageIcon(gestionproveedores.class.getResource("/imagenes/capa-mas.png")));
		btnAggEmpresa.setBounds(259, 496, 23, 23);
		contentPane.add(btnAggEmpresa);
		btnAggEmpresa.setOpaque(false);
		btnAggEmpresa.setContentAreaFilled(false);
		btnAggEmpresa.setBorderPainted(false);
		
		lblNombre = new JLabel(et.getString("nombreproveedor"));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNombre.setBounds(27, 150, 256, 20);
		contentPane.add(lblNombre);

		// Manejador
		ManejadorBotones EscuchadorBotones = new ManejadorBotones();
		ManejadorKey KeyBotones = new ManejadorKey();

		// Botones
		btnAtras.addActionListener(EscuchadorBotones);
		btnNuevoProducto.addActionListener(EscuchadorBotones);
		btnGuardarProducto.addActionListener(EscuchadorBotones);
		btnActualizarProducto.addActionListener(EscuchadorBotones);
		btnEliminarProducto.addActionListener(EscuchadorBotones);
		btnLimpiarProducto.addActionListener(EscuchadorBotones);
		btnModificarProveedor.addActionListener(EscuchadorBotones);
		btnAggEmpresa.addActionListener(EscuchadorBotones);

		// Validaciones
		txtFldNombreProveedor.addKeyListener(KeyBotones);
		txtFldApellidoProveedor.addKeyListener(KeyBotones);
		txtFldTelefonoProveedor.addKeyListener(KeyBotones);
		txtFldDireccionProveedor.addKeyListener(KeyBotones);
		txtFldCorreoProveedor.addKeyListener(KeyBotones);
		txtFldIdEmpresa.addKeyListener(KeyBotones);

		// Inicializar controladores
		controladorProveedor = new CGestionProveedores();
		mostrarTablaP();
	}

	public class ManejadorBotones implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			if (evento.getSource().equals(btnAtras)) {
				menuprincipal gestionproveedores = new menuprincipal(idioma);
				gestionproveedores.setVisible(true);
				dispose();
			}
			if (evento.getSource().equals(btnNuevoProducto)) {
				habilitarCampos();
				btnNuevoProducto.setEnabled(false);
				btnGuardarProducto.setEnabled(true);
				btnEliminarProducto.setEnabled(false);
				btnActualizarProducto.setEnabled(false);
				btnLimpiarProducto.setEnabled(true);
				btnModificarProveedor.setEnabled(false);
			}
			if (evento.getSource().equals(btnGuardarProducto)) {
				// Guaradar datos en la BD
				guardarProveedor();
				// Mostrar informacion nueva
				mostrarTablaP();
				// Limpiar campos despues de guardar
				limpiarCampos();
				// Deshabilitar campos despues de guardar
				dehabilitarCampos();
				btnNuevoProducto.setEnabled(true);
				btnGuardarProducto.setEnabled(false);
				btnEliminarProducto.setEnabled(true);
				btnActualizarProducto.setEnabled(true);
				btnLimpiarProducto.setEnabled(false);
				btnModificarProveedor.setEnabled(false);
			}
			if (evento.getSource().equals(btnActualizarProducto)) {
				seleccionarID();
				habilitarCampos();
				btnNuevoProducto.setEnabled(false);
				btnGuardarProducto.setEnabled(false);
				btnEliminarProducto.setEnabled(false);
				btnActualizarProducto.setEnabled(false);
				btnLimpiarProducto.setEnabled(true);
				btnModificarProveedor.setEnabled(true);
			}
			if(evento.getSource().equals(btnModificarProveedor)) {
				modificarCliente();
				mostrarTablaP();
				limpiarCampos();
				dehabilitarCampos();
				btnNuevoProducto.setEnabled(true);
				btnGuardarProducto.setEnabled(false);
				btnEliminarProducto.setEnabled(true);
				btnActualizarProducto.setEnabled(true);
				btnLimpiarProducto.setEnabled(false);
				btnModificarProveedor.setEnabled(false);
			}
			if (evento.getSource().equals(btnEliminarProducto)) {
				// JOptionPane.showMessageDialog(null, et.getString("btnBorrar"));
				eliminarProveedor();
				mostrarTablaP();
			}
			if (evento.getSource().equals(btnLimpiarProducto)) {
				JOptionPane.showMessageDialog(null, et.getString("btnLimpiar"));
				limpiarCampos();
			}
			if (evento.getSource().equals(btnAggEmpresa)) {
				gestionempresa gestionproveedores = new gestionempresa(idioma);
				gestionproveedores.setVisible(true);
				dispose();
			}
		}
	}

	public class ManejadorKey implements KeyListener {
		public void keyTyped(KeyEvent event) {
			if (event.getSource().equals(txtFldCorreoProveedor)) {
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
			if (event.getSource().equals(txtFldNombreProveedor)) {
				int key = event.getKeyChar();
				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean numeros = key >= 48 && key <= 57;
				boolean space = key == 32;
				if (!(minusculas || mayusculas || numeros || space)) {
					event.consume();
				}
			}
			if (event.getSource().equals(txtFldApellidoProveedor)) {
				int key = event.getKeyChar();
				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean numeros = key >= 48 && key <= 57;
				boolean space = key == 32;
				if (!(minusculas || mayusculas || numeros || space)) {
					event.consume();
				}
			}
			if (event.getSource().equals(txtFldTelefonoProveedor)) {
				int key = event.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;
				if (!(numeros)) {
					event.consume();
				}
				if (txtFldTelefonoProveedor.getText().trim().length() == 10) {
					event.consume();
				}
			}
			if (event.getSource().equals(txtFldDireccionProveedor)) {
				int key = event.getKeyChar();
				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean numeros = key >= 48 && key <= 57;
				boolean space = key == 32;
				if (!(minusculas || mayusculas || numeros || space)) {
					event.consume();
				}
			}
			if (event.getSource().equals(txtFldIdEmpresa)) {
				int key = event.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;
				if (!(numeros)) {
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
	 * private void mostrarMensajeNuevo1() { // Usar un bucle for para mostrar el
	 * mensaje solo una vez for (int i = 0; i < 1; i++) {
	 * JOptionPane.showMessageDialog(this,
	 * "El botón 'Nuevo' se utiliza para añadir un nuevo proveedor.", "Información",
	 * JOptionPane.INFORMATION_MESSAGE); } } private void mostrarMensajeNuevo2() {
	 * if (primerUsoNuevo) { JOptionPane.showMessageDialog(this,
	 * "El botón 'Nuevo' se utiliza para añadir un nuevo proveedor.", "Información",
	 * JOptionPane.INFORMATION_MESSAGE); primerUsoNuevo = false; } }
	 */

	private void limpiarCampos() {
		// Limpiar campos
		txtFldNombreProveedor.setText("");
		txtFldApellidoProveedor.setText("");
		txtFldTelefonoProveedor.setText("");
		txtFldDireccionProveedor.setText("");
		txtFldCorreoProveedor.setText("");
		txtFldIdEmpresa.setText("");
	}

	private void habilitarCampos() {
		// Habilitar campos de agg información
		txtFldNombreProveedor.setEnabled(true);
		txtFldApellidoProveedor.setEnabled(true);
		txtFldTelefonoProveedor.setEnabled(true);
		txtFldDireccionProveedor.setEnabled(true);
		txtFldCorreoProveedor.setEnabled(true);
		txtFldIdEmpresa.setEnabled(true);
	}

	private void dehabilitarCampos() {
		// Deshabilitar campos
		txtFldNombreProveedor.setEnabled(false);
		txtFldApellidoProveedor.setEnabled(false);
		txtFldTelefonoProveedor.setEnabled(false);
		txtFldDireccionProveedor.setEnabled(false);
		txtFldCorreoProveedor.setEnabled(false);
		txtFldIdEmpresa.setEnabled(false);
	}

	private void guardarProveedor() {
		String nombre = txtFldNombreProveedor.getText();
		String apellido = txtFldApellidoProveedor.getText();
		String telefono = txtFldTelefonoProveedor.getText();
		String correo = txtFldCorreoProveedor.getText();
		String direccion = txtFldDireccionProveedor.getText();
		int idEmpresa = Integer.parseInt(txtFldIdEmpresa.getText().toString());

		MProveedores proveedor = new MProveedores(nombre, apellido, telefono, correo, direccion, idEmpresa);
		controladorProveedor.anadirProveedor(proveedor);
	}

	private void seleccionarID() {
		int filaSeleccionada = tablaP.getSelectedRow();
		if (filaSeleccionada >= 0) {
			idSeleccionado = (int) modeloTablaP.getValueAt(filaSeleccionada, 0);
			txtFldNombreProveedor.setText((String) modeloTablaP.getValueAt(filaSeleccionada, 1));
			txtFldApellidoProveedor.setText((String) modeloTablaP.getValueAt(filaSeleccionada, 2));
			txtFldTelefonoProveedor.setText((String) modeloTablaP.getValueAt(filaSeleccionada, 3));
			txtFldCorreoProveedor.setText((String) modeloTablaP.getValueAt(filaSeleccionada, 4));
			txtFldDireccionProveedor.setText((String) modeloTablaP.getValueAt(filaSeleccionada, 5));
			txtFldIdEmpresa.setText(String.valueOf(modeloTablaP.getValueAt(filaSeleccionada, 6)));
		} else {
			JOptionPane.showMessageDialog(this, "Debe seleccionar algún campo.");
		}
	}

	private void modificarCliente() {
		if (idSeleccionado != -1) {
			String nombre = txtFldNombreProveedor.getText();
			String apellido = txtFldApellidoProveedor.getText();
			String telefono = txtFldTelefonoProveedor.getText();
			String correo = txtFldCorreoProveedor.getText();
			String direccion = txtFldDireccionProveedor.getText();
			int idEmpresa = Integer.parseInt(txtFldIdEmpresa.getText());
			
			controladorProveedor.actualizarCliente(idSeleccionado, nombre, apellido, telefono, correo, direccion, idEmpresa);
		} else {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente para modificar.");
		}
	}
	
	private void eliminarProveedor() {
		int filaSeleccionada = tablaP.getSelectedRow();
		int idProveedor = (int) modeloTablaP.getValueAt(filaSeleccionada, 0);
		controladorProveedor.eliminarProveedor(idProveedor);
	}

	private void mostrarTablaP() {
		List<MProveedores> listaProveedores = controladorProveedor.mostrarProveedores();
		modeloTablaP.setRowCount(0); // Limpiar la tabla antes de llenarla

		for (MProveedores proveedor : listaProveedores) {
			Object[] fila = { proveedor.getIdProveedor(), proveedor.getNombre(), proveedor.getApellido(),
					proveedor.getTelefono(), proveedor.getCorreo(), proveedor.getDireccion(),
					proveedor.getIdEmpresa() };
			modeloTablaP.addRow(fila);
		}
	}
}
