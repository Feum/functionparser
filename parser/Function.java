package parser;

import java.util.LinkedList;
import java.util.List;

public class Function extends Expression {
	
//  function -> ( identifier "(" function { "," function} ")" ) | "!" identifier
	cgNode foo;

	public Function(Scanner scanner, Environment environment) {
		super(scanner, environment);
		
	    

		String id = "";
		TokenType lookAhead = lookAhead();
	    
		
		switch(lookAhead) {
			
		case LETTER: // identifier "(" function { "," function} ")" 
			id = identifier();
			foo = new cgLeaf(id);
			expect(TokenType.LEFTP); //flushes "("
			List<cgNode> foos = new LinkedList<cgNode>();
			
			
			while (lookAhead() != TokenType.RIGHTP)
			{	
				if (lookAhead() == TokenType.COMMA) expect(TokenType.COMMA); //flushes ","
				foos.add(function());
			}				
			if (!foos.isEmpty()) foo=new cgInternalNode(id, foos);	
			expect(TokenType.RIGHTP); //flushes ")"				
			break;
		
		case ESCLAM:  // "!" identifier
			expect(TokenType.ESCLAM);; //flushes "!"
			id = identifier();	
			if ((foo = environment.getFuction(id)) == null) {
				System.err.println(id + ": identifier not found (will be ignored)");	
				foo = new cgLeaf(id);
			}
			break;
			
		default:
		error("(Unexpected token " + lookAhead + ")");
		break;
			
		}
	}

	private String identifier() {
		return new Identifier(scanner,environment).getIdentifier();
	}
	
	private cgNode function() {
		return new Function(scanner,environment).getFunction();
	}
	
	
	public cgNode getFunction() {
		return foo;
	}

}
