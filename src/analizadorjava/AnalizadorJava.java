package analizadorjava;
import java.io.*;
public class AnalizadorJava {

    public static void main(String[] args) {
         /*
        try {
            parser p = new parser(new Yylex(new java.io.FileReader(new File("C:/Users/LaFer/Desktop/AnalizadorJava/src/resources/nepe.java"))));
            p.parse();
        }
        catch(Exception e) { System.out.println("nomameswey!!"+e.getMessage());}
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
