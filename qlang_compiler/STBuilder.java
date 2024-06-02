import java.io.File;
import org.stringtemplate.v4.*;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;

@SuppressWarnings("CheckReturnValue")
public class STBuilder extends QlangBaseVisitor<ST> {
    protected int varCount = 0;
    protected String target = "qlang"; // default
    protected STGroup stg = null;

    public boolean validTarget(String target) {
      File f = new File(target+".stg");

      return ("qlang".equalsIgnoreCase(target)) &&
             f.exists() && f.isFile() && f.canRead();
   }

   public void setTarget(String target) {
      assert validTarget(target);

      this.target = target;
   }


   @Override public ST visitStatList(QlangParser.StatListContext ctx) {
      assert validTarget(target);

      stg = new STGroupFile(target+".stg");
      ST res = stg.getInstanceOf("module");
      res.add("stat", visit(ctx.statList()));
      return res;
      //return res;
   }
    //a main (a st rule da main) é no statlist
   @Override
   public ST visitCommandWithBreak(QlangParser.CommandWithBreakContext ctx) {
        ST res = stg.getInstanceOf("stats");
        res.add(visit(ctx.command()));
        return res;
   }

   @Override public ST visitStatementComposition(QlangParser.StatementCompositionContext ctx) {
      ST res = stg.getInstanceOf("stats");
      res.add(visit(ctx.statement()));
      return res;
      //return res;
   }

   @Override
   public ST visitIDSetTerminal(QlangParser.IDSetTerminalContext ctx) {
      ST res = stg.getInstanceOf("literal");
      res.add("value", ctx.ID().getText());
      return res;
   }

   @Override
   public ST visitIDSetComposition(QlangParser.IDSetCompositionContext ctx) {
      ST res = stg.getInstanceOf("concat");
      res.add("left", ctx.ID().getText());
      res.add("right", visit(ctx.idset()));
      return res;
   }

   @Override
   public ST visitStatementQuestion(QlangParser.StatementQuestionContext ctx) {
      ST res = stg.getInstanceOf("newQuestion");
      res.add("type", ctx.newQuestion().QUESTIONTYPES().getText());
      res.add("id", visit(ctx.newQuestion().idset()));
      res.add("command", visit(ctx.newQuestion().commandComposition()));
      return res;
   }

   @Override
   public ST visitStatementDeclaration(QlangParser.StatementDeclarationContext ctx) {
      ST res = stg.getInstanceOf("decl");
      res.add("id", visit(ctx.declaration().idset()));
      res.add("type", ctx.declaration().VARIABLETYPES().getText());
      return res;
   }

   @Override
   public ST visitStatemtentAssignment(QlangParser.StatemtentAssignmentContext ctx) {
      ST res = stg.getInstanceOf("assign");
      res.add("id", visit(ctx.assignment().idset()));
      res.add("value", visit(ctx.assignment().expr()));
      return res;
   }

   @Override
   public ST visitStatementExecution(QlangParser.StatementExecutionContext ctx) {
      ST res = stg.getInstanceOf("execute");
      res.add("id", visit(ctx.execution().idset()));
      if (ctx.execution().expr() != null) {
         res.add("expr", visit(ctx.execution().expr()));
      }
      return res;
   }

   @Override
   public ST visitStatementExport(QlangParser.StatementExportContext ctx) {
      ST res = stg.getInstanceOf("export");
      res.add("id", visit(ctx.export().idset()));
      res.add("expr", visit(ctx.export().expr()));
      return res;
   }

   @Override
   public ST visitStatementCode(QlangParser.StatementCodeContext ctx) {
      ST res = stg.getInstanceOf("code");
      res.add("id", visit(ctx.code().idset()));
      if (ctx.code().assignment() != null) {
         res.add("assignment", visit(ctx.code().assignment()));
      }
      return res;
   }

   @Override
   public ST visitStatementCommand(QlangParser.StatementCommandContext ctx) {
      ST res = visit(ctx.command());
      return res;
   }

   @Override
   public ST visitStatementIfLineSentence(QlangParser.StatementIfLineSentenceContext ctx) {
      ST res = visit(ctx.ifLineSentence());
      return res;
   }

   @Override
   public ST visitNewQuestion(QlangParser.NewQuestionContext ctx) {
      ST res = stg.getInstanceOf("newQuestion");
      res.add("type", ctx.QUESTIONTYPES().getText());
      res.add("id", visit(ctx.idset()));
      res.add("commands", visit(ctx.commandComposition()));
      return res;
   }

   @Override
   public ST visitExecution(QlangParser.ExecutionContext ctx) {
      ST res = stg.getInstanceOf("execute");
      if (ctx.expr() != null) {
         res.add("expr", visit(ctx.expr()));
      }
      res.add("id", visit(ctx.idset()));
      return res;
   }

   @Override
   public ST visitExport(QlangParser.ExportContext ctx) {
      ST res = stg.getInstanceOf("export");
      res.add("id", visit(ctx.idset()));
      res.add("expr", visit(ctx.expr()));
      return res;
   }

