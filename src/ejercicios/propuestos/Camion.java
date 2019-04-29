package ejercicios.propuestos;

public class Camion extends Vehiculo {
	private int numeroRuedas;
	private int pesoMaximo;

	public Camion(String marca, String color, int numeroRuedas, int pesoMaximo) {
		super(marca, color);
		this.numeroRuedas = numeroRuedas;
		this.pesoMaximo = pesoMaximo;
	}

	public String toString() {
		return "Camion("+marca+", "+color+", ruedas: "+numeroRuedas+", pesoMax: "+pesoMaximo+")";
	}
}