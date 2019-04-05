package edu.usil.facilito01;

import java.util.Scanner;
/**
 * Input01
 */
public class Input01 {

	public static void main(String[] args) {
		Input01 objIp = new Input01();
		objIp.logica();
	}

	public void logica() {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 3; i++) {
			System.out.println("Ingrese un número entero: ");
			int numero = sc.nextInt();
			if (numero%2==0) {
				System.out.println("El número es PAR");
			} else {
				System.out.println("El número es IMPAR");
			}
		}
		sc.close();
	}
}