package com.ejemplo.arreglos;

import java.util.Arrays;

public class EjercicioPropuesto {
	public static void main(String[] args) {
		String[] palabras = {"Video", "Laptop", "Celular", "Televisor", "Programa"};
		System.out.println("Array desordenado: "+Arrays.toString(palabras)+"\n");
		Arrays.sort(palabras);
		System.out.println("Array ordenado: "+Arrays.toString(palabras)+"\n");
	}
}
