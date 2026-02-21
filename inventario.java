public class inventario {
    public void inventario(boolean linterna, boolean hacha, boolean maza, boolean llaves){
        System.out.println("Este es el inventario de tu partida actual:");
        System.out.println("================================================================");
        if (linterna == true){
            System.out.println("- Linterna 🔦, recuerda lo que paso cuando decidiste cogerlas ☘️");
        }
        if (hacha == true){
            System.out.println("- Hacha 🪓, recuerda lo que paso cuando decidiste cogerlas ☘️");
        }
        if (maza == true){
            System.out.println("- Maza 🔨, recuerda lo que paso cuando decidiste cogerlas ☘️");
        }
        if (llaves == true){
            System.out.println("- Llaves 🗝️, recuerda lo que paso cuando decidiste cogerlas ☘️");
        }
        if (linterna == false && hacha == false && maza == false && llaves == false){
            System.out.println("Tu inventario por el momento esta vacio 👜");
        }
        System.out.println("================================================================");
    }
}
