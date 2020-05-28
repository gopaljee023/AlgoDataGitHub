package com.gjee.leetcode;

public class Leet_25_LCSIMP {

	//4 solution explained:https://leetcode.com/explore/featured/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3340/discuss/651002/JAVA-Summary-of-4-different-solutions-or-Longest-Common-Subsequence
	//TLE
	//Time Complexity : Exponential i.e. O(2 ^ n)
	int LCS(int i,int j,int[]A, int []B){
		if(i==A.length || j == B.length)
			return 0;
		if(A[i]==B[j]) {
			return 1+LCS(i+1,j+1,A,B);
		}
		return Math.max(LCS(i+1,j,A,B), LCS(i,j+1,A,B));
	}

	//passed: with tabular
	//Time Complexity : O(m * n)
	//Space Complexity : O(m * n)
	public  int LCS2(int[]A, int []B) {
		int[][] LCSMem = new int[A.length+1][];
		for(int i=0;i<A.length+1;i++) {
			LCSMem[i]= new int[B.length+1];
		}

		return LCSTabular(A,B,LCSMem) ;
	}

	public  int LCSTabular(int[]A, int []B,int[][] LCSMem) {

		for (int i= 0; i < A.length; i++) {

			for (int j = 0; j <  B.length; j++) {

				if(A[i] == B[j]) {
					LCSMem[i+1][j+1] = 1+ LCSMem[i][j];
				}
				else {
					LCSMem[i+1][j+1] = Math.max(LCSMem[i][j+1],LCSMem[i+1][j]);
				}

			}
		}

		return LCSMem[A.length][B.length];
	}


	public int maxUncrossedLines(int[] A, int[] B) {

		return LCS(0,0,A,B);
	}
	public static void main(String[] args) {

		Leet_25_LCSIMP o = new Leet_25_LCSIMP();
		int A6[]= {3,3}, B6[] = {1,3,1,2,1} ;
		System.out.println("expecting:1"+o.maxUncrossedLines(A6, B6));

		int A[]= {3}, B[] = {3,3,2} ;
		System.out.println("expecting:1"+o.maxUncrossedLines(A, B));

		int A2[]= {1,4,2}, B2[] = {1,2,4} ;
		System.out.println("expecting:2"+o.maxUncrossedLines(A2, B2));

		int A3[]= {2,5,1,2,5}, B3[] = {10,5,2,1,5,2} ;
		System.out.println("expecting:3"+o.maxUncrossedLines(A3, B3));


		int A4[]= {1,3,7,1,7,5}, B4[] = {1,9,2,5,1} ;
		System.out.println("expecting:2"+o.maxUncrossedLines(A4, B4));

		int A5[]= {1,2}, B5[] = {1,1} ;
		System.out.println("expecting:1"+o.maxUncrossedLines(A5, B5));
	}
}
/*
 *  Uncrossed Lines
We write the integers of A and B (in the order they are given) on two separate horizontal lines.

Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:

A[i] == B[j];
The line we draw does not intersect any other connecting (non-horizontal) line.
Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.

Return the maximum number of connecting lines we can draw in this way.

 

Example 1:


Input: A = [1,4,2], B = [1,2,4]
Output: 2
Explanation: We can draw 2 uncrossed lines as in the diagram.
We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line from A[2]=2 to B[1]=2.
Example 2:

Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
Output: 3
Example 3:

Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1]
Output: 2
 

Note:

1 <= A.length <= 500
1 <= B.length <= 500
1 <= A[i], B[i] <= 2000
 */

