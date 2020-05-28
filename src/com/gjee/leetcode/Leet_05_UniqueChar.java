package com.gjee.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leet_05_UniqueChar {

	public int firstUniqChar(String s) {
		;int index = -1;
		Map<Character,Integer> map = new HashMap<>();

		int len= s.length();
		for(int i=len-1;i>=0;i--) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0)+1);
		}

		for(int i=0;i<len;i++) {
			char c = s.charAt(i);
			if(map.containsKey(c) ) {
				if(map.get(c)==1)
					return i;
			}
		}
		return index;
	}
}
/*
 * First Unique Character in a String
Solution
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

 */
