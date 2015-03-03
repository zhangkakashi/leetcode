package unique.binary.search.trees.two;

import java.util.ArrayList;
import java.util.List;

import treenode.TreeNode;

public class UniqueBinarySearchTreesTwo {
	public List<TreeNode> generateTrees(int n) {
        return create(1,n);
    }
    
    private List<TreeNode> create(int s, int e){
        List<TreeNode> l = new ArrayList<TreeNode>();
        //if(e==0)
        if(s>e){
            l.add(null);
            return l;
        }
        
        for(int i=s;i<=e;i++){
            List<TreeNode> left = create(s, i-1);
            List<TreeNode> right = create(i+1, e);
            for(int x=0;x<left.size();x++){
                for(int y=0;y<right.size();y++){
                    TreeNode node = new TreeNode(i);
                    node.left = left.get(x);
                    node.right = right.get(y);
                    l.add(node);
                }
            }
        }
        return l;
    }
}
