// Generated from Qlang.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QlangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QlangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QlangParser#statList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatList(QlangParser.StatListContext ctx);
	/**
	 * Visit a parse tree produced by {@link QlangParser#statementWithBreak}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWithBreak(QlangParser.StatementWithBreakContext ctx);
	/**
	 * Visit a parse tree produced by {@link QlangParser#statementComposition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementComposition(QlangParser.StatementCompositionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QlangParser#commandWithBreak}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommandWithBreak(QlangParser.CommandWithBreakContext ctx);
	/**
	 * Visit a parse tree produced by {@link QlangParser#commandComposition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommandComposition(QlangParser.CommandCompositionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDSetTerminal}
	 * labeled alternative in {@link QlangParser#idset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDSetTerminal(QlangParser.IDSetTerminalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDSetComposition}
	 * labeled alternative in {@link QlangParser#idset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDSetComposition(QlangParser.IDSetCompositionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementQuestion}
	 * labeled alternative in {@link QlangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementQuestion(QlangParser.StatementQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementDeclaration}
	 * labeled alternative in {@link QlangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementDeclaration(QlangParser.StatementDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatemtentAssignment}
	 * labeled alternative in {@link QlangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatemtentAssignment(QlangParser.StatemtentAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementExecution}
	 * labeled alternative in {@link QlangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExecution(QlangParser.StatementExecutionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementExport}
	 * labeled alternative in {@link QlangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExport(QlangParser.StatementExportContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementCode}
	 * labeled alternative in {@link QlangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementCode(QlangParser.StatementCodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementCommand}
	 * labeled alternative in {@link QlangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementCommand(QlangParser.StatementCommandContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementIfLineSentence}
	 * labeled alternative in {@link QlangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementIfLineSentence(QlangParser.StatementIfLineSentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link QlangParser#newQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewQuestion(QlangParser.NewQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QlangParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(QlangParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link QlangParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(QlangParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDAssignment}
	 * labeled alternative in {@link QlangParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDAssignment(QlangParser.IDAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NewAssignment}
	 * labeled alternative in {@link QlangParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewAssignment(QlangParser.NewAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HoleQuestionAssignment}
	 * labeled alternative in {@link QlangParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHoleQuestionAssignment(QlangParser.HoleQuestionAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link QlangParser#execution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecution(QlangParser.ExecutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QlangParser#export}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExport(QlangParser.ExportContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintSentence}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintSentence(QlangParser.PrintSentenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintLineSentence}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintLineSentence(QlangParser.PrintLineSentenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UsesCodeSentence}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsesCodeSentence(QlangParser.UsesCodeSentenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UsesCodeDefined}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsesCodeDefined(QlangParser.UsesCodeDefinedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChoiceCommand}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoiceCommand(QlangParser.ChoiceCommandContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExecutionCommand}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecutionCommand(QlangParser.ExecutionCommandContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfLineSentenceCommand}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfLineSentenceCommand(QlangParser.IfLineSentenceCommandContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentCommand}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentCommand(QlangParser.AssignmentCommandContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclarationCommand}
	 * labeled alternative in {@link QlangParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationCommand(QlangParser.DeclarationCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link QlangParser#codeholeComposition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeholeComposition(QlangParser.CodeholeCompositionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QlangParser#codeholeWithBreak}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeholeWithBreak(QlangParser.CodeholeWithBreakContext ctx);
	/**
	 * Visit a parse tree produced by {@link QlangParser#codehole}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodehole(QlangParser.CodeholeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueExpr(QlangParser.ValueExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDExpr(QlangParser.IDExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesisExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisExpr(QlangParser.ParenthesisExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TextExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextExpr(QlangParser.TextExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExecutionExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecutionExpr(QlangParser.ExecutionExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprBinaryLogical}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBinaryLogical(QlangParser.ExprBinaryLogicalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StdoutExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStdoutExpr(QlangParser.StdoutExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeExpr(QlangParser.TypeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(QlangParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMultDivMod(QlangParser.ExprMultDivModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReadExpr}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadExpr(QlangParser.ReadExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAddMinus}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAddMinus(QlangParser.ExprAddMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprBinaryRelational}
	 * labeled alternative in {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBinaryRelational(QlangParser.ExprBinaryRelationalContext ctx);
	/**
	 * Visit a parse tree produced by {@link QlangParser#ifLineSentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfLineSentence(QlangParser.IfLineSentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link QlangParser#ifBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfBlock(QlangParser.IfBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link QlangParser#elseifBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseifBlock(QlangParser.ElseifBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link QlangParser#elseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseBlock(QlangParser.ElseBlockContext ctx);
}