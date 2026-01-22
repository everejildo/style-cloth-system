package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import controlador.CmetodopagoVentas;
import modelo.MmetodopagoVentas;

public class metodopagoVentas extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static Locale idioma;
	private static ResourceBundle et;
	private JLabel lblmetodoPago;
	private JTextField txtFldmetodoPago;
	private JScrollPane scrollPane;
	private DefaultTableModel modeloTabla;
	private JTable tablametodoPago;
	private JLabel lblNuevo;
	private JLabel lblGuardar;
	private JLabel lblActualizar;
	private JLabel lblEliminar;
	private JLabel lblLimpiar;
	private JLabel lblModificar;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnLimpiar;
	private JButton btnModificar;
	private CmetodopagoVentas controladorMetodoPago;
	private int idSeleccionado = -1;
	private JButton btnAtras;

	public static void main(String[] args) {
		try {
			metodopagoVentas dialog = new metodopagoVentas(idioma);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public metodopagoVentas(Locale idioma) {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(metodopagoVentas.class.getResource("/imagenes/v914-ning-21a.png")));
		// Internacionalización
		metodopagoVentas.idioma = idioma;
		et = ResourceBundle.getBundle("properties/dic", idioma);

		setBounds(100, 100, 690, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblmetodoPago = new JLabel("metodoPago");
			lblmetodoPago.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			lblmetodoPago.setHorizontalAlignment(SwingConstants.CENTER);
			lblmetodoPago.setBounds(20, 45, 200, 20);
			contentPanel.add(lblmetodoPago);
		}
		{
			txtFldmetodoPago = new JTextField();
			txtFldmetodoPago.setBounds(20, 65, 200, 20);
			contentPanel.add(txtFldmetodoPago);
			txtFldmetodoPago.setColumns(10);
			txtFldmetodoPago.setEnabled(false);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 100, 633, 190);
			contentPanel.add(scrollPane);
		}
		{
			modeloTabla = new DefaultTableModel();
			modeloTabla.setColumnIdentifiers(new String[] { "ID", "Metodo Pago" });
		}
		{
			tablametodoPago = new JTable();
			tablametodoPago.setModel(modeloTabla);
			scrollPane.setViewportView(tablametodoPago);
		}
		{
			lblNuevo = new JLabel(et.getString("nuevo"));
			lblNuevo.setHorizontalAlignment(SwingConstants.CENTER);
			lblNuevo.setFont(new Font("Bahnschrift", Font.BOLD, 12));
			lblNuevo.setBounds(238, 70, 70, 20);
			contentPanel.add(lblNuevo);
		}
		{
			lblGuardar = new JLabel(et.getString("guardar"));
			lblGuardar.setHorizontalAlignment(SwingConstants.CENTER);
			lblGuardar.setFont(new Font("Bahnschrift", Font.BOLD, 12));
			lblGuardar.setBounds(307, 70, 70, 20);
			contentPanel.add(lblGuardar);
		}
		{
			lblActualizar = new JLabel(et.getString("actualizar"));
			lblActualizar.setHorizontalAlignment(SwingConstants.CENTER);
			lblActualizar.setFont(new Font("Bahnschrift", Font.BOLD, 12));
			lblActualizar.setBounds(376, 70, 70, 20);
			contentPanel.add(lblActualizar);
		}
		{
			lblEliminar = new JLabel(et.getString("borrar"));
			lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
			lblEliminar.setFont(new Font("Bahnschrift", Font.BOLD, 12));
			lblEliminar.setBounds(445, 70, 70, 20);
			contentPanel.add(lblEliminar);
		}
		{
			lblLimpiar = new JLabel(et.getString("limpiar"));
			lblLimpiar.setHorizontalAlignment(SwingConstants.CENTER);
			lblLimpiar.setFont(new Font("Bahnschrift", Font.BOLD, 12));
			lblLimpiar.setBounds(514, 70, 70, 20);
			contentPanel.add(lblLimpiar);
		}
		{
			lblModificar = new JLabel(et.getString("modify"));
			lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
			lblModificar.setFont(new Font("Bahnschrift", Font.BOLD, 12));
			lblModificar.setBounds(583, 70, 70, 20);
			contentPanel.add(lblModificar);
		}
		{
			btnNuevo = new JButton("");
			btnNuevo.setIcon(new ImageIcon(metodopagoVentas.class.getResource("/imagenes/anadir.png")));
			btnNuevo.setBounds(258, 40, 30, 30);
			contentPanel.add(btnNuevo);
			btnNuevo.setOpaque(false);
			btnNuevo.setContentAreaFilled(false);
			btnNuevo.setBorderPainted(false);
		}
		{
			btnGuardar = new JButton("");
			btnGuardar.setIcon(new ImageIcon(metodopagoVentas.class.getResource("/imagenes/salvar.png")));
			btnGuardar.setBounds(327, 40, 30, 30);
			contentPanel.add(btnGuardar);
			btnGuardar.setEnabled(false);
			btnGuardar.setOpaque(false);
			btnGuardar.setContentAreaFilled(false);
			btnGuardar.setBorderPainted(false);
		}
		{
			btnActualizar = new JButton("");
			btnActualizar.setIcon(new ImageIcon(metodopagoVentas.class.getResource("/imagenes/actualizar-flecha.png")));
			btnActualizar.setBounds(392, 40, 30, 30);
			contentPanel.add(btnActualizar);
			btnActualizar.setOpaque(false);
			btnActualizar.setContentAreaFilled(false);
			btnActualizar.setBorderPainted(false);
		}
		{
			btnEliminar = new JButton("");
			btnEliminar.setIcon(new ImageIcon(metodopagoVentas.class.getResource("/imagenes/borrar (1).png")));
			btnEliminar.setBounds(461, 40, 30, 30);
			contentPanel.add(btnEliminar);
			btnEliminar.setOpaque(false);
			btnEliminar.setContentAreaFilled(false);
			btnEliminar.setBorderPainted(false);
		}
		{
			btnLimpiar = new JButton("");
			btnLimpiar.setIcon(new ImageIcon(metodopagoVentas.class.getResource("/imagenes/escoba.png")));
			btnLimpiar.setBounds(530, 40, 30, 30);
			contentPanel.add(btnLimpiar);
			btnLimpiar.setOpaque(false);
			btnLimpiar.setContentAreaFilled(false);
			btnLimpiar.setBorderPainted(false);
		}
		{
			btnModificar = new JButton("");
			btnModificar.setIcon(new ImageIcon(metodopagoVentas.class.getResource("/imagenes/boligrafo-cuadrado.png")));
			btnModificar.setBounds(599, 40, 30, 30);
			contentPanel.add(btnModificar);
			btnModificar.setEnabled(false);
			btnModificar.setOpaque(false);
			btnModificar.setContentAreaFilled(false);
			btnModificar.setBorderPainted(false);

		}
		{
			btnAtras = new JButton("");
			btnAtras.setIcon(new ImageIcon(metodopagoVentas.class.getResource("/imagenes/angulo-circulo-izquierda.png")));
			btnAtras.setBounds(10, 10, 38, 38);
			contentPanel.add(btnAtras);
			btnAtras.setOpaque(false);
			btnAtras.setContentAreaFilled(false);
			btnAtras.setBorderPainted(false);
		}
		ManejadorBotones EscuchadorBotones = new ManejadorBotones();

		btnNuevo.addActionListener(EscuchadorBotones);
		btnGuardar.addActionListener(EscuchadorBotones);
		btnActualizar.addActionListener(EscuchadorBotones);
		btnEliminar.addActionListener(EscuchadorBotones);
		btnLimpiar.addActionListener(EscuchadorBotones);
		btnModificar.addActionListener(EscuchadorBotones);
		btnAtras.addActionListener(EscuchadorBotones);

		controladorMetodoPago = new CmetodopagoVentas();
		mostrarTabla();
	}

	public class ManejadorBotones implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			if (evento.getSource().equals(btnAtras)) {
				// Regresar al menu
				registroventas metodopagoVentas = new registroventas(idioma);
				metodopagoVentas.setVisible(true);
				dispose();
			}
			if (evento.getSource().equals(btnNuevo)) {
				// Habilitar campos de agg información
				habilitarCampos();
				btnNuevo.setEnabled(false);
				btnGuardar.setEnabled(true);
				btnEliminar.setEnabled(false);
				btnActualizar.setEnabled(false);
				btnLimpiar.setEnabled(true);
				btnModificar.setEnabled(false);
			}
			if (evento.getSource().equals(btnGuardar)) {
				// Guardar datos en BD
				guardar();
				// Actualizar tabla
				mostrarTabla();
				// Limpiar campos
				limpiarCampos();
				// Desabilitar campos de agg información
				deshabilitarCampos();
				// Deshabilitar btnGuardar
				btnNuevo.setEnabled(true);
				btnGuardar.setEnabled(false);
				btnEliminar.setEnabled(true);
				btnActualizar.setEnabled(true);
				btnLimpiar.setEnabled(false);
				btnModificar.setEnabled(false);
			}
			if (evento.getSource().equals(btnActualizar)) {
				// Habilitar campos de agg información
				habilitarCampos();
				// Cargar datos del cliente seleccionado
				seleccionarID();
				// Deshabilitar btnGuardar y habilitar btnModificar
				btnNuevo.setEnabled(false);
				btnGuardar.setEnabled(false);
				btnEliminar.setEnabled(false);
				btnActualizar.setEnabled(false);
				btnLimpiar.setEnabled(true);
				btnModificar.setEnabled(true);
			}
			if (evento.getSource().equals(btnModificar)) {
				// Guardar cambios realizados
				modificar();
				// Actualizar tabla
				mostrarTabla();
				// Limpiar campos
				limpiarCampos();
				// Deshabilitar campos y botones
				deshabilitarCampos();
				btnNuevo.setEnabled(true);
				btnGuardar.setEnabled(false);
				btnEliminar.setEnabled(true);
				btnActualizar.setEnabled(true);
				btnLimpiar.setEnabled(false);
				btnModificar.setEnabled(false);
			}
			if (evento.getSource().equals(btnEliminar)) {
				eliminar();
				// Actualizar la tabla después de eliminar
				mostrarTabla();
			}
			if (evento.getSource().equals(btnLimpiar)) {
				// Limpiar campos
				limpiarCampos();
				JOptionPane.showMessageDialog(null, et.getString("btnLimpiar"));
			}
		}
	}

	private void limpiarCampos() {
		// Limpiar campos
		txtFldmetodoPago.setText("");
	}

	private void habilitarCampos() {
		// Habilitar campos de agg información
		txtFldmetodoPago.setEnabled(true);
	}

	private void deshabilitarCampos() {
		// Habilitar campos de agg información
		txtFldmetodoPago.setEnabled(false);
	}

	private void guardar() {
		// Guardar datos en bd
		String metodoPago = txtFldmetodoPago.getText();

		MmetodopagoVentas metodosPago = new MmetodopagoVentas(metodoPago);
		controladorMetodoPago.anadirMetodoPago(metodosPago);
	}

	private void seleccionarID() {
		int filaSeleccionada = tablametodoPago.getSelectedRow();
		if (filaSeleccionada >= 0) {
			idSeleccionado = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
			txtFldmetodoPago.setText((String) modeloTabla.getValueAt(filaSeleccionada, 1));
		} else {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un campo.");
		}
	}

	private void modificar() {
		if (idSeleccionado != -1) {
			String metodoPago = txtFldmetodoPago.getText();

			controladorMetodoPago.actualizarMetodoPago(metodoPago, idSeleccionado);
		} else {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un campo para modificar.");
		}
	}

	private void eliminar() {
		int filaSeleccionada = tablametodoPago.getSelectedRow();
		int idtallaProductos = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
		controladorMetodoPago.eliminarMetodoPago(idtallaProductos);
	}

	private void mostrarTabla() {
		// Limpiar la tabla actual
		modeloTabla.setRowCount(0);

		// Obtener clientes del controlador
		List<MmetodopagoVentas> listaMetodoPago = controladorMetodoPago.obtenerMetodoPago();

		// Añadir clientes a la tabla
		for (MmetodopagoVentas metodosPago : listaMetodoPago) {
			modeloTabla.addRow(new Object[] { metodosPago.getIdmetodopagoVentas(), metodosPago.getMetodoPago() });
		}
	}
}
