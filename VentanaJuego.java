import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VentanaJuego extends JFrame{

    public JPanel imagePanel, bottomPanel, buttonPanel;
    public JLabel imageLabel;
    public JTextArea mainTextArea;
    public JButton choice1, choice2;

    public VentanaJuego(){

        setSize(900,700);
        getContentPane().setBackground(Color.decode("#0D1B2A"));
        setTitle("Ecos del Bosque Roto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false); // asi evita que se vea grande, ya que es una pantalla pequeña
        setLayout(new BorderLayout());

        interfaz();

    }

    private void interfaz(){


        imagePanel = new BackgroundPanel("ruta/a/tu/imagen.png");
        imagePanel.setBackground(Color.BLACK); // Fondo negro por si la imagen no carga

        add(imagePanel, BorderLayout.CENTER);

        // 2. PANEL DEL TEXTO (Medio-Abajo)
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBorder(new EmptyBorder(20, 50, 30, 50));
        bottomPanel.setBackground(Color.decode("#0D1B2A")); // Mismo color de tu fondo general

        mainTextArea = new JTextArea("Texto");
        mainTextArea.setBackground(Color.decode("#0D1B2A"));
        mainTextArea.setForeground(Color.WHITE); // Texto en blanco para contrastar
        mainTextArea.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
        mainTextArea.setLineWrap(true); // Hace que el texto salte de línea si llega al borde
        mainTextArea.setWrapStyleWord(true); // Evita cortar palabras a la mitad
        mainTextArea.setEditable(false); // El jugador no puede escribir aquí
        mainTextArea.setRows(4); // Establece el número de filas

        bottomPanel.add(mainTextArea, BorderLayout.CENTER);


        // 3. PANEL DE BOTONES (Abajo del todo)
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.decode("#0D1B2A"));
        // Usamos GridLayout aquí para que los botones se repartan el espacio equitativamente
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10)); // 1 fila, 2 columnas, 20px separación horizontal

        // Crear botones
        choice1 = crearBoton("Elección 1");
        choice2 = crearBoton("Elección 2");


        buttonPanel.add(choice1);
        buttonPanel.add(choice2);


        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setBackground(Color.DARK_GRAY);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setFocusPainted(false); // Quita el recuadro feo al hacer clic

        boton.setMargin(new Insets(10,20,10,20));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return boton;
    }

    class BackgroundPanel extends JPanel {
        private Image imagen;

        public BackgroundPanel(String rutaImagen) {
            this.imagen = new ImageIcon(rutaImagen).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (imagen != null) {
                // Dibuja la imagen estirándola para que ocupe el 100% de este panel
                g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    }

