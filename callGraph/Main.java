package callGraph;

public class Main {

	public static void main(String[] args) {
		
		cgLeaf c = new cgLeaf("c");
		
		cgNode root = new cgInternalNode(
						"f",new cgInternalNode(
								"a", new cgInternalNode("b", c), c));
		
		
		root.print();
								

	}

}
