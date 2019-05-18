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
}
