package reverse.linked.list.two;

import listnode.ListNode;



public class ReverseLinkedListTwo {
	public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||head.next==null||m==n){
            return head;
        }
        int first = m;
        ListNode node = head;
        ListNode pre = null;
        ListNode next = null;
        ListNode nodeM=null;
        //ListNode nodeN=null;
        if(m==1){
            pre=new ListNode(0);
            pre.next = head;
            nodeM = head;
        }
        while(node!=null&&n>0){
        	
            if(m==2&&pre==null){
                pre = node;
                nodeM = node.next;
            }
            m--;
            n--;
//            if(n==1){
//                nodeN = node;
//            }
            node = node.next;
            if(n==0){
            next = node;
            }
        }
//        System.out.println(node.val);
//        System.out.println(nodeM.val);
//        System.out.println(pre.val);
//        System.out.println(next.val);
        
        ListNode temp = null;
        while(nodeM!=node){
        	temp = nodeM;
            nodeM = nodeM.next;
            temp.next = next;
            next = temp;
            pre.next = temp;
            
        }
       // pre.next = next;
        if(first==1){
        	head = next;
        }else{
        return head;
        }
        return head;
    }
	public static void main(String[] args){
		int[] num = {1,2,3,4,5};
		ListNode h = new ListNode(num[0]);
		ListNode next = h;
		for(int i=1;i<num.length;i++){
			next.next = new ListNode(num[i]);
			next = next.next;
		}
		ListNode head = reverseBetween(h, 2,4);
		
		while(head!=null){
			System.out.println(head.val);
			head=head.next;
		}
	}
}
