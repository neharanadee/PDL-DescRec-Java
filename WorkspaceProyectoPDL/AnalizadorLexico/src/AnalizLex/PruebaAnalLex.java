package AnalizLex;

import java.util.List;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class PruebaAnalLex {
  public static void main( String[] args) throws Exception 
  {
    AnalizLexLexer lexer = new AnalizLexLexer( new ANTLRFileStream(args[0]));
    CommonTokenStream tokens = new CommonTokenStream( lexer );
    List<Token> listaTokens = tokens.getTokens();
    System.out.println(listaTokens.isEmpty());
    System.out.println("p1");
    AnalizLexParser parser = new AnalizLexParser( tokens );
    ParseTree tree = parser.r();
    ParseTreeWalker walker = new ParseTreeWalker();
//    walker.walk( new AnalizLexWalker(), tree );
  }
}