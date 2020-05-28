package com.gjee.leetcode;

import java.util.Stack;

public class Leet_13_RemoveKDigitsIMP {

	 public String removeLeading(String num) {
			while(true) {
				if(num.length()==1)
					break;
				if(num.charAt(0)=='0')
					num = num.substring(1);
				else
					break;
				
			}
			return num;
		}
		public String removeKdigits(String num,int k) {
			
			int original =k;
			if(original == num.length()) return "0";
			Stack<Character> stack  = new Stack<>();
			
			for(int i=0;i<num.length();i++) {
				char ch = num.charAt(i);
				/* this will remove all data 1 by 1.. if condition satsifies*/
				/*if(!stack.isEmpty() && stack.peek()>ch) {
					stack.pop();
				}
				*/
				while(k>0 && !stack.isEmpty() && stack.peek()>ch ) {
					k--;
					stack.pop();
				}
				stack.add(ch);
			}
			
		
			
			while(k>0) {
				k--;
				stack.pop();
			}
			
			StringBuilder builder= new StringBuilder();
			while(!stack.isEmpty()) {
				builder.append(stack.pop());
			}
			
			String result = builder.reverse().toString();
			

			
			return removeLeading(result);
			
		}
}
/*

Remove K Digits
Solution
Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
*/