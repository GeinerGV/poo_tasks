package ejercicios.propuestos;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random rnd = new Random();
        String[][] marcas = {
            {"Koenigsegg","Lamborghini","W Motors","Bugatti","Ferrari","Aston Martin","Pagani","Maybach"},
            {"Mercedes-Benz","MAN","Iveco","Scania","Volvo","Renault","DAF","Fuso"}
        }
        String[] colores = {"negro", "azul", "marrón", "gris", "verde", "naranja", "rosa", "púrpura", "rojo", "blanco", "amarillo", "turquesa", "verde oliva", "verde menta", "borgoña", "lavanda", "magenta", "salmón", "cian", "beige", "rosado", "verde oscuro", "verde oliva", "lila", "amarillo pálido", "fucsia", "mostaza", "ocre", "trullo", "malva"};
        int[] pesos = {18, 26, 31}
        for (int i = 0; i < 10; i++) {
            int valor = rnd.nextInt((i+1)*2);
            if (valor%2==0) {
                System.out.println(new AutoDeportivo(marcas[0][i%marcas[0].length], colores[i % colores.length], 238+rnd.nextInt(278-238)));
            } else {
                rnd = new Random();
                ejes = 2+rnd.nextInt(3);
                System.out.println(new Camion(marcas[1][i%marcas[1].length], colores[i % colores.length], ejes, pesos[ejes-2]));
            }
        }
    }
}