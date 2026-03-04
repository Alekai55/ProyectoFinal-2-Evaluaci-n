package juegoseco.ui;

import juegoseco.logica.Proyecto_final;

import javax.swing.*;
import java.awt.*;

public class easteregg extends JFrame {

    private JButton iniciarJuego;
    //  Declaramos la imagen con 'private' para proteger
    // la estética de la ventana de inicio frente a modificaciones desde otras partes del programa.
    private ImageIcon img = new ImageIcon("img/logo_trebol.png");

    // PANEL PERSONALIZADO PARA EL FONDO
    //Declaramos este panel como 'private' porque
    // es un componente visual exclusivo de esta ventana. Ninguna otra clase del
    // proyecto necesita (ni debe poder) crear instancias de este fondo personalizado.
    private class PanelConFondo extends JPanel {
        private Image imagen;

        public PanelConFondo(String ruta) {
            imagen = new ImageIcon(ruta).getImage();
        }
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public easteregg() {

        setTitle("Ecos del Bosque Roto");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(img.getImage());

        // PANEL DE FONDO
        PanelConFondo fondo = new PanelConFondo("img/easteregg.png");
        fondo.setLayout(null); // Para colocar el botón libremente
        setContentPane(fondo);
    }
}
