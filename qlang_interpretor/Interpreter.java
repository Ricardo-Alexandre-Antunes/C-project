import java.util.HashMap;
import java.util.Scanner;

@SuppressWarnings("CheckReturnValue")
public class Interpreter extends PilBaseVisitor<Value> {
   private HashMap<String, Value> variables = new HashMap<>();
   private HashMap<String, String> variablesTypes = new HashMap<>();

   public Interpreter(HashMap<String, String> variables) {
      this.variablesTypes = variables;
   }

   @Override public Value visitProgram(PilParser.ProgramContext ctx) {
      Value res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Value visitStatementComposition(PilParser.StatementCompositionContext ctx) {
      Value res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Value visitStatementWithBreak(PilParser.StatementWithBreakContext ctx) {
      Value res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Value visitStatement(PilParser.StatementContext ctx) {
      Value res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Value visitIfElse(PilParser.IfElseContext ctx) {
      Value res = null;
      String elseStat = ctx.elseStat.getText();
      BooleanValue condition = (BooleanValue) visit(ctx.expr());
      if (condition.getValue()) {
         visit(ctx.statementComposition(0));
      } 
      else if (elseStat != null) {
         visit(ctx.statementComposition(1));
      }
      return res;
   }

   @Override public Value visitLoopFull(PilParser.LoopFullContext ctx) {
      Value res = null;
      String loop_until = null;
      String loop_while = null;

      if (ctx.loopUntil != null) {
         loop_until = ctx.loopUntil.getText();
      } 
      else if (ctx.loopWhile != null) {
         loop_while = ctx.loopWhile.getText();
      } 

      while (true) {
         for (int i = 0; i < ctx.statementWithBreak().size(); i++)
            visit(ctx.statementWithBreak(i));

         BooleanValue breakValue = (BooleanValue) visit(ctx.expr());
         if (loop_until != null) {
            if (breakValue.getValue()) {
               break;
            }
         } 
         else if (loop_while != null) {
            if (!breakValue.getValue()) {
               break;
            }
         }
         visit(ctx.statementComposition());
      }
      return res;
   }

   @Override public Value visitLoopSimple(PilParser.LoopSimpleContext ctx) {
      Value res = null;
      String loop_until = ctx.loopUntil.getText();
      String loop_while = ctx.loopWhile.getText();
      
      while (true) {
         visit(ctx.statementComposition());

         BooleanValue breakValue = (BooleanValue) visit(ctx.expr());
         if (loop_until != null) {
            if (breakValue.getValue()) {
               break;
            }
         } 
         else if (loop_while != null) {
            if (!breakValue.getValue()) {
               break;
            }
         }
      }
      return res;
   }

   @Override public Value visitWritelnExpr(PilParser.WritelnExprContext ctx) {
      String res = "";
      for (int i = 0; i < ctx.expr().size(); i++) {
         String val = (String) ((Value) visit(ctx.expr(i))).getValue().toString();
         res += val;
      }
      System.out.println(res);
      return null;
   }

   @Override public Value visitWriteExpr(PilParser.WriteExprContext ctx) {
      String res = "";
      for (int i = 0; i < ctx.expr().size(); i++) {
         String val = (String) ((Value) visit(ctx.expr(i))).getValue().toString();
         res += val;
      }
      System.out.print(res);
      return null;
   }

   @Override public Value visitAssignment(PilParser.AssignmentContext ctx) {
      String id = ctx.idset().getText();
      String type = variablesTypes.get(id);

      switch (type) {
         case "integer":
            IntegerValue intVal = (IntegerValue) visit(ctx.expr());
            variables.put(id, intVal);
            break;
         case "real":
            RealValue realVal = (RealValue) visit(ctx.expr());
            variables.put(id, realVal);
            break;
         case "text":
            TextValue textVal = (TextValue) visit(ctx.expr());
            variables.put(id, textVal);
            break;
         case "boolean":
            BooleanValue boolVal = (BooleanValue) visit(ctx.expr());
            variables.put(id, boolVal);
            break;
         default:
            break;
      }
      return null;
   }

   @Override public Value visitExprRead(PilParser.ExprReadContext ctx) {
      Value res = visit(ctx.expr());
      System.out.print(res);
      Scanner scanner = new Scanner(System.in);
      String input = "";
      if (scanner.hasNextLine()) {
         input = scanner.nextLine();
      }
      Value result = new TextValue(input);
      scanner.close();
      return result;
   }

   @Override public Value visitExprBinaryLogical(PilParser.ExprBinaryLogicalContext ctx) {
      Value expr1 = visit(ctx.expr(0));
      Value expr2 = visit(ctx.expr(1));
      String op = ctx.op.getText();
      
      switch (op) {
         case "and":
            return expr1.and(expr2);
         case "or":
            return expr1.or(expr2);
         case "xor":
            return expr1.xor(expr2);
         case "implies":
            return expr1.implies(expr2);
         case "and then":
            return expr1.andThen(expr2);
         case "or else":
            return expr1.orElse(expr2);
         default:
            return null;
      }
   }

   @Override public Value visitExprUnary(PilParser.ExprUnaryContext ctx) {
      Value res = visit(ctx.expr());
      String op = ctx.op.getText();

      switch (op) {
         case "+":
            return res;
         case "-":
            return res.unaryMinus();
         case "not":
            return res.not();
         default:
            return null;
      }
   }

   @Override public Value visitExprFloat(PilParser.ExprFloatContext ctx) {
      RealValue res = new RealValue(Double.parseDouble(ctx.FLOAT().getText()));
      return res;
   }

   @Override public Value visitExprAddMinus(PilParser.ExprAddMinusContext ctx) {
      Value expr1 = visit(ctx.expr(0));
      Value expr2 = visit(ctx.expr(1));
      String op = ctx.op.getText();

      switch (op) {
         case "+":
            return expr1.add(expr2);
         case "-":
            return expr1.subtract(expr2);
         default:
            return null;
      }
   }

   @Override public Value visitExprText(PilParser.ExprTextContext ctx) {
      TextValue res = new TextValue(ctx.TEXT().getText().replaceAll("\"", ""));
      return res;
   }

   @Override public Value visitExprParenthesis(PilParser.ExprParenthesisContext ctx) {
      Value res = visit(ctx.expr());
      return res;
   }

   @Override public Value visitExprInteger(PilParser.ExprIntegerContext ctx) {
      IntegerValue res = new IntegerValue(Integer.parseInt(ctx.INTEGER().getText()));
      return res;
   }

   @Override public Value visitExprId(PilParser.ExprIdContext ctx) {
      Value res = visit(ctx.idset());
      return res;
   }

   @Override public Value visitExprBinaryRelational(PilParser.ExprBinaryRelationalContext ctx) {
      Value expr1 = visit(ctx.expr(0));
      Value expr2 = visit(ctx.expr(1));
      String op = ctx.op.getText();

      switch (op) {
         case "<":
            return expr1.lessThan(expr2);
         case "<=":
            return expr1.lessThanOrEqual(expr2);
         case ">":
            return expr1.greaterThan(expr2);
         case ">=":
            return expr1.greaterThanOrEqual(expr2);
         case "=":
            return expr1.equal(expr2);
         case "/=":
            return expr1.notEqual(expr2);
         default:
            return null;
      }
   }

   @Override public Value visitExprTypeConversion(PilParser.ExprTypeConversionContext ctx) {
      Value res = visit(ctx.expr());
      String type = ctx.type.getText();
      return res.convertTo(type);
   }

   @Override public Value visitExprMultDivMod(PilParser.ExprMultDivModContext ctx) {
      Value expr1 = visit(ctx.expr(0));
      Value expr2 = visit(ctx.expr(1));
      String op = ctx.op.getText();
      
      switch (op) {
         case "*":
            return expr1.multiply(expr2);
         case ":":
            return expr1.divide(expr2);
         case "%":
            return expr1.mod(expr2);
         default:
            return null;
      }
   }

   @Override public Value visitIdset(PilParser.IdsetContext ctx) {
      Value res = null;
      if (variables.containsKey(ctx.ID().getText())) {
         return variables.get(ctx.ID().getText());
      }
      return res;
   }

   @Override public Value visitExprBoolean(PilParser.ExprBooleanContext ctx) {
      BooleanValue res = new BooleanValue(Boolean.parseBoolean(ctx.BOOLEAN().getText()));
      return res;
   }
}
