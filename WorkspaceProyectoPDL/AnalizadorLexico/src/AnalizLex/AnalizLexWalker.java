package AnalizLex;

public class AnalizLexWalker extends AnalizLexBaseListener {
	  public void enterR(AnalizLexParser.RContext ctx ) {
	    System.out.println( "Entering R : " + ctx.r().getText() );
	  }

	  public void exitR(AnalizLexParser.RContext ctx ) {
	    System.out.println( "Exiting R" );
	  }
	}