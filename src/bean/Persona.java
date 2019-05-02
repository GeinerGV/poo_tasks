package bean;

import java.io.Serializable;

/**
 * Persona
 */
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String paisNacimiento;
	private String paisResidencia;
	private int edad;

	public Persona() {}

	public Persona(String nombre, String paisNacimiento, String paisResidencia, int edad) {
		this.nombre = nombre;
		this.paisNacimiento = paisNacimiento;
		this.paisResidencia = paisResidencia;
		this.edad = edad;
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
	 * @return the paisNacimiento
	 */
	public String getPaisNacimiento() {
		return paisNacimiento;
	}

	/**
	 * @param paisNacimiento the paisNacimiento to set
	 */
	public void setPaisNacimiento(String paisNacimiento) {
		this.paisNacimiento = paisNacimiento;
	}

	/**
	 * @return the paisResidencia
	 */
	public String getPaisResidencia() {
		return paisResidencia;
	}

	/**
	 * @param paisResidencia the paisResidencia to set
	 */
	public void setPaisResidencia(String paisResidencia) {
		this.paisResidencia = paisResidencia;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	
}