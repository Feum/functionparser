package execution;

public interface Visitor {
	
	public void visit(cgInternalNode a);
	
	public void visit(cgLeaf a);
	

}
