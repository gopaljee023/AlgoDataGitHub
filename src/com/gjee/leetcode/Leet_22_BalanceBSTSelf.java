package com.gjee.leetcode;

public class Leet_22_BalanceBSTSelf {

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
	class TreeNode {
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
	public int height(TreeNode node){
		if(node==null)
		{
			return 0;

		}
		return 1+Math.max(height(node.left),height(node.right));
	}
	//timelimit
	public TreeNode balanceBST(TreeNode root) {
		if(root==null)
			return root;
		while(true){
			int lh = height(root.left);
			int rh = height(root.right);
			if(Math.abs(lh-rh)<=1)
				return root;

			if(lh>rh){
				TreeNode temp =root;
				root = root.left;
				temp.left = root.right;
				root.right = temp;
			}
			else{
				TreeNode temp =root;
				root = root.right;
				temp.right = root.left;
				root.left = temp;
			}
		}
	}
	public static void main(String[] args) {

	}



}
/*
Given a binary search tree, return a balanced binary search tree with
 the same node values.

A binary search tree is balanced if and only if the depth of the two 
subtrees of every node never differ by more than 1.

If there is more than one answer, return any of them.

Input: root = [1,null,2,null,3,null,4,null,null]
Output: [2,1,3,null,null,null,4]
Explanation: This is not the only correct answer, [3,1,4,null,2,null,null] is also correct.
 */