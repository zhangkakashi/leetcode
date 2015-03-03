package flatten.binary.tree.to.linked.list;

class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
public class FlattenBinaryTreeToLinkedList {

	public static void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        if(root.left==null&&root.left==null){
            last = root;
        }
        TreeNode right = root.right;
        if(root.left!=null){
        	System.out.println("sign->"+1);
            root.right = root.left;
            flatten(root.left);
            root.left = null;
        }
        if(right!=null){
        	
            last.right = right;
            flatten(right);
            System.out.println("sign->"+2);
        }
    }
    static TreeNode last = null;
    private static TreeNode move(TreeNode root){
    	//Queue q = null;
        if(root.left==null&&root.left==null){
            last = root;
        }
        TreeNode right = root.right;
        if(root.left!=null){
        	System.out.println("sign->"+1);
            root.right = move(root.left);
            root.left = null;
        }
        if(right!=null){
            last.right = move(root.right);
            System.out.println("sign->"+2);
        }
        System.out.println("sign->"+3);
        return root;
    }
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		flatten(root);
		System.out.println(root.right.val);
		System.out.println(root.right.right.val);
		//System.out.println(root.left.val);
		//System.out.println(root.right.right.right.val);
	}

}
