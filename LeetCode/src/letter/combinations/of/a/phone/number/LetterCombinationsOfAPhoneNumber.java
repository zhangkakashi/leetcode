package letter.combinations.of.a.phone.number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

	public static List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();

		Map<String, List<String>> digit = new HashMap<String, List<String>>();
		for (int i = 0; i < 10; i++) {
			List<String> temp = new ArrayList<String>();
			if (i == 2) {
				temp.add("a");
				temp.add("b");
				temp.add("c");
			} else if (i == 3) {
				temp.add("d");
				temp.add("e");
				temp.add("f");
			} else if (i == 4) {
				temp.add("g");
				temp.add("h");
				temp.add("i");
			} else if (i == 5) {
				temp.add("j");
				temp.add("k");
				temp.add("l");
			} else if (i == 6) {
				temp.add("m");
				temp.add("n");
				temp.add("o");
			} else if (i == 7) {
				temp.add("p");
				temp.add("q");
				temp.add("r");
				temp.add("s");
			} else if (i == 8) {
				temp.add("t");
				temp.add("u");
				temp.add("v");
			} else if (i == 9) {
				temp.add("w");
				temp.add("x");
				temp.add("y");
				temp.add("z");
			} else {
				temp = null;
			}
			digit.put("" + i, temp);
		}

		for (int i = 0; i < digits.length(); i++) {
			List<String> t = digit.get("" + digits.charAt(i));

			res = combine(res, t);

		}

		return res;
	}

	public static List<String> combine(List<String> a, List<String> b) {
		List<String> res = new ArrayList<String>();

		if ((a == null||a.size()==0) && (b == null||b.size()==0)) {

			return res;
		} else if (a == null || a.size() == 0) {

			for (String temp : b) {
				res.add(temp);

			}
		} else if (b == null || b.size() == 0) {
			for (String temp : a) {
				res.add(temp);

			}
		} else {

			for (int i = 0; i < a.size(); i++) {
				for (int j = 0; j < b.size(); j++) {
					String temp = a.get(i) + b.get(j);

					res.add(temp);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		List<String> r = new ArrayList<String>();
		r = letterCombinations("123");
		System.out.println(r.size());
		for (String temp : r) {
			System.out.println(temp);
		}

	}

}
