package com.gjee;


public class BinarySearchRec {

	
public static int bSearchRec(int []arr, int low,int high,int key) {
	
		if(low>high) return -1;
		
		int mid = low + (high-low)/2 ; //(low+high)/2  :overflow can happen
		
		if(arr[mid]  == key) 
			return mid;
		else if(key<arr[mid])
			return bSearchRec(arr,low,mid-1,key);
		else 
			return bSearchRec(arr,mid+1,high,key);
	}
	public static void main(String[] args) {


		int[] arr = {1,2,3,4};
		System.out.println(bSearchRec(arr,0,arr.length-1,2));
		
		int []arr1 = {1};
		System.out.println(bSearchRec(arr1,0,arr1.length-1,1));
	
		System.out.println(bSearchRec(arr1,0,arr1.length-1,2));
	}

}
