package parser;

public class SyntaxErrorException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public SyntaxErrorException (String msg) 
	{
		super(msg);
	}

}
