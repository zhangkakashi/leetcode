package binarytreelevelordertraversal;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class BinaryTreeLevelOrderTraversal {

	/**
	 * @param args
	 */
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> order = new ArrayList<List<Integer>>();
		 
		List<TreeNode> level = new ArrayList<TreeNode>();
		level.add(root);
		
		while(!level.isEmpty()&&(!(level.get(0)==null))){
			
			
			
			List<Integer> curVal = new ArrayList<Integer>();
			List<TreeNode> nextLevel = new ArrayList<TreeNode>();
			
			for(TreeNode cur: level){
				curVal.add(cur.val);
				if(cur.left!=null){
					nextLevel.add(cur.left);
				}
				if(cur.right!=null){
					nextLevel.add(cur.right);
				}
				
			}
			
			order.add(curVal);
			level = nextLevel;
			
		}
		
		
		return order;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
