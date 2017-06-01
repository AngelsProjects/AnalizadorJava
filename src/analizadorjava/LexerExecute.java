package analizadorjava;

import java.io.File;
import java.util.ArrayList;
import java_cup.runtime.Symbol;

public class LexerExecute {

    static ArrayList<String> tokens = new ArrayList<>();

    public static String getName(int i) {
        return tokens.get(i);
    }

    public static ArrayList<Symbol> execute(File file) {
        initList();
        Symbol sym;
        ArrayList<Symbol> listSym = new ArrayList();
        try {
            Yylex lexer = new Yylex(new java.io.FileReader(file));
            for(sym = lexer.next_token(); sym.sym != 0; sym = lexer.next_token()) {
                listSym.add(sym);
            }
        } catch (Exception e) {
        }
        return listSym;
    }

    private static void initList() {
        
        tokens.add(0, "EOF");
        tokens.add(1, "error");
        tokens.add(2, "ENTERO");
        tokens.add(3, "FLOTANTE");
        tokens.add(4, "DOBLE");
        tokens.add(5, "BOOLEANO");
        tokens.add(6, "STRING");
        tokens.add(7, "VERDADERO");
        tokens.add(8, "FALSO");
        tokens.add(9, "PUNTOYCOMA");
        tokens.add(10, "DOSPUNTOS");
        tokens.add(11, "PUNTO");
        tokens.add(12, "RETORNAR ");
        tokens.add(13, "VALORINT");
        tokens.add(14, "VALORFLOAT");
        tokens.add(15, "VALORDOBLE");
        tokens.add(16, "VALORBOOLEANO");
        tokens.add(17, "CADENA");
        tokens.add(18, "PRIVADO");
        tokens.add(19, "PUBLICO");
        tokens.add(20, "PROTEGIDO");
        tokens.add(21, "ESTATICO");
        tokens.add(22, "DEFECTO");
        tokens.add(23, "CLASE");
        tokens.add(24, "IMPORTAR");
        tokens.add(25, "PAQUETE");
        tokens.add(26, "COMENTARIO");
        tokens.add(27, "PARA");
        tokens.add(28, "SI");
        tokens.add(29, "INTERRUMPUTOR");
        tokens.add(30, "MIENTRAS");
        tokens.add(31, "HACER");
        tokens.add(32, "CASO");
        tokens.add(33, "SINO");
        tokens.add(34, "ROMPER");
        tokens.add(35, "IGUAL");
        tokens.add(36, "ABRIR_PARENTESIS");
        tokens.add(37, "CERRAR_PARENTESIS");
        tokens.add(38, "ABRIR_LLAVE");
        tokens.add(39, "CERRAR_LLAVE");
        tokens.add(40, "CORCHETE_ABRE");
        tokens.add(41, "SUMA");
        tokens.add(42, "RESTA");
        tokens.add(43, "DIVISON");
        tokens.add(44, "MULTIPLICACION");
        tokens.add(45, "AND");
        tokens.add(46, "OR");
        tokens.add(47, "NOT");
        tokens.add(48, "MAYORIGUAL");
        tokens.add(49, "MENORIGUAL");
        tokens.add(50, "RESIDUO");
        tokens.add(51, "IGUALIGUAL");
        tokens.add(52, "DISTINTO");
        tokens.add(53, "MENORQUE");
        tokens.add(54, "MAYORQUE");
        tokens.add(55, "HUECO");
        tokens.add(56, "PRINCIPAL");
        tokens.add(57, "COMILLA");
        tokens.add(58, "VARIABLE");
        tokens.add(59, "PRINCIPAL");
        tokens.add(60, "COMILLA");
        tokens.add(61, "VARIABLE");
        tokens.add(62, "ARGUMENTO");
    }
}