package binary.tree.inorder.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import treenode.TreeNode;

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        
        TreeNode temp = root;
        while(temp!=null||!s.isEmpty()){
            while(temp!=null){
                s.push(temp);
                temp = temp.left;
            }
            if(!s.isEmpty()){
                temp = s.pop();
                l.add(temp.val);
                temp = temp.right;
            }
        }
        
        return l;
        
    }
}
