grammar AnalizLex;

options
{
}

//as the generated lexer will reside in org.meri.antlr_step_by_step.parsers 
//package, we have to add package declaration on top of it
@lexer::header {
package analizadorlex;
}

//as the generated parser will reside in org.meri.antlr_step_by_step.parsers 
//package, we have to add package declaration on top of it
@parser::header {
package analizadorlex;
}

// ***************** Lexer Rules:

COMA : ',';
PCOMA: ';';
APARE: '(';
CPARE: ')';
ALLAV: '{';
CLLAV: '}';
ASUMA: '+';
ASIG : '=';
MAYOR: '>';
EQUAL: '==';
LOGAND: '&&';
ASIGMOD: '%=';
MASMAS: '++';
TRUE: 'true';
FALSE: 'false';
VAR  : 'var';
INT  : 'int';
BOOL : 'bool';
CHAR : 'char';
WRITE: 'write';
WHILE: 'while';
PROMPT: 'prompt';
FUNCTION: 'function';
RETURN: 'return';
IF	 : 'if';
FOR  : 'for';
BREAK: 'break';
ID	 : LETRA(LETRA|DIGITO)*;
NUM  : DIGITO+;
CADENA: '"' (TEXTSTRING)* '"';
COMMENT: '/*' .*? '*/' -> skip;
LINE_COMMENT: '//' ~[\r\n]* -> skip;
DEL  : (' '|'\t'|'\r'|'\n'|'\r\n') -> skip;

fragment 
LETRA	: [a-zA-Z];
fragment
DIGITO	: [0-9];
fragment
TEXTSTRING : ~[\"];
fragment
TEXTCOMMENT1 : ~[\*];
fragment
TEXTCOMMENT2 : ~[\*/];
//S	: ';' | ',' | '(' | ')' | '{' | '}' | '+' | EOF | LETRA A | DIGITO D | '=' E | '&' F | '"' C | '/' B | '%' M | DEL S;
//A	: LETRA A | DIGITO Ap | '_' Ap | ;
//Ap	: LETRA Ap | DIGITO Ap | '_' Ap | ;
//D	: DIGITO D | ;
//E	: '=' | ;
//F	: '&';
//C	: TEXTSTRING C | '"';
//B	: '*' Bp;
//Bp	: TEXTCOMMENT1 Bp | '*' Bpp;
//Bpp	: '/' S | TEXTCOMMENT2 Bp | '*' Bpp;
//M	: '=';
//VAR : 'var';
//INT : 'int';
//BOOL: 'bool';
//CHAR: 'char';
//WRITE: 'write';
//PROMPT: 'prompt';
//RETURN: 'return';
//IF	: 'if';
//FOR: 'for';
//BREAK: 'break';


// ***************** Parser Rules:

p	: b z p | FUNCTION z p | z p;
z	: '\n' | '\n' z;
b	: VAR t ID | IF APARE e CPARE s | WHILE APARE e CPARE z ALLAV z c CLLAV | s;
t	: INT | BOOL | CHAR;
f	: FUNCTION h ID APARE a CPARE z ALLAV z c CLLAV;
s	: ID ASIG e | RETURN x | ID APARE l CPARE | WRITE APARE l CPARE | PROMPT APARE ID CPARE | ID ASIGMOD e | FOR APARE ID PCOMA e PCOMA e PCOMA CPARE ALLAV e CLLAV;
c 	: b z c | ;
h	: t | ;
x	: e | ;
a	: t ID k | ;
k	: COMA t ID k | ;
l	: e q | ;
q	: COMA e q | ;
e	: e LOGAND r | r;
r	: r MAYOR u | u;
u   : u ASUMA v | v;
v	: ID | APARE e CPARE | INT | CADENA | ID APARE l CPARE | MASMAS ID;