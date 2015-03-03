package partitioning;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public static List<List<String>> partition(String s) {
        if(s.length()<1){
            return ls;
        }
        boolean[][] m = new boolean[s.length()][s.length()];
        getP(s,m);
        add(s,0,new ArrayList<String>(),m);
        
        
        return ls;
    }
    
    static List<List<String>> ls = new ArrayList<List<String>>();
    
    private static void add(String s, int j, List<String> l,boolean[][] m){
        
        for(int i=j;i<s.length();i++){
            if(m[j][i]){
                if(i==s.length()-1){
                    List<String> l1 = new ArrayList<String>(l);
                    l1.add(s.substring(j,i+1));
                    ls.add(l1);
                }else{
                    List<String> l1 = new ArrayList<String>(l);
                    l1.add(s.substring(j,i+1));
                    add(s, i+1, l1, m);
                }
            }
        }
    }
    
    
    private static void getP(String s, boolean[][] m){
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(i==j){
                    m[i][j] = true;
                }else{
                    if(s.charAt(i)==s.charAt(j)){
                        if(j==i+1||m[i+1][j-1]){
                            m[i][j]=true;
                        }
                    }
                }
            }
        }
    }
    
    private boolean isP(String s){
        int start = 0;
        int end = s.length()-1;
        while(end>start){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }else{
                start++;
                end--;
            }
        }
        return true;
    }
	public static void main(String[] args) {
		System.out.println(partition("aba"));

	}

}
