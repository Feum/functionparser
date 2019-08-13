package callGraph;

public class cgInternalNode extends cgNode {

	cgNode[] children;
	
	
	public cgInternalNode(String label, cgNode... children) {
		
		this.label=label;
		this.children =  children;
		
		
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

}
