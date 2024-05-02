grammar Qlang;

statList: (statement? ';' (NEWLINE)*)* EOF;

statement: 
        newQuestion
        | declaration
        | assignment
        | execution
        | export
        | code
        ;
        
code:
        'code ' ID ' is' (' ')* NEWLINE? '"[' codeBlock ']"'
        ;

codeBlock:
        'ola'
        | 'hey'
        ;



newQuestion: 
        'multi-choice ' ID ' is' ('\n' expr ';')+ 'end' #MultiChoiceQuestion
        | 'hole ' ID ' is' ('\n' expr ';')+ 'end' #HoleQuestion
        | 'open ' ID ' is' ('\n' expr ';')+ 'end' #OpenQuestion
        | 'cole-hole ' ID ' is' ('\n' expr ';')+ 'end' #ColeHoleQuestion
        | 'cole-open ' ID ' is' ('\n' expr ';')+ 'end' #ColeOpenQuestion
        | 'code-output ' ID ' is' ('\n' expr ';')+ 'end' #CodeOutputQuestion
        ;

declaration:
        ID ': ' 'question' #QuestionDeclaration
        | ID ': ' 'fraction' #FractionDeclaration 
        | ID ': ' 'integer' #IntegerDeclaration
        | ID ': ' 'text' #TextDeclaration
        ;

assignment:
        ID ' := ' ID #IDAssignment
        | ID ' := ' 'new' ID #NewAssignment
        ;

execution:
        'execute' ID
        ;

export:
        'export ' ID ' to ' '"' ID '"'
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
    'if ' expr ' then' ('\n' statement)+
    ;

elseifBlock :
    'elseif ' expr ' then' ('\n' statement)+
    ;

elseBlock: 
    'else ' ('\n' statement)+
    ;

ID : [a-zA-Z_]+ ;
Integer : [0-9]+ ;
Minus : '-' ;
SKIPPING : [\t]+ -> skip ;
NEWLINE:'\r'? '\n' ;
COMMENT: '#' .*? '\n' -> skip ;

























