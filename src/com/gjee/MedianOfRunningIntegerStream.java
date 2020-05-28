package com.gjee;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * 
 * class MedianFinder {

    // initialize your data structure here.
    public MedianFinder() {

    }

    public void addNum(int num) {

    }

    public double findMedian() {

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


public class MedianOfRunningIntegerStream {

	PriorityQueue<Integer> maxQueue ;
	PriorityQueue<Integer> minQueue;
	public MedianOfRunningIntegerStream() {

		maxQueue = new PriorityQueue<>(Collections.reverseOrder()) ;
        minQueue = new PriorityQueue<>(); //minimum ko priroity //will contain upper part of array
	}
	//12 11 12 12
 /*	public void addNum(int num) {
       
      if(maxQueue.peek() ==null || maxQueue.peek()>=num) {
    	  maxQueue.add(num);
      }
      else if(minQueue.peek() ==null || minQueue.peek()<=num) {
    	  minQueue.add(num);
      }
      if(maxQueue.size()-minQueue.size()>1) {
    	  minQueue.add(maxQueue.remove());
      }
      if(minQueue.size()-maxQueue.size()>1) {
    	  maxQueue.add(minQueue.remove());
      }
	}*/

	public void addNum(int num) {
	       
	      if(maxQueue.peek() ==null || maxQueue.peek()>=num) {
	    	  maxQueue.add(num);
	           System.out.println("max"+num);
	      }
	      else{ //IMPORTANT: if not able to add in maxQueue, add in minqueue anyhow
	    	  minQueue.add(num);
	           System.out.println("min"+num);
	      }
	        System.out.println("maxq size"+maxQueue.size());
	        System.out.println("minq size"+minQueue.size());
	      if(maxQueue.size()-minQueue.size()>1) {
	    	  minQueue.add(maxQueue.remove());
	        }
	      else if(minQueue.size()-maxQueue.size()>1) {
	    	  maxQueue.add(minQueue.remove());
	           System.out.println("++");
	         }
		}

		public double findMedian() {
	        /*System.out.println(maxQueue.size()+"size"+minQueue.size());
	        System.out.println(maxQueue.peek()+"--"+minQueue.peek());
	        System.out.println();
	        */
			if(maxQueue.size() == minQueue.size()) {
				return (maxQueue.peek()+minQueue.peek())/2.0;
			}
			else if(maxQueue.size()>minQueue.size()){
				return maxQueue.peek();
			}
			else {
				return  minQueue.peek();
			}
			
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/*
 * 
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.


Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2


Follow up:

If all integer numbers from the stream are between 0 and 100, how would you optimize it?
If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */
