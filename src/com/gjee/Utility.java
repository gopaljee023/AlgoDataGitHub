package com.gjee;

public class Utility {

	
	public static void swap(int[] result, int i, int j) {
		int t = result[i];
		result[i] = result[j];
		result[j]=t;
	}
	
	public static int max(int a, int b) {
		return a>b?a:b;
	}
	
	public static int min(int a, int b) {
		return a<b?a:b;
	}
		
}
