package permutation.sequence;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PermutationSequence {

	public static String getPermutation(int n, int k) {
        int div = 1;
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        List<Integer> l1 = new LinkedList<Integer>();
        for(int i=1;i<n;i++){
            div *= i;
            l.add(div);
            l1.add(i);
        }
        l1.add(n);
        String res = "";
        k--;
        for(int i=n-1;i>0;i--){
        	//System.out.println("l1:  " + l1);
            int r = k/l.get(i);
            //System.out.println(r);
            res = res + l1.remove(r);
            //System.out.println(res);
            k = k%l.get(i);
            
            
        }
        res = res + l1.get(0);
        return res;
    }
	public static void main(String[] args) {
		for(int i=1;i<10;i++){
		System.out.println(getPermutation(4,i));
		}
	}

}
