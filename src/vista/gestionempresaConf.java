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

import controlador.CGestionEmpresa;
import modelo.MEmpresa;

public class gestionempresaConf extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFldNombreEmpresa;
	private JButton btnAtras;
	private JLabel lblTelefonoEmpresa;
	private JTextField txtFldTelefonoEmpresa;
	private JLabel lblCorreoEmpresa;
	private JTextField txtFldCorreoEmpresa;
	private JButton btnNuevoEmpresa;
	private JLabel lblNuevoEmpresa;
	private JButton btnGuardarEmpresa;
	private JLabel lblGuardarEmpresa;
	private JButton btnActualizarEmpresa;
	private JLabel lblActualizarEmpresa;
	private JButton btnEliminarEmpresa;
	private JLabel lblBorrarEmpresa;
	private JButton btnLimpiarEmpresa;
	private JLabel lblLimpiarEmpresa;
	private JTable tabla;
	private static Locale idioma;
	private static ResourceBundle et;
	private DefaultTableModel modeloTabla;
	private CGestionEmpresa controladorEmpresa;
	private int idSeleccionado = -1;
	private JButton btnModificarEmpresa;
	// private boolean primerUsoNuevo = true;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionempresaConf frame = new gestionempresaConf(idioma);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public gestionempresaConf(Locale idioma) {
		// Internacionalización
		gestionempresaConf.idioma = idioma;
		et = ResourceBundle.getBundle("properties/dic", idioma);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 602);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 244, 244));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblGestionEmpresa = new JLabel(et.getString("gestionempresa"));
		lblGestionEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionEmpresa.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblGestionEmpresa.setBounds(10, 30, 935, 40);
		contentPane.add(lblGestionEmpresa);

		JLabel lblNombreEmpresa = new JLabel(et.getString("nombreproveedor"));
		lblNombreEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreEmpresa.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNombreEmpresa.setBounds(27, 150, 256, 20);
		contentPane.add(lblNombreEmpresa);

		txtFldNombreEmpresa = new JTextField();
		txtFldNombreEmpresa.setBounds(27, 173, 256, 20);
		contentPane.add(txtFldNombreEmpresa);
		txtFldNombreEmpresa.setColumns(10);
		txtFldNombreEmpresa.setEnabled(false);

		btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(gestionempresaConf.class.getResource("/imagenes/angulo-circulo-izquierda.png")));
		btnAtras.setBounds(10, 10, 39, 33);
		contentPane.add(btnAtras);
		btnAtras.setOpaque(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);

		lblTelefonoEmpresa = new JLabel(et.getString("telefonoproveedor"));
		lblTelefonoEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefonoEmpresa.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblTelefonoEmpresa.setBounds(27, 215, 256, 20);
		contentPane.add(lblTelefonoEmpresa);

		txtFldTelefonoEmpresa = new JTextField();
		txtFldTelefonoEmpresa.setColumns(10);
		txtFldTelefonoEmpresa.setBounds(27, 238, 256, 20);
		contentPane.add(txtFldTelefonoEmpresa);
		txtFldTelefonoEmpresa.setEnabled(false);

		lblCorreoEmpresa = new JLabel(et.getString("correoproveedor"));
		lblCorreoEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreoEmpresa.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblCorreoEmpresa.setBounds(27, 280, 256, 20);
		contentPane.add(lblCorreoEmpresa);

		txtFldCorreoEmpresa = new JTextField();
		txtFldCorreoEmpresa.setColumns(10);
		txtFldCorreoEmpresa.setBounds(27, 303, 256, 20);
		contentPane.add(txtFldCorreoEmpresa);
		txtFldCorreoEmpresa.setEnabled(false);

		btnNuevoEmpresa = new JButton("");
		btnNuevoEmpresa.setIcon(new ImageIcon(gestionempresaConf.class.getResource("/imagenes/anadir.png")));
		btnNuevoEmpresa.setVerticalAlignment(SwingConstants.TOP);
		btnNuevoEmpresa.setOpaque(false);
		btnNuevoEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNuevoEmpresa.setContentAreaFilled(false);
		btnNuevoEmpresa.setBorderPainted(false);
		btnNuevoEmpresa.setBounds(388, 80, 30, 30);
		contentPane.add(btnNuevoEmpresa);

		lblNuevoEmpresa = new JLabel(et.getString("nuevo"));
		lblNuevoEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoEmpresa.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblNuevoEmpresa.setBounds(368, 110, 70, 20);
		contentPane.add(lblNuevoEmpresa);

		btnGuardarEmpresa = new JButton("");
		btnGuardarEmpresa.setIcon(new ImageIcon(gestionempresaConf.class.getResource("/imagenes/salvar.png")));
		btnGuardarEmpresa.setOpaque(false);
		btnGuardarEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGuardarEmpresa.setEnabled(false);
		btnGuardarEmpresa.setContentAreaFilled(false);
		btnGuardarEmpresa.setBorderPainted(false);
		btnGuardarEmpresa.setBounds(457, 80, 30, 30);
		contentPane.add(btnGuardarEmpresa);

		lblGuardarEmpresa = new JLabel(et.getString("guardar"));
		lblGuardarEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuardarEmpresa.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblGuardarEmpresa.setBounds(437, 110, 70, 20);
		contentPane.add(lblGuardarEmpresa);

		btnActualizarEmpresa = new JButton("");
		btnActualizarEmpresa
				.setIcon(new ImageIcon(gestionempresaConf.class.getResource("/imagenes/actualizar-flecha.png")));
		btnActualizarEmpresa.setOpaque(false);
		btnActualizarEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnActualizarEmpresa.setContentAreaFilled(false);
		btnActualizarEmpresa.setBorderPainted(false);
		btnActualizarEmpresa.setBounds(526, 80, 30, 30);
		contentPane.add(btnActualizarEmpresa);

		lblActualizarEmpresa = new JLabel(et.getString("actualizar"));
		lblActualizarEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualizarEmpresa.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblActualizarEmpresa.setBounds(506, 110, 70, 20);
		contentPane.add(lblActualizarEmpresa);

		btnEliminarEmpresa = new JButton("");
		btnEliminarEmpresa.setIcon(new ImageIcon(gestionempresaConf.class.getResource("/imagenes/borrar (1).png")));
		btnEliminarEmpresa.setOpaque(false);
		btnEliminarEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEliminarEmpresa.setContentAreaFilled(false);
		btnEliminarEmpresa.setBorderPainted(false);
		btnEliminarEmpresa.setBounds(595, 80, 30, 30);
		contentPane.add(btnEliminarEmpresa);

		lblBorrarEmpresa = new JLabel(et.getString("borrar"));
		lblBorrarEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrarEmpresa.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblBorrarEmpresa.setBounds(575, 110, 70, 20);
		contentPane.add(lblBorrarEmpresa);

		btnLimpiarEmpresa = new JButton("");
		btnLimpiarEmpresa.setIcon(new ImageIcon(gestionempresaConf.class.getResource("/imagenes/escoba.png")));
		btnLimpiarEmpresa.setOpaque(false);
		btnLimpiarEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLimpiarEmpresa.setContentAreaFilled(false);
		btnLimpiarEmpresa.setBorderPainted(false);
		btnLimpiarEmpresa.setBounds(664, 80, 30, 30);
		contentPane.add(btnLimpiarEmpresa);

		lblLimpiarEmpresa = new JLabel(et.getString("limpiar"));
		lblLimpiarEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblLimpiarEmpresa.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblLimpiarEmpresa.setBounds(644, 110, 70, 20);
		contentPane.add(lblLimpiarEmpresa);

		// Crear la tabla de proveedores
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn(et.getString("idempresa"));
		modeloTabla.addColumn(et.getString("nombreempresa"));
		modeloTabla.addColumn(et.getString("telefonoempresa"));
		modeloTabla.addColumn(et.getString("correoempresa"));

		tabla = new JTable(modeloTabla);

		JScrollPane scrollPaneE = new JScrollPane(tabla);
		scrollPaneE.setBounds(320, 150, 600, 400);
		contentPane.add(scrollPaneE);
		
		btnModificarEmpresa = new JButton("");
		btnModificarEmpresa.setIcon(new ImageIcon(gestionempresaConf.class.getResource("/imagenes/boligrafo-cuadrado.png")));
		btnModificarEmpresa.setOpaque(false);
		btnModificarEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnModificarEmpresa.setEnabled(false);
		btnModificarEmpresa.setContentAreaFilled(false);
		btnModificarEmpresa.setBorderPainted(false);
		btnModificarEmpresa.setBounds(733, 80, 30, 30);
		contentPane.add(btnModificarEmpresa);
		
		JLabel lblModificarEmpresa = new JLabel(et.getString("modify"));
		lblModificarEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarEmpresa.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblModificarEmpresa.setBounds(713, 110, 70, 20);
		contentPane.add(lblModificarEmpresa);

		// Manejadores
		ManejadorBotones EscuchadorBotones = new ManejadorBotones();
		ManejadorKey KeyBotones = new ManejadorKey();
		
		// Botones
		btnAtras.addActionListener(EscuchadorBotones);
		btnNuevoEmpresa.addActionListener(EscuchadorBotones);
		btnGuardarEmpresa.addActionListener(EscuchadorBotones);
		btnActualizarEmpresa.addActionListener(EscuchadorBotones);
		btnEliminarEmpresa.addActionListener(EscuchadorBotones);
		btnLimpiarEmpresa.addActionListener(EscuchadorBotones);
		btnModificarEmpresa.addActionListener(EscuchadorBotones);

		// Validaciones
		txtFldNombreEmpresa.addKeyListener(KeyBotones);
		txtFldTelefonoEmpresa.addKeyListener(KeyBotones);
		txtFldCorreoEmpresa.addKeyListener(KeyBotones);

		// Inicializar controladores
		controladorEmpresa = new CGestionEmpresa();
		mostrarTabla();
	}
	
	public class ManejadorBotones implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			if (evento.getSource().equals(btnAtras)) {
				configuracion gestionempresaConf = new configuracion(idioma);
				gestionempresaConf.setVisible(true);
				dispose();
			}
			if (evento.getSource().equals(btnNuevoEmpresa)) {
				habilitarCampos();
				btnNuevoEmpresa.setEnabled(false);
				btnGuardarEmpresa.setEnabled(true);
				btnEliminarEmpresa.setEnabled(false);
				btnActualizarEmpresa.setEnabled(false);
				btnLimpiarEmpresa.setEnabled(true);
				btnModificarEmpresa.setEnabled(false);
			}
			if (evento.getSource().equals(btnGuardarEmpresa)) {
				// Guaradar datos en la BD
				guardarEmpresa();
				// Mostrar informacion nueva
				mostrarTabla();
				// Limpiar campos despues de guardar
				limpiarCampos();
				// Deshabilitar campos despues de guardar
				dehabilitarCampos();
				btnNuevoEmpresa.setEnabled(true);
				btnGuardarEmpresa.setEnabled(false);
				btnEliminarEmpresa.setEnabled(true);
				btnActualizarEmpresa.setEnabled(true);
				btnLimpiarEmpresa.setEnabled(false);
				btnModificarEmpresa.setEnabled(false);
			}
			if (evento.getSource().equals(btnActualizarEmpresa)) {
				seleccionarID();
				habilitarCampos();
				btnNuevoEmpresa.setEnabled(false);
				btnGuardarEmpresa.setEnabled(false);
				btnEliminarEmpresa.setEnabled(false);
				btnActualizarEmpresa.setEnabled(false);
				btnLimpiarEmpresa.setEnabled(true);
				btnModificarEmpresa.setEnabled(true);
			}
			if(evento.getSource().equals(btnModificarEmpresa)) {
				modificarEmpresa();
				mostrarTabla();
				limpiarCampos();
				dehabilitarCampos();
				btnNuevoEmpresa.setEnabled(true);
				btnGuardarEmpresa.setEnabled(false);
				btnEliminarEmpresa.setEnabled(true);
				btnActualizarEmpresa.setEnabled(true);
				btnLimpiarEmpresa.setEnabled(false);
				btnModificarEmpresa.setEnabled(false);
			}
			if (evento.getSource().equals(btnEliminarEmpresa)) {
				eliminarEmpresa();
				mostrarTabla();
			}
			if (evento.getSource().equals(btnLimpiarEmpresa)) {
				JOptionPane.showMessageDialog(null, et.getString("btnLimpiar"));
				limpiarCampos();
			}
		}
	}

	public class ManejadorKey implements KeyListener {
		public void keyTyped(KeyEvent event) {
			if (event.getSource().equals(txtFldCorreoEmpresa)) {
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
			if (event.getSource().equals(txtFldNombreEmpresa)) {
				int key = event.getKeyChar();
				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean numeros = key >= 48 && key <= 57;
				boolean space = key == 32;
				if (!(minusculas || mayusculas || numeros || space)) {
					event.consume();
				}
			}
			if (event.getSource().equals(txtFldTelefonoEmpresa)) {
				int key = event.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;
				if (!(numeros)) {
					event.consume();
				}
				if (txtFldTelefonoEmpresa.getText().trim().length() == 10) {
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
		txtFldNombreEmpresa.setText("");
		txtFldTelefonoEmpresa.setText("");
		txtFldCorreoEmpresa.setText("");
	}

	private void habilitarCampos() {
		// Habilitar campos de agg información
		txtFldNombreEmpresa.setEnabled(true);
		txtFldTelefonoEmpresa.setEnabled(true);
		txtFldCorreoEmpresa.setEnabled(true);
	}

	private void dehabilitarCampos() {
		// Deshabilitar campos
		txtFldNombreEmpresa.setEnabled(false);
		txtFldTelefonoEmpresa.setEnabled(false);
		txtFldCorreoEmpresa.setEnabled(false);
	}

	private void guardarEmpresa() {
		String nombre = txtFldNombreEmpresa.getText();
		String telefono = txtFldTelefonoEmpresa.getText();
		String correo = txtFldCorreoEmpresa.getText();

		MEmpresa empresa = new MEmpresa(nombre, telefono, correo);
		controladorEmpresa.anadirEmpresa(empresa);
	}

	private void seleccionarID() {
		int filaSeleccionada = tabla.getSelectedRow();
		if (filaSeleccionada >= 0) {
			idSeleccionado = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
			txtFldNombreEmpresa.setText((String) modeloTabla.getValueAt(filaSeleccionada, 1));
			txtFldTelefonoEmpresa.setText((String) modeloTabla.getValueAt(filaSeleccionada, 2));
			txtFldCorreoEmpresa.setText((String) modeloTabla.getValueAt(filaSeleccionada, 3));
		} else {
			JOptionPane.showMessageDialog(this, "Debe seleccionar algún campo.");
		}
	}

	private void modificarEmpresa() {
		if (idSeleccionado != -1) {
			String nombre = txtFldNombreEmpresa.getText();
			String telefono = txtFldTelefonoEmpresa.getText();
			String correo = txtFldCorreoEmpresa.getText();
			
			controladorEmpresa.actualizarEmpresa(idSeleccionado, nombre, telefono, correo);
		} else {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente para modificar.");
		}
	}
	
	private void eliminarEmpresa() {
		int filaSeleccionada = tabla.getSelectedRow();
		int idEmpresa = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
		controladorEmpresa.eliminarEmpresa(idEmpresa);
	}

	private void mostrarTabla() {
		List<MEmpresa> listaEmpresa = controladorEmpresa.mostrarEmpresa();
		modeloTabla.setRowCount(0); // Limpiar la tabla antes de llenarla

		for (MEmpresa empresa : listaEmpresa) {
			Object[] fila = { empresa.getIdEmpresa(), empresa.getNombre(),
					empresa.getTelefono(), empresa.getCorreo() };
			modeloTabla.addRow(fila);
		}
	}
}
