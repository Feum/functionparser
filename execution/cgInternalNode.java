package execution;

public class cgInternalNode extends cgNode {

	cgNode[] children;
	
	public cgInternalNode(String label, boolean performed, cgNode... children) {
		
		this.label=label;
		this.children =  children;
		this.hasBeenPerformed = performed;
		
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
	public void accept(Visitor v) {
		
		v.visit(this);
	
			for (cgNode child : children) 
				child.accept(v);
		
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
	public boolean hasChildrenBeenPerformed() {
		boolean correct = true;
		
		for (cgNode n : children)
			correct &= n.hasBeenPerformed();
		
		return correct;
	}

}
