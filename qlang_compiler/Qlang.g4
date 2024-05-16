
grammar Qlang;

statList: statementComposition EOF;

statementWithBreak: (statement ';');

statementComposition: statementWithBreak* (statement | statementWithBreak);

commandWithBreak: (command ';');

commandComposition: commandWithBreak* (command | commandWithBreak);

statement: 
        newQuestion     #StatementQuestion
        | declaration   #StatementDeclaration
        | assignment    #StatemtentAssignment
        | execution     #StatementExecution
        | export        #StatementExport
        | code          #StatementCode
        ;
        
code:
        'code' ID 'is' PIL
        ;

newQuestion: 
        'multi-choice' ID+ 'is' commandComposition 'end' #MultiChoiceQuestion
        | 'hole' ID+ 'is' commandComposition 'end' #HoleQuestion
        | 'open' ID+ 'is' commandComposition 'end' #OpenQuestion
        | 'cole-hole' ID+ 'is' commandComposition 'end' #ColeHoleQuestion
        | 'cole-open' ID+ 'is' commandComposition 'end' #ColeOpenQuestion
        | 'code-output' ID+ 'is' commandComposition 'end' #CodeOutputQuestion
        ;

declaration:
        ID ':' 'question' #QuestionDeclaration
        | ID ':' 'fraction' #FractionDeclaration 
        | ID ':' 'integer' #IntegerDeclaration
        | ID ':' 'text' #TextDeclaration
        ;

assignment:
        ID ':=' execution #IDAssignment
        | ID ':=' 'new' ID+ #NewAssignment
        | ID '->' TEXT  #HoleQuestionAssignment
        ;

execution:
        'execute' ID+
        ;

export:
        'export' ID 'to' TEXT
        ;

command :  
        'print' TEXT+ #PrintSentence
        | 'println' (TEXT | assignment)* #PrintLineSentence
        | 'uses code from ' TEXT ' end' #UsesCodeSentence
        ;

expr:
        ID
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
PIL : VERBATIMOPEN .*? VERBATIMCLOSE; 
TEXT : '"'.+? '"';
ID : [a-zA-Z_][a-zA-Z0-9_]* ;
Integer : [0-9]+ ;
SKIPPING : [ \n\t]+ -> skip ;
NEWLINE:'\r'? '\n' ;
BLOCKCOMMENT: '#//' .*? '//#' -> skip ;
SINGLECOMMENT: '#' .*? '\n' -> skip ;


























