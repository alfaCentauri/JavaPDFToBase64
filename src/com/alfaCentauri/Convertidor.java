package com.alfaCentauri;

import java.io.*;
import java.util.stream.Stream;
import java.util.Base64;

public class Convertidor {

    public static void main(String []args) {
        System.out.println("Para codificar en base 64 un documento pdf.");
        String ruta = "data/Protocolo https.pdf";
        String rutaSalida = "data/salida.txt";
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(ruta);
            byte []lineas = inputStream.readAllBytes();
            int countLines = lineas.length;
            System.out.println("Contiene: " + countLines + ", lineas.");
            //
            byte[] encodedBytes = Base64.getEncoder().encode(lineas);
            System.out.println("encodedBytes " + new String(encodedBytes));
            byte[] decodedBytes = Base64.getDecoder().decode(encodedBytes);
            System.out.println("decodedBytes " + new String(decodedBytes));
            //Salida
            FileOutputStream out = new FileOutputStream(new File(rutaSalida));
            out.write(encodedBytes);
            out.close();
            System.out.println("Se guardó correctamente en el disco.\n" + rutaSalida);
            System.out.println("Fin del programa.");
        }catch (Exception error) {
            System.out.println("Error: " + error.getMessage() );
        }
    }

}
