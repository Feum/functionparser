package parser;

public class Sequence extends Expression {

//  sequence -> {statement ";"} "$"
	
	public Sequence(Scanner scanner, Environment environment) {
		super(scanner, environment);
		nextToken();
		while(lookAhead() != TokenType.EOI) {
			Binding b = (new Statement(scanner, environment)).getBinding();
			if (b != null) environment.addBinding(b);
			System.out.print(b.getIdentifier() + " = "); b.getFunction().print(); System.out.println();
			expect(TokenType.SEMICOLON);  // flush ";"
		}
	} 
	
	

}
