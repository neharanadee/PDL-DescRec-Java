// Generated from AnalizLex.g4 by ANTLR 4.5.1

package analizadorlex;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AnalizLexLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMA=1, PCOMA=2, APARE=3, CPARE=4, ALLAV=5, CLLAV=6, ASUMA=7, ASIG=8, 
		MAYOR=9, EQUAL=10, LOGAND=11, ASIGMOD=12, MASMAS=13, TRUE=14, FALSE=15, 
		VAR=16, INT=17, BOOL=18, CHAR=19, WRITE=20, WHILE=21, PROMPT=22, FUNCTION=23, 
		RETURN=24, IF=25, FOR=26, BREAK=27, ID=28, NUM=29, CADENA=30, COMMENT=31, 
		LINE_COMMENT=32, DEL=33;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"COMA", "PCOMA", "APARE", "CPARE", "ALLAV", "CLLAV", "ASUMA", "ASIG", 
		"MAYOR", "EQUAL", "LOGAND", "ASIGMOD", "MASMAS", "TRUE", "FALSE", "VAR", 
		"INT", "BOOL", "CHAR", "WRITE", "WHILE", "PROMPT", "FUNCTION", "RETURN", 
		"IF", "FOR", "BREAK", "ID", "NUM", "CADENA", "COMMENT", "LINE_COMMENT", 
		"DEL", "LETRA", "DIGITO", "TEXTSTRING", "TEXTCOMMENT1", "TEXTCOMMENT2"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "';'", "'('", "')'", "'{'", "'}'", "'+'", "'='", "'>'", "'=='", 
		"'&&'", "'%='", "'++'", "'true'", "'false'", "'var'", "'int'", "'bool'", 
		"'char'", "'write'", "'while'", "'prompt'", "'function'", "'return'", 
		"'if'", "'for'", "'break'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "COMA", "PCOMA", "APARE", "CPARE", "ALLAV", "CLLAV", "ASUMA", "ASIG", 
		"MAYOR", "EQUAL", "LOGAND", "ASIGMOD", "MASMAS", "TRUE", "FALSE", "VAR", 
		"INT", "BOOL", "CHAR", "WRITE", "WHILE", "PROMPT", "FUNCTION", "RETURN", 
		"IF", "FOR", "BREAK", "ID", "NUM", "CADENA", "COMMENT", "LINE_COMMENT", 
		"DEL"
	};
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


	public AnalizLexLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "AnalizLex.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2#\u00f5\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35"+
		"\3\35\3\35\7\35\u00be\n\35\f\35\16\35\u00c1\13\35\3\36\6\36\u00c4\n\36"+
		"\r\36\16\36\u00c5\3\37\3\37\7\37\u00ca\n\37\f\37\16\37\u00cd\13\37\3\37"+
		"\3\37\3 \3 \3 \3 \7 \u00d5\n \f \16 \u00d8\13 \3 \3 \3 \3 \3 \3!\3!\3"+
		"!\3!\7!\u00e3\n!\f!\16!\u00e6\13!\3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3"+
		"&\3\'\3\'\3\u00d6\2(\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E\2G\2I\2K\2M\2\3\2\t\4\2\f\f\17\17\5\2\13"+
		"\f\17\17\"\"\4\2C\\c|\3\2\62;\3\2$$\4\2,,^^\5\2,,\61\61^^\u00f5\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\3O\3\2\2\2\5Q\3\2\2\2\7S"+
		"\3\2\2\2\tU\3\2\2\2\13W\3\2\2\2\rY\3\2\2\2\17[\3\2\2\2\21]\3\2\2\2\23"+
		"_\3\2\2\2\25a\3\2\2\2\27d\3\2\2\2\31g\3\2\2\2\33j\3\2\2\2\35m\3\2\2\2"+
		"\37r\3\2\2\2!x\3\2\2\2#|\3\2\2\2%\u0080\3\2\2\2\'\u0085\3\2\2\2)\u008a"+
		"\3\2\2\2+\u0090\3\2\2\2-\u0096\3\2\2\2/\u009d\3\2\2\2\61\u00a6\3\2\2\2"+
		"\63\u00ad\3\2\2\2\65\u00b0\3\2\2\2\67\u00b4\3\2\2\29\u00ba\3\2\2\2;\u00c3"+
		"\3\2\2\2=\u00c7\3\2\2\2?\u00d0\3\2\2\2A\u00de\3\2\2\2C\u00e9\3\2\2\2E"+
		"\u00eb\3\2\2\2G\u00ed\3\2\2\2I\u00ef\3\2\2\2K\u00f1\3\2\2\2M\u00f3\3\2"+
		"\2\2OP\7.\2\2P\4\3\2\2\2QR\7=\2\2R\6\3\2\2\2ST\7*\2\2T\b\3\2\2\2UV\7+"+
		"\2\2V\n\3\2\2\2WX\7}\2\2X\f\3\2\2\2YZ\7\177\2\2Z\16\3\2\2\2[\\\7-\2\2"+
		"\\\20\3\2\2\2]^\7?\2\2^\22\3\2\2\2_`\7@\2\2`\24\3\2\2\2ab\7?\2\2bc\7?"+
		"\2\2c\26\3\2\2\2de\7(\2\2ef\7(\2\2f\30\3\2\2\2gh\7\'\2\2hi\7?\2\2i\32"+
		"\3\2\2\2jk\7-\2\2kl\7-\2\2l\34\3\2\2\2mn\7v\2\2no\7t\2\2op\7w\2\2pq\7"+
		"g\2\2q\36\3\2\2\2rs\7h\2\2st\7c\2\2tu\7n\2\2uv\7u\2\2vw\7g\2\2w \3\2\2"+
		"\2xy\7x\2\2yz\7c\2\2z{\7t\2\2{\"\3\2\2\2|}\7k\2\2}~\7p\2\2~\177\7v\2\2"+
		"\177$\3\2\2\2\u0080\u0081\7d\2\2\u0081\u0082\7q\2\2\u0082\u0083\7q\2\2"+
		"\u0083\u0084\7n\2\2\u0084&\3\2\2\2\u0085\u0086\7e\2\2\u0086\u0087\7j\2"+
		"\2\u0087\u0088\7c\2\2\u0088\u0089\7t\2\2\u0089(\3\2\2\2\u008a\u008b\7"+
		"y\2\2\u008b\u008c\7t\2\2\u008c\u008d\7k\2\2\u008d\u008e\7v\2\2\u008e\u008f"+
		"\7g\2\2\u008f*\3\2\2\2\u0090\u0091\7y\2\2\u0091\u0092\7j\2\2\u0092\u0093"+
		"\7k\2\2\u0093\u0094\7n\2\2\u0094\u0095\7g\2\2\u0095,\3\2\2\2\u0096\u0097"+
		"\7r\2\2\u0097\u0098\7t\2\2\u0098\u0099\7q\2\2\u0099\u009a\7o\2\2\u009a"+
		"\u009b\7r\2\2\u009b\u009c\7v\2\2\u009c.\3\2\2\2\u009d\u009e\7h\2\2\u009e"+
		"\u009f\7w\2\2\u009f\u00a0\7p\2\2\u00a0\u00a1\7e\2\2\u00a1\u00a2\7v\2\2"+
		"\u00a2\u00a3\7k\2\2\u00a3\u00a4\7q\2\2\u00a4\u00a5\7p\2\2\u00a5\60\3\2"+
		"\2\2\u00a6\u00a7\7t\2\2\u00a7\u00a8\7g\2\2\u00a8\u00a9\7v\2\2\u00a9\u00aa"+
		"\7w\2\2\u00aa\u00ab\7t\2\2\u00ab\u00ac\7p\2\2\u00ac\62\3\2\2\2\u00ad\u00ae"+
		"\7k\2\2\u00ae\u00af\7h\2\2\u00af\64\3\2\2\2\u00b0\u00b1\7h\2\2\u00b1\u00b2"+
		"\7q\2\2\u00b2\u00b3\7t\2\2\u00b3\66\3\2\2\2\u00b4\u00b5\7d\2\2\u00b5\u00b6"+
		"\7t\2\2\u00b6\u00b7\7g\2\2\u00b7\u00b8\7c\2\2\u00b8\u00b9\7m\2\2\u00b9"+
		"8\3\2\2\2\u00ba\u00bf\5E#\2\u00bb\u00be\5E#\2\u00bc\u00be\5G$\2\u00bd"+
		"\u00bb\3\2\2\2\u00bd\u00bc\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2"+
		"\2\2\u00bf\u00c0\3\2\2\2\u00c0:\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c4"+
		"\5G$\2\u00c3\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c6<\3\2\2\2\u00c7\u00cb\7$\2\2\u00c8\u00ca\5I%\2\u00c9"+
		"\u00c8\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2"+
		"\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00cf\7$\2\2\u00cf"+
		">\3\2\2\2\u00d0\u00d1\7\61\2\2\u00d1\u00d2\7,\2\2\u00d2\u00d6\3\2\2\2"+
		"\u00d3\u00d5\13\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d7"+
		"\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9"+
		"\u00da\7,\2\2\u00da\u00db\7\61\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\b "+
		"\2\2\u00dd@\3\2\2\2\u00de\u00df\7\61\2\2\u00df\u00e0\7\61\2\2\u00e0\u00e4"+
		"\3\2\2\2\u00e1\u00e3\n\2\2\2\u00e2\u00e1\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4"+
		"\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00e4\3\2"+
		"\2\2\u00e7\u00e8\b!\2\2\u00e8B\3\2\2\2\u00e9\u00ea\t\3\2\2\u00eaD\3\2"+
		"\2\2\u00eb\u00ec\t\4\2\2\u00ecF\3\2\2\2\u00ed\u00ee\t\5\2\2\u00eeH\3\2"+
		"\2\2\u00ef\u00f0\n\6\2\2\u00f0J\3\2\2\2\u00f1\u00f2\n\7\2\2\u00f2L\3\2"+
		"\2\2\u00f3\u00f4\n\b\2\2\u00f4N\3\2\2\2\t\2\u00bd\u00bf\u00c5\u00cb\u00d6"+
		"\u00e4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}