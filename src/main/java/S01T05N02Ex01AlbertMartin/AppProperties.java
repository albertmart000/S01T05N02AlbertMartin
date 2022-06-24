package S01T05N02Ex01AlbertMartin;

import java.io.*;
import java.util.Properties;

public class AppPropierties {

    private static final String FILE = "/home/albert/Escritorio/IdeaProjects/S01T05N02AlbertMartin/src/App.properties";

    public static void main(String[] args) {

        //Fem l'aexiu de configuració parametritzant tant el directori que volem llistar com l'arxiu a on es guardarà aquesta llista.
        Properties properties= new Properties();
        try {

            FileWriter fileWriter = new FileWriter(FILE);
            BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);

            properties.setProperty("directoryPath", "/home/albert/Escritorio/Biblioteca de Contenidos");
            properties.setProperty("filePath", "/home/albert/Escritorio/IdeaProjects/S01T05N02AlbertMartin/src/DirectoryList.txt");

            properties.store(bufferedWriter, null);

            System.out.println(properties);

        } catch (IOException e) {
            System.out.println("El arxiu no s'ha pogut crear" + e.getMessage());

        }

        try {

            FileReader fileReader = new FileReader(FILE);
            BufferedReader bufferedReader= new BufferedReader(fileReader);

            properties.load(bufferedReader);

            System.out.println("Directori a llegir: " + properties.getProperty("directoryPath") +
                    "\nNom i director del fitxer .txt: " + properties.getProperty("filePath"));

        } catch (IOException e) {
            System.out.println("El arxiu no s'ha pogut crear" + e.getMessage());
        }
    }
}