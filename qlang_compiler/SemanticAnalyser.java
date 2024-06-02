   import java.util.ArrayList;
   import java.util.HashMap;
   import java.util.List;
   import org.antlr.v4.runtime.ParserRuleContext;

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
            case "code":
               return codeType;
            default:
               return null;
         }
      }

      @Override
      public Boolean visitStatList(QlangParser.StatListContext ctx) {
         Boolean res = true;
         return visit(ctx.statementComposition());
         // return res;
      }

      @Override
      public Boolean visitStatementWithBreak(QlangParser.StatementWithBreakContext ctx) {
         Boolean res = true;
         return visit(ctx.statement());
         // return res;
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
         // return res;
      }

      @Override
      public Boolean visitCommandWithBreak(QlangParser.CommandWithBreakContext ctx) {
         Boolean res = true;
         return visit(ctx.command());
         // return res;
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
         // return res;
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
      // Ricardo : cometi um erro crasso aqui, não é para definir question sets assim
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
         Boolean res = true;
         if (res){
            String question = ctx.idset().getText();
            if (declaredVariables.containsKey(question)) {
               ErrorHandling.registerError();
               ErrorHandling.printError(ctx, "Cannot assign a Question Class to a previously declarated variable (even if question type)");
               return false;
            }
            if (declaredQuestionClasses.contains(question)) {
                  // Ricardo : Aqui acho que faz mais sentido deixar o utilizador mudar o tipo de questão mas avisar que está a ser feito um override.
                  ErrorHandling.registerError();
                  ErrorHandling.printWarning(ctx, "The question " + question + " had already been declared, and its definition has been overriden");
                  return false;
               //if (!declaredVariables.get(question).equals(ctx.QUESTIONTYPES().getText())) res = false;
            } else {
               declaredQuestionClasses.add(ctx.idset().getText());
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
         
         if (idset.equals("result")){
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, "Variable 'result' is reserved. You cannot declare over it.");
            return false;
         }
         // Ricardo : declarar uma variavel com . não faz sentido. É uma classe que deve ser inicializada de outra forma
         if (idset.contains(".")) {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, idset + " cannot be declared with a dot (reserved for question class definitions)");
            res = false;
         } else {
            // Verificar se a variável já foi declarada
            if (declaredVariables.containsKey(idset)) {
                  // Utilizar a classe ErrorHandling para imprimir erros
                  ErrorHandling.registerError();
                  ErrorHandling.printError(ctx, idset + " was already declared previously.");
                  res = false;
            } else {
                  // Verificar se o tipo é válido
                  Type variableType = getTypeByExpression(type);
                  if (variableType == null) {
                     ErrorHandling.registerError();
                     ErrorHandling.printError(ctx, type + " is not a valid type.");
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
         System.out.println(ctx.getText());
         Boolean res = true;
         String idset = ctx.idset().getText();
         // isto pode estar mal
         Type exprType = ctx.expr().eType;
         System.out.println(ctx.expr().eType);
         System.out.println(ctx.expr().getText());

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
               System.out.println(exprType);
               if (false){ //!idsetType.equals(exprType.name())) {
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

         return res;
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
            ErrorHandling.printError(ctx, firstIdset + " has not been declared.");
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
         ctx.eType = fractionType;
         String idset = ctx.idset().getText();

         if (ctx.NEW() != null && (!declaredQuestionClasses.contains(idset) && !declaredCodeClasses.contains(idset))){
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, idset + " is not a valid question or code class.");
            return false;  
         //mas o que e que estas a fazer?
         //Rodrigo: Ricardo dá indicações
         // comecem a fazer siga grind
         // eu ja fiz e refiz todos tu e que tens de dizer o que ta mal
         // um de vocês faz o export o outro o print sentence e por aí em diante
         // Rodrigo: eu faço o export :skull
         // não sei o que está mal até ver :skull:
         // hugo: tou clueless
         
         }
         if (ctx.NEW() != null){
            if (declaredQuestionClasses.contains(idset)) {
               ctx.eType = fractionType;
            }
            if (declaredCodeClasses.contains(idset)) {
               ctx.eType = codeType;
            }
         }
         if (!declaredVariables.containsKey(idset)) {
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
            if ("code".equals(idsetType.name())) ctx.eType = codeType;
            if (!"question".equals(idsetType.name()) && !"code".equals(idsetType.name())) {
               //olha tira o "Error: " de todo  o lado a funcao já faz Error
               ErrorHandling.registerError();
               ErrorHandling.printError(ctx, idset + " must be of type 'question' or 'code'.");
               return false;
            }
         }

         return res;
      }

      // verificar se expr é do tipo text

      // JOAO : Aqui tb n se devia verficiar se o idset é do tipo Result? (que é o
      // único que faz export)
      // Hugo eu acho que sim
      //estou a ver não garanto que esteja mal ou bem
      @Override
      public Boolean visitExport(QlangParser.ExportContext ctx) {
         Boolean res = true;
         String idset = ctx.idset().getText();
         
         if (!declaredVariables.containsKey(idset) && !idset.equals("result")) {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx,  idset + " has not been declared.");
            return false;
         }

         res = res && visit(ctx.expr()); //sem problemas
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
         // return res;
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
         // return res;
      }

      @Override
      public Boolean visitUsesCodeSentence(QlangParser.UsesCodeSentenceContext ctx) {
         Boolean res = true;
         if (ctx.codeholeComposition() != null) {
            res = visit(ctx.codeholeComposition());
         }
         return res;
         // return res;
      }

      // verificar se idset é do tipo code ou do tipo text porque é que eu disse isto gg
      // vai dormir ze eu ja nao fiz o qlang e tu ainda por cima dizes indicacoes erradas
      // olha, faco oq agora?
      // se quiserem começar o léxico enquanto eu revejo isto ainda não têm o ST todo mas dá para começar
      // acho melhor dizeres o que está mal
      // preciso de ver :skull:
      // ver exemplo do professor
      // ou a minha resolução da tabela html
      // eu para comecar o lexico preciso de um tutorial que eu nao andei a fazer nada disso
      // pois por isso e que tou a dizer era mais facil aq mas ya
      // JOAO
      @Override
      public Boolean visitUsesCodeDefined(QlangParser.UsesCodeDefinedContext ctx) {
         Boolean res = true;
         String idset = ctx.idset().getText();

         if (!declaredVariables.containsKey(idset)) {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, "Erystem.out.pror: " + idset + " has not been declared.");
            res = false;
         } else {
            String idsetType = declaredVariables.get(idset).name();
            if (!"code".equals(idsetType)) {
               ErrorHandling.registerError();
               ErrorHandling.printError(ctx, idset + " must be of type 'code'. Found: " + idsetType);
               return false;
            }
         }

         if (res) {
            if (ctx.codeholeComposition() != null) {
               res = visit(ctx.codeholeComposition());
            }
         }

         return res;
         // return res;
      }

      // nao apagar
      @Override
      public Boolean visitChoiceCommand(QlangParser.ChoiceCommandContext ctx) {
         Boolean res = true;
         return visit(ctx.expr());
         // return res;
      }

      @Override
      public Boolean visitExecutionCommand(QlangParser.ExecutionCommandContext ctx) {
         Boolean res = true;
         return visit(ctx.execution());
         // return res;
      }
      
      // comeca aqui -> Hugo
      @Override
      public Boolean visitIfLineSentenceCommand(QlangParser.IfLineSentenceCommandContext ctx) {
         Boolean res = true;
         return visit(ctx.ifLineSentence());
         // return res;
      }

      @Override
      public Boolean visitAssignmentCommand(QlangParser.AssignmentCommandContext ctx) {
         Boolean res = true;
         return visit(ctx.assignment());
         // return res;
      }

      @Override
      public Boolean visitDeclarationCommand(QlangParser.DeclarationCommandContext ctx) {
         Boolean res = true;
         return visit(ctx.declaration());
         // return res;
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
         // return res;
      }

      @Override
      public Boolean visitCodeholeWithBreak(QlangParser.CodeholeWithBreakContext ctx) {
         Boolean res = true;
         return visit(ctx.codehole());
         // return res;
      }

      @Override
      public Boolean visitCodehole(QlangParser.CodeholeContext ctx) {
         Boolean res = true;
         return res;
         // return res;
      }

      // segundo integer não pode ser 0 e ver se é fracao ou integer

      // JOAO
      // Hugo para de por VisitChildren em tudo ze
      @Override
      public Boolean visitValueExpr(QlangParser.ValueExprContext ctx) {
         //isto afinal é no runtime confirmei com o eduardo
         Boolean res = true;
         if (ctx.Integer(1) == null) ctx.eType = integerType;
         else ctx.eType = fractionType;
         return true;
      }

      @Override
      public Boolean visitIDExpr(QlangParser.IDExprContext ctx) {
         Boolean res = visit(ctx.idset());
         if (res) {
            ctx.eType = declaredVariables.get(ctx.idset().getText());
            if (ctx.eType == null) {
               ErrorHandling.registerError();
               ErrorHandling.printError(ctx, "Variable " + ctx.idset().getText() + " has not been declared.");
               return false;
            }
         }
         return res;
         // return res;
      }

      // ??????????
      //ricardo e para fazer um interpreter agora? era isso que tavas a dizer?
      // sim basicamente mas o que vai fazer é spammar ST
      //
      //O ETYPE ESQUECIME DE VER
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
         ctx.eType = stringType;
         return true;
         // return res;
      }

      @Override
      public Boolean visitExecutionExpr(QlangParser.ExecutionExprContext ctx) {
         Boolean res = visit(ctx.execution());
         System.out.println(ctx.execution().eType.name());
         ctx.eType = fractionType;
         if (!res) return false;
         ctx.eType = ctx.execution().eType;
         System.out.println(ctx.eType.name());
         return res;
         // return res;
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


      //requisitos desejáveis (acho) nvm gg
      //não tenho a certeza decidam
      //náo

      // antlr4-visitor STBuilder ST
      @Override
      public Boolean visitStdoutExpr(QlangParser.StdoutExprContext ctx) {
         Boolean res = true;
         if (!"text".equals(ctx.expr(0).eType.name())) {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, "The input to a code block must be in the text format.");
            return false;
            //tens de clicar no pin para te libertares
         }

         if (!"text".equals(ctx.expr(0).eType.name())) {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, "The input to a code block must be in the text format.");
            return false;
         }
         ctx.eType = stringType;
         res = visit(ctx.expr(0)) && visit(ctx.expr(1));
         return res;
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
         Boolean res = true;
         ctx.eType = stringType;
         return res;
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
                  ErrorHandling.registerError();
                  ErrorHandling.printError(ctx, " Both operands of a binary relational expression must be numeric. Found: "
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
         Boolean res = visit(ctx.ifBlock());
         for (QlangParser.ElseifBlockContext elseif : ctx.elseifBlock()) {
            res = res && visit(elseif);
         }
         if (ctx.elseBlock() != null) {
            res = res && visit(ctx.elseBlock());
         }
         return res;
         // return res;
      }


      //Hugo
      @Override
      public Boolean visitIfBlock(QlangParser.IfBlockContext ctx) {
         Boolean res = true;
         // Check if the expression inside the if condition is boolean
         Type exprType = getTypeByExpression(ctx.expr().getText());
         if (!(exprType instanceof BooleanType)) {
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, " The condition in the if statement must be of type boolean.");
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
            ErrorHandling.registerError();
            ErrorHandling.printError(ctx, " The condition in the elseif statement must be of type boolean.");
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
         Boolean res = true;
         for (QlangParser.StatementContext stmtCtx : ctx.statement()) {
            if (!visit(stmtCtx)) {
               res = false;
               break;
            }
         }
         return res;
         // return res;
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
