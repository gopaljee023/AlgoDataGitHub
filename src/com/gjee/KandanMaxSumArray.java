package com.gjee;

import com.gjee.leetcode.Leet_15_KandanCircularIMP;

public class KandanMaxSumArray {

	//someone' else
	public int kadane(int[] array) {
        int maxTillI = array[0];
        int max = array[0];
        for(int i = 1; i < array.length; i++) {
            maxTillI = Math.max(maxTillI+array[i], array[i]);
            max = Math.max(max, maxTillI);
        }
        return max;
    }
	
	//kandan's alg
	public int maxSubarraySumCircular(int[] A) {
		int split_sum =0;
		int sum_so_far = A[0];
		for (int i = 0; i < A.length; i++) {

			split_sum += A[i];
			if(split_sum>sum_so_far) {
				sum_so_far = split_sum;
			}

			if(split_sum<0) {
				split_sum = 0;
			}
		}

		return sum_so_far;
	}
	
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
		
		public static void main(String[] args) {
			KandanMaxSumArray o = new KandanMaxSumArray();

			//		int[]arr0 = {1,-2,3,-2};
			//		System.out.println("{1,-2,3,-2}: 3 result->"+o.maxSubarraySumCircular(arr0));
			int arr[] = {1,2,3};
			System.out.println("{1,2,3}: 6 result->"+o.maxSubarraySumCircular(arr));

			int[]arr1 = {-1,-2,-3};
			System.out.println("{-1,-2,-3}: -1 result->"+o.maxSubarraySumCircular(arr1));



			int[]arr2 = {3,-1,2};
			System.out.println("{3,-1,2}: 4 result->"+o.maxSubarraySumCircular(arr2));


			int[]arr3 = {-1,2,4};
			System.out.println("{-1,2,4}: 6 result->"+o.maxSubarraySumCircular(arr3));

		}

}
