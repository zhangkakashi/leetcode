package rotate.list;

import listnode.ListNode;

public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
        if(head==null||head.next==null||n==0){
            return head;
        }
        ListNode n1 = head;
        int count = 1;
        while(n1.next!=null){
            n1 = n1.next;
            count++;
        }
        n = n%count;
        if(n==0){
            return head;
        }
        n1 = head;
        ListNode n2 = head;
        while(n2!=null&&n>1){
            n2 = n2.next;
            n--;
        }
        if(n>1||n2==null||n2.next==null){
            return head;
        }
        
        ListNode pre = null;
        while(n2.next!=null){
            pre = n1;
            n2 = n2.next;
            n1 = n1.next;
        }
        pre.next = null;
        n2.next = head;
        return n1;
    }
}
