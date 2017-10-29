
public class TestWar {
	
	public static void main(String[] args) {
		String[] arr = {"ac", "ca", "cc"};
		long start;
		
		WarWithArray wa = new WarWithArray(arr, arr[0].length());
		start = System.nanoTime();
		System.out.println("Array:\n" + wa.compute2k().toString());
		System.out.println(System.nanoTime()-start);
		
		WarWithHash wh = new WarWithHash(arr, arr[0].length());
		start = System.nanoTime();
		System.out.println("\nHashtable:\n" + wh.compute2k().toString());
		System.out.println(System.nanoTime()-start);
	}
}