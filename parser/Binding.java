package parser;

public class Binding {
	
	String identifier;
	cgNode function;
	
	public Binding (String id, cgNode foo)
	{
		identifier = id;
		function = foo;
		
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public cgNode getFunction() {
		
		return function;
	}

}
