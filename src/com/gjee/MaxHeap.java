package com.gjee;

import java.io.IOException;

public class MaxHeap {

	public static int[] createMaxHeap(int[] arr) {
		int len = arr.length;
		int[] result = new int[len];
		result[0]=arr[0];
		for(int i=1;i<len;i++) {
			result[i] = arr[i];
			heapify(result,i);
		}

		return result;
	}
	private static void heapify(int[] result,int addedIndex) {
		if(addedIndex==0)
			return;
		int parentIndex = addedIndex/2;
		if(result[parentIndex]< result[addedIndex]) {
			Utility.swap(result,parentIndex, addedIndex);
			heapify(result,parentIndex);
		}
	}
	
	public static void main(String[] args) throws IOException {
		InputReader rd = new InputReader();
		
		int[] arr = rd.rdIntArr();
		arr = createMaxHeap(arr);
		for(int n:arr) {
			System.out.println(n+" ");
		}

	}
}
