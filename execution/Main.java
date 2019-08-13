package execution;

public class Main {

	public static void main(String[] args) {
		
		
		cgNode c = new cgLeaf("c", false);
		cgNode f = new cgLeaf("f", false);
		
		cgNode root = new cgInternalNode("root", false, 
					new cgInternalNode("d", false, 
							new cgInternalNode("b", false, 
									new cgInternalNode("a", false,
											f)),
							c), new cgInternalNode("e", false, c, f));
	
					
		
		Enumerator en = new Enumerator(root);
		
		for (String s : en) System.out.print(s);
								

	}

}
