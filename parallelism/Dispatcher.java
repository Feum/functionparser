package parallelism;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Dispatcher {

	PriorityQueue<Processor> processors;
	
	public Dispatcher (int nProcessors) 
	{
		
		Comparator <Processor> comparator = new Comparator<Processor>() {

			@Override
			public int compare(Processor o1, Processor o2) {
				
				return (o1.getLoad() - o2.getLoad());
			}
			
		};
		processors = new PriorityQueue<Processor>(comparator);
		for (int i = 0; i < nProcessors; i++) processors.add(new Processor());
	}
	
	//Adds the task to the less loaded processor (making it wait if needed)
	public void addTask (cgNode n) 
	{
		int timeToWait = n.calculateTimeToWait();
		Processor p = processors.poll();
		
		p.idle(timeToWait - p.getLoad());
		p.addTask(n);
		
		//register the time at which the task will end executing
		n.setTimeStamp(p.getLoad());
		
		//update the queue
		processors.add(p);
		

	}
	
	public int getMaxLoad() 
	{
		int load = 0;
		for (Processor p : processors) 
			load = p.getLoad() <= load ? load : p.getLoad();
		
		return load;
	}
	
	public void printProcessingHistory() {
		
		Iterator<Processor> iterator = processors.iterator();
		int i = 0;
		while (iterator.hasNext())	
			{
				System.out.println("Processor N°" + i + ": " + iterator.next().getHistory());
				i++;
			}
			
	}
	
}
