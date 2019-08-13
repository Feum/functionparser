package parallelism;

public abstract class cgNode  {
	
	String label;
	boolean marked;
	int indegree;
	int executionTime; //intrinsics time needed for this function
	int timeStamp; //execution will end at this time
	int priority;

	
	public void print() {
		System.out.print(label);
	}
	
	public abstract int accept (Visitor v);
	
	public void incrementIndegree()
	{
		indegree++;
	}
	
	public void decrementIndegree() {
	
		indegree--;
	}
	
	public abstract void incrementChildrenIndegree();

	
	public abstract void decrementChildrenIndegree();

	public boolean isIndegreeZero() {
	
		return (indegree == 0);
	}
	
	public boolean isMarked() {
		 return marked;
	}
	
	public void setMark(boolean b) {
		
		marked = b;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setExecutionTime(int et) {
		this.executionTime = et;
	}
	
	public int getExecutionTime() {
		return this.executionTime;
	}
	
	public int getTimeStamp() {
		return timeStamp;
	}
	
	public void setTimeStamp(int timestamp)
	{
		timeStamp = timestamp;
	}
	
	public abstract int calculateTimeToWait();
	
	public void setPriority(int pd) {
		this.priority = pd;
	}

	public int getPriority () {
		return this.priority;
	}
	

}
