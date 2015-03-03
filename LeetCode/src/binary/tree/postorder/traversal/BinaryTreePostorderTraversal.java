package binary.tree.postorder.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import treenode.TreeNode;

public class BinaryTreePostorderTraversal {
	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> l = new ArrayList<Integer>();
		if (root == null) {
			return l;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		//TreeNode pre = null;
		while (!s.isEmpty()) {
			/*TreeNode temp = s.peek();

			 System.out.println(temp.val);
			if ((temp.left == null && temp.right == null)
					|| (pre != null && (pre==temp.left ) || (pre==temp.right))) {
				l.add(temp.val);
				s.pop();
				pre = temp;
				// continue;
			} else {
				if (temp.left != null) {
					s.push(temp.left);
					// temp.left=null;
				}
				if (temp.right != null) {
					s.push(temp.right);
					// temp.right=null;
				}
			}*/
			TreeNode temp = s.pop();
			l.add(0, temp.val);
			if (temp.left != null) {
				s.push(temp.left);
				// temp.left=null;
			}
			if (temp.right != null) {
				s.push(temp.right);
				// temp.right=null;
			}
		}
		return l;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(2);
		System.out.println(postorderTraversal(root));
	}
}
