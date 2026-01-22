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

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controladores.Controlador_Venta;
import modelo.Modelo_Venta;
import javax.swing.ImageIcon;

public class venta extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JButton btnNewButton_Regresar;
    private JButton btnVender;
    private JButton btnCancelar;

    private Locale Idioma;
    private static ResourceBundle et;
    private JCheckBox checkBoxProductos;
    private JComboBox<String> comboBox;
    private JCheckBox chckbxNewCheckBox;
    private JComboBox<String> comboBoxCoperativa;
    private Controlador_Venta controladorVenta;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    venta frame = new venta();
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
    public venta() {

        /// Inicializar Variables para Internacionalizacion
        // Obtener el idioma por defecto del sistema
        // (de la maquina virtual Java)
        Idioma = Locale.getDefault();

        // Ahora en ingles americano
        //Idioma = new Locale("en","US");
        Idioma = new Locale("es","MX");
        //Idioma = new Locale("es");

        // Obtener los recursos desde el archivo <properties/dic>
        // en funcion del idioma <locale>
        et = ResourceBundle.getBundle("properties/dic", Idioma);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 683, 584);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(0, 255, 255));
        contentPane.setBackground(new Color(128, 255, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
                JLabel lblNewLabel_3 = new JLabel("");
                lblNewLabel_3.setIcon(new ImageIcon(venta.class.getResource("/Imaggenes/gente (2) (1).png")));
                //lblNewLabel_3.setIcon(new ImageIcon(venta.class.getResource("/Imaggenes/gente (2) (1).png")));
                lblNewLabel_3.setBounds(10, 24, 157, 147);
                contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel = new JLabel(et.getString("ventapescador"));
        lblNewLabel.setForeground(new Color(128, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
        lblNewLabel.setBounds(211, 35, 214, 31);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel(et.getString("precio"));
        lblNewLabel_1.setForeground(new Color(128, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        lblNewLabel_1.setBounds(46, 406, 82, 15);
        contentPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(123, 404, 96, 19);
        contentPane.add(textField);
        textField.setColumns(10);

        textField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Evita que se escriban caracteres no numéricos
                }
            }
        });

        btnVender = new JButton(et.getString("vender"));
        btnVender.setBackground(new Color(64, 159, 255));
        btnVender.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        btnVender.setBounds(64, 485, 116, 32);
        contentPane.add(btnVender);

        btnVender.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	registrarVenta();
            }
        });

        checkBoxProductos = new JCheckBox(et.getString("productos"));
        checkBoxProductos.setBackground(new Color(0, 128, 255));
        checkBoxProductos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        checkBoxProductos.setBounds(33, 233, 113, 21);
        contentPane.add(checkBoxProductos);

        comboBox = new JComboBox<>();
        comboBox.setBackground(new Color(196, 225, 255));
        comboBox.setBounds(10, 260, 143, 25);
        contentPane.add(comboBox);

        checkBoxProductos.addActionListener(e -> {
            if (checkBoxProductos.isSelected()) {
                comboBox.addItem("Camaron");
                comboBox.addItem("Pescado");
                comboBox.addItem("Jaiba");
                comboBox.addItem("Caracol");
            } else {
                comboBox.removeAllItems();
            }
        });

        JLabel lblNewLabel_2 = new JLabel(et.getString("cantidad"));
        lblNewLabel_2.setForeground(new Color(128, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        lblNewLabel_2.setBounds(251, 226, 71, 16);
        contentPane.add(lblNewLabel_2);

        textField_1 = new JTextField();
        textField_1.setBounds(327, 217, 116, 31);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        chckbxNewCheckBox = new JCheckBox(et.getString("cooperativa"));
        chckbxNewCheckBox.setBackground(new Color(0, 128, 255));
        chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        chckbxNewCheckBox.setBounds(508, 222, 116, 31);
        contentPane.add(chckbxNewCheckBox);

        comboBoxCoperativa = new JComboBox<>();
        comboBoxCoperativa.setBackground(new Color(196, 225, 255));
        comboBoxCoperativa.setBounds(500, 255, 143, 30);
        contentPane.add(comboBoxCoperativa);

        chckbxNewCheckBox.addActionListener(e -> {
            if (chckbxNewCheckBox.isSelected()) {
                comboBoxCoperativa.addItem("Los changos");
                comboBoxCoperativa.addItem("Islote del Mero");
                comboBoxCoperativa.addItem("3 Yacos");
            } else {
                comboBoxCoperativa.removeAllItems();
            }
        });

        btnCancelar = new JButton(et.getString("cancelar"));
        btnCancelar.setBackground(new Color(64, 159, 255));
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        btnCancelar.setBounds(485, 486, 103, 31);
        contentPane.add(btnCancelar);

        // Aquí va el nuevo ActionListener para btnCancelar
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpiar los campos de texto
                textField.setText("");
                textField_1.setText("");

                // Deseleccionar los checkboxes
                checkBoxProductos.setSelected(false);
                chckbxNewCheckBox.setSelected(false);

                // Vaciar los combo boxes
                comboBox.removeAllItems();
                comboBoxCoperativa.removeAllItems();

                // Mostrar un mensaje confirmando la cancelación
                JOptionPane.showMessageDialog(null, "Venta cancelada y todos los datos han sido borrados.");
            }
        });

        btnNewButton_Regresar = new JButton(et.getString("regresar"));
        btnNewButton_Regresar.setBackground(new Color(64, 159, 255));
        btnNewButton_Regresar.setBounds(541, 20, 103, 46);
        contentPane.add(btnNewButton_Regresar);

        JLabel lblNewLabel_4 = new JLabel("");
        //lblNewLabel_4.setIcon(new ImageIcon(venta.class.getResource("/Imaggenes/I2bL (2).gif")));
        lblNewLabel_4.setBounds(0, 0, 669, 547);
        contentPane.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon(venta.class.getResource("/Imaggenes/I2bL (2).gif")));
        lblNewLabel_5.setBounds(0, 0, 669, 547);
        contentPane.add(lblNewLabel_5);

        btnNewButton_Regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu venta = new Menu();
                venta.setVisible(true);
                dispose();
            }
        });
        
        controladorVenta = new Controlador_Venta();
        
        
        
    }
 
    
    private void registrarVenta() {
    	try {
    	// Verificar que haya un producto y una cooperativa seleccionados
        if (comboBox.getSelectedItem() == null || comboBoxCoperativa.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Por favor selecciona un producto y una cooperativa.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String producto = comboBox.getSelectedItem().toString();
        double cantidad = Double.parseDouble(textField_1.getText());
        String cooperativa = comboBoxCoperativa.getSelectedItem().toString();
        double precio = Double.parseDouble(textField.getText());

        Modelo_Venta venta = new Modelo_Venta(producto, cantidad, cooperativa, precio);
        controladorVenta.crearVenta(venta);
    	} catch (NumberFormatException e) {
            // Mostrar mensajes de error si ocurre una excepción de formato numérico
            JOptionPane.showMessageDialog(null, "Por favor ingresa valores numéricos válidos para la cantidad y el precio.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void NumberForma(NumberFormatException e1) {
   
        JOptionPane.showMessageDialog(null, "Por favor ingresa valores numéricos válidos para la cantidad y el precio.", "Error", JOptionPane.ERROR_MESSAGE);
    	
        JOptionPane.showMessageDialog(null, "Por favor selecciona un producto y una cooperativa.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
}
