
grammar Qlang;

statList: statementComposition EOF;

statementWithBreak: (statement ';');

statementComposition: statementWithBreak* (statement | statementWithBreak);

commandWithBreak: (command ';');

commandComposition: commandWithBreak* (command | commandWithBreak);

idset : ID | ID '.' idset;

statement: 
        newQuestion             #StatementQuestion
        | declaration           #StatementDeclaration
        | assignment            #StatemtentAssignment
        | execution             #StatementExecution
        | export                #StatementExport
        | code                  #StatementCode
        | command               #StatementCommand
        | ifLineSentence        #StatementIfLineSentence
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
        idset ':=' expr #IDAssignment
        | idset ':=' 'new' idset #NewAssignment
        | idset '->' expr  #HoleQuestionAssignment
        ;

execution:
        'execute' (expr',')? ('new')? idset
        ;


export:
        'export' idset 'to' expr
        ;

command :  
        'print' (assignment | expr)* #PrintSentence
        | 'println' ((assignment | expr) ('|program')?)* #PrintLineSentence
        | 'uses code from' TEXT codeholeComposition? 'end' #UsesCodeSentence
        | 'uses code' idset codeholeComposition? 'end' #UsesCodeDefined
        | 'choice' (expr',')? TEXT 'end' #ChoiceCommand
        | execution #ExecutionCommand
        | ifLineSentence #IfLineSentenceCommand
        | assignment #AssignmentCommand
        | declaration #DeclarationCommand
        ;

codeholeComposition: codeholeWithBreak* (codehole | codeholeWithBreak);

codeholeWithBreak: (codehole ';');

codehole: (Integer ',')? (Integer ',')? (TEXT | idset) ('line' Integer)?;

expr:
        idset                                                   #IDExpr
        | Integer(('/'Integer)?)                                #ValueExpr
        | 'not' expr                                            #NotExpr                            
        | expr '&&' expr                                        #AndExpr
        | expr '|' expr                                         #OrExpr
        | expr '=' expr                                         #EqualExpr
        | expr '!=' expr                                        #NotEqualExpr
        | expr '<' expr                                         #LessExpr
        | expr '<=' expr                                        #LessEqualExpr
        | expr '>' expr                                         #GreaterExpr
        | expr '>=' expr                                        #GreaterEqualExpr
        | expr '+' expr                                         #PlusExpr
        | expr '-' expr                                         #MinusExpr
        | expr '*' expr                                         #MultExpr
        | expr '/' expr                                         #DivExpr
        | '(' expr ')'                                          #ParenthesisExpr  
        | 'read' TEXT                                           #ReadExpr  
        | TEXT                                                  #TextExpr                         
        | type=('integer' | 'text' | 'fraction')'(' expr ')'    #TypeExpr
        | execution                                             #ExecutionExpr
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