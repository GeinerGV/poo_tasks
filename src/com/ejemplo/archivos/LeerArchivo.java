package com.ejemplo.archivos;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * LeerArchivo
 */
public class LeerArchivo {
    /**
     * Lee un archivo byte x byte
     * @param nombre_archivo
     */
    public void leer_desde_archivo_Bytes(String nombre_archivo) {
        try {
            FileInputStream r = new FileInputStream(nombre_archivo);

            int a = r.available();
            int nByte = 0;

            int d = r.read();

            while (d != -1) {
                ++nByte;
                System.out.print((char) d);
                d = r.read();
            }
            r.close();
            
            System.out.println("\nCantidad de Bytes leídos = " + nByte);
            System.out.println("Cantidad de Bytes en el archivo = " + a);
        } catch (IOException e) {
            System.out.println("\n### IO Error: " + e);
        }
    }
}