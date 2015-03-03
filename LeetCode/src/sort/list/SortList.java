package sort.list;

import listnode.ListNode;

public class SortList {
	 public static ListNode sortList(ListNode head) {
	        if(head==null||head.next==null){
	            return head;
	        }
	        return divide(head);
	    }
	    
	    private static ListNode divide(ListNode head){
	        if(head==null||head.next==null){
	            return head;
	        }
	        ListNode n1 = head;
	        ListNode n2 = head;
	        ListNode pre = null;
	        while(n1!=null&&n2!=null&&n2.next!=null){
	        	pre = n1;
	            n1 = n1.next;
	            n2 = n2.next.next;
	        }
	        System.out.println("sign1");
	        n2 = n1;
	        pre.next = null;
	        System.out.println(head.next);
	        ListNode left = divide(head);
	        ListNode right = divide(n2);
	        
	        return merge(left, right);
	    }
	    
	    private static ListNode merge(ListNode left, ListNode right){
	        if(left==null){
	            return right;
	        }
	        if(right==null){
	            return left;
	        }
	        ListNode head = null;
	        ListNode temp = null;
	        while(left!=null&&right!=null){
	            if(left.val<=right.val){
	                if(temp==null){
	                    temp=left;
	                    head = left;
	                }else{
	                    temp.next = left;
	                    temp = temp.next;
	                }
	                left = left.next;
	            }else{
	                if(temp==null){
	                    temp=right;
	                    head = right;
	                }else{
	                    temp.next = right;
	                    temp = temp.next;
	                }
	                right = right.next;
	            }
	        }
	        System.out.println("sign2");
	        if(left!=null){
	            while(left!=null){
	                temp.next = left;
	                temp = temp.next;
	                left = left.next;
	            }
	        }
	        if(right!=null){
	            while(right!=null){
	                temp.next = right;
	                temp = temp.next;
	                right = right.next;
	            }
	        }
	        return head;
	    }
	public static void main(String[] args) {
		int[] num = {3,2,4};
		ListNode head = new ListNode(num[1]);
		ListNode temp = head;
		for(int i=1;i<num.length;i++){
			temp.next = new ListNode(num[i]);
			temp = temp.next;
		}
		sortList(head);
		

	}

}
