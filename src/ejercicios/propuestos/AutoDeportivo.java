package ejercicios.propuestos;

public class AutoDeportivo extends Vehiculo {
    private static int numeroPuertas = 2;
    private int velocidadMaxima;

    public AutoDeportivo(String marca, String color, int velMax) {
        super(marca, color);
        velocidadMaxima = velMax;
    }
    
    public String toString() {
        return "AutoDeportivo("+marca+", "+color+", velMax: "+velocidadMaxima+")";
    }
}