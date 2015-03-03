package construct.binary.tree.from.inorder.and.postorder.traversal;

import treenode.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length<1||postorder.length<1||inorder.length!=postorder.length){
            return null;
        }
        return build(inorder, postorder, 0, postorder.length-1, 0, postorder.length-1 );
    }
    
    private TreeNode build(int[] inorder, int[] postorder, int si, int ei, int sp, int ep ){
        if(ep<sp){
            return null;
        }
        TreeNode root = new TreeNode(postorder[ep]);
        if(ep==sp){
            return root;
        }
        int ilocation=0;
        for(int i=si;i<=ei;i++){
            if(inorder[i]==postorder[ep]){
                ilocation = i;
                break;
            }
        }
        
        root.left = build(inorder, postorder, si, ilocation-1, sp, sp+ilocation-1-si );
        root.right = build(inorder, postorder, ilocation+1, ei, sp+ilocation-1-si+1, ep-1 );
        return root;
        
    }
}
