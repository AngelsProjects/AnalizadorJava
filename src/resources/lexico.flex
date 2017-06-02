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
args=[a][r][g][s]
boolean=[b][o][o][l][e][a][n]
break=[b][r][e][a][k]
case=[c][a][s][e]
classes=[c][l][a][s][s]
default=[d][e][f][a][u][l][t]
do=[d][o]
double=[d][o][u][b][l][e]
else=[e][l][s][e]
float=[f][l][o][a][t]
for=[f][o][r]
if=[i][f]
import=[i][m][p][o][r][t]
int=[i][n][t]
package=[p][a][c][k][a][g][e]
private=[p][r][i][v][a][t][e]
protected=[p][r][o][t][e][c][t][e][d]
public=[p][u][b][l][i][c] 
static=[s][t][a][t][i][c]
switch=[s][w][i][t][c][h]
string=[S][t][r][i][n][g]
void=[v][o][i][d]
while=[w][h][i][l][e]
false=[f][a][l][s][e]
true=[t][r][u][e]
main=[m][a][i][n]
variable=[_|$|a-z][_|$|a-z|A-Z|0-9]*
cadena=(\".*\")
numeroInt=[+|-]*[0-9]+
numeroFloat=([+|-]*[0-9]*.[0-9]+[f])|([+|-]*[0-9]+[f])
numeroDoble=([+|-]*[0-9]*.[0-9]+)|([+|-]*[0-9]+)
boleano=[t][r][u][e]|[f][a][l][s][e]
comentarios=[/][/].+
comment             = {trad_comment} | {line_comment} | {doc_comment}
trad_comment        = "/*" [^*] ~"*/" | "/*" "*"+ "/"
line_comment        = "//" ([^\r\n])* {newline}?
doc_comment         = "/*" "*"+ [^/*] ~"*/"
newline             =   \r|\n|\r\n
%%

<YYINITIAL> {
   
    "."                 { return newSym(sym.PUNTO,yytext()); }
    ";"                { return newSym(sym.PUNTOYCOMA,yytext()); }
    "+"                { return newSym(sym.SUMA,yytext()); }
    "-"                { return newSym(sym.RESTA,yytext()); }
    "*"                { return newSym(sym.MULTIPLICACION,yytext()); }
    "/"                { return newSym(sym.DIVISION,yytext()); }
    "("                { return newSym(sym.ABRIR_PARENTESIS,yytext()); }
    ")"                { return newSym(sym.CERRAR_PARENTESIS,yytext()); }
	":"				   { return newSym(sym.DOSPUNTOS,yytext()); }
	"["					{ return newSym(sym.CORCHETE_ABRE,yytext()); }
	"]"					{ return newSym(sym.CORCHETE_CIERRA,yytext()); }
	"{"					{ return newSym(sym.ABRIR_LLAVE,yytext()); }
	"}"					{ return newSym(sym.CERRAR_LLAVE,yytext()); }
	"!"				   { return newSym(sym.NOT,yytext()); }
	"||"			   { return newSym(sym.OR, yytext()); }
	"&&"			   { return newSym(sym.AND,yytext()); }
	">="				{ return newSym(sym.MAYORIGUAL,yytext()); }
	"<="				{ return newSym(sym.MENORIGUAL,yytext()); }
	">"					{ return newSym(sym.MAYORQUE,yytext()); }
	"<"					{ return newSym(sym.MENORQUE,yytext()); }
	"!="				{ return newSym(sym.DISTINTO,yytext()); }
	"=="				{ return newSym(sym.IGUALIGUAL, yytext()); }
	"="					{ return newSym(sym.IGUAL,yytext()); }
	"%"					{ return newSym(sym.RESIDUO,yytext()); }
}

{variable}  {return newSym(sym.VARIABLE,yytext());}
{if}        {return newSym(sym.SI,yytext());} 
{main}      { return newSym(sym.PRINCIPAL,yytext());}
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
{cadena}    {return newSym(sym.CADENA,yytext());} 
{numeroInt} {return newSym(sym.VALORINT,yytext());} 
{numeroFloat}   {return newSym(sym.VALORFLOAT,yytext());} 
{numeroDoble}   {return newSym(sym.VALORDOBLE,yytext());}
{boleano}   {return newSym(sym.BOOLEANO,yytext());} 
{comentarios}   {return newSym(sym.COMENTARIO,yytext());}
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