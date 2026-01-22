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

import controlador.CGeneroProducto;
import modelo.MGeneroProducto;

public class generoProductoConf extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static Locale idioma;
	private static ResourceBundle et;
	private JLabel lblGenero;
	private JTextField txtFldGenero;
	private JScrollPane scrollPane;
	private DefaultTableModel modeloTabla;
	private JTable tablaGenero;
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
	private CGeneroProducto controladorGenero;
	private int idSeleccionado = -1;
	private JButton btnAtras;

	public static void main(String[] args) {
		try {
			generoProductoConf dialog = new generoProductoConf(idioma);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public generoProductoConf(Locale idioma) {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(generoProductoConf.class.getResource("/imagenes/v914-ning-21a.png")));
		// Internacionalización
		generoProductoConf.idioma = idioma;
		et = ResourceBundle.getBundle("properties/dic", idioma);

		setBounds(100, 100, 690, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblGenero = new JLabel(et.getString("generoproductos"));
			lblGenero.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			lblGenero.setHorizontalAlignment(SwingConstants.CENTER);
			lblGenero.setBounds(20, 45, 200, 20);
			contentPanel.add(lblGenero);
		}
		{
			txtFldGenero = new JTextField();
			txtFldGenero.setBounds(20, 65, 200, 20);
			contentPanel.add(txtFldGenero);
			txtFldGenero.setColumns(10);
			txtFldGenero.setEnabled(false);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 100, 633, 190);
			contentPanel.add(scrollPane);
		}
		{
			modeloTabla = new DefaultTableModel();
			modeloTabla.setColumnIdentifiers(new String[] {et.getString("codigoproductos"), et.getString("generoproductos")});
		}
		{
			tablaGenero = new JTable();
			tablaGenero.setModel(modeloTabla);
			scrollPane.setViewportView(tablaGenero);
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
			btnNuevo.setIcon(new ImageIcon(generoProductoConf.class.getResource("/imagenes/anadir.png")));
			btnNuevo.setBounds(258, 40, 30, 30);
			contentPanel.add(btnNuevo);
			btnNuevo.setOpaque(false);
			btnNuevo.setContentAreaFilled(false);
			btnNuevo.setBorderPainted(false);
		}
		{
			btnGuardar = new JButton("");
			btnGuardar.setIcon(new ImageIcon(generoProductoConf.class.getResource("/imagenes/salvar.png")));
			btnGuardar.setBounds(327, 40, 30, 30);
			contentPanel.add(btnGuardar);
			btnGuardar.setEnabled(false);
			btnGuardar.setOpaque(false);
			btnGuardar.setContentAreaFilled(false);
			btnGuardar.setBorderPainted(false);
		}
		{
			btnActualizar = new JButton("");
			btnActualizar.setIcon(new ImageIcon(generoProductoConf.class.getResource("/imagenes/actualizar-flecha.png")));
			btnActualizar.setBounds(392, 40, 30, 30);
			contentPanel.add(btnActualizar);
			btnActualizar.setOpaque(false);
			btnActualizar.setContentAreaFilled(false);
			btnActualizar.setBorderPainted(false);
		}
		{
			btnEliminar = new JButton("");
			btnEliminar.setIcon(new ImageIcon(generoProductoConf.class.getResource("/imagenes/borrar (1).png")));
			btnEliminar.setBounds(461, 40, 30, 30);
			contentPanel.add(btnEliminar);
			btnEliminar.setOpaque(false);
			btnEliminar.setContentAreaFilled(false);
			btnEliminar.setBorderPainted(false);
		}
		{
			btnLimpiar = new JButton("");
			btnLimpiar.setIcon(new ImageIcon(generoProductoConf.class.getResource("/imagenes/escoba.png")));
			btnLimpiar.setBounds(530, 40, 30, 30);
			contentPanel.add(btnLimpiar);
			btnLimpiar.setOpaque(false);
			btnLimpiar.setContentAreaFilled(false);
			btnLimpiar.setBorderPainted(false);
		}
		{
			btnModificar = new JButton("");
			btnModificar.setIcon(new ImageIcon(generoProductoConf.class.getResource("/imagenes/boligrafo-cuadrado.png")));
			btnModificar.setBounds(599, 40, 30, 30);
			contentPanel.add(btnModificar);
			btnModificar.setEnabled(false);
			btnModificar.setOpaque(false);
			btnModificar.setContentAreaFilled(false);
			btnModificar.setBorderPainted(false);

		}
		{
			btnAtras = new JButton("");
			btnAtras.setIcon(new ImageIcon(generoProductoConf.class.getResource("/imagenes/angulo-circulo-izquierda.png")));
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

		controladorGenero = new CGeneroProducto();
		mostrarTabla();
	}

	public class ManejadorBotones implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			if (evento.getSource().equals(btnAtras)) {
				// Regresar al menu
				configuracion generoProductoConf = new configuracion(idioma);
				generoProductoConf.setVisible(true);
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
		txtFldGenero.setText("");
	}

	private void habilitarCampos() {
		// Habilitar campos de agg información
		txtFldGenero.setEnabled(true);
	}

	private void deshabilitarCampos() {
		// Habilitar campos de agg información
		txtFldGenero.setEnabled(false);
	}

	private void guardar() {
		// Guardar datos en bd
		String genero = txtFldGenero.getText();

		MGeneroProducto generos = new MGeneroProducto(genero);
		controladorGenero.anadirGenero(generos);
	}

	private void seleccionarID() {
		int filaSeleccionada = tablaGenero.getSelectedRow();
		if (filaSeleccionada >= 0) {
			idSeleccionado = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
			txtFldGenero.setText((String) modeloTabla.getValueAt(filaSeleccionada, 1));
		} else {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un campo.");
		}
	}

	private void modificar() {
		if (idSeleccionado != -1) {
			String genero = txtFldGenero.getText();

			controladorGenero.actualizarGenero(genero, idSeleccionado);
		} else {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un campo para modificar.");
		}
	}

	private void eliminar() {
		int filaSeleccionada = tablaGenero.getSelectedRow();
		int idgeneroroductos = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
		controladorGenero.eliminarGenero(idgeneroroductos);
	}

	private void mostrarTabla() {
		// Limpiar la tabla actual
		modeloTabla.setRowCount(0);

		// Obtener clientes del controlador
		List<MGeneroProducto> listaGeneros = controladorGenero.obtenerGenero();

		// Añadir clientes a la tabla
		for (MGeneroProducto generos : listaGeneros) {
			modeloTabla.addRow(new Object[] { generos.getIdgeneroproductos(), generos.getGenero() });
		}
	}
}
