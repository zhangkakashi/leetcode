package convert.sorted.array.to.binary.search.tree;

public class ConvertSortedArrayToBinarySearchTree {

	public static TreeNode sortedArrayToBST(int[] num) {
        if(num.length==0){
            return null;
        }else if(num.length==1){
            TreeNode t = new TreeNode(num[0]);
            return t;
        }
        
        
        int mid = (num.length-1)/2;
        
        TreeNode t = new TreeNode(num[mid]);
        if(mid-1>=0){
        t.left = sortedArrayToBST(num, 0, mid-1);}
        if(mid+1<=(num.length-1)){
        t.right = sortedArrayToBST(num, mid+1, num.length-1);}
        return t;
    }
    
    public static TreeNode sortedArrayToBST(int[] num, int l, int r) {
    	if(l==r){
    		TreeNode t = new TreeNode(num[l]);
    		return t;
    	}
        int mid = l+(r-l)/2;
        System.out.println(l);
        System.out.println(mid);
        System.out.println(l+mid);
        TreeNode t = new TreeNode(num[mid]);
        
        if((mid-1)>=l){
        t.left = sortedArrayToBST(num, l, mid-1);}
        if((mid+1)<=r){
        t.right = sortedArrayToBST(num, mid+1, r);
        }
        return t;
    }
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = {-1,0,1,2};
		TreeNode t = sortedArrayToBST(a);

	}
	
	
	

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}