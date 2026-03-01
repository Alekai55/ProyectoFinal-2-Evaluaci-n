package juegoseco.logica;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class mensaje_ganador {
    public static void mensaje_ganador() {
        System.out.println("\n");
        System.out.println("   ___ ___  _  _  ___  ___    _ _____ _   _ _      _ _____ ___ ___  _  _ ___ ");
        System.out.println("  / __/ _ \\| \\| |/ __|| _ \\  /_\\_   _| | | | |    /_\\_   _|_ _/ _ \\| \\| / __|");
        System.out.println(" | (_| (_) | .` | (_ ||   / / _ \\| | | |_| | |__ / _ \\| |  | | (_) | .` \\__ \\");
        System.out.println("  \\___\\___/|_|\\_|\\___||_|_\\/_/ \\_\\_|  \\___/|____/_/ \\_\\_| |___\\___/|_|\\_|___/");
        System.out.println("\n           🥳 ¡HAS TOMADO LA DECISIÓN CORRECTA! 🥳");
        try {
            // CORRECCIÓN 1: Quitamos las comillas dobles escapadas (\") que sobraban dentro de la ruta
            String ruta = "Sonidos\\victoria.wav";

            AudioInputStream audio = AudioSystem.getAudioInputStream(new File(ruta));

            // CORRECCIÓN 2: Usamos una variable nueva (clipArbol) en lugar de 'musicaMenu', para no cortar la música de fondo si estuviera sonando.
            Clip clipArbol = AudioSystem.getClip();

            // Abrir el audio antes de darle a start
            clipArbol.open(audio);
            clipArbol.start();

            //Pausar programa hasta que terine el audio
            long duracionMicrosegundos = clipArbol.getMicrosecondLength();
            long duracionMilisegundos = duracionMicrosegundos / 1000;
            Thread.sleep(duracionMilisegundos + 100);
            System.exit(0);

        } catch (Exception e) {
            System.out.println("No se pudo cargar el sonido del árbol: " + e.getMessage());
            e.printStackTrace(); // Esto te ayudará a ver el error exacto en la consola si falla
        }
    }
}
