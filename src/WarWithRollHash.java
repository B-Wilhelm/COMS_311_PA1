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
import java.util.Hashtable;


public class WarWithRollHash
{
	private String[] s;
	private int k;
	private Hashtable<String,String> table;
	
	/**
	 * creates an object that stores an input string-array (into a Rolling Hash) of DNA sequences for later computation
	 * @param	s	The set of substrings (length k) of the DNA sequence
	 * @param	k	The length of substrings (in s) of the DNA sequence
	 */
	public WarWithRollHash(String[] s, int k)
	{
		table = new Hashtable<String,String>(s.length);
		this.s = s;
		this.k = k;
		
		for(String value : s) {
			table.put(value, value);
		}
	}
	
	/**
	 * Computes DNA sequences with length 2*k
	 * @return		The ArrayList of all substrings of the DNA sequence with length 2*k
	 */
	public ArrayList<String> compute2k()
	{
		// TODO
		return null;
	}
}