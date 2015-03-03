package sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	static List<List<Integer>> ls = new ArrayList<List<Integer>>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null||candidates.length<1){
            return ls;
        }
        Arrays.sort(candidates);
        combine(candidates, target, new ArrayList<Integer>(), 0, 0);
        
        return ls;
    }
    
    private static void combine(int [] can, int target, List<Integer> l, int sum, int j){
        for(int i=j;i<can.length;i++){
        	System.out.println(sum+can[i]);
            if(sum+can[i]==target){
            	System.out.println("sign1");
                List<Integer> l1 = new ArrayList<Integer>(l);
                l1.add(can[i]);
                ls.add(l1);
                break;
            }else if(sum+can[i]<=target-can[i]){
            	System.out.println("sign2");
                List<Integer> l1 = new ArrayList<Integer>(l);
                l1.add(can[i]);
                combine(can, target, l1, sum+can[i], i);
            }else if(sum+can[i]>target){
            	System.out.println("sign3");
                break;
            }
        }
    }
	public static void main(String[] args) {
		int[] num = {8,7,4,3};
		System.out.println(combinationSum(num, 11));

	}

}
