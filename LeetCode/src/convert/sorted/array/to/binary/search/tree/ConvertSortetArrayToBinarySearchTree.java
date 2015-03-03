package convert.sorted.array.to.binary.search.tree;

import treenode.TreeNode;

public class ConvertSortetArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
        if(num==null||num.length<1){
            return null;
        }
        return convert(num,0,num.length-1);
    }
    
    private TreeNode convert(int[] num, int l, int r){
        if(r<l){
            return null;
        }
        int mid = (l+r)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = convert(num,l,mid-1);
        root.right = convert(num, mid+1, r);
        return root;
    }
}
