package com.ejemplo;

public class Ejemplo1 {
	public static void main(String[] args) {
		String j = null;
		try {
			System.out.println(j.length());
			System.out.println("Pasamos por la división");
			
		} catch(NullPointerException e) {
			System.out.println("Capturamos un error en la división");
		} catch(Exception e) {
			System.out.println("Se produjo el siguiente error:");
			e.printStackTrace();
		} finally {
			System.out.println("RetoCumplido¡");
		}
		System.out.println("Seguimos con el programa");
	}
}
