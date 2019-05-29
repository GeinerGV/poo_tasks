package com.ejemplo.archivos;

import java.io.File;
import java.io.IOException;

/**
 * TesterInformacionArchivo
 */
public class TesterInformacionArchivo {

	public static void main(String[] args) throws IOException {
		if (args.length>0) {
			for (int i = 0; i < args.length; i++) {
				File f = new File(args[i]);
				System.out.println("NOMBRE: " + f.getName());
				System.out.println("RUTA: " + f.getPath());

				if (f.exists()) {
					System.out.println("El archivo existe");
					System.out.println(f.canRead() ? "Tiene permiso de Lectura" : "No se puede escribir");
					System.out.println(f.canWrite() ? "Tiene permiso de Escritura" : "No se puede escribir");
					System.out.println("Tamaño de Archivo: " + f.length() + " bytes");
				} else {
					System.out.println("El archivo no existe.");
				}
			}
		} else {
			System.out.println("Debe indicar un Archivo.");
		}
	}
}