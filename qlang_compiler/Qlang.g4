
grammar Qlang;

statList: statementComposition EOF;

statementWithBreak: (statement ';');

statementComposition: statementWithBreak* (statement | statementWithBreak);

commandWithBreak: (command ';');

commandComposition: commandWithBreak* (command | commandWithBreak);

idset : ID | ID '.' idset;

statement: 
        newQuestion     #StatementQuestion
        | declaration   #StatementDeclaration
        | assignment    #StatemtentAssignment
        | execution     #StatementExecution
        | export        #StatementExport
        | code          #StatementCode
        | command       #StatementCommand
        ;
        
code:
        'code' idset 'is' PIL
        ;

newQuestion: 
        'multi-choice' idset 'is' commandComposition 'end' #MultiChoiceQuestion
        | 'hole' idset 'is' commandComposition 'end' #HoleQuestion
        | 'open' idset 'is' commandComposition 'end' #OpenQuestion
        | 'code-hole' idset 'is' commandComposition 'end' #ColeHoleQuestion
        | 'code-open' idset 'is' commandComposition 'end' #ColeOpenQuestion
        | 'code-output' idset 'is' commandComposition 'end' #CodeOutputQuestion
        ;

declaration:
        idset ':' 'question' #QuestionDeclaration
        | idset ':' 'fraction' #FractionDeclaration 
        | idset ':' 'integer' #IntegerDeclaration
        | idset ':' 'text' #TextDeclaration
        ;

assignment:
        idset ':=' expr #IDAssignment
        | idset ':=' 'new' ID+ #NewAssignment
        | idset '->' TEXT  #HoleQuestionAssignment
        ;

execution:
        'execute' idset
        ;

export:
        'export' idset 'to' TEXT
        ;

command :  
        'print' TEXT+ #PrintSentence
        | 'println' (TEXT | assignment)* #PrintLineSentence
        | 'uses code from ' TEXT ' end' #UsesCodeSentence
        ;

expr:
        idset
        | Integer
        | 'true'
        | 'false'
        | 'not' expr
        | expr 'and' expr
        | expr 'or' expr
        | expr '==' expr
        | expr '!=' expr
        | expr '<' expr
        | expr '<=' expr
        | expr '>' expr
        | expr '>=' expr
        | '(' expr ')'
        | 'read' TEXT
        | TYPES '(' expr ')'
        ;


ifLineSentence :
    ifBlock elseifBlock* elseBlock?
    ;

ifBlock : 
    'if' expr 'then' (statement)+
    ;

elseifBlock :
    'elseif' expr 'then' (statement)+
    ;

elseBlock: 
    'else'(statement)+
    ;
    
VERBATIMOPEN : ('"' | '\'') ('{' | '[' | '<');
VERBATIMCLOSE : ('"' | '\'') ('}' | ']' | '<');
TYPES : 'integer' | 'text' | 'fraction';
PIL : VERBATIMOPEN .*? VERBATIMCLOSE; 
TEXT : '"'.+? '"';
ID : [a-zA-Z_][a-zA-Z0-9_]* ;
Integer : [0-9]+ ;
SKIPPING : [ \n\t]+ -> skip ;
NEWLINE:'\r'? '\n' ;
BLOCKCOMMENT: '#//' .*? '//#' -> skip ;
SINGLECOMMENT: '#' .*? '\n' -> skip ;


























