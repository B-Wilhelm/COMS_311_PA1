
public class Testing {

	public static void main(String[] args) {
		BinaryST tree = new BinaryST(new String[] {"D", "B", "A", "C", "B", "C", "F", "E", "E", "B", "F"});
		BinaryST tree2 = new BinaryST(new String[] {});
		BinaryST tree3 = new BinaryST(new String[] {"B", "B", "B", "B", "B"});
		String[] io = tree.inOrder();
		String[] po = tree.preOrder();
		printArray(io);
		printArray(po);
		System.out.println(tree.search("A"));
		System.out.println(tree.search("B"));
		System.out.println(tree.search("C"));
		System.out.println(tree.search("D"));
		System.out.println(tree.search("E"));
		System.out.println(tree.search("F"));
		System.out.println(tree.search("G"));
		System.out.println(tree3.distinctSize());
		System.out.println(tree3.size());
		System.out.println(tree3.height());
	}
	
	public static void printArray(String[] s) {
		for(int i = 0; i < s.length; i++)
			System.out.print(s[i] + " ");
		System.out.println();
	}
}
