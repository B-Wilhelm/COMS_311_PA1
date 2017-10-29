/**
 * @author Brett Wilhelm
 * @author Harrison Zey
 */

/*	LEAVE THIS FILE IN THE DEFAULT PACKAGE
	(i.e., DO NOT add 'package cs311.pa1;' or similar)

	DO NOT MODIFY THE EXISTING METHOD SIGNATURES
	(you may, however, add member fields and additional methods)

	DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
	(i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)
*/


public class BinaryST
{
	
	private String data;
	private BinaryST right; 
	private BinaryST left;
	/**
	 * 
	 */
	public BinaryST()
	{
		// Creates Empty BST
		this.data = null;
		this.right = null;
		this.left = null;
	}
	
	/**
	 * 
	 * @param 	s 	An array of strings that are placed inside of a new Binary Search Tree
	 */
	public BinaryST(String[] s)
	{
		for(int i = 0; i < s.length; i++)
			add(s[i]);
	}
	
	/**
	 * 
	 * @return		The number of distinct strings stored in the Binary Search Tree
	 */
	public int distinctSize()
	{
		// TODO
		return 0;
	}
	
	/**
	 * 
	 * @return 		The total number of elements stored in the Binary Search Tree
	 */
	public int size()
	{
		// TODO
		return 0;
	}
	
	/**
	 * 
	 * @return 		The current height of the Binary Search Tree
	 */
	public int height()
	{
		// TODO
		return 0;
	}
	
	/**
	 * 
	 * @param	s	The string to be added to the Binary Search Tree
	 */
	public void add(String s)
	{
		if(this.data == null) {
			this.data = s;
		}else {
			if (s.compareTo(this.data) > 0){
				if (this.right != null)
						this.right.add(s);
				else
					this.right = new BinaryST(new String[]{s});
	
			}else{
				if (this.left != null)
					this.left.add(s);
				else
					this.left = new BinaryST(new String[]{s});
			}
		}
	}
	
	/**
	 * 
	 * @param	s	The string to be searched for in the Binary Search Tree
	 * @return		Returns true if the string is found in the Binary Search Tree; false otherwise
	 */
	public boolean search(String s)
	{
		// TODO
		return false;
	}
	
	/**
	 * 
	 * @param	s	The string that will have its number of occurrences counted in the Binary Search Tree
	 * @return		The number of times a string is found in the Binary Search Tree
	 */
	public int frequency(String s)
	{
		// TODO
		return 0;
	}
	
	/**
	 * 
	 * @param	s	The string that is to be removed from the Binary Search Tree
	 * @return		Returns true if the string is found and removed; false otherwise
	 */
	public boolean remove(String s)
	{
		// TODO
		return false;
	}
	
	/**
	 * 
	 * @return		Array of strings obtained from an in-order traversal of the Binary Search Tree
	 */
	public String[] inOrder()
	{	
		String[] currArray = {};
		String[] tempArray;
		String[] addedArray;
		
		if( this.left != null ) {
			addedArray = this.left.inOrder();
			tempArray = new String[currArray.length + addedArray.length];
			System.arraycopy(currArray, 0, tempArray, 0, currArray.length);
			System.arraycopy(addedArray, 0, tempArray, currArray.length, addedArray.length);
			currArray = tempArray;
		}
		
		addedArray = new String[] {this.data};
		tempArray = new String[currArray.length + addedArray.length];
		System.arraycopy(currArray, 0, tempArray, 0, currArray.length);
		System.arraycopy(addedArray, 0, tempArray, currArray.length, addedArray.length);
		currArray = tempArray;
		
		if( this.right != null ) {
			addedArray = this.right.inOrder();
			tempArray = new String[currArray.length + addedArray.length];
			System.arraycopy(currArray, 0, tempArray, 0, currArray.length);
			System.arraycopy(addedArray, 0, tempArray, currArray.length, addedArray.length);
			currArray = tempArray;
		}
		
		return currArray;
	}
	
	/**
	 * 
	 * @return		Array of strings obtained from a pre-order traversal of the Binary Search Tree
	 */
	public String[] preOrder()
	{
		// TODO
		return null;
	}
	
	/**
	 * 
	 * @param	s	The string that is to be ranked
	 * @return		The numeric rank of (number of strings smaller than) the string
	 */
	public int rankOf(String s)
	{
		// TODO
		return 0;
	}
}