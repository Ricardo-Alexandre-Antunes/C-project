grammar pil ;

program: statement* EOF ;

statement: (assignment | write | if) ';' ;

if: 'if' expr 'then' statement ('else' statement)? 'end' ;

write:  'writeln' (expr ',')* expr
      | 'write' (expr ',')* expr  
      ;

assignment:  ID ':=' expr 
           | ID ':=' read
           ;

read: 'read' expr ;

expr: '(' expr ')' 
    | '-' expr 
    | expr '*' expr
    | expr ':' expr
    | expr '%' expr
    | expr '+' expr 
    | expr '-' expr 
    | expr '=' expr  
    | expr '/=' expr 
    | expr '<' expr
    | expr '>' expr 
    | expr '<=' expr 
    | expr '>=' expr
    | expr 'and' expr 
    | expr 'and' 'then' expr
    | expr 'or' expr
    | expr 'or' 'else' expr
    | expr 'xor' expr 
    | expr 'implies' expr
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
