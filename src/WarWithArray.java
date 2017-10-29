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

import java.util.ArrayList;


public class WarWithArray
{
	String[] s;
	int k;
	ArrayList<String> c;
	
	/**
	 * creates an object that stores an input string-array (into an array) of DNA sequences for later computation
	 * @param	s	The set of substrings (length k) of the DNA sequence
	 * @param	k	The length of substrings (in s) of the DNA sequence
	 */
	public WarWithArray(String[] s, int k)
	{
		this.s = s;
		this.k = k;
	}
	
	/**
	 * Computes DNA sequences with length 2*k
	 * @return		The ArrayList of all substrings of the DNA sequence with length 2*k
	 */
	public ArrayList<String> compute2k()
	{
		c = new ArrayList<String>();
		
		for(int i = 0; i < s.length; i++) {
			for(int j = 0; j < s.length; j++) {
				c.add(s[i]+s[j]);
			}
		}
		
		return c;
	}
}