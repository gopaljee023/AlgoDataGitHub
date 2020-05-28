package com.gjee.leetcode;

//Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
public class Leet_20_KthElementBST {

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

	int result ;
	boolean isSet = false;
	public int kthSmallest(TreeNode root, int k) {
		inline(root,k);
		return result;
	}

	public  int inline(TreeNode root,int k){
		if(root==null)
			return k ;
		if(isSet) return k;
		k = inline(root.left,k);
		k--;
		if(!isSet){
			if(k==0){
				result = root.val;
				isSet = true;
			}
		}
		k = inline(root.right,k);
		return k;
	}
}
