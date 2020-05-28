package com.gjee.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//costruct binary tree from sorted array
public class Leet_24_BSTFromPreorderSelf {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	

	//A+B, +AB

	public TreeNode bstFromPreorder(int[] preorder) {
		
	 
	 List<Integer> list = new ArrayList<>();
	 for (int data : preorder) {
		list.add(data);
	}
	  
	 return bstFromPreorder(list);
		
	}
	
	//HERE COMPLEXITY IS O(n^2) .. google and we will get O(n)
	private TreeNode bstFromPreorder(List<Integer> list) {
		if(list.size()==0) return null;
		
		TreeNode node = new TreeNode(list.get(0));
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		for(int i=1;i<list.size();i++) {
			if(node.val>list.get(i)) {
				left.add(list.get(i));
			}
			else {
				right.add(list.get(i));
			}
		}
		
		node.left = bstFromPreorder(left);
		node.right = bstFromPreorder(right);
		
		return node;
	}

	public static void main(String[] args) {


		Leet_24_BSTFromPreorderSelf o = new Leet_24_BSTFromPreorderSelf();
		int ar[] = {8,5,1,7,10,12}; 
		TreeNode root = o.bstFromPreorder(ar);
		o.inorder(root);

	}
	private void inorder(TreeNode root) {
		if(root==null)
			return;
		inorder(root.left);
		System.out.println(root.val+" ");
		inorder(root.right);

	}

}
/*
Construct Binary Search Tree from Preorder Traversal
Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]



Constraints:

1 <= preorder.length <= 100
1 <= preorder[i] <= 10^8
The values of preorder are distinct.
 */