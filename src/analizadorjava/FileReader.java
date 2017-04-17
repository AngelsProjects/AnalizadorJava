package analizadorjava;

import java.io.*;
import java.util.ArrayList;

public class FileReader {

    File entrance;
    FileOutputStream salida;
    BufferedReader reader;
    BufferedWriter bw;
    ArrayList<String> linesFile;
    ArrayList<Tokens> tokenPatron;

    public ArrayList<String> OpenFile(String path) {
        try {
            linesFile = new ArrayList<>();
            entrance = new File(path);
            reader = new BufferedReader(new java.io.FileReader(entrance));
            String line;
            while ((line = reader.readLine()) != null) {
                boolean flag = true;
                if (line.isEmpty() || line == "" || line.matches("[ ]+")) {
                    System.out.println("no mames weeeey!!!");
                    flag = false;
                }
                if (flag) {
                    linesFile.add(line.trim());
                }
               
            }
            reader.close();
        } catch (Exception e) {
            System.err.println("Problema en: " + e);
            return null;
        }
        return linesFile;
    }
}
