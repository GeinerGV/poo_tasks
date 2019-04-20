package edu.usil.bean;

import java.io.Serializable;

public class Alumno implements Serializable {
	private String codigo;
	private String nombre;
	private String apellido;
	private int ciclo;
	
	public Alumno() {}
	
	public Alumno(String codigo, String nombre, String apellido, int ciclo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ciclo = ciclo;
	}
	
	@Override
	public String toString() {
		return codigo + "\t" + nombre + "\t" + apellido + "\t" + ciclo;
	}
}
