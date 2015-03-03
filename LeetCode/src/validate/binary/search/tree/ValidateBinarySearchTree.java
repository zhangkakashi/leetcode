package validate.binary.search.tree;

import treenode.TreeNode;

public class ValidateBinarySearchTree {
	public static boolean isValidBST(TreeNode root) {
        if(root==null){
        	//System.out.println(4);
            return true;
        }
        if(root.left==null&&root.right==null){
        	//System.out.println(1);
            return true;
        }
        //System.out.println(5);
        if(root.val==Integer.MIN_VALUE&&root.left!=null){
            return false;
        }else if(root.val==Integer.MIN_VALUE){
            return check(root.right, Integer.MAX_VALUE, root.val-1);
        }
        if(root.val==Integer.MAX_VALUE&&root.right!=null){
            return false;
        }else if(root.val==Integer.MAX_VALUE){
            return check(root.left, root.val-1, Integer.MIN_VALUE);
        }
        return check(root.left, root.val-1, Integer.MIN_VALUE)&&check(root.right, Integer.MAX_VALUE, root.val+1);
    }
    
    private static boolean check(TreeNode root, int max, int min){
        if(root==null){
        	//System.out.println(6);
            return true;
        }
        System.out.println((root.val+"  "+max)+"  "+min);
        if((root.val>max)||(root.val<min)){
            return false;
        }
        
        
        if(root.val==Integer.MIN_VALUE&&root.left!=null){
            return false;
        }
        if(root.val==Integer.MAX_VALUE&&root.right!=null){
            return false;
        }
        
        System.out.println(2);
        return check(root.left, root.val-1, min)&&check(root.right, max, root.val-1);
        
    }
    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(1);
		//root.left = new TreeNode(2147483647);
		//root.right = new TreeNode(2147483647);
		//root.right.left = new TreeNode(-2147483648);
		System.out.println(isValidBST(root));

	}

}
