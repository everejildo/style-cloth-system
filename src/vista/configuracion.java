package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class configuracion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Locale idioma;
	private ResourceBundle et;
	private JLabel lblConfiguracion;
	private JComboBox<String> cmbBxIdioma;
	private JButton btnAtras;
	private JLabel lblIdiomaConf;
	private JButton btnGestionEmpresa;
	private JLabel lblBtnEmpleados;
	private JButton btnGestionEmpleados;
	private JLabel lblRespaldo;
	private JButton btnRespaldo;
	private JLabel lblComboBox;
	private JButton btnCBpuesto;
	private JButton btnCBmetodopago;
	private JButton btnCBtalla;
	private JButton btnCBtipo;
	private JButton btnCBgenero;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					configuracion frame = new configuracion(idioma);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public configuracion(Locale idioma) {
		// Internacionalización por defecto en español
		cargarResourceBundle(idioma);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Configurar etiquetas y combo box inicialmente
		lblConfiguracion = new JLabel(et.getString("configuracion"));
		lblConfiguracion.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblConfiguracion.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfiguracion.setBounds(10, 30, 500, 40);
		contentPane.add(lblConfiguracion);

		lblIdiomaConf = new JLabel(et.getString("idioma"));
		lblIdiomaConf.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdiomaConf.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblIdiomaConf.setBounds(10, 80, 500, 20);
		contentPane.add(lblIdiomaConf);

		cmbBxIdioma = new JComboBox<>();
		cmbBxIdioma.setEnabled(true);
		cmbBxIdioma.setBounds(145, 103, 230, 20);
		cmbBxIdioma
				.setModel(new DefaultComboBoxModel<>(new String[] { et.getString("español"), et.getString("ingles") }));
		contentPane.add(cmbBxIdioma);

		btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(configuracion.class.getResource("/imagenes/angulo-circulo-izquierda.png")));
		btnAtras.setOpaque(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		btnAtras.setBounds(10, 10, 38, 33);
		contentPane.add(btnAtras);

		JLabel lblBtnEmpresa = new JLabel(et.getString("botonempresa"));
		lblBtnEmpresa.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblBtnEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtnEmpresa.setBounds(10, 145, 500, 20);
		contentPane.add(lblBtnEmpresa);

		btnGestionEmpresa = new JButton(et.getString("ventanago"));
		btnGestionEmpresa.setIcon(new ImageIcon(configuracion.class.getResource("/imagenes/participacion.png")));
		btnGestionEmpresa.setBounds(145, 168, 230, 22);
		contentPane.add(btnGestionEmpresa);

		lblBtnEmpleados = new JLabel(et.getString("empleadosconf"));
		lblBtnEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtnEmpleados.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblBtnEmpleados.setBounds(10, 210, 500, 20);
		contentPane.add(lblBtnEmpleados);

		btnGestionEmpleados = new JButton(et.getString("ventanago"));
		btnGestionEmpleados.setIcon(new ImageIcon(configuracion.class.getResource("/imagenes/participacion.png")));
		btnGestionEmpleados.setBounds(145, 233, 230, 22);
		contentPane.add(btnGestionEmpleados);

		lblRespaldo = new JLabel(et.getString("respaldoconf"));
		lblRespaldo.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblRespaldo.setHorizontalAlignment(SwingConstants.CENTER);
		lblRespaldo.setBounds(10, 275, 500, 20);
		contentPane.add(lblRespaldo);

		btnRespaldo = new JButton(et.getString("btnrespladoconf"));
		btnRespaldo.setBounds(145, 298, 230, 22);
		contentPane.add(btnRespaldo);
		
		lblComboBox = new JLabel(et.getString("comboboxconf"));
		lblComboBox.setHorizontalAlignment(SwingConstants.CENTER);
		lblComboBox.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblComboBox.setBounds(10, 330, 500, 20);
		contentPane.add(lblComboBox);
		
		btnCBpuesto = new JButton("puesto");
		btnCBpuesto.setBounds(75, 351, 180, 22);
		contentPane.add(btnCBpuesto);
		
		btnCBmetodopago = new JButton("metodo pago");
		btnCBmetodopago.setBounds(265, 351, 180, 22);
		contentPane.add(btnCBmetodopago);
		
		btnCBtalla = new JButton("talla");
		btnCBtalla.setBounds(75, 383, 180, 22);
		contentPane.add(btnCBtalla);
		
		btnCBtipo = new JButton("tipo");
		btnCBtipo.setBounds(265, 383, 180, 22);
		contentPane.add(btnCBtipo);
		
		btnCBgenero = new JButton("genero");
		btnCBgenero.setBounds(170, 415, 180, 22);
		contentPane.add(btnCBgenero);

		// Manejadores
		ManejadorBotones EscuchadorBotones = new ManejadorBotones();

		// Botones
		cmbBxIdioma.addActionListener(EscuchadorBotones);
		btnAtras.addActionListener(EscuchadorBotones);
		btnGestionEmpresa.addActionListener(EscuchadorBotones);
		btnGestionEmpleados.addActionListener(EscuchadorBotones);
		btnRespaldo.addActionListener(EscuchadorBotones);
		btnCBpuesto.addActionListener(EscuchadorBotones);
		btnCBmetodopago.addActionListener(EscuchadorBotones);
		btnCBtalla.addActionListener(EscuchadorBotones);
		btnCBtipo.addActionListener(EscuchadorBotones);
		btnCBgenero.addActionListener(EscuchadorBotones);
	}

	public class ManejadorBotones implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			if (evento.getSource().equals(btnAtras)) {
				menuprincipal configuracion = new menuprincipal(idioma);
				configuracion.setVisible(true);
				dispose();
			}
			if (evento.getSource().equals(cmbBxIdioma)) {
				String selectedLanguage = (String) cmbBxIdioma.getSelectedItem();
				switch (selectedLanguage) {
				case "Español":
					idioma = new Locale("es", "MX");
					break;
				case "Ingles":
					idioma = new Locale("en", "US");
					break;
				case "Spanish":
					idioma = new Locale("es", "MX");
					break;
				case "English":
					idioma = new Locale("en", "US");
					break;
				}
				cambiaridioma();
			}
			if (evento.getSource().equals(btnGestionEmpresa)) {
				gestionempresaConf configuracion = new gestionempresaConf(idioma);
				configuracion.setVisible(true);
				dispose();
			}
			if (evento.getSource().equals(btnGestionEmpleados)) {
				gestionempleados configuracion = new gestionempleados(idioma);
				configuracion.setVisible(true);
				dispose();
			}
			if (evento.getSource().equals(btnRespaldo)) {
				Respaldo configuracion = new Respaldo(idioma);
				configuracion.setModal(true); // Bloquear la ventana principal hasta que se cierre el diálogo
				configuracion.setVisible(true);
			}
			if (evento.getSource().equals(btnCBpuesto)) {
				puestoConf configuracion = new puestoConf(idioma);
				configuracion.setVisible(true);
				dispose();
			}
			if (evento.getSource().equals(btnCBmetodopago)) {
				metodopagoConf configuracion = new metodopagoConf(idioma);
				configuracion.setVisible(true);
				dispose();
			}
			if (evento.getSource().equals(btnCBtalla)) {
				tallaConf configuracion = new tallaConf(idioma);
				configuracion.setVisible(true);
				dispose();
			}
			if (evento.getSource().equals(btnCBtipo)) {
				tipoConf configuracion = new tipoConf(idioma);
				configuracion.setVisible(true);
				dispose();
			}
			if (evento.getSource().equals(btnCBgenero)) {
				generoProductoConf configuracion = new generoProductoConf(idioma);
				configuracion.setVisible(true);
				dispose();
			}
		}
	}

	private void cargarResourceBundle(Locale idioma) {
		try {
			configuracion.idioma = idioma;
			et = ResourceBundle.getBundle("properties.dic", idioma);
		} catch (MissingResourceException e) {
			System.err.println("No se pudo cargar el ResourceBundle.");
			e.printStackTrace();
		}
	}

	private void cambiaridioma() {
		cargarResourceBundle(idioma);

		try {
			// Actualizar etiquetas y componentes con el nuevo idioma
			lblConfiguracion.setText(et.getString("configuracion"));
			lblIdiomaConf.setText(et.getString("idioma"));

			// Actualizar el combo box
			cmbBxIdioma.setModel(
					new DefaultComboBoxModel<>(new String[] { et.getString("español"), et.getString("ingles") }));

		} catch (MissingResourceException ex) {
			JOptionPane.showMessageDialog(null, "Error: No se pudo encontrar el recurso de configuración.");
			ex.printStackTrace();
		}
	}
}
