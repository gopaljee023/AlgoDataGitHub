package com.gjee.algo.rough;

import java.util.Arrays;
import java.util.LinkedList;

public class NextIntegerElement2_leetCode503 {

	//from others good good
	public int[] nextGreaterElements1(int[] A) {
	    int n = A.length, res[] = new int[n];
	    Arrays.fill(res, -1);
	    LinkedList<Integer> stack = new LinkedList<>();
	    for (int i = 0; i < n * 2; i++) {
	        while (!stack.isEmpty() && A[stack.peek()] < A[i % n]) {
	            res[stack.pop()] = A[i % n];
	        }
	        stack.push(i % n);
	    }
	    return res;
	}
	
	public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int [] result = new int[len];
        Arrays.fill(result,-1);
      
        for(int i=0;i<len;i++){
            int j = (i+1)%len;
            while(j!=i){
                if(nums[j]>nums[i]){
                    result[i]= nums[j];
                    break;
                }
                j = (j+1)%len;
            }
        }
       
        return result;
       
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
 * 
 * 
 *  Next Greater Element II
Medium

1280

66

Add to List

Share
Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

Example 1:
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number; 
The second 1's next greater number needs to search circularly, which is also 2.
*/
