package cycles;

import java.util.LinkedList;
import java.util.List;

public class Initializer implements Visitor {

	List<cgNode> verticesList;
	Logic logic;
	cgNode root;
	
	public Initializer(cgNode root, Logic logic) {
		
		verticesList = new LinkedList<cgNode>();
		this.logic = logic;
		this.root = root;


	}
	
	//returns: true if a cycle has been found
	@Override
	public boolean visit(cgInternalNode n) {
		
		if (!n.isMarked())
		{
			n.setMark(true);
			n.incrementChildrenIndegree();
			verticesList.add(n);
		}
		
		if (!n.isInStack) 
			n.setStackFlag(true);
		else
			return true;

		
		return false;
		
		
		
	}

	@Override
	public boolean visit(cgLeaf l) {
		
		if (!l.isMarked())
		{
			l.setMark(true);
			verticesList.add(l);
		}
		
		return false;

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

	@Override
	public void notify(Cycle c) {
		
		logic.notifyCycles(c);
		
	}

}
