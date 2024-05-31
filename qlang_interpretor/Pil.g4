grammar Pil ;

program: statementComposition?  EOF ;     

statementComposition: statementWithBreak* (statement | statementWithBreak) ;

statementWithBreak: statement ';' ;

statement: (assignment | write | if | loop ) ;

if: 'if' expr 'then' statementComposition ('else' elseStat=statementComposition)? 'end'         #IfElse
  ; 

loop: 'loop' statementWithBreak* (loopUntil='until' expr | loopWhile='while' expr) 'do' statementComposition 'end'  #LoopFull
    | 'loop' statementComposition (loopUntil='until' expr | loopWhile='while' expr) 'do' 'end'                      #LoopSimple
    ;   

write:  'writeln' (expr ',')* expr  #WritelnExpr
      | 'write' (expr ',')* expr    #WriteExpr
      ;

assignment:  idset ':=' expr ;

expr returns [Type eType, String varName]: 
      '(' expr ')'                                                              #ExprParenthesis
    | op=('-' | '+' | 'not') expr                                               #ExprUnary
    | expr op=('*' | ':' | '%') expr                                            #ExprMultDivMod
    | expr op=('+' | '-') expr                                                  #ExprAddMinus
    | expr op=('=' | '>=' | '<=' | '>' | '<' | '/=') expr                       #ExprBinaryRelational
    | expr op=('and' | 'or' | 'xor' | 'implies' | ANDTHEN | ORELSE ) expr       #ExprBinaryLogical
    | INTEGER                                                                   #ExprInteger                                
    | FLOAT                                                                     #ExprFloat               
    | idset                                                                     #ExprId                           
    | TEXT                                                                      #ExprText   
    | BOOLEAN                                                                   #ExprBoolean                              
    | type=TYPES '(' expr ')'                                                   #ExprTypeConversion
    | 'read' expr                                                               #ExprRead                                  
    ;

idset: ID ;  

BOOLEAN: 'true' | 'false' ;
TYPES: 'integer' | 'real' | 'text' ;
ANDTHEN: 'and' 'then' ;
ORELSE: 'or' 'else' ;
TEXT : '"'.+? '"' ;
INTEGER : [0-9]+ ;
FLOAT : [0-9]+ '.' [0-9]+ ;
ID : [a-zA-Z_][a-zA-Z_0-9]* ;
COMMENT: '--' .*? '\n' -> skip ;
WS : [ \n\t]+ -> skip ; 