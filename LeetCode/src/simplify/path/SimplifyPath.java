package simplify.path;

import java.util.Stack;

public class SimplifyPath {
	public static String simplifyPath(String path) {
		int len = path.length();
		if (len < 1) {
			return "/";
		}
		Stack<String> stack = new Stack<String>();
		int i = 0;
		// System.out.println(i);
		i = 1;
		int t = 1;
		while (i < len) {
			if (path.charAt(i) == '/') {
				if (t == i) {
					t++;
				} else {
					String p = path.substring(t, i);
					if (p.equals("..")) {
						if(!stack.isEmpty()){
							stack.pop();
						}
					} else if (p.equals(".")) {

					} else if (!p.equals("")) {
						stack.push(p);
					}
					t = i + 1;
				}
			}
			i++;

		}
		String p = path.substring(t, len);
		// System.out.println(p);
		if (p.equals("..")) {
			if(!stack.isEmpty()){
				stack.pop();
			}
		} else if (p.equals(".")) {

		} else if (!p.equals("")) {
			stack.push(p);
		}

		String res = "";
		while (!stack.isEmpty()) {
			String x = stack.pop();
			if (res.equals("")) {
				res = x;
			} else {
				res = x + "/" + res;
			}

		}
		res = "/" + res;

		return res;
	}

	public static void main(String[] args) {
		System.out.println(simplifyPath("/home/hu"));
		System.out.println(simplifyPath("/a/./b/../../c/"));

	}

}
