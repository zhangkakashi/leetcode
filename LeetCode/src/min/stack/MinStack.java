package min.stack;

public class MinStack {
	   Node min = null;
	    Node store = null;
	    public void push(int x) {
	        if(store ==null){
	            min = new Node(x);
	            store = new Node(x);
	        }else{
	            Node temp = new Node(x);
	            temp.next = store;
	            store = temp;
	            if(x<=min.val){
	                Node t =new Node(x);
	                t.next = min;
	                min = t;
	            }
	        }
	    }

	    public void pop() {
	        if(store.val==min.val){
	            min = min.next;
	        }
	        store = store.next;
	    }

	    public int top() {
	        return (store==null)?0:store.val;
	    }

	    public int getMin() {
	        return (min==null)?0:min.val;
	    }
	    
	    private class Node{
	        int val;
	        Node next;
	        public Node(int x){
	            val = x;
	        }
	}
}
