import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings("CheckReturnValue")
public class SemanticAnalyser extends QlangBaseVisitor<Boolean> {

   private HashMap<String, String> declaredVariables = new HashMap<String, String>();
   private final BooleanType booleanType = new BooleanType();
   private final TextType stringType = new TextType();
   private final IntegerType integerType = new IntegerType();
   private final CodeType codeType = new CodeType();
   private final QuestionType questionType = new QuestionType();
   private ArrayList<String> navigatingidSet = new ArrayList<String>();

   @Override public Boolean visitStatList(QlangParser.StatListContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitStatementWithBreak(QlangParser.StatementWithBreakContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitStatementComposition(QlangParser.StatementCompositionContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitCommandWithBreak(QlangParser.CommandWithBreakContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitCommandComposition(QlangParser.CommandCompositionContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitIDSetTerminal(QlangParser.IDSetTerminalContext ctx) {
      Boolean res = true;
      if (navigatingidSet.contains(ctx.ID().getText())) {
         System.out.println("Error: " + ctx.ID().getText() + " is already declared in this set.");
         res = false;
      } 
      else {
         navigatingidSet.clear();
      }
      return res;
   }

   @Override public Boolean visitIDSetComposition(QlangParser.IDSetCompositionContext ctx) {
      Boolean res = true;
      if (navigatingidSet.contains(ctx.ID().getText())) {
         System.out.println("Error: " + ctx.ID().getText() + " is already declared in this set.");
         res = false;
      } 
      else if (declaredVariables.containsKey(res)){
         if (!declaredVariables.get(res).equals("QuestionSet")) res = false;

      }
      else {
         declaredVariables.put(ctx.ID().getText(), "QuestionSet");
      }
      if (res) {
         navigatingidSet.add(ctx.ID().getText());
         visit(ctx.idset());
      }
      return res;
      //return res;
   }

   @Override public Boolean visitNewQuestion(QlangParser.NewQuestionContext ctx) {
      Boolean res = true;
      String[] questionSets = ctx.idset().getText().split(".");
      String trueQuestion = questionSets[questionSets.length - 1];
      if (declaredVariables.containsKey(trueQuestion)) {
         if (!declaredVariables.get(trueQuestion).equals(ctx.QUESTIONTYPES().getText())) res = false;
      }
      else {
         declaredVariables.put(trueQuestion, ctx.QUESTIONTYPES().getText());
      }
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitDeclaration(QlangParser.DeclarationContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitCode(QlangParser.CodeContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitIDAssignment(QlangParser.IDAssignmentContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitNewAssignment(QlangParser.NewAssignmentContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitHoleQuestionAssignment(QlangParser.HoleQuestionAssignmentContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitExecution(QlangParser.ExecutionContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitExport(QlangParser.ExportContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitPrintSentence(QlangParser.PrintSentenceContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitPrintLineSentence(QlangParser.PrintLineSentenceContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitUsesCodeSentence(QlangParser.UsesCodeSentenceContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitUsesCodeDefined(QlangParser.UsesCodeDefinedContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitChoiceCommand(QlangParser.ChoiceCommandContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitExecutionCommand(QlangParser.ExecutionCommandContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }



   //comeca aqui -> Hugo
   @Override public Boolean visitIfLineSentenceCommand(QlangParser.IfLineSentenceCommandContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitAssignmentCommand(QlangParser.AssignmentCommandContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitDeclarationCommand(QlangParser.DeclarationCommandContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitCodeholeComposition(QlangParser.CodeholeCompositionContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitCodeholeWithBreak(QlangParser.CodeholeWithBreakContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitCodehole(QlangParser.CodeholeContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitValueExpr(QlangParser.ValueExprContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitIDExpr(QlangParser.IDExprContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitParenthesisExpr(QlangParser.ParenthesisExprContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitTextExpr(QlangParser.TextExprContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitExecutionExpr(QlangParser.ExecutionExprContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitExprBinaryLogical(QlangParser.ExprBinaryLogicalContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitStdoutExpr(QlangParser.StdoutExprContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitTypeExpr(QlangParser.TypeExprContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitUnaryExpr(QlangParser.UnaryExprContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitExprMultDivMod(QlangParser.ExprMultDivModContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitReadExpr(QlangParser.ReadExprContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitExprAddMinus(QlangParser.ExprAddMinusContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitExprBinaryRelational(QlangParser.ExprBinaryRelationalContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitIfLineSentence(QlangParser.IfLineSentenceContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitIfBlock(QlangParser.IfBlockContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitElseifBlock(QlangParser.ElseifBlockContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitElseBlock(QlangParser.ElseBlockContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }
}
