grammar pil ;

program: statement* EOF ;

statement: assignment | write ;

write:  'writeln' ((expr)+ ',' expr)* NEWLINE 
      | 'write' ((expr)+ ',' expr)*  
      ;

assignment:  ID ':=' expr 
           | ID ':=' boolean 
           | ID ':=' read
           ;

read: 'read' expr ;

boolean:  expr '=' expr 
        | expr '/=' expr 
        | expr '<' expr
        | expr '>' expr 
        | expr '<=' expr 
        | expr '>=' expr 
        | expr 'and' expr 
        | expr 'or' expr
        | expr 'xor' expr 
        | expr 'and then' expr
        | expr 'or else' expr
        | expr 'implies' expr
       ;

expr: '(' expr ')' 
    | '-' expr 
    | expr '+' expr 
    | expr '-' expr 
    | expr '*' expr 
    | expr ':' expr 
    | expr '%' expr 
    | INTEGER 
    | FLOAT 
    | ID
    | TEXT
    ;

TEXT : '"'[a-zA-Z_0-9]+ '"' ;
INTEGER : [0-9]+ ;
FLOAT : [0-9]+ '.' [0-9]+ ;
ID : [a-zA-Z_][a-zA-Z_0-9]* ;
//WS : [ \t]+ -> skip ;
NEWLINE:'\r'? '\n' ;
COMMENT: '--' .*? '\n' -> skip ;