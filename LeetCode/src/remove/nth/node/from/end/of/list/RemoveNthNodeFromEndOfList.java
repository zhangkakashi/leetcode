package remove.nth.node.from.end.of.list;

import listnode.ListNode;

public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head==null){
            return head;
        }
        ListNode n1 = head;
        ListNode n2 = head;
        ListNode pre = null;
        
        int temp = n;
        while(temp>1&&n2.next!=null){
            n2 = n2.next;
            temp--;
        }
        if(n2.next==null&&temp>1){
            return head;
        }else if(n2.next==null){
            head = head.next;
            return head;
        }
        
        while(n2.next!=null){
            pre = n1;
            n2 = n2.next;
            n1 = n1.next;
        }
        pre.next = n1.next;
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
