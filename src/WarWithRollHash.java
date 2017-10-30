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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class WarWithRollHash
{
	private String[] s;
	private int k;
	private ArrayList<String> c;
	private String temp;
	
	/**
	 * creates an object that stores an input string-array (into a Rolling Hash) of DNA sequences for later computation
	 * @param	s	The set of substrings (length k) of the DNA sequence
	 * @param	k	The length of substrings (in s) of the DNA sequence
	 */
	public WarWithRollHash(String[] s, int k) {
		this.s = s;
		this.k = k;
	}
	
	/**
	 * Computes DNA sequences with length 2*k
	 * @return		The ArrayList of all substrings of the DNA sequence with length 2*k
	 */
	public ArrayList<String> compute2k() {
		
	}
	
	private boolean validCheck(String P, String T, int q) {
		int m = P.length();
		int n = T.length();
		int p = 0; // hash of pattern P
		int t = 0; // hash of text T
		int h = (d ^ (m-1)) % q;

		// preprocessing: hashing P[1..m] and T[1..m] (first window of T)
		for (int i = 1; i < m; i++) {
		    p = (d * p + P[i]) % q; //(1)
		    t = (d * t + T[i]) % q;
		}

		// matching
		for (int j = 0; j < n-m; j++) {
		    if(p == t) {
		        if(P[1..m] == T[j+1..j+m]
		            System.out.println("matched");
		    }
		    // update the rolling hash
		    if(j < n-m)
		        t = (d * (t - T[j+1] * h) + T[j+m+1]) % q;
		}
	}