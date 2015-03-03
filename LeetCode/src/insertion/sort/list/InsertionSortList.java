package insertion.sort.list;

import listnode.ListNode;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        
        ListNode tail = head;
        while(tail.next!=null){
            if(tail.next.val>=tail.val){
                tail = tail.next;
            }else{
                ListNode temp = tail.next;
                tail.next = tail.next.next;
                if(temp.val<=head.val){
                    temp.next = head;
                    head = temp;
                }else{
                    ListNode pre = head;
                    while(pre.next.val<temp.val){
                        pre = pre.next;
                    }
                    temp.next = pre.next;
                    pre.next = temp;
                }
            }
        }
        return head;
    }
}
