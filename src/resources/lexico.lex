package analizadorjava;
import  java_cup.runtime.Symbol;
%%
%cup
%full
%line
%char
%class Lexer
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

%(public)%
{abstract}{return new Symbol(sym.ABSTRACTO,yychar,yyline,yytext());}
{args}{return new Symbol(sym.ARGUMENTO,yychar,yyline,yytext());}
{boolean}{return new Symbol(sym.BOOLEANO,yychar,yyline,yytext());}
{break}{return new Symbol(sym.ROMPER,yychar,yyline,yytext());}
{case}{return new Symbol(sym.CASO,yychar,yyline,yytext());}
{catch}{return new Symbol(sym.CACHAR,yychar,yyline,yytext());}
{class}{return new Symbol(sym.CLASE,yychar,yyline,yytext());}
{default}{return new Symbol(sym.DEFECTO,yychar,yyline,yytext());}
{do}{return new Symbol(sym.HACER,yychar,yyline,yytext());}
{double}{return new Symbol(sym.DOBLE,yychar,yyline,yytext());}{{ {} 
{else}{return new Symbol(sym.SINO,yychar,yyline,yytext());}
{float}{return new Symbol(sym.FLOTANTE,yychar,yyline,yytext());}
{for}{return new Symbol(sym.CICLOFOR,yychar,yyline,yytext());}
{if}{return new Symbol(sym.SI,yychar,yyline,yytext());} 
{import}{return new Symbol(sym.IMPORTAR,yychar,yyline,yytext());} 
{int}{return new Symbol(sym.ENTERO,yychar,yyline,yytext());} 
{new}{return new Symbol(sym.NUEVO,yychar,yyline,yytext());} 
{package}{return new Symbol(sym.PAQUETE,yychar,yyline,yytext());} 
{private}{return new Symbol(sym.PRIVADO,yychar,yyline,yytext());} 
{protected}{return new Symbol(sym.PROTEGIDO,yychar,yyline,yytext());} 
{public}{return new Symbol(sym.PUBLICO,yychar,yyline,yytext());} 
{return}{return new Symbol(sym.RETORNAR,yychar,yyline,yytext());} 
{static}{return new Symbol(sym.ESTATICO,yychar,yyline,yytext());} 
{switch}{return new Symbol(sym.INTERRUMPUTOR,yychar,yyline,yytext());} 
{string}{return new Symbol(sym.STRING,yychar,yyline,yytext());} 
{try}{return new Symbol(sym.INTENTAR,yychar,yyline,yytext());} 
{void}{return new Symbol(sym.HUECO,yychar,yyline,yytext());} 
{true}{return new Symbol(sym.VERDADERO,yychar,yyline,yytext());} 
{false}{return new Symbol(sym.FALSO,yychar,yyline,yytext());} 
{while}{return new Symbol(sym.MIENTRAS,yychar,yyline,yytext());} 
{variable}{return new Symbol(sym.VARIABLE,yychar,yyline,yytext());} 
{cadena}{return new Symbol(sym.CADENA,yychar,yyline,yytext());} 
{numeroInt}{return new Symbol(sym.VALORINT,yychar,yyline,yytext());} 
{numeroFloat}{return new Symbol(sym.VALORFLOAT,yychar,yyline,yytext());} 
{numeroDoble}{return new Symbol(sym.VALORDOBLE,yychar,yyline,yytext());} 
{comilla}{return new Symbol(sym.COMILLA,yychar,yyline,yytext());} 
{boleano}{return new Symbol(sym.BOOLEANO,yychar,yyline,yytext());} 
{comentarios}{return new Symbol(sym.COMENTARIO,yychar,yyline,yytext());} 

">" {return new Symbol(sym.MAYOR_QUE,yychar,yyline,yytext());}
"<" {return new Symbol(sym.MENOR_QUE,yychar,yyline,yytext());}
">=" {return new Symbol(sym.MAYORIGUAL,yychar,yyline,yytext());}
"=<" {return new Symbol(sym.MENORIGUAL,yychar,yyline,yytext());}
"+" {return new Symbol(sym.SUMA,yychar,yyline,yytext());}
"-" {return new Symbol(sym.RESTA,yychar,yyline,yytext());}
","{return new Symbol(sym.COMA,yychar,yyline,yytext());}
"."{return new Symbol(sym.PUNTO,yychar,yyline,yytext());}
"*"{return new Symbol(sym.MULTIPLICACION,yychar,yyline,yytext());}
"%"{return new Symbol(sym.RESIDUO,yychar,yyline,yytext());}
"("{return new Symbol(sym.ABRIR_PARENTESIS,yychar,yyline,yytext());}
")"{return new Symbol(sym.CERRAR_PARENTESIS,yychar,yyline,yytext());}
"/"{return new Symbol(sym.DIAGONALINVERSA,yychar,yyline,yytext());}
"\"{return new Symbol(sym.DIVISION,yychar,yyline,yytext());}
"["{return new Symbol(sym.CORCHETE_ABRE,yychar,yyline,yytext());}
"]"{return new Symbol(sym.CORCHETE_CIERRA,yychar,yyline,yytext());}
"{"{return new Symbol(sym.ABRIR_LLAVE,yychar,yyline,yytext());}
"}"{return new Symbol(sym.CERRAR_LLAVE,yychar,yyline,yytext());}
":"{return new Symbol(sym.DOS PUNTOS,yychar,yyline,yytext());}
";"{return new Symbol(sym.PUNTO Y COMA,yychar,yyline,yytext());}
"!"{return new Symbol(sym.NOT,yychar,yyline,yytext());}
"="{return new Symbol(sym.IGUAL,yychar,yyline,yytext());}
"=="{return new Symbol(sym.IGUALGUAL,yychar,yyline,yytext());}
"!=" {return new Symbol(sym.DISTINTO,yychar,yyline,yytext());}
"&&" {return new Symbol(sym.AND,yychar,yyline,yytext());}
"||" {return new Symbol(sym.OR,yychar,yyline,yytext());}