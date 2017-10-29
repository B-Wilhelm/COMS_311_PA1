
public class TestWar {
	
	public static void main(String[] args) {
		String[] arr = {"ac", "ca", "cc"};
		long start, time;
		
		WarWithArray wa = new WarWithArray(arr, arr[0].length());
		start = System.nanoTime();
		System.out.println("Array:");
//		System.out.println(wa.compute2k().toString());
		time= (System.nanoTime() - start);
		System.out.println("Time elapsed: " + time + "ns\n");
		
		WarWithBST wb = new WarWithBST(arr, arr[0].length());
		start = System.nanoTime();
		System.out.println("BST:");
//		System.out.println(wb.compute2k().toString());
		time= (System.nanoTime() - start);
		System.out.println("Time elapsed: " + time + "ns\n");
		
		WarWithHash wh = new WarWithHash(arr, arr[0].length());
		start = System.nanoTime();
		System.out.println("Hashtable:");
//		System.out.println(wh.compute2k().toString());
		time= (System.nanoTime() - start);
		System.out.println("Time elapsed: " + time + "ns");
	}
}