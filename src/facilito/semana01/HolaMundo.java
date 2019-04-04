package facilito.semana01;

public class HolaMundo {
    public static void main(String[] args) {
        int tope = 5;
        String nombre = "Geiner Grandez Valle (GGV)";
        
        for (int i = 0; i < tope; i++) {
            System.out.println("Hola :)" + i + " " + nombre);

            if (i==4) {
                System.out.println("Reto cumplido! :) ");
            }
        }
    }
}