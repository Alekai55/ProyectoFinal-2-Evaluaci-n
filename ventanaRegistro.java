import javax.swing.*;
import java.awt.*;

public class ventanaRegistro extends JFrame{
    public static String username = "";
    public static String pwd = "";
    ImageIcon img = new ImageIcon("logo_trebol.png");
    private JLabel tituloRegistro, usuarioRegistro, contrasenaRegistro;
    private JTextField camponombreRegistro;
    private JPasswordField campocontrasenaRegistro;
    private JButton registrar = new JButton();
    public ventanaRegistro() {
        getContentPane().setBackground(Color.decode("#0D1B2A"));
        setTitle("Ecos del Bosque Roto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null); // Centra la ventana
        setResizable(false); // asi evita que se vea grande, ya que es una pantalla pequeña
        setIconImage(img.getImage());
        setLayout(null);

        Font fuenteEtiquetas = new Font("SansSerif", Font.BOLD, 14);
        Font fuenteCampos = new Font("Monospaced", Font.PLAIN, 12);

        tituloRegistro = new JLabel("Registro de usuario");
        tituloRegistro.setBounds(110, 10, 200, 20);
        tituloRegistro.setFont(new Font("Arial", Font.BOLD, 15));
        tituloRegistro.setForeground(Color.decode("#08E576")); // Color neón como en la web
        add(tituloRegistro);

        usuarioRegistro = new JLabel("Nombre de usuario:");
        usuarioRegistro.setBounds(20, 50, 200, 20);
        usuarioRegistro.setForeground(Color.WHITE); // Texto en blanco
        usuarioRegistro.setFont(fuenteEtiquetas);//Usamos las fuentes hechas arriba
        add(usuarioRegistro);

        camponombreRegistro = new JTextField(10);
        camponombreRegistro.setBounds(160, 52, 130, 20);
        camponombreRegistro.setBackground(Color.decode("#183452")); // Azul
        camponombreRegistro.setForeground(Color.WHITE);
        camponombreRegistro.setCaretColor(Color.WHITE); // Blanco
        add(camponombreRegistro);

        contrasenaRegistro = new JLabel("Contraseña:");
        contrasenaRegistro.setBounds(60, 100, 200, 20);
        contrasenaRegistro.setForeground(Color.WHITE); // Texto en blanco
        contrasenaRegistro.setFont(fuenteEtiquetas);
        add(contrasenaRegistro);

        campocontrasenaRegistro = new JPasswordField(10);
        campocontrasenaRegistro.setBounds(160, 100, 130, 20);
        campocontrasenaRegistro.setBackground(Color.decode("#183452"));
        campocontrasenaRegistro.setForeground(Color.WHITE);
        campocontrasenaRegistro.setCaretColor(Color.WHITE);
        add(campocontrasenaRegistro);

        // Declaracion y configuracion de boton para registrar usuario
        // Usamos la variable de arriba
        registrar = new JButton("Registrar usuario");
        registrar.setBounds(90, 150, 180, 30);
        registrar.setFocusPainted(false);
        registrar.setBackground(Color.decode("#0D1B2A")); // Fondo oscuro
        registrar.setForeground(Color.decode("#61FFB5")); // Verde menta suave
        registrar.setBorder(BorderFactory.createLineBorder(Color.decode("#00FF80"))); // Borde neón
        add(registrar);

        // Configuramos la accion del boton al dar click en el
        registrar.addActionListener(e -> {
            username = camponombreRegistro.getText(); // Se agrega al String username el texo incluido en el camponombre
            pwd = new String(campocontrasenaRegistro.getPassword()); // Se agrega al String pwd el texto incluido en el campocontraseña
            dispose();
            VentanaLogin ventanaLogin = new VentanaLogin(username,pwd);
            ventanaLogin.setVisible(true);
        });
    }


}