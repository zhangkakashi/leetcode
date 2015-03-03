package partition.list;

import listnode.ListNode;



public class PartitionList {
	public static ListNode partition(ListNode head, int x) {
		if(head==null||head.next==null){
            return head;
        }
        ListNode temp1 = head;
        //System.out.println(head.next.next.val);
        ListNode p = null;
        while(temp1!=null&&temp1.val<x){
            
                p = temp1;
            
            temp1 = temp1.next;
        }
        if(temp1==null){
            return head;
        }
        
        ListNode pre = temp1;
        ListNode temp2 = temp1.next;
       
        while(temp2!=null){
        	//
            if(temp2.val<x){
                if(temp1==head){
                	System.out.println("sing2");
                    pre.next = temp2.next;
                    temp2.next = head;
                    head = temp2;
                    p = temp2;
                    temp2 = pre.next;
                    
                }else{
                	System.out.println("sing3");
                    pre.next = temp2.next;
                    temp2.next = temp1;
                    p.next = temp2;
                    p = temp2;
                    temp2 = pre.next;
                }
            }else{
            	System.out.println("sing1");
            pre = temp2;
            temp2 = temp2.next;
            }
        }
        return head;
        
    }
	public static void main(String[] args) {
		int[] num = {3,3,1,2,4};
		ListNode n = new ListNode(num[0]);
		ListNode temp = n;
		for(int i=1;i<num.length;i++){
			
			temp.next = new ListNode(num[i]);
			temp = temp.next;
		}
		
		ListNode n2 = partition(n, 3);
		while(n2!=null){
			System.out.println(n2.val);
			n2=n2.next;
		}

	}

}
