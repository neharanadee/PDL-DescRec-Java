/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio Chica
 */
public class Main {

	/**
	 * Muestra un menu para elegir la opcion
	 * mas conveniente
	 * @param args the command line arguments
	 */
	static Yytoken tokenActual = null;
	static AnalizadorLexico a = null;

	public static void main(String[] args) {
		int opcion = 0;

		java.util.Scanner in = new java.util.Scanner(System.in);

		System.out.println("Seleccione una opcion:");
		System.out.println("1) Generar Analizador Lexico a partir de alexico.flex");
		System.out.println("2) Ejecutar archivo entrada.txt");
		System.out.print("Opcion: ");
		opcion = in.nextInt();
		switch (opcion) {
		case 1: {
			System.out.println("\n*** Generando ***\n");
			System.out.println("\n*** Procesando archivo alexico.flex ***\n");
			String archLex = "alexico.flex";
			String[] entrada = {archLex};
			jflex.Main.main(entrada);
			//Movemos el archivo generado al directorio src
			File arch = new File("AnalizadorLexico.java");
			if(arch.exists()){
				System.out.println("" + arch);
				Path currentRelativePath = Paths.get("");
				String nuevoDir = currentRelativePath.toAbsolutePath().toString()
						+ File.separator + "src" + File.separator 
						+ "analizadorlex" + File.separator+arch.getName();
				File archViejo = new File(nuevoDir);
				archViejo.delete();
				if(arch.renameTo(new File(nuevoDir))){
					System.out.println("\n*** Generado ***\n");
					System.out.println("\n*** Saliendo automaticamente ***\n");
					System.exit(0);
				}else{
					System.out.println("\n*** No generado ***\n");
				}
			}else{
				System.out.println("\n*** Codigo no existente ***\n");
			}
			break;
		}
		case 2: {
			String entrada = "";
			System.out.println("*** Procesando archivo entrada.txt ***");
			entrada = "entrada.txt";
			BufferedReader bf = null;

			try {
				bf = new BufferedReader(new FileReader(entrada));
				a = new AnalizadorLexico(bf);
				tokenActual = a.sigToken(); //Primer token
				P();
				//				do {//Todo el codigo
				//					token = a.sigToken();
				//					System.out.println(token.toString());
				//				} while (token != null);
			} catch (Exception ex) {
				System.err.println(ex);
				System.err.println("El token que no se encontro es: "+tokenActual+" linea "+linea()+"\n\n");//luego se quita
				//Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				try {
					bf.close();
				} catch (IOException ex) {
					//Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			break;
		}
		default: {
			System.out.println("Opcion no valida.");
			break;
		}
		}

	}

	public static void compToken(String token){
		if(token.equals("Id")){
			if(tokenActual.tipo.equals(token)){
				try{
					tokenActual=a.sigToken();
				}catch (Exception ex) {
				}
			}else
				throw new RuntimeException("Para el carro!!Token invalido en comprobarToken - Id");
		}else if(token.equals("eol")){
			if(tokenActual.tipo.equals(token)){
				try{
					tokenActual=a.sigToken();
				}catch (Exception ex) {
				}
			}else
				throw new RuntimeException("Para el carro!!Token invalido en comprobarToken - eol");
		}else if(token.equals("eof")){
			if(tokenActual.tipo.equals(token)){
				try{
					tokenActual=a.sigToken();
				}catch (Exception ex) {
				}
			}else
				throw new RuntimeException("Para el carro!!Token invalido en comprobarToken - eof");
		}else if(token.equals("Num")){
			if(tokenActual.tipo.equals(token)){
				try{
					tokenActual=a.sigToken();
				}catch (Exception ex) {
				}
			}else
				throw new RuntimeException("Para el carro!!Token invalido en comprobarToken - Num");
		}else if(token.equals("Cadena")){
			if(tokenActual.tipo.equals(token)){
				try{
					tokenActual=a.sigToken();
				}catch (Exception ex) {
				}
			}else
				throw new RuntimeException("Para el carro!!Token invalido en comprobarToken - Cadena");
		}else{
			if(tokenActual.token.equals(token)){
				try{
					tokenActual=a.sigToken();
				}catch (Exception ex) {
				}
			}else
				throw new RuntimeException("Para el carro!!Token invalido en comprobarToken - Resto");
		}
	}

	public static Entrada P(){//P -> B Z P | F Z P | Z P | eof.
		if(tokenActual.token.equals("var") || tokenActual.token.equals("if") || tokenActual.token.equals("for") || 
				tokenActual.tipo.equals("Id") || tokenActual.token.equals("return") || tokenActual.token.equals("write")
				|| tokenActual.token.equals("prompt")){//First(BZP) = var, if, for, id, return, write, prompt
			B();
			Z();
			P();

		}else if (tokenActual.token.equals("function")){//First(FZP) = function
			F();
			Z();
			P();

		}else if (tokenActual.tipo.equals("eol")){//First(ZP) = cr
			Z();
			P();

		}else if (tokenActual.tipo.equals("eof")){//First(eof) = eof
			compToken("eof");

		}else {
			throw new RuntimeException("Error en P, no se ha aceptado ningun token");

		}

	}
	public static void Z(){//Z -> cr Z'.
		if(tokenActual.tipo.equals("eol")){//First(crZ') = cr
			compToken("eol");
			Zp();
			//return new Entrada(0,null,null,0,null,null);
		}else
			throw new RuntimeException("Error en Z, no se ha aceptado ningun token");
	}
	public static void Zp(){//Z' -> Z | oc.
		if(tokenActual.tipo.equals("eol")){//First(Z) = cr
			Z();
			//return new Entrada(0,null,null,0,null,null);
		}else{
			//Otro caracter
			//return new Entrada(0,null,null,0,null,null);
		}
	}
	public static Entrada B(){//B -> var T id W | if ( E ) S | S | for ( S ; E ; S ) Z { Z C }.
		if(tokenActual.token.equals("var")){//First(varTidW) = var
			compToken("var");
			//try{
			Entrada T = T();
			//}catch(Exception ex){
			//	System.err.println(ex);
			//	System.exit(1);
			//}
			compToken("Id");
			/*add id TS*/
			Entrada W = W();
			for (String s : W.getParam()) { 
				if (!s.equals(T.getTipo())) 
					System.out.println("Error (linea "+ linea() +"): se esperaba tipo "+T.getTipo()+" se declara como "+ s +"" );
			}
			/*add tipo y despl a ids desde este al final con T.tipo y T.despl*/
			return new Entrada(0,null,null,0,null,null);

		}else if(tokenActual.token.equals("if")){// First(if(E)S) = if
			compToken("if");
			compToken("(");
			Entrada E = E();
			if (E.getTipo()!="boolean") 
				System.out.println("Error (linea "+linea()+"): condicional espera tipo logico, se introduce "+E.getTipo()+"");
			compToken(")");
			Entrada S = S();
			if (S.getTipo().equals("err") )
				System.out.println("Error (linea "+linea()+"): sentencia del condicional incorrecta");
			return new Entrada(0,null,S.getTipo(),0,null,null);

		}else if(tokenActual.tipo.equals("Id") || tokenActual.token.equals("return")
				|| tokenActual.token.equals("write")
				|| tokenActual.token.equals("prompt")){//First(S)= id, return, write, prompt
			Entrada S = S();
			if ( S.getTipo().equals("err") )
				System.out.println("Error (linea "+linea()+"): sentencia incorrecta");
			return new Entrada(0,null,S.getTipo(),0,null,null);
			
		}else if(tokenActual.token.equals("for")){//First(for(S;E;S)Z{ZC}) = for
			compToken("for");
			compToken("(");
			Entrada S1 = S();
			if ( S1.getTipo().equals("err") )
				System.out.println("Error (linea "+linea()+"): sentencia incorrecta primera parte del for");
			compToken(";");
			Entrada E = E();
			if ( !E.getTipo().equals("boolean") )
				System.out.println("Error (linea "+linea()+"): sentencia incorrecta segunda parte del for");
			compToken(";");
			Entrada S2 = S();
			if (S2.getTipo().equals("err") )
				System.out.println("Error (linea "+linea()+"): sentencia incorrecta tercera parte del for");
			compToken(")");
			Z();
			compToken("{");
			Z();
			C();
			compToken("}");
			return new Entrada(0,null,null,0,null,null);

		}else
			throw new RuntimeException("Error en B, no se ha aceptado ningun token");
	}	
	public static Entrada W(){//W -> , id W | = E W' | LAMBDA.
		if(tokenActual.token.equals(",")){//First(,idW) = ,
			compToken(",");
			compToken("Id");
			/*addTS id */
			Entrada W = W();
			return new Entrada(0,null,null,0,W.getParam(),null);

		}else if(tokenActual.token.equals("=")){// First(=EW) = =
			compToken("=");
			Entrada E = E();
			Entrada Wp = Wp();
			ArrayList<String> tipos = new ArrayList<String>();
			tipos.add(E.getTipo());
			tipos.addAll(Wp.getParam()); // for (String s : Wp.getParam() ) { tipos.add(s); }
			return new Entrada(0,null,null,0,tipos,null);

		}else if(tokenActual.tipo.equals("eol")){// Follow(W) = cr
			// Nothing
			return new Entrada(0,null,null,0,null,null);
			
		}else
			throw new RuntimeException("Error en W, no se ha aceptado ningun token");
	}
	public static Entrada Wp() { //W' -> , id W | LAMBDA.
		if(tokenActual.token.equals(",")) { //First(, id W) =  , 
			compToken(",");
			compToken("Id");
			/*addTS id*/
			Entrada W = W();
			return new Entrada(0,null,null,0,W.getParam(),null);
			
		}else if(tokenActual.tipo.equals("eol")){ // Follow(W') = cr
			//Nothing
			return new Entrada(0,null,null,0,null,null);
			
		}else
			throw new RuntimeException("Error en W', no se ha aceptado ningun token");
	}

	public static Entrada S(){//S -> id S' | return X | write ( E ) | prompt ( id ).
		if(tokenActual.tipo.equals("Id")){//First(idS') = id
			compToken("Id");
			Entrada Sp = Sp();
			if ( /*!found id && */ !Sp.getTipo().equals("int") ) {
				/*addTS global id como int*/
				System.out.println("Error (linea "+linea()+"): se asigna tipo "+Sp.getTipo()+" a una variable tipo int");
				return new Entrada (0,null,"err",0,null,null);
			} else if ( /*found id && */ !Sp.getTipo().equals("tipoiddTS" )) {
				System.out.println("Error (linea "+linea()+"): se asigna tipo "+Sp.getTipo()+" a una variable tipo tipoiddTS");
				return new Entrada (0,null,"err",0,null,null);
			}
			/*addTS id Sp.tipo, Sp.tam */
			return new Entrada (0,null,"ok",0,null,null);
			
		}else if(tokenActual.token.equals("return")){// First(returnX) = return
			compToken("return");
			Entrada X = X();
			return new Entrada (0,null,"ok",X.getDespl(),null,X.getTipo());
			
		}else if(tokenActual.token.equals("write")){// First(write(E)) = write
			compToken("write");
			compToken("(");
			Entrada E = E();
			compToken(")");
			return new Entrada (0,null,"ok",0,null,null);

		}else if(tokenActual.token.equals("prompt")){// First(prompt(id)) = prompt
			compToken("prompt");
			compToken("(");
			compToken("Id");
			compToken(")");
			return new Entrada (0,null,"ok",0,null,null);
			
		}else
			throw new RuntimeException("Error en S, no se ha aceptado ningun token");
	}
	public static Entrada Sp(){//S' -> = E | %= E | ( L ).
		if(tokenActual.token.equals("=")){//First(=E) = =
			compToken("=");
			Entrada E = E();
			return new Entrada (0,null,E.getTipo(),E.getDespl(),null,null);
			
		}else if(tokenActual.token.equals("%=")){// First(%=E) = %=
			compToken("%=");
			Entrada E = E();
			if ( !E.getTipo().equals("int") ) {
				System.out.println("Error (linea "+linea()+"): se usa tipo "+E.getTipo()+" en %= que solo permite int");
				return new Entrada (0,null,"err",0,null,null);
			}				
			return new Entrada(0,null,"int",E.getDespl(),null,null);

		}else if(tokenActual.token.equals("(")){// First((L)) = (
			compToken("(");
			Entrada L = L();
			compToken(")");
			return new Entrada (0,null,null,0,L.getParam(),null);
			
		}else
			throw new RuntimeException("Error en Sp, no se ha aceptado ningun token");
	}
	public static Entrada T() /*throws TipoVaribleNoDefinido*/{//T -> int | boolean | char.
		if(tokenActual.token.equals("int")){//First(int) = int
			compToken("int");
			return new Entrada (0,null,"int",2,null,null);

		}else if(tokenActual.token.equals("boolean")){// First(boolean) = boolean
			compToken("boolean");
			return new Entrada (0,null,"boolean",1,null,null);

		}else if(tokenActual.token.equals("char")){// First(char) = char
			compToken("char");
			return new Entrada (0,null,"char",1,null,null);

		}else{
			//System.err.print("Linea "+tokenActual.linea+", ");
			//throw new TipoVaribleNoDefinido("Se debe definir un tipo de variable en la declaracion");
			throw new RuntimeException("Error en T, no se ha aceptado ningun token");
		}

	}
	public static Entrada X(){//X -> E | LAMBDA.
		if(tokenActual.tipo.equals("Id") || tokenActual.token.equals("(")
				|| tokenActual.tipo.equals("Num")
				|| tokenActual.tipo.equals("Cadena")
				|| tokenActual.token.equals("true")
				|| tokenActual.token.equals("false")){//First(E) = id, (, num, cadena, true, false
			Entrada E = E();
			return new Entrada (0,null,E.getTipo(),E.getDespl(),null,null);

		}else if(tokenActual.token.equals(")") || tokenActual.token.equals(",")
				|| tokenActual.token.equals("=")
				|| tokenActual.token.equals(";")
				|| tokenActual.tipo.equals("eol")){// Follow(E) = ), ,, =, ;, cr
			// Nothing
			return new Entrada (0,null,null,0,null,null);

		}else
			throw new RuntimeException("Error en X, no se ha aceptado ningun token");
	}
	public static Entrada L(){//L -> E Q | LAMBDA.
		if(tokenActual.tipo.equals("Id")||tokenActual.token.equals("(")
				|| tokenActual.tipo.equals("Num")
				|| tokenActual.tipo.equals("Cadena")
				|| tokenActual.token.equals("true")
				|| tokenActual.token.equals("false")){//First(EQ) = id, (, num, cadena, true, false
			Entrada E = E();
			Entrada Q = Q();
			ArrayList<String> expr = new ArrayList<String>();
			expr.add(E.getTipo());
			expr.addAll(Q.getParam());
			return new Entrada (0,null,null,0,expr,null);

		}else if(tokenActual.token.equals(")")){// Follow(L) = )
			// Nothing
			return new Entrada (0,null,null,0,null,null);

		}else
			throw new RuntimeException("Error en L, no se ha aceptado ningun token");
	}
	public static Entrada Q(){//Q -> , E Q | LAMBDA.
		if(tokenActual.token.equals(",")){//First(,EQ) = ,
			compToken(",");
			Entrada E = E();
			Entrada Q = Q();
			ArrayList<String> expr = new ArrayList<String>();
			expr.add(E.getTipo());
			expr.addAll(Q.getParam());
			return new Entrada (0,null,null,0,expr,null);

		}else if(tokenActual.token.equals(")")){// Follow(Q) = )
			// Nothing
			return new Entrada (0,null,null,0,null,null);

		}else
			throw new RuntimeException("Error en Q, no se ha aceptado ningun token");
	}
	public static Entrada F(){//F -> function H id ( A )  Z { Z C }.
		if(tokenActual.token.equals("function")){//First(functionHid(A)Z{ZC}) = function
			/*Crea sub-TS*/
			compToken("function");
			Entrada H = H();
			compToken("Id");
			/*addTS id tipo ret H.tipo*/
			compToken("(");
			Entrada A = A();
			compToken(")");
			/*addTS id tipo funcion retorno tipo H, argumentos entrada params de A */
			Z();
			compToken("{");
			Z();
			Entrada C = C();
			compToken("}");
			/*Tipo devuelto por C sea el de H*/
			return new Entrada (0,null,(H.getTipo()==C.getTipo())?"ok":"err",0,null,null);

		}else
			throw new RuntimeException("Error en F, no se ha aceptado ningun token");
	}
	public static Entrada H(){//H -> T | LAMBDA.
		if(tokenActual.token.equals("int") || tokenActual.token.equals("boolean")
				|| tokenActual.token.equals("char")){//First(T) = int, boolean, char
			//try{
			Entrada T = T();
			//}catch(Exception ex){
			//System.err.println(ex);
			//System.exit(1);
			//}
			return new Entrada (0,null,T.getTipo(),T.getDespl(),null,null);

		}else if(tokenActual.tipo.equals("Id")){// Follow(H) = id
			// Nothing
			return new Entrada (0,null,null,0,null,null);
		}else
			throw new RuntimeException("Error en H, no se ha aceptado ningun token");
	}
	public static Entrada A(){//A -> T id K | LAMBDA.
		if(tokenActual.token.equals("int") || tokenActual.token.equals("boolean")
				|| tokenActual.token.equals("char")){//First(TidK) = int, boolean, char
			//try{
			Entrada T = T();
			//}catch(Exception ex){
			//	System.err.println(ex);
			//	System.exit(1);
			//}
			compToken("Id");
			/*Introducir tabla Id con Id.nombre, T.tipo, T.tam en la TS de la funcion*/
			Entrada K = K();
			ArrayList<String> params = new ArrayList<String>();
			params.add(T.getTipo());							// Anade a la lista el tipo del parametro que va antes
			for (String s : K.getParam() ) { params.add(s); }	// Anade resto de tipos a la lista en orden
			return new Entrada(0,null,null,0,params,null);		// a A se le guarda la lista completa de parametros
		}else if(tokenActual.token.equals(")")){// Follow(A) = )
			// Nothing
			return new Entrada(0,null,null,0,null,null);
		}else
			throw new RuntimeException("Error en A, no se ha aceptado ningun token");
	}
	public static Entrada K(){//K -> , T id K | LAMBDA.
		if(tokenActual.token.equals(",")){//First(,TidK) = ,
			compToken(",");
			//try{
			Entrada T = T();
			//}catch(Exception ex){
			//	System.err.println(ex);
			//	System.exit(1);
			//}
			compToken("Id");
			/*Introducir tabla Id con Id.nombre, T.tipo, T.tam en la TS de la funcion*/
			Entrada K = K();
			ArrayList<String> params = new ArrayList<String>();
			params.add(T.getTipo());							// Anade a la lista el tipo del parametro que va a antes
			for (String s : K.getParam() ) { params.add(s); }	// Anade resto de tipos a la lista en orden
			return new Entrada(0,null,null,0,params,null);

		}else if(tokenActual.token.equals(")")){// Follow(K) = )
			// Nothing
			return new Entrada(0,null,null,0,null,null);
		}else
			throw new RuntimeException("Error en K, no se ha aceptado ningun token");
	}
	public static Entrada C(){//C -> B Z C | break | LAMBDA.
		if(tokenActual.token.equals("var") || tokenActual.token.equals("if") || tokenActual.token.equals("for") || 
				tokenActual.tipo.equals("Id") || tokenActual.token.equals("return") || tokenActual.token.equals("write")
				|| tokenActual.token.equals("prompt")){//First(BZC) = var, if, for, id, return, write, prompt
			B();
			Z();
			C();
			return new Entrada (0,null,null,0,null,null);

		}else if(tokenActual.token.equals("break")){//First(break) = break
			compToken("break");
			/*destruir TS local? */
			return new Entrada (0,null,null,0,null,null);

		}else if(tokenActual.token.equals("}")){// Follow(C) = }
			// Nothing
			return new Entrada (0,null,null,0,null,null);

		}else
			throw new RuntimeException("Error en C, no se ha aceptado ningun token");
	}
	public static Entrada E(){//E -> G E'.
		if(tokenActual.tipo.equals("Id")||tokenActual.token.equals("(")
				|| tokenActual.tipo.equals("Num")
				|| tokenActual.tipo.equals("Cadena")
				|| tokenActual.token.equals("true")
				|| tokenActual.token.equals("false")){//First(GE') = id, (, num, cadena, true, false
			G();
			Ep();

		}else
			throw new RuntimeException("Error en E, no se ha aceptado ningun token");
	}
	public static Entrada Ep(){//E' -> %= G E' | LAMBDA.
		if(tokenActual.token.equals("%=")){//First(%=GEp) = %=
			compToken("%=");
			Entrada G = G();
			Entrada Ep = Ep();
			if ( !Ep.getTipo().equals(G.getTipo()) ) {
				System.out.println("Error (linea "+linea()+"): %= solo para tipo int ");
				return new Entrada (0,null,"err",0,null,null);
			}

		}else if(tokenActual.token.equals(")")||tokenActual.token.equals(",")
				|| tokenActual.token.equals("=")
				|| tokenActual.token.equals(";")
				|| tokenActual.tipo.equals("eol")){// Follow(Ep) = ), ,, =, ;, cr
			// Nothing
			return new Entrada (0,null,null,0,null,null);
			
		}else
			throw new RuntimeException("Error en Ep, no se ha aceptado ningun token");
	}
	public static Entrada G(){//G -> R G'.
		if(tokenActual.tipo.equals("Id")||tokenActual.token.equals("(")
				|| tokenActual.tipo.equals("Num")
				|| tokenActual.tipo.equals("Cadena")
				|| tokenActual.token.equals("true")
				|| tokenActual.token.equals("false")){//First(GE') = id, (, num, cadena, true, false
			Entrada R = R();
			Entrada Gp = Gp();
			if ( !R.getTipo().equals(Gp.getTipo()) ) {
				System.out.println("Error (linea "+linea()+"): operaciones logicas solo con operandos logicos ");
				return new Entrada (0,null,"err",0,null,null);
			}
			return new Entrada (0,null,"boolean",1,null,null);

		}else
			throw new RuntimeException("Error en G, no se ha aceptado ningun token");
	}
	public static Entrada Gp(){//G' -> && R G' | LAMBDA.
		if(tokenActual.token.equals("&&")){//First(&&RGp) = &&
			compToken("&&");
			Entrada R = R();
			Entrada Gp = Gp();
			if ( !R.getTipo().equals(Gp.getTipo()) ) {
				System.out.println("Error (linea "+linea()+"): operaciones logicas solo con operandos logicos ");
				return new Entrada (0,null,"err",0,null,null);
			}
			return new Entrada (0,null,"boolean",1,null,null);

		}else if(tokenActual.token.equals("%=")||tokenActual.token.equals(")")||tokenActual.token.equals(",")
				|| tokenActual.token.equals("=")
				|| tokenActual.token.equals(";")
				|| tokenActual.tipo.equals("eol")){// Follow(Gp) = %=, ), ,, =, ;, cr
			// Nothing
			return new Entrada (0,null,null,0,null,null);
			
		}else
			throw new RuntimeException("Error en Gp, no se ha aceptado ningun token");
	}
	public static Entrada R(){//R -> U R'.
		if(tokenActual.tipo.equals("Id")||tokenActual.token.equals("(")
				|| tokenActual.tipo.equals("Num")
				|| tokenActual.tipo.equals("Cadena")
				|| tokenActual.token.equals("true")
				|| tokenActual.token.equals("false")){//First(UR') = id, (, num, cadena, true, false
			Entrada U = U();
			Entrada Rp = Rp();
			if ( !U.getTipo().equals(Rp.getTipo()) ) {
				System.out.println("Error (linea "+linea()+"): solo se pueden comparar tipos iguales ");
				return new Entrada (0,null,"err",0,null,null);
			}
			return new Entrada (0,null,"boolean",1,null,null);

		}else
			throw new RuntimeException("Error en U, no se ha aceptado ningun token");
	}
	public static Entrada Rp(){//R' -> == U R' | LAMBDA.
		if(tokenActual.token.equals("==")){//First(==UR') = ==
			compToken("==");
			Entrada U = U();
			Entrada Rp = Rp();
			if ( !U.getTipo().equals(Rp.getTipo()) ) {
				System.out.println("Error (linea "+linea()+"): solo se pueden comparar tipos iguales ");
				return new Entrada (0,null,"err",0,null,null);
			}
			return new Entrada (0,null,Rp.getTipo(),Rp.getDespl(),null,null);

		}else if(tokenActual.token.equals("&&")||tokenActual.token.equals("%=")||tokenActual.token.equals(")")
				||tokenActual.token.equals(",")
				|| tokenActual.token.equals("=")
				|| tokenActual.token.equals(";")
				|| tokenActual.tipo.equals("eol")){// Follow(Rp) = &&, %=, ), ,, =, ;, cr
			// Nothing
			return new Entrada (0,null,null,0,null,null);

		}else
			throw new RuntimeException("Error en Rp, no se ha aceptado ningun token");
	}
	public static Entrada U(){//U -> V U'.
		if(tokenActual.tipo.equals("Id")||tokenActual.token.equals("(")
				|| tokenActual.tipo.equals("Num")
				|| tokenActual.tipo.equals("Cadena")
				|| tokenActual.token.equals("true")
				|| tokenActual.token.equals("false")){//First(VU') = id, (, num, cadena, true, false
			Entrada V = V();
			Entrada Up = Up();
			if ( !V.getTipo().equals(Up.getTipo()) ) {
				System.out.println("Error (linea "+linea()+"): solo se pueden sumar tipos iguales ");
				return new Entrada (0,null,"err",0,null,null);
			}
			return new Entrada (0,null,Up.getTipo(),Up.getDespl(),null,null);

		}else
			throw new RuntimeException("Error en U, no se ha aceptado ningun token");
	}
	public static Entrada Up(){//U' -> + V U' | LAMBDA.
		if(tokenActual.token.equals("+")){//First(+VUp) = +
			compToken("+");
			Entrada V = V();
			Entrada Up = Up();
			if ( !V.getTipo().equals(Up.getTipo()) ) {
				System.out.println("Error (linea "+linea()+"): solo se pueden sumar tipos iguales ");
				return new Entrada (0,null,"err",0,null,null);
			}
			return new Entrada (0,null,Up.getTipo(),Up.getDespl(),null,null);
				
		}else if(tokenActual.token.equals("==")||tokenActual.token.equals("&&")||tokenActual.token.equals("%=")
				||tokenActual.token.equals(")")
				|| tokenActual.token.equals(",")
				|| tokenActual.token.equals("=")
				|| tokenActual.token.equals(";")
				|| tokenActual.tipo.equals("eol")){// Follow(Up) = ==, &&, %=, ), ,, =, ;, cr
			// Nothing
			return new Entrada (0,null,null,0,null,null);

		}else
			throw new RuntimeException("Error en Up, no se ha aceptado ningun token");
	}
	public static Entrada V(){//V -> id V' | ( E ) | entero | cadena | true | false.
		if(tokenActual.tipo.equals("Id")){//First(idV') = id
			compToken("Id");
			Entrada Vp = Vp();
			//if ( /*!found id TS or id.tipo!= funcion*/) {
			//	System.out.println("Error (linea "+linea()+"): id no es una funcion ");
			//	return new Entrada (0,null,null,0,null,null);
			// }
			// if tipos params id != Vp.params ) {
			// System.out.println("Error (linea "+linea()+"): la funcion recibe "+id.param.printParam() );
			// return new Entrada (0,null,null,0,null,null);
			// }
			return new Entrada (0,null,/*id.ret type*/null,0,null,null); 

		}else if(tokenActual.token.equals("(")){//First((E)) = (
			compToken("(");
			Entrada E = E();
			compToken(")");
			return new Entrada (0,null,E.getTipo(),E.getDespl(),null,null);

		}else if(tokenActual.tipo.equals("Num")){//First(entero) = entero
			if ( Integer.parseInt(tokenActual.token) > 32767 )
				System.out.println("Error (linea "+linea()+"): numero maximo permitido es 32767 ");
			compToken("Num");
			return new Entrada(0,null,"int",2,null,null);

		}else if(tokenActual.tipo.equals("Cadena")){//First(cadena) = cadena
			compToken("Cadena");
			return new Entrada(0,null,"char",1,null,null);

		}else if(tokenActual.token.equals("true")){//First(true) = true
			compToken("true");
			return new Entrada(0,null,"boolean",1,null,null);

		}else if(tokenActual.token.equals("false")){//First(false) = false
			compToken("false");
			return new Entrada(0,null,"boolean",1,null,null);

		}else
			throw new RuntimeException("Error en V, no se ha aceptado ningun token");
	}
	public static Entrada Vp(){//V' -> ( L ) | LAMBDA.
		if(tokenActual.token.equals("(")){//First((L)) = (
			compToken("(");
			Entrada L = L();
			compToken(")");
			return new Entrada (0,null,null,0,L.getParam(),null);

		}else if(tokenActual.token.equals("+")||tokenActual.token.equals("==")
				|| tokenActual.token.equals("&&")
				|| tokenActual.token.equals("%=")
				||tokenActual.token.equals(")")
				|| tokenActual.token.equals(",")
				|| tokenActual.token.equals("=")
				|| tokenActual.token.equals(";")
				|| tokenActual.tipo.equals("eol")){// Follow(Vp) = +, ==, &&, %=, ), ,, =, ;, cr
			// Nothing
			return new Entrada (0,null,null,0,null,null);
		}else
			throw new RuntimeException("Error en Vp, no se ha aceptado ningun token");
	}

	public static int linea(){
		return tokenActual.linea+1;
	}


}



class Entrada{
	private int 		pos;	// Posicion en la TS
	private String 		nom;	// Nombre identificador
	private String 		tipo;	// Tipo identificador
	private int 		despl;	// Tamano entrada
	private ArrayList<String> 	param;	// Parametros entrada
	private String 		ret;	// Tipo retorno

	public Entrada(int pos, String nom, String tipo, int despl,
			ArrayList<String> param, String ret) {
		super();
		this.pos = pos;
		this.nom = nom;
		this.tipo = tipo;
		this.despl = despl;
		this.param = param;
		this.ret = ret;
	}

	public int getPosicion() {
		return pos;
	}

	public String getIdent() {
		return nom;
	}

	public String getTipo() {
		return tipo;
	}

	public int getDespl() {
		return despl;
	}

	public ArrayList<String> getParam() {
		return param;
	}
	
	public String printParam() {
		String getparam = "[ ";
		for (String s : param ) { getparam = getparam +", " + s + " "; }
		getparam = getparam + "]";
		return getparam;
	}

	public String getRet() {
		return ret;
	}

	@Override
	public String toString() {
		return  "Entrada [posicion=" + pos + ", ident=" + nom
				+ ", tipo=" + tipo + ", despl=" + despl + ", param=" + printParam() + "]" ;
	}


}
class TablaSimbolos{
	ArrayList<Entrada> tabla;
	public TablaSimbolos(){
		tabla = new ArrayList<Entrada>();
	}
}

