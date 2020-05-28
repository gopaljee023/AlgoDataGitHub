package com.gjee;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementUnsortedArray {

	public int findKthLargest(int[] nums, int k) {
	    int n= nums.length;
	    //Collections.reverseOrder()
	   // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
			pq.add(nums[i]);
		}
        for(int j=k;j<n;j++) {
        	int peek  = pq.peek(); //jo nikalane walla hota hai wahi peek hai
        	if(peek<nums[j]) {
        		pq.remove(); //root will be deleted
        		pq.add(nums[j]);
        	}
        }
		return pq.remove();
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthLargestElementUnsortedArray o = new KthLargestElementUnsortedArray();
//		int[] nums = {3,2,1,5,6,4};
//		int k = 2;
//		System.out.println("output should be 5:"+o.findKthLargest(nums, k));

		int[] nums = {3,2,3,1,2,4,5,5,6};
		int k = 4;
		System.out.println("output should be 4:"+o.findKthLargest(nums, k));
	}

}

/*

ind the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
