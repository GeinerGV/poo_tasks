package edu.usil.arreglos;

import java.util.Scanner;

public class Ejercicio01 {
	
	public static void main(String[] args) {
		Ejercicio01 eo1 = new Ejercicio01();
		e01.promedio();
	}
	
	public void promedio() {
		Scanner sc = new Scanner(System.in);
		int[] numeros = new int[5];
		int suma = 0;
		
		for (int i=0; i<numeros.length; i++) {
			System.out.println("Ingrese el número "+i);
			numeros[i] = sc.nextInt();
			suma += numeros[i];
		}
		
		for (int i=0; i<numeros.length; i++) {
			System.out.println("["+i+"]="+numeros[i]+"\t");
		}
		System.out.println("El promedio es "+(suma/5));
	}
}
