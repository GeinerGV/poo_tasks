package bean;

import java.io.Serializable;

public class Comprobante implements Serializable {
	private int correlativo;
	private String fecha;
	private String ruc_emisor;
	private String razon_emisor;
	public Comprobante(int correlativo) {
		this.correlativo = correlativo;
	}
	public Comprobante(int correlativo, String fch, String ruc, String razon) {
		this.correlativo = correlativo;
		fecha = fch;
		ruc_emisor = ruc;
		razon_emisor = razon;
	}
}
