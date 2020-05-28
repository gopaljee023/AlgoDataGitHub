package com.gjee.leetcode;

public class Leet_12_BST {

	public int singleNonDuplicate(int[] nums) {
	     
		return binary(nums,0,nums.length-1);
	}
	private int binary(int[] nums, int start, int end) {
		if(start >end) return -1;
		if(start == end) return nums[start];
		
		int mid = start + (end-start)/2;
		int result =nums[mid];
		if(nums[mid] == nums[mid+1]) //can't be even number of elements
		{
			result = binary(nums,start,mid-1);
			if(result ==-1) {
				result =binary(nums,mid+2,end);
			}
		}
		else if(nums[mid] == nums[mid-1]) {
			result = binary(nums,start,mid-2);
			if(result==-1) {
				result =binary(nums,mid+1,end);
			}
		}
		return result;
	}
	
}

/*

Single Element in a Sorted Array
Solution
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

Follow up: Your solution should run in O(log n) time and O(1) space.

 

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10
 

Constraints:

1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5
*/