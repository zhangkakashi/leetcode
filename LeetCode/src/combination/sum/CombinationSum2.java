package combination.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

	static List<List<Integer>> ls = new ArrayList<List<Integer>>();
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		
		Arrays.sort(candidates);
		rec(new ArrayList<Integer>(), 0, candidates, target);
		return ls;
	}

	private static void rec(List<Integer> l, int newBegin, int[] can, int target){
		if(target==0){
			ls.add(l);
			return;
		}
		for(int i=newBegin;i<can.length;i++){
			System.out.println(target);
			int newt = target-can[i];
			
			if(newt>=0){
				List<Integer> temp = new ArrayList<Integer>(l);
				//System.out.println(temp);
				temp.add(can[i]);
				rec(temp,i,can,newt);
			}else{
				break;
			}
		}
		
	}
	public static void main(String[] args) {
		int []n = {1,2} ;
		System.out.println(combinationSum(n,2));

	}

}
