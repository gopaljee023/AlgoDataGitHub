package com.gjee.leetcode;

public class Leet_00_CountSquaresIMP {

	public int min(int a, int b, int c){
		return Math.min(c,Math.min(a,b));
	}
	//My solution1
	public int countSquares(int[][] matrix) {
		int H = matrix.length;
		int W = matrix[0].length;
		int[][] dp = new int[H+1][W+1];
		int count =0;
		for(int i=1;i<=H;i++){

			for(int j=1;j<=W;j++){
				if(matrix[i-1][j-1] == 1) {
					dp[i][j] = 1;
					dp[i][j] += min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]);
					
				}
			}
		}
		
		for(int i=H;i>=1;i--) {
			for(int j=W;j>=1;j--) {
				System.out.print(dp[i][j]+ " ");
				count += dp[i][j];
			}
		}
         return count;
	}
	
	//My solution with little bit tweaking
	public int countSquares2(int[][] matrix) {
		int H = matrix.length;
		int W = matrix[0].length;
		int[][] dp = new int[H+1][W+1];
		int count =0;
		for(int i=1;i<=H;i++){

			for(int j=1;j<=W;j++){
				if(matrix[i-1][j-1] == 1) {
					dp[i][j] = 1;
					dp[i][j] += min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]);
					count+=dp[i][j];
				}
			}
		}
		/*
		 * not required:in previous loop,only we can calculate
		for(int i=H;i>=1;i--) {
			for(int j=W;j>=1;j--) {
				System.out.print(dp[i][j]+ " ");
				count += dp[i][j];
			}
		}*/
         return count;
	}
}


/*

Count Square Submatrices with All Ones
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.



Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:

Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.


Constraints:

1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1
 */