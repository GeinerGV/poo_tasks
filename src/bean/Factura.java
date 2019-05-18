package bean;

public class Factura extends Comprobante {
	private static int numeracion = 0;
	private String ruc_cliente;
	private String razon_client;
	private double monto;
	private double igv;
	
	public Factura () {
		super(++numeracion);
	}

	public static int getNumeracion() {
		return numeracion;
	}

	public static void setNumeracion(int numeracion) {
		Factura.numeracion = numeracion;
	}

	public String getRuc_cliente() {
		return ruc_cliente;
	}

	public void setRuc_cliente(String ruc_cliente) {
		this.ruc_cliente = ruc_cliente;
	}

	public String getRazon_client() {
		return razon_client;
	}

	public void setRazon_client(String razon_client) {
		this.razon_client = razon_client;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public double getIgv() {
		return igv;
	}

	public void setIgv(double igv) {
		this.igv = igv;
	}

	@Override
	public String toString() {
		return "Factura ["+ toStringInChild() +"igv=" + igv + ", monto=" + monto + ", razon_client=" + razon_client + ", ruc_cliente="
				+ ruc_cliente + "]";
	}
}
