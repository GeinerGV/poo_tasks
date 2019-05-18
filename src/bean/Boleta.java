package bean;

public class Boleta extends Comprobante {
	private static int numeracion = 0;
	private String nombre_cliente;
	private double monto;
	
	public Boleta() {
		super(++numeracion);
	}

	public static int getNumeracion() {
		return numeracion;
	}

	public static void setNumeracion(int numeracion) {
		Boleta.numeracion = numeracion;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "Boleta ["+ toStringInChild() +"monto=" + monto + ", nombre_cliente=" + nombre_cliente + "]";
	}
}
