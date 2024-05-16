grammar pil ;

program: statementComposition  EOF ;

statementComposition: statementWithBreak* (statement | statementWithBreak) ;

statementWithBreak: (statement ';') ;

statement: (assignment | write | if | loop ) ;

if: 'if' expr 'then' statementComposition ('else' statementComposition)? 'end' ; 

loop: 'loop' statementWithBreak* ('until' expr | 'while' expr) 'do' statementComposition 'end' 
    | 'loop' statementComposition ('until' expr | 'while' expr) 'do' 'end'
    ;

write:  'writeln' (expr ',')* expr
      | 'write' (expr ',')* expr 
      ;

assignment:  ID ':=' expr ;

expr: '(' expr ')' 
    | op=('-' | '+' | 'not') expr 
    | expr op=('+' | '-') expr
    | expr op=('*' | ':' | '%') expr
    | expr op=('=' | '>=' | '<=' | '>' | '<' | '/=') expr  
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
    | TYPES '(' expr ')'
    | 'read' expr
    ;

TYPES: ('integer' | 'real' | 'text') ;
TEXT : '"'.+? '"' ;
INTEGER : [0-9]+ ;
FLOAT : [0-9]+ '.' [0-9]+ ;
ID : [a-zA-Z_][a-zA-Z_0-9]* ;
COMMENT: '--' .*? '\n' -> skip ;
WS : [ \n\t]+ -> skip ; 