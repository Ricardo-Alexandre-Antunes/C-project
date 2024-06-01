   import java.util.ArrayList;
   import java.util.HashMap;
   import java.util.List;

   @SuppressWarnings("CheckReturnValue")
   public class SemanticAnalyser extends QlangBaseVisitor<Boolean> {

      // Ricardo : mudei o hashmap para podermos utilizar o type adequadamente
      private HashMap<String, Type> declaredVariables = new HashMap<String, Type>();
      // ... mas para isso também adicionei um array list para ids que são classes
      private ArrayList<String> declaredQuestionClasses = new ArrayList<String>();
      // ... ... e outra para code-classe
      private ArrayList<String> declaredCodeClasses = new ArrayList<String>();
      private final BooleanType booleanType = new BooleanType();
      private final TextType stringType = new TextType();
      private final IntegerType integerType = new IntegerType();
      private final CodeType codeType = new CodeType();
      private final FractionType fractionType = new FractionType();
      private final QuestionType questionType = new QuestionType();
      private ArrayList<String> navigatingidSet = new ArrayList<String>();

      private final RealType realType = new RealType();
      private final TextType textType = new TextType();

      private Type getTypeByExpression(String type) {
         switch (type) {
            case "integer":
               return integerType;
            case "real":
               return realType;
            case "text":
               return textType;
            case "question":
               return questionType;
            case "fraction":
               return fractionType;
            default:
               return null;
         }
      }

      @Override
      public Boolean visitStatList(QlangParser.StatListContext ctx) {
         Boolean res = null;
         return visitChildren(ctx);
         // return res;
      }

      @Override
      public Boolean visitStatementWithBreak(QlangParser.StatementWithBreakContext ctx) {
         Boolean res = null;
         return visitChildren(ctx);
         // return res;
      }

      @Override
      public Boolean visitStatementComposition(QlangParser.StatementCompositionContext ctx) {
         Boolean res = null;
         return visitChildren(ctx);
         // return res;
      }

      @Override
      public Boolean visitCommandWithBreak(QlangParser.CommandWithBreakContext ctx) {
         Boolean res = null;
         return visitChildren(ctx);
         // return res;
      }

      @Override
      public Boolean visitCommandComposition(QlangParser.CommandCompositionContext ctx) {
         Boolean res = null;
         return visitChildren(ctx);
         // return res;
      }

      @Override
      public Boolean visitIDSetTerminal(QlangParser.IDSetTerminalContext ctx) {
         Boolean res = true;
         if (navigatingidSet.contains(ctx.ID().getText())) {
            System.out.println("Error: " + ctx.ID().getText() + " is already declared in this set.");
            res = false;
         } else {
            navigatingidSet.clear();
         }
         return res;
      }

      @Override
      // Ricardo : cometi um erro crasso aqui, não é para definir question sets assim
      public Boolean visitIDSetComposition(QlangParser.IDSetCompositionContext ctx) {
         Boolean res = true;
         if (navigatingidSet.contains(ctx.ID().getText())) {
            System.out.println("Error: " + ctx.ID().getText() + " is already declared in this set.");
            res = false;
         } else {
            navigatingidSet.add(ctx.ID().getText());
            res = visit(ctx.idset());
         }
         return res;
         // return res;
      }

      // JOAO : Não falta o res no return?
      // Hugo : é capaz
      /* Ricardo : meus caros a questão / code é definida por 
                  todo o texto do idset; podemos assim, ter, 
                  por exemplo, uma pergunta chamada Bloco1.PerguntaAberta 
                  e outra chamada Bloco2.PerguntaAberta. 
                  Seriam perguntas diferentes e seria nomenclatura válida.

      Fiz alterações para refletir essa possibilidade.

      NOVO: Como fiz uma lista para classes de questões especificamente, mudei agora aqui também
      */
      @Override
      public Boolean visitNewQuestion(QlangParser.NewQuestionContext ctx) {
         Boolean res = visit(ctx.idset());
         if (res){
            String question = ctx.idset().getText();
            if (declaredVariables.containsKey(question)) {
               ErrorHandling.registerError();
               ErrorHandling.printError(ctx, "Cannot assign a Question Class to a previously declarated variable (even if question type)");
               res = false;
            }
            if (declaredQuestionClasses.contains(question)) {
                  // Ricardo : Aqui acho que faz mais sentido deixar o utilizador mudar o tipo de questão mas avisar que está a ser feito um override.
                  ErrorHandling.printWarning(ctx, "The question " + question + " had already been declared, and its definition has been overriden");
               //if (!declaredVariables.get(question).equals(ctx.QUESTIONTYPES().getText())) res = false;
            } else {
               declaredQuestionClasses.put(ctx.idset().getText());
            }
         }
         return res && visit(ctx.commandComposition());
         // return res && visitChildren(ctx); ============ AQUI =============
      }

      // inserir idset com type no hashmap
      // hugo
      /* Ricardo : Se uma variável já foi declarada, não pode ser declarada de novo (pensem no Java, por exemplo).
                  Sei que vão dizer que ai não fizeste o mesmo para as questões, pois é meus caros gg
      */
      @Override
      public Boolean visitDeclaration(QlangParser.DeclarationContext ctx) {
         Boolean res = true;
         String idset = ctx.idset().getText();
         String type = "code";
         if (ctx.VARIABLETYPES() != null) type = ctx.VARIABLETYPES().getText();
         
         // Ricardo : declarar uma variavel com . não faz sentido. É uma classe que deve ser inicializada de outra forma
         if (idset.contains(".")) {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, "Error: " + idset + " cannot be declared with a dot (reserved for question class definitions)");
            res = false;
         } else {
            // Verificar se a variável já foi declarada
            if (declaredVariables.containsKey(idset)) {
                  // Utilizar a classe ErrorHandling para imprimir erros
                  ErrorHandling.registerError();
                  ErrorHandling.printError(ctx, "Error: " + idset + " was already declared previously.");
                  res = false;
            } else {
                  // Verificar se o tipo é válido
                  Type variableType = getTypeByExpression(type);
                  if (variableType == null) {
                     ErrorHandling.registerError();
                     ErrorHandling.printError(ctx, "Error: " + type + " is not a valid type.");
                     res = false;
                  } else {
                     // Adicionar a variável ao mapa de variáveis declaradas
                     declaredVariables.put(idset, variableType);
                  }
            }
         }

         return res;
      }

      // verificar se idset foi declarado do tipo code
      // Ricardo : se não foi declarado ainda deixar passar...
      /* UPDATE Ricardo : com a separção adequada entre classes e variáveis, 
                        apenas temos que ver se esta variável está incluida na 
                        lista de questões-classe para imprimir erro, ou na lista 
                        de código-classe para imprimir aviso
      */
      //hugo
      
      
      @Override
      public Boolean visitCode(QlangParser.CodeContext ctx) {
         Boolean res = true;
         String idset = ctx.idset().getText();

         // Verificar se o idset está na lista de questões-classe
         if (declaredQuestionClasses.contains(idset)) {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, idset + " was already declared - and it's not a class of type Code.");
            res = false;
            return res;
         }

         // Verificar se o idset está na lista de código-classe
         if (declaredCodeClasses.contains(idset)) {
            ErrorHandling.printWarning(ctx, idset + " was already declared, but its previous definition is being overridden.");
         } else {
            // Adicionar idset à lista de código-classe
            declaredCodeClasses.add(idset);
         }

         return res;
      }


      // se o idset tiver . entao o expr tem que ser uma question / code senao tem que ter o
      // mesmo tipo que expr
      // Ricardo : ok sou burro. já tinha que ser declarado.
      // hugo
      @Override
      public Boolean visitIDAssignment(QlangParser.IDAssignmentContext ctx) {
         Boolean res = true;
         String idset = ctx.idset().getText();
         // isto pode estar mal
         Type exprType = ctx.expr().eType;

         // Visitar a expressão para **ver se é válida**
         res = visit(ctx.expr());
         // Se não for válida, não vale a pena continuar.
         if (!res) return false;
         /*
         if (idset.contains(".")) {
            // If idset contains a dot, expr must be of type 'question'
            if (!"question".equals(exprType.name()) && !"code".equals(exprType.name())) {
               ErrorHandling.registerError();
               ErrorHandling.printError(ctx, "Assignment mismatch: " + exprType.name());
               res = false;
            }
         } else */ {
            // Check if idset has been declared
            if (!declaredVariables.containsKey(idset)) {
               ErrorHandling.registerError();
               ErrorHandling.printError(ctx, idset + " has not been declared prior to assignment.");
               res = false;
            } else {
               // Check if the type of idset matches the type of the expression
               Type idsetType = declaredVariables.get(idset);
               if (!idsetType.equals(exprType.name())) {
                  if (idsetType.conformsTo(exprType)){
                     ErrorHandling.printWarning(ctx, "Assignment mismatch - Expected " + idsetType + " but found " + exprType.name() + ". However, assignment was still possible.");
                  } else {
                     ErrorHandling.registerError();
                     ErrorHandling.printError(ctx, "Assignment Mismatch - Expected " + idsetType + " but found " + exprType.name());
                     res = false;
                  }
               }
            }
         }

         return res && visitChildren(ctx);
         // return res;
      }

      // verificar se primeiro idset e do tipo question e se o segundo idset e do tipo
      // question class ou seja multi choice, hole, open, code hole, code open,
      // code-output ou composed
      /* Ricardo : com os novos array lists, é mais fácil fazer esta verificação
                  agora basta ver se o segundo idset está na lista de classes de questões
                  ou na lista de classes de code
                  e depois ver se o primeiro idset é uma questão ou code accordingly
      */
      // hugo
      @Override
      public Boolean visitNewAssignment(QlangParser.NewAssignmentContext ctx) {
         Boolean res = true;
         String firstIdset = ctx.idset(0).getText();
         String secondIdset = ctx.idset(1).getText();

         
         // Verificar se o primeiro idset foi declarado e é do tipo 'question'
         if (!declaredVariables.containsKey(firstIdset)) {
            ErrorHandling.printError(ctx, "Error: " + firstIdset + " has not been declared.");
            return false;
         } /* else if (!"question".equals(declaredVariables.get(firstIdset))) {
            System.out.println("Error: " + firstIdset + " is not of type 'question'.");
            res = false;
         }

         

         // Verificar se o segundo idset é um dos tipos permitidos
         if (res) {
            String secondIdsetType = declaredVariables.get(secondIdset);
            if (secondIdsetType == null || 
                  !(secondIdsetType.equals("multi-choice") || 
                  secondIdsetType.equals("hole") || 
                  secondIdsetType.equals("open") || 
                  secondIdsetType.equals("code-hole") || 
                  secondIdsetType.equals("code-open") || 
                  secondIdsetType.equals("code-output") || 
                  secondIdsetType.equals("composed"))) {
                  System.out.println("Error: " + secondIdset + " must be of type 'multi-choice', 'hole', 'open', 'code-hole', 'code-open', 'code-output' or 'composed'. Found: " + secondIdsetType);
                  res = false;
            }
         }
         */

         if (declaredQuestionClasses.contains(secondIdset)) {
            if (!"question".equals(declaredVariables.get(firstIdset).name())) {
               ErrorHandling.registerError();
               ErrorHandling.printError(ctx, "Error: " + firstIdset + " is not a question.");
               return false;
            }
         } else if (declaredCodeClasses.contains(secondIdset)) {
            if (!"code".equals(declaredVariables.get(firstIdset).name())) {
               ErrorHandling.registerError();
               ErrorHandling.printError(ctx, "Error: " + firstIdset + " is not a code.");
               return false;
            }
         } else {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, "Error: " + secondIdset + " is not a valid question or code class.");
            return false;
         }

         return res;
      }


      // verificar se idset é terminal (não pode ter pontos)

      // Hugo
      @Override
      public Boolean visitHoleQuestionAssignment(QlangParser.HoleQuestionAssignmentContext ctx) {
         Boolean res = true;
         String idset = ctx.idset().getText();
         Type exprType = ctx.expr().eType;

         // Visit the expression to determine its type
         res = visit(ctx.expr());
         if (!res) return false;

         // Verificar se idset é terminal (não pode ter pontos)
         if (idset.contains(".")) {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, "The local variable " + idset + " must not be a question-class or code-class.");
            res = false;
         }

         // Verificar se expr é do tipo 'code-hole' | Ricardo : NÃO!!!!!!
         /*
         if (!"code-hole".equals(exprType.name())) {
            System.out.println("Error: The expression assigned to " + idset + " must be of type 'code-hole'. Found: "
                     + exprType.name());
            res = false;
         }
         */

         return res;
      }

      // verificar se idset é do tipo question ou code

      // JOAO
      // hugo, nao era preciso aquilo
      // Ricardo : alterei ligeiramente a gramática para sabermos se o 'new' está no execute
      //          Se estiver, quer dizer que tem que ser uma classe. 
      //          Se não estiver, tem que ser uma variável do tipo question ou code
      @Override
      public Boolean visitExecution(QlangParser.ExecutionContext ctx) {
         Boolean res = true;
         String idset = ctx.idset().getText();

         if (ctx.init != null && (!declaredQuestionClasses.contains(idset) && !declaredCodeClasses.contains(idset))){
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, idset + " is not a valid question or code class.");
            return false;  
         }
         if (!declaredVariables.containsKey(idset)) {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, idset + " has not been declared.");
            res = false;
         } else {
            Type idsetType = declaredVariables.get(idset);
            if (!"question".equals(idsetType.name()) && !"code".equals(idsetType.name())) {
               ErrorHandling.printError(ctx, "Error: " + idset + " must be of type 'question' or 'code'.");
               res = false;
            }
         }

         return res;
      }

      // verificar se expr é do tipo text

      // JOAO : Aqui tb n se devia verficiar se o idset é do tipo Result? (que é o
      // único que faz export)
      // Hugo eu acho que sim
      @Override
      public Boolean visitExport(QlangParser.ExportContext ctx) {
         Boolean res = true;
         String idset = ctx.idset().getText();

         if (!declaredVariables.containsKey(idset)) {
            ErrorHandling.printError(ctx, "Error: " + idset + " has not been declared.");
            res = false;
         }

         res = res && visit(ctx.expr());
         Type exprType = ctx.expr().eType;

         if (!"text".equals(exprType.name())) {
            ErrorHandling.printError(ctx, "Error: The expression must be of type 'text'. Found: " + exprType.name());
            res = false;
         }

         return res;
      }

      @Override
      public Boolean visitPrintSentence(QlangParser.PrintSentenceContext ctx) {
         Boolean res = null;
         return visitChildren(ctx);
         // return res;
      }

      @Override
      public Boolean visitPrintLineSentence(QlangParser.PrintLineSentenceContext ctx) {
         Boolean res = null;
         return visitChildren(ctx);
         // return res;
      }

      @Override
      public Boolean visitUsesCodeSentence(QlangParser.UsesCodeSentenceContext ctx) {
         Boolean res = null;
         return visitChildren(ctx);
         // return res;
      }

      // verificar se idset é do tipo code ou do tipo text

      // JOAO
      @Override
      public Boolean visitUsesCodeDefined(QlangParser.UsesCodeDefinedContext ctx) {
         Boolean res = true;
         String idset = ctx.idset().getText();

         if (!declaredVariables.containsKey(idset)) {
            ErrorHandling.printError(ctx, "Erystem.out.pror: " + idset + " has not been declared.");
            res = false;
         } else {
            String idsetType = declaredVariables.get(idset);
            if (!"code".equals(idsetType) && !"text".equals(idsetType)) {
               ErrorHandling.printError(ctx, "Error: " + idset + " must be of type 'code' or 'text'. Found: " + idsetType);
               res = false;
            }
         }

         if (res) {
            res = visitChildren(ctx);
         }

         return res;
         // return res;
      }

      // nao apagar
      @Override
      public Boolean visitChoiceCommand(QlangParser.ChoiceCommandContext ctx) {
         Boolean res = null;
         return visitChildren(ctx);
         // return res;
      }

      @Override
      public Boolean visitExecutionCommand(QlangParser.ExecutionCommandContext ctx) {
         Boolean res = null;
         return visitChildren(ctx);
         // return res;
      }

      // comeca aqui -> Hugo
      @Override
      public Boolean visitIfLineSentenceCommand(QlangParser.IfLineSentenceCommandContext ctx) {
         Boolean res = null;
         return visitChildren(ctx);
         // return res;
      }

      @Override
      public Boolean visitAssignmentCommand(QlangParser.AssignmentCommandContext ctx) {
         Boolean res = null;
         return visitChildren(ctx);
         // return res;
      }

      @Override
      public Boolean visitDeclarationCommand(QlangParser.DeclarationCommandContext ctx) {
         Boolean res = null;
         return visitChildren(ctx);
         // return res;
      }

      @Override
      public Boolean visitCodeholeComposition(QlangParser.CodeholeCompositionContext ctx) {
         Boolean res = null;
         return visitChildren(ctx);
         // return res;
      }

      @Override
      public Boolean visitCodeholeWithBreak(QlangParser.CodeholeWithBreakContext ctx) {
         Boolean res = null;
         return visitChildren(ctx);
         // return res;
      }

      @Override
      public Boolean visitCodehole(QlangParser.CodeholeContext ctx) {
         Boolean res = null;
         return visitChildren(ctx);
         // return res;
      }

      // segundo integer não pode ser 0 e ver se é fracao ou integer

      // JOAO
      // Hugo para de por VisitChildren em tudo ze
      @Override
      public Boolean visitValueExpr(QlangParser.ValueExprContext ctx) {
         Boolean res = true;

         // Get the integer parts of the value expression
         List<TerminalNode> integers = ctx.Integer();

         if (integers.size() == 1) {
            // Single integer, so it is an integer type
            ctx.eType = integerType;
         } else if (integers.size() == 2) {
            // Fraction case
            int numerator = Integer.parseInt(integers.get(0).getText());
            int denominator = Integer.parseInt(integers.get(1).getText());

            if (denominator == 0) {
               ErrorHandling.printError(ctx, "Error: Denominator cannot be zero.");
               res = false;
            } else {
               ctx.eType = fractionType;
            }
         } else {
            res = false; // This case should not occur if the grammar is correct
         }

         return res;
      }

      @Override
      public Boolean visitIDExpr(QlangParser.IDExprContext ctx) {
         Boolean res = null;
         return visitChildren(ctx);
         // return res;
      }

      // ??????????
      @Override
      public Boolean visitParenthesisExpr(QlangParser.ParenthesisExprContext ctx) {
         Boolean res = visit(ctx.expr());
         if (res) {
            ctx.eType = ctx.expr().eType;
         }
         return res;
      }

      @Override
      public Boolean visitTextExpr(QlangParser.TextExprContext ctx) {
         Boolean res = null;
         ctx.eType = stringType;
         return visitChildren(ctx);
         // return res;
      }

      @Override
      public Boolean visitExecutionExpr(QlangParser.ExecutionExprContext ctx) {
         Boolean res = null;
         ctx.eType = fractionType;
         return visitChildren(ctx);
         // return res;
      }

      @Override
      public Boolean visitExprBinaryLogical(QlangParser.ExprBinaryLogicalContext ctx) {
         Boolean res = visit(ctx.expr(0)) && visit(ctx.expr(1));
         if (res) {
            if (!"boolean".equals(ctx.expr(0).eType.name()) || !"boolean".equals(ctx.expr(1).eType.name())) {
               ErrorHandling.printError(ctx, "Logical operator applied to non-boolean operands!");
               res = false;
            } else {
               ctx.eType = booleanType;
            }
         }
         return res;
      }

      @Override
      public Boolean visitStdoutExpr(QlangParser.StdoutExprContext ctx) {
         Boolean res = null;
         ctx.eType = stringType;
         return visitChildren(ctx);
         // return res;
      }

      @Override
      public Boolean visitTypeExpr(QlangParser.TypeExprContext ctx) {
         Boolean res = true;
      
         // Obter o tipo especificado em VARIABLETYPES
         String variableType = ctx.VARIABLETYPES().getText();
      
         // Verificar o tipo e definir ctx.eType de acordo
         switch (variableType) {
            case "integer":
                  ctx.eType = integerType;
                  break;
            case "real":
                  ctx.eType = realType;
                  break;
            case "text":
                  ctx.eType = textType;
                  break;
            case "question":
                  ctx.eType = questionType;
                  break;
            case "fraction":
                  ctx.eType = fractionType;
                  break;
            default:
                  System.out.println("Error: Unknown type " + variableType);
                  res = false;
                  break;
         }
      
         return res && visitChildren(ctx);
      }
      

      @Override
      public Boolean visitUnaryExpr(QlangParser.UnaryExprContext ctx) {
         Boolean res = visit(ctx.expr()) && checkNumericType(ctx, ctx.expr().eType);
         if (res) {
            ctx.eType = ctx.expr().eType;
         }
         return res;
      }

      //hugo
      @Override
      public Boolean visitExprMultDivMod(QlangParser.ExprMultDivModContext ctx) {
         Boolean res = visit(ctx.expr(0)) && visit(ctx.expr(1)) && checkNumericType(ctx, ctx.expr(0).eType)
               && checkNumericType(ctx, ctx.expr(1).eType);
         if (res) {
            ctx.eType = fetchType(ctx.expr(0).eType, ctx.expr(1).eType);
         }
         return res;
         // return res;
      }

      //hugo
      @Override
      public Boolean visitReadExpr(QlangParser.ReadExprContext ctx) {
         Boolean res = null;
         ctx.eType = stringType;
         return visitChildren(ctx);
         // return res;
      }

      //hugo
      @Override
      public Boolean visitExprAddMinus(QlangParser.ExprAddMinusContext ctx) {
         Boolean res = visit(ctx.expr(0)) && visit(ctx.expr(1)) && checkNumericType(ctx, ctx.expr(0).eType)
               && checkNumericType(ctx, ctx.expr(1).eType);
         if (res) {
            ctx.eType = fetchType(ctx.expr(0).eType, ctx.expr(1).eType);
         }
         return res;
      }

      // verificar se valores numericos

      // JOAO
      // Hugo, acho que aqui tinhas de usar a funcao do Type, alterei.
      @Override
      public Boolean visitExprBinaryRelational(QlangParser.ExprBinaryRelationalContext ctx) {
         Boolean res = true;
      
         // Visit the left and right expressions
         res = visit(ctx.expr(0)) && visit(ctx.expr(1));
      
         if (res) {
            // Get the types of the left and right expressions
            Type leftType = ctx.expr(0).eType;
            Type rightType = ctx.expr(1).eType;
      
            // Check if both types are numeric
            if (!leftType.isNumeric() || !rightType.isNumeric()) {
                  ErrorHandling.printError(ctx, "Error: Both operands of a binary relational expression must be numeric. Found: "
                        + leftType.name() + " and " + rightType.name());
                  res = false;
            } else {
                  // Set the type of the relational expression to boolean
                  ctx.eType = booleanType;
            }
         }
      
         return res;
      }
      

      @Override
      public Boolean visitIfLineSentence(QlangParser.IfLineSentenceContext ctx) {
         Boolean res = null;
         return visitChildren(ctx);
         // return res;
      }


      //Hugo
      @Override
      public Boolean visitIfBlock(QlangParser.IfBlockContext ctx) {
         Boolean res = true;
         // Check if the expression inside the if condition is boolean
         Type exprType = getTypeByExpression(ctx.expr());
         if (!(exprType instanceof BooleanType)) {
            ErrorHandling.printError(ctx, "Error: The condition in the if statement must be of type boolean.");
            res = false;
         }
         // Visit all the statements inside the if block
         for (QlangParser.StatementContext stmtCtx : ctx.statement()) {
            if (!visit(stmtCtx)) {
               res = false;
               break;
            }
         }
         return res;
      }
      //Hugo
      @Override
      public Boolean visitElseifBlock(QlangParser.ElseifBlockContext ctx) {
         Boolean res = true;
         // Check if the expression inside the elseif condition is boolean
         Type exprType = ctx.expr().eType;
         // nao sei se isto esta bem
         if (!(exprType.conformsTo(new BooleanType()))) {
            ErrorHandling.printError(ctx, "Error: The condition in the elseif statement must be of type boolean.");
            res = false;
         }
         // Visit all the statements inside the elseif block
         for (QlangParser.StatementContext stmtCtx : ctx.statement()) {
            if (!visit(stmtCtx)) {
               res = false;
               break;
            }
         }
         return res;
      }

      @Override
      public Boolean visitElseBlock(QlangParser.ElseBlockContext ctx) {
         Boolean res = null;
         return visitChildren(ctx);
         // return res;
      }

      private Boolean checkNumericType(ParserRuleContext ctx, Type t) {
         Boolean res = true;
         if (!t.isNumeric()) {
            ErrorHandling.printError(ctx, "Numeric operator applied to a non-numeric operand!");
            res = false;
         }
         return res;
      }

      private Type fetchType(Type t1, Type t2) {
         Type res = null;
         if (t1.isNumeric() && t2.isNumeric()) {
            if ("real".equals(t1.name()))
               res = t1;
            else if ("real".equals(t2.name()))
               res = t2;
            else
               res = t1;
         } else if ("boolean".equals(t1.name()) && "boolean".equals(t2.name()))
            res = t1;
         return res;
      }
   }
