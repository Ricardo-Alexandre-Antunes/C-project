grammar pil ;

program: (statement ';')* EOF ;

statement: (assignment | write | if | loop) ;

if: 'if' expr 'then' statement ('else' statement)? 'end' ;

loop: 'loop' ('until' expr | 'while' expr) 'do' statement 'end' ;

write:  'writeln' (expr ',')* expr
      | 'write' (expr ',')* expr  
      ;

assignment:  ID ':=' expr 
           | ID ':=' read
           | ID ':=' conversion
           ;

read: 'read' expr ;

conversion: 'integer' '(' (expr | read) ')'
          | 'real' '(' (expr | read) ')'
          | 'text' '(' (expr | read) ')'
          ;

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
    | 'not' expr
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