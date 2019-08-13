package cycles;

public interface Visitor {
	
	public boolean visit(cgInternalNode a);
	
	public boolean visit(cgLeaf a);

	public void notify(Cycle c);
	

}
