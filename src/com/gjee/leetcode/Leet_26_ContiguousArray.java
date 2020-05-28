package com.gjee.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leet_26_ContiguousArray {

	//best explined:https://youtu.be/9ZyLjjk536U
	/*hint1:The moving_one_zero variable is incremented by one for every 1 encountered 
	and the same is decremented by one for every 0 encountered.*/
	/*hint2: we need to keep moving_one_zero as key and current index as value to a map*/
	public static int findMaxLength(int[] nums) {
		Map<Integer,Integer> OneZeroMovingPositionAtIndex = new HashMap<>();
		int max_len  = 0;
		OneZeroMovingPositionAtIndex.put(0,-1); //important 
		int len = nums.length;
		int moving_one_zero =0;

		for(int pos=0;pos<len;pos++){
			if(nums[pos]==0){
				moving_one_zero --; 
			}
			else{
				moving_one_zero++;
			}
			
			if(OneZeroMovingPositionAtIndex.containsKey(moving_one_zero)){
				int between_sub_len = pos-OneZeroMovingPositionAtIndex.get(moving_one_zero);
				max_len = Math.max(max_len,between_sub_len);

			}else{
				OneZeroMovingPositionAtIndex.put(moving_one_zero,pos);
			}
		}

		return max_len;

	}


	public static void main(String[] args) {
		int[] arr = {0,0,1,0,0,0,1,1};
		System.out.println("expecting 6"+findMaxLength(arr));
		int [] arr1 = {0,1};
		System.out.println("expecting 2"+findMaxLength(arr1));
		
	}

}
/*
 * Continous array:
 * 
Given a binary array, find the maximum length of a contiguous subarray with equal
 number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.
*/
