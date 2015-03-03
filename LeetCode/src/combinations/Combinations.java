package combinations;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public static List<List<Integer>> combine(int n, int k) {

		if (k > n) {
			return ls;
		}
		List<Integer> l = new ArrayList<Integer>();
		combine(l, k, 1, n);
		return ls;
	}

	static List<List<Integer>> ls = new ArrayList<List<Integer>>();

	private static void combine(List<Integer> l, int k, int start, int n) {
		if (k <1) {
			ls.add(new ArrayList<Integer>(l));
			return;
		}
//		System.out.println(k);
//		System.out.println(l);
		for (int i = start; i <= n; i++) {
			List<Integer> l1 = new ArrayList<Integer>(l);
			l1.add(i);
			combine(l1, k - 1, i + 1, n);
		}
	}
	
	public static void main(String[] args){
		System.out.println(combine(4, 2));
	}
}
