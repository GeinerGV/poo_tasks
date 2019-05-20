package bean;

public class Factura extends Comprobante {
	private static final long serialVersionUID = 7399101709666805038L;
	private static int numeracion = 0;
	private String ruc_cliente;
	private String razon_cliente;
	private double monto;
	private double igv;
	
	public Factura () {
		super(++numeracion);
	}

	public Factura(Comprobante c) {
		super(++numeracion, c.getRuc_emisor(), c.getRazon_emisor());
	}

	public static int getNumeracion() {
		return numeracion;
	}

	public String getRuc_cliente() {
		return ruc_cliente;
	}

	public void setRuc_cliente(String ruc_cliente) {
		this.ruc_cliente = ruc_cliente;
	}

	public String getRazon_cliente() {
		return razon_cliente;
	}

	public void setRazon_cliente(String razon_cliente) {
		this.razon_cliente = razon_cliente;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
		setIgv();
	}

	public double getIgv() {
		return igv;
	}

	private void setIgv() {
		this.igv = monto*0.18;
	}

	@Override
	public String toString() {
		return "Factura ["+ toStringInChild() +", igv=" + igv + ", monto=" + monto + ", razon_client=" + razon_cliente + ", ruc_cliente="
				+ ruc_cliente + "]";
	}
}
