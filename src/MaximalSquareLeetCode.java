

import java.io.IOException;

/*problem description: down*/
public class MaximalSquareLeetCode {

	/*
	1 0 1 0 0
	1 0 1 1 1
	1 1 1 1 1
	1 0 0 1 0

	 */
	
	/* i wrote it without any help */
	public static  int maximalSquareJee(char[][] matrix) {
		int max_c_r = 0;
		int c_r=0;


		for(int i=0;i<matrix.length;i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] =='1') {
					c_r=1;
					
					while(true) {
					
						if(c_r+i == matrix.length) break;
						if(c_r+j ==  matrix[i].length) break;
					  boolean have = true;
						for(int k1=0;k1<=c_r;k1++) {
							boolean oneDm = true;
						    for(int k2=0;k2<=c_r;k2++) {
								
								if(matrix[i+k1][j+k2] == '0') {
									oneDm = false;
									break;
								}
							}
							if(oneDm==false) {
							    have = false;
								break;
							}
						}
						if(have == true) c_r++;
						else break;
							
					}
				}
				if(c_r>max_c_r) {
					max_c_r = c_r;
				}
			}
		}
		return max_c_r*max_c_r;

	}


	public static void main(String[] args) throws NumberFormatException, IOException {
		InputReader input = new InputReader();
		int row = input.rdInt();
		int col = input.rdInt();;
		int[][] _2dArr = input.rd2DIntArray(row, col);
		char[][] matrix = new char[row][col];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				
				 matrix[i][j] = Character.forDigit(_2dArr[i][j],10);    
			}
		}

		System.out.println(maximalSquareErrichto(matrix));


	}
	
	//DP problem solved with tabular method
	static int  min(int a,int b, int c) {
		return min(min(a,b),c);
	}
	static int min(int a,int b) {
		return a>b?b:a;
	}
	static int max(int a, int b) {
		return a>b?a:b;
	}
	public static  int  maximalSquareErrichto(char[][] matrix) {
		int H = matrix.length;
		if(H==0 || (matrix[0].length == 0)) {
			return 0;
		}
		int W = matrix[0].length;
		int[][] dp = new int[H+1][W+1];
		
		int answer = 0;
		for (int i = 1; i <=H; i++) {
			for (int j = 1; j <= W; j++) {
				if(matrix[i-1][j-1] == '1') {
					dp[i][j] = 1;
					
					dp[i][j] += min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]);
				}
				
				answer = max(answer, dp[i][j]);
			}
			
		}
		
		
		
		return answer*answer;
	}
	

}


/*

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
 */