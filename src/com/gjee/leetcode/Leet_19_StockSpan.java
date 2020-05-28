package com.gjee.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Stream;

/*very good solution:
https://leetcode.com/problems/online-stock-span/discuss/640358/JAVA-Solution-With-visualization-and-easy-explained!

*/
public class Leet_19_StockSpan {

	static class Solutoin1TLE {
		Deque<Integer> stack = new ArrayDeque<>();

		//TLE
		public int next(int price) {

			Deque<Integer> temp = new ArrayDeque<>();
			temp.push(price);
			int count =0;
			while(!stack.isEmpty()){
				if(stack.peek()<=price){
					temp.push(stack.pop());
				}
				else {
					break;
				}

			}

			for(Integer v:temp){
				stack.push(v);
				count++;
			}
			return count;
		}
	}


	static class Solutoin2Working{
		public Solutoin2Working() {

		}
		int[] testInput = new int[10000];
		int len =0 ;
		public int next(int price) {

			testInput[len++] = price;
			int count =0;

			for(int i=len-1;i>=0;i--) {
				if(testInput[i]<=price) {
					count++;
				}
				else {
					break;
				}
			}
			return count;
		}
	}
	
	//not finished yet
	static class Solutoin3{
		
	
		 
		
		final int LIMIT = 10000;
		int len =0;
		int[] data = new int[LIMIT];
		int[] span = new int[LIMIT];
		
		public Solutoin3() {
			
		}
		
		public int next(int price) {

			data[len]= price;
			span[len]=1;
			len++;
			
		   int count =0;
		   
		   //100 70 80 90  50 40 60  70  40  100
		   
		   //1   1  2  3   1  1  3    4   1
		   for(int i=len-1;i>=0;i--) {
				
			}
			
			return count;
		}
	}



	public static void main(String[] args) {

		
		Leet_19_StockSpan.Solutoin1TLE o = new Leet_19_StockSpan.Solutoin1TLE();
		System.out.println(o.next(100));
		System.out.println(o.next(80));
		System.out.println(o.next(60));
		System.out.println(o.next(70));
		System.out.println(o.next(60));
		System.out.println(o.next(75));
		System.out.println(o.next(85));
	

	}

}

/*
 * 
 * 
 * Online Stock Span
Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.

The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.

For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].



Example 1:

Input: ["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
Output: [null,1,1,1,2,1,4,6]
Explanation: 
First, S = StockSpanner() is initialized.  Then:
S.next(100) is called and returns 1,
S.next(80) is called and returns 1,
S.next(60) is called and returns 1,
S.next(70) is called and returns 2,
S.next(60) is called and returns 1,
S.next(75) is called and returns 4,
S.next(85) is called and returns 6.

Note that (for example) S.next(75) returned 4, because the last 4 prices
(including today's price of 75) were less than or equal to today's price.


Note:

Calls to StockSpanner.next(int price) will have 1 <= price <= 10^5.
There will be at most 10000 calls to StockSpanner.next per test case.
There will be at most 150000 calls to StockSpanner.next across all test cases.
The total time limit for this problem has been reduced by 75% for C++, and 50% for all other languages.
 */
