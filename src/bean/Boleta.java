package bean;

public class Boleta extends Comprobante {
	private static int numeracion = 0;
	private String nombre_cliente;
	private double monto;
	
	public Boleta() {
		super(++numeracion);
	}
}
