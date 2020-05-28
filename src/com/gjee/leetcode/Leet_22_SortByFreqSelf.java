package com.gjee.leetcode;

public class Leet_22_SortByFreqSelf {

	class Node{
		public char ch;
		public int freq;
	}
	public String frequencySort(String s) {
		Node[] nodes =new Node[256];
		for(int i=0;i<256;i++) {
			nodes[i]= new Node();
		}
		
         for(char ch :s.toCharArray()) {
        	
        	 nodes[ch].ch= ch;
        	 nodes[ch].freq++; 
        	}
         divideAndConquer(nodes,0,255);
         StringBuilder build = new StringBuilder();
         for(int i=255;i>=0;i--) {
        	 while(nodes[i]!=null && nodes[i].freq>0) {
        		 build.append(nodes[i].ch);
        		 nodes[i].freq--;
        	 }
         }
         return build.toString();
	}

	private void divideAndConquer(Node[] nodes, int start, int end) {
		
		if(start<end) {
			int mid = start + (end-start)/2;
			divideAndConquer(nodes,start,mid);
			divideAndConquer(nodes,mid+1,end);
			merge(nodes,start,mid,end);
		}
		
	}

	private void merge(Node[] nodes, int start, int mid, int end) {
	   
		int l_s = start,l_e = mid, s_s = mid+1, s_e = end;
		int size = end-start+1;
		Node[] temp = new Node[size];
		for(int i=0;i<size;i++) {
			temp[i]= new Node();
		}
		int  i=0;
		while(l_s<=l_e && s_s<=s_e) {
			
			if(nodes[l_s].freq<nodes[s_s].freq) {
				temp[i++]= nodes[l_s++];
			}
			else {
				temp[i++]= nodes[s_s++];
			}
			
		}
		while(l_s<=l_e) {
			temp[i++] = nodes[l_s++];

		}
		while(s_s<=s_e) {
			temp[i++] = nodes[s_s++];
		}
		
		for(Node t:temp) {
			nodes[start++]= t;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leet_22_SortByFreqSelf o =new Leet_22_SortByFreqSelf();
		System.out.println("expecting:eeTr ->"+o.frequencySort("Tree"));
		
		System.out.println("expecting:aaaccc/cccaaa-> "+o.frequencySort("cccaaa"));
		
		System.out.println("expecting:bbAa/bbaA->"+o.frequencySort("Aabb"));

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
