package com.ejemplo;

public class Ejemplo1 {
	public staic void main() {
		int j;
		try {
			j = 1/j;
			System.out.pritln("Pasamos por la división");
			
		} catch(NullPointerException e) {
			System.out.pritln("Capturamos un error en la división");
		} catch(Exception e) {
			System.out.println("Se produjo el siguiente error:");
			e.printStackTrace();
		} finally {
			System.out.pritln("RetoCumplido¡");
		}
		System.out.pritln("Seguimos con el programa");
	}
}
