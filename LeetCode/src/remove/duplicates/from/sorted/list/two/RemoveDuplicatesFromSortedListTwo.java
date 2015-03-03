package remove.duplicates.from.sorted.list.two;

import listnode.ListNode;



public class RemoveDuplicatesFromSortedListTwo {
	public static ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode temp = head;
        ListNode pre =null;
        int number = head.val;
        while(temp!=null&&temp.next!=null){
        	
            if(temp==head&&temp.next.val==number){
                while(head!=null&&head.val==number){
                    temp = head;
                    //System.out.println(temp.next);
                    head=head.next;
                    temp.next=null;
                    
                }
                
                temp=head;
                if(head!=null){
                number = head.val;
                }
                
            }else{
                if(temp.next.val!=number){
                    pre = temp;
                    temp = temp.next;
                    number = temp.val;
                    
                }else{
                    while(pre.next!=null&&pre.next.val==number){
                    	pre.next = pre.next.next;
                    	
                    }
                    //System.out.println(pre);
                    temp=pre.next;
                    if(temp!=null){
                    	number = temp.val;
                    }
                }
            }
            
        }
        //System.out.println(head.next);
        return head;
    }
	public static void main(String[] args) {
		int[] num = {1,2,3,3,4,4,5};
		ListNode head = new ListNode(num[0]);
		ListNode temp = head;
		for(int i=1;i<num.length;i++){
			temp.next = new ListNode(num[i]);
			temp = temp.next;
		}
		
		ListNode x = deleteDuplicates(head);
		while(x!=null){
		System.out.println("->"+x);
		x=x.next;
		}
	}

}