   @Override
   public ST visitPrintSentence(QlangParser.PrintSentenceContext ctx) {
      ST res = stg.getInstanceOf("print");
      res.add("expr", visit(ctx.assignment()));
      return res;
   }

   @Override
   public ST visitPrintLineSentence(QlangParser.PrintLineSentenceContext ctx) {
      ST res = stg.getInstanceOf("println");
      res.add("expr", visit(ctx.assignment()));
      return res;
   }

   @Override
   public ST visitUsesCodeSentence(QlangParser.UsesCodeSentenceContext ctx) {
      ST res = stg.getInstanceOf("usesCode");
      res.add("text", ctx.TEXT().getText());
      if (ctx.codeholeComposition() != null) {
         res.add("codehole", visit(ctx.codeholeComposition()));
      }
      return res;
   }

   @Override
   public ST visitExecution(QlangParser.ExecutionContext ctx) {
      ST res = stg.getInstanceOf("execute");
      if (ctx.expr() != null) {
         res.add("expr", visit(ctx.expr()));
      }
      res.add("id", visit(ctx.idset()));
      return res;
   }

   @Override
   public ST visitExport(QlangParser.ExportContext ctx) {
      ST res = stg.getInstanceOf("export");
      res.add("id", visit(ctx.idset()));
      res.add("expr", visit(ctx.expr()));
      return res;
   }

   @Override
   public ST visitPrintSentence(QlangParser.PrintSentenceContext ctx) {
      ST res = stg.getInstanceOf("print");
      res.add("expr", visit(ctx.assignment()));
      return res;
   }

   @Override
   public ST visitPrintLineSentence(QlangParser.PrintLineSentenceContext ctx) {
      ST res = stg.getInstanceOf("println");
      res.add("expr", visit(ctx.assignment()));
      return res;
   }

   @Override
   public ST visitUsesCodeSentence(QlangParser.UsesCodeSentenceContext ctx) {
      ST res = stg.getInstanceOf("usesCode");
      res.add("text", ctx.TEXT().getText());
      if (ctx.codeholeComposition() != null) {
         res.add("codehole", visit(ctx.codeholeComposition()));
      }
      return res;
   }

@Override
   public ST visitUsesCodeDefined(QlangParser.UsesCodeDefinedContext ctx) {
      ST res = stg.getInstanceOf("usesCodeDefined");
      res.add("id", visit(ctx.idset()));
      if (ctx.codeholeComposition() != null) {
         res.add("codehole", visit(ctx.codeholeComposition()));
      }
      return res;
   }

   @Override
   public ST visitChoiceCommand(QlangParser.ChoiceCommandContext ctx) {
      ST res = stg.getInstanceOf("choice");
      res.add("text", ctx.TEXT().getText());
      if (ctx.expr() != null) {
         res.add("expr", visit(ctx.expr()));
      }
      return res;
   }

   @Override
   public ST visitExecutionCommand(QlangParser.ExecutionCommandContext ctx) {
      ST res = visit(ctx.execution());
      return res;
   }

   @Override
   public ST visitIfLineSentenceCommand(QlangParser.IfLineSentenceCommandContext ctx) {
      ST res = visit(ctx.ifLineSentence());
      return res;
   }

   @Override
   public ST visitAssignmentCommand(QlangParser.AssignmentCommandContext ctx) {
      ST res = visit(ctx.assignment());
      return res;
   }

@Override
   public ST visitDeclarationCommand(QlangParser.DeclarationCommandContext ctx) {
      ST res = visit(ctx.declaration());
      return res;
   }

   @Override
   public ST visitCodeholeComposition(QlangParser.CodeholeCompositionContext ctx) {
      ST res = stg.getInstanceOf("codeholeComp");
      for (QlangParser.CodeholeWithBreakContext chCtx : ctx.codeholeWithBreak()) {
         res.add("codehole", visit(chCtx));
      }
      if (ctx.codehole() != null) {
         res.add("codehole", visit(ctx.codehole()));
      }
      return res;
   }

   @Override
   public ST visitCodeholeWithBreak(QlangParser.CodeholeWithBreakContext ctx) {
      ST res = visit(ctx.codehole());
      return res;
   }

   @Override
   public ST visitCodehole(QlangParser.CodeholeContext ctx) {
      ST res = stg.getInstanceOf("codehole");
      if (ctx.Integer(0) != null) {
         res.add("start", ctx.Integer(0).getText());
      }
      if (ctx.Integer(1) != null) {
         res.add("end", ctx.Integer(1).getText());
      }
      res.add("text", ctx.getText());
      if (ctx.idset() != null) {
         res.add("idset", visit(ctx.idset()));
      }
      if (ctx.Integer() != null) {
         res.add("line", ctx.Integer().getText());
      }
      return res;
   }

   @Override
   public ST visitValueExpr(QlangParser.ValueExprContext ctx) {
      ST res = stg.getInstanceOf("literal");
      res.add("value", ctx.getText());
      return res;
   }

