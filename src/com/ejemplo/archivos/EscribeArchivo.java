package com.ejemplo.archivos;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * EscribeArchivo
 */
public class EscribeArchivo {
    /**
     * Lee desde teclado y escribe byte x byte en un archivo
     * @param nombre_archivo
     */
    public void escribir_archivo_Byte(String nombre_archivo) {
        try {
            FileOutputStream r = new FileOutputStream(nombre_archivo);

            int nByte = 0;
            int d = System.in.read();

            while (d != 4) {
                ++nByte;
                r.write(d);
                d = System.in.read();
            }
            r.close();
        } catch (IOException e) {
            System.out.println("\n### IO Error: " + e);
        }
    }
}