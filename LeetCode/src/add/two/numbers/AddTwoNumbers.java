package add.two.numbers;

import listnode.ListNode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        int add = 0;
        ListNode res = null;
        ListNode last = null;
        while(l1!=null&&l2!=null){
            if(res==null){
                res = l1;
                int temp = l1.val;
                res.val = (temp+l2.val)%10;
                add=(temp+l2.val)/10;
                last = res;
                l1=l1.next;
                l2=l2.next;
            }else{
                int temp = l1.val;
                l1.val=(temp+l2.val+add)%10;
                add=(temp+l2.val+add)/10;
                last = l1;
                l1=l1.next;
                l2=l2.next;
            }
        }
        if(l1!=null){
            while(l1!=null){
            last.next = l1;
            int temp = l1.val;
            l1.val=(temp+add)%10;
            add=(temp+add)/10;
            last =l1;
            l1=l1.next;
            }
        }
        if(l2!=null){
            while(l2!=null){
            last.next = l2;
            int temp = l2.val;
            l2.val=(temp+add)%10;
            add=(temp+add)/10;
            last=l2;
            l2=l2.next;
            }
        }
        if(add!=0){
            last.next = new ListNode(add);
        }
        return res;
    }
}
