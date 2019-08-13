package parallelism;

public class cgLeaf extends cgNode{

	
	
	public cgLeaf(String label, int executionTime)
	{
		this.label = label;
		this.marked = false;
		this.indegree = 0;
		this.executionTime = executionTime;
		this.timeStamp = 0;
		this.priority = 0;
	
	}

	@Override
	public int accept(Visitor v) {
		v.visit(this);
		
		return 0;
		
	}

	@Override
	public void incrementChildrenIndegree() {}

	@Override
	public void decrementChildrenIndegree() {}

	@Override
	public int calculateTimeToWait() {
		return 0;
	}
	
	
	

}
