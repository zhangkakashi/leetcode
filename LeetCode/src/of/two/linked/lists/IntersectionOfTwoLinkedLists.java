package of.two.linked.lists;

import listnode.ListNode;

public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        if(headA==headB){
            return headA;
        }
        int numA=1, numB=1;
        ListNode tempA=headA, tempB=headB;
        while(tempA.next!=null){
            tempA = tempA.next;
            numA++;
        }
        while(tempB.next!=null){
            tempB = tempB.next;
            numB++;
        }
        if(tempA!=tempB){
            return null;
        }
        int dis = 0;
        if(numA>numB){
            dis = numA-numB;
            tempA = headA;
            tempB = headB;
        }else{
            dis = numB - numA;
            tempA = headB;
            tempB = headA;
        }
        while(dis>0){
            tempA = tempA.next;
            dis--;
        }
        while(tempA!=tempB){
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }
}
