package subsets.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubsetsTwo {
	static List<List<Integer>> ls = new ArrayList<List<Integer>>();
	public static List<List<Integer>> subsetsWithDup(int[] num) {
        
        if(num.length<1){
            return ls;
        }
        Arrays.sort(num);
        ls.add(new ArrayList<Integer>());
        add(new ArrayList<Integer>(), 0, num);
        return ls;
    }
	
	private static void add(List<Integer> l, int s, int[] num){
		for(int i=s;i<num.length;i++){
			if(i>s&&num[i]==num[i-1]){
				continue;
			}
			List<Integer> l1 = new ArrayList<Integer>(l);
			l1.add(num[i]);
			ls.add(l1);
			if(i<num.length-1){
			add(l1, i+1, num);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] num = {1,1,1,1,1};
		System.out.println(subsetsWithDup(num));

	}

}
