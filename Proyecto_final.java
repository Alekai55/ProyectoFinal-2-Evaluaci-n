import javax.sound.sampled.*;
import java.io.File;
import java.util.Scanner;

public class Proyecto_final {
    private Scanner sc = new Scanner(System.in);
    private mensaje_ganador mg = new mensaje_ganador();
    private mensaje_perdedor mp = new mensaje_perdedor();
    private mensaje_perdedor2 mp2 = new mensaje_perdedor2();
    private inventario i = new inventario();
    private iniciar_musica musica = new iniciar_musica();
    private Clip musicaMenu;
    private reproducirEfecto reproducirEfecto = new reproducirEfecto();
    private Boolean linterna = false;
    private Boolean hacha = false;
    private Boolean maza = false;
    private Boolean llaves = false;
    private boolean juegoActivo = true;

    public static void main(String[] args) {
        ventanaRegistro ventanaRegistro = new ventanaRegistro();
        ventanaRegistro.setVisible(true);
    }

    /*Método para validad que el usuario escriba 1 o 2 y no otro número o letra
     */
    private int leerOpcion() {
        int opcion;
        while (true) {
            System.out.print("➤ Elige una opción (1 o 2): ");
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                if (opcion == 1 || opcion == 2) {
                    return opcion;
                } else {
                    System.out.println("⚠️ Opción no válida. Debes elegir 1 o 2.");
                }
            } else {
                System.out.println("⚠️ Entrada no válida. Introduce un número.");
                sc.next(); // Limpia el buffer para evitar bucle infinito
            }
        }
    }

    public void juego() {
        do {
            musica.iniciar_musica_juego(musicaMenu);
            System.out.println("========================🌲☘️ Ecos del Bosque Roto ☘️🌲========================");
            i.inventario(linterna, hacha, maza, llaves);
            System.out.println("Despiertas en un bosque oscuro rodeado de árboles muy altos, no llevas nada más que una camiseta negra, una chaqueta, unos pantalones medio rasgados, unas zapatillas de correr desgastadas y un gorro, debido a la situación, tus sentidos se han agudizado, escuchas ruidos variados desde múltiples direcciones. Tienes tan solo de referencia un árbol marcado con un trébol, debes moverte, elige un camino:");
            int opcion;
            System.out.println("Hacia que zona decides avanzar");
            System.out.println("1. Moverse por la parte izquierda del arbol marcado ‍🚶🏼‍♂️️");
            System.out.println("2. Moverse por la parte derecha del arbol marcado 🚶🏼‍♂️‍➡️");
            opcion = leerOpcion(); // Método de validación
            switch (opcion) {
                case 1:
                    System.out.println("Su eleccion fue avanzar por la parte izquierda del arbol marcado");
                    System.out.println("Sigues por un camino donde la tierra comienza a humedecerse y sientes como se te empiezan a hundir los pies en charcas de lodo. ");
                    reproducirEfecto.reproducir("going-on-a-forest-road-gravel-and-grass-6404 (mp3cut.net).wav");
                    System.out.println("¿Qué decides hacer?");
                    System.out.println("1. Subirte al árbol más cercano 🏃🏼‍♂️‍➡️⬆️🌲");
                    System.out.println("2. Moverte más rápido para pasar el camino 🏃🏼‍♂️️💨");
                    opcion = leerOpcion();
                    switch (opcion) {
                        case 1:
                            System.out.println("Su eleccion fue subes al arbol mas cercano");
                            System.out.println("Al hacerlo acabas cansado así que decides reposar un poco. Al cabo de unos minutos escuchas unas campanas sonar, y ves como un grupo de personas encapuchadas pasan por debajo de ti. A uno de ellos se le caen unas llaves");
                            reproducirEfecto.reproducir("climbingdownfromtree-97783 (mp3cut.net).wav");
                            System.out.println("¿Decides bajar a cogerlas?");
                            System.out.println("1. Si ✅");
                            System.out.println("2. No 🔴");
                            opcion = leerOpcion();
                            switch (opcion) {
                                case 1:
                                    llaves = true;
                                    System.out.println("Elegiste bajar a coger las llaves");
                                    System.out.println("Al intentar bajar, se te engancha la chaqueta a una de las ramas y caes a plomo contra el suelo haciendo mucho ruido. El grupo se da la vuelta y corren a por ti.");
                                    reproducirEfecto.reproducir("tintineo-de-llaves-333884 (mp3cut.net).wav");
                                    mp.mensaje_perdedor();
                                    continue;
                                case 2:
                                    llaves = true;
                                    System.out.println("Decidiste no bajar a por las llaves");
                                    System.out.println("Decides esperar a que se vayan. Bajas cautelosamente del árbol y guardas las llaves en el bolsillo de tu chaqueta. Pesan bastante y tienen formas extrañas. Están manchadas de algo aceitoso ");
                                    reproducirEfecto.reproducir("tintineo-de-llaves-333884 (mp3cut.net).wav");
                                    System.out.println("¿Qué camino elegirias?");
                                    System.out.println("1. Ir por donde el grupo 👨🏿‍👩🏻‍👧🏾‍👦🏽");
                                    System.out.println("2. Ir en dirección contraria al grupo ❌👨🏿‍👩🏻‍👧🏾‍👦🏽");
                                    opcion = leerOpcion();
                                    switch (opcion) {
                                        case 1:
                                            System.out.println("Moviéndote de forma cautelosa siguiendo las huellas que van dejando el grupo te encuentras con una enorme aldea de personas, coges unos ropajes que encuentras y caminas por la aldea hasta un callejón en la que ves a varias personas encerradas en jaulas. Asustado metes las manos en los bolsillos y tocas las llaves ");
                                            reproducirEfecto.reproducir("going-on-a-forest-road-gravel-and-grass-6404 (mp3cut.net).wav");
                                            System.out.println("1. Pruebas a abrir las jaulas ⛓️‍💥");
                                            System.out.println("2. Decides continuar tu camino ➡️🚶🏼‍♂️‍➡️");
                                            opcion = leerOpcion();
                                            switch (opcion) {
                                                case 1:
                                                    System.out.println("Tratas de abrir las jaulas, pero tardas demasiado en encontrar las llaves para cada una de ellas. Las personas atrapadas parecen idénticas unas de otras, llevan las mismas prendas y sus rostros son iguales. Al tratar de rescatar a una mujer, se te caen las llaves y al cogerlas, el grupo al que habías seguido te atrapa. En sus túnicas llevan el símbolo de un trébol ");
                                                    reproducirEfecto.reproducir("hit-cage-45988 (mp3cut.net).wav");
                                                    mp.mensaje_perdedor();
                                                    continue;
                                                case 2:
                                                    System.out.println("Continuas por el callejón y al llegar al final de este, una mujer encerrada te dice: “no podrás salir de aquí, no tú solo contigo mismo” Extrañado por sus palabras sales del callejón y te encuentras de frente con el grupo al que estabas siguiendo. Te atrapan. En sus túnicas llevan el símbolo de un trébol");
                                                    reproducirEfecto.reproducir("going-on-a-forest-road-gravel-and-grass-6404 (mp3cut.net).wav");
                                                    mp.mensaje_perdedor();
                                                    continue;
                                            }
                                        case 2:
                                            System.out.println("Al ir en dirección contraria al grupo, te llevan a un camino donde ves a varios grupos de personas que parecen ser cazadores de conejos. Uno de ellos se percata de tu presencia y comienza a gritarte.No parece querer hacerte daño, pero va armado ");
                                            reproducirEfecto.reproducir("going-on-a-forest-road-gravel-and-grass-6404 (mp3cut.net).wav");
                                            System.out.println("1. Dialogas 💬");
                                            System.out.println("2. Corres 🏃🏼‍♂️‍➡️");
                                            opcion = leerOpcion();
                                            switch (opcion) {
                                                case 1:
                                                    System.out.println("Hablas con el hombre, es un señor mayor equipado con los típicos pertrechos de un cazador veterano. Te dice que tengas cuidado, que hay un grupo de personas que están experimentando con seres humanos. Te invita a ir con el grupo de cazadores y te ofrecen una tienda de campaña donde dormir por unas horas. Al despertar, ves que no hay nadie. Tan solo una nota con el dibujo de un trébol y un texto que dice: “no confíes en nadie, más que en ti mismo” Tras leerlo sientes una presión en el pecho y acabas muriendo");
                                                    reproducirEfecto.reproducir("murmullos-7133 (mp3cut.net).wav");
                                                    mp.mensaje_perdedor();
                                                    continue;
                                                case 2:
                                                    System.out.println("Sales corriendo, de fondo escuchas silbidos y sonidos de los cazadores corriendo tras de ti. Comienzan a dispararte, saltas hacia un árbol caído para recuperar el aliento. Reposas un poco y antes de seguir corriendo ves la marca de un trébol en el árbol donde te has cubierto. El hombre que se acercó a ti te grita: “No deberías haber huido, tu solo no vas a conseguirlo” Te han disparado en la cabeza, no ha servido de nada huir, has sido un cobarde.");
                                                    reproducirEfecto.reproducir("running-in-the-woods-65579 (mp3cut.net).wav");
                                                    mp.mensaje_perdedor();
                                                    continue;
                                            }
                                    }
                            }
                        case 2:
                            System.out.println("Escoges moverte rapido para pasar el camino");
                            System.out.println("Pasas corriendo por los enormes charcos de lodo y tropiezas con una piedra marcada con un trébol. Al levantarte sientes una presencia detrás de ti, estás atemorizado, pero curioso ");
                            reproducirEfecto.reproducir("running-in-the-woods-65579 (mp3cut.net).wav");
                            System.out.println("¿Decides darte la vuelta?");
                            System.out.println("1. Si ✅");
                            System.out.println("2. No 🔴");
                            opcion = leerOpcion();
                            switch (opcion) {
                                case 1:
                                    System.out.println("Le echas valor y al darte la vuelta ves que era un pequeño conejito cogiendo bellotas. Logras tranquilizarte y decides seguir el camino seco donde a ves un pasadizo que lleva a una pequeña cabaña  ");
                                    reproducirEfecto.reproducir("a-rabbit-is-eating-a-cucumber-28700 (mp3cut.net).wav");
                                    System.out.println("¿Qué decides a hacer?");
                                    System.out.println("1. Mirar los alrededores 🔎");
                                    System.out.println("2. Entrar a la cabaña 🚶🏼‍♂️‍➡️🛖");
                                    opcion = leerOpcion();
                                    switch (opcion) {
                                        case 1:
                                            System.out.println("Encuentras la entrada al sótano de la cabaña, ves unos tablones y decides tapiar la entrada. Te sientes más seguro, no hace tanto frío, pero sigues indefenso. Exploras la cabaña y encuentras comida, ropa y una pequeña estufa con la que entrar en calor. Cuando consigues sentirte cómodo, escuchas un ruido");
                                            reproducirEfecto.reproducir("going-on-a-forest-road-gravel-and-grass-6404 (mp3cut.net).wav");
                                            System.out.println("¿Qué vas a hacer?");
                                            System.out.println("1. Comprobar su origen 🧏🏼");
                                            System.out.println("2. Esconderse 🐢");
                                            opcion = leerOpcion();
                                            switch (opcion) {
                                                case 1:
                                                    System.out.println("Abres la puerta y ves que eres tu mismo, pero completamente tatuado con tréboles. Todo se vuelve oscuro y tan solo escuchas una voz de ti mismo diciéndote “estás cerca, puedes conseguirlo”");
                                                    reproducirEfecto.reproducir("opening-door-411632 (mp3cut.net).wav");
                                                    mp.mensaje_perdedor();
                                                    continue;
                                                case 2:
                                                    System.out.println("Apagas rápidamente la estufa  y te escondes en un armario cerca de la entrada. En la parte interior de la puerta del armario ves un trébol tallado. Sientes una presión en el pecho, has muerto");
                                                    reproducirEfecto.reproducir("cabinet-door-close-47724 (mp3cut.net).wav");
                                                    mp.mensaje_perdedor();
                                                    continue;
                                            }
                                        case 2:
                                            System.out.println("Entras en la cabaña por la puerta principal. No hay nadie, se respira un ambiente frío y desolador, cierras todas las puertas y ventanas y encuentras una manta que te cubre todo el cuerpo, comida y una hoguera que logras encender con unas cerillas que había.  Encuentras una escopeta y en ese preciso momento escuchas un ruido");
                                            System.out.println("¿Qué vas a hacer?");
                                            System.out.println("1. Comprobar su origen 🧏🏼🔎");
                                            System.out.println("2. Esconderse 🐢");
                                            opcion = leerOpcion();
                                            switch (opcion) {
                                                case 1:
                                                    System.out.println("Al tener la escopeta en tus manos te sientes fuerte, pero realmente no sabes utilizarla, tratas de asomarte por la ventana cercana a la puerta y debido a los nervios disparas sin querer. Asustado, abres la puerta y te ves a ti mismo tirado en el suelo.  Hay una marca en la entrada de un trébol");
                                                    reproducirEfecto.reproducir("shotgun-sounds-6464 (mp3cut.net).wav");
                                                    mp.mensaje_perdedor();
                                                    continue;
                                                case 2:
                                                    System.out.println("Piensas rápidamente donde podrías esconderte y al ir a apagar la hoguera, la puerta se abre de golpe y sientes un profundo dolor que te tumba al suelo. Lo último que logras ver es el símbolo del trébol en la pared interior de la chimenea");
                                                    reproducirEfecto.reproducir("cabinet-door-close-47724 (mp3cut.net).wav");
                                                    mp.mensaje_perdedor();
                                                    continue;
                                            }
                                    }
                                case 2:
                                    System.out.println("Te quedas congelado, tratas de moverte hacia adelante, pero notas como algo empieza a tocarte la espalda y de repente sientes un golpe muy fuerte que te tira al suelo y acto seguido mueres ");
                                    mp.mensaje_perdedor();
                                    continue;
                            }
                    }
                case 2:
                    System.out.println("Su eleccion fue avanzar por la parte derecha del arbol marcado");
                    System.out.println("Sigues por un camino tranquilo en el que de pronto ves una extraña figura a la lejanía, entrando a lo que parece una cabaña ");
                    reproducirEfecto.reproducir("going-on-a-forest-road-gravel-and-grass-6404 (mp3cut.net).wav");
                    System.out.println("¿Qué decides hacer?");
                    System.out.println("1. Dirigirse hacia la figura 🚶🏼‍♂️‍➡️🗿");
                    System.out.println("2. Explorar el entorno 🔎🌲🌳");
                    opcion = leerOpcion();
                    switch (opcion) {
                        case 1:
                            System.out.println("Conforme te acercas a la cabaña empiezas a ver plantas muertas, bandejas de comida tiradas por los alrededores y ves iluminación proveniente de una chimenea dentro de la cabaña. Hay una ventana medio abierta por la que cabes");
                            reproducirEfecto.reproducir("going-on-a-forest-road-gravel-and-grass-6404 (mp3cut.net).wav");
                            System.out.println("¿Decides entrar");
                            System.out.println("1. Si ✅");
                            System.out.println("2. No 🔴");
                            opcion = leerOpcion();
                            switch (opcion) {
                                case 1:
                                    System.out.println("Entras sin hacer ningún ruido, te llega un olor a carne quemada y comienzas a escuchar murmullos de una persona. Al asomarte a la chimenea, ves a una persona apuntándote con una escopeta");
                                    reproducirEfecto.reproducir("window-open-89994 (mp3cut.net).wav");
                                    System.out.println("Aterrorizado solo tienes dos posibles opciones, ¿Cuál decides?");
                                    System.out.println("1. Dialogar 💬");
                                    System.out.println("2. Correr 🏃🏼‍♂️‍➡️");
                                    opcion = leerOpcion();
                                    switch (opcion) {
                                        case 1:
                                            System.out.println("Tratas de explicarte y notas como tu atacante está tan sorprendido como tú, al fijarte más en los detalles de su rostro, sientes una similitud contigo mismo, pero antes de decir nada recibes un disparo en el estómago y al caer al suelo ves en el techo el símbolo del trébol");
                                            reproducirEfecto.reproducir("murmullos-7133 (mp3cut.net).wav");
                                            mp.mensaje_perdedor();
                                            continue;
                                        case 2:
                                            System.out.println("Tratas de huir por donde habías venido, consigues sortear la ventana sin hacerte daño, pero cuando estás a punto de escapar recibes un disparo en la espalda. Sientes un frío con el que comienzas a desmayarte. Al alzar la mirada ves el símbolo del trébol marcado en el árbol más próximo");
                                            reproducirEfecto.reproducir("running-in-the-woods-65579 (mp3cut.net).wav");
                                            mp.mensaje_perdedor();
                                            continue;
                                    }
                                case 2:
                                    linterna = true;
                                    System.out.println("Decides comprobar los alrededores antes de entrar y encuentras un cobertizo con varias herramientas rotas. Logras rescatar una linterna de mucha potencia.");
                                    reproducirEfecto.reproducir("flashlight-clicking-on-and-off-71252 (mp3cut.net).wav");
                                    System.out.println("¿Entras en la cabaña?");
                                    System.out.println("1. Si ✅");
                                    System.out.println("2. No 🔴");
                                    opcion = leerOpcion();
                                    switch (opcion){
                                        case 1:
                                            System.out.println("Al entrar en la cabaña ves a un hombre con una manta que le cubre por completo, parece asustado. Tratas de hablar con él y cuando se da la vuelta ves que es muy parecido a ti. Juntos tratáis de explicar vuestra situación. Tras un largo rato recuperáis energía y discutís sobre lo que debéis hacer.");
                                            reproducirEfecto.reproducir("chirrido-de-puerta-335976 (mp3cut.net).wav");
                                            System.out.println("¿Qué haréis?");
                                            System.out.println("1. Pasar la noche en la cabaña 🌙🛖");
                                            System.out.println("2. Salir de noche 🌙🚶🏼‍♂️‍➡️");
                                            opcion = leerOpcion();
                                            switch (opcion){
                                                case 1:
                                                    reproducirEfecto.reproducir("fire-crackling-sounds-427410 (mp3cut.net).wav");
                                                    System.out.println("Te despiertas, y al alzar la mirada ves a un grupo de personas encapuchadas que tienen a tu compañero amenazado por un cuchillo.  Te dicen: “deberíais haberos ido” Acto seguido degüellan a tu compañero y al momento sientes como tu pecho se hunde y acabas muriendo por un ataque al corazón");
                                                    mp2.mensaje_perdedor2(sc, juegoActivo);
                                                    continue;
                                                case 2:
                                                    reproducirEfecto.reproducir("chirrido-de-puerta-335976 (mp3cut.net).wav");
                                                    System.out.println("Decidís salir rápidamente de noche, tú iluminas el camino con tu linterna y tu compañero vigila los alrededores. Al cabo de un rato, te golpeas contra una pared. Todo este tiempo el bosque era falso, tu compañero y tu sois clones.  Has formado parte de un experimento que muestra si fuéramos capaces de confiar en nosotros mismos de forma literal");
                                                    mg.mensaje_ganador();
                                                    juegoActivo = false;
                                            }
                                        case 2:
                                            System.out.println("Decides no entrar, continúas por el bosque, está muy oscuro, no logras ver nada, escuchas a tu alrededor el sonido del agua, pero no logras intuir de dónde viene.  Logras llegar a un río y al otro lado ves un grupo de varias figuras extrañas observándote. Asustado, tratas de darte la vuelta y huir, pero es demasiado tarde. Te tenían rodeado. Uno de ellos te agarra por el cuello y te estrangula. Antes de morir ves que en su muñeca tiene tatuado un trébol");
                                            mp2.mensaje_perdedor2(sc, juegoActivo);
                                            continue;
                                    }
                            }
                        case 2:
                            System.out.println("Antes de dirigirte a la cabaña, exploras los alrededores. Hay un montón de pieles de conejo apiladas en un tocón y hay varios árboles marcados con un trébol. Al revisar uno de ellos encuentras un hacha oxidada ");
                            reproducirEfecto.reproducir("going-on-a-forest-road-gravel-and-grass-6404 (mp3cut.net).wav");
                            System.out.println("¿Decides coger el hacha?");
                            System.out.println("1. Si ✅");
                            System.out.println("2. No 🔴");
                            opcion = leerOpcion();
                            switch (opcion) {
                                case 1:
                                    hacha = true;
                                    System.out.println("Pesa demasiado pero te sientes menos indefenso, al acercarte a la cabaña ves una entrada exterior al sótano pero está tapiada por maderas con clavos");
                                    reproducirEfecto.reproducir("sword-pick-up-and-throw-45573 (mp3cut.net).wav");
                                    System.out.println("¿decides romperlas con el hacha? ");
                                    System.out.println("1. Si ✅");
                                    System.out.println("2. No 🔴");
                                    opcion = leerOpcion();
                                    switch (opcion) {
                                        case 1:
                                            System.out.println("Al romper la madera haces un ruido tremendo y sientes como alguien dentro de la casa, comienza a correr por ella. Debido a la situación, sin pensarlo, corres escaleras arriba y atacas a alguien idéntico a ti.  Sientes una fuerte presión en el pecho y acabas muriendo sobre tu propio cadáver");
                                            reproducirEfecto.reproducir("chopping_small_wood_pieces-27536 (mp3cut.net).wav");
                                            mp.mensaje_perdedor();
                                            continue;
                                        case 2:
                                            System.out.println("Decides no hacerlo, piensas que es mejor idea tratar de buscar ayuda de manera pacífica.  Tocas la puerta principal de la cabaña y esperas a que alguien te abra.  Una persona de tu misma altura, tapado por una manta y equipado con una escopeta te pide que te identifiques. Le comentas tu situación y rápidamente te abre la puerta para que pases.  Juntos compartís vuestra experiencia y decidís tomar una decisión");
                                            reproducirEfecto.reproducir("door-knock-291150 (mp3cut.net).wav");
                                            System.out.println("1. Pasar la noche en la cabaña 🌙➡️☀️");
                                            System.out.println("2. Salir de noche 🌙🚶🏼‍♂️‍➡️");
                                            opcion = leerOpcion();
                                            switch (opcion) {
                                                case 1:
                                                    System.out.println("Pasáis la noche en vela, no podéis dormir, no entendéis cómo es posible que todo esto haya ocurrido. Empezáis a dudar el uno de otro. Os enfrentáis por ver quien es el verdadero tú");
                                                    System.out.println("¿Quién eres tu realmente? ¿De verdad vas a creerle? ¿A lo mejor tu también mientes?");
                                                    mp2.mensaje_perdedor2(sc, juegoActivo);
                                                    continue;
                                                case 2:
                                                    System.out.println("Salís rápidamente de la cabaña, y al ir a ciegas tropiezas contra un árbol. Se te cae el hacha al suelo y antes de agacharte a cogerla. Tu compañero la recoge del suelo y te dice: “yo voy mejor preparado que tú, este no es tu camino” Ves que ya no es como tú, en sus ojos ves el símbolo del trébol. Te ha matado a sangre fría");
                                                    mp2.mensaje_perdedor2(sc, juegoActivo);
                                                    continue;
                                            }
                                    }
                                case 2:
                                    maza = true;
                                    System.out.println("Al estar oxidada es muy probable que se rompa al usarla así que decides ir camino a la cabaña y sin querer tropiezas con una maza que no habías visto así que decides cogerla e ir a la cabaña. Escuchas ruido dentro y parece aproximarse a dónde estás tu ");
                                    reproducirEfecto.reproducir("sword-pick-up-and-throw-45573 (mp3cut.net).wav");
                                    System.out.println("Le echas valor y decides ponerte en guardia ¿Qué harás?");
                                    System.out.println("1. Golpear antes de aproximarse");
                                    System.out.println("2. Esperar  a que se aproxime");
                                    opcion = leerOpcion();
                                    switch (opcion) {
                                        case 1:
                                            System.out.println("Sin pensarlo dos veces, asestas un golpe certero contra una persona que cae redonda contra el suelo. Tus manos están manchadas de sangre, la maza se ha partido por el golpe y en la parte alta del mango reconoces el símbolo de un trébol. La persona que tienes a tus pies eres tu mismo, no entiendes cómo es posible. Sientes una presión en el corazón y acabas muriendo");
                                            reproducirEfecto.reproducir("hammer-smash-effect-382731 (mp3cut.net).wav");
                                            mp.mensaje_perdedor();
                                            continue;
                                        case 2:
                                            System.out.println("Esperas y de pronto ves el cañón de una escopeta a través de una ventana. Ves todo negro, no queda nada de ti, solo sientes que te has equivocado. Antes de quedarte sumido en el profundo vacío de la muerte, tienes una visión. Ves un símbolo de un trébol que está en varios lugares distintos. Escuchas ecos de tu propia de voz diciéndote que lo intentes una vez más");
                                            reproducirEfecto.reproducir("shotgun-sounds-6464 (mp3cut.net).wav");
                                            mp.mensaje_perdedor();
                                            continue;
                                    }
                            }
                    }
            }
        } while(juegoActivo);
    }
}
