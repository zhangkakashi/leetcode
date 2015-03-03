package wordbreak;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	public static boolean wordBreak(String s, Set<String> dict) {
        if(dict==null||dict.size()<1||s==null||s.length()<1){
        	System.out.println("sign2");
            return false;
        }
        return doBreak(s, dict, 0);
    }
    
    private static boolean doBreak(String s, Set<String> dict, int j){
        boolean flag = false;
        for(int i=j+1;i<=s.length();i++){
            if(dict.contains(s.substring(j,i))){
            	System.out.println(s.substring(j,i));
                if(i==s.length()){
                    return true;
                }else{
                    flag = flag||doBreak(s, dict, i);
                }
            }
            if(flag){
                return true;
            }
        }
        return flag;
    }
	public static void main(String[] args) {
		String[] arr={};
		Set<String> set = new HashSet<String>();
		for(String s: arr ){
			set.add(s);
		}
		System.out.println(wordBreak("acaaaaabbbdbcccdcdaadcdccacbcccabbbbcdaaaaaadb", set));

	}

}
