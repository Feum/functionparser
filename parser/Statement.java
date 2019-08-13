package parser;

public class Statement extends Expression {
	
	Binding binding;
    //  statement -> identifier "=" function

	public Statement(Scanner scanner, Environment environment) {
		super(scanner, environment);
		
	    String identifier = (new Identifier(scanner, environment)).getIdentifier(); 
	    expect(TokenType.EQUAL); // flushes "="
		cgNode foo = (new Function(scanner, environment)).getFunction();
		
	    if (identifier != "" && foo != null)
	    	this.binding = new Binding (identifier, foo);
	}
	
	public Binding getBinding() {
			return binding;
	}

}
