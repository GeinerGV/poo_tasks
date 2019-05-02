package bean;

/**
 * Mochilero
 */
public class Mochilero extends Persona {

	private static final long serialVersionUID = 1L;
	
	private String destinoFavorito;
	private int tiempoDeMochilero;

	public Mochilero(String nombre, String paisNacimiento, String paisResidencia, int edad, String destinoFavorito, int tiempoDeMochilero) {
		super(nombre, paisNacimiento, paisResidencia, edad);
		this.destinoFavorito = destinoFavorito;
		this.tiempoDeMochilero = tiempoDeMochilero;
	}

	/**
	 * @return the destinoFavorito
	 */
	public String getDestinoFavorito() {
		return destinoFavorito;
	}

	/**
	 * @param destinoFavorito the destinoFavorito to set
	 */
	public void setDestinoFavorito(String destinoFavorito) {
		this.destinoFavorito = destinoFavorito;
	}

	/**
	 * @return the tiempoDeMochilero
	 */
	public int getTiempoDeMochilero() {
		return tiempoDeMochilero;
	}

	/**
	 * @param tiempoDeMochilero the tiempoDeMochilero to set
	 */
	public void setTiempoDeMochilero(int tiempoDeMochilero) {
		this.tiempoDeMochilero = tiempoDeMochilero;
	}

	@Override
	public String toString() {
		return "Mochilero [\n\tedad=" + super.getEdad() + "\n\tnombre=" + super.getNombre()
		+ "\n\tpaisNacimiento=" + super.getPaisNacimiento()
		+ "\n\tpaisResidencia=" + super.getPaisResidencia()
		+ "\n\tdestinoFavorito=" + destinoFavorito + 
		"\n\ttiempoDeMochilero=" + tiempoDeMochilero + "\n]";
	}
}