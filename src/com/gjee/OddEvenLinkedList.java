package com.gjee;


public class OddEvenLinkedList {
    class ListNode{
    	public ListNode next;
    	public int val;
    	
    	public void display(ListNode head) {
    		while(head!=null) {
    			System.out.print(head.val + " ");
    			head = head.next;
    		}
    	}
    	
    	public ListNode insert(int[] arr,ListNode head) {
    		
    		while(head!=null) {
                
    		}
    		
    		return head;
    	}
    }
	public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
