package bean;

import java.io.Serializable;

public class Comprobante implements Serializable {
	private String fecha;
	private String ruc_emisor;
	private String razon_emisor;
	public Comprobante() {}
	public Comprobante(String fch, String ruc, String razon) {
		fecha = fch;
		ruc_emisor = ruc;
		razon_emisor = razon;
	}
}
