package parallelism;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class TaskPool implements Iterable<cgNode> {
	
	//A pool of nodes organized by execution time (higher first)
	
	PriorityQueue<cgNode> pool;
	
	public TaskPool() {
		
		Comparator<cgNode> comparator = new Comparator<cgNode>() 
		{

			@Override
			public int compare(cgNode o1, cgNode o2) {
				
				return (o2.getExecutionTime() - o1.getExecutionTime());
			}
			
		};
		
		pool = new PriorityQueue<cgNode>(comparator);
		
	}
	
	public void add(cgNode n)
	{
		pool.add(n);
	}
	
	public cgNode poll() 
	{
		return pool.poll();
	}
	
	public boolean isEmpty()
	{
		return (pool.peek() == null);
	}

	@Override
	public Iterator<cgNode> iterator() {
	
		return (new TaskPoolIterator());
	}
	
	private class TaskPoolIterator implements Iterator<cgNode> {

		@Override
		public boolean hasNext() {
			return !isEmpty();
		}

		@Override
		public cgNode next() {

			return poll();
		}
		
	}

}
