package ejemplo01;
public class Deportista extends Persona {
	public Deportista(String nombre, int edad) {
		super(nombre, edad);
	}
	private String deporteFavorito;
	private boolean profesional;
	
	public String getDeporteFavorito() {
		return deporteFavorito;
	}
	public void setDeporteFavorito(String deporteFavorito) {
		this.deporteFavorito = deporteFavorito;
	}
	public boolean isProfesional() {
		return profesional;
	}
	public void setProfesional(boolean profesional) {
		this.profesional = profesional;
	}
	public String toString() {
		return this.getNombre()+" "+this.getEdad()+" "+this.getDeporteFavorito();
	}
}
