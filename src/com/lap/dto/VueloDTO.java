package com.lap.dto;

import java.io.Serializable;

public class VueloDTO implements Serializable {

	String origen;
	String destino;
	String aerolinea;
	int asientos;
	int disponibles;
	int precio;
	
	public static String getCodigoName(String nameWithCode) {
		return nameWithCode.substring(nameWithCode.lastIndexOf(" ")+2, nameWithCode.length()-1);
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String nameWithCode) {
		this.origen = getCodigoName(nameWithCode);
		System.out.println(nameWithCode+"\t"+origen);
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String nameWithCode) {
		this.destino = getCodigoName(nameWithCode);
		System.out.println(nameWithCode+"\t"+destino);
	}
	public String getAerolinea() {
		return aerolinea;
	}
	public void setAerolinea(String nameWithCode) {
		this.aerolinea = getCodigoName(nameWithCode);
		System.out.println(nameWithCode+"\t"+aerolinea);
	}
	public int getAsientos() {
		return asientos;
	}
	public void setAsientos(int asientos) {
		this.asientos = asientos;
	}
	public int getDisponibles() {
		return disponibles;
	}
	public void setDisponibles(int disponibles) {
		this.disponibles = disponibles;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
}
