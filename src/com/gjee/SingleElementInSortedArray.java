package com.gjee;

public class SingleElementInSortedArray {

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
	public static void main(String[] args) {
		SingleElementInSortedArray o = new SingleElementInSortedArray();
		// TODO Auto-generated method stub
		int[] arr = {1,1,2,3,3,4,4,8,8};
	  System.out.println(o.singleNonDuplicate(arr));

//		int []arr = {3,3,7,7,10,11,11};
//		System.out.println(o.singleNonDuplicate(arr));
		
//		int[] arr = {2,2,3,3,4};
//		System.out.println(o.singleNonDuplicate(arr));
//		int[] arr = {2};
//		System.out.println(o.singleNonDuplicate(arr));
}

}
/*
 * 
 *  Single Element in a Sorted Array
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.



Example 1:

Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: [3,3,7,7,10,11,11]
Output: 10


Note: Your solution should run in O(log n) time and O(1) space.

 */
