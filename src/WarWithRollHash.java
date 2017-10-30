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
	private ArrayList<String> c;
	private String temp;
	private final static int NUM_LETTERS_ALPHABET = 26;
	
	/**
	 * creates an object that stores an input string-array (into a Rolling Hash) of DNA sequences for later computation
	 * @param	s	The set of substrings (length k) of the DNA sequence
	 * @param	k	The length of substrings (in s) of the DNA sequence
	 */
	public WarWithRollHash(String[] s, int k)
	{
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
		temp = "";
		c = new ArrayList<String>();
		
		for(int i = 0; i < s.length; i++) {
			for(int j = 0; j < s.length; j++) {
				temp = s[i]+s[j];
				if(validCheck(temp)) {
					c.add(temp);
				}
			}
		}
		
		return c;
	}
	
	private boolean validCheck(String t) {
		return false;
	}
	
	private boolean search(String pattern, String text, int primeNum) {
		int i, j;
		int p = 0;	// Hash value for pattern
		int t = 0;	// Hash value for text
		int h = 1;
		
		for (i = 0; i < pattern.length()-1; i++) {
			h = (h*NUM_LETTERS_ALPHABET) % primeNum;
		}
		
		for(i = 0; i < pattern.length(); i++) {
			p = (p*NUM_LETTERS_ALPHABET + pattern.charAt(i)) % primeNum;
			t = (t*NUM_LETTERS_ALPHABET + text.charAt(i)) % primeNum;
		}
		
		for(i = 0; i <= (text.length()-pattern.length()); i++) {
			if(p == t) {
				for(j = 0; j < pattern.length(); j++) {
					if(text.charAt(i+j) != pattern.charAt(j))	break;
				}
				
				if(j == pattern.length())	System.out.println("Pattern found at index " + i);
			}
		}
		
		return false;
	}
}