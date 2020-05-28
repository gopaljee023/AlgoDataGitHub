package com.gjee.leetcode;

public class Leet_03_Ransom {

	public boolean canConstruct(String ransomNote, String magazine) {
		int[] data = new int[26];
		int RL = ransomNote.length() ;
        int ML = magazine.length();
		
        
        
		for (int i = 0; i < ML; i++) {
			data[magazine.charAt(i)-'a']++;
		}
		boolean result = true;
		
		for (int i = 0; i < RL; i++) {
			if(data[ransomNote.charAt(i)-'a'] !=0) {
				data[ransomNote.charAt(i)-'a'] --;
				
			}
            else {
            	result = false;
				break;
			}
		}
		
		return result;
	}
}

/*

Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

 

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 

Constraints:

You may assume that both strings contain only lowercase letters.
*/