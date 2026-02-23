import javax.swing.*;
import java.awt.*;

public class inventario extends JDialog {
    private JButton volver;
    private JLabel texto;
    private Image todo = new ImageIcon("todo.png").getImage();
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
        volver.setBounds(150, 150, 100, 30);
        panelConFondo.add(volver);

        volver.addActionListener(e -> dispose());
    }

    // CLASE INTERNA CORREGIDA
    private class PanelFondo extends JPanel {
        private boolean l, h, m, ll;

        public PanelFondo(boolean linterna, boolean hacha, boolean maza, boolean llaves) {
            this.l = linterna;
            this.h = hacha;
            this.m = maza;
            this.ll = llaves;
        }

        @Override // La firma DEBE ser exactamente así
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Lógica de dibujo según los objetos obtenidos
            if (l && h && m && ll) {
                g.drawImage(todo, 0, 0, getWidth(), getHeight(), this);
            } else if (ll) {
                // Aquí podrías dibujar otra imagen si solo tiene llaves
                g.drawImage(llave, 0, 0, getWidth(), getHeight(), this);
            }else if (h) {
                // Aquí podrías dibujar otra imagen si solo tiene llaves
                g.drawImage(hacha, 0, 0, getWidth(), getHeight(), this);
            }else if (m) {
                // Aquí podrías dibujar otra imagen si solo tiene llaves
                g.drawImage(maza, 0, 0, getWidth(), getHeight(), this);
            }else if (l) {
                // Aquí podrías dibujar otra imagen si solo tiene llaves
                g.drawImage(linterna, 0, 0, getWidth(), getHeight(), this);
            }else {
                g.drawImage(nada,0,0,getWidth(),getHeight(),this);
            }
        }
    }
}