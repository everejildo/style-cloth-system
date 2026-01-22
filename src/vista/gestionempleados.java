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

import javax.swing.DefaultComboBoxModel;
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

import controlador.CGestionEmpleados;
import controlador.CProductos;
import modelo.MEmpleado;
import javax.swing.JComboBox;

public class gestionempleados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFldNombreEmpleado;
	private JTextField txtFldApellidoEmpleado;
	private JTextField txtFldTelefonoEmpleado;
	private JButton btnNuevoEmpleado;
	private JButton btnAtras;
	private JLabel lblDireccionEmpleado;
	private JLabel lblFechaEmpleado;
	private JDateChooser dtChsrRegistroEmpleado;
	private JButton btnGuardarEmpleado;
	private JButton btnActualizarEmpleado;
	private JButton btnEliminarEmpleado;
	private JButton btnLimpiarEmpleado;
	private JLabel lblGuardarEmpleado;
	private JLabel lblActualizarEmpleado;
	private JLabel lblBorrarEmpleado;
	private JLabel lblLimpiarEmpleado;
	private JLabel lblPuestoEmpleado;
	private JTextField txtFldCorreoEmpleado;
	private JTextField txtFldDireccionEmpleado;
	private DefaultTableModel modeloTabla;
	private JTable tablaEmpleado;
	private static Locale idioma;
	private static ResourceBundle et;
	private CGestionEmpleados controladorEmpleado;
	private JButton btnModificarUpdate;
	private int idSeleccionado = -1;
	private Date hoy;
	private JLabel lblModificar;
	private JLabel lblRfcEmpleado;
	private JTextField txtFldRfcEmpleado;
	private JButton btnAggPuesto;
	private JComboBox cmbBxPuestoEmpleado;
	private DefaultComboBoxModel<String> DatosPuesto;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionempleados frame = new gestionempleados(idioma);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public gestionempleados(Locale idioma) {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(gestionempleados.class.getResource("/imagenes/v914-ning-21a.png")));
		// Internacionalización
		gestionempleados.idioma = idioma;
		et = ResourceBundle.getBundle("properties/dic", idioma);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 656);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 244, 244));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblGestionEmpleado = new JLabel(et.getString("gestionempleado"));
		lblGestionEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionEmpleado.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblGestionEmpleado.setBounds(10, 30, 935, 40);
		contentPane.add(lblGestionEmpleado);

		JLabel lblNombreEmpleado = new JLabel(et.getString("nombreemple"));
		lblNombreEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreEmpleado.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNombreEmpleado.setBounds(20, 127, 256, 20);
		contentPane.add(lblNombreEmpleado);

		txtFldNombreEmpleado = new JTextField();
		txtFldNombreEmpleado.setBounds(20, 150, 256, 20);
		contentPane.add(txtFldNombreEmpleado);
		txtFldNombreEmpleado.setColumns(10);
		txtFldNombreEmpleado.setEnabled(false);

		JLabel lblApellidoEmpleado = new JLabel(et.getString("apellidoemple"));
		lblApellidoEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidoEmpleado.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblApellidoEmpleado.setBounds(20, 180, 256, 20);
		contentPane.add(lblApellidoEmpleado);

		txtFldApellidoEmpleado = new JTextField();
		txtFldApellidoEmpleado.setColumns(10);
		txtFldApellidoEmpleado.setBounds(20, 203, 256, 20);
		contentPane.add(txtFldApellidoEmpleado);
		txtFldApellidoEmpleado.setEnabled(false);

		JLabel lblTelefonoEmpleado = new JLabel(et.getString("telefonoemple"));
		lblTelefonoEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefonoEmpleado.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblTelefonoEmpleado.setBounds(20, 233, 256, 20);
		contentPane.add(lblTelefonoEmpleado);

		txtFldTelefonoEmpleado = new JTextField();
		txtFldTelefonoEmpleado.setColumns(10);
		txtFldTelefonoEmpleado.setBounds(20, 256, 256, 20);
		contentPane.add(txtFldTelefonoEmpleado);
		txtFldTelefonoEmpleado.setEnabled(false);

		btnNuevoEmpleado = new JButton("");
		btnNuevoEmpleado.setVerticalAlignment(SwingConstants.TOP);
		btnNuevoEmpleado.setIcon(new ImageIcon(gestionempleados.class.getResource("/imagenes/anadir.png")));
		btnNuevoEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNuevoEmpleado.setBounds(363, 80, 30, 30);
		contentPane.add(btnNuevoEmpleado);
		btnNuevoEmpleado.setOpaque(false);
		btnNuevoEmpleado.setContentAreaFilled(false);
		btnNuevoEmpleado.setBorderPainted(false);

		btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(gestionempleados.class.getResource("/imagenes/angulo-circulo-izquierda.png")));
		btnAtras.setOpaque(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		btnAtras.setBounds(10, 10, 38, 33);
		contentPane.add(btnAtras);

		JLabel lblCorreoEmpleado = new JLabel(et.getString("correoemple"));
		lblCorreoEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreoEmpleado.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblCorreoEmpleado.setBounds(20, 286, 256, 20);
		contentPane.add(lblCorreoEmpleado);

		lblDireccionEmpleado = new JLabel(et.getString("direccionemple"));
		lblDireccionEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccionEmpleado.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblDireccionEmpleado.setBounds(20, 339, 256, 20);
		contentPane.add(lblDireccionEmpleado);

		lblFechaEmpleado = new JLabel(et.getString("fechaRemple"));
		lblFechaEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaEmpleado.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblFechaEmpleado.setBounds(20, 445, 256, 20);
		contentPane.add(lblFechaEmpleado);

		hoy = new Date();

		dtChsrRegistroEmpleado = new JDateChooser();
		dtChsrRegistroEmpleado.setDateFormatString("dd/MM/yyyy");
		dtChsrRegistroEmpleado.setDate(hoy);
		dtChsrRegistroEmpleado.setMaxSelectableDate(hoy);
		dtChsrRegistroEmpleado.setMinSelectableDate(hoy);
		dtChsrRegistroEmpleado.setBounds(20, 468, 256, 20);
		contentPane.add(dtChsrRegistroEmpleado);
		dtChsrRegistroEmpleado.setEnabled(false);
		// Deshabilitar la edición del campo de texto del JDateChooser
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dtChsrRegistroEmpleado.getDateEditor();
		editor.setEditable(false);

		btnGuardarEmpleado = new JButton("");
		btnGuardarEmpleado.setIcon(new ImageIcon(gestionempleados.class.getResource("/imagenes/salvar.png")));
		btnGuardarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGuardarEmpleado.setBounds(432, 80, 30, 30);
		contentPane.add(btnGuardarEmpleado);
		btnGuardarEmpleado.setOpaque(false);
		btnGuardarEmpleado.setContentAreaFilled(false);
		btnGuardarEmpleado.setBorderPainted(false);
		btnGuardarEmpleado.setEnabled(false);

		btnActualizarEmpleado = new JButton("");
		btnActualizarEmpleado
				.setIcon(new ImageIcon(gestionempleados.class.getResource("/imagenes/actualizar-flecha.png")));
		btnActualizarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnActualizarEmpleado.setBounds(501, 80, 30, 30);
		contentPane.add(btnActualizarEmpleado);
		btnActualizarEmpleado.setOpaque(false);
		btnActualizarEmpleado.setContentAreaFilled(false);
		btnActualizarEmpleado.setBorderPainted(false);

		btnEliminarEmpleado = new JButton("");
		btnEliminarEmpleado.setToolTipText("Seleccionar en la tabla especificamente el campo ID");
		btnEliminarEmpleado.setIcon(new ImageIcon(gestionempleados.class.getResource("/imagenes/borrar (1).png")));
		btnEliminarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEliminarEmpleado.setBounds(570, 80, 30, 30);
		contentPane.add(btnEliminarEmpleado);
		btnEliminarEmpleado.setOpaque(false);
		btnEliminarEmpleado.setContentAreaFilled(false);
		btnEliminarEmpleado.setBorderPainted(false);

		btnLimpiarEmpleado = new JButton("");
		btnLimpiarEmpleado.setIcon(new ImageIcon(gestionempleados.class.getResource("/imagenes/escoba.png")));
		btnLimpiarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLimpiarEmpleado.setBounds(639, 80, 30, 30);
		contentPane.add(btnLimpiarEmpleado);
		btnLimpiarEmpleado.setOpaque(false);
		btnLimpiarEmpleado.setContentAreaFilled(false);
		btnLimpiarEmpleado.setBorderPainted(false);

		btnModificarUpdate = new JButton();
		btnModificarUpdate
				.setIcon(new ImageIcon(gestionempleados.class.getResource("/imagenes/boligrafo-cuadrado.png")));
		btnModificarUpdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnModificarUpdate.setBounds(708, 80, 30, 30);
		contentPane.add(btnModificarUpdate);
		btnModificarUpdate.setEnabled(false);
		btnModificarUpdate.setOpaque(false);
		btnModificarUpdate.setContentAreaFilled(false);
		btnModificarUpdate.setBorderPainted(false);

		JLabel lblNuevoEmpleado = new JLabel(et.getString("nuevo"));
		lblNuevoEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoEmpleado.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblNuevoEmpleado.setBounds(343, 110, 70, 20);
		contentPane.add(lblNuevoEmpleado);

		lblGuardarEmpleado = new JLabel(et.getString("guardar"));
		lblGuardarEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuardarEmpleado.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblGuardarEmpleado.setBounds(412, 110, 70, 20);
		contentPane.add(lblGuardarEmpleado);

		lblActualizarEmpleado = new JLabel(et.getString("actualizar"));
		lblActualizarEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualizarEmpleado.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblActualizarEmpleado.setBounds(481, 110, 70, 20);
		contentPane.add(lblActualizarEmpleado);

		lblBorrarEmpleado = new JLabel(et.getString("borrar"));
		lblBorrarEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrarEmpleado.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblBorrarEmpleado.setBounds(550, 110, 70, 20);
		contentPane.add(lblBorrarEmpleado);

		lblLimpiarEmpleado = new JLabel(et.getString("limpiar"));
		lblLimpiarEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblLimpiarEmpleado.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblLimpiarEmpleado.setBounds(619, 110, 70, 20);
		contentPane.add(lblLimpiarEmpleado);

		lblModificar = new JLabel(et.getString("modify"));
		lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificar.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lblModificar.setBounds(688, 110, 70, 20);
		contentPane.add(lblModificar);

		lblPuestoEmpleado = new JLabel(et.getString("puestoemple"));
		lblPuestoEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuestoEmpleado.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblPuestoEmpleado.setBounds(20, 392, 256, 20);
		contentPane.add(lblPuestoEmpleado);

		txtFldCorreoEmpleado = new JTextField();
		txtFldCorreoEmpleado.setColumns(10);
		txtFldCorreoEmpleado.setBounds(20, 309, 256, 20);
		contentPane.add(txtFldCorreoEmpleado);
		txtFldCorreoEmpleado.setEnabled(false);

		txtFldDireccionEmpleado = new JTextField();
		txtFldDireccionEmpleado.setColumns(10);
		txtFldDireccionEmpleado.setBounds(20, 362, 256, 20);
		contentPane.add(txtFldDireccionEmpleado);
		txtFldDireccionEmpleado.setEnabled(false);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(300, 150, 640, 344);
		contentPane.add(scrollPane);

		modeloTabla = new DefaultTableModel();
		modeloTabla.setColumnIdentifiers(
				new String[] { et.getString("idemple"), et.getString("nombreemple"), et.getString("apellidoemple"),
						et.getString("telefonoemple"), et.getString("correoemple"), et.getString("direccionemple"),
						et.getString("puestoemple"), et.getString("fechaRemple"), et.getString("errefece") });
		tablaEmpleado = new JTable();
		tablaEmpleado.setModel(modeloTabla);
		scrollPane.setViewportView(tablaEmpleado);

		lblRfcEmpleado = new JLabel(et.getString("errefece"));
		lblRfcEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblRfcEmpleado.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblRfcEmpleado.setBounds(20, 498, 256, 20);
		contentPane.add(lblRfcEmpleado);

		txtFldRfcEmpleado = new JTextField();
		txtFldRfcEmpleado.setBounds(20, 521, 256, 19);
		contentPane.add(txtFldRfcEmpleado);
		txtFldRfcEmpleado.setColumns(10);
		txtFldRfcEmpleado.setEnabled(false);
		
		btnAggPuesto = new JButton("");
		btnAggPuesto.setIcon(new ImageIcon(gestionempleados.class.getResource("/imagenes/capa-mas.png")));
		btnAggPuesto.setBounds(253, 415, 23, 23);
		contentPane.add(btnAggPuesto);
		btnAggPuesto.setOpaque(false);
		btnAggPuesto.setContentAreaFilled(false);
		btnAggPuesto.setBorderPainted(false);
		
		DatosPuesto = new DefaultComboBoxModel<String>();
		DatosPuesto = CGestionEmpleados.cmbBxPuesto();
		
		cmbBxPuestoEmpleado = new JComboBox(DatosPuesto);
		cmbBxPuestoEmpleado.setBounds(20, 415, 230, 20);
		contentPane.add(cmbBxPuestoEmpleado);

		// Manejador
		ManejadorBotones EscuchadorBotones = new ManejadorBotones();
		ManejadorKey KeyBotones = new ManejadorKey();

		// Botones
		btnAtras.addActionListener(EscuchadorBotones);
		btnNuevoEmpleado.addActionListener(EscuchadorBotones);
		btnGuardarEmpleado.addActionListener(EscuchadorBotones);
		btnActualizarEmpleado.addActionListener(EscuchadorBotones);
		btnEliminarEmpleado.addActionListener(EscuchadorBotones);
		btnLimpiarEmpleado.addActionListener(EscuchadorBotones);
		btnModificarUpdate.addActionListener(EscuchadorBotones);
		btnAggPuesto.addActionListener(EscuchadorBotones);

		// BotonesValidaciones
		txtFldNombreEmpleado.addKeyListener(KeyBotones);
		txtFldApellidoEmpleado.addKeyListener(KeyBotones);
		txtFldTelefonoEmpleado.addKeyListener(KeyBotones);
		txtFldCorreoEmpleado.addKeyListener(KeyBotones);
		txtFldDireccionEmpleado.addKeyListener(KeyBotones);
		txtFldRfcEmpleado.addKeyListener(KeyBotones);

		// Inicializar controlador
		controladorEmpleado = new CGestionEmpleados();
		mostrarTablaEmpleado();

	}

	public class ManejadorBotones implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			if (evento.getSource().equals(btnAtras)) {
				// Regresar al menu
				configuracion gestionclientes = new configuracion(idioma);
				gestionclientes.setVisible(true);
				dispose();
			}
			if (evento.getSource().equals(btnNuevoEmpleado)) {
				// Habilitar campos de agg información
				habilitarCampos();
				btnNuevoEmpleado.setEnabled(false);
				btnGuardarEmpleado.setEnabled(true);
				btnEliminarEmpleado.setEnabled(false);
				btnActualizarEmpleado.setEnabled(false);
				btnLimpiarEmpleado.setEnabled(true);
				btnModificarUpdate.setEnabled(false);
			}
			if (evento.getSource().equals(btnGuardarEmpleado)) {
				// Guardar datos en BD
				guardarCliente();
				// Actualizar tabla
				mostrarTablaEmpleado();
				// Limpiar campos
				limpiarCampos();
				// Desabilitar campos de agg información
				deshabilitarCampos();
				// Deshabilitar btnGuardar
				btnNuevoEmpleado.setEnabled(true);
				btnGuardarEmpleado.setEnabled(false);
				btnEliminarEmpleado.setEnabled(true);
				btnActualizarEmpleado.setEnabled(true);
				btnLimpiarEmpleado.setEnabled(false);
				btnModificarUpdate.setEnabled(false);
			}
			if (evento.getSource().equals(btnActualizarEmpleado)) {
				// Habilitar campos de agg información
				habilitarCampos();
				// Cargar datos del cliente seleccionado
				seleccionarID();
				// Deshabilitar btnGuardar y habilitar btnModificar
				btnNuevoEmpleado.setEnabled(false);
				btnGuardarEmpleado.setEnabled(false);
				btnEliminarEmpleado.setEnabled(false);
				btnActualizarEmpleado.setEnabled(false);
				btnLimpiarEmpleado.setEnabled(true);
				btnModificarUpdate.setEnabled(true);
			}
			if (evento.getSource().equals(btnModificarUpdate)) {
				// Guardar cambios realizados
				modificarEmpleado();
				// Actualizar tabla
				mostrarTablaEmpleado();
				// Limpiar campos
				limpiarCampos();
				// Deshabilitar campos y botones
				deshabilitarCampos();
				btnNuevoEmpleado.setEnabled(true);
				btnGuardarEmpleado.setEnabled(false);
				btnEliminarEmpleado.setEnabled(true);
				btnActualizarEmpleado.setEnabled(true);
				btnLimpiarEmpleado.setEnabled(false);
				btnModificarUpdate.setEnabled(false);
			}
			if (evento.getSource().equals(btnEliminarEmpleado)) {
				eliminarEmpleado();
				// Actualizar la tabla después de eliminar
				mostrarTablaEmpleado();
			}
			if (evento.getSource().equals(btnLimpiarEmpleado)) {
				// Limpiar campos
				limpiarCampos();

				JOptionPane.showMessageDialog(null, et.getString("btnLimpiar"));
			}
			if(evento.getSource().equals(btnAggPuesto)) {
				puesto gestionclientes = new puesto(idioma);
				gestionclientes.setVisible(true);
				dispose();
			}
		}
	}

	private void limpiarCampos() {
		// Limpiar campos
		txtFldNombreEmpleado.setText("");
		txtFldApellidoEmpleado.setText("");
		txtFldTelefonoEmpleado.setText("");
		txtFldCorreoEmpleado.setText("");
		txtFldDireccionEmpleado.setText("");
		dtChsrRegistroEmpleado.setDate(hoy);
		txtFldRfcEmpleado.setText("");
		cmbBxPuestoEmpleado.setSelectedIndex(0);
	}

	private void habilitarCampos() {
		// Habilitar campos de agg información
		txtFldNombreEmpleado.setEnabled(true);
		txtFldApellidoEmpleado.setEnabled(true);
		txtFldTelefonoEmpleado.setEnabled(true);
		txtFldCorreoEmpleado.setEnabled(true);
		txtFldDireccionEmpleado.setEnabled(true);
		dtChsrRegistroEmpleado.setEnabled(true);
		txtFldRfcEmpleado.setEnabled(true);
		cmbBxPuestoEmpleado.setEnabled(true);
	}

	private void deshabilitarCampos() {
		// Habilitar campos de agg información
		txtFldNombreEmpleado.setEnabled(false);
		txtFldApellidoEmpleado.setEnabled(false);
		txtFldTelefonoEmpleado.setEnabled(false);
		txtFldCorreoEmpleado.setEnabled(false);
		txtFldDireccionEmpleado.setEnabled(false);
		dtChsrRegistroEmpleado.setEnabled(false);
		txtFldRfcEmpleado.setEnabled(false);
		cmbBxPuestoEmpleado.setEnabled(false);
	}

	private void guardarCliente() {
		// Guardar datos en bd
		String nombre = txtFldNombreEmpleado.getText();
		String apellido = txtFldApellidoEmpleado.getText();
		String telefono = txtFldTelefonoEmpleado.getText();
		String correo = txtFldCorreoEmpleado.getText();
		String direccion = txtFldDireccionEmpleado.getText();
		Date fechaRegistro = dtChsrRegistroEmpleado.getDate();
		String rfc = txtFldRfcEmpleado.getText();
		String puesto = cmbBxPuestoEmpleado.getSelectedItem().toString();

		MEmpleado empleado = new MEmpleado(nombre, apellido, direccion, telefono, correo, rfc, fechaRegistro, puesto);
		controladorEmpleado.anadirEmpleado(empleado);
	}

	private void seleccionarID() {
		int filaSeleccionada = tablaEmpleado.getSelectedRow();
		if (filaSeleccionada >= 0) {
			idSeleccionado = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
			txtFldNombreEmpleado.setText((String) modeloTabla.getValueAt(filaSeleccionada, 1));
			txtFldApellidoEmpleado.setText((String) modeloTabla.getValueAt(filaSeleccionada, 2));
			txtFldTelefonoEmpleado.setText((String) modeloTabla.getValueAt(filaSeleccionada, 3));
			txtFldCorreoEmpleado.setText((String) modeloTabla.getValueAt(filaSeleccionada, 4));
			txtFldDireccionEmpleado.setText((String) modeloTabla.getValueAt(filaSeleccionada, 5));
			cmbBxPuestoEmpleado.setSelectedItem(modeloTabla.getValueAt(filaSeleccionada, 6));
			txtFldRfcEmpleado.setText((String) modeloTabla.getValueAt(filaSeleccionada, 8));
		} else {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un campo.");
		}
	}

	private void modificarEmpleado() {
		if (idSeleccionado != -1) {
			String nombre = txtFldNombreEmpleado.getText();
			String apellido = txtFldApellidoEmpleado.getText();
			String telefono = txtFldTelefonoEmpleado.getText();
			String correo = txtFldCorreoEmpleado.getText();
			String direccion = txtFldDireccionEmpleado.getText();
			String puesto = (String) cmbBxPuestoEmpleado.getSelectedItem();
			// Date fechaRegistro = dtChsrRegistroEmpleado.getDate();
			String rfc = txtFldRfcEmpleado.getText();

			controladorEmpleado.actualizarEmpleado(idSeleccionado, nombre, apellido, direccion, telefono, correo, rfc,
					puesto);
		} else {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente para modificar.");
		}
	}

	private void eliminarEmpleado() {
		int filaSeleccionada = tablaEmpleado.getSelectedRow();
		int idEmple = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
		controladorEmpleado.eliminarEmpleado(idEmple);
	}

	private void mostrarTablaEmpleado() {
		// Limpiar la tabla actual
		modeloTabla.setRowCount(0);

		// Obtener clientes del controlador
		List<MEmpleado> listaEmpleados = controladorEmpleado.obtenerEmpleados();

		// Añadir clientes a la tabla
		for (MEmpleado empleado : listaEmpleados) {
			modeloTabla.addRow(new Object[] { empleado.getIdEmple(), empleado.getNombre(), empleado.getApellido(),
					empleado.getTelefono(), empleado.getCorreo(), empleado.getDireccion(), empleado.getPuesto(),
					empleado.getFechaRegistro(), empleado.getRfc() });
		}
	}

	public class ManejadorKey implements KeyListener {
		public void keyTyped(KeyEvent event) {
			if (event.getSource().equals(txtFldNombreEmpleado)) {
				int key = event.getKeyChar();
				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean space = key == 32;
				if (!(mayusculas || minusculas || space)) {
					event.consume();
				}
			}
			if (event.getSource().equals(txtFldApellidoEmpleado)) {
				int key = event.getKeyChar();
				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean space = key == 32;
				if (!(mayusculas || minusculas || space)) {
					event.consume();
				}
			}
			if (event.getSource().equals(txtFldTelefonoEmpleado)) {
				int key = event.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;
				if (!(numeros)) {
					event.consume();
				}
				if (txtFldTelefonoEmpleado.getText().trim().length() == 10) {
					event.consume();
				}
			}
			if (event.getSource().equals(txtFldCorreoEmpleado)) {
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
			if (event.getSource().equals(txtFldDireccionEmpleado)) {
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
			if (event.getSource().equals(cmbBxPuestoEmpleado)) {
				String selectedItem = (String) cmbBxPuestoEmpleado.getSelectedItem();
		        
		        // Verificar que no se haya seleccionado "Seleccione una opción"
		        if (!selectedItem.equals("Seleccione una opción") && !selectedItem.equals("Seleccione una opcion")) {
		            char keyChar = event.getKeyChar();
		            if (!Character.isDigit(keyChar)) {
		                event.consume(); // Ignora el evento si no es un número
		            }
		        } else {
		            event.consume(); // Ignora todas las entradas si "Seleccione una opción" está seleccionado
		        }
			}
			if (event.getSource().equals(txtFldRfcEmpleado)) {
				int key = event.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;
				boolean mayusculas = key >= 65 && key <= 90;
				if (!(numeros || mayusculas)) {
					event.consume();
				}
				if (txtFldRfcEmpleado.getText().trim().length() == 13) {
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
