package parallelism;

public class cgInternalNode extends cgNode {

	cgNode[] children;
	
	public cgInternalNode(String label, int executionTime, cgNode... children) {
		
		this.label=label;
		this.children =  children;
		this.executionTime = executionTime;
		this.timeStamp = 0;
		this.priority = 0;
		
	}

	public void print() {
		
		System.out.print(label + " -> (");
		for (int i = 0; i < children.length; i++) 
		{
			children[i].print();
			if (i != children.length - 1) System.out.print(" , ");
		}
		System.out.print(")");
	}

	@Override
	public int accept(Visitor v) {
		
		v.visit(this);
		int maxpriority = 0;
		 
	
			for (cgNode child : children) 
				{
					
					int childpriority = child.accept(v);
					maxpriority = maxpriority < childpriority ? childpriority : maxpriority;
					
				}
			
			this.priority = maxpriority + 1;
			
		return this.priority;
		
	}

	@Override
	public void incrementChildrenIndegree() {
		
		for (cgNode child : children)
			child.incrementIndegree();
	}

	@Override
	public void decrementChildrenIndegree() {
	
		for (cgNode child : children)
			child.decrementIndegree();
		
	}

	@Override
	public int calculateTimeToWait() {

		int timeToWait = 0;
		
		for (cgNode child : children)
			timeToWait = timeToWait < child.getTimeStamp() ? child.getTimeStamp() : timeToWait;
			
		return timeToWait;
		
	}
	
}
