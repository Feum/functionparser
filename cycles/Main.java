package cycles;

public class Main {

	public static void main(String[] args) {
		
		
		cgInternalNode c = new cgInternalNode("c");
		cgInternalNode f = new cgInternalNode("f");
		cgInternalNode a = new cgInternalNode("a", f);
		cgInternalNode d = new cgInternalNode("d",
								new cgInternalNode("b",
										a), c);
		
		cgInternalNode root = new cgInternalNode("root", d, new cgInternalNode("e", c, f));
	
		a.addChild(d);
		f.addChild(d);
		d.addChild(f);
		
		
		
		Enumerator en = new Enumerator(root);
		
		while (en.hasNext())
			{System.out.print(en.next());
			}
								

	}

}
