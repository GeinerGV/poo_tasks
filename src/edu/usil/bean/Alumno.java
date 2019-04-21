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

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the ciclo
	 */
	public int getCiclo() {
		return ciclo;
	}

	/**
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}
}
