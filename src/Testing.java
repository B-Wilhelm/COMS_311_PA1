
public class Testing {

	public static void main(String[] args) {
		BinaryST tree = new BinaryST(new String[] {"ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX"});
		String[] io = tree.inOrder();
		printArray(io);
	}
	
	public static void printArray(String[] s) {
		for(int i = 0; i < s.length; i++)
			System.out.print(s[i] + " ");
	}
}
