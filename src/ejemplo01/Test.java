package ejemplo01;

public class Test {
	public static void main(String[] args) {
		System.out.println("Creando un objeto persona");
		Persona p = new Persona("Pepito Perez", 25);
		System.out.println(p.getNombre());
		System.out.println(p.getEdad());
		
		System.out.println("Creando un deportista");
		Deportista d = new Deportista("Ricardo", 30);
		d.setDeporteFavorito("Natación");
		d.setProfesional(true);
		System.out.println(d);
		System.out.println("cambiando nombre del deportista");
		d.setNombre("Jorgito");
		System.out.println(d);
	}
}
