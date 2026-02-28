import javax.swing.*;
import java.awt.*;

public class inventario extends JDialog {
    private JButton volver;
    private JLabel texto;
    private Image llave = new ImageIcon("llave.png").getImage();
    private Image maza = new ImageIcon("maza.png").getImage();
    private Image hacha = new ImageIcon("hacha.png").getImage();
    private Image linterna = new ImageIcon("linterna.png").getImage();
    private Image nada = new ImageIcon("nada.png").getImage();

    public inventario(boolean linterna, boolean hacha, boolean maza, boolean llaves, ImageIcon img) {
        setTitle("Inventario");
        setModal(true);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(img.getImage());

        PanelFondo panelConFondo = new PanelFondo(linterna, hacha, maza, llaves);
        panelConFondo.setLayout(null);
        setContentPane(panelConFondo);

        texto = new JLabel("Este es tu inventario actual");
        texto.setBounds(130, 10, 400, 20);
        texto.setForeground(Color.WHITE);
        panelConFondo.add(texto);

        ImageIcon img2 = new ImageIcon("mochila.png");
        Image imagenEscalada = img2.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        img2 = new ImageIcon(imagenEscalada);

        volver = new JButton(img2);
        volver.setBounds(184, 150, 16, 16);
        panelConFondo.add(volver);

        volver.addActionListener(e -> dispose());
    }

    private class PanelFondo extends JPanel {
        private boolean l, h, m, ll;

        public PanelFondo(boolean linterna, boolean hacha, boolean maza, boolean llaves) {
            this.l = linterna;
            this.h = hacha;
            this.m = maza;
            this.ll = llaves;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int anchoTotal = getWidth();
            int altoTotal = getHeight();

            // 1. Dibujamos el fondo primero
            g2d.drawImage(nada, 0, 0, anchoTotal, altoTotal, this);

            // 2. Dibujamos los objetos exactamente igual que el fondo.
            // Al tener el mismo tamaño y la posición correcta en su transparencia, encajarán solos.
            if (ll) {
                g2d.drawImage(llave, 0, 0, anchoTotal, altoTotal, this);
            }

            if (m) {
                g2d.drawImage(maza, 0, 0, anchoTotal, altoTotal, this);
            }

            if (h) {
                g2d.drawImage(hacha, 0, 0, anchoTotal, altoTotal, this);
            }

            if (l) {
                g2d.drawImage(linterna, 0, 0, anchoTotal, altoTotal, this);
            }
        }
    }
}
