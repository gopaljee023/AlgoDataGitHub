package com.gjee.leetcode;

import java.util.ArrayList;
import java.util.*;

public class Leet_17_Anagrams {

	//https://www.youtube.com/watch?v=q9I5g0XyjEA : very good explination.. 
	//https://youtu.be/px9WEf0Lpjc :good code

	public void printAnagram(String s) {


	}

   Map<String,String> map =new HashMap<>();

	public String  sort(String test) {
		if(map.containsKey(test)) {
			return map.get(test);
		}
		char[] ar = test.toCharArray();
		Arrays.sort(ar);
		String sorted = String.valueOf(ar);
		map.put(test,sorted);
		return sorted;
	}

	public List<Integer> findAnagrams(String s, String p) {


		List<Integer> result = new ArrayList<>();
		int len = s.length();
		int plen= p.length();
		String p1 = sort(p);
		for(int i=0;i<=len-plen;i++) {
			String sub = s.substring(i,plen+i);
			if(anagram(sub,p1)) {
				result.add(i);
			}
		}
		return result;
	}
	private boolean anagram(String sub, String p) {

		return sort(sub).equals(p);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leet_17_Anagrams o = new Leet_17_Anagrams();
		System.out.println("[0,6]"+o.findAnagrams("cbaebabacd", "abc").toString());

		System.out.println("[0, 1, 2]"+o.findAnagrams("abab", "ab").toString());


	}

}


/*

Find All Anagrams in a String
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger 
than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 */