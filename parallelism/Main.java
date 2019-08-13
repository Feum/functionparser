package parallelism;

public class Main {

	public static void main(String[] args) {
		
		cgNode a = new cgLeaf("a", 1);
		cgNode b = new cgLeaf("b", 2);
		cgNode c = new cgLeaf("c", 3);
		cgNode d = new cgLeaf("d", 4);
		cgNode e = new cgLeaf("e", 5);
		
		cgNode aa = new cgInternalNode("aa", 6, a);
		cgNode bb = new cgInternalNode("bb", 7, b, d);
		cgNode cc = new cgInternalNode("cc", 8, a, e);
		cgNode dd = new cgInternalNode("dd", 9, d, c);
		cgNode ee = new cgInternalNode("ee", 10, dd, dd);
		cgNode ff = new cgInternalNode("ff", 11, b, bb);
		
		cgNode aaa = new cgInternalNode("aaa", 12, ee, ff);
		cgNode bbb = new cgInternalNode("bbb", 13, aa, bb);
		cgNode ccc = new cgInternalNode("ccc", 14, cc, dd);
		
		cgNode root = new cgInternalNode("root", 0, aaa, bbb, ccc);
		
		Logic logic = new Logic(root, 5);
		logic.distributeLoad();
		logic.print();

	}

}
