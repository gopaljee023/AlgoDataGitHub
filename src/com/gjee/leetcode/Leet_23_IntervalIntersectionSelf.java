package com.gjee.leetcode;

public class Leet_23_IntervalIntersectionSelf {

	// i missed : if two intervals are disjoint.
	public int[][] intervalIntersection(int[][] A, int[][] B) {
        int len1 = A.length, len2 = B.length, total = 0;
    
       int[][] result = new int[len1+len2][];
        for(int i=0;i<len1+len2;i++){
            result[i]= new int[2];
        }
    
        int ai = 0, bi=0;
        
        //[13,23]
        //[8,12]
        
        /*
        [[0,2],[5,10],[13,23],[24,25]]
[[1,5],[8,12],[15,24],[25,26]]

:[[1,2],[5,5],[8,10],[13,12],[15,23],[24,24],[25,25]]
[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
*/
        while(ai!=len1 && bi!=len2){
            
            if(A[ai][0]>B[bi][1]){
                bi++;
                continue;
            }
           if(B[bi][0]>A[ai][1]){
                ai++;
                continue;
            }
            int l = Math.max(A[ai][0], B[bi][0]);
            int h = Math.min(A[ai][1], B[bi][1]);
            
            result[total][0]=l;
            result[total][1]=h;
            
            if(h == A[ai][1])
                ai++;
            else
                bi++;
            
            total++;
        }
        
        int[][] fresult = new int[total][];
         for(int i=0;i<total;i++){
            fresult[i]= new int[2];
            fresult[i][0]= result[i][0];
              fresult[i][1]= result[i][1];
        }
        
        return fresult;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/*
 * Interval List Intersections
Given two lists of closed intervals, each list of intervals is 
pairwise disjoint 
and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real 
numbers x with a <= x <= b.  The intersection of two closed intervals is a 
set of real numbers that is either empty, or can be represented as a closed 
interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

 

Example 1:



Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 

Note:

0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9

*/
