package edu.usil.bean;

import java.io.Serializable;

public class Alumno implements Serializable {
	private static final long serialVersionUID = 858336669705994156L;
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
		return "Código: "+codigo + "\n" + "Nombre: "+nombre + "\n" +"Apellidos: "+ apellido + "\n" + "Ciclo: "+ ciclo;
	}
}
