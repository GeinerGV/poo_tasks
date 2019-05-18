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

	public int getCorrelativo() {
		return correlativo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getRuc_emisor() {
		return ruc_emisor;
	}

	public void setRuc_emisor(String ruc_emisor) {
		this.ruc_emisor = ruc_emisor;
	}

	public String getRazon_emisor() {
		return razon_emisor;
	}

	public void setRazon_emisor(String razon_emisor) {
		this.razon_emisor = razon_emisor;
	}

	@Override
	public String toString() {
		return "Comprobante [correlativo=" + correlativo + ", fecha=" + fecha + ", razon_emisor=" + razon_emisor
				+ ", ruc_emisor=" + ruc_emisor + "]";
	}
	protected String toStringInChild() {
		return "correlativo=" + correlativo + ", fecha=" + fecha + ", razon_emisor=" + razon_emisor
				+ ", ruc_emisor=" + ruc_emisor;
	}


	
}
