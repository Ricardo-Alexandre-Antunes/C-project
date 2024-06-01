import java.util.HashMap;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

@SuppressWarnings("CheckReturnValue")
public class SemanticAnalyser extends PilBaseVisitor<Boolean> {
   private HashMap<String, String> variablesTypes = new HashMap<>();
   private final RealType realType = new RealType();
   private final IntegerType integerType = new IntegerType();
   private final BooleanType booleanType = new BooleanType();
   private final TextType textType = new TextType();

   public HashMap<String, String> getVariablesTypes() {
      return variablesTypes;
   }

   @Override public Boolean visitProgram(PilParser.ProgramContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitStatementComposition(PilParser.StatementCompositionContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitStatementWithBreak(PilParser.StatementWithBreakContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitStatement(PilParser.StatementContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitIfElse(PilParser.IfElseContext ctx) {
      Boolean res = visit(ctx.expr());
      if (res) {
         if (!"boolean".equals(ctx.expr().eType.name())) {
            ErrorHandling.printError(ctx, "Invalid type for if condition!");
            res = false;
         }
      }
      return res;
   }

   @Override public Boolean visitLoopFull(PilParser.LoopFullContext ctx) {
      Boolean res = visit(ctx.expr());
      if (res) {
         if (!"boolean".equals(ctx.expr().eType.name())) {
            ErrorHandling.printError(ctx, "Invalid type for loop condition!");
            res = false;
         }
      }
      return res;
   }

   @Override public Boolean visitLoopSimple(PilParser.LoopSimpleContext ctx) {
      Boolean res = visit(ctx.expr());
      if (res) {
         if (!"boolean".equals(ctx.expr().eType.name())) {
            ErrorHandling.printError(ctx, "Invalid type for loop condition!");
            res = false;
         }
      }
      return res;
   }

   @Override public Boolean visitWritelnExpr(PilParser.WritelnExprContext ctx) {
      Boolean res = true;
      return res;
   }

   @Override public Boolean visitWriteExpr(PilParser.WriteExprContext ctx) {
      Boolean res = true;
      return res;
   }

   @Override public Boolean visitAssignment(PilParser.AssignmentContext ctx) {
      Boolean res = visit(ctx.expr()) && visit(ctx.idset());
      String text = ctx.expr().getText();
      String id = ctx.idset().getText();

      if (text.startsWith("integer")) {
         variablesTypes.put(id, "integer");
         return res;
      }
      else if (text.startsWith("real")) {
         variablesTypes.put(id, "real");
         return res;
      }
      else if (text.startsWith("text")) {
         variablesTypes.put(id, "text");
         return res;
      }

      if (res) {
         if (!"text".equals(ctx.expr().eType.name()) && !"integer".equals(ctx.expr().eType.name()) && !"real".equals(ctx.expr().eType.name()) && !"boolean".equals(ctx.expr().eType.name())) {
            ErrorHandling.printError(ctx, "Invalid type for assignment!");
            res = false;
         }
         variablesTypes.put(id, ctx.expr().eType.name());
      } 
      return res;
   }

   @Override public Boolean visitExprRead(PilParser.ExprReadContext ctx) {
      Boolean res = visit(ctx.expr());
      if (res) {
         if (!"text".equals(ctx.expr().eType.name())) {
            ErrorHandling.printError(ctx, "Invalid type for prompt!");
            res = false;
         }
         ctx.eType = textType;
      }
      return res;
   }

   @Override public Boolean visitExprBinaryLogical(PilParser.ExprBinaryLogicalContext ctx) {
      Boolean res = visit(ctx.expr(0)) && visit(ctx.expr(1));
      if (res) {
         if (!"boolean".equals(ctx.expr(0).eType.name()) || !"boolean".equals(ctx.expr(1).eType.name())) {
            ErrorHandling.printError(ctx, "Logical operator applied to non-boolean operands!");
            res = false;
         }
         else {
            ctx.eType = booleanType;
         }
      }
      return res;
   }

   @Override public Boolean visitExprBoolean(PilParser.ExprBooleanContext ctx) {
      Boolean res = true;
      ctx.eType = booleanType;
      return res;
   }

   @Override public Boolean visitExprFloat(PilParser.ExprFloatContext ctx) {
      Boolean res = true;
      ctx.eType = realType;
      return res;
   }

   @Override public Boolean visitExprText(PilParser.ExprTextContext ctx) {
      Boolean res = true;
      ctx.eType = textType;
      return res;
   }

   @Override public Boolean visitExprParenthesis(PilParser.ExprParenthesisContext ctx) {
      Boolean res = visit(ctx.expr());
      if (res) {
         ctx.eType = ctx.expr().eType;
      }
      return res;
   }

   @Override public Boolean visitExprMultDivMod(PilParser.ExprMultDivModContext ctx) {
      Boolean res = visit(ctx.expr(0)) && visit(ctx.expr(1)) && checkNumericType(ctx, ctx.expr(0).eType) && checkNumericType(ctx, ctx.expr(1).eType); 
      if (res) {
         ctx.eType = fetchType(ctx.expr(0).eType, ctx.expr(1).eType);
      }
      return res;
   }

   @Override public Boolean visitExprUnary(PilParser.ExprUnaryContext ctx) {
      Boolean res = false;
      if (ctx.op.getText().equals("not")) {
         res = visit(ctx.expr());
         if (res) {
            if (!"boolean".equals(ctx.expr().eType.name())) {
               ErrorHandling.printError(ctx, "Logical operator applied to non-boolean operand!");
               res = false;
            }
            else {
               ctx.eType = booleanType;
            }
         }
      }
      else {
         res = visit(ctx.expr()) && checkNumericType(ctx, ctx.expr().eType);
         if (res) {
            ctx.eType = ctx.expr().eType;
         }
      }
      return res;
   }

   @Override public Boolean visitExprAddMinus(PilParser.ExprAddMinusContext ctx) {
      Boolean res = visit(ctx.expr(0)) && visit(ctx.expr(1)) && checkNumericType(ctx, ctx.expr(0).eType) && checkNumericType(ctx, ctx.expr(1).eType); 
      if (res) {
         ctx.eType = fetchType(ctx.expr(0).eType, ctx.expr(1).eType);
      }
      return res;
   }

   @Override public Boolean visitExprInteger(PilParser.ExprIntegerContext ctx) {
      Boolean res = true;
      ctx.eType = integerType;
      return res;
   }

   @Override public Boolean visitExprId(PilParser.ExprIdContext ctx) {
      Boolean res = visit(ctx.idset());
      String id = ctx.idset().getText();
      
      if (variablesTypes.containsKey(id)) {
         switch (variablesTypes.get(id)) {
            case "integer":
               ctx.eType = integerType;
               break;
            case "real":
               ctx.eType = realType;
               break;
            case "text":
               ctx.eType = textType;
               break;
            case "boolean":
               ctx.eType = booleanType;
               break;
            default:
               ctx.eType = null;
               break;
         }
      }
      return res;
   }

   @Override public Boolean visitExprBinaryRelational(PilParser.ExprBinaryRelationalContext ctx) {
      Boolean res = visit(ctx.expr(0)) && visit(ctx.expr(1));
      if (res) {
         if (fetchType(ctx.expr(0).eType, ctx.expr(1).eType) == null) {
            ErrorHandling.printError(ctx, "Comparison operator applied to invalid operands!");
            res = false;
         }
         else {
            ctx.eType = booleanType;
         }
      }
      return res;
   }

   @Override public Boolean visitExprTypeConversion(PilParser.ExprTypeConversionContext ctx) {
      Boolean res = visit(ctx.expr());
      String text = ctx.expr().getText();

      if (text.startsWith("read")) {
         return res;
      }

      return res;
   }

   @Override public Boolean visitExprError(PilParser.ExprErrorContext ctx) {
      Boolean res = true;
      ctx.eType = booleanType;
      return res;
   }

   @Override public Boolean visitIdset(PilParser.IdsetContext ctx) {
      Boolean res = true;
      return res;
   }

   private Boolean checkNumericType(ParserRuleContext ctx, Type t) {
      Boolean res = true;
      
      if (!t.isNumeric())
      {
         ErrorHandling.printError(ctx, "Numeric operator applied to a non-numeric operand!");
         res = false;
      }
      return res;
   }

   private Type fetchType(Type t1, Type t2) {
      Type res = null;
      if (t1.isNumeric() && t2.isNumeric())
      {
         if ("real".equals(t1.name()))
            res = t1;
         else if ("real".equals(t2.name()))
            res = t2;
         else
            res = t1;
      }
      else if ("boolean".equals(t1.name()) && "boolean".equals(t2.name()))
         res = t1;
      return res;
   }
}
