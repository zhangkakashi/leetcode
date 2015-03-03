package binary.search.tree.iterator;

import java.util.Stack;

import treenode.TreeNode;
class BSTIterator2 {

	Stack<TreeNode> stack = new Stack<TreeNode>();
	
    public BSTIterator2(TreeNode root) {
        push(root);
    }
    
    private void push(TreeNode root){
    	if(root!=null){
    		stack.push(root);
    		push(root.left);
    	}
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
    	TreeNode t = stack.pop();
    	push(t.right);
        return t.val;
    }
}
public class BinarySearchTreeIterator2 {

	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
