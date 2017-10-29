
public class Testing {

	public static void main(String[] args) {
		BinaryST tree = new BinaryST(new String[] {"D", "B", "A", "C", "F", "E"});
		String[] io = tree.inOrder();
		String[] po = tree.preOrder();
		printArray(io);
		printArray(po);
	}
	
	public static void printArray(String[] s) {
		for(int i = 0; i < s.length; i++)
			System.out.print(s[i] + " ");
		System.out.println();
	}
}
