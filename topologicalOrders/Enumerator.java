package topologicalOrders;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Enumerator implements Iterable<String> {
	
	Logic logic;
	List<String> solutions;
	Iterator<String> iterator;
	
	
	public Enumerator (cgNode root) {
		
		this.logic = new Logic(root, this);
		solutions = new LinkedList<String>();
		logic.findSolutions();
		
		iterator = solutions.iterator();
		
	}

	
	public void yield(String solution) {
		solutions.add(solution);
	}
	
	@Override
	public Iterator<String> iterator() {
		return new EnumeratorIterator();
	}
	
	private class EnumeratorIterator implements Iterator<String>{

		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		@Override
		public String next() {
			return iterator.next();
		}
		
	}


}
