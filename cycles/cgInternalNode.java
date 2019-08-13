package cycles;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class cgInternalNode extends cgNode {

	List<cgNode> children;
	List<Integer> cyclesThatStartFromMe;
	boolean isInStack;
	
	public cgInternalNode(String label) {
		
		this.label=label;
		this.children =  new LinkedList<cgNode>();
		this.isInStack = false;
		cyclesThatStartFromMe = new LinkedList<Integer>();
		
	}
	
	public cgInternalNode(String label, cgNode... children) {
		
		this.label=label;
		this.children =  new LinkedList<cgNode>(Arrays.asList(children));
		this.isInStack = false;
		cyclesThatStartFromMe = new LinkedList<Integer>();
			
	}
	
	public void addChild(cgNode n) 
	{
		children.add(n);
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

	@Override
	public List<Cycle> accept(Visitor v) {		
		
		List<Cycle> myCycles = new LinkedList<Cycle>();
		
		
		if (v.visit(this) == false) 
		{ //If a new cycle has not been found on me
			for (cgNode child : children) 
			{
				//For each of my children...
				
				List<Cycle> childCycles = child.accept(v);
				
				if (childCycles != null)
					for (Cycle c : childCycles)
					{
						//...check if i am the end node of their cycles...
						c.addNode(this);
						if (cyclesThatStartFromMe.contains(c.getID())) 
						{
							v.notify(c);
						}		
						//...or else just update and pass them to my father
						else myCycles.add(c);
					}
				
				
			}
			isInStack = false;
		}
		else
		{
			//If a new cycle has been found on me, create a new cycle and pass it to my father
			Cycle newcycle = new Cycle();
			newcycle.addNode(this);
			myCycles.add(newcycle);
			
			//Remember that i will be the end node of this cycle, when the recursion backtracks.
			cyclesThatStartFromMe.add(newcycle.getID());
		}
			return myCycles;
		
	}
	
	public boolean isInStack() {
		return isInStack;
	}
	
	public void setStackFlag(boolean f) {
		isInStack = f;
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

}
