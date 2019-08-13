package parallelism;

public class Logic {

	cgNode root;
	TaskPool[] priorityPools;
	Dispatcher taskDispatcher;

	
	public Logic (cgNode root, int nProcessor) {
		this.root = root;
		PriorityVisitor v = new PriorityVisitor(root);
		this.priorityPools = v.calculatePriorities();
		taskDispatcher = new Dispatcher(nProcessor);
		
	}
	
	public void distributeLoad () {
		
		
		//For each possible priority level
		for (TaskPool tp : priorityPools) 
			//Dispatch every function to the less loaded processor (making it wait if needed)
			for (cgNode n : tp) taskDispatcher.addTask(n);
					
	}
	
	public void print() {
		
		System.out.println("Minimized Execution Time: " + taskDispatcher.getMaxLoad() + "\n");
		taskDispatcher.printProcessingHistory();
		
	}
}
