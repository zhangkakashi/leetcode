package intersection.of.two.linked.lists;

import listnode.ListNode;

public class IntersectionOfTwoLinkedLists {

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null||headB==null){
            return null;
        }
        if(headA==headB){
            return headA;
        }
        int dis = 0;
        ListNode n1 = headA;
        ListNode n2 = headB;
        while(n1.next!=null&&n2.next!=null){
            n1 = n1.next;
            n2 = n2.next;
            if(n1.next==null){
                while(n2.next!=null){
                    n2 = n2.next;
                    dis++;
                }
            }else if(n2.next==null){
                while(n1.next!=null){
                    n1 = n1.next;
                    dis++;
                }
                dis = 0 - dis;
            }
        }
        if(n1!=n2){
            return null;
        }
        if(dis==0){
            return n1;
        }
        n1 = headA;
        n2 = headB;
        if(dis<0){
            while(dis<0){
                n1 = n1.next;
                dis++;
            }
        }else{
            while(dis>0){
                n2 = n2.next;
                dis--;
            }
        }
        
        while(n1!=n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }
    
	public static void main(String[] args) {
		int[] a1 = {2,3};
		
		int[] a2 = {2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		ListNode headA = new ListNode(a1[0]);
		ListNode headB = null;
		ListNode temp = headA;
		ListNode temp1 = null;
		for(int i=1;i<a1.length;i++){
			temp.next = new ListNode(a1[i]);
			if(i==1){
				headB = temp;
				temp1 = headB;
			}else{
				temp1.next = temp.next;
				temp1 = temp1.next;
			}
			temp = temp.next;
            
		}
		temp = headB;
		for(int i=1;i<a2.length;i++){
			temp.next = new ListNode(a2[i]);
			temp = temp.next;
		}
		System.out.println(getIntersectionNode(headA, headB));
	}

}
