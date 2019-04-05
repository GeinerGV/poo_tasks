package ejercicios.propuestos;
import java.util.Scanner;
/**
 * VistaConsola
 */
public class VistaConsola {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int altura = 0;
		while (altura <=0) {
			System.out.println("Ingrese su estutura en centímetros:");
			altura = sc.nextInt();
		}
		int peso = -1;
		while (peso<0) {
			System.out.println("Ingrese su peso en kilogramos:");
			peso = sc.nextInt();
		}
		sc.close();
		IMC imc = new IMC(altura, peso);
		// System.out.println(imc.calcular());
		System.out.println("\nIMC: "+ imc.getMensaje());
	}
}