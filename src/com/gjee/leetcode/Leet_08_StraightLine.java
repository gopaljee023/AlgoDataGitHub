package com.gjee.leetcode;

public class Leet_08_StraightLine {

	 public boolean checkStraightLine(int[][] cd) {
	        int len = cd.length;
			 double m =0.0;
			 double c = 0.0;
			 boolean paraX = true;
			 boolean paraY = true;
			 if(cd.length==2) return true;
			 
			 for(int i=0;i<len-1;i++) {
				 int x1= cd[i][0],y1 = cd[i][1];
				 int x2 = cd[i+1][0],y2 = cd[i+1][1];
				 if(x1!=x2) {
					 paraX = false;
		            if(Math.abs(x2-x1)!=0) {
					 m = (y2-y1)/(x2-x1) ;
					 //y =mx+c;
					 c = y1 -m*x1;
		            }
				 }
				 if(y1!=y2) {
					 paraY = false;
				 }
			 }
			 
			 if(paraX == true || paraY == true)
				 return true;
			 
			 boolean inLine= true;
			 for(int i=0;i<len;i++) {
				 int x1 = cd[i][0];
				 int y1 = cd[i][1];
				 if(y1 != (int)m*x1+c) {
					 inLine = false;
					 break;
				 }
			 }
			 return inLine;
	    }
}
/*
 *  Check If It Is a Straight Line
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

 

 

Example 1:



Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:



Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
 

Constraints:

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.
*/
