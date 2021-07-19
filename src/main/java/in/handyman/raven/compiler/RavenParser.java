// Generated from Raven.g4 by ANTLR 4.9.2

package in.handyman.raven.compiler;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RavenParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, NON_ZERO_DIGIT=26, STRING=27, CRLF=28, Operator=29, WS=30, COMMENT=31, 
		LINE_COMMENT=32;
	public static final int
		RULE_process = 0, RULE_tryClause = 1, RULE_finallyClause = 2, RULE_catchClause = 3, 
		RULE_action = 4, RULE_copyData = 5, RULE_transform = 6, RULE_loadCsv = 7, 
		RULE_abort = 8, RULE_callProcess = 9, RULE_expression = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"process", "tryClause", "finallyClause", "catchClause", "action", "copyData", 
			"transform", "loadCsv", "abort", "callProcess", "expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'process'", "'{'", "'}'", "'try'", "'finally'", "'catch'", "'copydata'", 
			"'as'", "'from'", "'to'", "'using'", "'on-condition'", "'fielding'", 
			"'with-fetch-batch-size'", "'with-write-batch-size'", "'transform'", 
			"'on'", "'loadcsv'", "'with'", "'abort'", "'callprocess'", "'with-target'", 
			"'from-file'", "'for-every'", "'if'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "NON_ZERO_DIGIT", "STRING", "CRLF", "Operator", "WS", "COMMENT", 
			"LINE_COMMENT"
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
	public String getGrammarFileName() { return "Raven.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RavenParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProcessContext extends ParserRuleContext {
		public Token name;
		public TryClauseContext tryBlock;
		public CatchClauseContext catchBlock;
		public FinallyClauseContext finallyBlock;
		public TerminalNode STRING() { return getToken(RavenParser.STRING, 0); }
		public TryClauseContext tryClause() {
			return getRuleContext(TryClauseContext.class,0);
		}
		public CatchClauseContext catchClause() {
			return getRuleContext(CatchClauseContext.class,0);
		}
		public FinallyClauseContext finallyClause() {
			return getRuleContext(FinallyClauseContext.class,0);
		}
		public ProcessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_process; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RavenListener ) ((RavenListener)listener).enterProcess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RavenListener ) ((RavenListener)listener).exitProcess(this);
		}
	}

	public final ProcessContext process() throws RecognitionException {
		ProcessContext _localctx = new ProcessContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_process);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			match(T__0);
			setState(23);
			((ProcessContext)_localctx).name = match(STRING);
			setState(24);
			match(T__1);
			setState(25);
			((ProcessContext)_localctx).tryBlock = tryClause();
			setState(26);
			((ProcessContext)_localctx).catchBlock = catchClause();
			setState(27);
			((ProcessContext)_localctx).finallyBlock = finallyClause();
			setState(28);
			match(T__2);
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

	public static class TryClauseContext extends ParserRuleContext {
		public ActionContext action;
		public List<ActionContext> actions = new ArrayList<ActionContext>();
		public List<ActionContext> action() {
			return getRuleContexts(ActionContext.class);
		}
		public ActionContext action(int i) {
			return getRuleContext(ActionContext.class,i);
		}
		public TryClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RavenListener ) ((RavenListener)listener).enterTryClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RavenListener ) ((RavenListener)listener).exitTryClause(this);
		}
	}

	public final TryClauseContext tryClause() throws RecognitionException {
		TryClauseContext _localctx = new TryClauseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_tryClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(T__3);
			setState(31);
			match(T__1);
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__15) | (1L << T__17) | (1L << T__19) | (1L << T__20))) != 0)) {
				{
				{
				setState(32);
				((TryClauseContext)_localctx).action = action();
				((TryClauseContext)_localctx).actions.add(((TryClauseContext)_localctx).action);
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
			match(T__2);
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

	public static class FinallyClauseContext extends ParserRuleContext {
		public ActionContext action;
		public List<ActionContext> actions = new ArrayList<ActionContext>();
		public List<ActionContext> action() {
			return getRuleContexts(ActionContext.class);
		}
		public ActionContext action(int i) {
			return getRuleContext(ActionContext.class,i);
		}
		public FinallyClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finallyClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RavenListener ) ((RavenListener)listener).enterFinallyClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RavenListener ) ((RavenListener)listener).exitFinallyClause(this);
		}
	}

	public final FinallyClauseContext finallyClause() throws RecognitionException {
		FinallyClauseContext _localctx = new FinallyClauseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_finallyClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(T__4);
			setState(41);
			match(T__1);
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__15) | (1L << T__17) | (1L << T__19) | (1L << T__20))) != 0)) {
				{
				{
				setState(42);
				((FinallyClauseContext)_localctx).action = action();
				((FinallyClauseContext)_localctx).actions.add(((FinallyClauseContext)_localctx).action);
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
			match(T__2);
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

	public static class CatchClauseContext extends ParserRuleContext {
		public ActionContext action;
		public List<ActionContext> actions = new ArrayList<ActionContext>();
		public List<ActionContext> action() {
			return getRuleContexts(ActionContext.class);
		}
		public ActionContext action(int i) {
			return getRuleContext(ActionContext.class,i);
		}
		public CatchClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RavenListener ) ((RavenListener)listener).enterCatchClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RavenListener ) ((RavenListener)listener).exitCatchClause(this);
		}
	}

	public final CatchClauseContext catchClause() throws RecognitionException {
		CatchClauseContext _localctx = new CatchClauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_catchClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__5);
			setState(51);
			match(T__1);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__15) | (1L << T__17) | (1L << T__19) | (1L << T__20))) != 0)) {
				{
				{
				setState(52);
				((CatchClauseContext)_localctx).action = action();
				((CatchClauseContext)_localctx).actions.add(((CatchClauseContext)_localctx).action);
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58);
			match(T__2);
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

	public static class ActionContext extends ParserRuleContext {
		public CopyDataContext copyData() {
			return getRuleContext(CopyDataContext.class,0);
		}
		public LoadCsvContext loadCsv() {
			return getRuleContext(LoadCsvContext.class,0);
		}
		public CallProcessContext callProcess() {
			return getRuleContext(CallProcessContext.class,0);
		}
		public TransformContext transform() {
			return getRuleContext(TransformContext.class,0);
		}
		public AbortContext abort() {
			return getRuleContext(AbortContext.class,0);
		}
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RavenListener ) ((RavenListener)listener).enterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RavenListener ) ((RavenListener)listener).exitAction(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				{
				setState(60);
				copyData();
				}
				break;
			case T__17:
				{
				setState(61);
				loadCsv();
				}
				break;
			case T__20:
				{
				setState(62);
				callProcess();
				}
				break;
			case T__15:
				{
				setState(63);
				transform();
				}
				break;
			case T__19:
				{
				setState(64);
				abort();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class CopyDataContext extends ParserRuleContext {
		public Token name;
		public Token source;
		public Token to;
		public Token value;
		public ExpressionContext condition;
		public Token writeThreadCount;
		public Token fetchBatchSize;
		public Token writeBatchSize;
		public List<TerminalNode> STRING() { return getTokens(RavenParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(RavenParser.STRING, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> NON_ZERO_DIGIT() { return getTokens(RavenParser.NON_ZERO_DIGIT); }
		public TerminalNode NON_ZERO_DIGIT(int i) {
			return getToken(RavenParser.NON_ZERO_DIGIT, i);
		}
		public CopyDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_copyData; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RavenListener ) ((RavenListener)listener).enterCopyData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RavenListener ) ((RavenListener)listener).exitCopyData(this);
		}
	}

	public final CopyDataContext copyData() throws RecognitionException {
		CopyDataContext _localctx = new CopyDataContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_copyData);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(67);
			match(T__6);
			setState(68);
			match(T__7);
			setState(69);
			((CopyDataContext)_localctx).name = match(STRING);
			setState(70);
			match(T__8);
			setState(71);
			((CopyDataContext)_localctx).source = match(STRING);
			setState(72);
			match(T__9);
			setState(73);
			((CopyDataContext)_localctx).to = match(STRING);
			setState(74);
			match(T__10);
			setState(75);
			match(T__1);
			setState(76);
			((CopyDataContext)_localctx).value = match(STRING);
			setState(77);
			match(T__2);
			setState(78);
			match(T__11);
			setState(79);
			((CopyDataContext)_localctx).condition = expression();
			setState(80);
			match(T__12);
			setState(81);
			((CopyDataContext)_localctx).writeThreadCount = match(NON_ZERO_DIGIT);
			setState(82);
			match(T__13);
			setState(83);
			((CopyDataContext)_localctx).fetchBatchSize = match(NON_ZERO_DIGIT);
			setState(84);
			match(T__14);
			setState(85);
			((CopyDataContext)_localctx).writeBatchSize = match(NON_ZERO_DIGIT);
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

	public static class TransformContext extends ParserRuleContext {
		public Token name;
		public Token on;
		public Token STRING;
		public List<Token> value = new ArrayList<Token>();
		public ExpressionContext condition;
		public List<TerminalNode> STRING() { return getTokens(RavenParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(RavenParser.STRING, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TransformContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transform; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RavenListener ) ((RavenListener)listener).enterTransform(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RavenListener ) ((RavenListener)listener).exitTransform(this);
		}
	}

	public final TransformContext transform() throws RecognitionException {
		TransformContext _localctx = new TransformContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_transform);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__15);
			setState(88);
			match(T__7);
			setState(89);
			((TransformContext)_localctx).name = match(STRING);
			setState(90);
			match(T__16);
			setState(91);
			((TransformContext)_localctx).on = match(STRING);
			setState(92);
			match(T__10);
			setState(93);
			match(T__1);
			setState(94);
			((TransformContext)_localctx).STRING = match(STRING);
			((TransformContext)_localctx).value.add(((TransformContext)_localctx).STRING);
			setState(95);
			match(T__2);
			setState(96);
			match(T__11);
			setState(97);
			((TransformContext)_localctx).condition = expression();
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

	public static class LoadCsvContext extends ParserRuleContext {
		public Token name;
		public Token source;
		public Token to;
		public Token delim;
		public Token fetchBatchSize;
		public Token writeBatchSize;
		public Token value;
		public ExpressionContext condition;
		public Token writeThreadCount;
		public List<TerminalNode> STRING() { return getTokens(RavenParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(RavenParser.STRING, i);
		}
		public List<TerminalNode> NON_ZERO_DIGIT() { return getTokens(RavenParser.NON_ZERO_DIGIT); }
		public TerminalNode NON_ZERO_DIGIT(int i) {
			return getToken(RavenParser.NON_ZERO_DIGIT, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LoadCsvContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loadCsv; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RavenListener ) ((RavenListener)listener).enterLoadCsv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RavenListener ) ((RavenListener)listener).exitLoadCsv(this);
		}
	}

	public final LoadCsvContext loadCsv() throws RecognitionException {
		LoadCsvContext _localctx = new LoadCsvContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_loadCsv);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__17);
			setState(100);
			match(T__7);
			setState(101);
			((LoadCsvContext)_localctx).name = match(STRING);
			setState(102);
			match(T__8);
			setState(103);
			((LoadCsvContext)_localctx).source = match(STRING);
			setState(104);
			match(T__9);
			setState(105);
			((LoadCsvContext)_localctx).to = match(STRING);
			setState(106);
			match(T__18);
			setState(107);
			((LoadCsvContext)_localctx).delim = match(STRING);
			setState(108);
			match(T__13);
			setState(109);
			((LoadCsvContext)_localctx).fetchBatchSize = match(NON_ZERO_DIGIT);
			setState(110);
			match(T__14);
			setState(111);
			((LoadCsvContext)_localctx).writeBatchSize = match(NON_ZERO_DIGIT);
			setState(112);
			match(T__10);
			setState(113);
			match(T__1);
			setState(114);
			((LoadCsvContext)_localctx).value = match(STRING);
			setState(115);
			match(T__2);
			setState(116);
			match(T__11);
			setState(117);
			((LoadCsvContext)_localctx).condition = expression();
			setState(118);
			match(T__12);
			setState(119);
			((LoadCsvContext)_localctx).writeThreadCount = match(NON_ZERO_DIGIT);
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

	public static class AbortContext extends ParserRuleContext {
		public Token name;
		public Token value;
		public ExpressionContext condition;
		public List<TerminalNode> STRING() { return getTokens(RavenParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(RavenParser.STRING, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AbortContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abort; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RavenListener ) ((RavenListener)listener).enterAbort(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RavenListener ) ((RavenListener)listener).exitAbort(this);
		}
	}

	public final AbortContext abort() throws RecognitionException {
		AbortContext _localctx = new AbortContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_abort);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(T__19);
			setState(122);
			match(T__7);
			setState(123);
			((AbortContext)_localctx).name = match(STRING);
			setState(124);
			match(T__1);
			setState(125);
			((AbortContext)_localctx).value = match(STRING);
			setState(126);
			match(T__2);
			setState(127);
			match(T__11);
			setState(128);
			((AbortContext)_localctx).condition = expression();
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

	public static class CallProcessContext extends ParserRuleContext {
		public Token name;
		public Token target;
		public Token source;
		public Token datasource;
		public Token value;
		public ExpressionContext condition;
		public List<TerminalNode> STRING() { return getTokens(RavenParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(RavenParser.STRING, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CallProcessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callProcess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RavenListener ) ((RavenListener)listener).enterCallProcess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RavenListener ) ((RavenListener)listener).exitCallProcess(this);
		}
	}

	public final CallProcessContext callProcess() throws RecognitionException {
		CallProcessContext _localctx = new CallProcessContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_callProcess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(T__20);
			setState(131);
			match(T__7);
			setState(132);
			((CallProcessContext)_localctx).name = match(STRING);
			setState(133);
			match(T__21);
			setState(134);
			((CallProcessContext)_localctx).target = match(STRING);
			setState(135);
			match(T__22);
			setState(136);
			((CallProcessContext)_localctx).source = match(STRING);
			setState(137);
			match(T__10);
			setState(138);
			((CallProcessContext)_localctx).datasource = match(STRING);
			setState(139);
			match(T__23);
			setState(140);
			match(T__1);
			setState(141);
			((CallProcessContext)_localctx).value = match(STRING);
			setState(142);
			match(T__2);
			setState(143);
			match(T__11);
			setState(144);
			((CallProcessContext)_localctx).condition = expression();
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

	public static class ExpressionContext extends ParserRuleContext {
		public Token lhs;
		public Token operator;
		public Token rhs;
		public List<TerminalNode> STRING() { return getTokens(RavenParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(RavenParser.STRING, i);
		}
		public TerminalNode Operator() { return getToken(RavenParser.Operator, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RavenListener ) ((RavenListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RavenListener ) ((RavenListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(T__24);
			{
			setState(147);
			((ExpressionContext)_localctx).lhs = match(STRING);
			setState(148);
			((ExpressionContext)_localctx).operator = match(Operator);
			setState(149);
			((ExpressionContext)_localctx).rhs = match(STRING);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u009a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\7\3$\n\3\f\3\16"+
		"\3\'\13\3\3\3\3\3\3\4\3\4\3\4\7\4.\n\4\f\4\16\4\61\13\4\3\4\3\4\3\5\3"+
		"\5\3\5\7\58\n\5\f\5\16\5;\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6D\n\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\2\2\r\2\4\6\b\n\f\16\20\22\24\26\2\2\2\u0095\2\30\3\2\2\2\4 \3\2"+
		"\2\2\6*\3\2\2\2\b\64\3\2\2\2\nC\3\2\2\2\fE\3\2\2\2\16Y\3\2\2\2\20e\3\2"+
		"\2\2\22{\3\2\2\2\24\u0084\3\2\2\2\26\u0094\3\2\2\2\30\31\7\3\2\2\31\32"+
		"\7\35\2\2\32\33\7\4\2\2\33\34\5\4\3\2\34\35\5\b\5\2\35\36\5\6\4\2\36\37"+
		"\7\5\2\2\37\3\3\2\2\2 !\7\6\2\2!%\7\4\2\2\"$\5\n\6\2#\"\3\2\2\2$\'\3\2"+
		"\2\2%#\3\2\2\2%&\3\2\2\2&(\3\2\2\2\'%\3\2\2\2()\7\5\2\2)\5\3\2\2\2*+\7"+
		"\7\2\2+/\7\4\2\2,.\5\n\6\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2"+
		"\60\62\3\2\2\2\61/\3\2\2\2\62\63\7\5\2\2\63\7\3\2\2\2\64\65\7\b\2\2\65"+
		"9\7\4\2\2\668\5\n\6\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<"+
		"\3\2\2\2;9\3\2\2\2<=\7\5\2\2=\t\3\2\2\2>D\5\f\7\2?D\5\20\t\2@D\5\24\13"+
		"\2AD\5\16\b\2BD\5\22\n\2C>\3\2\2\2C?\3\2\2\2C@\3\2\2\2CA\3\2\2\2CB\3\2"+
		"\2\2D\13\3\2\2\2EF\7\t\2\2FG\7\n\2\2GH\7\35\2\2HI\7\13\2\2IJ\7\35\2\2"+
		"JK\7\f\2\2KL\7\35\2\2LM\7\r\2\2MN\7\4\2\2NO\7\35\2\2OP\7\5\2\2PQ\7\16"+
		"\2\2QR\5\26\f\2RS\7\17\2\2ST\7\34\2\2TU\7\20\2\2UV\7\34\2\2VW\7\21\2\2"+
		"WX\7\34\2\2X\r\3\2\2\2YZ\7\22\2\2Z[\7\n\2\2[\\\7\35\2\2\\]\7\23\2\2]^"+
		"\7\35\2\2^_\7\r\2\2_`\7\4\2\2`a\7\35\2\2ab\7\5\2\2bc\7\16\2\2cd\5\26\f"+
		"\2d\17\3\2\2\2ef\7\24\2\2fg\7\n\2\2gh\7\35\2\2hi\7\13\2\2ij\7\35\2\2j"+
		"k\7\f\2\2kl\7\35\2\2lm\7\25\2\2mn\7\35\2\2no\7\20\2\2op\7\34\2\2pq\7\21"+
		"\2\2qr\7\34\2\2rs\7\r\2\2st\7\4\2\2tu\7\35\2\2uv\7\5\2\2vw\7\16\2\2wx"+
		"\5\26\f\2xy\7\17\2\2yz\7\34\2\2z\21\3\2\2\2{|\7\26\2\2|}\7\n\2\2}~\7\35"+
		"\2\2~\177\7\4\2\2\177\u0080\7\35\2\2\u0080\u0081\7\5\2\2\u0081\u0082\7"+
		"\16\2\2\u0082\u0083\5\26\f\2\u0083\23\3\2\2\2\u0084\u0085\7\27\2\2\u0085"+
		"\u0086\7\n\2\2\u0086\u0087\7\35\2\2\u0087\u0088\7\30\2\2\u0088\u0089\7"+
		"\35\2\2\u0089\u008a\7\31\2\2\u008a\u008b\7\35\2\2\u008b\u008c\7\r\2\2"+
		"\u008c\u008d\7\35\2\2\u008d\u008e\7\32\2\2\u008e\u008f\7\4\2\2\u008f\u0090"+
		"\7\35\2\2\u0090\u0091\7\5\2\2\u0091\u0092\7\16\2\2\u0092\u0093\5\26\f"+
		"\2\u0093\25\3\2\2\2\u0094\u0095\7\33\2\2\u0095\u0096\7\35\2\2\u0096\u0097"+
		"\7\37\2\2\u0097\u0098\7\35\2\2\u0098\27\3\2\2\2\6%/9C";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}