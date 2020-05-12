package com.gjee;


import java.util.HashMap;

class Node2{
    int key;
    int value;
    Node2 prev;
    Node2 next;
 
    public Node2(int key, int value){
        this.key=key;
        this.value=value;
    }
}
class LRUCache2 {
	Node2 head;
	Node2 tail;
    HashMap<Integer, Node2> map = null;
    int cap = 0;
 
    public LRUCache2(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
    }
 
    public int get(int key) {
        if(map.get(key)==null){
            return -1;
        }
 
        //move to tail
        Node2 t = map.get(key);
 
        removeNode(t);
        offerNode(t);
 
        return t.value;
    }
 
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node2 t = map.get(key);
            t.value = value;
 
            //move to tail
            removeNode(t);
            offerNode(t);
        }else{
            if(map.size()>=cap){
                //delete head
                map.remove(head.key);
                removeNode(head);
            }
 
            //add to tail
            Node2 node = new Node2(key, value);
            offerNode(node);
            map.put(key, node);
        }
    }
 
    private void removeNode(Node2 n){
        if(n.prev!=null){
            n.prev.next = n.next;
        }else{
            head = n.next;
        }
 
        if(n.next!=null){
            n.next.prev = n.prev;
        }else{
            tail = n.prev;
        }
    }
 
    private void offerNode(Node2 n){
        if(tail!=null){
            tail.next = n;
        }
 
        n.prev = tail;
        n.next = null;
        tail = n;
 
        if(head == null){
            head = tail;   
        }
    }
}
