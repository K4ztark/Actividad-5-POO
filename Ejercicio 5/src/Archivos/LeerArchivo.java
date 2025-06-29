package Archivos;

import java.io.*;

public class LeerArchivo {

    public static String leerContenidoArchivo(String ruta) throws IOException {
        FileInputStream archivo = new FileInputStream(ruta);
        InputStreamReader conversor = new InputStreamReader(archivo);
        BufferedReader filtro = new BufferedReader(conversor);

        StringBuilder contenido = new StringBuilder();
        String linea = filtro.readLine();

        while (linea != null) {
            contenido.append(linea).append("\n");
            linea = filtro.readLine();
        }

        filtro.close();
        return contenido.toString();
    }
}
