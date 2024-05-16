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
	 * Enter a parse tree produced by the {@code MultiChoiceQuestion}
	 * labeled alternative in {@link QlangParser#newQuestion}.
	 * @param ctx the parse tree
	 */
	void enterMultiChoiceQuestion(QlangParser.MultiChoiceQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiChoiceQuestion}
	 * labeled alternative in {@link QlangParser#newQuestion}.
	 * @param ctx the parse tree
	 */
	void exitMultiChoiceQuestion(QlangParser.MultiChoiceQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HoleQuestion}
	 * labeled alternative in {@link QlangParser#newQuestion}.
	 * @param ctx the parse tree
	 */
	void enterHoleQuestion(QlangParser.HoleQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HoleQuestion}
	 * labeled alternative in {@link QlangParser#newQuestion}.
	 * @param ctx the parse tree
	 */
	void exitHoleQuestion(QlangParser.HoleQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OpenQuestion}
	 * labeled alternative in {@link QlangParser#newQuestion}.
	 * @param ctx the parse tree
	 */
	void enterOpenQuestion(QlangParser.OpenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OpenQuestion}
	 * labeled alternative in {@link QlangParser#newQuestion}.
	 * @param ctx the parse tree
	 */
	void exitOpenQuestion(QlangParser.OpenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ColeHoleQuestion}
	 * labeled alternative in {@link QlangParser#newQuestion}.
	 * @param ctx the parse tree
	 */
	void enterColeHoleQuestion(QlangParser.ColeHoleQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColeHoleQuestion}
	 * labeled alternative in {@link QlangParser#newQuestion}.
	 * @param ctx the parse tree
	 */
	void exitColeHoleQuestion(QlangParser.ColeHoleQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ColeOpenQuestion}
	 * labeled alternative in {@link QlangParser#newQuestion}.
	 * @param ctx the parse tree
	 */
	void enterColeOpenQuestion(QlangParser.ColeOpenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColeOpenQuestion}
	 * labeled alternative in {@link QlangParser#newQuestion}.
	 * @param ctx the parse tree
	 */
	void exitColeOpenQuestion(QlangParser.ColeOpenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CodeOutputQuestion}
	 * labeled alternative in {@link QlangParser#newQuestion}.
	 * @param ctx the parse tree
	 */
	void enterCodeOutputQuestion(QlangParser.CodeOutputQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CodeOutputQuestion}
	 * labeled alternative in {@link QlangParser#newQuestion}.
	 * @param ctx the parse tree
	 */
	void exitCodeOutputQuestion(QlangParser.CodeOutputQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code QuestionDeclaration}
	 * labeled alternative in {@link QlangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterQuestionDeclaration(QlangParser.QuestionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code QuestionDeclaration}
	 * labeled alternative in {@link QlangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitQuestionDeclaration(QlangParser.QuestionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FractionDeclaration}
	 * labeled alternative in {@link QlangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterFractionDeclaration(QlangParser.FractionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FractionDeclaration}
	 * labeled alternative in {@link QlangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitFractionDeclaration(QlangParser.FractionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntegerDeclaration}
	 * labeled alternative in {@link QlangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterIntegerDeclaration(QlangParser.IntegerDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntegerDeclaration}
	 * labeled alternative in {@link QlangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitIntegerDeclaration(QlangParser.IntegerDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TextDeclaration}
	 * labeled alternative in {@link QlangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterTextDeclaration(QlangParser.TextDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TextDeclaration}
	 * labeled alternative in {@link QlangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitTextDeclaration(QlangParser.TextDeclarationContext ctx);
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
	 * Enter a parse tree produced by {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(QlangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(QlangParser.ExprContext ctx);
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