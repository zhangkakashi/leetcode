package minimum.depth.of.binary.tree;

import treenode.TreeNode;

public class MinimumDepthOfBinaryTree {
public int minDepth(TreeNode root) {
        
        
        return cal( root, 0);
        
    }
    
    private int cal(TreeNode root, int deep){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return deep+1;
        }
        int left = deep;
        int right = deep;
        if(root.left!=null){
            left = cal(root.left, deep+1);
        }
        if(root.right!=null){
            right = cal(root.right, deep+1);
        }
        
        if(left==deep){
            return right;
        }else if(right == deep){
            return left;
        }else{
            return Math.min(left, right);
        }
        
    }
}
