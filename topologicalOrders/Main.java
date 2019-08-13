package topologicalOrders;

public class Main {

	public static void main(String[] args) {
		
		
		cgNode c = new cgLeaf("c");
		cgNode f = new cgLeaf("f");
		
		cgNode root = new cgInternalNode("root", 
					new cgInternalNode("d",
							new cgInternalNode("b",
									new cgInternalNode("a",
											f)),
							c), new cgInternalNode("e", c, f));
	
					
		
		Enumerator en = new Enumerator(root);
		
		for (String s : en) System.out.print(s);
								

	}

}
