package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.CRespaldo;

public class Respaldo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtFldRuta;
	private JButton cancelButton;
	private JLabel lblRuta;
	private JButton okButton;
	private static Locale idioma;
	private static ResourceBundle et;

	public Respaldo(Locale idioma) {
		// Internacionalización
		Respaldo.idioma = idioma;
		et = ResourceBundle.getBundle("properties/dic", idioma);

		setIconImage(Toolkit.getDefaultToolkit().getImage(Respaldo.class.getResource("/imagenes/v914-ning-21a.png")));
		setTitle("Respaldo de Base de Datos");
		setBounds(100, 100, 450, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		txtFldRuta = new JTextField();
		txtFldRuta.setBounds(10, 50, 414, 20);
		contentPanel.add(txtFldRuta);
		txtFldRuta.setColumns(10);

		okButton = new JButton(et.getString("ok"));
		okButton.setBounds(260, 80, 80, 22);
		contentPanel.add(okButton);

		cancelButton = new JButton(et.getString("cancel"));
		cancelButton.setBounds(344, 80, 80, 22);
		contentPanel.add(cancelButton);

		lblRuta = new JLabel(et.getString("ruta"));
		lblRuta.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblRuta.setBounds(10, 26, 130, 20);
		contentPanel.add(lblRuta);

		// Manejadores
		ManejadorBotones EscuchadorBotones = new ManejadorBotones();

		okButton.addActionListener(EscuchadorBotones);
		cancelButton.addActionListener(EscuchadorBotones);

	}

	public class ManejadorBotones implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			if (evento.getSource().equals(okButton)) {
				String ruta = txtFldRuta.getText();
				File file = new File(ruta);
				if (file.exists()) {
					JOptionPane.showMessageDialog(null, "Ruta válida. El respaldo se guardará en: " + ruta);
					realizarBackup();
					dispose(); // Cierra la ventana
				} else {
					JOptionPane.showMessageDialog(null, "La ruta no existe. Por favor, ingrese una ruta válida.");
				}
			}
			if (evento.getSource().equals(cancelButton)) {
				configuracion VRespaldo = new configuracion(idioma);
				VRespaldo.setVisible(true);
				dispose();
			}
		}
	}
	
	private void realizarBackup() {
		String ruta = txtFldRuta.getText();  // Obtener la ruta del JTextField
	    CRespaldo controladorRespaldo = new CRespaldo();
	    controladorRespaldo.execPA(ruta);  // Pasar la ruta al procedimiento almacenado
	}

}
