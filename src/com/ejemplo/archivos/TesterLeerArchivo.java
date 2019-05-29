package com.ejemplo.archivos;

/**
 * TesterLeerArchivo
 */
public class TesterLeerArchivo {

    public static void main(String[] args) {
        LeerArchivo la = new LeerArchivo();

        la.leer_desde_archivo_Bytes("./src/com/ejemplo/archivos/list.txt");
    }
}