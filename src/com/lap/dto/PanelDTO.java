package com.lap.dto;

import java.io.Serializable;

public class PanelDTO implements Serializable {

	int id;
	String origen;
	String opais;
	String destino;
	String dpais;
	String  numero;
	int asientos;
	int gate;
	String estado;
	String compania;
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append( compania + "\t");
		sb.append( numero + "\t");
		sb.append( origen + "/" + opais + "\t");
		sb.append( destino + "/" + dpais + "\t");
		sb.append( asientos  + "\t" );
		sb.append( gate  + "\t" );
		sb.append( estado  + "\t" );
		return sb.toString();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getOpais() {
		return opais;
	}
	public void setOpais(String opais) {
		this.opais = opais;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getDpais() {
		return dpais;
	}
	public void setDpais(String dpais) {
		this.dpais = dpais;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public int getAsientos() {
		return asientos;
	}
	public void setAsientos(int asientos) {
		this.asientos = asientos;
	}
	public int getGate() {
		return gate;
	}
	public void setGate(int gate) {
		this.gate = gate;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCompania() {
		return compania;
	}
	public void setCompania(String compania) {
		this.compania = compania;
	}
	
}
