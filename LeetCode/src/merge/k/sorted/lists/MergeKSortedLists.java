package merge.k.sorted.lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import listnode.ListNode;

public class MergeKSortedLists {

	public ListNode mergeKLists(List<ListNode> lists) {
	    if(lists.size()<1||lists.get(0)==null){
	    	return null;
	    }
		List<ListNode> list = sort(lists);
		ListNode head = pop(list);
		ListNode temp = head;
		//System.out.println(list);
		while(list.size()>0){
			//System.out.println(list);
			temp.next = pop(list);
			temp = temp.next;
			
		}
		
		return head;
	    }
	    
	    private List<ListNode> sort(List<ListNode> l){
	    	List<ListNode> link = new LinkedList<ListNode>();
	        link.add(l.get(0));
	        for(int i=1;i<l.size();i++){
	            if(l.get(i)==null){
	                continue;
	            }
	            int j=0;
	            while(j<link.size()&&l.get(i).val>link.get(j).val){
	            	j++;
	            }
	            link.add(j, l.get(i));
	        }
	        System.out.println(link);
	        return link;
	       
	    }
	    
	    private ListNode pop(List<ListNode> l){
	    	ListNode head = l.get(0);
	    	l.remove(0);
	    	if(head.next!=null){
	    		ListNode temp = head.next;
	    		int j=0;
	            while(j<l.size()&&temp.val>l.get(j).val){
	            	j++;
	            }
	            l.add(j, temp);
	    	}
	    	return head;
	    }
    
    
	public static void main(String[] args) {
		int [][] num = {{2,4,7,45,453},{},{23,124,234},{3,4}};
		List<ListNode> l = new ArrayList<ListNode>();
		for(int[] j:num){
			ListNode h = null;
			ListNode temp = null;
			for(int i: j){
				if(h==null){
					h = new ListNode(i);
					temp = h;
				}else{
					temp.next = new ListNode(i);
					temp = temp.next;
				}
			
			}
			l.add(h);
		}
		System.out.println(l);
		MergeKSortedLists m = new MergeKSortedLists();
		ListNode node = m.mergeKLists(l);
		while(node!=null){
			System.out.println(node);
			node = node.next;
		}

	}

}
