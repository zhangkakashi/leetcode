package regular.expression.matching;

public class RegularExpressionMatching {
	public static boolean isMatch(String s, String p) {
		if(s.equals(p)){
			return true;
		}
		int l1 = s.length();
		int l2 = p.length();
		int i1=0,i2=0;
		while(i1<l1&&i2<l2){
			if(p.charAt(i2)=='.'){
				i1++;
				i2++;
				continue;
			}
			if(i2>0&&p.charAt(i2)=='*'){
//				if(p.charAt(i2-1)!=s.charAt(i1)&&p.charAt(i2-1)!='.'){
//					if(l2-i2>1&&p.charAt(i2+1)==s.charAt(i1)){
//						i2++;
//						continue;
//					}else{
//					i1++;
//					}
//				}
				if(s.charAt(i1)==s.charAt(i1-1)){
					i1++;
				}else{
//					if(p.charAt(i2-1)!=s.charAt(i1)){
//						i2++;
//					}else 
						if(p.charAt(i2-1)=='.'){
						i1++;
					}else if(i2==l2-1){
						return false;
					}else{
						i2++;
					}
				}
			}else if(s.charAt(i1)==p.charAt(i2)){
				i1++;
				i2++;
			}else if(s.charAt(i1)!=p.charAt(i2)&&i2<l2-1&&p.charAt(i2+1)=='*'){
				i2 = i2+2;
			}else{
				return false;
			}
		}
		
		if(i1<l1){
			return false;
		}
		
		if(i2<l2){
			if(l2-i2>1){
				return false;
			}
			if(p.charAt(i2)!='*'){
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isMatch("",""));
		System.out.println(isMatch("aa","a"));
		System.out.println(isMatch("aa","aa"));
		System.out.println(isMatch("aaa","aa"));
		System.out.println(isMatch("aa", "a*"));
		System.out.println(isMatch("aa", ".*"));
		System.out.println(isMatch("ab", ".*"));
		System.out.println(isMatch("aab", "c*a*b"));
		System.out.println(isMatch("ab", ".*c"));
		System.out.println(isMatch("aaa", "a*a"));
	}

}
