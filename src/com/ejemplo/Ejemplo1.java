package com.ejemplo;

public class Ejemplo1 {
	public staic void main() {
		int j = 0;
		try {
			j = 1/j;
			System.out.pritln("Pasamos por la división");
			
		} catch(ArithmeticException e) {
			System.out.pritln("Capturamos un error en la división");
		}
		System.out.pritln("Seguimos con el programa");
	}
}
