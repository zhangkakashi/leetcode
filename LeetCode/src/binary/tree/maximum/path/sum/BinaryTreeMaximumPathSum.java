package binary.tree.maximum.path.sum;

import treenode.TreeNode;

public class BinaryTreeMaximumPathSum {

	public static int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int sum = getMax(root);
		// int sum = maxSum(root);
		return Math.max(sum, max);
	}

	static int max = Integer.MIN_VALUE;

	private static int getMax(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = 0;
		int right = 0;
		int sum = root.val;

		if (root.left != null) {
			left = getMax(root.left);
			int sum1 = sum + left;
			max = check(max, sum1);
		}
		if (root.right != null) {
			right = getMax(root.right);
			int sum2 = sum + right;
			max = check(max, sum2);
		}

		sum = sum + left + right;

		System.out.println("root.val->" + root.val + "  sum->" + sum
				+ "  max->" + max + "  left->" + left + "  right->" + right);
		max = check(max, check(root.val, sum));

		return check(root.val, check(root.val + left, root.val + right));
	}

	private static int check(int n1, int n2) {
		if (n1 >= n2) {
			return n1;
		} else {
			return n2;
		}

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode root2 = new TreeNode(-2);
		TreeNode root3 = new TreeNode(-3);
		TreeNode root4 = new TreeNode(1);
		TreeNode root5 = new TreeNode(3);
		TreeNode root6 = new TreeNode(-2);
		TreeNode root7 = new TreeNode(-1);
		

		root.left = root2;
		root.right = root3;
		root2.left = root4;
		root2.right = root5;
		root3.left = root6;
		root4.left = root7;
		/*
		 * 1 / \ -2 -3 / \ / 1 3 -2 / 1
		 */
		System.out.println(maxPathSum(root));
	}
}
