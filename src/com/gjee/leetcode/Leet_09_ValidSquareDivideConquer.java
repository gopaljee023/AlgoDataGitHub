package com.gjee.leetcode;

public class Leet_09_ValidSquareDivideConquer {

	public boolean isPerfectSquare(int num) {
        if(num < 2) return true;
        
        long si = 2, ei = num / 2;
        while(si <= ei){
            long mid = (si + (ei - si) / 2);
            long guessedNo = mid * mid;
            if(guessedNo == num){
                return true;
            }
            else if(guessedNo < num){
                si = mid + 1;
            }
            else{
                ei = mid - 1;
            }
        }
        return false;
    }
}
/*
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.

Follow up: Do not use any built-in library function such as sqrt.

 

Example 1:

Input: num = 16
Output: true
Example 2:

Input: num = 14
Output: false
 

Constraints:

1 <= num <= 2^31 - 1

*/
