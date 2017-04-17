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
try=[t][r][y]
void=[v][o][i][d]
while=[w][h][i][l][e]

comilla=["]
variable=[_|$|a-z|A-Z][_|$|a-z|A-Z|0-9]*
cadena=[^"]*
numeroInt=[+|-]*[0-9]+
numeroFloat=([+|-]*[0-9]*.[0-9]+[f])|([+|-]*[0-9]+[f])
numeroDoble=([+|-]*[0-9]*.[0-9]+)|([+|-]*[0-9]+)
boleano=[0|1]
comentarios=[/][/].+

%(public)%

">" {return new Symbol(sym.	,yychar,yyline,yytext());}
"<" {return new Symbol(sym.	,yychar,yyline,yytext());}
">=" {return new Symbol(sym.	,yychar,yyline,yytext());}
"=<" {return new Symbol(sym.	,yychar,yyline,yytext());}
"+" {return new Symbol(sym.	,yychar,yyline,yytext());}
"-" {return new Symbol(sym.	,yychar,yyline,yytext());}
","{return new Symbol(sym.	,yychar,yyline,yytext());}
"."{return new Symbol(sym.	,yychar,yyline,yytext());}
"*"{return new Symbol(sym.	,yychar,yyline,yytext());}
"%"{return new Symbol(sym.	,yychar,yyline,yytext());}
"("{return new Symbol(sym.	,yychar,yyline,yytext());}
")"{return new Symbol(sym.	,yychar,yyline,yytext());}
"/"{return new Symbol(sym.	,yychar,yyline,yytext());}
"\"{return new Symbol(sym.	,yychar,yyline,yytext());}
"["{return new Symbol(sym.	,yychar,yyline,yytext());}
"]"{return new Symbol(sym.	,yychar,yyline,yytext());}
"{"{return new Symbol(sym.	,yychar,yyline,yytext());}
"}"{return new Symbol(sym.	,yychar,yyline,yytext());}
":"{return new Symbol(sym.	,yychar,yyline,yytext());}
";"{return new Symbol(sym.	,yychar,yyline,yytext());}
"!"{return new Symbol(sym.	,yychar,yyline,yytext());}
"="{return new Symbol(sym.	,yychar,yyline,yytext());}
"=="{return new Symbol(sym.	,yychar,yyline,yytext());}
"!=" {return new Symbol(sym.	,yychar,yyline,yytext());}
"&&" {return new Symbol(sym.	,yychar,yyline,yytext());}
"||" {return new Symbol(sym.	,yychar,yyline,yytext());}

{abstract}{return new Symbol(sym.	,yychar,yyline,yytext());}
{assert}{return new Symbol(sym.	,yychar,yyline,yytext());}
{args}{return new Symbol(sym.	,yychar,yyline,yytext());}
{boolean}{return new Symbol(sym.	,yychar,yyline,yytext());}
{break}{return new Symbol(sym.	,yychar,yyline,yytext());}
{case}{return new Symbol(sym.	,yychar,yyline,yytext());}
{catch}{return new Symbol(sym.	,yychar,yyline,yytext());}
{char}{return new Symbol(sym.	,yychar,yyline,yytext());}
{class}{return new Symbol(sym.	,yychar,yyline,yytext());}
{default}{return new Symbol(sym.	,yychar,yyline,yytext());}
{do}{return new Symbol(sym.	,yychar,yyline,yytext());}
{double}{return new Symbol(sym.	,yychar,yyline,yytext());}{{ {} 
{else}{return new Symbol(sym.	 ,yychar,yyline,yytext());}
{float}{return new Symbol(sym.	 ,yychar,yyline,yytext());}
{for}{return new Symbol(sym.	 ,yychar,yyline,yytext());}
{if}{return new Symbol(sym.	 ,yychar,yyline,yytext());} 
{import}{return new Symbol(sym.  ,yychar,yyline,yytext());} 
{int}{return new Symbol(sym.	,yychar,yyline,yytext());} 
{new}{return new Symbol(sym.	,yychar,yyline,yytext());} 
{package}{return new Symbol(sym.	,yychar,yyline,yytext());} 
{private}{return new Symbol(sym.	,yychar,yyline,yytext());} 
{protected}{return new Symbol(sym.	,yychar,yyline,yytext());} 
{public}{return new Symbol(sym.	,yychar,yyline,yytext());} 
{return}{return new Symbol(sym.	,yychar,yyline,yytext());} 
{static}{return new Symbol(sym.	,yychar,yyline,yytext());} 
{switch}{return new Symbol(sym.	,yychar,yyline,yytext());} 
{try}{return new Symbol(sym.	,yychar,yyline,yytext());} 
{void}{return new Symbol(sym.	,yychar,yyline,yytext());} 
{while}{return new Symbol(sym.	,yychar,yyline,yytext());} 
{palabra}{return new Symbol(sym.	,yychar,yyline,yytext());} 
{string}{return new Symbol(sym.	,yychar,yyline,yytext());} 
{numeroInt}{return new Symbol(sym.	,yychar,yyline,yytext());} 
{numeroFloat}{return new Symbol(sym.	,yychar,yyline,yytext());} 
{numeroDoble}{return new Symbol(sym.	,yychar,yyline,yytext());} 
{comilla}{return new Symbol(sym.	,yychar,yyline,yytext());} 
{boleano}{return new Symbol(sym.	,yychar,yyline,yytext());} 
{comentarios}{return new Symbol(sym.	,yychar,yyline,yytext());} 