package topologicalOrders;

public abstract class cgNode  {
	
	String label;
	boolean marked;
	int indegree;

	
	public void print() {
		System.out.print(label);
	}
	
	public abstract void accept (Visitor v);
	
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

}
