package parser;

import java.util.Iterator;
import java.util.List;

public class cgInternalNode extends cgNode {

	List<cgNode> children;
	
	public cgInternalNode(String label, List<cgNode> children) {
		
		this.label=label;
		this.children = children;
		
	}

	public void print() {
		
		System.out.print(label + " -> (");
		Iterator<cgNode> iterator = children.iterator();
		while (iterator.hasNext())
		{
			iterator.next().print();
			if (iterator.hasNext()) System.out.print(" , ");
		}
		System.out.print(")");
		
	}

}
