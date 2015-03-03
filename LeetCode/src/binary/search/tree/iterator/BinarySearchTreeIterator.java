package binary.search.tree.iterator;

import java.util.LinkedList;
import java.util.Queue;

import treenode.TreeNode;
class BSTIterator {

	Queue<TreeNode> q = new LinkedList<TreeNode>();
	
    public BSTIterator(TreeNode root) {
        push(root);
    }
    
    private void push(TreeNode root){
    	if(root!=null){
    		push(root.left);
    		q.add(root);
    		push(root.right);
    	}
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !q.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return q.poll().val;
    }
}
public class BinarySearchTreeIterator {

	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
