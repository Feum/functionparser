package cycles;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Enumerator {
	
	Logic logic;
	List<String> solutions;
	Iterator<String> iterator;
	
	
	public Enumerator (cgNode root) {
		
		this.logic = new Logic(root, this);
		solutions = new LinkedList<String>();
		if (logic.isGraphReady()) logic.findSolutions();
		
		iterator = solutions.iterator();
		
	}

	
	public void yield(String solution) {
		solutions.add(solution);
	}
	
	public boolean hasNext() {
		return iterator.hasNext();
	}
	
	public String next() {
		if (hasNext())
			return iterator.next();
		else return null;
	}
}
