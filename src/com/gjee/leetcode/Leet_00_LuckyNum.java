package com.gjee.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet_00_LuckyNum {

	boolean amLucky(int[][] matrix,int row,int col) {

		int R = matrix[0].length;
		int max =matrix[row][col];
		for(int i=0;i<R;i++) {
			if(max<matrix[i][col])
				return false;
		}
		return true;
	}
	public List<Integer> luckyNumbers (int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		int H = matrix.length;
		int W  = matrix[0].length;
		for(int i=0;i<H;i++) {
			int min = matrix[i][0];
			int col = 0;
			for(int j=0;j<W;j++) {
				if(min>matrix[i][j]) {
					min = matrix[i][j];
					col=j;
				}
			}
			//out of row..
			if(amLucky(matrix,i,col)) {
				list.add(min);
			}
			
		}
			
		return list;
      }
	
	//arr[] = max with i and j
	 //arr

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and
 maximum in its column.



Example 1:

Input: matrix = 
      [[3,7,8],
      [9,11,13],
      [15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column
Example 2:

Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 3:

Input: matrix = [[7,8],[1,2]]
Output: [7]


Constraints:

m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 10^5.
All elements in the matrix are distinct.
 */