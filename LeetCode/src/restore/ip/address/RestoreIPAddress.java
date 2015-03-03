package restore.ip.address;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
	static List<String> l = new ArrayList<String>();

	public static List<String> restoreIpAddresses(String s) {

		int len = s.length();
		if (len < 4 || len > 12) {
			return l;
		}
		add(s, 0, "", 0);
		return l;

	}

	private static void add(String s, int start, String temp, int w) {
		if (w >= 4) {
			return;
		}
		if (w == 3 && start < s.length() - 3) {
			return;
		} else if (w == 3
				&& (s.charAt(start) != '0' || start == s.length() - 1)
				&& (Integer.parseInt(s.substring(start)) <= 255)) {

			temp = temp + s.substring(start);
			l.add(temp);
			return;

		}

		int x = s.length() - 1 - start + 1;
		if (x >= 4 - w && x <= (4 - w) * 3) {
			String temp1 = temp + s.substring(start, start + 1) + ".";
			add(s, start + 1, temp1, w + 1);
		}
		if (s.charAt(start) != '0') {
			if (x - 1 >= 4 - w && x - 1 <= (4 - w) * 3) {
				String temp1 = temp + s.substring(start, start + 2) + ".";
				add(s, start + 2, temp1, w + 1);
			}
			if (x - 2 >= 4 - w && x - 2 <= (4 - w) * 3
					&& (Integer.parseInt(s.substring(start, start + 3)) <= 255)) {
				String temp1 = temp + s.substring(start, start + 3) + ".";
				add(s, start + 3, temp1, w + 1);
			}

		}

	}

	public static void main(String[] args) {
		System.out.println(restoreIpAddresses("172162541"));

	}

}