   @Override
   public ST visitIdExpr(CalcParser.IdExprContext ctx) {
      ST res = stg.getInstanceOf("stats");
      ST decl = stg.getInstanceOf("decl");
      String id = ctx.ID().getText();
      ctx.varName = newVarName();
      decl.add("type", ctx.eType.name());
      decl.add("var", ctx.varName);
      decl.add("value", CalcParser.symbolTable.get(id).varName());
      res.add("stat", decl.render());
      return res;
   }

   @Override
   public ST visitParenthesisExpr(QlangParser.ParenthesisExprContext ctx) {
      ST res = stg.getInstanceOf("parens");
      res.add("expr", visit(ctx.expr()));
      return res;
   }

   @Override
   public ST visitTextExpr(QlangParser.TextExprContext ctx) {
      ST res = stg.getInstanceOf("literal");
      res.add("value", ctx.getText());
      return res;
   }

   @Override
   public ST visitExecutionExpr(QlangParser.ExecutionExprContext ctx) {
      ST res = visit(ctx.execution());
      return res;
   }

   @Override
   public ST visitExprBinaryLogical(QlangParser.ExprBinaryLogicalContext ctx) {
      ST res = stg.getInstanceOf("binaryExpr");
      res.add("left", visit(ctx.expr(0)));
      res.add("op", ctx.op.getText());
      res.add("right", visit(ctx.expr(1)));
      return res;
   }

   @Override
   public ST visitStdoutExpr(QlangParser.StdoutExprContext ctx) {
      ST res = stg.getInstanceOf("stdout");
      res.add("expr", visit(ctx.expr()));
      return res;
   }

   @Override
   public ST visitTypeExpr(QlangParser.TypeExprContext ctx) {
      ST res = stg.getInstanceOf("typeCast");
      res.add("type", ctx.VARIABLETYPES().getText());
      res.add("expr", visit(ctx.expr()));
      return res;
   }

   @Override
   public ST visitUnaryExpr(QlangParser.UnaryExprContext ctx) {
      ST res = stg.getInstanceOf("unaryExpr");
      res.add("op", ctx.op.getText());
      res.add("expr", visit(ctx.expr()));
      return res;
   }

   @Override
   public ST visitExprMultDivMod(QlangParser.ExprMultDivModContext ctx) {
      ST res = stg.getInstanceOf("binaryExpr");
      res.add("left", visit(ctx.expr(0)));
      res.add("op", ctx.op.getText());
      res.add("right", visit(ctx.expr(1)));
      return res;
   }

   @Override
   public ST visitReadExpr(QlangParser.ReadExprContext ctx) {
      ST res = stg.getInstanceOf("read");
      res.add("text", ctx.TEXT().getText());
      return res;
   }

   @Override
   public ST visitExprAddMinus(QlangParser.ExprAddMinusContext ctx) {
      ST res = stg.getInstanceOf("binaryExpr");
      res.add("left", visit(ctx.expr(0)));
      res.add("op", ctx.op.getText());
      res.add("right", visit(ctx.expr(1)));
      return res;
   }

   @Override
   public ST visitExprBinaryRelational(QlangParser.ExprBinaryRelationalContext ctx) {
      ST res = stg.getInstanceOf("binaryExpr");
      res.add("left", visit(ctx.expr(0)));
      res.add("op", ctx.op.getText());
      res.add("right", visit(ctx.expr(1)));
      return res;
   }

   @Override
   public ST visitIfLineSentence(QlangParser.IfLineSentenceContext ctx) {
      ST res = stg.getInstanceOf("ifLine");
      res.add("ifBlock", visit(ctx.ifBlock()));
      for (QlangParser.ElseifBlockContext elifCtx : ctx.elseifBlock()) {
         res.add("elseifBlock", visit(elifCtx));
      }
      if (ctx.elseBlock() != null) {
         res.add("elseBlock", visit(ctx.elseBlock()));
      }
      return res;
   }

   @Override
   public ST visitIfBlock(QlangParser.IfBlockContext ctx) {
      ST res = stg.getInstanceOf("ifBlock");
      res.add("expr", visit(ctx.expr()));
      for (QlangParser.StatementContext stmtCtx : ctx.statement()) {
         res.add("statement", visit(stmtCtx));
      }
      return res;
   }

   @Override
   public ST visitElseifBlock(QlangParser.ElseifBlockContext ctx) {
      ST res = stg.getInstanceOf("elseifBlock");
      res.add("expr", visit(ctx.expr()));
      for (QlangParser.StatementContext stmtCtx : ctx.statement()) {
         res.add("statement", visit(stmtCtx));
      }
      return res;
   }
   
   @Override
   public ST visitElseBlock(QlangParser.ElseBlockContext ctx) {
      ST res = stg.getInstanceOf("elseBlock");
      for (QlangParser.StatementContext stmtCtx : ctx.statement()) {
            res.add("statement", visit(stmtCtx));
      }
      return res;
   }
}
