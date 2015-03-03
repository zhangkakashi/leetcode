package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets {

	public static List<List<Integer>> subsets(int[] s) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(s);
		if (s.length == 0) {
			List<Integer> l = new ArrayList<Integer>();
			res.add(l);
			return res;
		} else {
			for (int i = 0; i < 1<<s.length; i++) {
				List<Integer> l = shift(i);
				
				List<Integer> temp = new ArrayList<Integer>();
				for (int j = 0; j < l.size(); j++) {
					
					if (l.get(j) == 1) {
						temp.add(s[j]);
					}
				}
				res.add(temp);

			}

			return res;
		}

	}

	public static List<Integer> shift(int n) {
		List<Integer> s = new ArrayList<Integer>();
		
		while (n >= 1) {
			if (n % 2 == 1) {
				s.add(1);
			} else {
				s.add(0);
			}
			n = n >> 1;
		}
		for (int i = 0; i < s.size(); i++) {
			//System.out.println(s.get(i));
		}
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s[] = {6,5,4,3,2,1}; 
		List<List<Integer>> l = subsets(s);
		for(int i=0;i<l.size();i++){
			System.out.print("{");
			for(int j=0;j<l.get(i).size();j++){
				System.out.print(l.get(i).get(j) + ", ");
			}
			System.out.println("}");
		}
	}

}
