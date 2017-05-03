package analizadorjava;
import  java_cup.runtime.Symbol;
%%
%public
%cup
%full
%line
%column
%class Yylex;
%unicode 
%type Token

abstract=[a][b][s][t][r][a][c][t]
args=[a][r][g][s]
assert=[a][s][s][e][r][t]
boolean=[b][o][o][l][e][a][n]
break=[b][r][e][a][k]
case=[c][a][s][e]
catch=[c][a][t][c][h]
char=[c][h][a][r]
class=[c][l][a][s][s]
default=[d][e][f][a][u][l][t]
do=[d][o]
double=[d][o][u][b][l][e]
else=[e][l][s][e]
float=[f][l][o][a][t]
for=[f][o][r]
if=[i][f]
import=[i][m][p][o][r][t]
int=[i][n][t]
new=[n][e][w]
package=[p][a][c][k][a][g][e]
private=[p][r][i][v][a][t][e]
protected=[p][r][o][t][e][c][t][e][d]
public=[p][u][b][l][i][c]
return=[r][e][t][u][r][n] 
static=[s][t][a][t][i][c]
switch=[s][w][i][t][c][h]
string=[S][t][r][i][n][g]
try=[t][r][y]
void=[v][o][i][d]
while=[w][h][i][l][e]
false=[false]
true=[true]
comilla=["]
variable=[_|$|a-z|A-Z][_|$|a-z|A-Z|0-9]*
cadena=[^"]*
numeroInt=[+|-]*[0-9]+
numeroFloat=([+|-]*[0-9]*.[0-9]+[f])|([+|-]*[0-9]+[f])
numeroDoble=([+|-]*[0-9]*.[0-9]+)|([+|-]*[0-9]+)
boleano=[true|false]
comentarios=[/][/].+
%%

{abstract}{return new Symbol(sym.ABSTRACTO,yyline,yycolumn,yytext());}
{args}{return new Symbol(sym.ARGUMENTO,yyline,yycolumn,yytext());}
{boolean}{return new Symbol(sym.BOOLEANO,yyline,yycolumn,yytext());}
{break}{return new Symbol(sym.ROMPER,yyline,yycolumn,yytext());}
{case}{return new Symbol(sym.CASO,yyline,yycolumn,yytext());}
{catch}{return new Symbol(sym.CACHAR,yyline,yycolumn,yytext());}
{class}{return new Symbol(sym.CLASE,yyline,yycolumn,yytext());}
{default}{return new Symbol(sym.DEFECTO,yyline,yycolumn,yytext());}
{do}{return new Symbol(sym.HACER,yyline,yycolumn,yytext());}
{double}{return new Symbol(sym.DOBLE,yyline,yycolumn,yytext());}{{ {} 
{else}{return new Symbol(sym.SINO,yyline,yycolumn,yytext());}
{float}{return new Symbol(sym.FLOTANTE,yyline,yycolumn,yytext());}
{for}{return new Symbol(sym.CICLOFOR,yyline,yycolumn,yytext());}
{if}{return new Symbol(sym.SI,yyline,yycolumn,yytext());} 
{import}{return new Symbol(sym.IMPORTAR,yyline,yycolumn,yytext());} 
{int}{return new Symbol(sym.ENTERO,yyline,yycolumn,yytext());} 
{new}{return new Symbol(sym.NUEVO,yyline,yycolumn,yytext());} 
{package}{return new Symbol(sym.PAQUETE,yyline,yycolumn,yytext());} 
{private}{return new Symbol(sym.PRIVADO,yyline,yycolumn,yytext());} 
{protected}{return new Symbol(sym.PROTEGIDO,yyline,yycolumn,yytext());} 
{public}{return new Symbol(sym.PUBLICO,yyline,yycolumn,yytext());} 
{return}{return new Symbol(sym.RETORNAR,yyline,yycolumn,yytext());} 
{static}{return new Symbol(sym.ESTATICO,yyline,yycolumn,yytext());} 
{switch}{return new Symbol(sym.INTERRUMPUTOR,yyline,yycolumn,yytext());} 
{string}{return new Symbol(sym.STRING,yyline,yycolumn,yytext());} 
{try}{return new Symbol(sym.INTENTAR,yyline,yycolumn,yytext());} 
{void}{return new Symbol(sym.HUECO,yyline,yycolumn,yytext());} 
{true}{return new Symbol(sym.VERDADERO,yyline,yycolumn,yytext());} 
{false}{return new Symbol(sym.FALSO,yyline,yycolumn,yytext());} 
{while}{return new Symbol(sym.MIENTRAS,yyline,yycolumn,yytext());} 
{variable}{return new Symbol(sym.VARIABLE,yyline,yycolumn,yytext());} 
{cadena}{return new Symbol(sym.CADENA,yyline,yycolumn,yytext());} 
{numeroInt}{return new Symbol(sym.VALORINT,yyline,yycolumn,yytext());} 
{numeroFloat}{return new Symbol(sym.VALORFLOAT,yyline,yycolumn,yytext());} 
{numeroDoble}{return new Symbol(sym.VALORDOBLE,yyline,yycolumn,yytext());} 
{comilla}{return new Symbol(sym.COMILLA,yyline,yycolumn,yytext());} 
{boleano}{return new Symbol(sym.BOOLEANO,yyline,yycolumn,yytext());} 
{comentarios}{return new Symbol(sym.COMENTARIO,yyline,yycolumn,yytext());} 

">" {return new Symbol(sym.MAYORQUE,yyline,yycolumn,yytext());}
"<" {return new Symbol(sym.MENORQUE,yyline,yycolumn,yytext());}
">=" {return new Symbol(sym.MAYORIGUAL,yyline,yycolumn,yytext());}
"=<" {return new Symbol(sym.MENORIGUAL,yyline,yycolumn,yytext());}
"+" {return new Symbol(sym.SUMA,yyline,yycolumn,yytext());}
"-" {return new Symbol(sym.RESTA,yyline,yycolumn,yytext());}
","{return new Symbol(sym.COMA,yyline,yycolumn,yytext());}
"."{return new Symbol(sym.PUNTO,yyline,yycolumn,yytext());}
"*"{return new Symbol(sym.MULTIPLICACION,yyline,yycolumn,yytext());}
"%"{return new Symbol(sym.RESIDUO,yyline,yycolumn,yytext());}
"("{return new Symbol(sym.ABRIR_PARENTESIS,yyline,yycolumn,yytext());}
")"{return new Symbol(sym.CERRAR_PARENTESIS,yyline,yycolumn,yytext());}
"/"{return new Symbol(sym.DIAGONALINVERSA,yyline,yycolumn,yytext());}
"\"{return new Symbol(sym.DIVISION,yyline,yycolumn,yytext());}
"["{return new Symbol(sym.CORCHETE_ABRE,yyline,yycolumn,yytext());}
"]"{return new Symbol(sym.CORCHETE_CIERRA,yyline,yycolumn,yytext());}
"{"{return new Symbol(sym.ABRIR_LLAVE,yyline,yycolumn,yytext());}
"}"{return new Symbol(sym.CERRAR_LLAVE,yyline,yycolumn,yytext());}
":"{return new Symbol(sym.DOS PUNTOS,yyline,yycolumn,yytext());}
";"{return new Symbol(sym.PUNTO Y COMA,yyline,yycolumn,yytext());}
"!"{return new Symbol(sym.NOT,yyline,yycolumn,yytext());}
"="{return new Symbol(sym.IGUAL,yyline,yycolumn,yytext());}
"=="{return new Symbol(sym.IGUALGUAL,yyline,yycolumn,yytext());}
"!=" {return new Symbol(sym.DISTINTO,yyline,yycolumn,yytext());}
"&&" {return new Symbol(sym.AND,yyline,yycolumn,yytext());}
"||" {return new Symbol(sym.OR,yyline,yycolumn,yytext());}
(\n|\r|\t|" ")  { }
.    { System.out.println("Error Lexico " + (yyline+1) + " " + (yycolumn+1) + " " + yytext() ); }