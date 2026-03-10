package juegoseco.audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class iniciar_musica {
    public static void iniciar_musica_juego(Clip musicaMenu) {
        try {
            String ruta = "Sonidos\\sonido_de_fondo.wav";

            AudioInputStream audio = AudioSystem.getAudioInputStream(new File(ruta));
            musicaMenu = AudioSystem.getClip();
            musicaMenu.open(audio);
            musicaMenu.loop(Clip.LOOP_CONTINUOUSLY); // 🎵Repetir en bucle
            musicaMenu.start();

        } catch (Exception e) {
            System.out.println("No se pudo cargar la música: " + e.getMessage());
        }
    }
}
