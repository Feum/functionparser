package parser;

public class Identifier extends Expression {
	
	//  identifier -> {a|..|z}
	String id;

	public Identifier(Scanner scanner, Environment environment) {
		super(scanner, environment);
	    
		id="";
		if (scanner.getToken() == TokenType.LETTER ) id+=scanner.getLetter();
	    while (lookAhead() == TokenType.LETTER) {
	    	nextToken();
	    	id+=scanner.getLetter();
	    }
	}



	public String getIdentifier() {
		return id;
	}

}
