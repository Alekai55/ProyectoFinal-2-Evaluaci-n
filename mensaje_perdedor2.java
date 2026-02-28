import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Scanner;

public class mensaje_perdedor2{
    public void mensaje_perdedor2(Scanner sc, boolean juegoActivo){
        System.out.println("\n");
        System.out.println("   ____    _    __  __ _____    _____     _______ ____  ");
        System.out.println("  / ___|  / \\  |  \\/  | ____|  / _ \\ \\   / / ____|  _ \\ ");
        System.out.println(" | |  _  / _ \\ | |\\/| |  _|   | | | \\ \\ / /|  _| | |_) |");
        System.out.println(" | |_| |/ ___ \\| |  | | |___  | |_| |\\ V / | |___|  _ < ");
        System.out.println("  \\____/_/   \\_\\_|  |_|_____|  \\___/  \\_/  |_____|_| \\_\\");
        System.out.println("\n=======================💀 Tu historia termina aquí 💀=======================\n");
        System.out.println("En tus manos esta, decides reiniciar el juego o por el contrario decides abandonarlo");
        System.out.println("1. Reiniciar el juego 🔁");
        System.out.println("2. Abandonar el juego ❌");
        int decision = sc.nextInt();
        while (decision != 1 && decision != 2) {
            System.out.println("En tus manos esta, decides reiniciar el juego o por el contrario decides abandonarlo");
            System.out.println("1. Reiniciar el juego 🔁");
            System.out.println("2. Abandonar el juego ❌");
            decision = sc.nextInt();
        }
        if (decision == 1) {
            System.out.println("Reiniciando el juego, tomaste una buena decisión");
        }else if (decision == 2) {
            System.out.println("Saliendo del programa... Eres un inútil");
            try {
                // CORRECCIÓN 1: Quitamos las comillas dobles escapadas (\") que sobraban dentro de la ruta
                String ruta = "Sonidos\\081790_quotgame-overquot-evil-88883 (mp3cut.net).wav";

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
                juegoActivo = false;

            } catch (Exception e) {
                System.out.println("No se pudo cargar el sonido del árbol: " + e.getMessage());
                e.printStackTrace(); // Esto te ayudará a ver el error exacto en la consola si falla
            }
            System.exit(0);
        }
    }
}
