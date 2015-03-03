package reverse.linked.list.ii;

import listnode.ListNode;

public class ReverseLinkedListII {

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		int res = m;
        int dis = n-m;
        ListNode n1 = head;
        ListNode n2 = head;
        ListNode pre = new ListNode(0);
        pre.next = n2;
        
        while(dis>0&&n1!=null){
            n1 = n1.next;
            dis--;
        }
        if(n1==null){
            return head;
        }
        while(m>1){
            n1 = n1.next;
            pre = n2;
            n2 = n2.next;
            m--;
        }
        
        ListNode next = n1.next;
        
        ListNode tail = next;
        while(n2!=null&&n2!=next){
        	//System.out.println("x");
            ListNode temp = n2.next;
            n2.next = tail;
            tail = n2;
            n2 = temp;
        }
        
            pre.next = n1;
            if(res==1){
            	//System.out.println(head);
            	return n1;
            }else{
            	
            	return head;
            }
            
        
    }
	public static void main(String[] args) {
		int[] arr = {1,3, 5};
		ListNode head = new ListNode(arr[0]);
		ListNode temp = head;
		for(int i=1;i<arr.length;i++){
			temp.next = new ListNode(arr[i]);
			temp = temp.next;
		}
		ListNode res = reverseBetween(head, 1,2);
		while(res!=null){
			System.out.println(res);
			res = res.next;
		}
	}

}
