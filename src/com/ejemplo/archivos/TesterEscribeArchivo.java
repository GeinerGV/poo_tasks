package com.ejemplo.archivos;

/**
 * TesterEscribeArchivo
 */
public class TesterEscribeArchivo {

    public static void main(String[] args) {
        EscribeArchivo ea = new EscribeArchivo();
        ea.escribir_archivo_Byte("./src/com/ejemplo/archivos/write.txt");
    }
}