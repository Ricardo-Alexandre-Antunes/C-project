// Generated from Qlang.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class QlangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, VERBATIMOPEN=43, VERBATIMCLOSE=44, 
		PIL=45, TEXT=46, ID=47, Integer=48, SKIPPING=49, NEWLINE=50, BLOCKCOMMENT=51, 
		SINGLECOMMENT=52;
	public static final int
		RULE_statList = 0, RULE_statementWithBreak = 1, RULE_statementComposition = 2, 
		RULE_commandWithBreak = 3, RULE_commandComposition = 4, RULE_statement = 5, 
		RULE_code = 6, RULE_newQuestion = 7, RULE_declaration = 8, RULE_assignment = 9, 
		RULE_execution = 10, RULE_export = 11, RULE_command = 12, RULE_expr = 13, 
		RULE_ifLineSentence = 14, RULE_ifBlock = 15, RULE_elseifBlock = 16, RULE_elseBlock = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"statList", "statementWithBreak", "statementComposition", "commandWithBreak", 
			"commandComposition", "statement", "code", "newQuestion", "declaration", 
			"assignment", "execution", "export", "command", "expr", "ifLineSentence", 
			"ifBlock", "elseifBlock", "elseBlock"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'code'", "'is'", "'multi-choice'", "'end'", "'hole'", "'open'", 
			"'cole-hole'", "'cole-open'", "'code-output'", "':'", "'question'", "'fraction'", 
			"'integer'", "'text'", "':='", "'new'", "'->'", "'execute'", "'export'", 
			"'to'", "'print'", "'println'", "'uses code from '", "' end'", "'true'", 
			"'false'", "'not'", "'and'", "'or'", "'=='", "'!='", "'<'", "'<='", "'>'", 
			"'>='", "'('", "')'", "'if'", "'then'", "'elseif'", "'else'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "VERBATIMOPEN", "VERBATIMCLOSE", 
			"PIL", "TEXT", "ID", "Integer", "SKIPPING", "NEWLINE", "BLOCKCOMMENT", 
			"SINGLECOMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Qlang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QlangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatListContext extends ParserRuleContext {
		public StatementCompositionContext statementComposition() {
			return getRuleContext(StatementCompositionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(QlangParser.EOF, 0); }
		public StatListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterStatList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitStatList(this);
		}
	}

	public final StatListContext statList() throws RecognitionException {
		StatListContext _localctx = new StatListContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_statList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			statementComposition();
			setState(37);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementWithBreakContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementWithBreakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementWithBreak; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterStatementWithBreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitStatementWithBreak(this);
		}
	}

	public final StatementWithBreakContext statementWithBreak() throws RecognitionException {
		StatementWithBreakContext _localctx = new StatementWithBreakContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statementWithBreak);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(39);
			statement();
			setState(40);
			match(T__0);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementCompositionContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<StatementWithBreakContext> statementWithBreak() {
			return getRuleContexts(StatementWithBreakContext.class);
		}
		public StatementWithBreakContext statementWithBreak(int i) {
			return getRuleContext(StatementWithBreakContext.class,i);
		}
		public StatementCompositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementComposition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterStatementComposition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitStatementComposition(this);
		}
	}

	public final StatementCompositionContext statementComposition() throws RecognitionException {
		StatementCompositionContext _localctx = new StatementCompositionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statementComposition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(42);
					statementWithBreak();
					}
					} 
				}
				setState(47);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(50);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(48);
				statement();
				}
				break;
			case 2:
				{
				setState(49);
				statementWithBreak();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CommandWithBreakContext extends ParserRuleContext {
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public CommandWithBreakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commandWithBreak; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterCommandWithBreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitCommandWithBreak(this);
		}
	}

	public final CommandWithBreakContext commandWithBreak() throws RecognitionException {
		CommandWithBreakContext _localctx = new CommandWithBreakContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_commandWithBreak);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(52);
			command();
			setState(53);
			match(T__0);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CommandCompositionContext extends ParserRuleContext {
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public List<CommandWithBreakContext> commandWithBreak() {
			return getRuleContexts(CommandWithBreakContext.class);
		}
		public CommandWithBreakContext commandWithBreak(int i) {
			return getRuleContext(CommandWithBreakContext.class,i);
		}
		public CommandCompositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commandComposition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterCommandComposition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitCommandComposition(this);
		}
	}

	public final CommandCompositionContext commandComposition() throws RecognitionException {
		CommandCompositionContext _localctx = new CommandCompositionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_commandComposition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(55);
					commandWithBreak();
					}
					} 
				}
				setState(60);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(61);
				command();
				}
				break;
			case 2:
				{
				setState(62);
				commandWithBreak();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementExecutionContext extends StatementContext {
		public ExecutionContext execution() {
			return getRuleContext(ExecutionContext.class,0);
		}
		public StatementExecutionContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterStatementExecution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitStatementExecution(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementDeclarationContext extends StatementContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public StatementDeclarationContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterStatementDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitStatementDeclaration(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatemtentAssignmentContext extends StatementContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public StatemtentAssignmentContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterStatemtentAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitStatemtentAssignment(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementCodeContext extends StatementContext {
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public StatementCodeContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterStatementCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitStatementCode(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementExportContext extends StatementContext {
		public ExportContext export() {
			return getRuleContext(ExportContext.class,0);
		}
		public StatementExportContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterStatementExport(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitStatementExport(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementQuestionContext extends StatementContext {
		public NewQuestionContext newQuestion() {
			return getRuleContext(NewQuestionContext.class,0);
		}
		public StatementQuestionContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterStatementQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitStatementQuestion(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		try {
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new StatementQuestionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				newQuestion();
				}
				break;
			case 2:
				_localctx = new StatementDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				declaration();
				}
				break;
			case 3:
				_localctx = new StatemtentAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				assignment();
				}
				break;
			case 4:
				_localctx = new StatementExecutionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(68);
				execution();
				}
				break;
			case 5:
				_localctx = new StatementExportContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(69);
				export();
				}
				break;
			case 6:
				_localctx = new StatementCodeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(70);
				code();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CodeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(QlangParser.ID, 0); }
		public TerminalNode PIL() { return getToken(QlangParser.PIL, 0); }
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitCode(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_code);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(T__1);
			setState(74);
			match(ID);
			setState(75);
			match(T__2);
			setState(76);
			match(PIL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NewQuestionContext extends ParserRuleContext {
		public NewQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newQuestion; }
	 
		public NewQuestionContext() { }
		public void copyFrom(NewQuestionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ColeHoleQuestionContext extends NewQuestionContext {
		public CommandCompositionContext commandComposition() {
			return getRuleContext(CommandCompositionContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(QlangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(QlangParser.ID, i);
		}
		public ColeHoleQuestionContext(NewQuestionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterColeHoleQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitColeHoleQuestion(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CodeOutputQuestionContext extends NewQuestionContext {
		public CommandCompositionContext commandComposition() {
			return getRuleContext(CommandCompositionContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(QlangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(QlangParser.ID, i);
		}
		public CodeOutputQuestionContext(NewQuestionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterCodeOutputQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitCodeOutputQuestion(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ColeOpenQuestionContext extends NewQuestionContext {
		public CommandCompositionContext commandComposition() {
			return getRuleContext(CommandCompositionContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(QlangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(QlangParser.ID, i);
		}
		public ColeOpenQuestionContext(NewQuestionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterColeOpenQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitColeOpenQuestion(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiChoiceQuestionContext extends NewQuestionContext {
		public CommandCompositionContext commandComposition() {
			return getRuleContext(CommandCompositionContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(QlangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(QlangParser.ID, i);
		}
		public MultiChoiceQuestionContext(NewQuestionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterMultiChoiceQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitMultiChoiceQuestion(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HoleQuestionContext extends NewQuestionContext {
		public CommandCompositionContext commandComposition() {
			return getRuleContext(CommandCompositionContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(QlangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(QlangParser.ID, i);
		}
		public HoleQuestionContext(NewQuestionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterHoleQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitHoleQuestion(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OpenQuestionContext extends NewQuestionContext {
		public CommandCompositionContext commandComposition() {
			return getRuleContext(CommandCompositionContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(QlangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(QlangParser.ID, i);
		}
		public OpenQuestionContext(NewQuestionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterOpenQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitOpenQuestion(this);
		}
	}

	public final NewQuestionContext newQuestion() throws RecognitionException {
		NewQuestionContext _localctx = new NewQuestionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_newQuestion);
		int _la;
		try {
			setState(138);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				_localctx = new MultiChoiceQuestionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				match(T__3);
				setState(80); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(79);
					match(ID);
					}
					}
					setState(82); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(84);
				match(T__2);
				setState(85);
				commandComposition();
				setState(86);
				match(T__4);
				}
				break;
			case T__5:
				_localctx = new HoleQuestionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				match(T__5);
				setState(90); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(89);
					match(ID);
					}
					}
					setState(92); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(94);
				match(T__2);
				setState(95);
				commandComposition();
				setState(96);
				match(T__4);
				}
				break;
			case T__6:
				_localctx = new OpenQuestionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(98);
				match(T__6);
				setState(100); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(99);
					match(ID);
					}
					}
					setState(102); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(104);
				match(T__2);
				setState(105);
				commandComposition();
				setState(106);
				match(T__4);
				}
				break;
			case T__7:
				_localctx = new ColeHoleQuestionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(108);
				match(T__7);
				setState(110); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(109);
					match(ID);
					}
					}
					setState(112); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(114);
				match(T__2);
				setState(115);
				commandComposition();
				setState(116);
				match(T__4);
				}
				break;
			case T__8:
				_localctx = new ColeOpenQuestionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(118);
				match(T__8);
				setState(120); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(119);
					match(ID);
					}
					}
					setState(122); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(124);
				match(T__2);
				setState(125);
				commandComposition();
				setState(126);
				match(T__4);
				}
				break;
			case T__9:
				_localctx = new CodeOutputQuestionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(128);
				match(T__9);
				setState(130); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(129);
					match(ID);
					}
					}
					setState(132); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(134);
				match(T__2);
				setState(135);
				commandComposition();
				setState(136);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	 
		public DeclarationContext() { }
		public void copyFrom(DeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FractionDeclarationContext extends DeclarationContext {
		public TerminalNode ID() { return getToken(QlangParser.ID, 0); }
		public FractionDeclarationContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterFractionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitFractionDeclaration(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntegerDeclarationContext extends DeclarationContext {
		public TerminalNode ID() { return getToken(QlangParser.ID, 0); }
		public IntegerDeclarationContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterIntegerDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitIntegerDeclaration(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TextDeclarationContext extends DeclarationContext {
		public TerminalNode ID() { return getToken(QlangParser.ID, 0); }
		public TextDeclarationContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterTextDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitTextDeclaration(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QuestionDeclarationContext extends DeclarationContext {
		public TerminalNode ID() { return getToken(QlangParser.ID, 0); }
		public QuestionDeclarationContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterQuestionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitQuestionDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declaration);
		try {
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new QuestionDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				match(ID);
				setState(141);
				match(T__10);
				setState(142);
				match(T__11);
				}
				break;
			case 2:
				_localctx = new FractionDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				match(ID);
				setState(144);
				match(T__10);
				setState(145);
				match(T__12);
				}
				break;
			case 3:
				_localctx = new IntegerDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(146);
				match(ID);
				setState(147);
				match(T__10);
				setState(148);
				match(T__13);
				}
				break;
			case 4:
				_localctx = new TextDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(149);
				match(ID);
				setState(150);
				match(T__10);
				setState(151);
				match(T__14);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	 
		public AssignmentContext() { }
		public void copyFrom(AssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NewAssignmentContext extends AssignmentContext {
		public List<TerminalNode> ID() { return getTokens(QlangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(QlangParser.ID, i);
		}
		public NewAssignmentContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterNewAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitNewAssignment(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IDAssignmentContext extends AssignmentContext {
		public TerminalNode ID() { return getToken(QlangParser.ID, 0); }
		public ExecutionContext execution() {
			return getRuleContext(ExecutionContext.class,0);
		}
		public IDAssignmentContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterIDAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitIDAssignment(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HoleQuestionAssignmentContext extends AssignmentContext {
		public TerminalNode ID() { return getToken(QlangParser.ID, 0); }
		public TerminalNode TEXT() { return getToken(QlangParser.TEXT, 0); }
		public HoleQuestionAssignmentContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterHoleQuestionAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitHoleQuestionAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignment);
		try {
			int _alt;
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new IDAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				match(ID);
				setState(155);
				match(T__15);
				setState(156);
				execution();
				}
				break;
			case 2:
				_localctx = new NewAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				match(ID);
				setState(158);
				match(T__15);
				setState(159);
				match(T__16);
				setState(161); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(160);
						match(ID);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(163); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 3:
				_localctx = new HoleQuestionAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(165);
				match(ID);
				setState(166);
				match(T__17);
				setState(167);
				match(TEXT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExecutionContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(QlangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(QlangParser.ID, i);
		}
		public ExecutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_execution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterExecution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitExecution(this);
		}
	}

	public final ExecutionContext execution() throws RecognitionException {
		ExecutionContext _localctx = new ExecutionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_execution);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(T__18);
			setState(172); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(171);
					match(ID);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(174); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExportContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(QlangParser.ID, 0); }
		public TerminalNode TEXT() { return getToken(QlangParser.TEXT, 0); }
		public ExportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_export; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterExport(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitExport(this);
		}
	}

	public final ExportContext export() throws RecognitionException {
		ExportContext _localctx = new ExportContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_export);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(T__19);
			setState(177);
			match(ID);
			setState(178);
			match(T__20);
			setState(179);
			match(TEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CommandContext extends ParserRuleContext {
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
	 
		public CommandContext() { }
		public void copyFrom(CommandContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintSentenceContext extends CommandContext {
		public List<TerminalNode> TEXT() { return getTokens(QlangParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(QlangParser.TEXT, i);
		}
		public PrintSentenceContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterPrintSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitPrintSentence(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UsesCodeSentenceContext extends CommandContext {
		public TerminalNode TEXT() { return getToken(QlangParser.TEXT, 0); }
		public UsesCodeSentenceContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterUsesCodeSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitUsesCodeSentence(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintLineSentenceContext extends CommandContext {
		public List<TerminalNode> TEXT() { return getTokens(QlangParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(QlangParser.TEXT, i);
		}
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public PrintLineSentenceContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterPrintLineSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitPrintLineSentence(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_command);
		int _la;
		try {
			setState(198);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
				_localctx = new PrintSentenceContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				match(T__21);
				setState(183); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(182);
					match(TEXT);
					}
					}
					setState(185); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==TEXT );
				}
				break;
			case T__22:
				_localctx = new PrintLineSentenceContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(187);
				match(T__22);
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TEXT || _la==ID) {
					{
					setState(190);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case TEXT:
						{
						setState(188);
						match(TEXT);
						}
						break;
					case ID:
						{
						setState(189);
						assignment();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(194);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__23:
				_localctx = new UsesCodeSentenceContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(195);
				match(T__23);
				setState(196);
				match(TEXT);
				setState(197);
				match(T__24);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(QlangParser.ID, 0); }
		public TerminalNode Integer() { return getToken(QlangParser.Integer, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(201);
				match(ID);
				}
				break;
			case Integer:
				{
				setState(202);
				match(Integer);
				}
				break;
			case T__25:
				{
				setState(203);
				match(T__25);
				}
				break;
			case T__26:
				{
				setState(204);
				match(T__26);
				}
				break;
			case T__27:
				{
				setState(205);
				match(T__27);
				setState(206);
				expr(10);
				}
				break;
			case T__36:
				{
				setState(207);
				match(T__36);
				setState(208);
				expr(0);
				setState(209);
				match(T__37);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(239);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(237);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(213);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(214);
						match(T__28);
						setState(215);
						expr(10);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(216);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(217);
						match(T__29);
						setState(218);
						expr(9);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(219);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(220);
						match(T__30);
						setState(221);
						expr(8);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(222);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(223);
						match(T__31);
						setState(224);
						expr(7);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(225);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(226);
						match(T__32);
						setState(227);
						expr(6);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(228);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(229);
						match(T__33);
						setState(230);
						expr(5);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(231);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(232);
						match(T__34);
						setState(233);
						expr(4);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(234);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(235);
						match(T__35);
						setState(236);
						expr(3);
						}
						break;
					}
					} 
				}
				setState(241);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfLineSentenceContext extends ParserRuleContext {
		public IfBlockContext ifBlock() {
			return getRuleContext(IfBlockContext.class,0);
		}
		public List<ElseifBlockContext> elseifBlock() {
			return getRuleContexts(ElseifBlockContext.class);
		}
		public ElseifBlockContext elseifBlock(int i) {
			return getRuleContext(ElseifBlockContext.class,i);
		}
		public ElseBlockContext elseBlock() {
			return getRuleContext(ElseBlockContext.class,0);
		}
		public IfLineSentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifLineSentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterIfLineSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitIfLineSentence(this);
		}
	}

	public final IfLineSentenceContext ifLineSentence() throws RecognitionException {
		IfLineSentenceContext _localctx = new IfLineSentenceContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ifLineSentence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			ifBlock();
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__40) {
				{
				{
				setState(243);
				elseifBlock();
				}
				}
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__41) {
				{
				setState(249);
				elseBlock();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfBlockContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterIfBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitIfBlock(this);
		}
	}

	public final IfBlockContext ifBlock() throws RecognitionException {
		IfBlockContext _localctx = new IfBlockContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(T__38);
			setState(253);
			expr(0);
			setState(254);
			match(T__39);
			setState(256); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(255);
				statement();
				}
				}
				setState(258); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 140737489930196L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElseifBlockContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ElseifBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseifBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterElseifBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitElseifBlock(this);
		}
	}

	public final ElseifBlockContext elseifBlock() throws RecognitionException {
		ElseifBlockContext _localctx = new ElseifBlockContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_elseifBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(T__40);
			setState(261);
			expr(0);
			setState(262);
			match(T__39);
			setState(264); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(263);
				statement();
				}
				}
				setState(266); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 140737489930196L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElseBlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ElseBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterElseBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitElseBlock(this);
		}
	}

	public final ElseBlockContext elseBlock() throws RecognitionException {
		ElseBlockContext _localctx = new ElseBlockContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_elseBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(T__41);
			setState(270); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(269);
				statement();
				}
				}
				setState(272); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 140737489930196L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00014\u0113\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0005\u0002"+
		",\b\u0002\n\u0002\f\u0002/\t\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"3\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0005\u0004"+
		"9\b\u0004\n\u0004\f\u0004<\t\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"@\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005H\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0004\u0007Q\b\u0007"+
		"\u000b\u0007\f\u0007R\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0004\u0007[\b\u0007\u000b\u0007\f\u0007\\\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0004"+
		"\u0007e\b\u0007\u000b\u0007\f\u0007f\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007o\b\u0007\u000b\u0007"+
		"\f\u0007p\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0004\u0007y\b\u0007\u000b\u0007\f\u0007z\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007\u0083"+
		"\b\u0007\u000b\u0007\f\u0007\u0084\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u008b\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003"+
		"\b\u0099\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004"+
		"\t\u00a2\b\t\u000b\t\f\t\u00a3\u0001\t\u0001\t\u0001\t\u0003\t\u00a9\b"+
		"\t\u0001\n\u0001\n\u0004\n\u00ad\b\n\u000b\n\f\n\u00ae\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0004\f\u00b8"+
		"\b\f\u000b\f\f\f\u00b9\u0001\f\u0001\f\u0001\f\u0005\f\u00bf\b\f\n\f\f"+
		"\f\u00c2\t\f\u0001\f\u0001\f\u0001\f\u0003\f\u00c7\b\f\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0003\r\u00d4\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005"+
		"\r\u00ee\b\r\n\r\f\r\u00f1\t\r\u0001\u000e\u0001\u000e\u0005\u000e\u00f5"+
		"\b\u000e\n\u000e\f\u000e\u00f8\t\u000e\u0001\u000e\u0003\u000e\u00fb\b"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0004\u000f\u0101"+
		"\b\u000f\u000b\u000f\f\u000f\u0102\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0004\u0010\u0109\b\u0010\u000b\u0010\f\u0010\u010a\u0001"+
		"\u0011\u0001\u0011\u0004\u0011\u010f\b\u0011\u000b\u0011\f\u0011\u0110"+
		"\u0001\u0011\u0000\u0001\u001a\u0012\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"\u0000\u0000\u0132"+
		"\u0000$\u0001\u0000\u0000\u0000\u0002\'\u0001\u0000\u0000\u0000\u0004"+
		"-\u0001\u0000\u0000\u0000\u00064\u0001\u0000\u0000\u0000\b:\u0001\u0000"+
		"\u0000\u0000\nG\u0001\u0000\u0000\u0000\fI\u0001\u0000\u0000\u0000\u000e"+
		"\u008a\u0001\u0000\u0000\u0000\u0010\u0098\u0001\u0000\u0000\u0000\u0012"+
		"\u00a8\u0001\u0000\u0000\u0000\u0014\u00aa\u0001\u0000\u0000\u0000\u0016"+
		"\u00b0\u0001\u0000\u0000\u0000\u0018\u00c6\u0001\u0000\u0000\u0000\u001a"+
		"\u00d3\u0001\u0000\u0000\u0000\u001c\u00f2\u0001\u0000\u0000\u0000\u001e"+
		"\u00fc\u0001\u0000\u0000\u0000 \u0104\u0001\u0000\u0000\u0000\"\u010c"+
		"\u0001\u0000\u0000\u0000$%\u0003\u0004\u0002\u0000%&\u0005\u0000\u0000"+
		"\u0001&\u0001\u0001\u0000\u0000\u0000\'(\u0003\n\u0005\u0000()\u0005\u0001"+
		"\u0000\u0000)\u0003\u0001\u0000\u0000\u0000*,\u0003\u0002\u0001\u0000"+
		"+*\u0001\u0000\u0000\u0000,/\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000"+
		"\u0000-.\u0001\u0000\u0000\u0000.2\u0001\u0000\u0000\u0000/-\u0001\u0000"+
		"\u0000\u000003\u0003\n\u0005\u000013\u0003\u0002\u0001\u000020\u0001\u0000"+
		"\u0000\u000021\u0001\u0000\u0000\u00003\u0005\u0001\u0000\u0000\u0000"+
		"45\u0003\u0018\f\u000056\u0005\u0001\u0000\u00006\u0007\u0001\u0000\u0000"+
		"\u000079\u0003\u0006\u0003\u000087\u0001\u0000\u0000\u00009<\u0001\u0000"+
		"\u0000\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;?\u0001"+
		"\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000=@\u0003\u0018\f\u0000>@\u0003"+
		"\u0006\u0003\u0000?=\u0001\u0000\u0000\u0000?>\u0001\u0000\u0000\u0000"+
		"@\t\u0001\u0000\u0000\u0000AH\u0003\u000e\u0007\u0000BH\u0003\u0010\b"+
		"\u0000CH\u0003\u0012\t\u0000DH\u0003\u0014\n\u0000EH\u0003\u0016\u000b"+
		"\u0000FH\u0003\f\u0006\u0000GA\u0001\u0000\u0000\u0000GB\u0001\u0000\u0000"+
		"\u0000GC\u0001\u0000\u0000\u0000GD\u0001\u0000\u0000\u0000GE\u0001\u0000"+
		"\u0000\u0000GF\u0001\u0000\u0000\u0000H\u000b\u0001\u0000\u0000\u0000"+
		"IJ\u0005\u0002\u0000\u0000JK\u0005/\u0000\u0000KL\u0005\u0003\u0000\u0000"+
		"LM\u0005-\u0000\u0000M\r\u0001\u0000\u0000\u0000NP\u0005\u0004\u0000\u0000"+
		"OQ\u0005/\u0000\u0000PO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000"+
		"RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000"+
		"\u0000TU\u0005\u0003\u0000\u0000UV\u0003\b\u0004\u0000VW\u0005\u0005\u0000"+
		"\u0000W\u008b\u0001\u0000\u0000\u0000XZ\u0005\u0006\u0000\u0000Y[\u0005"+
		"/\u0000\u0000ZY\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\Z"+
		"\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000"+
		"\u0000^_\u0005\u0003\u0000\u0000_`\u0003\b\u0004\u0000`a\u0005\u0005\u0000"+
		"\u0000a\u008b\u0001\u0000\u0000\u0000bd\u0005\u0007\u0000\u0000ce\u0005"+
		"/\u0000\u0000dc\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fd\u0001"+
		"\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000"+
		"hi\u0005\u0003\u0000\u0000ij\u0003\b\u0004\u0000jk\u0005\u0005\u0000\u0000"+
		"k\u008b\u0001\u0000\u0000\u0000ln\u0005\b\u0000\u0000mo\u0005/\u0000\u0000"+
		"nm\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000"+
		"\u0000pq\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rs\u0005\u0003"+
		"\u0000\u0000st\u0003\b\u0004\u0000tu\u0005\u0005\u0000\u0000u\u008b\u0001"+
		"\u0000\u0000\u0000vx\u0005\t\u0000\u0000wy\u0005/\u0000\u0000xw\u0001"+
		"\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000"+
		"z{\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|}\u0005\u0003\u0000"+
		"\u0000}~\u0003\b\u0004\u0000~\u007f\u0005\u0005\u0000\u0000\u007f\u008b"+
		"\u0001\u0000\u0000\u0000\u0080\u0082\u0005\n\u0000\u0000\u0081\u0083\u0005"+
		"/\u0000\u0000\u0082\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000"+
		"\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000"+
		"\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0087\u0005\u0003"+
		"\u0000\u0000\u0087\u0088\u0003\b\u0004\u0000\u0088\u0089\u0005\u0005\u0000"+
		"\u0000\u0089\u008b\u0001\u0000\u0000\u0000\u008aN\u0001\u0000\u0000\u0000"+
		"\u008aX\u0001\u0000\u0000\u0000\u008ab\u0001\u0000\u0000\u0000\u008al"+
		"\u0001\u0000\u0000\u0000\u008av\u0001\u0000\u0000\u0000\u008a\u0080\u0001"+
		"\u0000\u0000\u0000\u008b\u000f\u0001\u0000\u0000\u0000\u008c\u008d\u0005"+
		"/\u0000\u0000\u008d\u008e\u0005\u000b\u0000\u0000\u008e\u0099\u0005\f"+
		"\u0000\u0000\u008f\u0090\u0005/\u0000\u0000\u0090\u0091\u0005\u000b\u0000"+
		"\u0000\u0091\u0099\u0005\r\u0000\u0000\u0092\u0093\u0005/\u0000\u0000"+
		"\u0093\u0094\u0005\u000b\u0000\u0000\u0094\u0099\u0005\u000e\u0000\u0000"+
		"\u0095\u0096\u0005/\u0000\u0000\u0096\u0097\u0005\u000b\u0000\u0000\u0097"+
		"\u0099\u0005\u000f\u0000\u0000\u0098\u008c\u0001\u0000\u0000\u0000\u0098"+
		"\u008f\u0001\u0000\u0000\u0000\u0098\u0092\u0001\u0000\u0000\u0000\u0098"+
		"\u0095\u0001\u0000\u0000\u0000\u0099\u0011\u0001\u0000\u0000\u0000\u009a"+
		"\u009b\u0005/\u0000\u0000\u009b\u009c\u0005\u0010\u0000\u0000\u009c\u00a9"+
		"\u0003\u0014\n\u0000\u009d\u009e\u0005/\u0000\u0000\u009e\u009f\u0005"+
		"\u0010\u0000\u0000\u009f\u00a1\u0005\u0011\u0000\u0000\u00a0\u00a2\u0005"+
		"/\u0000\u0000\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a9\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005/\u0000"+
		"\u0000\u00a6\u00a7\u0005\u0012\u0000\u0000\u00a7\u00a9\u0005.\u0000\u0000"+
		"\u00a8\u009a\u0001\u0000\u0000\u0000\u00a8\u009d\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a5\u0001\u0000\u0000\u0000\u00a9\u0013\u0001\u0000\u0000\u0000"+
		"\u00aa\u00ac\u0005\u0013\u0000\u0000\u00ab\u00ad\u0005/\u0000\u0000\u00ac"+
		"\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae"+
		"\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af"+
		"\u0015\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005\u0014\u0000\u0000\u00b1"+
		"\u00b2\u0005/\u0000\u0000\u00b2\u00b3\u0005\u0015\u0000\u0000\u00b3\u00b4"+
		"\u0005.\u0000\u0000\u00b4\u0017\u0001\u0000\u0000\u0000\u00b5\u00b7\u0005"+
		"\u0016\u0000\u0000\u00b6\u00b8\u0005.\u0000\u0000\u00b7\u00b6\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000"+
		"\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00c7\u0001\u0000"+
		"\u0000\u0000\u00bb\u00c0\u0005\u0017\u0000\u0000\u00bc\u00bf\u0005.\u0000"+
		"\u0000\u00bd\u00bf\u0003\u0012\t\u0000\u00be\u00bc\u0001\u0000\u0000\u0000"+
		"\u00be\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c0\u00be\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000"+
		"\u00c1\u00c7\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000"+
		"\u00c3\u00c4\u0005\u0018\u0000\u0000\u00c4\u00c5\u0005.\u0000\u0000\u00c5"+
		"\u00c7\u0005\u0019\u0000\u0000\u00c6\u00b5\u0001\u0000\u0000\u0000\u00c6"+
		"\u00bb\u0001\u0000\u0000\u0000\u00c6\u00c3\u0001\u0000\u0000\u0000\u00c7"+
		"\u0019\u0001\u0000\u0000\u0000\u00c8\u00c9\u0006\r\uffff\uffff\u0000\u00c9"+
		"\u00d4\u0005/\u0000\u0000\u00ca\u00d4\u00050\u0000\u0000\u00cb\u00d4\u0005"+
		"\u001a\u0000\u0000\u00cc\u00d4\u0005\u001b\u0000\u0000\u00cd\u00ce\u0005"+
		"\u001c\u0000\u0000\u00ce\u00d4\u0003\u001a\r\n\u00cf\u00d0\u0005%\u0000"+
		"\u0000\u00d0\u00d1\u0003\u001a\r\u0000\u00d1\u00d2\u0005&\u0000\u0000"+
		"\u00d2\u00d4\u0001\u0000\u0000\u0000\u00d3\u00c8\u0001\u0000\u0000\u0000"+
		"\u00d3\u00ca\u0001\u0000\u0000\u0000\u00d3\u00cb\u0001\u0000\u0000\u0000"+
		"\u00d3\u00cc\u0001\u0000\u0000\u0000\u00d3\u00cd\u0001\u0000\u0000\u0000"+
		"\u00d3\u00cf\u0001\u0000\u0000\u0000\u00d4\u00ef\u0001\u0000\u0000\u0000"+
		"\u00d5\u00d6\n\t\u0000\u0000\u00d6\u00d7\u0005\u001d\u0000\u0000\u00d7"+
		"\u00ee\u0003\u001a\r\n\u00d8\u00d9\n\b\u0000\u0000\u00d9\u00da\u0005\u001e"+
		"\u0000\u0000\u00da\u00ee\u0003\u001a\r\t\u00db\u00dc\n\u0007\u0000\u0000"+
		"\u00dc\u00dd\u0005\u001f\u0000\u0000\u00dd\u00ee\u0003\u001a\r\b\u00de"+
		"\u00df\n\u0006\u0000\u0000\u00df\u00e0\u0005 \u0000\u0000\u00e0\u00ee"+
		"\u0003\u001a\r\u0007\u00e1\u00e2\n\u0005\u0000\u0000\u00e2\u00e3\u0005"+
		"!\u0000\u0000\u00e3\u00ee\u0003\u001a\r\u0006\u00e4\u00e5\n\u0004\u0000"+
		"\u0000\u00e5\u00e6\u0005\"\u0000\u0000\u00e6\u00ee\u0003\u001a\r\u0005"+
		"\u00e7\u00e8\n\u0003\u0000\u0000\u00e8\u00e9\u0005#\u0000\u0000\u00e9"+
		"\u00ee\u0003\u001a\r\u0004\u00ea\u00eb\n\u0002\u0000\u0000\u00eb\u00ec"+
		"\u0005$\u0000\u0000\u00ec\u00ee\u0003\u001a\r\u0003\u00ed\u00d5\u0001"+
		"\u0000\u0000\u0000\u00ed\u00d8\u0001\u0000\u0000\u0000\u00ed\u00db\u0001"+
		"\u0000\u0000\u0000\u00ed\u00de\u0001\u0000\u0000\u0000\u00ed\u00e1\u0001"+
		"\u0000\u0000\u0000\u00ed\u00e4\u0001\u0000\u0000\u0000\u00ed\u00e7\u0001"+
		"\u0000\u0000\u0000\u00ed\u00ea\u0001\u0000\u0000\u0000\u00ee\u00f1\u0001"+
		"\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001"+
		"\u0000\u0000\u0000\u00f0\u001b\u0001\u0000\u0000\u0000\u00f1\u00ef\u0001"+
		"\u0000\u0000\u0000\u00f2\u00f6\u0003\u001e\u000f\u0000\u00f3\u00f5\u0003"+
		" \u0010\u0000\u00f4\u00f3\u0001\u0000\u0000\u0000\u00f5\u00f8\u0001\u0000"+
		"\u0000\u0000\u00f6\u00f4\u0001\u0000\u0000\u0000\u00f6\u00f7\u0001\u0000"+
		"\u0000\u0000\u00f7\u00fa\u0001\u0000\u0000\u0000\u00f8\u00f6\u0001\u0000"+
		"\u0000\u0000\u00f9\u00fb\u0003\"\u0011\u0000\u00fa\u00f9\u0001\u0000\u0000"+
		"\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb\u001d\u0001\u0000\u0000"+
		"\u0000\u00fc\u00fd\u0005\'\u0000\u0000\u00fd\u00fe\u0003\u001a\r\u0000"+
		"\u00fe\u0100\u0005(\u0000\u0000\u00ff\u0101\u0003\n\u0005\u0000\u0100"+
		"\u00ff\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000\u0000\u0000\u0102"+
		"\u0100\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103"+
		"\u001f\u0001\u0000\u0000\u0000\u0104\u0105\u0005)\u0000\u0000\u0105\u0106"+
		"\u0003\u001a\r\u0000\u0106\u0108\u0005(\u0000\u0000\u0107\u0109\u0003"+
		"\n\u0005\u0000\u0108\u0107\u0001\u0000\u0000\u0000\u0109\u010a\u0001\u0000"+
		"\u0000\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000"+
		"\u0000\u0000\u010b!\u0001\u0000\u0000\u0000\u010c\u010e\u0005*\u0000\u0000"+
		"\u010d\u010f\u0003\n\u0005\u0000\u010e\u010d\u0001\u0000\u0000\u0000\u010f"+
		"\u0110\u0001\u0000\u0000\u0000\u0110\u010e\u0001\u0000\u0000\u0000\u0110"+
		"\u0111\u0001\u0000\u0000\u0000\u0111#\u0001\u0000\u0000\u0000\u001c-2"+
		":?GR\\fpz\u0084\u008a\u0098\u00a3\u00a8\u00ae\u00b9\u00be\u00c0\u00c6"+
		"\u00d3\u00ed\u00ef\u00f6\u00fa\u0102\u010a\u0110";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}