package balanced.binary.tree;

import treenode.TreeNode;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)){
            return true;
        }
        
        if(check(root)<0){
            return false;
        }else{
            return true;
        }
        
        //return check(root, 0);
    }
    
    private int check(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = check(root.left);
        int right = check(root.right);
        
        if(left<0||right<0||Math.abs(left-right)>1){
            return -1;
        }else{
            return 1 + Math.max(left,right);
        }
    }
}
