package wordbreak;

import java.util.Set;

public class WordBreak2 {
	public boolean wordBreak(String s, Set<String> dict) {

		if (dict.size() < 1) {
			return false;
		}
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;

		for (int i = 0; i < s.length(); i++) {
			if (!dp[i]) {
				continue;
			}

			for (String d : dict) {
				int len = d.length();
				if (i + len > s.length()) {
					continue;
				}
				if (s.substring(i, i + len).equals(d)) {
					dp[i + len] = true;
				}
			}
		}
		return dp[dp.length - 1];
	}
}
