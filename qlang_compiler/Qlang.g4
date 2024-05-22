
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
        | ifLineSentence #StatementIfLineSentence
        ;
        
code:
        'code' idset 'is' (PIL assignment?)+ 'end'
        ;

newQuestion: 
        'multi-choice' idset 'is' commandComposition 'end' #MultiChoiceQuestion
        | 'hole' idset 'is' commandComposition 'end' #HoleQuestion
        | 'open' idset 'is' commandComposition 'end' #OpenQuestion
        | 'code-hole' idset 'is' commandComposition 'end' #ColeHoleQuestion
        | 'code-open' idset 'is' commandComposition 'end' #ColeOpenQuestion
        | 'code-output' idset 'is' commandComposition 'end' #CodeOutputQuestion
        | 'composed' idset 'is' commandComposition 'end' #ComposedQuestion
        ;

declaration:
        idset ':' 'question' #QuestionDeclaration
        | idset ':' 'fraction' #FractionDeclaration 
        | idset ':' 'integer' #IntegerDeclaration
        | idset ':' 'text' #TextDeclaration
        | idset ':' 'code' #CodeDeclaration
        ;

assignment:
        idset ':=' (expr | execution | TEXT)* #IDAssignment
        | idset ':=' 'new' idset #NewAssignment
        | idset '->' TEXT  #HoleQuestionAssignment
        ;

execution:
        'execute' (Integer('/'Integer)?',')? ('new')? idset
        ;


export:
        'export' idset 'to' TEXT
        ;

command :  
        'print' (assignment | expr)* #PrintSentence
        | 'println' ((assignment | expr) ('|program')?)* #PrintLineSentence
        | 'uses code from' TEXT codeholeComposition? 'end' #UsesCodeSentence
        | 'uses code' idset codeholeComposition? 'end' #UsesCodeDefined
        | 'choice' (Integer'/'Integer',')? TEXT 'end' #ChoiceCommand
        | execution #ExecutionCommand
        | ifLineSentence #IfLineSentenceCommand
        | assignment #AssignmentCommand
        | declaration #DeclarationCommand
        ;

codeholeComposition: codeholeWithBreak* (codehole | codeholeWithBreak);

codeholeWithBreak: (codehole ';');

codehole: (Integer ',')? (Integer ',')? (TEXT | idset) ('line' Integer)?;

expr:
        idset
        | Integer
        | 'true'
        | 'false'
        | 'not' expr
        | expr and=('and' | '&&') (expr | execution)
        | expr or=('or' | '|') (expr | execution)
        | expr '=' expr
        | expr '!=' expr
        | expr '<' expr
        | expr '<=' expr
        | expr '>' expr
        | expr '>=' expr
        | '(' expr ')'
        | 'read' TEXT
        | TEXT
        | type=('integer' | 'text' | 'fraction')'(' expr ')'
        ;


ifLineSentence :
    ifBlock elseifBlock* elseBlock? 'end'
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
    

 
OPEN_BRACKETS: '{' | '[' | '(' | '<' ;
CLOSE_BRACKETS: '}' | ']' | ')' | '>' ;
VERBATIMOPEN : OPEN_BRACKETS;
VERBATIMCLOSE : CLOSE_BRACKETS;
PIL : '"' VERBATIMOPEN .*? VERBATIMCLOSE '"' | '\'' VERBATIMOPEN .*? VERBATIMCLOSE '\'';
TEXT : '"' .*?  '"' | '\'' .*? '\'';
ID : [a-zA-Z_][a-zA-Z0-9_]* ;
Integer : [0-9]+ ;
SKIPPING : [ \n\t]+ -> skip ;
NEWLINE:'\r'? '\n' ;
BLOCKCOMMENT: '#//' .*? '//#' -> skip ;
SINGLECOMMENT: '#' .*? '\n' -> skip ;