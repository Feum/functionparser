package topologicalOrders;

public class cgLeaf extends cgNode{

	
	
	public cgLeaf(String label)
	{
		this.label = label;
		this.marked = false;
		this.indegree = 0;
	
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
		
	}

	@Override
	public void incrementChildrenIndegree() {}

	@Override
	public void decrementChildrenIndegree() {}
	

}
