package execution;

public class cgLeaf extends cgNode{

	
	
	public cgLeaf(String label, boolean performed)
	{
		this.label = label;
		this.marked = false;
		this.indegree = 0;
		this.hasBeenPerformed = performed;
	
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
		
	}

	@Override
	public void incrementChildrenIndegree() {}

	@Override
	public void decrementChildrenIndegree() {}

	@Override
	public boolean hasChildrenBeenPerformed() {
		
		return true;
	}
	

}
