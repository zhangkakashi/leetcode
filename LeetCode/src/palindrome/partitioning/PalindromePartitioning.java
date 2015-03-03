package palindrome.partitioning;

import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {

	public List<List<String>> partition(String s) {
        if(s==null||s.length()<1){
            return ls;
        }
        dfs(s, new LinkedList<String>());
        return ls;
    }
    
    private void dfs(String s, List<String> l1){
    	System.out.println(s.length());
        if(s.length()<1){
        	ls.add(l1);
            return;
        }
        if(s.length()==1){
            List<String> l = new LinkedList<String>(l1);
            l.add(s);
            ls.add(l);
            return ;
        }
        for(int i=1;i<=s.length();i++){
            if(check(s.substring(0,i))){
                List<String> l = new LinkedList<String>(l1);
                l.add(s.substring(0,i));
                System.out.println(s.substring(0,i));
                dfs(s.substring(i,s.length()), l);
            }
        }
    }
    
    List<List<String>> ls = new LinkedList<List<String>>();
    private boolean check(String s){
        if(s==null||s.length()<2){
            return true;
        }
        int i = 0, j=s.length()-1;
        while(j>i){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
	public static void main(String[] args) {
		PalindromePartitioning p = new PalindromePartitioning();
		System.out.println(p.partition("bb"));

	}

}
