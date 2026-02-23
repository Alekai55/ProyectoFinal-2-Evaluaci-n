import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class reproducirEfecto {

    // Método estático para poder llamarlo sin crear un objeto "new"
    public void reproducir(String nombreArchivo) {
        try {
            // Construimos la ruta sumando la carpeta "Sonidos\" más el nombre que le pasemos
            String ruta = "Sonidos\\" + nombreArchivo;
            File archivo = new File(ruta);

            if (archivo.exists()) {
                AudioInputStream audio = AudioSystem.getAudioInputStream(archivo);
                Clip clip = AudioSystem.getClip();

                // Abrimos el clip
                clip.open(audio);
                clip.start();

                // Esperar a que termine el audio antes de continuar el juego (calculado en milisegundos)
                long duracionMicrosegundos = clip.getMicrosecondLength();
                long duracionMilisegundos = duracionMicrosegundos / 1000;
                Thread.sleep(duracionMilisegundos + 100);

                // Cerramos recursos para no saturar la memoria
                clip.close();
                audio.close();
            } else {
                System.out.println("⚠️ Archivo no encontrado: " + ruta);
            }

        } catch (Exception e) {
            System.out.println("Error al reproducir sonido (" + nombreArchivo + "): " + e.getMessage());
        }
    }
}