package cycles;

import java.util.LinkedList;
import java.util.List;

public class Cycle {
	
	private static int nOfCycles = 0;
	private int ID;
	List<cgNode> nodes;
	
	public Cycle() {
			
		this.ID = nOfCycles;
		nOfCycles++;
		nodes = new LinkedList<cgNode>();
		
	}
	
	public int getID() {
		return ID;
	}
	
	public void addNode(cgNode nd) {
		nodes.add(nd);
	}
	
	public String toString() {
		String string = "";
		for (cgNode n : nodes) 
		{
			string = (n.getLabel() + " ") + string;
		}
		
		return string;
	}

}
