import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("CheckReturnValue")
public class SemanticAnalyser extends QlangBaseVisitor<Boolean> {

   private HashMap<String, String> declaredVariables = new HashMap<String, String>();
   private final BooleanType booleanType = new BooleanType();
   private final TextType stringType = new TextType();
   private final IntegerType integerType = new IntegerType();
   private final CodeType codeType = new CodeType();
   private final FractionType fractionType = new FractionType();
   private final QuestionType questionType = new QuestionType();
   private ArrayList<String> navigatingidSet = new ArrayList<String>();

   private final RealType realType = new RealType();
   private final TextType textType = new TextType();

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
   */
   @Override
   public Boolean visitNewQuestion(QlangParser.NewQuestionContext ctx) {
      Boolean res = visit(ctx.idset());
      if (res){
         String question = ctx.idset().getText();
         if (declaredVariables.containsKey(question)) {
            if (declaredVariables.get(question).equals("question")){
               // Ricardo : Aqui acho que faz mais sentido deixar o utilizador mudar o tipo de questão mas avisar que está a ser feito um override.
               ErrorHandling.printWarning(ctx, "The question " + question + " had already been declared, and its definition has been overriden");
            }
            else {
               ErrorHandling.registerError();
               ErrorHandling.printError(ctx, "Cannot assign a question to a non-question declarated variable");
               res = false;
            }
            //if (!declaredVariables.get(question).equals(ctx.QUESTIONTYPES().getText())) res = false;
         } else {
            declaredVariables.put(ctx.idset().getText(), "question");
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
      if (idset.contains(".")) {
         if (type.equals("question") || type.equals("code")) ErrorHandling.printWarning(ctx, "This declaration is redundant, and it will have to be done again");
      };

      if (declaredVariables.containsKey(idset)) {
         // Ricardo : é suposto utilizarmos a classe ErrorHandling para imprimir erros
         ErrorHandling.registerError();
         ErrorHandling.printError(ctx, "Error: " + idset + " was already declared previously.");
         res = false;
      } else {
         declaredVariables.put(idset, type);
      }

      return res;
   }

   // verificar se idset foi declarado do tipo code
   // Ricardo : se não foi declarado ainda deixar passar...
   //hugo
   @Override
   public Boolean visitCode(QlangParser.CodeContext ctx) {
      Boolean res = true;
      String idset = ctx.idset().getText();
      /*
      if (!declaredVariables.containsKey(idset)) {
         System.out.println("Error: " + idset + " has not been declared.");
         res = false;
      } else */ if ( declaredVariables.containsKey(idset) && !"code".equals(declaredVariables.get(idset))) {
         System.out.println("Error: " + idset + " is not of type code.");
         res = false;
      }

      return true;
      // Ha um problema com o pil assignemnt (muito avancado)
      // return res;
   }

   // se o idset tiver . entao o expr tem que ser uma question senao tem que ter o
   // mesmo tipo que expr
   // hugo
   @Override
   public Boolean visitIDAssignment(QlangParser.IDAssignmentContext ctx) {
      Boolean res = true;
      String idset = ctx.idset().getText();
      // isto pode estar mal
      Type exprType = ctx.expr().eType;

      // Visit the expression to determine its type
      res = visit(ctx.expr());

      if (idset.contains(".")) {
         // If idset contains a dot, expr must be of type 'question'
         if (!"question".equals(exprType.name())) {
            System.out.println("Error: The expression assigned to " + idset + " must be of type 'question'. Found: "
                  + exprType.name());
            res = false;
         }
      } else {
         // Check if idset has been declared
         if (!declaredVariables.containsKey(idset)) {
            System.out.println("Error: " + idset + " has not been declared.");
            res = false;
         } else {
            // Check if the type of idset matches the type of the expression
            String idsetType = declaredVariables.get(idset);
            if (!idsetType.equals(exprType.name())) {
               System.out.println(
                     "Error: Type mismatch for " + idset + ". Expected: " + idsetType + ", Found: " + exprType.name());
               res = false;
            }
         }
      }

      return res && visitChildren(ctx);
      // return res;
   }

   // verificar se primeiro idset e do tipo question e se o segundo idset e do tipo
   // question class ou seja multi choice, hole, open, code hole, code open,
   // code-output ou composed
   // hugo
   @Override
   public Boolean visitNewAssignment(QlangParser.NewAssignmentContext ctx) {
      Boolean res = true;
      String firstIdset = ctx.idset(0).getText();
      String secondIdset = ctx.idset(1).getText();

      // Verificar se o primeiro idset foi declarado e é do tipo 'question'
      if (!declaredVariables.containsKey(firstIdset)) {
         System.out.println("Error: " + firstIdset + " has not been declared.");
         res = false;
      } else if (!"question".equals(declaredVariables.get(firstIdset))) {
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

      // Verificar se idset é terminal (não pode ter pontos)
      if (idset.contains(".")) {
         System.out.println("Error: The idset " + idset + " must be terminal and cannot contain dots.");
         res = false;
      }

      // Verificar se expr é do tipo 'code-hole'
      if (!"code-hole".equals(exprType.name())) {
         System.out.println("Error: The expression assigned to " + idset + " must be of type 'code-hole'. Found: "
                  + exprType.name());
         res = false;
      }

      return res;
   }

   // verificar se idset é do tipo question ou code

   // JOAO
   // hugo, nao era preciso aquilo
   @Override
   public Boolean visitExecution(QlangParser.ExecutionContext ctx) {
      Boolean res = true;
      String idset = ctx.idset().getText();

      if (!declaredVariables.containsKey(idset)) {
         System.out.println("Error: " + idset + " has not been declared.");
         res = false;
      } else {
         String idsetType = declaredVariables.get(idset);
         if (!"question".equals(idsetType) && !"code".equals(idsetType)) {
            System.out.println("Error: " + idset + " must be of type 'question' or 'code'.");
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
         System.out.println("Error: " + idset + " has not been declared.");
         res = false;
      }

      res = res && visit(ctx.expr());
      Type exprType = ctx.expr().eType;

      if (!"text".equals(exprType.name())) {
         System.out.println("Error: The expression must be of type 'text'. Found: " + exprType.name());
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
         System.out.println("Error: " + idset + " has not been declared.");
         res = false;
      } else {
         String idsetType = declaredVariables.get(idset);
         if (!"code".equals(idsetType) && !"text".equals(idsetType)) {
            System.out.println("Error: " + idset + " must be of type 'code' or 'text'. Found: " + idsetType);
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
            System.out.println("Error: Denominator cannot be zero.");
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
               System.out.println("Error: Both operands of a binary relational expression must be numeric. Found: "
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
         System.out.println("Error: The condition in the if statement must be of type boolean.");
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
         System.out.println("Error: The condition in the elseif statement must be of type boolean.");
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
