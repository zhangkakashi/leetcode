package path.sum;

import treenode.TreeNode;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        boolean left = false;
        boolean right = false;
        
        if(root.left==null&&root.right==null){
            if(sum==root.val){
                return true;
            }else{
                return false;
            }
        }
        if(root.left!=null){
            left = hasPathSum(root.left,sum-root.val);
        }
        if(root.right!=null){
            right = hasPathSum(root.right,sum-root.val);
        }
        
        return left||right;
    }
}
