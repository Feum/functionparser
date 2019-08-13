package parser;

import java.io.BufferedReader;
import java.io.IOException;

public class Scanner {
	private char actualChar;
	private InputBuffer input;
	private TokenType token;
	private char letter;

	public Scanner (BufferedReader in) {
	    input = new InputBuffer(in);
	    token = TokenType.EOI;
	    actualChar = ' ';
	} 


	public TokenType nextToken ( ) throws SyntaxErrorException, IOException {
	    while (Character.isWhitespace(actualChar))
	    	actualChar = input.get( );
	    
	   token = Token.tokenize(actualChar);
	   letter = Character.toLowerCase(actualChar);
	   actualChar = input.get();
	   return token;
	} 

	
	public TokenType getToken() {
		return token;
	}
	
	public char getLetter() {
		return letter;
	}

	public TokenType lookAhead() throws SyntaxErrorException, IOException {
		return Token.tokenize(input.lookAhead());
	}

}

