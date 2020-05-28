package com.gjee.leetcode;

import com.gjee.leetcode.Leet_24_BSTFromPreorderSelf.TreeNode;

public class Leet_24_BSTFromPreOrderOthers {
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

	
	
	private TreeNode insert(TreeNode root, int val) {
		
		if(root == null) return new TreeNode(val);
		else if(root.val > val) root.left = insert(root.left, val);
		else root.right = insert(root.right, val);
		return root;
	}

	//here also it is O(n^2)
	public TreeNode bstFromPreorder(int[] preorder) { 
		
		TreeNode root = null;
		for(int val : preorder) 
			root = insert(root, val);
		return root;
	}

	public static void main(String[] args) {


		Leet_24_BSTFromPreOrderOthers o = new Leet_24_BSTFromPreOrderOthers();
		int ar[] = {1,2,3,4}; 
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
