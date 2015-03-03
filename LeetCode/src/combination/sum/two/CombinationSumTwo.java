package combination.sum.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTwo {
	static List<List<Integer>> ls = new ArrayList<List<Integer>>();
    public static List<List<Integer>> combinationSum2(int[] num, int target) {
        if(num==null||num.length<1){
            return ls;
        }
        Arrays.sort(num);
        combine(num, target, 0, 0, new ArrayList<Integer>());
        return ls;
    }
    
    private static void combine(int[] num, int target, int j, int sum, List<Integer> l){
        for(int i=j;i<num.length;i++){
            if(i>j&&num[i]==num[i-1]){
                continue;
            }else if(sum+num[i]==target){
            	System.out.println("sign3->"+sum);
                List<Integer> l1 = new ArrayList<Integer>(l);
                l1.add(num[i]);
                ls.add(l1);
                break;
            }else if(sum+num[i]>target){
            	System.out.println("sign2->"+sum);
                break;
            }else{
                List<Integer> l1 = new ArrayList<Integer>(l);
                l1.add(num[i]);
                System.out.println("sign1->"+sum);
                if(i+1<num.length){
                    combine(num,target,i+1, sum+num[i], l1);
                }
            }
        }
    }
	public static void main(String[] args) {
		int[] num = {2,3,5};
		System.out.println(combinationSum2( num, 7));

	}

}
