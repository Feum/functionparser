package cycles;

import java.util.LinkedList;
import java.util.List;

public class Logic {

	cgNode[] vertices;
	cgNode root;
	List<Integer> solution;
	Enumerator enumerator;
	boolean cycleWarning;
	
	public Logic (cgNode root, Enumerator enumerator) {
		
		solution = new LinkedList<Integer>();
		this.root = root;
		this.enumerator = enumerator;
		cycleWarning = false;
	}
	
	//returns: false if the graph has cycles
	public boolean isGraphReady() {
		Initializer init = new Initializer(root, this);
		this.vertices = init.initialize();
		return !cycleWarning;
	}
	
	public void findSolutions()
	{
	
		boolean allSolutionsFound = false;
	
		//Try all the possibilities among the 0-indegree nodes
		for (int i = 0; i< vertices.length; i++ )
		{
			
			cgNode n = vertices[i];
			
			//When i try a node, i decrement the indegree of his children and remove it from the graph...
			if ((!n.isMarked()) && n.isIndegreeZero())
			{
				n.setMark(true);
				n.decrementChildrenIndegree();
				
				//...add it to the solution and so on...
				solution.add(i);
								
				findSolutions();
				
				//...until i backtrack. Then i clean up for trying other possibilities.
				n.setMark(false);
				n.incrementChildrenIndegree();
				solution.remove(solution.indexOf(i));
				
				allSolutionsFound = true;
			}
		}
		
		if (!allSolutionsFound) {
			
			String sol = "";
			
			for (int i : solution)
			{
				sol = (vertices[i].getLabel() + " ") + sol;
			}
			sol += "\n";
			
			enumerator.yield(sol);
		}
		

	}
	
	public void notifyCycles(Cycle c) {
		
		cycleWarning = true;
		System.out.println("Cycle detected: " + c.toString());
		
	}
	
}
