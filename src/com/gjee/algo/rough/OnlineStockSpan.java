package com.gjee.algo.rough;

import java.util.Stack;

public class OnlineStockSpan {

	
	static class StockSpanner {
	    
	    /*
	        We should have a stack of a pair of (current  price, maximum number of consecutive days)
	        Since we don't have an access to the indicies.
	    */
	    Stack<int[]> s;
	    
	    public StockSpanner() {
	        s = new Stack<>();
	    }
	    
	   /*
	   Let's trace the algorithm together on [100, 80, 60, 70, 60, 75, 85]
	   1. calling StockSpanner.next(100) should result in first element in our stack will be (100, 1) (s.size() == 1)
	   2. calling StockSpanner.next(80) should result in second element in our stack will be (80, 1) (s.size() == 2)
	   3. calling StockSpanner.next(60) should result in third element in our stack will be (60, 1) (s.size() == 3)
	   4. Now on calling StockSpanner.next(70) we should add span of (60) + 1 {the current day}
	   and remove it from stack (70, 2) (s.size() == 3)
	   5. Now on calling StockSpanner.next(60) result in fourth element in our stack will be (60, 1) (s.size() == 4)
	   6. Now on calling StockSpanner.next(75) we should add span of (60) and (70) + 1 {the current day}
	   and remove it from stack : (75, 4) (s.size() == 3)
	   7. Now on calling StockSpanner.next(85) we should add span of (75) and (80) + 1 {the current day}
	   and remove it from stack : (85, 6) (s.size() == 2)
	   */
	    
	    public int next(int price) {
	        int span = 1; //for self
	        while (!s.isEmpty() && price >= s.peek()[0]) { // If the current price is greater than stack peek.
	            span += s.peek()[1];
	            s.pop();
	            /*
	             * span += s.pop()[1];
	             */
	        }
	        s.push(new int[]{price, span});
	        return span;
	    }
	}
	
	//for input :100, 80, 60, 70, 60, 75, 85
	//.next(100): stack :- (100,1)
	//.next(80): stack: (100,1),(80,1)
	//.next(60):stack: (100,1),(80,1) ,(60,1)
	//.next(70):stack: (100,1),(80,1) ,(70,2) //try to understand this one
	//.next(60)::stack: (100,1),(80,1) ,(70,2),(60,1) //try to understand this one
	//.next(75)::stack: (100,1),(80,1) ,(75,4) ;//understand using while loop
	//.next(85):stack: (100,1),(85,6) 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = {100, 80, 60, 70, 60, 75, 85};
		OnlineStockSpan.StockSpanner o = new OnlineStockSpan.StockSpanner();
		for(Integer x : arr) {
			System.out.println(o.next(x));
		}

	}

}

/*
 * 
 * /*
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

