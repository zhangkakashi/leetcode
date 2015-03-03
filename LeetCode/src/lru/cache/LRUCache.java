package lru.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private Map<Integer, Node> m = new HashMap<Integer, Node>();
	private Node head = null;
	private Node tail = null;
	private int cap;
	private int size = 0;
	
	public LRUCache(int capacity) {
		this.cap = capacity;
	}

	public int get(int key) {
		if(m.containsKey(key)){
			Node n = m.get(key);
			//n.val = value;
			if(head==n){
				return head.val;
			}
			else if(tail==n){
				tail = n.pre;
				tail.next = null;
				n.next = head;
				head.pre = n;
				head = n;
			}
			else{
				Node temp = n.pre;
				temp.next = n.next;
				n.next.pre = temp;
				n.next = head;
				head.pre = n;
				head = n;
			}
			return n.val;
		}
		return -1;  
	}

	public void set(int key, int value) {
		if(cap<1){
			return;
		}
		if(!m.containsKey(key)){
			if(size<cap){
				Node n = new Node(value);
				n.next = head;
				//head.pre = n;
				
				if(size==0){
					tail = n;
				}else{
					head.pre = n;
				}
				head = n;
				n.k = key;
				m.put(key, n);
				size++;
			}else{
				if(tail.pre!=null){
					m.remove(tail.k);
					tail = tail.pre;
					tail.next=null;
					
				}else{
					m.remove(tail.k);
					tail = null;
				}
				
				if(tail==null){
					Node n = new Node(value);
					//head.pre = n;
					head = n;
					tail = n;
					n.k = key;
					m.put(key, n);
				}else{
					Node n = new Node(value);
					n.next = head;
					head.pre = n;
					head = n;
					n.k = key;
					m.put(key, n);
				}
			}
			
		}else{
			Node n = m.get(key);
			n.val = value;
			if(head==n){
				head.val = value;
			}
			else if(tail==n){
				tail = n.pre;
				tail.next = null;
				n.next = head;
				head.pre = n;
				head = n;
			}
			else{
				Node temp = n.pre;
				temp.next = n.next;
				n.next.pre = temp;
				n.next = head;
				head.pre = n;
				head = n;
			}
			
		}
		
	}
	
	private class Node{
		int val;
		int k;
		Node pre;
		Node next;
		public Node(int x){
			val = x;
		}
	}
	
	public static void main(String[] args){
//		LRUCache l = new LRUCache(1);
//		l.set(2,1);
//		System.out.println(l.get(2));
//		l.set(3,2);
//		System.out.println(l.get(2));
//		System.out.println(l.get(3));
		
		LRUCache l = new LRUCache(2);
		l.set(2,1);
		System.out.println("sign");
		l.set(1,1);
		System.out.println("sign");
		l.set(2,3);
		System.out.println("sign");
		l.set(4,1);
		System.out.println("sign");
		System.out.println(l.get(1));
		System.out.println("sign");
		System.out.println(l.get(2));
		System.out.println("sign");
		System.out.println(l.get(3));
		System.out.println("sign");
	}
}
