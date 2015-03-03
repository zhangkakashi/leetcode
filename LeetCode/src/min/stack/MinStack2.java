package min.stack;

public class MinStack2 {
	   //Node min = null;
	    Node store = null;
	    public void push(int x) {
	        if(store ==null){
	            //min = new Node(x);
	            store = new Node(x);
	            store.min = x;
	        }else{
	            Node temp = new Node(x);
	            
	            if(x<=store.min){
	                temp.min = x;
	            }else{
	            	temp.min = store.min;
	            }
	            temp.next = store;
	            store = temp;
	        }
	    }

	    public void pop() {
	        store = store.next;
	    }

	    public int top() {
	        return (store==null)?0:store.val;
	    }

	    public int getMin() {
	        return (store==null)?0:store.min;
	    }
	    
	    private class Node{
	        int val;
	        int min;
	        Node next;
	        public Node(int x){
	            val = x;
	        }
	}
}
