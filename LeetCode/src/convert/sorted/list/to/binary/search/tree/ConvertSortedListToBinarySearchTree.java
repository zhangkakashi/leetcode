package convert.sorted.list.to.binary.search.tree;

import listnode.ListNode;
import treenode.TreeNode;

public class ConvertSortedListToBinarySearchTree {
	public static TreeNode sortedListToBST(ListNode head) {
		if(head==null){
            return null;
        }
        int count = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        return convert(head, 0, count-1);
    }
    private static TreeNode convert(ListNode head, int s, int length){
    	if(s>length){
            return null;
        }
        int mid = (s+length)/2;
        ListNode res = head;
        for(int i=s;i<mid;i++){
            res = res.next;
        }
        TreeNode r = new TreeNode(res.val);
        r.left = convert(head,s,mid-1);
        r.right = convert(res.next,mid+1, length);
        return r;
    }
	public static void main(String[] args) {
		int[] num = {0};
		ListNode node = new ListNode(num[0]);
		ListNode temp = node;
		for(int i=1;i< num.length;i++){
			temp.next =  new ListNode(num[i]);
			temp = temp.next;
		}
		
		sortedListToBST(node);

	}

}
