package com.gjee.leetcode;

public class Leet_14_Trie {

	class Node{

		public Node[] link = new Node[26];
		public boolean word;
		public char ch;

	}
	class Trie {

	    	Node root ;
		/** Initialize your data structure here. */
		public Trie() {

			root = new Node();
			root.ch ='*';
		}

		/** Inserts a word into the trie. */
		public void insert(String word) {
		
			Node current = root;
			int len = word.length();
			for(int i=0;i<len;i++) {
				char ch =word.charAt(i);
				Node next = current.link[ch-'a'] ;
				if(next==null) {
					next = new Node();
					next.ch = ch;
					if(i==len-1) next.word = true;
					current.link[ch-'a'] = next;
				}
	            else{
					if(i==len-1) {
						next.word  = true;
					}
				}
	        
				current = next;
			}
		}

		/** Returns if the word is in the trie. */
		public boolean search(String word) {

			Node current = root;
			int len = word.length();
			for(int i=0;i<len;i++) {
			    char ch =word.charAt(i);
				Node next = current.link[ch-'a'] ;
				if(next ==null)
					return false;
				else
					current = next;
			}
			
			
			return current.word;
		}

		/** Returns if there is any word in the trie that starts with the given prefix. */
		public boolean startsWith(String word) {

			Node current = root;
			int len = word.length();
			for(int i=0;i<len;i++) {
			    char ch =word.charAt(i);
				Node next = current.link[ch-'a'] ;
				if(next ==null)
					return false;
				else
					current = next;
			}
			
			return true;
		}
	}
}

/*
 * 
 * Implement Trie (Prefix Tree)
Solution
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
*/
