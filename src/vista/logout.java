package vista;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.net.URL;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class logout extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel JLabelLogOut;
    private Cursor CursorImg;
    private URL Ruta;
    private GroupLayout layout;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    logout frame = new logout();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public logout() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        InicializarComponentes();

        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/userLabel.png")).getImage());
        this.setLocationRelativeTo(null);

        // inicializar la variable para el tiempo de visualización del splash
        Thread tiempo = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                login login = new login();
                login.setVisible(true);
                dispose();
            }
        });

        tiempo.start(); // Iniciar el Thread
    }

    private void InicializarComponentes() {
        JLabelLogOut = new JLabel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        Ruta = getClass().getResource("/imagenes/cerrar-sesionn.gif");
        Icon Imagen = new ImageIcon(Ruta);
        JLabelLogOut.setIcon(Imagen);
        CursorImg = new Cursor(Cursor.WAIT_CURSOR);
        JLabelLogOut.setCursor(CursorImg);

        layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(JLabelLogOut));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(JLabelLogOut));
        pack();
    }
}
