import javax.swing.*;
import java.awt.*;

public class ventanaIniciarJuego extends JFrame {

    private JButton iniciarJuego;
    ImageIcon img = new ImageIcon("img/logo_trebol.png");

    // PANEL PERSONALIZADO PARA EL FONDO
    class PanelConFondo extends JPanel {
        private Image imagen;

        public PanelConFondo(String ruta) {
            imagen = new ImageIcon(ruta).getImage();
        }
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public ventanaIniciarJuego() {

        setTitle("Ecos del Bosque Roto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(img.getImage());

        // PANEL DE FONDO
        PanelConFondo fondo = new PanelConFondo("img/fondo.png");
        fondo.setLayout(null); // Para colocar el botón libremente
        setContentPane(fondo);

        // BOTÓN
        iniciarJuego = new JButton("Iniciar Juego");
        iniciarJuego.setBounds(120, 150, 150, 40);
        iniciarJuego.setFocusPainted(false);
        iniciarJuego.setBackground(new Color(40, 15, 60));       // fondo púrpura oscuro
        iniciarJuego.setForeground(new Color(144, 238, 144));    // texto verde claro
        iniciarJuego.setFont(new Font("Monospaced", Font.BOLD, 16));
        iniciarJuego.setBorder(BorderFactory.createLineBorder(new Color(150, 60, 200), 2));
        iniciarJuego.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fondo.add(iniciarJuego);

        iniciarJuego.addActionListener(e -> {
            dispose();
            Proyecto_final pf = new Proyecto_final();
            pf.juego(img);
        });
    }
}
