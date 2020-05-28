package com.gjee.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet_22_BalancedBSTInorderIMP {
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
	 public TreeNode balanceBST(TreeNode root) {
		  List<Integer> list =new ArrayList<>();
		  inorder(root,list);
		  return balanceBST(list,0,list.size()-1);
	  }
   private void inorder(TreeNode root, List<Integer> list) {
		
		if(root!=null) {
			inorder(root.left,list);
			list.add(root.val);
			inorder(root.right,list);
		}
		
	}
	private TreeNode balanceBST(List<Integer> list, int start, int end) {
	
		TreeNode root = null;
		if(start<=end) {
			int mid = start+ (end-start)/2;
			root = new TreeNode(list.get(mid));
			root.left  = balanceBST(list,start,mid-1);
			root.right = balanceBST(list,mid+1,end);
		}
		return root;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
