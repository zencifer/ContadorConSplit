import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Split {

    public static void main(String args[]) {

        if (args.length == 0) {
            System.out.println("Falta el nombre del archivo");
            System.exit(1);
        }

        String fileName = args[0];

        FileReader fileReader = null;

        try {
            fileReader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("El nombre del archivo no se encuentra");
            System.exit(2);
        }

        BufferedReader in = new BufferedReader(fileReader);

        String textLine = null;
        int palabras = 0;
        int contadorLineas = 0;
        String texto;

        // tiempo al inicio
        long start = System.currentTimeMillis();
        try {
            while ((texto = in.readLine()) !=null){
                String[] arrPalabras = texto.split("\\s+");
                palabras = palabras+ arrPalabras.length;
                contadorLineas++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de entrada");
            System.exit(3);
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // tiempo de procesamiento
        long time = System.currentTimeMillis() - start;

        System.out.printf("El archivo %s tiene %,7d palabras. " , fileName, palabras);
        System.out.printf(" Numero de lineas: %,6d%n", contadorLineas);
        System.out.printf("Tiempo procesamiento (milisegundos): %d %n" , time);
    }
}
