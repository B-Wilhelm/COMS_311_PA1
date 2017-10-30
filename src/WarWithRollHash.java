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
				if(validCheck(temp))
					c.add(temp);
			}
		}
		
		return c;
	}
	
	private boolean validCheck(String text) {
		
		String pattern;
		int i, j;
		int patternCount = 0;
		int primeNum;
		int p;	// Hash value for pattern
		int t;	// Hash value for text
		int h;
		
		if(text.length() < 1) {
			return false;
		}
		
		for(int l = 0; l < s.length; l++) {
			pattern = s[l];
			primeNum = 101;
			p = 0;
			t = 0;
			h = 1;
			
			for (i = 0; i < pattern.length()-1; i++)
				h = (h*NUM_LETTERS_ALPHABET) % primeNum;
			
			for(i = 0; i < pattern.length(); i++) {
				p = (p*NUM_LETTERS_ALPHABET + pattern.charAt(i)) % primeNum;
				t = (t*NUM_LETTERS_ALPHABET + text.charAt(i)) % primeNum;
			}
			
			for(i = 0; i <= (text.length()-pattern.length()); i++) {
				if(p == t) {
					for(j = 0; j < pattern.length(); j++) {
						if(text.charAt(i+j) != pattern.charAt(j))
							break;
					}
					
					if(j == pattern.length()) {
						patternCount++;
					}
				}
				
				if(i < (text.length()-pattern.length())) {
					t = (NUM_LETTERS_ALPHABET*(t - text.charAt(i)*h) + text.charAt(i + pattern.length())) % primeNum;
					if(t < 0)
						t += primeNum;
				}
			}
		}
		return (patternCount == k+1);
	}
}