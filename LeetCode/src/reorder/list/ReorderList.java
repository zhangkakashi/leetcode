package reorder.list;

import listnode.ListNode;

public class ReorderList {
	public static void reorderList(ListNode head) {
        if(head==null||head.next==null){
        	//System.out.println("sign1");
            return;
        }
        ListNode n1 = head;
        ListNode n2 = head;
        while(n2!=null&&n2.next!=null){
            n1 = n1.next;
            n2 = n2.next.next;
        }
        
        if(n1==null||n1.next==null){
            return;
        }
        
        ListNode rev = n1.next;
        n1.next = null;
        
        ListNode h1 = null;
        ListNode next = rev.next;
        while(next!=null){
            rev.next = h1;
            h1 = rev;
            rev = next;
            next = next.next;
        }
        rev.next = h1;
        
        n1 = head;
        while(rev!=null){
            next = n1.next;
            h1 = rev;
            n1.next = h1;
            rev = rev.next;
            h1.next = next;
            n1 = next;
        }
    }
	public static void main(String[] args) {
		ListNode head = null;
		int [] num = {1};
		
		head = new ListNode(num[0]);
		ListNode temp = head;
		for(int i=1;i<num.length;i++){
			 
			
				
				temp.next = new ListNode(num[i]);
			
			temp = temp.next;
		}
		
		reorderList(head);
		
		while(head!=null){
			System.out.println(head);
			head = head.next;
		}
		

	}

}
