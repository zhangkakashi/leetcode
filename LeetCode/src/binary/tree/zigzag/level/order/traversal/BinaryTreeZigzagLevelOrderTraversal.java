package binary.tree.zigzag.level.order.traversal;

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
	
	public String toString(){
		return val+"";
	}
}

public class BinaryTreeZigzagLevelOrderTraversal {

	static List<List<Integer>> ls = new ArrayList<List<Integer>>();

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return ls;
		}
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();

		s1.push(root);

		while (!s1.empty() || !s2.empty()) {
			System.out.println("sign->"+1);
			if (!s1.empty()) {
				List<Integer> l = new ArrayList<Integer>();
				while (!s1.empty()) {
					System.out.println("sign->"+2);
					TreeNode n = s1.pop();
					l.add(n.val);
					if (n.left != null) {
						s2.push(n.left);
					}
					if (n.right != null) {
						s2.push(n.right);
					}

				}
				ls.add(l);
			}
			System.out.println(s1.empty()+""+s2.empty());
			if (!s2.empty()) {
				List<Integer> l = new ArrayList<Integer>();
				while (!s2.empty()) {
					System.out.println("sign->"+3);
					TreeNode n = s2.pop();
					l.add(n.val);
					if (n.right != null) {
						s1.push(n.right);
					}
					if (n.left != null) {
						s1.push(n.left);
					}
				}
				ls.add(l);
			}
		}
		return ls;

	}

	public static void main(String[] args) {
		System.out.println(zigzagLevelOrder(new TreeNode(1)));

	}

}
