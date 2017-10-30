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
	 * Default Constructor; Creates a Binary Search Tree
	 */
	public BinaryST()
	{
		// Creates Empty BST
		this.data = null;
		this.right = null;
		this.left = null;
	}
	
	/**
	 * Constructor; Creates a Binary Search Tree and fills it with Strings from an array
	 * @param 	s 	An array of strings that are placed inside of a new Binary Search Tree
	 */
	public BinaryST(String[] s)
	{
		for(int i = 0; i < s.length; i++)
			add(s[i]);
	}
	
	/**
	 * Returns the number of unique strings in the Binary Search Tree
	 * @return		The number of distinct strings stored in the Binary Search Tree
	 */
	public int distinctSize()
	{
		String[] io = inOrder();
		int count = 0;
		
		if(this.data != null)
			count = 1;
		
		for(int i = 1; i < io.length; i++){
			if(io[i].compareTo(io[i-1]) != 0) {
				count++;
			}
		}
		
		return count;
	}
	
	/**
	 * Finds the total number of elements in the Binary Search Tree
	 * @return 		The number of elements stored in the Binary Search Tree
	 */
	public int size()
	{
		int size = 0;
		if(this.data != null)
			size = 1;
		
		if(this.right != null) 
				size += this.right.size();
		if(this.left != null)
				size += this.left.size();
		return size;
	}
	
	/**
	 * Returns the height of the Binary Search Tree
	 * @return 		The current height of the Binary Search Tree
	 */
	public int height()
	{
		int left = 0,right = 0;
		if(this.data != null){
			left = 1; right = 1;
		}
		
		if(this.right != null) 
				right += this.right.height();
		if(this.left != null)
				left += this.left.height();
		return Math.max(right, left);
	}
	
	/**
	 * Adds a string to the Binary Search Tree
	 * @param	s	The string to be added to the Binary Search Tree
	 */
	public void add(String s)
	{
		if(this.data == null) {
			this.data = s;
		}else {
			if (s.compareTo(this.data) < 0){
				if (this.left != null)
						this.left.add(s);
				else
					this.left = new BinaryST(new String[]{s});
	
			}else{
				if (this.right != null)
					this.right.add(s);
				else
					this.right = new BinaryST(new String[]{s});
			}
		}
	}
	
	/**
	 * Checks to see if an inputed string can be found in the Binary Search Tree
	 * @param	s	The string to be searched for in the Binary Search Tree
	 * @return		Returns true if the string is found in the Binary Search Tree; false otherwise
	 */
	public boolean search(String s)
	{
		boolean found = false;
		if(s.compareTo(this.data) > 0){
			if(this.right != null)
				found = this.right.search(s);
		}else if(s.compareTo(this.data) < 0){
			if(this.left != null)
				found = this.left.search(s);
		} else {
			found = true;
		}
		return found;
	}
	
	/**
	 * Calculates the number of occurences a string has in the Binary Search Tree
	 * @param	s	The string that will have its number of occurrences counted in the Binary Search Tree
	 * @return		The number of times a string is found in the Binary Search Tree
	 */
	public int frequency(String s)
	{
		int count = 0;
		if(s.compareTo(this.data) > 0){
			if(this.right != null)
				count += this.right.frequency(s);
		}else if(s.compareTo(this.data) < 0){
			if(this.left != null)
				count += this.left.frequency(s);
		} else {
			count ++;
			if(this.right != null)
				count += this.right.frequency(s);
		}
		return count;
	}
	
	/**
	 * Removes a string from the Binary Search Tree
	 * @param	s	The string that is to be removed from the Binary Search Tree
	 * @return		Returns true if the string is found and removed; false otherwise
	 */
	public boolean remove(String s){		
		if(!search(s))
			return false;
		else
			return remove(s, this);
    }
	
	/**
	 * Helper method for removing a string from the Binary Search Tree
	 * @param	s		The string that is to be removed from the Binary Search Tree
	 * @param	root	The root of the Binary Search Tree
	 * @return			Returns true if the string is found and removed; false otherwise
	 */
	public boolean remove(String s, BinaryST root) {
		if (s.compareTo(this.data) < 0){
	        if (left != null)
	              return left.remove(s, this);
	        else
	              return false;
	  }else if (s.compareTo(this.data) > 0){
	        if (right != null)
	              return right.remove(s, this);
	        else
	              return false;
	  }else{
	        if (left != null && right != null) {
	        	this.data = right.min();
				right.remove(this.data, this);
	        } else if (root.left == this) {
        		root.left = (left != null) ? left : right;
	        } else if (root.right == this) {
	        	root.right = (left != null) ? left : right;
	        }
	        return true;
        }
	}
	
	/**
	 * Returns the value on the left of the inputed root
	 * @return			Returns the value on the left of a root; this will be the smallest element of a chain
	 */
	public String min() {
		if (left == null)
		      return data;
		else
		      return left.min();
	}
	
	/**
	 * Creates a listing of the strings in the Binary Search Tree via in-order traversal
	 * @return		Array of strings obtained from an in-order traversal of the Binary Search Tree
	 */
	public String[] inOrder()
	{	
		String[] currArray = {};
		
		if( this.left != null )
			currArray = appendArray(currArray, this.left.inOrder());
			currArray = appendArray(currArray, new String[] {this.data});
		if( this.right != null )
			currArray = appendArray(currArray, this.right.inOrder());
		
		return currArray;
	}
	
	/**
	 * Creates a listing of the strings in the Binary Search Tree via pre-order traversal
	 * @return		Array of strings obtained from a pre-order traversal of the Binary Search Tree
	 */	
	public String[] preOrder()
	{
		String[] currArray = {};
		
		currArray = appendArray(currArray, new String[] {this.data});
		if( this.left != null )
			currArray = appendArray(currArray, this.left.preOrder());
		if( this.right != null )
			currArray = appendArray(currArray, this.right.preOrder());
		
		return currArray;
	}
	
	public String[] appendArray(String[] currArray, String[] addedArray) {
		String[] tempArray;
		
		tempArray = new String[currArray.length + addedArray.length];
		System.arraycopy(currArray, 0, tempArray, 0, currArray.length);
		System.arraycopy(addedArray, 0, tempArray, currArray.length, addedArray.length);
		return tempArray;
	}
	
	/**
	 * 
	 * @param	s	The string that is to be ranked
	 * @return		The numeric rank of (number of strings smaller than) the string
	 */
	public int rankOf(String s)
	{
		int rank = 0;
		
		if(!search(s))
			return 0;
		
		if(s.compareTo(this.data) > 0){
			if(this.right != null) {
				rank = this.right.rankOf(s) + 1;
				if(this.left != null)
					rank += this.left.size();
			}
		}else if(s.compareTo(this.data) < 0){
			if(this.left != null)
				rank = this.left.rankOf(s);
		} else {
			if(this.left != null)
				rank = this.left.size();
		}
		
		return rank;
	}
}