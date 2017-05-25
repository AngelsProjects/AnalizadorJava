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
            for (sym = lexer.next_token(); sym.sym != 0; sym = lexer.next_token()) {
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
        tokens.add(34, "INTENTAR");
        tokens.add(35, "CACHAR");
        tokens.add(36, "ROMPER");
        tokens.add(37, "IGUAL");
        tokens.add(38, "ABRIR_PARENTESIS");
        tokens.add(39, "CERRAR_PARENTESIS");
        tokens.add(40, "ABRIR_LLAVE");
        tokens.add(41, "CERRAR_LLAVE");
        tokens.add(42, "CORCHETE_ABRE");
        tokens.add(43, "CORCHETE_CIERRA");
        tokens.add(44, "SUMA");
        tokens.add(45, "RESTA");
        tokens.add(46, "DIVISION");
        tokens.add(47, "MULTIPLICACION");
        tokens.add(48, "AND");
        tokens.add(49, "OR");
        tokens.add(50, "NOT");
        tokens.add(51, "MAYORIGUAL");
        tokens.add(52, "MENORIGUAL");
        tokens.add(53, "RESIDUO");
        tokens.add(54, "IGUALIGUAL");
        tokens.add(55, "DISTINTO");
        tokens.add(56, "MENORQUE");
        tokens.add(57, "MAYORQUE");
        tokens.add(58, "HUECO");
        tokens.add(59, "PRINCIPAL");
        tokens.add(60, "COMILLA");
        tokens.add(61, "VARIABLE");
        tokens.add(62, "ARGUMENTO");
    }
}
