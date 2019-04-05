package edu.usil.facilito01;
import java.util.Scanner;

/**
 * Input02
 */
public class Input02 {

	public static void main(String[] args) {
		Input02 objI2 = new Input02();
		objI2.logica();
	}

	public void logica() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese su nombre: ");
		String linea = sc.nextLine();
		sc.close();

		System.out.println("Longitud \t"+linea.length());
		System.out.println("Mayúsculas \t"+linea.toUpperCase());
		System.out.println("Minúsculas \t"+linea.toLowerCase());
		System.out.println("Quitar blancos \t"+linea.trim());

		System.out.println("Concatenar \t"+linea.concat(" HOLA"));
		System.out.println("Indexof \t"+linea.indexOf("Pepito"));
		if (linea.equals("Pepito Perez")) {
			System.out.println("Los strings son idénticos");
		}
		for (int i = 0; i < linea.length(); i++) {
			System.out.println(linea.substring(i, i+1));
		}
		for (int i = linea.length(); i > 0; i--) {
			System.out.println(linea.substring(i-1, i));
		}
	}
}