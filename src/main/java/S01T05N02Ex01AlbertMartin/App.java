package S01T05N02Ex01AlbertMartin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class AppN01 {

    public static void main(String[] args) throws IOException {

    //Demanem el directori que cal llistar i creem l'arxiu de text que, en aquest cas, es guardarà en el mateix package
    //a on està la classe principal.
        String directoryPath = getDirectoryPath();
        FileWriter fileWriter = new FileWriter("directoryList.txt");
        BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);

     //Afegim recursivament les dades dels arxius del directori en el fitxer directoryList.txt incloent tots els nivells
     //del directori. Si el procés ha anat bé, tanquem l'arxiu i ho comuniquem per pantalla.
        try {
            addDataFiles(directoryPath, bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
            }
        bufferedWriter.flush();
        System.out.println("El arxiu s'he creat correctament");
    }

    //Ordenem els arxius dels directoris alfabèticament.
    public static File[] listSortedDirectoryFiles(String namePath) {
        File file = new File(namePath);
        File[] files = file.listFiles();
        Arrays.sort(files);
        return files;
    }

    //Anem afegint les dades dels arxius. Si l'arxiu és un directori, es repeteix el procés.
    public static void addDataFiles(String directoryPath, BufferedWriter bufferedWriter) throws IOException {
        File[] files = listSortedDirectoryFiles(directoryPath);
        if (files != null && files.length > 0){
            for (File file : files) {
                if(!file.isDirectory()) {
                    bufferedWriter.write(("(- Fitxer)" + " " + file.getName() + " " +
                            new SimpleDateFormat("dd/MM/yyyy").format(file.lastModified())) + "\n");

                } else {
                    bufferedWriter.write(("(Directori:)" + " " + file.getName() + " " +
                            new SimpleDateFormat("dd/MM/yyyy").format(file.lastModified())) + "\n");
                    addDataFiles(file.getAbsolutePath(), bufferedWriter);
                }
            }
        }
    }

    private static String getDirectoryPath() {
        System.out.println("Escriu la ruta del directori que vols llistar");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
