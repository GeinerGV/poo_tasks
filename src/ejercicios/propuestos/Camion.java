package ejercicios.propuestos;

public class Camion extends Vehiculo {
	private int numeroEjes;
	private int pesoMaximo;

	public Camion(String marca, String color, int numeroEjes, int pesoMaximo) {
		super(marca, color);
		this.numeroEjes = numeroEjes;
		this.pesoMaximo = pesoMaximo;
	}

	public String toString() {
		return "Camion("+marca+", "+color+", "+numeroEjes+" ejes, pesoMax: "+pesoMaximo+")";
	}
}