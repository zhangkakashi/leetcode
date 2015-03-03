package combination.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	static List<List<Integer>> ls = new ArrayList<List<Integer>>();
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		for(int i=0;i<candidates.length;i++){
			//System.out.println(i);
			if(candidates[i]==target){
				List<Integer> l = new ArrayList<Integer>();
				l.add(candidates[i]);
				ls.add(l);
				break;
			}else if(candidates[i]>target){
				break;
			}else{
				List<Integer> l = new ArrayList<Integer>();
				l.add(candidates[i]);
				rec(l,i,candidates, target,candidates[i]);
			}
		}
		return ls;
	}

	private static void rec(List<Integer> l, int newBegin, int[] can, int target, int cur){
		for(int i=newBegin;i<can.length;i++){
//			System.out.println("i->" + i);
//			System.out.println("can[i]----->" + (can[i]));
//			System.out.println("cur----->" + (cur));
//			System.out.println("can[i]+cur----->" + (can[i]+cur));
			if((can[i]+cur)==target){
				//System.out.println("can[i]+cur----->" + (can[i]+cur));
				//System.out.println("target->"+target);
				List<Integer> l1 = l.subList(0, l.size());
				
				l1.add(can[i]);
				System.out.println(l1);
				ls.add(l1);
				l.remove(l.size()-1);
				l.remove(l.size()-1);
				break;
			}else if((can[i]+cur)<target){
				//System.out.println("can[i]----->" + (can[i]));
				//System.out.println("cur----->" + (cur));
				l.add(can[i]);
				//System.out.println(1);
				rec(l,i,can, target,can[i]+cur);
			}else{
				l.remove(l.size()-1);
				//System.out.println("hehe");
				break;
			}
		}
	}
	public static void main(String[] args) {
		int []n = {1} ;
		combinationSum(n,2);

	}

}
