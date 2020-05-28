package com.gjee.leetcode;

import java.util.*;

//Longest sum contiguous subarray : Kandan is used for this
public class Leet_15_KandanCircularIMP {

	//brute force: I tried 
	public int maxSubarraySumCircular1(int[] A) {
		int sum = A[0];
		int len = A.length;
		for(int i=0;i<len;i++) {

			int temp = 0;
			for(int j=i;j<len+i;j++) {

				int k = j%len;

				temp += A[k];
				if(temp>sum) {
					sum = temp;
				}
			}
		}
		return sum;
	}

	//someelse code
	public static int maxSubarraySumCircular2(int[] A) {
	    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	    int sum1 = 0, sum2 = 0, total = 0;
	    for(int x : A) {
	        if(sum1<0){
	            sum1 = 0;
	        }
	        sum1 += x;
	        max = Math.max(max, sum1);
	        if(sum2>0){
	            sum2 = 0;
	        }
	        sum2 += x;
	        min = Math.min(min, sum2);
	        total += x;
	    }
	    return max > 0 ? Math.max(max, total - min) : max;
	  }
	
	//someeles' code
	public int maxSubarraySumCircular3(int[] A) {
        int total = 0, maxSum = Integer.MIN_VALUE, curMax = 0, minSum = Integer.MAX_VALUE, curMin = 0;
        for (int a : A) {
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
            total += a;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
	
	
	public int maxSubarraySumCircular(int[] A) {
		int total_sum =0;
		int max_ending_at = 0;
		int min_ending_at =0;
		int globalMax= Integer.MIN_VALUE;
		int globalMin = Integer.MAX_VALUE;
		
		for(int d : A) {
			total_sum += d;
			max_ending_at = Math.max(max_ending_at+d,d);
			globalMax = Math.max(max_ending_at,globalMax);
			
			min_ending_at = Math.min(min_ending_at+d,d);
			globalMin = Math.min(min_ending_at,globalMin);
		}
		
		if(globalMax>0) {
			return Math.max(globalMax, total_sum-globalMin);
			
		}
		else {
			return globalMax;
		}
		
	
	}
	
	public static void main(String[] args) {
		Leet_15_KandanCircularIMP o = new Leet_15_KandanCircularIMP();

		int [] arr_2 = {0,5,8,-9,9,-7,3,-2};
		System.out.println("0,5,8,-9,9,-7,3,-2}: 16 result->"+o.maxSubarraySumCircular(arr_2));
		int [] arr_ = {9,-4,-7,9};
		System.out.println("{9,-4,-7,9}}: 18 result->"+o.maxSubarraySumCircular(arr_));
		int[]arr2 = {3,-1,2};
		System.out.println("{3,-1,2}: 5 result->"+o.maxSubarraySumCircular(arr2));
			int[]arr0 = {1,-2,3,-2};
			System.out.println("{1,-2,3,-2}: 3 result->"+o.maxSubarraySumCircular(arr0));
		int arr[] = {1,2,3};
		System.out.println("{1,2,3}: 6 result->"+o.maxSubarraySumCircular(arr));

		int[]arr1 = {-1,-2,-3};
		System.out.println("{-1,-2,-3}: -1 result->"+o.maxSubarraySumCircular(arr1));



		

		int[]arr3 = {-1,2,4};
		System.out.println("{-1,2,4}: 6 result->"+o.maxSubarraySumCircular(arr3));

	}

}
