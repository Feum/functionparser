package parallelism;

import java.util.LinkedList;
import java.util.List;

public class Processor {

	List<cgNode> tasks;
	String history;
	int load;
	
	public Processor() {
		
		tasks = new LinkedList<cgNode>();
		load = 0;
		history = "";
	}
	
	public void addTask(cgNode n) {
		
		tasks.add(n);
		load += n.getExecutionTime();
		history += n.getLabel() + "(" + n.executionTime + ") ";
		
	}
	
	public void idle(int idleTime) {
		
		if (idleTime > 0) 
			{
				load+=idleTime;
				history+= "idle("+idleTime+") ";
			}
	}
	
	public int getLoad() {
		return load;
	}
	
	public String getHistory() {
		return history;
	}
}
