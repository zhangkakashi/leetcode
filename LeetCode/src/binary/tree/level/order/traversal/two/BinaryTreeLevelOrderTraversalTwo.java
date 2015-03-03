package binary.tree.level.order.traversal.two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import treenode.TreeNode;

public class BinaryTreeLevelOrderTraversalTwo {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<List<Integer>>();
        if(root==null){
            ls.add(new ArrayList<Integer>());
            return ls;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> l = new ArrayList<Integer>();
            Queue<TreeNode> temp = new LinkedList<TreeNode>();
            while(!q.isEmpty()){
                TreeNode node = q.poll();
                l.add(node.val);
                if(node.left!=null){
                    temp.add(node.left);
                }
                if(node.right!=null){
                    temp.add(node.right);
                }
            }
            q = temp;
            ls.add(0,l);
        }
        return ls;
    }
}
