/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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

	public class Entrada{
		private int posicion;
		private String ident;
		private String tipo;
		private int despl;
		private String param;

		public Entrada(int posicion, String ident, String tipo, int despl,
				String param) {
			super();
			this.posicion = posicion;
			this.ident = ident;
			this.tipo = tipo;
			this.despl = despl;
			this.param = param;
		}

		public int getPosicion() {
			return posicion;
		}

		public String getIdent() {
			return ident;
		}


		public String getTipo() {
			return tipo;
		}

		public int getDespl() {
			return despl;
		}

		public String getParam() {
			return param;
		}


		@Override
		public String toString() {
			return "Entrada [posicion=" + posicion + ", ident=" + ident
					+ ", tipo=" + tipo + ", despl=" + despl + ", param="
					+ param + "]";
		}


	}
	public class TablaSimbolos{
		ArrayList<Entrada> tabla;
		public TablaSimbolos(){
			tabla = new ArrayList<Entrada>();
		}
	}

	/**
	 * Muestra un menu para elegir la opcion
	 * mas conveniente
	 * @param args the command line arguments
	 */
	static Yytoken tokenActual = null;
	static AnalizadorLexico a = null;
	static ArrayList<Integer> parser = new ArrayList<Integer>();

	public static void main(String[] args) {
		int opcion = 0;

		java.util.Scanner in = new java.util.Scanner(System.in);

		System.out.println("Seleccione una opci�n:");
		System.out.println("1) Generar Analizador L�xico a partir de alexico.flex");
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
				//				do {//Todo el c�digo
				//					token = a.sigToken();
				//					System.out.println(token.toString());
				//				} while (token != null);

			} catch (Exception ex) {
				System.err.println(ex);
				System.err.println("El token que no se encontr� es: "+tokenActual+" l�nea "+linea()+"\n\n");//luego se quita
				//Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				try {
					bf.close();
				} catch (IOException ex) {
					//Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			String filename = "Parser.txt";
			BufferedWriter out;
			try{
				out = new BufferedWriter(
						new FileWriter(filename));

				System.out.println("Fichero Parser.txt generado");
				out.write("Des ");
				int num;
				for(int i=0; i<parser.size();i++){
					num = parser.get(i);
					out.write(num+" ");
				}
				out.close();
			}catch(Exception e){

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
				throw new RuntimeException("Para el carro!!Token inv�lido en comprobarToken - Id");
		}else if(token.equals("eol")){
			if(tokenActual.tipo.equals(token)){
				try{
					tokenActual=a.sigToken();
				}catch (Exception ex) {
				}
			}else
				throw new RuntimeException("Para el carro!!Token inv�lido en comprobarToken - eol");
		}else if(token.equals("eof")){
			if(tokenActual.tipo.equals(token)){
				try{
					tokenActual=a.sigToken();
				}catch (Exception ex) {
				}
			}else
				throw new RuntimeException("Para el carro!!Token inv�lido en comprobarToken - eof");
		}else if(token.equals("Num")){
			if(tokenActual.tipo.equals(token)){
				try{
					tokenActual=a.sigToken();
				}catch (Exception ex) {
				}
			}else
				throw new RuntimeException("Para el carro!!Token inv�lido en comprobarToken - Num");
		}else if(token.equals("Cadena")){
			if(tokenActual.tipo.equals(token)){
				try{
					tokenActual=a.sigToken();
				}catch (Exception ex) {
				}
			}else
				throw new RuntimeException("Para el carro!!Token inv�lido en comprobarToken - Cadena");
		}else{
			if(tokenActual.token.equals(token)){
				try{
					tokenActual=a.sigToken();
				}catch (Exception ex) {
				}
			}else
				throw new RuntimeException("Para el carro!!Token inv�lido en comprobarToken - Resto");
		}
	}

	public static void P(){//P -> B Z P | F Z P | Z P | eof.
		if (tokenActual != null){
			if(tokenActual.token.equals("var") || tokenActual.token.equals("if") || tokenActual.token.equals("for") || 
					tokenActual.tipo.equals("Id") || tokenActual.token.equals("return") || tokenActual.token.equals("write")
					|| tokenActual.token.equals("prompt")){//First(BZP) = var, if, for, id, return, write, prompt
				parser.add(1);
				B();
				Z();
				P();

			}else if (tokenActual.token.equals("function")){//First(FZP) = function
				parser.add(2);
				F();
				Z();
				P();

			}else if (tokenActual.tipo.equals("eol")){//First(ZP) = cr
				parser.add(3);
				Z();
				P();

			}else if (tokenActual.tipo.equals("eof")){//First(eof) = eof
				parser.add(4);
				compToken("eof");

			}else {
				throw new RuntimeException("Error en P, no se ha aceptado ning�n token");

			}
		}
	}
	public static void Z(){//Z -> cr Z'.
		if(tokenActual.tipo.equals("eol")){//First(crZ') = cr
			parser.add(5);
			compToken("eol");
			Zp();

		}else
			throw new RuntimeException("Error en Z, no se ha aceptado ning�n token");
	}
	public static void Zp(){//Z' -> Z | oc.
		if(tokenActual != null){
			if(tokenActual.tipo.equals("eol")){//First(Z) = cr
				parser.add(6);
				Z();

			}else{
				parser.add(7);
				//Otro car�cter
			}
		}
	}
	public static void B(){//B -> var T id W | if ( E ) S | S | for ( S ; E ; S ) Z { Z C }.
		if(tokenActual.token.equals("var")){//First(varTidW) = var
			parser.add(8);
			compToken("var");
			//try{
			T();
			//}catch(Exception ex){
			//	System.err.println(ex);
			//	System.exit(1);
			//}
			compToken("Id");
			W();

		}else if(tokenActual.token.equals("if")){// First(if(E)S) = if
			parser.add(9);
			compToken("if");
			compToken("(");
			E();
			compToken(")");
			S();

		}else if(tokenActual.tipo.equals("Id") || tokenActual.token.equals("return")
				|| tokenActual.token.equals("write")
				|| tokenActual.token.equals("prompt")){//First(S)= id, return, write, prompt
			parser.add(10);
			S();
		}else if(tokenActual.token.equals("for")){//First(for(S;E;S)Z{ZC}) = for
			parser.add(11);
			compToken("for");
			compToken("(");
			S();
			compToken(";");
			E();
			compToken(";");
			S();
			compToken(")");
			Z();
			compToken("{");
			Z();
			C();
			compToken("}");

		}else
			throw new RuntimeException("Error en B, no se ha aceptado ning�n token");
	}	
	public static void W(){//W -> , id W | = E W' | LAMBDA.
		if(tokenActual.token.equals(",")){//First(,idW) = ,
			parser.add(12);
			compToken(",");
			compToken("Id");
			W();

		}else if(tokenActual.token.equals("=")){// First(=EWp) = =
			parser.add(13);
			compToken("=");
			E();
			Wp();

		}else if(tokenActual.tipo.equals("eol")){// Follow(W) = cr
			parser.add(14);
			// Nothing

		}else
			throw new RuntimeException("Error en W, no se ha aceptado ning�n token");
	}
	public static void Wp(){//W' -> , id W | LAMBDA.
		if(tokenActual.token.equals(",")){//First(,idW) = ,
			parser.add(15);
			compToken(",");
			compToken("Id");
			W();

		}else if(tokenActual.tipo.equals("eol")){// Follow(Wp) = cr
			parser.add(16);
			// Nothing

		}else
			throw new RuntimeException("Error en Wp, no se ha aceptado ning�n token");
	}
	public static void S(){//S -> id S' | return X | write ( E ) | prompt ( id ).
		if(tokenActual.tipo.equals("Id")){//First(idS') = id
			parser.add(17);
			compToken("Id");
			Sp();

		}else if(tokenActual.token.equals("return")){// First(returnX) = return
			parser.add(18);
			compToken("return");
			X();

		}else if(tokenActual.token.equals("write")){// First(write(E)) = write
			parser.add(19);
			compToken("write");
			compToken("(");
			E();
			compToken(")");

		}else if(tokenActual.token.equals("prompt")){// First(prompt(id)) = prompt
			parser.add(20);
			compToken("prompt");
			compToken("(");
			compToken("Id");
			compToken(")");

		}else
			throw new RuntimeException("Error en S, no se ha aceptado ning�n token");
	}
	public static void Sp(){//S' -> = E | %= E | ( L ).
		if(tokenActual.token.equals("=")){//First(=E) = =
			parser.add(21);
			compToken("=");
			E();

		}else if(tokenActual.token.equals("%=")){// First(%=E) = %=
			parser.add(22);
			compToken("%=");
			E();

		}else if(tokenActual.token.equals("(")){// First((L)) = (
			parser.add(23);
			compToken("(");
			L();
			compToken(")");
		}else
			throw new RuntimeException("Error en Sp, no se ha aceptado ning�n token");
	}
	public static void T() /*throws TipoVaribleNoDefinido*/{//T -> int | boolean | char.
		if(tokenActual.token.equals("int")){//First(int) = int
			parser.add(24);
			compToken("int");

		}else if(tokenActual.token.equals("boolean")){// First(boolean) = boolean
			parser.add(25);
			compToken("boolean");

		}else if(tokenActual.token.equals("char")){// First(char) = char
			parser.add(26);
			compToken("char");

		}else{
			//System.err.print("L�nea "+tokenActual.linea+", ");
			//throw new TipoVaribleNoDefinido("Se debe definir un tipo de variable en la declaraci�n");
			throw new RuntimeException("Error en T, no se ha aceptado ning�n token");
		}

	}
	public static void X(){//X -> E | LAMBDA.
		if(tokenActual.tipo.equals("Id") || tokenActual.token.equals("(")
				|| tokenActual.tipo.equals("Num")
				|| tokenActual.tipo.equals("Cadena")
				|| tokenActual.token.equals("true")
				|| tokenActual.token.equals("false")){//First(E) = id, (, num, cadena, true, false
			parser.add(27);
			E();

		}else if(tokenActual.token.equals(")") || tokenActual.token.equals(",")
				|| tokenActual.token.equals("=")
				|| tokenActual.token.equals(";")
				|| tokenActual.tipo.equals("eol")){// Follow(E) = ), ,, =, ;, cr
			parser.add(28);
			// Nothing

		}else
			throw new RuntimeException("Error en X, no se ha aceptado ning�n token");
	}
	public static void L(){//L -> E Q | LAMBDA.
		if(tokenActual.tipo.equals("Id")||tokenActual.token.equals("(")
				|| tokenActual.tipo.equals("Num")
				|| tokenActual.tipo.equals("Cadena")
				|| tokenActual.token.equals("true")
				|| tokenActual.token.equals("false")){//First(EQ) = id, (, num, cadena, true, false
			parser.add(29);
			E();
			Q();

		}else if(tokenActual.token.equals(")")){// Follow(L) = )
			parser.add(30);
			// Nothing

		}else
			throw new RuntimeException("Error en L, no se ha aceptado ning�n token");
	}
	public static void Q(){//Q -> , E Q | LAMBDA.
		if(tokenActual.token.equals(",")){//First(,EQ) = ,
			parser.add(31);
			compToken(",");
			E();
			Q();

		}else if(tokenActual.token.equals(")")){// Follow(Q) = )
			parser.add(32);
			// Nothing

		}else
			throw new RuntimeException("Error en Q, no se ha aceptado ning�n token");
	}
	public static void F(){//F -> function H id ( A )  Z { Z C }.
		if(tokenActual.token.equals("function")){//First(functionHid(A)Z{ZC}) = function
			parser.add(33);
			compToken("function");
			H();
			compToken("Id");
			compToken("(");
			A();
			compToken(")");
			Z();
			compToken("{");
			Z();
			C();
			compToken("}");

		}else
			throw new RuntimeException("Error en F, no se ha aceptado ning�n token");
	}
	public static void H(){//H -> T | LAMBDA.
		if(tokenActual.token.equals("int") || tokenActual.token.equals("boolean")
				|| tokenActual.token.equals("char")){//First(T) = int, boolean, char
			parser.add(34);
			//try{
			T();
			//}catch(Exception ex){
			//System.err.println(ex);
			//System.exit(1);
			//}

		}else if(tokenActual.tipo.equals("Id")){// Follow(H) = id
			parser.add(35);
			// Nothing

		}else
			throw new RuntimeException("Error en H, no se ha aceptado ning�n token");
	}
	public static void A(){//A -> T id K | LAMBDA.
		if(tokenActual.token.equals("int") || tokenActual.token.equals("boolean")
				|| tokenActual.token.equals("char")){//First(TidK) = int, boolean, char
			parser.add(36);
			//try{
			T();
			//}catch(Exception ex){
			//	System.err.println(ex);
			//	System.exit(1);
			//}
			compToken("Id");
			K();

		}else if(tokenActual.token.equals(")")){// Follow(A) = )
			parser.add(37);
			// Nothing

		}else
			throw new RuntimeException("Error en A, no se ha aceptado ning�n token");
	}
	public static void K(){//K -> , T id K | LAMBDA.
		if(tokenActual.token.equals(",")){//First(,TidK) = ,
			parser.add(38);
			compToken(",");
			//try{
			T();
			//}catch(Exception ex){
			//	System.err.println(ex);
			//	System.exit(1);
			//}
			compToken("Id");
			K();

		}else if(tokenActual.token.equals(")")){// Follow(K) = )
			parser.add(39);
			// Nothing

		}else
			throw new RuntimeException("Error en K, no se ha aceptado ning�n token");
	}
	public static void C(){//C -> B Z C | break | LAMBDA.
		if(tokenActual.token.equals("var") || tokenActual.token.equals("if") || tokenActual.token.equals("for") || 
				tokenActual.tipo.equals("Id") || tokenActual.token.equals("return") || tokenActual.token.equals("write")
				|| tokenActual.token.equals("prompt")){//First(BZC) = var, if, for, id, return, write, prompt
			parser.add(40);
			B();
			Z();
			C();

		}else if(tokenActual.token.equals("break")){//First(break) = break
			parser.add(41);
			compToken("break");

		}else if(tokenActual.token.equals("}")){// Follow(C) = }
			parser.add(42);
			// Nothing

		}else
			throw new RuntimeException("Error en C, no se ha aceptado ning�n token");
	}
	public static void E(){//E -> G E'.
		if(tokenActual.tipo.equals("Id")||tokenActual.token.equals("(")
				|| tokenActual.tipo.equals("Num")
				|| tokenActual.tipo.equals("Cadena")
				|| tokenActual.token.equals("true")
				|| tokenActual.token.equals("false")){//First(GE') = id, (, num, cadena, true, false
			parser.add(43);
			G();
			Ep();

		}else
			throw new RuntimeException("Error en E, no se ha aceptado ning�n token");
	}
	public static void Ep(){//E' -> %= G E' | LAMBDA.
		if(tokenActual.token.equals("%=")){//First(%=GEp) = %=
			parser.add(44);
			compToken("%=");
			G();
			Ep();

		}else if(tokenActual.token.equals(")")||tokenActual.token.equals(",")
				|| tokenActual.token.equals("=")
				|| tokenActual.token.equals(";")
				|| tokenActual.tipo.equals("eol")){// Follow(Ep) = ), ,, =, ;, cr
			parser.add(45);
			// Nothing
		}else
			throw new RuntimeException("Error en Ep, no se ha aceptado ning�n token");
	}
	public static void G(){//G -> R G'.
		if(tokenActual.tipo.equals("Id")||tokenActual.token.equals("(")
				|| tokenActual.tipo.equals("Num")
				|| tokenActual.tipo.equals("Cadena")
				|| tokenActual.token.equals("true")
				|| tokenActual.token.equals("false")){//First(GE') = id, (, num, cadena, true, false
			parser.add(46);
			R();
			Gp();

		}else
			throw new RuntimeException("Error en G, no se ha aceptado ning�n token");
	}
	public static void Gp(){//G' -> && R G' | LAMBDA.
		if(tokenActual.token.equals("&&")){//First(&&RGp) = &&
			parser.add(47);
			compToken("&&");
			R();
			Gp();

		}else if(tokenActual.token.equals("%=")||tokenActual.token.equals(")")||tokenActual.token.equals(",")
				|| tokenActual.token.equals("=")
				|| tokenActual.token.equals(";")
				|| tokenActual.tipo.equals("eol")){// Follow(Gp) = %=, ), ,, =, ;, cr
			parser.add(48);
			// Nothing
		}else
			throw new RuntimeException("Error en Gp, no se ha aceptado ning�n token");
	}
	public static void R(){//R -> U R'.
		if(tokenActual.tipo.equals("Id")||tokenActual.token.equals("(")
				|| tokenActual.tipo.equals("Num")
				|| tokenActual.tipo.equals("Cadena")
				|| tokenActual.token.equals("true")
				|| tokenActual.token.equals("false")){//First(UR') = id, (, num, cadena, true, false
			parser.add(49);
			U();
			Rp();

		}else
			throw new RuntimeException("Error en U, no se ha aceptado ning�n token");
	}
	public static void Rp(){//R' -> == U R' | LAMBDA.
		if(tokenActual.token.equals("==")){//First(==UR') = ==
			parser.add(50);
			compToken("==");
			U();
			Rp();

		}else if(tokenActual.token.equals("&&")||tokenActual.token.equals("%=")||tokenActual.token.equals(")")
				||tokenActual.token.equals(",")
				|| tokenActual.token.equals("=")
				|| tokenActual.token.equals(";")
				|| tokenActual.tipo.equals("eol")){// Follow(Rp) = &&, %=, ), ,, =, ;, cr
			parser.add(51);
			// Nothing

		}else
			throw new RuntimeException("Error en Rp, no se ha aceptado ning�n token");
	}
	public static void U(){//U -> V U'.
		if(tokenActual.tipo.equals("Id")||tokenActual.token.equals("(")
				|| tokenActual.tipo.equals("Num")
				|| tokenActual.tipo.equals("Cadena")
				|| tokenActual.token.equals("true")
				|| tokenActual.token.equals("false")){//First(VU') = id, (, num, cadena, true, false
			parser.add(52);
			V();
			Up();

		}else
			throw new RuntimeException("Error en U, no se ha aceptado ning�n token");
	}
	public static void Up(){//U' -> + V U' | LAMBDA.
		if(tokenActual.token.equals("+")){//First(+VUp) = +
			parser.add(53);
			compToken("+");
			V();
			Up();

		}else if(tokenActual.token.equals("==")||tokenActual.token.equals("&&")||tokenActual.token.equals("%=")
				||tokenActual.token.equals(")")
				|| tokenActual.token.equals(",")
				|| tokenActual.token.equals("=")
				|| tokenActual.token.equals(";")
				|| tokenActual.tipo.equals("eol")){// Follow(Up) = ==, &&, %=, ), ,, =, ;, cr
			parser.add(54);
			// Nothing

		}else
			throw new RuntimeException("Error en Up, no se ha aceptado ning�n token");
	}
	public static void V(){//V -> id V' | ( E ) | entero | cadena | true | false.
		if(tokenActual.tipo.equals("Id")){//First(idV') = id
			parser.add(55);
			compToken("Id");
			Vp();

		}else if(tokenActual.token.equals("(")){//First((E)) = (
			parser.add(56);
			compToken("(");
			E();
			compToken(")");

		}else if(tokenActual.tipo.equals("Num")){//First(entero) = entero
			parser.add(57);
			compToken("Num");

		}else if(tokenActual.tipo.equals("Cadena")){//First(cadena) = cadena
			parser.add(58);
			compToken("Cadena");

		}else if(tokenActual.token.equals("true")){//First(true) = true
			parser.add(59);
			compToken("true");

		}else if(tokenActual.token.equals("false")){//First(false) = false
			parser.add(60);
			compToken("false");

		}else
			throw new RuntimeException("Error en V, no se ha aceptado ning�n token");
	}
	public static void Vp(){//V' -> ( L ) | LAMBDA.
		if(tokenActual.token.equals("(")){//First((L)) = (
			parser.add(61);
			compToken("(");
			L();
			compToken(")");

		}else if(tokenActual.token.equals("+")||tokenActual.token.equals("==")
				|| tokenActual.token.equals("&&")
				|| tokenActual.token.equals("%=")
				||tokenActual.token.equals(")")
				|| tokenActual.token.equals(",")
				|| tokenActual.token.equals("=")
				|| tokenActual.token.equals(";")
				|| tokenActual.tipo.equals("eol")){// Follow(Vp) = +, ==, &&, %=, ), ,, =, ;, cr
			parser.add(62);
			// Nothing
		}else
			throw new RuntimeException("Error en Vp, no se ha aceptado ning�n token");
	}

	public static int linea(){
		return tokenActual.linea+1;
	}


}
