// Generated from AnalizLex.g4 by ANTLR 4.4

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
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, COMA=2, PCOMA=3, APARE=4, CPARE=5, ALLAV=6, CLLAV=7, ASUMA=8, 
		ASIG=9, MAYOR=10, EQUAL=11, LOGAND=12, ASIGMOD=13, MASMAS=14, TRUE=15, 
		FALSE=16, VAR=17, INT=18, BOOL=19, CHAR=20, WRITE=21, WHILE=22, PROMPT=23, 
		FUNCTION=24, RETURN=25, IF=26, FOR=27, BREAK=28, ID=29, NUM=30, CADENA=31, 
		COMMENT=32, LINE_COMMENT=33, DEL=34;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'"
	};
	public static final String[] ruleNames = {
		"T__0", "COMA", "PCOMA", "APARE", "CPARE", "ALLAV", "CLLAV", "ASUMA", 
		"ASIG", "MAYOR", "EQUAL", "LOGAND", "ASIGMOD", "MASMAS", "TRUE", "FALSE", 
		"VAR", "INT", "BOOL", "CHAR", "WRITE", "WHILE", "PROMPT", "FUNCTION", 
		"RETURN", "IF", "FOR", "BREAK", "ID", "NUM", "CADENA", "COMMENT", "LINE_COMMENT", 
		"DEL", "LETRA", "DIGITO", "TEXTSTRING", "TEXTCOMMENT1", "TEXTCOMMENT2"
	};


	public AnalizLexLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "AnalizLex.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2$\u00fe\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\36\3\36\3\36\7\36\u00c2\n\36\f\36\16\36\u00c5\13\36\3\37"+
		"\6\37\u00c8\n\37\r\37\16\37\u00c9\3 \3 \7 \u00ce\n \f \16 \u00d1\13 \3"+
		" \3 \3!\3!\3!\3!\7!\u00d9\n!\f!\16!\u00dc\13!\3!\3!\3!\3!\3!\3\"\3\"\3"+
		"\"\3\"\7\"\u00e7\n\"\f\"\16\"\u00ea\13\"\3\"\3\"\3#\3#\3#\5#\u00f1\n#"+
		"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3\u00da\2)\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G\2I\2K\2M"+
		"\2O\2\3\2\t\4\2\f\f\17\17\5\2\13\f\17\17\"\"\4\2C\\c|\3\2\62;\3\2$$\4"+
		"\2,,^^\5\2,,\61\61^^\u00ff\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\3Q\3\2\2\2\5S\3\2\2\2\7U\3\2\2\2\tW\3\2\2\2\13Y\3\2\2"+
		"\2\r[\3\2\2\2\17]\3\2\2\2\21_\3\2\2\2\23a\3\2\2\2\25c\3\2\2\2\27e\3\2"+
		"\2\2\31h\3\2\2\2\33k\3\2\2\2\35n\3\2\2\2\37q\3\2\2\2!v\3\2\2\2#|\3\2\2"+
		"\2%\u0080\3\2\2\2\'\u0084\3\2\2\2)\u0089\3\2\2\2+\u008e\3\2\2\2-\u0094"+
		"\3\2\2\2/\u009a\3\2\2\2\61\u00a1\3\2\2\2\63\u00aa\3\2\2\2\65\u00b1\3\2"+
		"\2\2\67\u00b4\3\2\2\29\u00b8\3\2\2\2;\u00be\3\2\2\2=\u00c7\3\2\2\2?\u00cb"+
		"\3\2\2\2A\u00d4\3\2\2\2C\u00e2\3\2\2\2E\u00f0\3\2\2\2G\u00f4\3\2\2\2I"+
		"\u00f6\3\2\2\2K\u00f8\3\2\2\2M\u00fa\3\2\2\2O\u00fc\3\2\2\2QR\7\f\2\2"+
		"R\4\3\2\2\2ST\7.\2\2T\6\3\2\2\2UV\7=\2\2V\b\3\2\2\2WX\7*\2\2X\n\3\2\2"+
		"\2YZ\7+\2\2Z\f\3\2\2\2[\\\7}\2\2\\\16\3\2\2\2]^\7\177\2\2^\20\3\2\2\2"+
		"_`\7-\2\2`\22\3\2\2\2ab\7?\2\2b\24\3\2\2\2cd\7@\2\2d\26\3\2\2\2ef\7?\2"+
		"\2fg\7?\2\2g\30\3\2\2\2hi\7(\2\2ij\7(\2\2j\32\3\2\2\2kl\7\'\2\2lm\7?\2"+
		"\2m\34\3\2\2\2no\7-\2\2op\7-\2\2p\36\3\2\2\2qr\7v\2\2rs\7t\2\2st\7w\2"+
		"\2tu\7g\2\2u \3\2\2\2vw\7h\2\2wx\7c\2\2xy\7n\2\2yz\7u\2\2z{\7g\2\2{\""+
		"\3\2\2\2|}\7x\2\2}~\7c\2\2~\177\7t\2\2\177$\3\2\2\2\u0080\u0081\7k\2\2"+
		"\u0081\u0082\7p\2\2\u0082\u0083\7v\2\2\u0083&\3\2\2\2\u0084\u0085\7d\2"+
		"\2\u0085\u0086\7q\2\2\u0086\u0087\7q\2\2\u0087\u0088\7n\2\2\u0088(\3\2"+
		"\2\2\u0089\u008a\7e\2\2\u008a\u008b\7j\2\2\u008b\u008c\7c\2\2\u008c\u008d"+
		"\7t\2\2\u008d*\3\2\2\2\u008e\u008f\7y\2\2\u008f\u0090\7t\2\2\u0090\u0091"+
		"\7k\2\2\u0091\u0092\7v\2\2\u0092\u0093\7g\2\2\u0093,\3\2\2\2\u0094\u0095"+
		"\7y\2\2\u0095\u0096\7j\2\2\u0096\u0097\7k\2\2\u0097\u0098\7n\2\2\u0098"+
		"\u0099\7g\2\2\u0099.\3\2\2\2\u009a\u009b\7r\2\2\u009b\u009c\7t\2\2\u009c"+
		"\u009d\7q\2\2\u009d\u009e\7o\2\2\u009e\u009f\7r\2\2\u009f\u00a0\7v\2\2"+
		"\u00a0\60\3\2\2\2\u00a1\u00a2\7h\2\2\u00a2\u00a3\7w\2\2\u00a3\u00a4\7"+
		"p\2\2\u00a4\u00a5\7e\2\2\u00a5\u00a6\7v\2\2\u00a6\u00a7\7k\2\2\u00a7\u00a8"+
		"\7q\2\2\u00a8\u00a9\7p\2\2\u00a9\62\3\2\2\2\u00aa\u00ab\7t\2\2\u00ab\u00ac"+
		"\7g\2\2\u00ac\u00ad\7v\2\2\u00ad\u00ae\7w\2\2\u00ae\u00af\7t\2\2\u00af"+
		"\u00b0\7p\2\2\u00b0\64\3\2\2\2\u00b1\u00b2\7k\2\2\u00b2\u00b3\7h\2\2\u00b3"+
		"\66\3\2\2\2\u00b4\u00b5\7h\2\2\u00b5\u00b6\7q\2\2\u00b6\u00b7\7t\2\2\u00b7"+
		"8\3\2\2\2\u00b8\u00b9\7d\2\2\u00b9\u00ba\7t\2\2\u00ba\u00bb\7g\2\2\u00bb"+
		"\u00bc\7c\2\2\u00bc\u00bd\7m\2\2\u00bd:\3\2\2\2\u00be\u00c3\5G$\2\u00bf"+
		"\u00c2\5G$\2\u00c0\u00c2\5I%\2\u00c1\u00bf\3\2\2\2\u00c1\u00c0\3\2\2\2"+
		"\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4<\3"+
		"\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c8\5I%\2\u00c7\u00c6\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca>\3\2\2\2"+
		"\u00cb\u00cf\7$\2\2\u00cc\u00ce\5K&\2\u00cd\u00cc\3\2\2\2\u00ce\u00d1"+
		"\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1"+
		"\u00cf\3\2\2\2\u00d2\u00d3\7$\2\2\u00d3@\3\2\2\2\u00d4\u00d5\7\61\2\2"+
		"\u00d5\u00d6\7,\2\2\u00d6\u00da\3\2\2\2\u00d7\u00d9\13\2\2\2\u00d8\u00d7"+
		"\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00db\3\2\2\2\u00da\u00d8\3\2\2\2\u00db"+
		"\u00dd\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00de\7,\2\2\u00de\u00df\7\61"+
		"\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\b!\2\2\u00e1B\3\2\2\2\u00e2\u00e3"+
		"\7\61\2\2\u00e3\u00e4\7\61\2\2\u00e4\u00e8\3\2\2\2\u00e5\u00e7\n\2\2\2"+
		"\u00e6\u00e5\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9"+
		"\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00ec\b\"\2\2\u00ec"+
		"D\3\2\2\2\u00ed\u00f1\t\3\2\2\u00ee\u00ef\7\17\2\2\u00ef\u00f1\7\f\2\2"+
		"\u00f0\u00ed\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3"+
		"\b#\2\2\u00f3F\3\2\2\2\u00f4\u00f5\t\4\2\2\u00f5H\3\2\2\2\u00f6\u00f7"+
		"\t\5\2\2\u00f7J\3\2\2\2\u00f8\u00f9\n\6\2\2\u00f9L\3\2\2\2\u00fa\u00fb"+
		"\n\7\2\2\u00fbN\3\2\2\2\u00fc\u00fd\n\b\2\2\u00fdP\3\2\2\2\n\2\u00c1\u00c3"+
		"\u00c9\u00cf\u00da\u00e8\u00f0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}