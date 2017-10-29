
public class TestWar {
	
	public static void main(String[] args) {
		String[] arr = {"ac", "ca", "cc"};
		String results;
		long start, time;
		
		WarWithArray wa = new WarWithArray(arr, arr[0].length());
		start = System.nanoTime();
		System.out.println("Array:");
		results = wa.compute2k().toString();
//		System.out.println(results);
		time= (System.nanoTime() - start);
		System.out.println("Time elapsed: " + time + "ns\n");
		
		WarWithBST wb = new WarWithBST(arr, arr[0].length());
		start = System.nanoTime();
		System.out.println("BST:");
		results = wb.compute2k().toString();
//		System.out.println(results);
		time= (System.nanoTime() - start);
		System.out.println("Time elapsed: " + time + "ns\n");
		
		WarWithHash wh = new WarWithHash(arr, arr[0].length());
		start = System.nanoTime();
		System.out.println("Hashtable:");
		results = wh.compute2k().toString();
//		System.out.println(results);
		time= (System.nanoTime() - start);
		System.out.println("Time elapsed: " + time + "ns");
	}
}