package com.gjee.leetcode;

public class Leet_07_BinaryCousins {

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
	public boolean isCousins(TreeNode root, int x, int y) {
		// System.out.println(depth(root,x,0));
		// System.out.println(depth(root,y,0));
		int  a = depth(root,x,0);
		int b = depth(root,y,0);
		if(a!=b)
			return false;
		TreeNode r = findRoot(root,x,null);
		if(r.left!=null && r.left.val == y) return false;
		if(r.right!=null && r.right.val == y) return false;
		return true;

	}

	TreeNode findRoot(TreeNode root,int x,TreeNode parent){
		if(root==null) return null;
		if(root.val == x) return parent;
		TreeNode temp = findRoot(root.left,x,root);
		if(temp==null){
			temp = findRoot(root.right,x,root); 
		}
		return temp;
	}

	int depth(TreeNode root,int data,int dpth){
		if(root== null) return -1;

		if(root.val == data){
			return dpth;
		}
		int k  = depth(root.left,data,dpth+1) ;
		if(k==-1){
			k = depth(root.right,data,dpth+1) ;
		}

		return k;
	}
}
/*
 * 
 * Cousins in Binary Tree
Solution
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Constraints:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.
*/
