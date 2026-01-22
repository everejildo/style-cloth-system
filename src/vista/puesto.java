package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.CPuesto;
import modelo.MPuesto;

public class puesto extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static Locale idioma;
	private static ResourceBundle et;
	private JLabel lblNombrePuesto;
	private JLabel lblSueldoPuesto;
	private JLabel lblDeptoPuesto;
	private JLabel lblTurnoPuesto;
	private JTextField txtFldNombrePuesto;
	private JTextField txtFldSueldoPuesto;
	private JTextField txtFldDeptoPuesto;
	private JTextField txtFldTurnoPuesto;
	private JScrollPane scrollPane;
	private DefaultTableModel modeloTabla;
	private JTable tablaPuesto;
	private JLabel lblNuevoPuesto;
	private JLabel lblGuardarPuesto;
	private JLabel lblActualizarPuesto;
	private JLabel lblEliminarPuesto;
	private JLabel lblLimpiarPuesto;
	private JLabel lblModificarPuesto;
	private JButton btnNuevoPuesto;
	private JButton btnGuardarPuesto;
	private JButton btnActualizarPuesto;
	private JButton btnEliminarPuesto;
	private JButton btnLimpiarPuesto;
	private JButton btnModificarPuesto;
	private CPuesto controladorPuesto;
	private int idSeleccionado = -1;
	private JButton btnAtras;
	
	public static void main(String[] args) {
		try {
			puesto dialog = new puesto(idioma);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public puesto(Locale idioma) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(puesto.class.getResource("/imagenes/v914-ning-21a.png")));
		// Internacionalización
		puesto.idioma = idioma;
		et = ResourceBundle.getBundle("properties/dic", idioma);

		setBounds(100, 100, 900, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblNombrePuesto = new JLabel(et.getString("nombrepuesto"));
			lblNombrePuesto.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			lblNombrePuesto.setHorizontalAlignment(SwingConstants.CENTER);
			lblNombrePuesto.setBounds(20, 100, 200, 20);
			contentPanel.add(lblNombrePuesto);
		}
		{
			lblSueldoPuesto = new JLabel(et.getString("sueldopuesto"));
			lblSueldoPuesto.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			lblSueldoPuesto.setHorizontalAlignment(SwingConstants.CENTER);
			lblSueldoPuesto.setBounds(20, 150, 200, 20);
			contentPanel.add(lblSueldoPuesto);
		}
		{
			lblDeptoPuesto = new JLabel(et.getString("deptopuesto"));
			lblDeptoPuesto.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			lblDeptoPuesto.setHorizontalAlignment(SwingConstants.CENTER);
			lblDeptoPuesto.setBounds(20, 200, 200, 20);
			contentPanel.add(lblDeptoPuesto);
		}
		{
			lblTurnoPuesto = new JLabel(et.getString("turnopuesto"));
			lblTurnoPuesto.setHorizontalAlignment(SwingConstants.CENTER);
			lblTurnoPuesto.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			lblTurnoPuesto.setBounds(20, 250, 200, 20);
			contentPanel.add(lblTurnoPuesto);
		}
		{
			txtFldNombrePuesto = new JTextField();
			txtFldNombrePuesto.setBounds(20, 120, 200, 20);
			contentPanel.add(txtFldNombrePuesto);
			txtFldNombrePuesto.setColumns(10);
			txtFldNombrePuesto.setEnabled(false);
		}
		{
			txtFldSueldoPuesto = new JTextField();
			txtFldSueldoPuesto.setBounds(20, 170, 200, 20);
			contentPanel.add(txtFldSueldoPuesto);
			txtFldSueldoPuesto.setColumns(10);
			txtFldSueldoPuesto.setEnabled(false);
		}
		{
			txtFldDeptoPuesto = new JTextField();
			txtFldDeptoPuesto.setBounds(20, 220, 200, 20);
			contentPanel.add(txtFldDeptoPuesto);
			txtFldDeptoPuesto.setColumns(10);
			txtFldDeptoPuesto.setEnabled(false);
		}
		{
			txtFldTurnoPuesto = new JTextField();
			txtFldTurnoPuesto.setBounds(20, 270, 200, 20);
			contentPanel.add(txtFldTurnoPuesto);
			txtFldTurnoPuesto.setColumns(10);
			txtFldTurnoPuesto.setEnabled(false);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(238, 100, 628, 190);
			contentPanel.add(scrollPane);
		}
		{
			modeloTabla = new DefaultTableModel();
			modeloTabla.setColumnIdentifiers(
					new String[] { et.getString("idpuesto"), et.getString("nombrepuesto"), et.getString("sueldopuesto"),
							et.getString("deptopuesto"), et.getString("turnopuesto") });
		}
		{
			tablaPuesto = new JTable();
			tablaPuesto.setModel(modeloTabla);
			scrollPane.setViewportView(tablaPuesto);
		}
		{
			lblNuevoPuesto = new JLabel(et.getString("nuevo"));
			lblNuevoPuesto.setHorizontalAlignment(SwingConstants.CENTER);
			lblNuevoPuesto.setFont(new Font("Bahnschrift", Font.BOLD, 12));
			lblNuevoPuesto.setBounds(238, 70, 70, 20);
			contentPanel.add(lblNuevoPuesto);
		}
		{
			lblGuardarPuesto = new JLabel(et.getString("guardar"));
			lblGuardarPuesto.setHorizontalAlignment(SwingConstants.CENTER);
			lblGuardarPuesto.setFont(new Font("Bahnschrift", Font.BOLD, 12));
			lblGuardarPuesto.setBounds(307, 70, 70, 20);
			contentPanel.add(lblGuardarPuesto);
		}
		{
			lblActualizarPuesto = new JLabel(et.getString("actualizar"));
			lblActualizarPuesto.setHorizontalAlignment(SwingConstants.CENTER);
			lblActualizarPuesto.setFont(new Font("Bahnschrift", Font.BOLD, 12));
			lblActualizarPuesto.setBounds(376, 70, 70, 20);
			contentPanel.add(lblActualizarPuesto);
		}
		{
			lblEliminarPuesto = new JLabel(et.getString("borrar"));
			lblEliminarPuesto.setHorizontalAlignment(SwingConstants.CENTER);
			lblEliminarPuesto.setFont(new Font("Bahnschrift", Font.BOLD, 12));
			lblEliminarPuesto.setBounds(445, 70, 70, 20);
			contentPanel.add(lblEliminarPuesto);
		}
		{
			lblLimpiarPuesto = new JLabel(et.getString("borrar"));
			lblLimpiarPuesto.setHorizontalAlignment(SwingConstants.CENTER);
			lblLimpiarPuesto.setFont(new Font("Bahnschrift", Font.BOLD, 12));
			lblLimpiarPuesto.setBounds(514, 70, 70, 20);
			contentPanel.add(lblLimpiarPuesto);
		}
		{
			lblModificarPuesto = new JLabel(et.getString("modify"));
			lblModificarPuesto.setHorizontalAlignment(SwingConstants.CENTER);
			lblModificarPuesto.setFont(new Font("Bahnschrift", Font.BOLD, 12));
			lblModificarPuesto.setBounds(583, 70, 70, 20);
			contentPanel.add(lblModificarPuesto);
		}
		{
			btnNuevoPuesto = new JButton("");
			btnNuevoPuesto.setIcon(new ImageIcon(puesto.class.getResource("/imagenes/anadir.png")));
			btnNuevoPuesto.setBounds(258, 40, 30, 30);
			contentPanel.add(btnNuevoPuesto);
			btnNuevoPuesto.setOpaque(false);
			btnNuevoPuesto.setContentAreaFilled(false);
			btnNuevoPuesto.setBorderPainted(false);
		}
		{
			btnGuardarPuesto = new JButton("");
			btnGuardarPuesto.setIcon(new ImageIcon(puesto.class.getResource("/imagenes/salvar.png")));
			btnGuardarPuesto.setBounds(327, 40, 30, 30);
			contentPanel.add(btnGuardarPuesto);
			btnGuardarPuesto.setEnabled(false);
			btnGuardarPuesto.setOpaque(false);
			btnGuardarPuesto.setContentAreaFilled(false);
			btnGuardarPuesto.setBorderPainted(false);
		}
		{
			btnActualizarPuesto = new JButton("");
			btnActualizarPuesto.setIcon(new ImageIcon(puesto.class.getResource("/imagenes/actualizar-flecha.png")));
			btnActualizarPuesto.setBounds(392, 40, 30, 30);
			contentPanel.add(btnActualizarPuesto);
			btnActualizarPuesto.setOpaque(false);
			btnActualizarPuesto.setContentAreaFilled(false);
			btnActualizarPuesto.setBorderPainted(false);
		}
		{
			btnEliminarPuesto = new JButton("");
			btnEliminarPuesto.setIcon(new ImageIcon(puesto.class.getResource("/imagenes/borrar (1).png")));
			btnEliminarPuesto.setBounds(461, 40, 30, 30);
			contentPanel.add(btnEliminarPuesto);
			btnEliminarPuesto.setOpaque(false);
			btnEliminarPuesto.setContentAreaFilled(false);
			btnEliminarPuesto.setBorderPainted(false);
		}
		{
			btnLimpiarPuesto = new JButton("");
			btnLimpiarPuesto.setIcon(new ImageIcon(puesto.class.getResource("/imagenes/escoba.png")));
			btnLimpiarPuesto.setBounds(530, 40, 30, 30);
			contentPanel.add(btnLimpiarPuesto);
			btnLimpiarPuesto.setOpaque(false);
			btnLimpiarPuesto.setContentAreaFilled(false);
			btnLimpiarPuesto.setBorderPainted(false);
		}
		{
			btnModificarPuesto = new JButton("");
			btnModificarPuesto.setIcon(new ImageIcon(puesto.class.getResource("/imagenes/boligrafo-cuadrado.png")));
			btnModificarPuesto.setBounds(599, 40, 30, 30);
			contentPanel.add(btnModificarPuesto);
			btnModificarPuesto.setEnabled(false);
			btnModificarPuesto.setOpaque(false);
			btnModificarPuesto.setContentAreaFilled(false);
			btnModificarPuesto.setBorderPainted(false);
			
		}
		{
			btnAtras = new JButton("");
			btnAtras.setIcon(new ImageIcon(puesto.class.getResource("/imagenes/angulo-circulo-izquierda.png")));
			btnAtras.setBounds(10, 10, 38, 38);
			contentPanel.add(btnAtras);
			btnAtras.setOpaque(false);
			btnAtras.setContentAreaFilled(false);
			btnAtras.setBorderPainted(false);
		}
		ManejadorBotones EscuchadorBotones = new ManejadorBotones();
		
		btnNuevoPuesto.addActionListener(EscuchadorBotones);
		btnGuardarPuesto.addActionListener(EscuchadorBotones);
		btnActualizarPuesto.addActionListener(EscuchadorBotones);
		btnEliminarPuesto.addActionListener(EscuchadorBotones);
		btnLimpiarPuesto.addActionListener(EscuchadorBotones);
		btnModificarPuesto.addActionListener(EscuchadorBotones);
		btnAtras.addActionListener(EscuchadorBotones);
		
		controladorPuesto = new CPuesto();
		mostrarTablaPuesto();
	}
	
	public class ManejadorBotones implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			if (evento.getSource().equals(btnAtras)) {
				// Regresar al menu
				gestionempleados puesto = new gestionempleados(idioma);
				puesto.setVisible(true);
				dispose();
			}
			if (evento.getSource().equals(btnNuevoPuesto)) {
				// Habilitar campos de agg información
				habilitarCampos();
				btnNuevoPuesto.setEnabled(false);
				btnGuardarPuesto.setEnabled(true);
				btnEliminarPuesto.setEnabled(false);
				btnActualizarPuesto.setEnabled(false);
				btnLimpiarPuesto.setEnabled(true);
				btnModificarPuesto.setEnabled(false);
			}
			if (evento.getSource().equals(btnGuardarPuesto)) {
				// Guardar datos en BD
				guardarPuesto();
				// Actualizar tabla
				mostrarTablaPuesto();
				// Limpiar campos
				limpiarCampos();
				// Desabilitar campos de agg información
				deshabilitarCampos();
				// Deshabilitar btnGuardar
				btnNuevoPuesto.setEnabled(true);
				btnGuardarPuesto.setEnabled(false);
				btnEliminarPuesto.setEnabled(true);
				btnActualizarPuesto.setEnabled(true);
				btnLimpiarPuesto.setEnabled(false);
				btnModificarPuesto.setEnabled(false);
			}
			if (evento.getSource().equals(btnActualizarPuesto)) {
				// Habilitar campos de agg información
				habilitarCampos();
				// Cargar datos del cliente seleccionado
				seleccionarID();
				// Deshabilitar btnGuardar y habilitar btnModificar
				btnNuevoPuesto.setEnabled(false);
				btnGuardarPuesto.setEnabled(false);
				btnEliminarPuesto.setEnabled(false);
				btnActualizarPuesto.setEnabled(false);
				btnLimpiarPuesto.setEnabled(true);
				btnModificarPuesto.setEnabled(true);
			}
			if (evento.getSource().equals(btnModificarPuesto)) {
				// Guardar cambios realizados
				modificarPuesto();
				// Actualizar tabla
				mostrarTablaPuesto();
				// Limpiar campos
				limpiarCampos();
				// Deshabilitar campos y botones
				deshabilitarCampos();
				btnNuevoPuesto.setEnabled(true);
				btnGuardarPuesto.setEnabled(false);
				btnEliminarPuesto.setEnabled(true);
				btnActualizarPuesto.setEnabled(true);
				btnLimpiarPuesto.setEnabled(false);
				btnModificarPuesto.setEnabled(false);
			}
			if (evento.getSource().equals(btnEliminarPuesto)) {
				eliminarPuesto();
				// Actualizar la tabla después de eliminar
				mostrarTablaPuesto();
			}
			if (evento.getSource().equals(btnLimpiarPuesto)) {
				// Limpiar campos
				limpiarCampos();
				JOptionPane.showMessageDialog(null, et.getString("btnLimpiar"));
			}
		}
	}
	
	private void limpiarCampos() {
		// Limpiar campos
		txtFldNombrePuesto.setText("");
		txtFldSueldoPuesto.setText("");
		txtFldDeptoPuesto.setText("");
		txtFldTurnoPuesto.setText("");
	}
	
	private void habilitarCampos() {
		// Habilitar campos de agg información
		txtFldNombrePuesto.setEnabled(true);
		txtFldSueldoPuesto.setEnabled(true);
		txtFldDeptoPuesto.setEnabled(true);
		txtFldTurnoPuesto.setEnabled(true);
	}
	
	private void deshabilitarCampos() {
		// Habilitar campos de agg información
		txtFldNombrePuesto.setEnabled(false);
		txtFldSueldoPuesto.setEnabled(false);
		txtFldDeptoPuesto.setEnabled(false);
		txtFldTurnoPuesto.setEnabled(false);
	}
	
	private void guardarPuesto() {
		// Guardar datos en bd
		String nombre = txtFldNombrePuesto.getText();
		BigDecimal sueldo = new BigDecimal(txtFldSueldoPuesto.getText());
		String departamento = txtFldDeptoPuesto.getText();
		String turno = txtFldTurnoPuesto.getText();

		MPuesto puesto = new MPuesto(nombre, sueldo, departamento, turno);
		controladorPuesto.anadirPuesto(puesto);
	}
	
	private void seleccionarID() {
		int filaSeleccionada = tablaPuesto.getSelectedRow();
		if (filaSeleccionada >= 0) {
			idSeleccionado = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
			txtFldNombrePuesto.setText((String) modeloTabla.getValueAt(filaSeleccionada, 1));
			txtFldSueldoPuesto.setText(modeloTabla.getValueAt(filaSeleccionada, 2).toString());
			txtFldDeptoPuesto.setText((String) modeloTabla.getValueAt(filaSeleccionada, 3));
			txtFldTurnoPuesto.setText(modeloTabla.getValueAt(filaSeleccionada, 4).toString());
		} else {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un campo.");
		}
	}
	
	private void modificarPuesto() {
		if (idSeleccionado != -1) {
			String nombre = txtFldNombrePuesto.getText();
			BigDecimal sueldo = new BigDecimal(txtFldSueldoPuesto.getText());
			String departamento = txtFldDeptoPuesto.getText();
			String turno = txtFldTurnoPuesto.getText();

			controladorPuesto.actualizarPuesto(nombre, sueldo, departamento, turno, idSeleccionado);
		} else {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un campo para modificar.");
		}
	}
	
	private void eliminarPuesto() {
		int filaSeleccionada = tablaPuesto.getSelectedRow();
		int idPuesto = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
		controladorPuesto.eliminarPuesto(idPuesto);
	}
	
	private void mostrarTablaPuesto() {
		// Limpiar la tabla actual
		modeloTabla.setRowCount(0);

		// Obtener clientes del controlador
		List<MPuesto> listaPuestos = controladorPuesto.obtenerPuesto();

		// Añadir clientes a la tabla
		for (MPuesto puesto : listaPuestos) {
			modeloTabla.addRow(new Object[] { puesto.getIdPuesto(), puesto.getNombre(),
					puesto.getSueldo(), puesto.getDepartamento(), puesto.getTurno() });
		}
	}
}
