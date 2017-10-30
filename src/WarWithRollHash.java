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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WarWithRollHash
{
	private String[] s;
	private int k;
	private ArrayList<String> c;
	private String temp;
	private final Map<String, Integer> map = new HashMap<>();
	private int A_SIZE_POW_9;
	
	/**
	 * creates an object that stores an input string-array (into a Rolling Hash) of DNA sequences for later computation
	 * @param	s	The set of substrings (length k) of the DNA sequence
	 * @param	k	The length of substrings (in s) of the DNA sequence
	 */
	public WarWithRollHash(String[] s, int k)
	{
		this.s = s;
		this.k = k;
		
		for(String value : s)
			map.put(value, 0);
		
		A_SIZE_POW_9 = (int) Math.pow(map.size(), 9);
	}
	
	/**
	 * Computes DNA sequences with length 2*k
	 * @return		The ArrayList of all substrings of the DNA sequence with length 2*k
	 */
	public ArrayList<String> compute2k() {
		temp = "";
		c = new ArrayList<String>();
		
		for(int i = 0; i < s.length; i++) {
			for(int j = 0; j < s.length; j++) {
				temp = s[i]+s[j];
				c.addAll(validCheck(temp));
			}
		}
		
		return c;
	}
	
	private ArrayList<String> validCheck(String s) {	    
		Set<String> set = new HashSet<>();
        Set<Integer> hashes = new HashSet<>();
        c = new ArrayList<String>();
        
        for (int i = 0, rhash = 0; i < s.length(); i++) {
            if (i > 9) rhash -= A_SIZE_POW_9 * map.get(s.charAt(i-10));
            rhash = map.size() * rhash + map.get(s.charAt(i));
            if (i > 8 && !hashes.add(rhash)) c.add(s.substring(i-9,i+1));
        }
        return c;
	}
}