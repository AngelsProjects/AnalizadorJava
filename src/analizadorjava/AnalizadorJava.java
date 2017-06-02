package analizadorjava;

import java.io.*;

public class AnalizadorJava {

    public static void main(String[] args) throws FileNotFoundException, Exception {
/*
        String fileName = "C:/Users/LaFer/Desktop/AnalizadorJava/src/resources/nepe.java";

        Yylex scanner = new Yylex(new java.io.FileReader(fileName));
        parser p = new parser(scanner);
        p.parse();

        */
        View view = new View();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
         /*
        Wrapper wr = Wrapper.getInstance();
        wr.setMessage("Hola esto es un wrapper");
        System.out.println(wr.getMessage());
        View view = new View();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
         */
    }

}
