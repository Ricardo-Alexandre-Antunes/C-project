grammar Qlang;

statList: (statement? ';')* EOF;

statement: 
        newQuestion     #StatementQuestion
        | declaration   #StatementDeclaration
        | assignment    #StatemtentAssignment
        | execution     #StatementExecution
        | export        #StatementExport
        | code          #StatementCode
        ;
        
code:
        'code' ID 'is' '"[' codeBlock ']"'
        ;

codeBlock:
        STRING+
        ;



newQuestion: 
        'multi-choice' ID 'is' ( expr ';')+ 'end' #MultiChoiceQuestion
        | 'hole' ID 'is' (expr ';')+ 'end' #HoleQuestion
        | 'open' ID 'is' (expr ';')+ 'end' #OpenQuestion
        | 'cole-hole' ID 'is' (expr ';')+ 'end' #ColeHoleQuestion
        | 'cole-open' ID 'is' (expr ';')+ 'end' #ColeOpenQuestion
        | 'code-output' ID 'is' (expr ';')+ 'end' #CodeOutputQuestion
        ;

declaration:
        ID ':' 'question' #QuestionDeclaration
        | ID ':' 'fraction' #FractionDeclaration 
        | ID ':' 'integer' #IntegerDeclaration
        | ID ':' 'text' #TextDeclaration
        ;

assignment:
        ID ':=' ID #IDAssignment
        | ID ':=' 'new' ID #NewAssignment
        ;

execution:
        'execute' ID
        ;

export:
        'export' ID 'to' '"' ID '"'
        ;

expr :  
        'print' '"' ID '"' #PrintSentence
        | 'println' '"' ID '"' #PrintLineSentence
        | 'uses code from ' '"' ID '" end' #UsesCodeSentence
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

STRING : [ a-zA-Z_1-9]+;
VERBATIMOPEN : ('"' | '\'') ('{' | '[' | '<');
VERBATIMCLOSE : ('"' | '\'') ('}' | ']' | '<');
PIL : VERBATIMOPEN .*? VERBATIMCLOSE; 
ID : [a-zA-Z_]+ ;
Integer : [0-9]+ ;
Minus : '-' ;
SKIPPING : [ \n\t]+ -> skip ;
NEWLINE:'\r'? '\n' ;
BLOCKCOMMENT: '#//' .*? '//#' -> skip ;
SINGLECOMMENT: '#' .*? '\n' -> skip ;


























