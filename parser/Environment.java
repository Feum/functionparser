package parser;

import java.util.HashMap;
import java.util.Map;

public class Environment {
	
	private Map<String, cgNode> env;
	
	public Environment () {
		env = new HashMap<String, cgNode>();
	}
	
	public void addBinding (Binding a) {
		
		env.put(a.getIdentifier(), a.getFunction());
	}
	
	public cgNode getFuction (String identifier) {
		
		return env.get(identifier);
	}

}
