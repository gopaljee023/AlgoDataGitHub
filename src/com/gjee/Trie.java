package com.gjee;

class Node{

	public Node[] link = new Node[26];
	public boolean word;
	public char ch;

}

public class Trie {

	Node root ;
	/** Initialize your data structure here. */
	//will go into init
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie obj = new Trie();
	
		//obj.insert("abc");
//		System.out.println("should return false"+obj.search("a"));
//		System.out.println("should return true:"+obj.search("abc"));
//		System.out.println("startsWith:should return true:"+obj.startsWith("a"));
//		System.out.println("startsWith:should return true:"+obj.startsWith("abc"));
//		System.out.println("startsWith:should return false:"+obj.startsWith("abcd"));
//		System.out.println("startsWith:should return false:"+obj.startsWith("abcd"));
		
		obj.insert("apple");
		System.out.println("startsWith:should return true:"+obj.search("apple"));
		obj.insert("app");
		System.out.println("startsWith:should return true:"+obj.search("app"));
	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
