package parser;

import java.io.IOException;

public abstract class Expression {

	Scanner scanner;
	Environment environment;
	
	public Expression (Scanner scanner, Environment environment) {
		this.scanner = scanner;
		this.environment = environment;
	}
	
	protected void expect(TokenType expected) {
			
			TokenType token = nextToken();
			String ps = "";
			
			if (expected != token) 
				{
					if (token == TokenType.COMMA || token == TokenType.RIGHTP) ps = "\nMaybe forgot '()' after parameterless function?";
					error("Unexpected token " + token + ps );
					
				}
		}
	
	protected TokenType nextToken() {
		
		TokenType token = TokenType.EOI;
		
		try {
			token = scanner.nextToken();
		}
		catch (IOException e) {
			error("Invalid read operation");			
		}
		catch (SyntaxErrorException ex) {
			error(ex.getMessage());
			
		}
		
		return token;
	}
	
	protected TokenType lookAhead() {
		
		TokenType token = TokenType.EOI;
		
		try {
			token = scanner.lookAhead();
		}
		catch (IOException e) {
			error("Invalid read operation");			
		}
		catch (SyntaxErrorException ex) {
			error(ex.getMessage());
			
		}
		
		return token;
	}
	
	protected void error(String message) {
		
		System.err.println(message);
		System.exit(1);
	}
	
}

