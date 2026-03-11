package juegoseco.logica;

public class mensaje_perdedor {
    public void mensaje_perdedor(){
        try{
        System.out.println("\n");
        System.out.println("   ____    _    __  __ _____    _____     _______ ____  ");
        System.out.println("  / ___|  / \\  |  \\/  | ____|  / _ \\ \\   / / ____|  _ \\ ");
        System.out.println(" | |  _  / _ \\ | |\\/| |  _|   | | | \\ \\ / /|  _| | |_) |");
        System.out.println(" | |_| |/ ___ \\| |  | | |___  | |_| |\\ V / | |___|  _ < ");
        System.out.println("  \\____/_/   \\_\\_|  |_|_____|  \\___/  \\_/  |_____|_| \\_\\");
        System.out.println("\n=======================💀 Tu historia termina aquí 💀=======================\n");
        Thread.sleep(2000);
    }catch(Exception e){
            System.out.println("El mensaje de error no funciona correctamente");
        }
    }
}
