package cycles;

import java.util.List;

public class cgLeaf extends cgNode{

	
	
	public cgLeaf(String label)
	{
		this.label = label;
		this.marked = false;
		this.indegree = 0;
	
	}

	@Override
	public List<Cycle> accept(Visitor v) {
		v.visit(this);
		
		return null;
		
	}

	@Override
	public void incrementChildrenIndegree() {}

	@Override
	public void decrementChildrenIndegree() {}
	

}
