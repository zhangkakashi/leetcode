package longest.palindromic.substring;

public class LongestPalindromicSubstring {
	 public static String longestPalindrome(String s) {
	        if(s.length()<2){
	            return s;
	        }
	        int len = s.length();
	        String res = "";
	        for(int i=0;i<len;i++){
	            int l=i,r=i;
	            while(l>=0&&r<len&&s.charAt(l)==s.charAt(r)){
	                if(l>0&&s.charAt(l-1)==s.charAt(l)){
	                    l--;
	                }
	                if(r<len-1&&s.charAt(r+1)==s.charAt(r)){
	                    r++;
	                }
	                l--;
	                r++;
	            }
	            System.out.println(l+"  "+r);
	            String temp = s.substring(l+1,r);
	            if(temp.length()>res.length()){
	                res = temp;
	            }
	        }
	        return res;
	    }
	public static void main(String[] args) {
		System.out.println(longestPalindrome("bb"));

	}

}
