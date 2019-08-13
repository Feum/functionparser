package execution;

import java.util.LinkedList;
import java.util.List;

public class Initializer implements Visitor {

	List<cgNode> verticesList;
	cgNode root;
	
	public Initializer(cgNode root) {
		
		verticesList = new LinkedList<cgNode>();
		this.root = root;
	}
	
	@Override
	public void visit(cgInternalNode n) {
		
		if (!n.isMarked())
		{
			n.setMark(true);
			n.incrementChildrenIndegree();
			verticesList.add(n);
		}
		
	}

	@Override
	public void visit(cgLeaf l) {
		
		if (!l.isMarked())
		{
			l.setMark(true);
			verticesList.add(l);
		}

	}
	
	public cgNode[] initialize()
	{
		//initializing
		root.accept(this);
		
		//cleaning and collecting list of vertices
		int size = verticesList.size();
		cgNode[] array = new cgNode[size];
		cgNode n;
		for (int i = 0; i < size; i++) 
			{
				n = verticesList.get(i);
				n.setMark(false);
				array[i] = n;
			}
		return array;
	}

}
