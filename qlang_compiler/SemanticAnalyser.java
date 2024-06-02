   import java.util.ArrayList;
   import java.util.HashMap;
   import java.util.List;
   import org.antlr.v4.runtime.ParserRuleContext;
   import org.antlr.v4.runtime.tree.TerminalNode;

   @SuppressWarnings("CheckReturnValue")
   public class SemanticAnalyser extends QlangBaseVisitor<Boolean> {

      private HashMap<String, Type> declaredVariables = new HashMap<String, Type>();
      private ArrayList<String> declaredQuestionClasses = new ArrayList<String>();
      private ArrayList<String> declaredCodeClasses = new ArrayList<String>();
      private final BooleanType booleanType = new BooleanType();
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
            case "code":
               return codeType;
            default:
               return null;
         }
      }

      @Override
      public Boolean visitStatList(QlangParser.StatListContext ctx) {
         declaredVariables.put("result.name", textType);
         declaredVariables.put("result.id", integerType);
         declaredVariables.put("result.grade", fractionType);
         Boolean res = true;
         return visit(ctx.statementComposition());
      }

      @Override
      public Boolean visitStatementWithBreak(QlangParser.StatementWithBreakContext ctx) {
         Boolean res = true;
         return visit(ctx.statement());
      }

      @Override
      public Boolean visitStatementComposition(QlangParser.StatementCompositionContext ctx) {
         Boolean res = true;
         for (QlangParser.StatementWithBreakContext stmt : ctx.statementWithBreak()) {
            res = res && visit(stmt);
            if (!res) return res;
         }
         if (ctx.statement() != null) {
            res = res && visit(ctx.statement());
         }
         return res;
      }

      @Override
      public Boolean visitCommandWithBreak(QlangParser.CommandWithBreakContext ctx) {
         Boolean res = true;
         return visit(ctx.command());
      }

      @Override
      public Boolean visitCommandComposition(QlangParser.CommandCompositionContext ctx) {
         Boolean res = true;
         for (QlangParser.CommandWithBreakContext cmd : ctx.commandWithBreak()) {
            res = res && visit(cmd);
            if (!res) return res;
         }
         if (ctx.command() != null) {
            res = res && visit(ctx.command());
         }
         return res;
      }

      @Override
      public Boolean visitIDSetTerminal(QlangParser.IDSetTerminalContext ctx) {
         Boolean res = true;
         if (navigatingidSet.contains(ctx.ID().getText())) {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, ctx.ID().getText() + " is already declared in this set.");
            res = false;
         } else {
            navigatingidSet.clear();
         }
         return res;
      }

      @Override
      public Boolean visitIDSetComposition(QlangParser.IDSetCompositionContext ctx) {
         Boolean res = true;
         if (navigatingidSet.contains(ctx.ID().getText())) {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, ctx.ID().getText() + " is already declared in this set.");
            res = false;
         } else {
            navigatingidSet.add(ctx.ID().getText());
            res = visit(ctx.idset());
         }
         return res;
      }

      @Override
      public Boolean visitNewQuestion(QlangParser.NewQuestionContext ctx) {
         Boolean res = true;
         if (res){
            String question = ctx.idset().getText();
            if (declaredVariables.containsKey(question)) {
               ErrorHandling.registerError();
               ErrorHandling.printError(ctx, "Cannot assign a Question Class to a previously declarated variable (even if question type)");
               return false;
            }
            if (declaredQuestionClasses.contains(question)) {
                  ErrorHandling.registerError();
                  ErrorHandling.printWarning(ctx, "The question " + question + " had already been declared, and its definition has been overriden");
                  return false;
            
            } else {
               declaredQuestionClasses.add(ctx.idset().getText());
            }
         }
         return res && visit(ctx.commandComposition());
      }

      @Override
      public Boolean visitDeclaration(QlangParser.DeclarationContext ctx) {
         Boolean res = true;
         String idset = ctx.idset().getText();
         String type = "code";
         if (ctx.VARIABLETYPES() != null) type = ctx.VARIABLETYPES().getText();
         
         if (idset.contains("result")){
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, "Variable 'result' is reserved. You cannot declare over it.");
            return false;
         }
         if (idset.contains(".")) {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, idset + " cannot be declared with a dot (reserved for question class definitions)");
            res = false;
         } else {
            if (declaredVariables.containsKey(idset)) {
                  ErrorHandling.registerError();
                  ErrorHandling.printError(ctx, idset + " was already declared previously.");
                  res = false;
            } else {
                  Type variableType = getTypeByExpression(type);
                  if (variableType == null) {
                     ErrorHandling.registerError();
                     ErrorHandling.printError(ctx, type + " is not a valid type.");
                     res = false;
                  } else {
                     declaredVariables.put(idset, variableType);
                  }
            }
         }

         return res;
      }
      
      
      @Override
      public Boolean visitCode(QlangParser.CodeContext ctx) {
         Boolean res = true;
         String idset = ctx.idset().getText();

         if (declaredQuestionClasses.contains(idset)) {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, idset + " was already declared - and it's not a class of type Code.");
            res = false;
            return res;
         }

         if (declaredCodeClasses.contains(idset)) {
            ErrorHandling.printWarning(ctx, idset + " was already declared, but its previous definition is being overridden.");
         } else {

            declaredCodeClasses.add(idset);
         }

         return res;
      }

      @Override
      public Boolean visitIDAssignment(QlangParser.IDAssignmentContext ctx) {
         Boolean res = true;
         String idset = ctx.idset().getText();
         res = visit(ctx.expr());
         Type exprType = ctx.expr().eType;

         if (!res) return false;

         if (!declaredVariables.containsKey(idset)) {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, idset + " has not been declared prior to assignment.");
            res = false;
         } else {
            Type idsetType = declaredVariables.get(idset);
            if (!idsetType.name().equals(exprType.name())) {
               if (idsetType.conformsTo(exprType)){
                  ErrorHandling.printWarning(ctx, "Assignment mismatch - Expected " + idsetType + " but found " + exprType.name() + ". However, assignment was still possible.");
               } else {
                  ErrorHandling.registerError();
                  ErrorHandling.printError(ctx, "Assignment Mismatch - Expected " + idsetType + " but found " + exprType.name());
                  res = false;
               }
            }
         }

         return res;
      }


      @Override
      public Boolean visitNewAssignment(QlangParser.NewAssignmentContext ctx) {
         Boolean res = true;
         String firstIdset = ctx.idset(0).getText();
         String secondIdset = ctx.idset(1).getText();

         
         // Verificar se o primeiro idset foi declarado e é do tipo 'question'
         if (!declaredVariables.containsKey(firstIdset)) {
            ErrorHandling.printError(ctx, firstIdset + " has not been declared.");
            return false;
         }

         if (declaredQuestionClasses.contains(secondIdset)) {
            if (!"question".equals(declaredVariables.get(firstIdset).name())) {
               ErrorHandling.registerError();
               ErrorHandling.printError(ctx,  firstIdset + " is not a question.");
               return false;
            }
         } else if (declaredCodeClasses.contains(secondIdset)) {
            if (!"code".equals(declaredVariables.get(firstIdset).name())) {
               ErrorHandling.registerError();
               ErrorHandling.printError(ctx,  firstIdset + " is not a code.");
               return false;
            }
         } else {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx,  secondIdset + " is not a valid question or code class.");
            return false;
         }

         return res;
      }

      @Override
      public Boolean visitHoleQuestionAssignment(QlangParser.HoleQuestionAssignmentContext ctx) {
         Boolean res = true;
         String idset = ctx.idset().getText();
         Type exprType = ctx.expr().eType;

         res = visit(ctx.expr());
         if (!res) return false;

         if (idset.contains(".")) {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, "The local variable " + idset + " must not be a question-class or code-class.");
            res = false;
         }

         return res;
      }

      @Override
      public Boolean visitExecution(QlangParser.ExecutionContext ctx) {
         Boolean res = true;
         ctx.eType = fractionType;
         String idset = ctx.idset().getText();

         if (ctx.NEW() != null && (!declaredQuestionClasses.contains(idset) && !declaredCodeClasses.contains(idset))){
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, idset + " is not a valid question or code class.");
            return false;  
         
         }
         if (ctx.NEW() != null){
            if (declaredQuestionClasses.contains(idset)) {
               ctx.eType = fractionType;
            }
            if (declaredCodeClasses.contains(idset)) {
               ctx.eType = textType;
            }
         }
         else if (!declaredVariables.containsKey(idset)) {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, idset + " has not been declared.");
            return false;
         } else {
            Type idsetType = declaredVariables.get(idset);
            if (ctx.NEW() != null) {
               ErrorHandling.registerError();
               ErrorHandling.printError(ctx, idset + " is not a question-class or code-class.");
               return false;
            }
            if ("question".equals(idsetType.name())) ctx.eType = fractionType;
            if ("code".equals(idsetType.name())) ctx.eType = textType;
            if (!"question".equals(idsetType.name()) && !"code".equals(idsetType.name())) {

               ErrorHandling.registerError();
               ErrorHandling.printError(ctx, idset + " must be of type 'question' or 'code'.");
               return false;
            }
         }

         return res;
      }


      @Override
      public Boolean visitExport(QlangParser.ExportContext ctx) {
         Boolean res = true;
         String idset = ctx.idset().getText();
         
         if (!declaredVariables.containsKey(idset) && !idset.equals("result")) {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx,  idset + " has not been declared.");
            return false;
         }

         res = res && visit(ctx.expr()); 
         if (!res) return res;
         Type exprType = ctx.expr().eType;

         if (!"text".equals(exprType.name())) {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx,  "The expression must be of type 'text'. Found: " + exprType.name());
            return false;
         }

         return res;
      }

      @Override
      public Boolean visitPrintSentence(QlangParser.PrintSentenceContext ctx) {
         Boolean res = true;
         if (ctx.expr() == null){
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, "Print sentence must have at least one string to print.");
            return false;
         }
         else {
            for (QlangParser.ExprContext expr : ctx.expr()) {
               res = res && visit(expr);
               if (!res) return res;
               Type exprType = expr.eType;
               if (!"text".equals(exprType.name())) {
                  ErrorHandling.registerError();
                  ErrorHandling.printError(ctx, "Only text can be printed (did you try to do an assignment but used the incorrect syntax?)");
                  return false;
               }
            }
         }
         return res;
      }

      @Override
      public Boolean visitPrintLineSentence(QlangParser.PrintLineSentenceContext ctx) {
         Boolean res = true;
         if (ctx.expr() == null){
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, "Print sentence must have at least one string to print.");
            return false;
         }
         else {
            for (QlangParser.ExprContext expr : ctx.expr()) {
               res = res && visit(expr);
               if (!res) return res;
               Type exprType = expr.eType;
               if (!"text".equals(exprType.name())) {
                  ErrorHandling.registerError();
                  ErrorHandling.printError(ctx, "Only text can be printed (did you try to do an assignment but used the incorrect syntax?)");
                  return false;
               }
            }
         }
         return res;
      }

      @Override
      public Boolean visitUsesCodeSentence(QlangParser.UsesCodeSentenceContext ctx) {
         Boolean res = true;
         if (ctx.codeholeComposition() != null) {
            res = visit(ctx.codeholeComposition());
         }
         return res;
      }

      @Override
      public Boolean visitUsesCodeDefined(QlangParser.UsesCodeDefinedContext ctx) {
         Boolean res = visit(ctx.idset());
         String idset = ctx.idset().getText();

         if (!declaredCodeClasses.contains(idset)) {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, idset + " has not been declared.");
            res = false;
         }

         if (res) {
            if (ctx.codeholeComposition() != null) {
               res = visit(ctx.codeholeComposition());
            }
         }

         return res;

      }

      @Override
      public Boolean visitChoiceCommand(QlangParser.ChoiceCommandContext ctx) {
         Boolean res = true;
         return visit(ctx.expr());
      }

      @Override
      public Boolean visitExecutionCommand(QlangParser.ExecutionCommandContext ctx) {
         Boolean res = true;
         return visit(ctx.execution());

      }
      

      @Override
      public Boolean visitIfLineSentenceCommand(QlangParser.IfLineSentenceCommandContext ctx) {
         Boolean res = true;
         return visit(ctx.ifLineSentence());

      }

      @Override
      public Boolean visitAssignmentCommand(QlangParser.AssignmentCommandContext ctx) {
         Boolean res = true;
         return visit(ctx.assignment());

      }

      @Override
      public Boolean visitDeclarationCommand(QlangParser.DeclarationCommandContext ctx) {
         Boolean res = true;
         return visit(ctx.declaration());

      }

      @Override
      public Boolean visitCodeholeComposition(QlangParser.CodeholeCompositionContext ctx) {
         Boolean res = true;
         for (QlangParser.CodeholeWithBreakContext codehole : ctx.codeholeWithBreak()) {
            res = res && visit(codehole);
            if (!res) return res;
         }
         if (ctx.codehole() != null) {
            res = res && visit(ctx.codehole());
         }
         return res;

      }

      @Override
      public Boolean visitCodeholeWithBreak(QlangParser.CodeholeWithBreakContext ctx) {
         Boolean res = true;
         return visit(ctx.codehole());

      }

      @Override
      public Boolean visitCodehole(QlangParser.CodeholeContext ctx) {
         Boolean res = true;
         return res;

      }


      @Override
      public Boolean visitValueExpr(QlangParser.ValueExprContext ctx) {

         Boolean res = true;
         if (ctx.Integer(1) == null) ctx.eType = integerType;
         else ctx.eType = fractionType;
         return true;
      }

      @Override
      public Boolean visitIDExpr(QlangParser.IDExprContext ctx) {
         Boolean res = visit(ctx.idset());
         if (res) {
            switch (ctx.idset().getText()) {
               case "result.name":
                  ctx.eType = textType;
                  return res;
               case "result.id":
                  ctx.eType = integerType;
                  return res;
               case "return.grade":
                  ctx.eType = fractionType;
                  return res;
            }
            ctx.eType = declaredVariables.get(ctx.idset().getText());
            if (ctx.eType == null) {
               ErrorHandling.registerError();
               ErrorHandling.printError(ctx, "Variable " + ctx.idset().getText() + " has not been declared.");
               return false;
            }
         }
         return res;

      }


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
         Boolean res = true;
         ctx.eType = textType;
         return true;

      }

      @Override
      public Boolean visitExecutionExpr(QlangParser.ExecutionExprContext ctx) {
         Boolean res = visit(ctx.execution());
         ctx.eType = fractionType;
         if (!res) return false;
         ctx.eType = ctx.execution().eType;
         return res;

      }

      @Override
      public Boolean visitExprBinaryLogical(QlangParser.ExprBinaryLogicalContext ctx) {
         Boolean res = visit(ctx.expr(0)) && visit(ctx.expr(1));
         if (res) {
            if (!"boolean".equals(ctx.expr(0).eType.name()) || !"boolean".equals(ctx.expr(1).eType.name())) {
               ErrorHandling.registerError();
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
         Boolean res = visit(ctx.expr(0)) && visit(ctx.expr(1));

         if (!"text".equals(ctx.expr(0).eType.name())) {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, "The input to a code block must be in the text format.");
            return false;

         }

         if (!"text".equals(ctx.expr(0).eType.name())) {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, "The input to a code block must be in the text format.");
            return false;
         }
         ctx.eType = textType;
         res = visit(ctx.expr(0)) && visit(ctx.expr(1));
         return res;

      }

      @Override
      public Boolean visitTypeExpr(QlangParser.TypeExprContext ctx) {
         Boolean res = true;

         String variableType = ctx.VARIABLETYPES().getText();
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
                  ErrorHandling.registerError();
                  //senhor easter egg
                  ErrorHandling.printError(ctx, "Achievement Unlocked: How did we get here?");
                  res = false;
                  break;
         }
      
         return res && visit(ctx.expr());
      }
      

      @Override
      public Boolean visitUnaryExpr(QlangParser.UnaryExprContext ctx) {
         if (ctx.op.getText().equals("not") && !"boolean".equals(ctx.expr().eType.name())) {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, "Trying to negate a boolean, but turns out it's a " + ctx.expr().eType.name());
            return false;
         }
         Boolean res = visit(ctx.expr()) && checkNumericType(ctx, ctx.expr().eType);
         if (res) {
            ctx.eType = ctx.expr().eType;
         }
         return res;
      }

      @Override
      public Boolean visitExprMultDivMod(QlangParser.ExprMultDivModContext ctx) {
         Boolean res = visit(ctx.expr(0)) && visit(ctx.expr(1)) && checkNumericType(ctx, ctx.expr(0).eType)
               && checkNumericType(ctx, ctx.expr(1).eType);
         if (res) {
            ctx.eType = fetchType(ctx.expr(0).eType, ctx.expr(1).eType);
         }
         return res;
      }

      @Override
      public Boolean visitReadExpr(QlangParser.ReadExprContext ctx) {
         Boolean res = true;
         ctx.eType = textType;
         return res;
      }

      @Override
      public Boolean visitExprAddMinus(QlangParser.ExprAddMinusContext ctx) {
         Boolean res = visit(ctx.expr(0)) && visit(ctx.expr(1)) && checkNumericType(ctx, ctx.expr(0).eType)
               && checkNumericType(ctx, ctx.expr(1).eType);
         if (res) {
            ctx.eType = fetchType(ctx.expr(0).eType, ctx.expr(1).eType);
         }
         return res;
      }

     
      @Override
      public Boolean visitExprBinaryRelational(QlangParser.ExprBinaryRelationalContext ctx) {
         Boolean res = true;
      
         res = visit(ctx.expr(0)) && visit(ctx.expr(1));
      
         if (res) {
            Type leftType = ctx.expr(0).eType;
            Type rightType = ctx.expr(1).eType;
      
            if (!leftType.isNumeric() || !rightType.isNumeric()) {
                  ErrorHandling.registerError();
                  ErrorHandling.printError(ctx, " Both operands of a binary relational expression must be numeric. Found: "
                        + leftType.name() + " and " + rightType.name());
                  res = false;
            } else {
                  ctx.eType = booleanType;
            }
         }
      
         return res;
      }
      

      @Override
      public Boolean visitIfLineSentence(QlangParser.IfLineSentenceContext ctx) {
         Boolean res = visit(ctx.ifBlock());
         for (QlangParser.ElseifBlockContext elseif : ctx.elseifBlock()) {
            res = res && visit(elseif);
         }
         if (ctx.elseBlock() != null) {
            res = res && visit(ctx.elseBlock());
         }
         return res;
      }



      @Override
      public Boolean visitIfBlock(QlangParser.IfBlockContext ctx) {
         Boolean res = true;
         Type exprType = getTypeByExpression(ctx.expr().getText());
         if (!(exprType instanceof BooleanType)) {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, " The condition in the if statement must be of type boolean.");
            res = false;
         }
         for (QlangParser.StatementContext stmtCtx : ctx.statement()) {
            if (!visit(stmtCtx)) {
               res = false;
               break;
            }
         }
         return res;
      }

      @Override
      public Boolean visitElseifBlock(QlangParser.ElseifBlockContext ctx) {
         Boolean res = true;
         
         Type exprType = ctx.expr().eType;

         if (!(exprType.conformsTo(new BooleanType()))) {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, " The condition in the elseif statement must be of type boolean.");
            res = false;
         }
        
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
         Boolean res = true;
         for (QlangParser.StatementContext stmtCtx : ctx.statement()) {
            if (!visit(stmtCtx)) {
               res = false;
               break;
            }
         }
         return res;

      }

      private Boolean checkNumericType(ParserRuleContext ctx, Type t) {
         Boolean res = true;
         if (!t.isNumeric()) {
            ErrorHandling.registerError();
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
