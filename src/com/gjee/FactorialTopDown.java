package com.gjee;


class Fibonacci1{

	public int CalculateFibonacci(int n) {
		int[] memoize = new int[n+1];
		return fibonacciRecursive(memoize,n);
		}

	private int fibonacciRecursive(int[] memoize, int n) {
		if(n < 2)
			return n;

		// if we have already solved this subproblem, simply return the result from the cache
		if(memoize[n] != 0)
			return memoize[n];

		memoize[n] = fibonacciRecursive(memoize, n-1) + fibonacciRecursive(memoize, n-2);
		return memoize[n];

	}

}
public class FactorialTopDown {

	public static void main(String[] args) {
		Fibonacci1 fib = new Fibonacci1();
		System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
		System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
		System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));
	}

}
