package juegoseco.ui;

import juegoseco.logica.Proyecto_final;

import javax.swing.*;
import java.awt.*;

public class ventanaIniciarJuego extends JFrame {

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
            // 1. Cerramos la ventana actual (ventanaIniciarJuego)
            dispose();

            // 2. Mostramos el Easter Egg
            easteregg eg  = new easteregg();
            eg.setVisible(true);

            // 3. Creamos un hilo independiente para el temporizador y el juego
            new Thread(() -> {
                try {
                    // Hacemos que este hilo espere 1 segundo (1000 milisegundos)
                    // Mientras tanto, la ventana del easter egg se estará mostrando sin congelarse
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                // 4. Pasado el segundo, cerramos el Easter Egg automáticamente
                eg.dispose();

                // 5. ¡Iniciamos el juego en la consola!
                Proyecto_final pf = new Proyecto_final();
                pf.juego(img);
            }).start();
        });
    }
}
