// Generated from Qlang.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QlangParser}.
 */
public interface QlangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QlangParser#statList}.
	 * @param ctx the parse tree
	 */
	void enterStatList(QlangParser.StatListContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlangParser#statList}.
	 * @param ctx the parse tree
	 */
	void exitStatList(QlangParser.StatListContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlangParser#statementWithBreak}.
	 * @param ctx the parse tree
	 */
	void enterStatementWithBreak(QlangParser.StatementWithBreakContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlangParser#statementWithBreak}.
	 * @param ctx the parse tree
	 */
	void exitStatementWithBreak(QlangParser.StatementWithBreakContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlangParser#statementComposition}.
	 * @param ctx the parse tree
	 */
	void enterStatementComposition(QlangParser.StatementCompositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlangParser#statementComposition}.
	 * @param ctx the parse tree
	 */
	void exitStatementComposition(QlangParser.StatementCompositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlangParser#commandWithBreak}.
	 * @param ctx the parse tree
	 */
	void enterCommandWithBreak(QlangParser.CommandWithBreakContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlangParser#commandWithBreak}.
	 * @param ctx the parse tree
	 */
	void exitCommandWithBreak(QlangParser.CommandWithBreakContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlangParser#commandComposition}.
	 * @param ctx the parse tree
	 */
	void enterCommandComposition(QlangParser.CommandCompositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlangParser#commandComposition}.
	 * @param ctx the parse tree
	 */
	void exitCommandComposition(QlangParser.CommandCompositionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IDSetTerminal}
	 * labeled alternative in {@link QlangParser#idset}.
	 * @param ctx the parse tree
	 */
	void enterIDSetTerminal(QlangParser.IDSetTerminalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IDSetTerminal}
	 * labeled alternative in {@link QlangParser#idset}.
	 * @param ctx the parse tree
	 */
	void exitIDSetTerminal(QlangParser.IDSetTerminalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IDSetComposition}
	 * labeled alternative in {@link QlangParser#idset}.
	 * @param ctx the parse tree
	 */
	void enterIDSetComposition(QlangParser.IDSetCompositionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IDSetComposition}
	 * labeled alternative in {@link QlangParser#idset}.
	 * @param ctx the parse tree
	 */
	void exitIDSetComposition(QlangParser.IDSetCompositionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementQuestion}
	 * labeled alternative in {@link QlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementQuestion(QlangParser.StatementQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementQuestion}
	 * labeled alternative in {@link QlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementQuestion(QlangParser.StatementQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementDeclaration}
	 * labeled alternative in {@link QlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementDeclaration(QlangParser.StatementDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementDeclaration}
	 * labeled alternative in {@link QlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementDeclaration(QlangParser.StatementDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatemtentAssignment}
	 * labeled alternative in {@link QlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatemtentAssignment(QlangParser.StatemtentAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatemtentAssignment}
	 * labeled alternative in {@link QlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatemtentAssignment(QlangParser.StatemtentAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementExecution}
	 * labeled alternative in {@link QlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementExecution(QlangParser.StatementExecutionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementExecution}
	 * labeled alternative in {@link QlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementExecution(QlangParser.StatementExecutionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementExport}
	 * labeled alternative in {@link QlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementExport(QlangParser.StatementExportContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementExport}
	 * labeled alternative in {@link QlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementExport(QlangParser.StatementExportContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementCode}
	 * labeled alternative in {@link QlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementCode(QlangParser.StatementCodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementCode}
	 * labeled alternative in {@link QlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementCode(QlangParser.StatementCodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementCommand}
	 * labeled alternative in {@link QlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementCommand(QlangParser.StatementCommandContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementCommand}
	 * labeled alternative in {@link QlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementCommand(QlangParser.StatementCommandContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementIfLineSentence}
	 * labeled alternative in {@link QlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementIfLineSentence(QlangParser.StatementIfLineSentenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementIfLineSentence}
	 * labeled alternative in {@link QlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementIfLineSentence(QlangParser.StatementIfLineSentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlangParser#newQuestion}.
	 * @param ctx the parse tree
	 */
	void enterNewQuestion(QlangParser.NewQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlangParser#newQuestion}.
	 * @param ctx the parse tree
	 */
	void exitNewQuestion(QlangParser.NewQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(QlangParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(QlangParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlangParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(QlangParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlangParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(QlangParser.CodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IDAssignment}
	 * labeled alternative in {@link QlangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterIDAssignment(QlangParser.IDAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IDAssignment}
	 * labeled alternative in {@link QlangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitIDAssignment(QlangParser.IDAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NewAssignment}
	 * labeled alternative in {@link QlangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterNewAssignment(QlangParser.NewAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewAssignment}
	 * labeled alternative in {@link QlangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitNewAssignment(QlangParser.NewAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HoleQuestionAssignment}
	 * labeled alternative in {@link QlangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterHoleQuestionAssignment(QlangParser.HoleQuestionAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HoleQuestionAssignment}
	 * labeled alternative in {@link QlangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitHoleQuestionAssignment(QlangParser.HoleQuestionAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlangParser#execution}.
	 * @param ctx the parse tree
	 */
	void enterExecution(QlangParser.ExecutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlangParser#execution}.
	 * @param ctx the parse tree
	 */
	void exitExecution(QlangParser.ExecutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlangParser#export}.
	 * @param ctx the parse tree
	 */
	void enterExport(QlangParser.ExportContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlangParser#export}.
	 * @param ctx the parse tree
	 */
	void exitExport(QlangParser.ExportContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintSentence}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 */
	void enterPrintSentence(QlangParser.PrintSentenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintSentence}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 */
	void exitPrintSentence(QlangParser.PrintSentenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintLineSentence}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 */
	void enterPrintLineSentence(QlangParser.PrintLineSentenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintLineSentence}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 */
	void exitPrintLineSentence(QlangParser.PrintLineSentenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UsesCodeSentence}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 */
	void enterUsesCodeSentence(QlangParser.UsesCodeSentenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UsesCodeSentence}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 */
	void exitUsesCodeSentence(QlangParser.UsesCodeSentenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UsesCodeDefined}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 */
	void enterUsesCodeDefined(QlangParser.UsesCodeDefinedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UsesCodeDefined}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 */
	void exitUsesCodeDefined(QlangParser.UsesCodeDefinedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChoiceCommand}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 */
	void enterChoiceCommand(QlangParser.ChoiceCommandContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChoiceCommand}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 */
	void exitChoiceCommand(QlangParser.ChoiceCommandContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExecutionCommand}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 */
	void enterExecutionCommand(QlangParser.ExecutionCommandContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExecutionCommand}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 */
	void exitExecutionCommand(QlangParser.ExecutionCommandContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfLineSentenceCommand}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 */
	void enterIfLineSentenceCommand(QlangParser.IfLineSentenceCommandContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfLineSentenceCommand}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 */
	void exitIfLineSentenceCommand(QlangParser.IfLineSentenceCommandContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignmentCommand}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentCommand(QlangParser.AssignmentCommandContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignmentCommand}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentCommand(QlangParser.AssignmentCommandContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclarationCommand}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationCommand(QlangParser.DeclarationCommandContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclarationCommand}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationCommand(QlangParser.DeclarationCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlangParser#codeholeComposition}.
	 * @param ctx the parse tree
	 */
	void enterCodeholeComposition(QlangParser.CodeholeCompositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlangParser#codeholeComposition}.
	 * @param ctx the parse tree
	 */
	void exitCodeholeComposition(QlangParser.CodeholeCompositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlangParser#codeholeWithBreak}.
	 * @param ctx the parse tree
	 */
	void enterCodeholeWithBreak(QlangParser.CodeholeWithBreakContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlangParser#codeholeWithBreak}.
	 * @param ctx the parse tree
	 */
	void exitCodeholeWithBreak(QlangParser.CodeholeWithBreakContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlangParser#codehole}.
	 * @param ctx the parse tree
	 */
	void enterCodehole(QlangParser.CodeholeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlangParser#codehole}.
	 * @param ctx the parse tree
	 */
	void exitCodehole(QlangParser.CodeholeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterValueExpr(QlangParser.ValueExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitValueExpr(QlangParser.ValueExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IDExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIDExpr(QlangParser.IDExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IDExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIDExpr(QlangParser.IDExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesisExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisExpr(QlangParser.ParenthesisExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesisExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisExpr(QlangParser.ParenthesisExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TextExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTextExpr(QlangParser.TextExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TextExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTextExpr(QlangParser.TextExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExecutionExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExecutionExpr(QlangParser.ExecutionExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExecutionExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExecutionExpr(QlangParser.ExecutionExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprBinaryLogical}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprBinaryLogical(QlangParser.ExprBinaryLogicalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprBinaryLogical}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprBinaryLogical(QlangParser.ExprBinaryLogicalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StdoutExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStdoutExpr(QlangParser.StdoutExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StdoutExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStdoutExpr(QlangParser.StdoutExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTypeExpr(QlangParser.TypeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTypeExpr(QlangParser.TypeExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(QlangParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(QlangParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMultDivMod(QlangParser.ExprMultDivModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMultDivMod(QlangParser.ExprMultDivModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReadExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterReadExpr(QlangParser.ReadExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReadExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitReadExpr(QlangParser.ReadExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAddMinus}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAddMinus(QlangParser.ExprAddMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAddMinus}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAddMinus(QlangParser.ExprAddMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprBinaryRelational}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprBinaryRelational(QlangParser.ExprBinaryRelationalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprBinaryRelational}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprBinaryRelational(QlangParser.ExprBinaryRelationalContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlangParser#ifLineSentence}.
	 * @param ctx the parse tree
	 */
	void enterIfLineSentence(QlangParser.IfLineSentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlangParser#ifLineSentence}.
	 * @param ctx the parse tree
	 */
	void exitIfLineSentence(QlangParser.IfLineSentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlangParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void enterIfBlock(QlangParser.IfBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlangParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void exitIfBlock(QlangParser.IfBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlangParser#elseifBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseifBlock(QlangParser.ElseifBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlangParser#elseifBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseifBlock(QlangParser.ElseifBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link QlangParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseBlock(QlangParser.ElseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlangParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseBlock(QlangParser.ElseBlockContext ctx);
}