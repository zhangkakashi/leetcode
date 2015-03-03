package sum.root.to.leaf.numbers;

import treenode.TreeNode;

public class SumRootToLeafNumbers {
	int max = 0;
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return max;
        }
        find(root, 0);
        return max;
    }
    
    private void find(TreeNode root, int res){
        if(root.left==null&&root.right==null){
            res = res*10 + root.val;
            max = max + res;
            return;
        }
        if(root.left!=null){
            find(root.left, res*10 + root.val);
        }
        if(root.right!=null){
            find(root.right, res*10 + root.val);
        }
    }
}
