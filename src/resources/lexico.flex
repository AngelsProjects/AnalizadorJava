package analizadorjava;
import  java_cup.runtime.*;
%%

%cup
%line
%column
%unicode
%class Yylex

%{

/**
 * Return a new Symbol with the given token id, and with the current line and
 * column numbers.
 */
Symbol newSym(int tokenId) {
    return new Symbol(tokenId, yyline+1, yycolumn+1);
}

/**
 * Return a new Symbol with the given token id, the current line and column
 * numbers, and the given token value.  The value is used for tokens such as
 * identifiers and numbers.
 */

Symbol newSym(int tokenId, Object value) {
    return new Symbol(tokenId, yyline+1, yycolumn+1, value);
}

%}
args=[args]
boolean=[boolean]
break=[break]
case=[case]
catch=[catch]
classes=[c][l][a][s][s]
default=[default]
do=[d][o]
double=[d][o][u][b][l][e]
else=[e][l][s][e]
float=[f][l][o][a][t]
for=[f][o][r]
if=[if]
import=[import]
int=[i][n][t]
package=[p][a][c][k][a][g][e]
private=[private]
protected=[p][r][o][t][e][c][t][e][d]
public=[p][u][b][l][i][c] 
static=[s][t][a][t][i][c]
switch=[switch]
string=[String]
void=[v][o][i][d]
while=[w][h][i][l][e]
false=[f][a][l][s][e]
true=[t][r][u][e]
comilla=[\"]
variable=[_|$|a-z|A-Z][_|$|a-z|A-Z|0-9]*
cadena=.
numeroInt=[+|-]*[0-9]+
numeroFloat=([+|-]*[0-9]*.[0-9]+[f])|([+|-]*[0-9]+[f])
numeroDoble=([+|-]*[0-9]*.[0-9]+)|([+|-]*[0-9]+)
boleano=[true|false]
comentarios=[/][/].+
SUM = \+
REST = -
MULT = \*
DIV = \/
MOD = %
IGUAL = =
OPIGUAL = ==
DIFERENTE = \!=
MENOR = <
MAYOR = >
MENORIGUAL = <=
MAYORIGUAL = >=
AND = &&
OR = [\|][\|]
NOT = \!
LLAVEA = \{
LLAVEC = \}
CORCHETEA = \[
CORCHETEC = \]
PARENTESISA = \(
PARENTESISC = \)
SEMI = ;
DOSPUNTOS = :

comment             = {trad_comment} | {line_comment} | {doc_comment}
trad_comment        = "/*" [^*] ~"*/" | "/*" "*"+ "/"
line_comment        = "//" ([^\r\n])* {newline}?
doc_comment         = "/*" "*"+ [^/*] ~"*/"
newline             =   \r|\n|\r\n
%%
{args} {return newSym(sym.ARGUMENTO,yytext());}
{boolean}   {return newSym(sym.BOOLEANO,yytext());}
{break}     {return newSym(sym.ROMPER,yytext());}
{case}      {return newSym(sym.CASO,yytext());}
{classes}        { return newSym(sym.CLASE, yytext()); }
{default}   {return newSym(sym.DEFECTO,yytext());}
{do}        {return newSym(sym.HACER,yytext());}
{double}    {return newSym(sym.DOBLE,yytext());} 
{else}      {return newSym(sym.SINO,yytext());}
{float}     {return newSym(sym.FLOTANTE,yytext());}
{for}       {return newSym(sym.PARA,yytext());}
{if}        {return newSym(sym.SI,yytext());} 
{import}    {return newSym(sym.IMPORTAR,yytext());} 
{int}       {return newSym(sym.ENTERO,yytext());} 
{package}   {return newSym(sym.PAQUETE,yytext());} 
{private}   {return newSym(sym.PRIVADO,yytext());} 
{protected} {return newSym(sym.PROTEGIDO,yytext());} 
{public}    {return newSym(sym.PUBLICO,yytext());}
{static}    {return newSym(sym.ESTATICO,yytext());} 
{switch}    {return newSym(sym.INTERRUMPUTOR,yytext());} 
{string}    {return newSym(sym.STRING,yytext());}
{void}      {return newSym(sym.HUECO,yytext());} 
{true}      {return newSym(sym.VERDADERO,yytext());} 
{false}     {return newSym(sym.FALSO,yytext());} 
{while}     {return newSym(sym.MIENTRAS,yytext());} 
{variable}  {return newSym(sym.VARIABLE,yytext());} 
{cadena}    {return newSym(sym.CADENA,yytext());} 
{numeroInt} {return newSym(sym.VALORINT,yytext());} 
{numeroFloat}   {return newSym(sym.VALORFLOAT,yytext());} 
{numeroDoble}   {return newSym(sym.VALORDOBLE,yytext());} 
{comilla}   {return newSym(sym.COMILLA,yytext());} 
{boleano}   {return newSym(sym.BOOLEANO,yytext());} 
{comentarios}   {return newSym(sym.COMENTARIO,yytext());} 
{MAYOR} {return newSym(sym.MAYORQUE,yytext());}
{MENOR} {return newSym(sym.MENORQUE,yytext());}
{MAYORIGUAL} {return newSym(sym.MAYORIGUAL,yytext());}
{MENORIGUAL} {return newSym(sym.MENORIGUAL,yytext());}
{SUM} {return newSym(sym.SUMA,yytext());}
{REST} {return newSym(sym.RESTA,yytext());}
{MULT} {return newSym(sym.MULTIPLICACION,yytext());}
{MOD} {return newSym(sym.RESIDUO,yytext());}
{PARENTESISA} {return newSym(sym.ABRIR_PARENTESIS,yytext());}
{PARENTESISC} {return newSym(sym.CERRAR_PARENTESIS,yytext());}
{DIV} {return newSym(sym.DIVISION,yytext());}
{CORCHETEA} {return newSym(sym.CORCHETE_ABRE,yytext());}
{CORCHETEC} {return newSym(sym.CORCHETE_CIERRA,yytext());}
{LLAVEA} {return newSym(sym.ABRIR_LLAVE,yytext());}
{LLAVEC} {return newSym(sym.CERRAR_LLAVE,yytext());}
{DOSPUNTOS} {return newSym(sym.DOSPUNTOS,yytext());}
{SEMI} {return newSym(sym.PUNTOYCOMA,yytext());}
{NOT} {return newSym(sym.NOT,yytext());}
{IGUAL} {return newSym(sym.IGUAL,yytext());}
{OPIGUAL}                { return newSym(sym.IGUALIGUAL, yytext()); }
{DIFERENTE}    {return newSym(sym.DISTINTO,yytext());}
{AND}    {return newSym(sym.AND,yytext());}
{OR}                { return newSym(sym.OR, yytext()); }
(\n|\r|\t|" ")  { }
{comment}           { System.out.println("Comment recognize :\n" + yytext().substring(2, yylength()-2)); }
<<EOF>>             { return newSym(sym.EOF,"");}
. {  Wrapper wrapper = Wrapper.getInstance();
        if(wrapper.isError()==false)wrapper.setError(true);
        if(wrapper.getMessage().length()>0){
            wrapper.setMessage(wrapper.getMessage()+"\nError de lexico en Linea: " + (yyline+1) + "Columna: " + yycolumn+1 + ". Texto: " + yytext());
        }else{
            wrapper.setMessage("\nError de sintaxis en Linea: " + (yyline+1) + "Columna: " +yycolumn+1 + ". Texto: " + yytext());
        }
 }