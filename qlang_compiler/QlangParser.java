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
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, NEW=44, QUESTIONTYPES=45, 
		VARIABLETYPES=46, ANDTHEN=47, ORELSE=48, OPEN_BRACKETS=49, CLOSE_BRACKETS=50, 
		VERBATIMOPEN=51, VERBATIMCLOSE=52, PIL=53, TEXT=54, ID=55, Integer=56, 
		SKIPPING=57, NEWLINE=58, BLOCKCOMMENT=59, SINGLECOMMENT=60, ERROR=61;
	public static final int
		RULE_statList = 0, RULE_statementWithBreak = 1, RULE_statementComposition = 2, 
		RULE_commandWithBreak = 3, RULE_commandComposition = 4, RULE_idset = 5, 
		RULE_statement = 6, RULE_newQuestion = 7, RULE_declaration = 8, RULE_code = 9, 
		RULE_assignment = 10, RULE_execution = 11, RULE_export = 12, RULE_command = 13, 
		RULE_codeholeComposition = 14, RULE_codeholeWithBreak = 15, RULE_codehole = 16, 
		RULE_expr = 17, RULE_ifLineSentence = 18, RULE_ifBlock = 19, RULE_elseifBlock = 20, 
		RULE_elseBlock = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"statList", "statementWithBreak", "statementComposition", "commandWithBreak", 
			"commandComposition", "idset", "statement", "newQuestion", "declaration", 
			"code", "assignment", "execution", "export", "command", "codeholeComposition", 
			"codeholeWithBreak", "codehole", "expr", "ifLineSentence", "ifBlock", 
			"elseifBlock", "elseBlock"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'.'", "'is'", "'end'", "':'", "'code'", "':='", "'->'", 
			"'execute'", "','", "'export'", "'to'", "'print'", "'println'", "'|program'", 
			"'uses code from'", "'uses code'", "'choice'", "'line'", "'('", "')'", 
			"'|'", "'-'", "'+'", "'not'", "'*'", "'%'", "'='", "'>='", "'<='", "'>'", 
			"'<'", "'/='", "'and'", "'or'", "'xor'", "'implies'", "'/'", "'read'", 
			"'if'", "'then'", "'elseif'", "'else'", "'new'", null, null, "'and then'", 
			"'or else'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "NEW", "QUESTIONTYPES", 
			"VARIABLETYPES", "ANDTHEN", "ORELSE", "OPEN_BRACKETS", "CLOSE_BRACKETS", 
			"VERBATIMOPEN", "VERBATIMCLOSE", "PIL", "TEXT", "ID", "Integer", "SKIPPING", 
			"NEWLINE", "BLOCKCOMMENT", "SINGLECOMMENT", "ERROR"
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitStatList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatListContext statList() throws RecognitionException {
		StatListContext _localctx = new StatListContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_statList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			statementComposition();
			setState(45);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitStatementWithBreak(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementWithBreakContext statementWithBreak() throws RecognitionException {
		StatementWithBreakContext _localctx = new StatementWithBreakContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statementWithBreak);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(47);
			statement();
			setState(48);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitStatementComposition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementCompositionContext statementComposition() throws RecognitionException {
		StatementCompositionContext _localctx = new StatementCompositionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statementComposition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(50);
					statementWithBreak();
					}
					} 
				}
				setState(55);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(58);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(56);
				statement();
				}
				break;
			case 2:
				{
				setState(57);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitCommandWithBreak(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandWithBreakContext commandWithBreak() throws RecognitionException {
		CommandWithBreakContext _localctx = new CommandWithBreakContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_commandWithBreak);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(60);
			command();
			setState(61);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitCommandComposition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandCompositionContext commandComposition() throws RecognitionException {
		CommandCompositionContext _localctx = new CommandCompositionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_commandComposition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(63);
					commandWithBreak();
					}
					} 
				}
				setState(68);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(69);
				command();
				}
				break;
			case 2:
				{
				setState(70);
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
	public static class IdsetContext extends ParserRuleContext {
		public IdsetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idset; }
	 
		public IdsetContext() { }
		public void copyFrom(IdsetContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IDSetCompositionContext extends IdsetContext {
		public TerminalNode ID() { return getToken(QlangParser.ID, 0); }
		public IdsetContext idset() {
			return getRuleContext(IdsetContext.class,0);
		}
		public IDSetCompositionContext(IdsetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterIDSetComposition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitIDSetComposition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitIDSetComposition(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IDSetTerminalContext extends IdsetContext {
		public TerminalNode ID() { return getToken(QlangParser.ID, 0); }
		public IDSetTerminalContext(IdsetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterIDSetTerminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitIDSetTerminal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitIDSetTerminal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdsetContext idset() throws RecognitionException {
		IdsetContext _localctx = new IdsetContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_idset);
		try {
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new IDSetTerminalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				match(ID);
				}
				break;
			case 2:
				_localctx = new IDSetCompositionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				match(ID);
				setState(75);
				match(T__1);
				setState(76);
				idset();
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
	public static class StatementCommandContext extends StatementContext {
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public StatementCommandContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterStatementCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitStatementCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitStatementCommand(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitStatementExecution(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementIfLineSentenceContext extends StatementContext {
		public IfLineSentenceContext ifLineSentence() {
			return getRuleContext(IfLineSentenceContext.class,0);
		}
		public StatementIfLineSentenceContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterStatementIfLineSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitStatementIfLineSentence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitStatementIfLineSentence(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitStatementDeclaration(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitStatemtentAssignment(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitStatementCode(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitStatementExport(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitStatementQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement);
		try {
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new StatementQuestionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				newQuestion();
				}
				break;
			case 2:
				_localctx = new StatementDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				declaration();
				}
				break;
			case 3:
				_localctx = new StatemtentAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				assignment();
				}
				break;
			case 4:
				_localctx = new StatementExecutionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(82);
				execution();
				}
				break;
			case 5:
				_localctx = new StatementExportContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(83);
				export();
				}
				break;
			case 6:
				_localctx = new StatementCodeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(84);
				code();
				}
				break;
			case 7:
				_localctx = new StatementCommandContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(85);
				command();
				}
				break;
			case 8:
				_localctx = new StatementIfLineSentenceContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(86);
				ifLineSentence();
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
	public static class NewQuestionContext extends ParserRuleContext {
		public TerminalNode QUESTIONTYPES() { return getToken(QlangParser.QUESTIONTYPES, 0); }
		public IdsetContext idset() {
			return getRuleContext(IdsetContext.class,0);
		}
		public CommandCompositionContext commandComposition() {
			return getRuleContext(CommandCompositionContext.class,0);
		}
		public NewQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterNewQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitNewQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitNewQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewQuestionContext newQuestion() throws RecognitionException {
		NewQuestionContext _localctx = new NewQuestionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_newQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(QUESTIONTYPES);
			setState(90);
			idset();
			setState(91);
			match(T__2);
			setState(92);
			commandComposition();
			setState(93);
			match(T__3);
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
		public IdsetContext idset() {
			return getRuleContext(IdsetContext.class,0);
		}
		public TerminalNode VARIABLETYPES() { return getToken(QlangParser.VARIABLETYPES, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			idset();
			setState(96);
			match(T__4);
			setState(97);
			_la = _input.LA(1);
			if ( !(_la==T__5 || _la==VARIABLETYPES) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class CodeContext extends ParserRuleContext {
		public IdsetContext idset() {
			return getRuleContext(IdsetContext.class,0);
		}
		public List<TerminalNode> PIL() { return getTokens(QlangParser.PIL); }
		public TerminalNode PIL(int i) {
			return getToken(QlangParser.PIL, i);
		}
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_code);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__5);
			setState(100);
			idset();
			setState(101);
			match(T__2);
			setState(106); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(102);
				match(PIL);
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(103);
					assignment();
					}
				}

				}
				}
				setState(108); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PIL );
			setState(110);
			match(T__3);
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
		public List<IdsetContext> idset() {
			return getRuleContexts(IdsetContext.class);
		}
		public IdsetContext idset(int i) {
			return getRuleContext(IdsetContext.class,i);
		}
		public TerminalNode NEW() { return getToken(QlangParser.NEW, 0); }
		public NewAssignmentContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterNewAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitNewAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitNewAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IDAssignmentContext extends AssignmentContext {
		public IdsetContext idset() {
			return getRuleContext(IdsetContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitIDAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HoleQuestionAssignmentContext extends AssignmentContext {
		public IdsetContext idset() {
			return getRuleContext(IdsetContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public HoleQuestionAssignmentContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterHoleQuestionAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitHoleQuestionAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitHoleQuestionAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assignment);
		try {
			setState(125);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new IDAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				idset();
				setState(113);
				match(T__6);
				setState(114);
				expr(0);
				}
				break;
			case 2:
				_localctx = new NewAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				idset();
				setState(117);
				match(T__6);
				setState(118);
				match(NEW);
				setState(119);
				idset();
				}
				break;
			case 3:
				_localctx = new HoleQuestionAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(121);
				idset();
				setState(122);
				match(T__7);
				setState(123);
				expr(0);
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
		public Type eType;
		public IdsetContext idset() {
			return getRuleContext(IdsetContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEW() { return getToken(QlangParser.NEW, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitExecution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExecutionContext execution() throws RecognitionException {
		ExecutionContext _localctx = new ExecutionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_execution);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(T__8);
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(128);
				expr(0);
				setState(129);
				match(T__9);
				}
				break;
			}
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEW) {
				{
				setState(133);
				match(NEW);
				}
			}

			setState(136);
			idset();
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
		public IdsetContext idset() {
			return getRuleContext(IdsetContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitExport(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExportContext export() throws RecognitionException {
		ExportContext _localctx = new ExportContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_export);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__10);
			setState(139);
			idset();
			setState(140);
			match(T__11);
			setState(141);
			expr(0);
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
	public static class ChoiceCommandContext extends CommandContext {
		public TerminalNode TEXT() { return getToken(QlangParser.TEXT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ChoiceCommandContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterChoiceCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitChoiceCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitChoiceCommand(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExecutionCommandContext extends CommandContext {
		public ExecutionContext execution() {
			return getRuleContext(ExecutionContext.class,0);
		}
		public ExecutionCommandContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterExecutionCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitExecutionCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitExecutionCommand(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfLineSentenceCommandContext extends CommandContext {
		public IfLineSentenceContext ifLineSentence() {
			return getRuleContext(IfLineSentenceContext.class,0);
		}
		public IfLineSentenceCommandContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterIfLineSentenceCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitIfLineSentenceCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitIfLineSentenceCommand(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintSentenceContext extends CommandContext {
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitPrintSentence(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentCommandContext extends CommandContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public AssignmentCommandContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterAssignmentCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitAssignmentCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitAssignmentCommand(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UsesCodeSentenceContext extends CommandContext {
		public TerminalNode TEXT() { return getToken(QlangParser.TEXT, 0); }
		public CodeholeCompositionContext codeholeComposition() {
			return getRuleContext(CodeholeCompositionContext.class,0);
		}
		public UsesCodeSentenceContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterUsesCodeSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitUsesCodeSentence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitUsesCodeSentence(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationCommandContext extends CommandContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public DeclarationCommandContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterDeclarationCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitDeclarationCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitDeclarationCommand(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintLineSentenceContext extends CommandContext {
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitPrintLineSentence(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UsesCodeDefinedContext extends CommandContext {
		public IdsetContext idset() {
			return getRuleContext(IdsetContext.class,0);
		}
		public CodeholeCompositionContext codeholeComposition() {
			return getRuleContext(CodeholeCompositionContext.class,0);
		}
		public UsesCodeDefinedContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterUsesCodeDefined(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitUsesCodeDefined(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitUsesCodeDefined(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_command);
		int _la;
		try {
			int _alt;
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new PrintSentenceContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				match(T__12);
				setState(146); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						setState(146);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
						case 1:
							{
							setState(144);
							assignment();
							}
							break;
						case 2:
							{
							setState(145);
							expr(0);
							}
							break;
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(148); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				_localctx = new PrintLineSentenceContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				match(T__13);
				setState(158); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(153);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
						case 1:
							{
							setState(151);
							assignment();
							}
							break;
						case 2:
							{
							setState(152);
							expr(0);
							}
							break;
						}
						setState(156);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==T__14) {
							{
							setState(155);
							match(T__14);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(160); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 3:
				_localctx = new UsesCodeSentenceContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(162);
				match(T__15);
				setState(163);
				match(TEXT);
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 126100789566373888L) != 0)) {
					{
					setState(164);
					codeholeComposition();
					}
				}

				setState(167);
				match(T__3);
				}
				break;
			case 4:
				_localctx = new UsesCodeDefinedContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(168);
				match(T__16);
				setState(169);
				idset();
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 126100789566373888L) != 0)) {
					{
					setState(170);
					codeholeComposition();
					}
				}

				setState(173);
				match(T__3);
				}
				break;
			case 5:
				_localctx = new ChoiceCommandContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(175);
				match(T__17);
				setState(179);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(176);
					expr(0);
					setState(177);
					match(T__9);
					}
					break;
				}
				setState(181);
				match(TEXT);
				setState(182);
				match(T__3);
				}
				break;
			case 6:
				_localctx = new ExecutionCommandContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(183);
				execution();
				}
				break;
			case 7:
				_localctx = new IfLineSentenceCommandContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(184);
				ifLineSentence();
				}
				break;
			case 8:
				_localctx = new AssignmentCommandContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(185);
				assignment();
				}
				break;
			case 9:
				_localctx = new DeclarationCommandContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(186);
				declaration();
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
	public static class CodeholeCompositionContext extends ParserRuleContext {
		public CodeholeContext codehole() {
			return getRuleContext(CodeholeContext.class,0);
		}
		public List<CodeholeWithBreakContext> codeholeWithBreak() {
			return getRuleContexts(CodeholeWithBreakContext.class);
		}
		public CodeholeWithBreakContext codeholeWithBreak(int i) {
			return getRuleContext(CodeholeWithBreakContext.class,i);
		}
		public CodeholeCompositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeholeComposition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterCodeholeComposition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitCodeholeComposition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitCodeholeComposition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeholeCompositionContext codeholeComposition() throws RecognitionException {
		CodeholeCompositionContext _localctx = new CodeholeCompositionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_codeholeComposition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(189);
					codeholeWithBreak();
					}
					} 
				}
				setState(194);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(195);
				codehole();
				}
				break;
			case 2:
				{
				setState(196);
				codeholeWithBreak();
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
	public static class CodeholeWithBreakContext extends ParserRuleContext {
		public CodeholeContext codehole() {
			return getRuleContext(CodeholeContext.class,0);
		}
		public CodeholeWithBreakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeholeWithBreak; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterCodeholeWithBreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitCodeholeWithBreak(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitCodeholeWithBreak(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeholeWithBreakContext codeholeWithBreak() throws RecognitionException {
		CodeholeWithBreakContext _localctx = new CodeholeWithBreakContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_codeholeWithBreak);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(199);
			codehole();
			setState(200);
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
	public static class CodeholeContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(QlangParser.TEXT, 0); }
		public IdsetContext idset() {
			return getRuleContext(IdsetContext.class,0);
		}
		public List<TerminalNode> Integer() { return getTokens(QlangParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(QlangParser.Integer, i);
		}
		public CodeholeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codehole; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterCodehole(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitCodehole(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitCodehole(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeholeContext codehole() throws RecognitionException {
		CodeholeContext _localctx = new CodeholeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_codehole);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(202);
				match(Integer);
				setState(203);
				match(T__9);
				}
				break;
			}
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Integer) {
				{
				setState(206);
				match(Integer);
				setState(207);
				match(T__9);
				}
			}

			setState(212);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXT:
				{
				setState(210);
				match(TEXT);
				}
				break;
			case ID:
				{
				setState(211);
				idset();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(214);
				match(T__18);
				setState(215);
				match(Integer);
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
	public static class ExprContext extends ParserRuleContext {
		public Type eType;
		public String varName;
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this.eType = ctx.eType;
			this.varName = ctx.varName;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValueExprContext extends ExprContext {
		public List<TerminalNode> Integer() { return getTokens(QlangParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(QlangParser.Integer, i);
		}
		public ValueExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterValueExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitValueExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitValueExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IDExprContext extends ExprContext {
		public IdsetContext idset() {
			return getRuleContext(IdsetContext.class,0);
		}
		public IDExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterIDExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitIDExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitIDExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesisExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenthesisExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterParenthesisExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitParenthesisExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitParenthesisExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TextExprContext extends ExprContext {
		public TerminalNode TEXT() { return getToken(QlangParser.TEXT, 0); }
		public TextExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterTextExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitTextExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitTextExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExecutionExprContext extends ExprContext {
		public ExecutionContext execution() {
			return getRuleContext(ExecutionContext.class,0);
		}
		public ExecutionExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterExecutionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitExecutionExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitExecutionExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprBinaryLogicalContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ANDTHEN() { return getToken(QlangParser.ANDTHEN, 0); }
		public TerminalNode ORELSE() { return getToken(QlangParser.ORELSE, 0); }
		public ExprBinaryLogicalContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterExprBinaryLogical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitExprBinaryLogical(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitExprBinaryLogical(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StdoutExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public StdoutExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterStdoutExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitStdoutExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitStdoutExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeExprContext extends ExprContext {
		public TerminalNode VARIABLETYPES() { return getToken(QlangParser.VARIABLETYPES, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TypeExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterTypeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitTypeExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitTypeExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitUnaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprMultDivModContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprMultDivModContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterExprMultDivMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitExprMultDivMod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitExprMultDivMod(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReadExprContext extends ExprContext {
		public TerminalNode TEXT() { return getToken(QlangParser.TEXT, 0); }
		public ReadExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterReadExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitReadExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitReadExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAddMinusContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprAddMinusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterExprAddMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitExprAddMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitExprAddMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprBinaryRelationalContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprBinaryRelationalContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterExprBinaryRelational(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitExprBinaryRelational(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitExprBinaryRelational(this);
			else return visitor.visitChildren(this);
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
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
				{
				_localctx = new ParenthesisExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(219);
				match(T__19);
				setState(220);
				expr(0);
				setState(221);
				match(T__20);
				}
				break;
			case T__22:
			case T__23:
			case T__24:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(223);
				((UnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 58720256L) != 0)) ) {
					((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(224);
				expr(11);
				}
				break;
			case Integer:
				{
				_localctx = new ValueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(225);
				match(Integer);
				{
				setState(228);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(226);
					match(T__37);
					setState(227);
					match(Integer);
					}
					break;
				}
				}
				}
				break;
			case ID:
				{
				_localctx = new IDExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				idset();
				}
				break;
			case TEXT:
				{
				_localctx = new TextExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(231);
				match(TEXT);
				}
				break;
			case VARIABLETYPES:
				{
				_localctx = new TypeExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(232);
				match(VARIABLETYPES);
				setState(233);
				match(T__19);
				setState(234);
				expr(0);
				setState(235);
				match(T__20);
				}
				break;
			case T__38:
				{
				_localctx = new ReadExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(237);
				match(T__38);
				setState(238);
				match(TEXT);
				}
				break;
			case T__8:
				{
				_localctx = new ExecutionExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(239);
				execution();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(259);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(257);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new StdoutExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(242);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(243);
						match(T__21);
						setState(244);
						expr(13);
						}
						break;
					case 2:
						{
						_localctx = new ExprMultDivModContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(245);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(246);
						((ExprMultDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 201326624L) != 0)) ) {
							((ExprMultDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(247);
						expr(11);
						}
						break;
					case 3:
						{
						_localctx = new ExprAddMinusContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(248);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(249);
						((ExprAddMinusContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__22 || _la==T__23) ) {
							((ExprAddMinusContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(250);
						expr(10);
						}
						break;
					case 4:
						{
						_localctx = new ExprBinaryRelationalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(251);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(252);
						((ExprBinaryRelationalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16911433728L) != 0)) ) {
							((ExprBinaryRelationalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(253);
						expr(9);
						}
						break;
					case 5:
						{
						_localctx = new ExprBinaryLogicalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(254);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(255);
						((ExprBinaryLogicalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 422470163103744L) != 0)) ) {
							((ExprBinaryLogicalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(256);
						expr(8);
						}
						break;
					}
					} 
				}
				setState(261);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitIfLineSentence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfLineSentenceContext ifLineSentence() throws RecognitionException {
		IfLineSentenceContext _localctx = new IfLineSentenceContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_ifLineSentence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			ifBlock();
			setState(266);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__41) {
				{
				{
				setState(263);
				elseifBlock();
				}
				}
				setState(268);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__42) {
				{
				setState(269);
				elseBlock();
				}
			}

			setState(272);
			match(T__3);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitIfBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfBlockContext ifBlock() throws RecognitionException {
		IfBlockContext _localctx = new IfBlockContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_ifBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(T__39);
			setState(275);
			expr(0);
			setState(276);
			match(T__40);
			setState(278); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(277);
				statement();
				}
				}
				setState(280); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 36065080903166528L) != 0) );
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitElseifBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseifBlockContext elseifBlock() throws RecognitionException {
		ElseifBlockContext _localctx = new ElseifBlockContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_elseifBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			match(T__41);
			setState(283);
			expr(0);
			setState(284);
			match(T__40);
			setState(286); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(285);
				statement();
				}
				}
				setState(288); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 36065080903166528L) != 0) );
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QlangVisitor ) return ((QlangVisitor<? extends T>)visitor).visitElseBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseBlockContext elseBlock() throws RecognitionException {
		ElseBlockContext _localctx = new ElseBlockContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_elseBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(T__42);
			setState(292); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(291);
				statement();
				}
				}
				setState(294); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 36065080903166528L) != 0) );
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
		case 17:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001=\u0129\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0005\u00024\b\u0002\n\u0002\f\u00027\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002;\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0005\u0004A\b\u0004\n\u0004\f\u0004D\t\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004H\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005N\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"X\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\ti\b\t\u0004\tk\b\t\u000b\t\f\tl\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0003\n~\b\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u0084\b\u000b\u0001\u000b\u0003\u000b\u0087"+
		"\b\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0004\r\u0093\b\r\u000b\r\f\r\u0094\u0001\r"+
		"\u0001\r\u0001\r\u0003\r\u009a\b\r\u0001\r\u0003\r\u009d\b\r\u0004\r\u009f"+
		"\b\r\u000b\r\f\r\u00a0\u0001\r\u0001\r\u0001\r\u0003\r\u00a6\b\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0003\r\u00ac\b\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u00b4\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0003\r\u00bc\b\r\u0001\u000e\u0005\u000e\u00bf\b\u000e\n\u000e"+
		"\f\u000e\u00c2\t\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00c6\b\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u00cd\b\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00d1\b\u0010\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u00d5\b\u0010\u0001\u0010\u0001\u0010\u0003"+
		"\u0010\u00d9\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003"+
		"\u0011\u00e5\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003"+
		"\u0011\u00f1\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u0102"+
		"\b\u0011\n\u0011\f\u0011\u0105\t\u0011\u0001\u0012\u0001\u0012\u0005\u0012"+
		"\u0109\b\u0012\n\u0012\f\u0012\u010c\t\u0012\u0001\u0012\u0003\u0012\u010f"+
		"\b\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0004\u0013\u0117\b\u0013\u000b\u0013\f\u0013\u0118\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0004\u0014\u011f\b\u0014\u000b\u0014"+
		"\f\u0014\u0120\u0001\u0015\u0001\u0015\u0004\u0015\u0125\b\u0015\u000b"+
		"\u0015\f\u0015\u0126\u0001\u0015\u0000\u0001\"\u0016\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*\u0000\u0006\u0002\u0000\u0006\u0006..\u0001\u0000\u0017\u0019\u0002"+
		"\u0000\u0005\u0005\u001a\u001b\u0001\u0000\u0017\u0018\u0001\u0000\u001c"+
		"!\u0002\u0000\"%/0\u014c\u0000,\u0001\u0000\u0000\u0000\u0002/\u0001\u0000"+
		"\u0000\u0000\u00045\u0001\u0000\u0000\u0000\u0006<\u0001\u0000\u0000\u0000"+
		"\bB\u0001\u0000\u0000\u0000\nM\u0001\u0000\u0000\u0000\fW\u0001\u0000"+
		"\u0000\u0000\u000eY\u0001\u0000\u0000\u0000\u0010_\u0001\u0000\u0000\u0000"+
		"\u0012c\u0001\u0000\u0000\u0000\u0014}\u0001\u0000\u0000\u0000\u0016\u007f"+
		"\u0001\u0000\u0000\u0000\u0018\u008a\u0001\u0000\u0000\u0000\u001a\u00bb"+
		"\u0001\u0000\u0000\u0000\u001c\u00c0\u0001\u0000\u0000\u0000\u001e\u00c7"+
		"\u0001\u0000\u0000\u0000 \u00cc\u0001\u0000\u0000\u0000\"\u00f0\u0001"+
		"\u0000\u0000\u0000$\u0106\u0001\u0000\u0000\u0000&\u0112\u0001\u0000\u0000"+
		"\u0000(\u011a\u0001\u0000\u0000\u0000*\u0122\u0001\u0000\u0000\u0000,"+
		"-\u0003\u0004\u0002\u0000-.\u0005\u0000\u0000\u0001.\u0001\u0001\u0000"+
		"\u0000\u0000/0\u0003\f\u0006\u000001\u0005\u0001\u0000\u00001\u0003\u0001"+
		"\u0000\u0000\u000024\u0003\u0002\u0001\u000032\u0001\u0000\u0000\u0000"+
		"47\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000056\u0001\u0000\u0000"+
		"\u00006:\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u00008;\u0003\f\u0006"+
		"\u00009;\u0003\u0002\u0001\u0000:8\u0001\u0000\u0000\u0000:9\u0001\u0000"+
		"\u0000\u0000;\u0005\u0001\u0000\u0000\u0000<=\u0003\u001a\r\u0000=>\u0005"+
		"\u0001\u0000\u0000>\u0007\u0001\u0000\u0000\u0000?A\u0003\u0006\u0003"+
		"\u0000@?\u0001\u0000\u0000\u0000AD\u0001\u0000\u0000\u0000B@\u0001\u0000"+
		"\u0000\u0000BC\u0001\u0000\u0000\u0000CG\u0001\u0000\u0000\u0000DB\u0001"+
		"\u0000\u0000\u0000EH\u0003\u001a\r\u0000FH\u0003\u0006\u0003\u0000GE\u0001"+
		"\u0000\u0000\u0000GF\u0001\u0000\u0000\u0000H\t\u0001\u0000\u0000\u0000"+
		"IN\u00057\u0000\u0000JK\u00057\u0000\u0000KL\u0005\u0002\u0000\u0000L"+
		"N\u0003\n\u0005\u0000MI\u0001\u0000\u0000\u0000MJ\u0001\u0000\u0000\u0000"+
		"N\u000b\u0001\u0000\u0000\u0000OX\u0003\u000e\u0007\u0000PX\u0003\u0010"+
		"\b\u0000QX\u0003\u0014\n\u0000RX\u0003\u0016\u000b\u0000SX\u0003\u0018"+
		"\f\u0000TX\u0003\u0012\t\u0000UX\u0003\u001a\r\u0000VX\u0003$\u0012\u0000"+
		"WO\u0001\u0000\u0000\u0000WP\u0001\u0000\u0000\u0000WQ\u0001\u0000\u0000"+
		"\u0000WR\u0001\u0000\u0000\u0000WS\u0001\u0000\u0000\u0000WT\u0001\u0000"+
		"\u0000\u0000WU\u0001\u0000\u0000\u0000WV\u0001\u0000\u0000\u0000X\r\u0001"+
		"\u0000\u0000\u0000YZ\u0005-\u0000\u0000Z[\u0003\n\u0005\u0000[\\\u0005"+
		"\u0003\u0000\u0000\\]\u0003\b\u0004\u0000]^\u0005\u0004\u0000\u0000^\u000f"+
		"\u0001\u0000\u0000\u0000_`\u0003\n\u0005\u0000`a\u0005\u0005\u0000\u0000"+
		"ab\u0007\u0000\u0000\u0000b\u0011\u0001\u0000\u0000\u0000cd\u0005\u0006"+
		"\u0000\u0000de\u0003\n\u0005\u0000ej\u0005\u0003\u0000\u0000fh\u00055"+
		"\u0000\u0000gi\u0003\u0014\n\u0000hg\u0001\u0000\u0000\u0000hi\u0001\u0000"+
		"\u0000\u0000ik\u0001\u0000\u0000\u0000jf\u0001\u0000\u0000\u0000kl\u0001"+
		"\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000"+
		"mn\u0001\u0000\u0000\u0000no\u0005\u0004\u0000\u0000o\u0013\u0001\u0000"+
		"\u0000\u0000pq\u0003\n\u0005\u0000qr\u0005\u0007\u0000\u0000rs\u0003\""+
		"\u0011\u0000s~\u0001\u0000\u0000\u0000tu\u0003\n\u0005\u0000uv\u0005\u0007"+
		"\u0000\u0000vw\u0005,\u0000\u0000wx\u0003\n\u0005\u0000x~\u0001\u0000"+
		"\u0000\u0000yz\u0003\n\u0005\u0000z{\u0005\b\u0000\u0000{|\u0003\"\u0011"+
		"\u0000|~\u0001\u0000\u0000\u0000}p\u0001\u0000\u0000\u0000}t\u0001\u0000"+
		"\u0000\u0000}y\u0001\u0000\u0000\u0000~\u0015\u0001\u0000\u0000\u0000"+
		"\u007f\u0083\u0005\t\u0000\u0000\u0080\u0081\u0003\"\u0011\u0000\u0081"+
		"\u0082\u0005\n\u0000\u0000\u0082\u0084\u0001\u0000\u0000\u0000\u0083\u0080"+
		"\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0086"+
		"\u0001\u0000\u0000\u0000\u0085\u0087\u0005,\u0000\u0000\u0086\u0085\u0001"+
		"\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0088\u0001"+
		"\u0000\u0000\u0000\u0088\u0089\u0003\n\u0005\u0000\u0089\u0017\u0001\u0000"+
		"\u0000\u0000\u008a\u008b\u0005\u000b\u0000\u0000\u008b\u008c\u0003\n\u0005"+
		"\u0000\u008c\u008d\u0005\f\u0000\u0000\u008d\u008e\u0003\"\u0011\u0000"+
		"\u008e\u0019\u0001\u0000\u0000\u0000\u008f\u0092\u0005\r\u0000\u0000\u0090"+
		"\u0093\u0003\u0014\n\u0000\u0091\u0093\u0003\"\u0011\u0000\u0092\u0090"+
		"\u0001\u0000\u0000\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0093\u0094"+
		"\u0001\u0000\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0094\u0095"+
		"\u0001\u0000\u0000\u0000\u0095\u00bc\u0001\u0000\u0000\u0000\u0096\u009e"+
		"\u0005\u000e\u0000\u0000\u0097\u009a\u0003\u0014\n\u0000\u0098\u009a\u0003"+
		"\"\u0011\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u0098\u0001\u0000"+
		"\u0000\u0000\u009a\u009c\u0001\u0000\u0000\u0000\u009b\u009d\u0005\u000f"+
		"\u0000\u0000\u009c\u009b\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000"+
		"\u0000\u0000\u009d\u009f\u0001\u0000\u0000\u0000\u009e\u0099\u0001\u0000"+
		"\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000"+
		"\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00bc\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a3\u0005\u0010\u0000\u0000\u00a3\u00a5\u00056\u0000"+
		"\u0000\u00a4\u00a6\u0003\u001c\u000e\u0000\u00a5\u00a4\u0001\u0000\u0000"+
		"\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000"+
		"\u0000\u00a7\u00bc\u0005\u0004\u0000\u0000\u00a8\u00a9\u0005\u0011\u0000"+
		"\u0000\u00a9\u00ab\u0003\n\u0005\u0000\u00aa\u00ac\u0003\u001c\u000e\u0000"+
		"\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000"+
		"\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005\u0004\u0000\u0000"+
		"\u00ae\u00bc\u0001\u0000\u0000\u0000\u00af\u00b3\u0005\u0012\u0000\u0000"+
		"\u00b0\u00b1\u0003\"\u0011\u0000\u00b1\u00b2\u0005\n\u0000\u0000\u00b2"+
		"\u00b4\u0001\u0000\u0000\u0000\u00b3\u00b0\u0001\u0000\u0000\u0000\u00b3"+
		"\u00b4\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5"+
		"\u00b6\u00056\u0000\u0000\u00b6\u00bc\u0005\u0004\u0000\u0000\u00b7\u00bc"+
		"\u0003\u0016\u000b\u0000\u00b8\u00bc\u0003$\u0012\u0000\u00b9\u00bc\u0003"+
		"\u0014\n\u0000\u00ba\u00bc\u0003\u0010\b\u0000\u00bb\u008f\u0001\u0000"+
		"\u0000\u0000\u00bb\u0096\u0001\u0000\u0000\u0000\u00bb\u00a2\u0001\u0000"+
		"\u0000\u0000\u00bb\u00a8\u0001\u0000\u0000\u0000\u00bb\u00af\u0001\u0000"+
		"\u0000\u0000\u00bb\u00b7\u0001\u0000\u0000\u0000\u00bb\u00b8\u0001\u0000"+
		"\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb\u00ba\u0001\u0000"+
		"\u0000\u0000\u00bc\u001b\u0001\u0000\u0000\u0000\u00bd\u00bf\u0003\u001e"+
		"\u000f\u0000\u00be\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c0\u00be\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c5\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c3\u00c6\u0003 \u0010\u0000\u00c4\u00c6\u0003\u001e\u000f"+
		"\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c5\u00c4\u0001\u0000\u0000"+
		"\u0000\u00c6\u001d\u0001\u0000\u0000\u0000\u00c7\u00c8\u0003 \u0010\u0000"+
		"\u00c8\u00c9\u0005\u0001\u0000\u0000\u00c9\u001f\u0001\u0000\u0000\u0000"+
		"\u00ca\u00cb\u00058\u0000\u0000\u00cb\u00cd\u0005\n\u0000\u0000\u00cc"+
		"\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd"+
		"\u00d0\u0001\u0000\u0000\u0000\u00ce\u00cf\u00058\u0000\u0000\u00cf\u00d1"+
		"\u0005\n\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001"+
		"\u0000\u0000\u0000\u00d1\u00d4\u0001\u0000\u0000\u0000\u00d2\u00d5\u0005"+
		"6\u0000\u0000\u00d3\u00d5\u0003\n\u0005\u0000\u00d4\u00d2\u0001\u0000"+
		"\u0000\u0000\u00d4\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d8\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d7\u0005\u0013\u0000\u0000\u00d7\u00d9\u00058\u0000"+
		"\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000"+
		"\u0000\u00d9!\u0001\u0000\u0000\u0000\u00da\u00db\u0006\u0011\uffff\uffff"+
		"\u0000\u00db\u00dc\u0005\u0014\u0000\u0000\u00dc\u00dd\u0003\"\u0011\u0000"+
		"\u00dd\u00de\u0005\u0015\u0000\u0000\u00de\u00f1\u0001\u0000\u0000\u0000"+
		"\u00df\u00e0\u0007\u0001\u0000\u0000\u00e0\u00f1\u0003\"\u0011\u000b\u00e1"+
		"\u00e4\u00058\u0000\u0000\u00e2\u00e3\u0005&\u0000\u0000\u00e3\u00e5\u0005"+
		"8\u0000\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000"+
		"\u0000\u0000\u00e5\u00f1\u0001\u0000\u0000\u0000\u00e6\u00f1\u0003\n\u0005"+
		"\u0000\u00e7\u00f1\u00056\u0000\u0000\u00e8\u00e9\u0005.\u0000\u0000\u00e9"+
		"\u00ea\u0005\u0014\u0000\u0000\u00ea\u00eb\u0003\"\u0011\u0000\u00eb\u00ec"+
		"\u0005\u0015\u0000\u0000\u00ec\u00f1\u0001\u0000\u0000\u0000\u00ed\u00ee"+
		"\u0005\'\u0000\u0000\u00ee\u00f1\u00056\u0000\u0000\u00ef\u00f1\u0003"+
		"\u0016\u000b\u0000\u00f0\u00da\u0001\u0000\u0000\u0000\u00f0\u00df\u0001"+
		"\u0000\u0000\u0000\u00f0\u00e1\u0001\u0000\u0000\u0000\u00f0\u00e6\u0001"+
		"\u0000\u0000\u0000\u00f0\u00e7\u0001\u0000\u0000\u0000\u00f0\u00e8\u0001"+
		"\u0000\u0000\u0000\u00f0\u00ed\u0001\u0000\u0000\u0000\u00f0\u00ef\u0001"+
		"\u0000\u0000\u0000\u00f1\u0103\u0001\u0000\u0000\u0000\u00f2\u00f3\n\f"+
		"\u0000\u0000\u00f3\u00f4\u0005\u0016\u0000\u0000\u00f4\u0102\u0003\"\u0011"+
		"\r\u00f5\u00f6\n\n\u0000\u0000\u00f6\u00f7\u0007\u0002\u0000\u0000\u00f7"+
		"\u0102\u0003\"\u0011\u000b\u00f8\u00f9\n\t\u0000\u0000\u00f9\u00fa\u0007"+
		"\u0003\u0000\u0000\u00fa\u0102\u0003\"\u0011\n\u00fb\u00fc\n\b\u0000\u0000"+
		"\u00fc\u00fd\u0007\u0004\u0000\u0000\u00fd\u0102\u0003\"\u0011\t\u00fe"+
		"\u00ff\n\u0007\u0000\u0000\u00ff\u0100\u0007\u0005\u0000\u0000\u0100\u0102"+
		"\u0003\"\u0011\b\u0101\u00f2\u0001\u0000\u0000\u0000\u0101\u00f5\u0001"+
		"\u0000\u0000\u0000\u0101\u00f8\u0001\u0000\u0000\u0000\u0101\u00fb\u0001"+
		"\u0000\u0000\u0000\u0101\u00fe\u0001\u0000\u0000\u0000\u0102\u0105\u0001"+
		"\u0000\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000\u0103\u0104\u0001"+
		"\u0000\u0000\u0000\u0104#\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000"+
		"\u0000\u0000\u0106\u010a\u0003&\u0013\u0000\u0107\u0109\u0003(\u0014\u0000"+
		"\u0108\u0107\u0001\u0000\u0000\u0000\u0109\u010c\u0001\u0000\u0000\u0000"+
		"\u010a\u0108\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000"+
		"\u010b\u010e\u0001\u0000\u0000\u0000\u010c\u010a\u0001\u0000\u0000\u0000"+
		"\u010d\u010f\u0003*\u0015\u0000\u010e\u010d\u0001\u0000\u0000\u0000\u010e"+
		"\u010f\u0001\u0000\u0000\u0000\u010f\u0110\u0001\u0000\u0000\u0000\u0110"+
		"\u0111\u0005\u0004\u0000\u0000\u0111%\u0001\u0000\u0000\u0000\u0112\u0113"+
		"\u0005(\u0000\u0000\u0113\u0114\u0003\"\u0011\u0000\u0114\u0116\u0005"+
		")\u0000\u0000\u0115\u0117\u0003\f\u0006\u0000\u0116\u0115\u0001\u0000"+
		"\u0000\u0000\u0117\u0118\u0001\u0000\u0000\u0000\u0118\u0116\u0001\u0000"+
		"\u0000\u0000\u0118\u0119\u0001\u0000\u0000\u0000\u0119\'\u0001\u0000\u0000"+
		"\u0000\u011a\u011b\u0005*\u0000\u0000\u011b\u011c\u0003\"\u0011\u0000"+
		"\u011c\u011e\u0005)\u0000\u0000\u011d\u011f\u0003\f\u0006\u0000\u011e"+
		"\u011d\u0001\u0000\u0000\u0000\u011f\u0120\u0001\u0000\u0000\u0000\u0120"+
		"\u011e\u0001\u0000\u0000\u0000\u0120\u0121\u0001\u0000\u0000\u0000\u0121"+
		")\u0001\u0000\u0000\u0000\u0122\u0124\u0005+\u0000\u0000\u0123\u0125\u0003"+
		"\f\u0006\u0000\u0124\u0123\u0001\u0000\u0000\u0000\u0125\u0126\u0001\u0000"+
		"\u0000\u0000\u0126\u0124\u0001\u0000\u0000\u0000\u0126\u0127\u0001\u0000"+
		"\u0000\u0000\u0127+\u0001\u0000\u0000\u0000#5:BGMWhl}\u0083\u0086\u0092"+
		"\u0094\u0099\u009c\u00a0\u00a5\u00ab\u00b3\u00bb\u00c0\u00c5\u00cc\u00d0"+
		"\u00d4\u00d8\u00e4\u00f0\u0101\u0103\u010a\u010e\u0118\u0120\u0126";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}