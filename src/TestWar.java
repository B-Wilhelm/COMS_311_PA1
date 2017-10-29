
public class TestWar {
	
	public static void main(String[] args) {
		String[] arr = {"ac", "ca", "cc"};
		WarWithArray wa = new WarWithArray(arr, arr[0].length());
		System.out.println(wa.compute2k().toString());
	}
	
}