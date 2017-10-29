
public class Testing {

	public static void main(String[] args) {
		BinaryST tree = new BinaryST(new String[] {"D", "B", "A", "C", "B", "C", "F", "E", "E", "B", "F"});
		BinaryST tree2 = new BinaryST(new String[] {});
		BinaryST tree3 = new BinaryST(new String[] {"B", "B", "B", "B", "B"});
		BinaryST tree4 = new BinaryST(new String[] {"D", "B", "A", "C", "E", "F"});
		String[] io = tree4.inOrder();
		String[] po = tree4.preOrder();
		printArray(io);
		printArray(po);
		System.out.println(tree.search("A"));
		System.out.println(tree.search("B"));
		System.out.println(tree.search("C"));
		System.out.println(tree.search("D"));
		System.out.println(tree.search("E"));
		System.out.println(tree.search("F"));
		System.out.println(tree.search("G"));
		System.out.println(tree.distinctSize());
		System.out.println(tree.size());
		System.out.println(tree.height());
		System.out.println();
		System.out.println(tree.rankOf("A"));
		System.out.println(tree.rankOf("B"));
		System.out.println(tree.rankOf("C"));
		System.out.println(tree.rankOf("D"));
		System.out.println(tree.rankOf("E"));
		System.out.println(tree.rankOf("F"));
		System.out.println(tree.rankOf("G"));
		tree.remove("E");
		io = tree.inOrder();
		printArray(io);
		System.out.println();
		System.out.println(tree.frequency("A"));
		System.out.println(tree.frequency("B"));
		System.out.println(tree.frequency("C"));
		System.out.println(tree.frequency("D"));
		System.out.println(tree.frequency("E"));
		System.out.println(tree.frequency("F"));
		System.out.println(tree.frequency("G"));
	}
	
	public static void printArray(String[] s) {
		for(int i = 0; i < s.length; i++)
			System.out.print(s[i] + " ");
		System.out.println();
	}
}
