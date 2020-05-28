package com.gjee.leetcode;

import java.util.Arrays;

public class Leet_06_MajorityEle {

	public int majorityElement(int[] nums) {
		int len = nums.length;
		Arrays.sort(nums);
		//2 3 3
		//2 2 3
		int result = nums[0];
		int count =1;
		int t_c =1 ;
		int prev = result;


		for(int i=1;i<len;i++) {
			if(prev == nums[i])
				t_c++;
			else{
				t_c =1;
			}
			prev =  nums[i];
			if(t_c>=count) {
				count = t_c;
				result = nums[i];
				if(t_c>len/2) break;
			}
		}

		return result ;
	}
}
