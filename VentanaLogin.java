import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaLogin extends JFrame {
    // Declaramos las variables aquí arriba para que "toda la clase" las vea y tambien usarlas en el metodo de interacción
    // porque sino, como las demás las creo en iniciarcomponentes(privado), no las tengo
    private String username;
    private String pwd;
    private int intentos = 3;
    private JLabel titulo, usuario, contrasena;
    private JTextField camponombre;
    private JPasswordField campocontrasena;
    private JButton inicioSesion;
    ImageIcon img = new ImageIcon("logo_trebol.png");

    public VentanaLogin(String usuario, String contrasena) {
        this.username = usuario;
        this.pwd = contrasena;
        // Configuracion de ventana
        setTitle("Ecos del Bosque Roto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null); // Centra la ventana
        setResizable(false); // asi evita que se vea grande, ya que es una pantalla pequeña
        setIconImage(img.getImage());
        setLayout(null);

        // Cambiamos el fondo de la ventana al azul oscuro como en nuestra web
        getContentPane().setBackground(Color.decode("#0D1B2A"));

        iniciarComponentes();
        // Este método lo creo más abajo para no sobrecargar el constructor y que quede mas limpio, si necesito modiifcar algo, modifico el método
    }

    private void iniciarComponentes() {

        // Creamos unas fuentes para usarlas: Nombre, Estilo (Negrita/Plana), Tamaño
        Font fuenteEtiquetas = new Font("SansSerif", Font.BOLD, 14);
        Font fuenteCampos = new Font("Monospaced", Font.PLAIN, 12);
        // Las monoespaciadas van bien para escribir

        // Declaracion y configuracion de texto "titulo"
        titulo = new JLabel("Inicio sesion de usuario");
        titulo.setBounds(110, 10, 200, 20);
        titulo.setFont(new Font("Arial", Font.BOLD, 15));
        titulo.setForeground(Color.decode("#08E576")); // Color neón como en la web
        add(titulo);

        // Declaracion y configuracion de texto "usuario"
        usuario = new JLabel("Nombre de usuario:");
        usuario.setBounds(20, 50, 200, 20);
        usuario.setForeground(Color.WHITE); // Texto en blanco
        usuario.setFont(fuenteEtiquetas);//Usamos las fuentes hechas arriba
        add(usuario);

        // Declaracion y configuracion de campo de texto para el nombre
        // usamos la variable de arriba y crear el objeto
        camponombre = new JTextField(10);
        camponombre.setBounds(160, 52, 130, 20);
        camponombre.setBackground(Color.decode("#183452")); // Azul
        camponombre.setForeground(Color.WHITE);
        camponombre.setCaretColor(Color.WHITE); // Blanco
        add(camponombre);

        // Declaracion y configuracion de texto "contraseña"
        contrasena = new JLabel("Contrasena:");
        contrasena.setBounds(60, 100, 200, 20);
        contrasena.setForeground(Color.WHITE); // Texto en blanco
        contrasena.setFont(fuenteEtiquetas);
        add(contrasena);

        // Declaracion y configuracion de campo de texto para el nombre
        // usamos la variable de arriba para crear el objeto
        campocontrasena = new JPasswordField(10);
        campocontrasena.setBounds(160, 100, 130, 20);
        campocontrasena.setBackground(Color.decode("#183452"));
        campocontrasena.setForeground(Color.WHITE);
        campocontrasena.setCaretColor(Color.WHITE);
        add(campocontrasena);

        // Declaracion y configuracion de boton para iniciar sesion
        // Usamos la variable de arriba
        inicioSesion = new JButton("Iniciar Sesion");
        inicioSesion.setBounds(90, 150, 200, 20);
        inicioSesion.setFocusPainted(false);
        inicioSesion.setBackground(Color.decode("#00FF80")); // Verde Neón
        inicioSesion.setForeground(Color.BLACK); // Texto oscuro para que resalte en el neón
        inicioSesion.setFont(fuenteEtiquetas);
        add(inicioSesion);

        //Empezamos las acciones al pulsar botones:

        // Configuramos la accion del boton al dar click en el
        inicioSesion.addActionListener(e -> {
            String nombre = camponombre.getText();
            String contrasenaIngresada = new String(campocontrasena.getPassword()); //usamos getPassword que es la mejor para manejar JPasswordField

            if (nombre.isEmpty() || contrasenaIngresada.isEmpty() || !nombre.equals(username) || !contrasenaIngresada.equals(pwd)) {
                intentos--;
                JOptionPane.showMessageDialog(null, "Ingrese campos validos\nIntentos restantes: " + intentos, "Advertencia", JOptionPane.WARNING_MESSAGE);
                camponombre.setText("");
                campocontrasena.setText("");
                if (intentos <= 0) {
                    JOptionPane.showMessageDialog(null, "Sin Intentos\nSaliendo del programa...", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
            } else if (nombre.equals(getUsername()) && contrasenaIngresada.equals(getPassword())) {
                JOptionPane.showMessageDialog(null, "Iniciando sesion " + nombre);
                dispose();//asi se quita la ventana sóla y dejar iniciar el juego
                VentanaJuego interfaz = new VentanaJuego();
                interfaz.setVisible(true);
            }
        });

        // Efecto hover para el botón de inicio de sesión
        inicioSesion.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                inicioSesion.setBackground(Color.decode("#61FFB5")); // Se vuelve más claro el verde
            }

            public void mouseExited(MouseEvent e) {
                inicioSesion.setBackground(Color.decode("#00FF80")); // Vuelve al verde neón original
            }
        });
    }

    // Estos métodos (getters) permiten que otras clases lean el valor de las variables privadas,
    // pero al no existir un método "set", no pueden modificarlas. Así protegemos la integridad de los datos.
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return pwd;
    }
}