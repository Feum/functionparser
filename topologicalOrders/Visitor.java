package topologicalOrders;

public interface Visitor {
	
	public void visit(cgInternalNode a);
	
	public void visit(cgLeaf a);
	

}
