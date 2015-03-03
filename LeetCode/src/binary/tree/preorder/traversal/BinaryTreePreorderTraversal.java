package binary.tree.preorder.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class BinaryTreePreorderTraversal {

	/**
	 * @param args
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root==null){
			return res;
		}
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(root);
		while(!st.isEmpty()){
			TreeNode cur = st.peek();
			st.pop();
			res.add(cur.val);
			if(cur.left!=null){
				st.push(cur.left);
			}
			if(cur.right!=null){
				st.push(cur.right);
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
