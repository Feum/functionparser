package parallelism;

import java.util.LinkedList;
import java.util.List;

public class PriorityVisitor implements Visitor {

	cgNode root;
	List<cgNode> verticesList;
	
	public PriorityVisitor (cgNode root) {
		this.root = root;
		this.verticesList = new LinkedList<cgNode>();
	}
	
	@Override
	public void visit(cgInternalNode n) {
		
		if (!n.isMarked())
		{
			n.setMark(true);
			verticesList.add(n);
		}

	}

	@Override
	public void visit(cgLeaf a) {

		if (!a.isMarked())
		{
			a.setMark(true);
			verticesList.add(a);
		}


	}
	
	private TaskPool[] initialize(TaskPool[] array) {
		
		for (int i = 0; i < array.length; i++) array[i] = new TaskPool();
		
		return array;
		
	}
	
	public TaskPool[] calculatePriorities() {
		
		//calculatingPriorities
		root.accept(this);
		int maxPriority = root.getPriority() + 1;
		
		//initalization of the container (a pool for each priority)
		TaskPool[] priorityPools = initialize(new TaskPool[maxPriority]);		
		
		//cleaning and dividing vertices by priority
		for (cgNode n : verticesList)
			priorityPools[n.getPriority()].add(n);
			
		return priorityPools;
		
	}
}
