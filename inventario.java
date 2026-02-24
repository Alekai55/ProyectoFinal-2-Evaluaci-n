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

        // PASO 1: Pasamos los booleanos al panel al crearlo
        PanelFondo panelConFondo = new PanelFondo(linterna, hacha, maza, llaves);
        panelConFondo.setLayout(null);
        setContentPane(panelConFondo);

        texto = new JLabel("Este es tu inventario actual");
        texto.setBounds(130, 10, 400, 20);
        texto.setForeground(Color.WHITE);
        panelConFondo.add(texto); // Añadir al panel directamente

        ImageIcon img2 = new ImageIcon("mochila.png");
        Image imagenEscalada = img2.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        img2 = new ImageIcon(imagenEscalada);

        volver = new JButton(img2);
    volver.setBounds(184, 150, 16, 16);
        panelConFondo.add(volver);

        volver.addActionListener(e -> dispose());
    }

    // CLASE INTERNA CORREGIDA
    // CLASE INTERNA CORREGIDA Y MEJORADA
    // CLASE INTERNA CON TODAS LAS COMBINACIONES Y TAMAÑO COMPLETO
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

            // 1. ACTIVAR EL "MODO HD" DE JAVA (Suavizado de bordes)
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int anchoTotal = getWidth();
            int altoTotal = getHeight();

            // Usamos g2d en lugar de g a partir de ahora
            g2d.drawImage(nada, 0, 0, anchoTotal, altoTotal, this);

            // Ejemplo linterna:
            if (l) {
                // Ajusta estos números si la ves estirada/aplastada
                int xLinterna = 277;
                int yLinterna = 50;
                int anchoLinterna = 50;
                int altoLinterna = 115;
                g2d.drawImage(linterna, xLinterna, yLinterna, anchoLinterna, altoLinterna, this);
            }
            // ... (resto de objetos igual, pero con g2d)
        }
    }

}
