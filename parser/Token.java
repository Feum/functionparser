package parser;



public class Token {
	
	//Tokens container class
	
	
	public static TokenType tokenize (char character) throws SyntaxErrorException {
		
		TokenType token = TokenType.EOI;
		
		if (Character.isLetter(character))
			token = TokenType.LETTER;
	  
	    else {
			switch (character) {
			    case ';' : 	token = TokenType.SEMICOLON; 			
				break;
	
			    case '$' :  token = TokenType.EOI;			
				break;
	
			    case '=' :  token = TokenType.EQUAL;			
				break;
	
			    case '(' :  token = TokenType.LEFTP;				
				break;
	
			    case ')' :  token = TokenType.RIGHTP;				
				break;
				
			    case ',' :   token = TokenType.COMMA;			
				break;
	
			    case '!' : token = TokenType.ESCLAM;
			    break;
				
			    default : 
			    	throw new SyntaxErrorException("Illegal character " + character);
			} 
	    }
		return token;
	}

}
