package symmetric.tree;

import treenode.TreeNode;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)){
            return true;
        }
        return check(root.left, root.right);
    }
    private boolean check(TreeNode l, TreeNode r){
        if(l==null&&r==null){return true;}
        if((l==null&&r!=null)||(l!=null&&r==null)){return false;}
        if(l.val!=r.val){return false;}
        else{
            return check(l.left, r.right)&&check(l.right,r.left);
        }
    }
}
