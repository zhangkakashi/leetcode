package reverse.nodes.in.kgroup;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class ReverseNodeInKGroup {

	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		if (k < 2) {
			return head;
		}
		ListNode temp = head;
		

		int step = 0;
		ListNode res = head;
		while (temp.next != null) {
			ListNode pre = null;
			if (step != 0) {
				pre = temp;
				temp = temp.next;
			}
			ListNode point = temp;
			int r = k;
			System.out.println("temp->"+temp.val);
			System.out.println("point->"+point.val);
			while (point.next != null && r > 1) {
				point = point.next;
				r--;
			}
			if (r > 1) {
				return res;
			}
			ListNode head1 = temp;
			while (temp.next != point) {
				System.out.println("sign "+1);
				ListNode nt = temp.next;
				temp.next = temp.next.next;
				nt.next = head1;
				head1 = nt;
			}
			System.out.println("sign "+2);
			temp.next = point.next;
			point.next = head1;
			if (step == 0) {
				res = point;
			}else{
				pre.next = point;
			}
			step++;
		}
		return res;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode res = reverseKGroup(head, 2);
		
		while(res!=null){
			System.out.println(res.val);
			res = res.next;
		}

	}

}
