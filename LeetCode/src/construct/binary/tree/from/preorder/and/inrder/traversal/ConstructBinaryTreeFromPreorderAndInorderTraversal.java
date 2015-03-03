package construct.binary.tree.from.preorder.and.inrder.traversal;

import treenode.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length<1||preorder.length<1||inorder.length!=preorder.length){
            return null;
        }
        return build(inorder, preorder, 0, preorder.length-1, 0, preorder.length-1 );
    }
    
    private TreeNode build( int[] inorder, int[] preorder, int si, int ei, int sp, int ep) {
        if(sp>ep){
            return null;
        }
        
        TreeNode root =new TreeNode(preorder[sp]);
        if(sp==ep){
            return root;
        }
        
        int i=si;
        
        for(;i<=ei;i++){
            if(inorder[i]==preorder[sp]){
                break;
            }
        }
        
        root.left = build( inorder, preorder, si, i-1, sp+1, sp+1+(i-1-si));
        root.right = build( inorder, preorder, i+1, ei, sp+1+(i-1-si)+1, ep);
        return root;
    }
}
