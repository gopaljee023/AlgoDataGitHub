package com.gjee.leetcode;

import java.util.*;

public class Leet_22_SortByFreq {

	public static void main(String[] args) {
		Leet_22_SortByFreq o =new Leet_22_SortByFreq();
		System.out.println("expecting:eeTr ->"+o.frequencySort("Tree"));
		
		System.out.println("expecting:aaaccc/cccaaa-> "+o.frequencySort("cccaaa"));
		
		System.out.println("expecting:bbAa/bbaA->"+o.frequencySort("Aabb"));


	}
	
	//2ms :didn't understand
	public String frequencySort1(String s) {
		if(s.isEmpty() || s.length()==0)
            return s;
        int[] map = new int[128];
        char[] cA = s.toCharArray();
        
        for(char c:cA)
            map[c]++;
        
        char[] result = new char[s.length()];
        for(int i=0;i<s.length();){
            int max = 0;
            int index = 0;
            for(int j = 0;j<128;j++){
                if(map[j]>max){
                    max = map[j];
                    index = j;
                }
            }
            while(map[index]>0){
                result[i++] = (char)index;
                map[index]--;
            }
        }
        return new String(result);
	}

	 public String frequencySort(String s) {
	        Map<Character, Integer> map = new HashMap<>();
	        for (char c : s.toCharArray()) 
	            map.put(c, map.getOrDefault(c, 0) + 1);
							
	        List<Character> [] bucket = new List[s.length() + 1];
	        //why? array of List<>:if a and b both have equal number
	        //of freq (e.g 8_ .. bucket[8].list(a)->list(b)
	        for (char key : map.keySet()) {
	            int frequency = map.get(key);
	            if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
	            bucket[frequency].add(key);
	        }
					
	        StringBuilder sb = new StringBuilder();
	        for (int pos = bucket.length - 1; pos >= 0; pos--)
	            if (bucket[pos] != null)
	                for (char c : bucket[pos])
	                    for (int i = 0; i < map.get(c); i++)
	                        sb.append(c);

	        return sb.toString();
	    }

}

/*
 * 
 * Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

 */
