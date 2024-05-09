grammar pil ;

program: statement* EOF ;

statement: (assignment | write) ';' ;

write:  'writeln' ((expr)+ ',' expr)*  
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
        | expr 'and' 'then' expr
        | expr 'or' 'else' expr
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

TEXT : '"'.+? '"' ;
INTEGER : [0-9]+ ;
FLOAT : [0-9]+ '.' [0-9]+ ;
ID : [a-zA-Z_][a-zA-Z_0-9]* ;
COMMENT: '--' .*? '\n' -> skip ;
WS : [ \n\t]+ -> skip ;
