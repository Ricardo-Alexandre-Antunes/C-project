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
		T__31=32, T__32=33, T__33=34, T__34=35, ID=36, Integer=37, Minus=38, SKIPPING=39, 
		NEWLINE=40, COMMENT=41;
	public static final int
		RULE_statList = 0, RULE_statement = 1, RULE_code = 2, RULE_codeBlock = 3, 
		RULE_newQuestion = 4, RULE_declaration = 5, RULE_assignment = 6, RULE_execution = 7, 
		RULE_export = 8, RULE_expr = 9, RULE_ifLineSentence = 10, RULE_ifBlock = 11, 
		RULE_elseifBlock = 12, RULE_elseBlock = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"statList", "statement", "code", "codeBlock", "newQuestion", "declaration", 
			"assignment", "execution", "export", "expr", "ifLineSentence", "ifBlock", 
			"elseifBlock", "elseBlock"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'code '", "' is'", "' '", "'\"['", "']\"'", "'ola'", "'hey'", 
			"'multi-choice '", "'\\n'", "'end'", "'hole '", "'open '", "'cole-hole '", 
			"'cole-open '", "'code-output '", "': '", "'question'", "'fraction'", 
			"'integer'", "'text'", "' := '", "'new'", "'execute'", "'export '", "' to '", 
			"'\"'", "'print'", "'println'", "'uses code from '", "'\" end'", "'if '", 
			"' then'", "'elseif '", "'else '", null, null, "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"ID", "Integer", "Minus", "SKIPPING", "NEWLINE", "COMMENT"
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
		public TerminalNode EOF() { return getToken(QlangParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(QlangParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(QlangParser.NEWLINE, i);
		}
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 68769935878L) != 0)) {
				{
				{
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 68769935876L) != 0)) {
					{
					setState(28);
					statement();
					}
				}

				setState(31);
				match(T__0);
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(32);
					match(NEWLINE);
					}
					}
					setState(37);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
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
	public static class StatementContext extends ParserRuleContext {
		public NewQuestionContext newQuestion() {
			return getRuleContext(NewQuestionContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExecutionContext execution() {
			return getRuleContext(ExecutionContext.class,0);
		}
		public ExportContext export() {
			return getRuleContext(ExportContext.class,0);
		}
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				newQuestion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				declaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
				assignment();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(48);
				execution();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(49);
				export();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(50);
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
		public CodeBlockContext codeBlock() {
			return getRuleContext(CodeBlockContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(QlangParser.NEWLINE, 0); }
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
		enterRule(_localctx, 4, RULE_code);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(T__1);
			setState(54);
			match(ID);
			setState(55);
			match(T__2);
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(56);
				match(T__3);
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(62);
				match(NEWLINE);
				}
			}

			setState(65);
			match(T__4);
			setState(66);
			codeBlock();
			setState(67);
			match(T__5);
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
	public static class CodeBlockContext extends ParserRuleContext {
		public CodeBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterCodeBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitCodeBlock(this);
		}
	}

	public final CodeBlockContext codeBlock() throws RecognitionException {
		CodeBlockContext _localctx = new CodeBlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_codeBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_la = _input.LA(1);
			if ( !(_la==T__6 || _la==T__7) ) {
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
		public TerminalNode ID() { return getToken(QlangParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
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
		public TerminalNode ID() { return getToken(QlangParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
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
		public TerminalNode ID() { return getToken(QlangParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
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
		public TerminalNode ID() { return getToken(QlangParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
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
		public TerminalNode ID() { return getToken(QlangParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
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
		public TerminalNode ID() { return getToken(QlangParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
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
		enterRule(_localctx, 8, RULE_newQuestion);
		int _la;
		try {
			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				_localctx = new MultiChoiceQuestionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				match(T__8);
				setState(72);
				match(ID);
				setState(73);
				match(T__2);
				setState(78); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(74);
					match(T__9);
					setState(75);
					expr();
					setState(76);
					match(T__0);
					}
					}
					setState(80); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__9 );
				setState(82);
				match(T__10);
				}
				break;
			case T__11:
				_localctx = new HoleQuestionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				match(T__11);
				setState(85);
				match(ID);
				setState(86);
				match(T__2);
				setState(91); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(87);
					match(T__9);
					setState(88);
					expr();
					setState(89);
					match(T__0);
					}
					}
					setState(93); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__9 );
				setState(95);
				match(T__10);
				}
				break;
			case T__12:
				_localctx = new OpenQuestionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				match(T__12);
				setState(98);
				match(ID);
				setState(99);
				match(T__2);
				setState(104); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(100);
					match(T__9);
					setState(101);
					expr();
					setState(102);
					match(T__0);
					}
					}
					setState(106); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__9 );
				setState(108);
				match(T__10);
				}
				break;
			case T__13:
				_localctx = new ColeHoleQuestionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(110);
				match(T__13);
				setState(111);
				match(ID);
				setState(112);
				match(T__2);
				setState(117); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(113);
					match(T__9);
					setState(114);
					expr();
					setState(115);
					match(T__0);
					}
					}
					setState(119); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__9 );
				setState(121);
				match(T__10);
				}
				break;
			case T__14:
				_localctx = new ColeOpenQuestionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(123);
				match(T__14);
				setState(124);
				match(ID);
				setState(125);
				match(T__2);
				setState(130); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(126);
					match(T__9);
					setState(127);
					expr();
					setState(128);
					match(T__0);
					}
					}
					setState(132); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__9 );
				setState(134);
				match(T__10);
				}
				break;
			case T__15:
				_localctx = new CodeOutputQuestionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(136);
				match(T__15);
				setState(137);
				match(ID);
				setState(138);
				match(T__2);
				setState(143); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(139);
					match(T__9);
					setState(140);
					expr();
					setState(141);
					match(T__0);
					}
					}
					setState(145); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__9 );
				setState(147);
				match(T__10);
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
		enterRule(_localctx, 10, RULE_declaration);
		try {
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new QuestionDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				match(ID);
				setState(152);
				match(T__16);
				setState(153);
				match(T__17);
				}
				break;
			case 2:
				_localctx = new FractionDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				match(ID);
				setState(155);
				match(T__16);
				setState(156);
				match(T__18);
				}
				break;
			case 3:
				_localctx = new IntegerDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(157);
				match(ID);
				setState(158);
				match(T__16);
				setState(159);
				match(T__19);
				}
				break;
			case 4:
				_localctx = new TextDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(160);
				match(ID);
				setState(161);
				match(T__16);
				setState(162);
				match(T__20);
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
		public List<TerminalNode> ID() { return getTokens(QlangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(QlangParser.ID, i);
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

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignment);
		try {
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new IDAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				match(ID);
				setState(166);
				match(T__21);
				setState(167);
				match(ID);
				}
				break;
			case 2:
				_localctx = new NewAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				match(ID);
				setState(169);
				match(T__21);
				setState(170);
				match(T__22);
				setState(171);
				match(ID);
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
		public TerminalNode ID() { return getToken(QlangParser.ID, 0); }
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
		enterRule(_localctx, 14, RULE_execution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(T__23);
			setState(175);
			match(ID);
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
		public List<TerminalNode> ID() { return getTokens(QlangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(QlangParser.ID, i);
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
	}

	public final ExportContext export() throws RecognitionException {
		ExportContext _localctx = new ExportContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_export);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(T__24);
			setState(178);
			match(ID);
			setState(179);
			match(T__25);
			setState(180);
			match(T__26);
			setState(181);
			match(ID);
			setState(182);
			match(T__26);
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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintSentenceContext extends ExprContext {
		public TerminalNode ID() { return getToken(QlangParser.ID, 0); }
		public PrintSentenceContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class UsesCodeSentenceContext extends ExprContext {
		public TerminalNode ID() { return getToken(QlangParser.ID, 0); }
		public UsesCodeSentenceContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class PrintLineSentenceContext extends ExprContext {
		public TerminalNode ID() { return getToken(QlangParser.ID, 0); }
		public PrintLineSentenceContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).enterPrintLineSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QlangListener ) ((QlangListener)listener).exitPrintLineSentence(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expr);
		try {
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__27:
				_localctx = new PrintSentenceContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				match(T__27);
				setState(185);
				match(T__26);
				setState(186);
				match(ID);
				setState(187);
				match(T__26);
				}
				break;
			case T__28:
				_localctx = new PrintLineSentenceContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				match(T__28);
				setState(189);
				match(T__26);
				setState(190);
				match(ID);
				setState(191);
				match(T__26);
				}
				break;
			case T__29:
				_localctx = new UsesCodeSentenceContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				match(T__29);
				setState(193);
				match(T__26);
				setState(194);
				match(ID);
				setState(195);
				match(T__30);
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
		enterRule(_localctx, 20, RULE_ifLineSentence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			ifBlock();
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__33) {
				{
				{
				setState(199);
				elseifBlock();
				}
				}
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__34) {
				{
				setState(205);
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
		enterRule(_localctx, 22, RULE_ifBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(T__31);
			setState(209);
			expr();
			setState(210);
			match(T__32);
			setState(213); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(211);
				match(T__9);
				setState(212);
				statement();
				}
				}
				setState(215); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__9 );
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
		enterRule(_localctx, 24, RULE_elseifBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(T__33);
			setState(218);
			expr();
			setState(219);
			match(T__32);
			setState(222); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(220);
				match(T__9);
				setState(221);
				statement();
				}
				}
				setState(224); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__9 );
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
		enterRule(_localctx, 26, RULE_elseBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(T__34);
			setState(229); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(227);
				match(T__9);
				setState(228);
				statement();
				}
				}
				setState(231); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__9 );
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

	public static final String _serializedATN =
		"\u0004\u0001)\u00ea\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0003\u0000\u001e\b\u0000\u0001"+
		"\u0000\u0001\u0000\u0005\u0000\"\b\u0000\n\u0000\f\u0000%\t\u0000\u0005"+
		"\u0000\'\b\u0000\n\u0000\f\u0000*\t\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u00014\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002:\b\u0002\n\u0002\f\u0002=\t\u0002\u0001\u0002\u0003\u0002@\b\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0004\u0004O\b\u0004\u000b\u0004\f\u0004P\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0004\u0004\\\b\u0004\u000b\u0004\f\u0004]\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0004\u0004i\b\u0004\u000b\u0004\f\u0004j\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0004\u0004v\b\u0004\u000b\u0004\f\u0004"+
		"w\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004\u0083\b\u0004\u000b\u0004"+
		"\f\u0004\u0084\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004\u0090\b\u0004"+
		"\u000b\u0004\f\u0004\u0091\u0001\u0004\u0001\u0004\u0003\u0004\u0096\b"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005\u00a4\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00ad\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00c5\b\t\u0001\n\u0001"+
		"\n\u0005\n\u00c9\b\n\n\n\f\n\u00cc\t\n\u0001\n\u0003\n\u00cf\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0004\u000b\u00d6"+
		"\b\u000b\u000b\u000b\f\u000b\u00d7\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0004\f\u00df\b\f\u000b\f\f\f\u00e0\u0001\r\u0001\r\u0001\r\u0004\r"+
		"\u00e6\b\r\u000b\r\f\r\u00e7\u0001\r\u0000\u0000\u000e\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u0000\u0001\u0001"+
		"\u0000\u0007\b\u00fb\u0000(\u0001\u0000\u0000\u0000\u00023\u0001\u0000"+
		"\u0000\u0000\u00045\u0001\u0000\u0000\u0000\u0006E\u0001\u0000\u0000\u0000"+
		"\b\u0095\u0001\u0000\u0000\u0000\n\u00a3\u0001\u0000\u0000\u0000\f\u00ac"+
		"\u0001\u0000\u0000\u0000\u000e\u00ae\u0001\u0000\u0000\u0000\u0010\u00b1"+
		"\u0001\u0000\u0000\u0000\u0012\u00c4\u0001\u0000\u0000\u0000\u0014\u00c6"+
		"\u0001\u0000\u0000\u0000\u0016\u00d0\u0001\u0000\u0000\u0000\u0018\u00d9"+
		"\u0001\u0000\u0000\u0000\u001a\u00e2\u0001\u0000\u0000\u0000\u001c\u001e"+
		"\u0003\u0002\u0001\u0000\u001d\u001c\u0001\u0000\u0000\u0000\u001d\u001e"+
		"\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f#\u0005"+
		"\u0001\u0000\u0000 \"\u0005(\u0000\u0000! \u0001\u0000\u0000\u0000\"%"+
		"\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000"+
		"\u0000$\'\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000&\u001d\u0001"+
		"\u0000\u0000\u0000\'*\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000"+
		"()\u0001\u0000\u0000\u0000)+\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000"+
		"\u0000+,\u0005\u0000\u0000\u0001,\u0001\u0001\u0000\u0000\u0000-4\u0003"+
		"\b\u0004\u0000.4\u0003\n\u0005\u0000/4\u0003\f\u0006\u000004\u0003\u000e"+
		"\u0007\u000014\u0003\u0010\b\u000024\u0003\u0004\u0002\u00003-\u0001\u0000"+
		"\u0000\u00003.\u0001\u0000\u0000\u00003/\u0001\u0000\u0000\u000030\u0001"+
		"\u0000\u0000\u000031\u0001\u0000\u0000\u000032\u0001\u0000\u0000\u0000"+
		"4\u0003\u0001\u0000\u0000\u000056\u0005\u0002\u0000\u000067\u0005$\u0000"+
		"\u00007;\u0005\u0003\u0000\u00008:\u0005\u0004\u0000\u000098\u0001\u0000"+
		"\u0000\u0000:=\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000;<\u0001"+
		"\u0000\u0000\u0000<?\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000"+
		">@\u0005(\u0000\u0000?>\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000"+
		"@A\u0001\u0000\u0000\u0000AB\u0005\u0005\u0000\u0000BC\u0003\u0006\u0003"+
		"\u0000CD\u0005\u0006\u0000\u0000D\u0005\u0001\u0000\u0000\u0000EF\u0007"+
		"\u0000\u0000\u0000F\u0007\u0001\u0000\u0000\u0000GH\u0005\t\u0000\u0000"+
		"HI\u0005$\u0000\u0000IN\u0005\u0003\u0000\u0000JK\u0005\n\u0000\u0000"+
		"KL\u0003\u0012\t\u0000LM\u0005\u0001\u0000\u0000MO\u0001\u0000\u0000\u0000"+
		"NJ\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000"+
		"\u0000PQ\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RS\u0005\u000b"+
		"\u0000\u0000S\u0096\u0001\u0000\u0000\u0000TU\u0005\f\u0000\u0000UV\u0005"+
		"$\u0000\u0000V[\u0005\u0003\u0000\u0000WX\u0005\n\u0000\u0000XY\u0003"+
		"\u0012\t\u0000YZ\u0005\u0001\u0000\u0000Z\\\u0001\u0000\u0000\u0000[W"+
		"\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000][\u0001\u0000\u0000"+
		"\u0000]^\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_`\u0005\u000b"+
		"\u0000\u0000`\u0096\u0001\u0000\u0000\u0000ab\u0005\r\u0000\u0000bc\u0005"+
		"$\u0000\u0000ch\u0005\u0003\u0000\u0000de\u0005\n\u0000\u0000ef\u0003"+
		"\u0012\t\u0000fg\u0005\u0001\u0000\u0000gi\u0001\u0000\u0000\u0000hd\u0001"+
		"\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000"+
		"jk\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lm\u0005\u000b\u0000"+
		"\u0000m\u0096\u0001\u0000\u0000\u0000no\u0005\u000e\u0000\u0000op\u0005"+
		"$\u0000\u0000pu\u0005\u0003\u0000\u0000qr\u0005\n\u0000\u0000rs\u0003"+
		"\u0012\t\u0000st\u0005\u0001\u0000\u0000tv\u0001\u0000\u0000\u0000uq\u0001"+
		"\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000"+
		"wx\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0005\u000b\u0000"+
		"\u0000z\u0096\u0001\u0000\u0000\u0000{|\u0005\u000f\u0000\u0000|}\u0005"+
		"$\u0000\u0000}\u0082\u0005\u0003\u0000\u0000~\u007f\u0005\n\u0000\u0000"+
		"\u007f\u0080\u0003\u0012\t\u0000\u0080\u0081\u0005\u0001\u0000\u0000\u0081"+
		"\u0083\u0001\u0000\u0000\u0000\u0082~\u0001\u0000\u0000\u0000\u0083\u0084"+
		"\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0084\u0085"+
		"\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0087"+
		"\u0005\u000b\u0000\u0000\u0087\u0096\u0001\u0000\u0000\u0000\u0088\u0089"+
		"\u0005\u0010\u0000\u0000\u0089\u008a\u0005$\u0000\u0000\u008a\u008f\u0005"+
		"\u0003\u0000\u0000\u008b\u008c\u0005\n\u0000\u0000\u008c\u008d\u0003\u0012"+
		"\t\u0000\u008d\u008e\u0005\u0001\u0000\u0000\u008e\u0090\u0001\u0000\u0000"+
		"\u0000\u008f\u008b\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000"+
		"\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000"+
		"\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u0094\u0005\u000b\u0000"+
		"\u0000\u0094\u0096\u0001\u0000\u0000\u0000\u0095G\u0001\u0000\u0000\u0000"+
		"\u0095T\u0001\u0000\u0000\u0000\u0095a\u0001\u0000\u0000\u0000\u0095n"+
		"\u0001\u0000\u0000\u0000\u0095{\u0001\u0000\u0000\u0000\u0095\u0088\u0001"+
		"\u0000\u0000\u0000\u0096\t\u0001\u0000\u0000\u0000\u0097\u0098\u0005$"+
		"\u0000\u0000\u0098\u0099\u0005\u0011\u0000\u0000\u0099\u00a4\u0005\u0012"+
		"\u0000\u0000\u009a\u009b\u0005$\u0000\u0000\u009b\u009c\u0005\u0011\u0000"+
		"\u0000\u009c\u00a4\u0005\u0013\u0000\u0000\u009d\u009e\u0005$\u0000\u0000"+
		"\u009e\u009f\u0005\u0011\u0000\u0000\u009f\u00a4\u0005\u0014\u0000\u0000"+
		"\u00a0\u00a1\u0005$\u0000\u0000\u00a1\u00a2\u0005\u0011\u0000\u0000\u00a2"+
		"\u00a4\u0005\u0015\u0000\u0000\u00a3\u0097\u0001\u0000\u0000\u0000\u00a3"+
		"\u009a\u0001\u0000\u0000\u0000\u00a3\u009d\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a0\u0001\u0000\u0000\u0000\u00a4\u000b\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a6\u0005$\u0000\u0000\u00a6\u00a7\u0005\u0016\u0000\u0000\u00a7\u00ad"+
		"\u0005$\u0000\u0000\u00a8\u00a9\u0005$\u0000\u0000\u00a9\u00aa\u0005\u0016"+
		"\u0000\u0000\u00aa\u00ab\u0005\u0017\u0000\u0000\u00ab\u00ad\u0005$\u0000"+
		"\u0000\u00ac\u00a5\u0001\u0000\u0000\u0000\u00ac\u00a8\u0001\u0000\u0000"+
		"\u0000\u00ad\r\u0001\u0000\u0000\u0000\u00ae\u00af\u0005\u0018\u0000\u0000"+
		"\u00af\u00b0\u0005$\u0000\u0000\u00b0\u000f\u0001\u0000\u0000\u0000\u00b1"+
		"\u00b2\u0005\u0019\u0000\u0000\u00b2\u00b3\u0005$\u0000\u0000\u00b3\u00b4"+
		"\u0005\u001a\u0000\u0000\u00b4\u00b5\u0005\u001b\u0000\u0000\u00b5\u00b6"+
		"\u0005$\u0000\u0000\u00b6\u00b7\u0005\u001b\u0000\u0000\u00b7\u0011\u0001"+
		"\u0000\u0000\u0000\u00b8\u00b9\u0005\u001c\u0000\u0000\u00b9\u00ba\u0005"+
		"\u001b\u0000\u0000\u00ba\u00bb\u0005$\u0000\u0000\u00bb\u00c5\u0005\u001b"+
		"\u0000\u0000\u00bc\u00bd\u0005\u001d\u0000\u0000\u00bd\u00be\u0005\u001b"+
		"\u0000\u0000\u00be\u00bf\u0005$\u0000\u0000\u00bf\u00c5\u0005\u001b\u0000"+
		"\u0000\u00c0\u00c1\u0005\u001e\u0000\u0000\u00c1\u00c2\u0005\u001b\u0000"+
		"\u0000\u00c2\u00c3\u0005$\u0000\u0000\u00c3\u00c5\u0005\u001f\u0000\u0000"+
		"\u00c4\u00b8\u0001\u0000\u0000\u0000\u00c4\u00bc\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c0\u0001\u0000\u0000\u0000\u00c5\u0013\u0001\u0000\u0000\u0000"+
		"\u00c6\u00ca\u0003\u0016\u000b\u0000\u00c7\u00c9\u0003\u0018\f\u0000\u00c8"+
		"\u00c7\u0001\u0000\u0000\u0000\u00c9\u00cc\u0001\u0000\u0000\u0000\u00ca"+
		"\u00c8\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb"+
		"\u00ce\u0001\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cd"+
		"\u00cf\u0003\u001a\r\u0000\u00ce\u00cd\u0001\u0000\u0000\u0000\u00ce\u00cf"+
		"\u0001\u0000\u0000\u0000\u00cf\u0015\u0001\u0000\u0000\u0000\u00d0\u00d1"+
		"\u0005 \u0000\u0000\u00d1\u00d2\u0003\u0012\t\u0000\u00d2\u00d5\u0005"+
		"!\u0000\u0000\u00d3\u00d4\u0005\n\u0000\u0000\u00d4\u00d6\u0003\u0002"+
		"\u0001\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000"+
		"\u0000\u0000\u00d8\u0017\u0001\u0000\u0000\u0000\u00d9\u00da\u0005\"\u0000"+
		"\u0000\u00da\u00db\u0003\u0012\t\u0000\u00db\u00de\u0005!\u0000\u0000"+
		"\u00dc\u00dd\u0005\n\u0000\u0000\u00dd\u00df\u0003\u0002\u0001\u0000\u00de"+
		"\u00dc\u0001\u0000\u0000\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0"+
		"\u00de\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1"+
		"\u0019\u0001\u0000\u0000\u0000\u00e2\u00e5\u0005#\u0000\u0000\u00e3\u00e4"+
		"\u0005\n\u0000\u0000\u00e4\u00e6\u0003\u0002\u0001\u0000\u00e5\u00e3\u0001"+
		"\u0000\u0000\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7\u00e5\u0001"+
		"\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8\u001b\u0001"+
		"\u0000\u0000\u0000\u0015\u001d#(3;?P]jw\u0084\u0091\u0095\u00a3\u00ac"+
		"\u00c4\u00ca\u00ce\u00d7\u00e0\u00e7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}