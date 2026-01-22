package Cooperativa;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controladores.Controlador_ProveedorVenta;

public class ProveedorVenta extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField_cantidad;
    private JTextField textField_precio;
    private JButton btnCoperativa;
    private JLabel lblDistribuidorVent;
    private JButton btnNewButton_atras;
    private Locale Idioma;
    private static ResourceBundle et;
    private JButton btnProductos;
    private JComboBox<String> comboBoxProductos;
    private JComboBox<String> comboBox_cooperativa;
    private JButton btnNewButton;
    private JButton btnNewButton_cancelar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ProveedorVenta frame = new ProveedorVenta();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ProveedorVenta() {
        /// Inicializar Variables para Internacionalizacion
        Idioma = new Locale("es", "MX");
        et = ResourceBundle.getBundle("properties/dic", Idioma);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 689, 593);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 255, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 675, 556);
        contentPane.add(panel);
        panel.setLayout(null);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel_CantidadKG = new JLabel(et.getString("cantidadenkg"));
        lblNewLabel_CantidadKG.setForeground(new Color(0, 255, 255));
        lblNewLabel_CantidadKG.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        lblNewLabel_CantidadKG.setBounds(237, 237, 108, 21);
        panel.add(lblNewLabel_CantidadKG);

        textField_cantidad = new JTextField();
        textField_cantidad.setBounds(355, 239, 96, 19);
        panel.add(textField_cantidad);
        textField_cantidad.setColumns(10);

        textField_cantidad.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Evita que se escriban caracteres no numéricos
                }
            }
        });

        JLabel lblNewLabel_imagen = new JLabel("");
        lblNewLabel_imagen.setIcon(new ImageIcon(ProveedorVenta.class.getResource("/Imaggenes/gente (2) (1).png")));
        lblNewLabel_imagen.setBounds(26, 10, 150, 157);
        panel.add(lblNewLabel_imagen);

        btnNewButton_atras = new JButton(et.getString("atras"));
        btnNewButton_atras.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        btnNewButton_atras.setBounds(519, 29, 125, 21);
        panel.add(btnNewButton_atras);

        btnProductos = new JButton(et.getString("productos"));
        btnProductos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        btnProductos.setBounds(51, 232, 125, 31);
        panel.add(btnProductos);

        comboBoxProductos = new JComboBox<>();
        comboBoxProductos.setBounds(51, 268, 123, 21);
        panel.add(comboBoxProductos);

        btnProductos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Llenar el ComboBox con productos
                comboBoxProductos.removeAllItems(); // Limpiar items existentes
                comboBoxProductos.addItem("Camaron");
                comboBoxProductos.addItem("Pescado");
                comboBoxProductos.addItem("Jaiba");
                comboBoxProductos.addItem("Caracol");
            }
        });

        JLabel lblNewLabel_precio = new JLabel(et.getString("precio"));
        lblNewLabel_precio.setForeground(new Color(0, 255, 255));
        lblNewLabel_precio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        lblNewLabel_precio.setBounds(59, 378, 69, 21);
        panel.add(lblNewLabel_precio);

        textField_precio = new JTextField();
        textField_precio.setBounds(124, 380, 96, 19);
        panel.add(textField_precio);
        textField_precio.setColumns(10);

        textField_precio.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Evita que se escriban caracteres no numéricos
                }
            }
        });

        lblDistribuidorVent = new JLabel(et.getString("distribuidorventas"));
        lblDistribuidorVent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        lblDistribuidorVent.setBounds(207, 37, 138, 31);
        panel.add(lblDistribuidorVent);

        btnCoperativa = new JButton(et.getString("cooperativa"));
        btnCoperativa.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnCoperativa.setBounds(334, 350, 128, 31);
        panel.add(btnCoperativa);

        comboBox_cooperativa = new JComboBox<>();
        comboBox_cooperativa.setBounds(334, 391, 128, 31);
        panel.add(comboBox_cooperativa);

        btnCoperativa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Llenar el ComboBox con cooperativas
                comboBox_cooperativa.removeAllItems(); // Limpiar items existentes
                comboBox_cooperativa.addItem("Los Chagos");
                comboBox_cooperativa.addItem("3 Yacos");
                comboBox_cooperativa.addItem("El Islote del Mero");
            }
        });

        

        btnNewButton_cancelar = new JButton(et.getString("cancelar"));
        btnNewButton_cancelar.setBounds(523, 477, 121, 31);
        panel.add(btnNewButton_cancelar);
        btnNewButton_cancelar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));

        // Aquí va el nuevo ActionListener para btnCancelar
        btnNewButton_cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpiar los campos de texto
            	textField_cantidad.setText("");
            	textField_precio.setText("");

                // Deseleccionar los checkboxes
            	btnProductos.setSelected(false);
            	btnCoperativa.setSelected(false);

                // Vaciar los combo boxes
            	comboBoxProductos.removeAllItems();
            	comboBox_cooperativa.removeAllItems();

                // Mostrar un mensaje confirmando la cancelación
                JOptionPane.showMessageDialog(null, "Venta cancelada y todos los datos han sido borrados.");
            }
        });

        btnNewButton = new JButton(et.getString("vender"));
        btnNewButton.setBounds(28, 477, 113, 31);
        panel.add(btnNewButton);
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));

        // Integración con Controlador_ProveedorVenta
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Controlador_ProveedorVenta controlador = new Controlador_ProveedorVenta();
                controlador.realizarVenta(ProveedorVenta.this);
            }
        });

        JLabel lblNewLabel_Fondo = new JLabel("");
        lblNewLabel_Fondo.setIcon(new ImageIcon(ProveedorVenta.class.getResource("/Imaggenes/I2bL (2).gif")));
        lblNewLabel_Fondo.setBounds(0, 0, 675, 556);
        panel.add(lblNewLabel_Fondo);

        // Manejador para el botón atrás
        ManejadorBotones escuchadorBotones = new ManejadorBotones();
        btnNewButton_atras.addActionListener(escuchadorBotones);
    }

    // Métodos para obtener los componentes necesarios en el controlador
    public JComboBox<String> getComboBoxProductos() {
        return comboBoxProductos;
    }

    public JComboBox<String> getComboBox_cooperativa() {
        return comboBox_cooperativa;
    }

    public JTextField getTextField_cantidad() {
        return textField_cantidad;
    }

    public JTextField getTextField_precio() {
        return textField_precio;
    }

    // CLASE MANEJADOR
    public class ManejadorBotones implements ActionListener {
        public void actionPerformed(ActionEvent eventoBotones) {
            if (eventoBotones.getSource().equals(btnNewButton_atras)) {
            	Menu2 ProveedorVenta = new Menu2();
                ProveedorVenta.setVisible(true);
                dispose();
            }
        }
    }
}