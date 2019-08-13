package execution;

import java.util.LinkedList;
import java.util.List;

public class Logic {

	cgNode[] vertices;
	cgNode root;
	List<Integer> solution;
	Enumerator enumerator;
	
	public Logic (cgNode root, Enumerator enumerator) {
		
		solution = new LinkedList<Integer>();
		Initializer init = new Initializer(root);
		this.vertices = init.initialize();
		this.root = root;
		this.enumerator = enumerator;
	}
	
	public void findSolutions() throws ImpossibileSequenceException
	{
		
		for (cgNode n : vertices) 
			if (n.hasBeenPerformed() && !n.hasChildrenBeenPerformed()) 
				throw new ImpossibileSequenceException(); 
	
		boolean allSolutionsFound = false;
		
		
		//Try all the possibilities among the 0-indegree nodes
		for (int i = 0; i< vertices.length; i++ )
		{
			
			cgNode n = vertices[i];
					
			//When i try a node, i update the indegree of his children and remove it from the graph...
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
				if (!vertices[i].hasBeenPerformed())
					sol = (vertices[i].getLabel() + " ") + sol;
			}
			sol += "\n";
			
			enumerator.yield(sol);
		}
		

	}
	
}
