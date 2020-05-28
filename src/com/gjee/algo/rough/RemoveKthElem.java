package com.gjee.algo.rough;

import java.util.PriorityQueue;
import java.util.Stack;

public class RemoveKthElem {


	public String deleteLeadningZero(String s) {
		int i =0;
		for(i=0;i<s.length();i++) {
			if(s.charAt(i) !='0')
				break;
				
		}
		if(i==s.length())
			return "0";
		else
			return s.substring(i);
	}
	//timeout
	public String removeKdigits(String num, int len,int orig) {
		if(len==orig)
			return "0";
		if(orig==0)
			return deleteLeadningZero(num);
		num  = removeLeading(num);
		String min = num;
		while(true) {
			for(int i=0;i<num.length();i++) {
				String data = num.substring(0, i) + num.substring(i + 1);
				if(min.length()>data.length() ||min.compareTo(data)>0) {
					min = data;
				}
			}
			if(min.length()==len-orig)
				break;
			num = removeLeading(min);
		}

		return removeLeading(min);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveKthElem o = new RemoveKthElem();

//		System.out.println("expected-1219:"+o.removeKdigits("1432219", 7,3));
//	    System.out.println("expected-200:"+o.removeKdigits("10200", 5,1));
//
//		System.out.println("expected-0:"+o.removeKdigits("10", 2,2));
//		System.out.println("expected-10:"+o.removeKdigits("1010", 4,1));
//		
		System.out.println("expected-0:"+o.removeKdigits("1234567890",9));
		System.out.println("expected-11:"+o.removeKdigits("112", 1));
		System.out.println("expected-1219:"+o.removeKdigits("1432219", 3));
	    System.out.println("expected-200:"+o.removeKdigits("10200", 1));

		System.out.println("expected-0:"+o.removeKdigits("10", 2));
		System.out.println("expected-10:"+o.removeKdigits("1010", 1));
		
	}
	
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
			stack.push(ch);
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
 * 
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

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
