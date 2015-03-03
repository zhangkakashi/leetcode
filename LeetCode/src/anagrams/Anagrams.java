package anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
	public List<String> anagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<String, List<String>>();
        List<String> l = new ArrayList<String>();
        
        for(String s: strs){
            String temp = sort(s);
            if(m.containsKey(temp)){
                m.get(temp).add(s);
            }else{
                List<String> l1 = new ArrayList<String>();
                l1.add(s);
                m.put(temp, l1);
            }
        }
        
        for(String s: m.keySet()){
            if(m.get(s).size()>1){
                for(String s1: m.get(s)){
                    l.add(s1);
                }
            }
        }
        return l;
        
    }
    
    private String sort(String s){
        if(s.length()<2){
            return s;
        }
        int mid = (s.length())/2;
        String s1 = sort(s.substring(0,mid));
        String s2 = sort(s.substring(mid,s.length()));
        return merge(s1,s2);
    }
    
    private String merge(String s1, String s2){
        if(s2.length()<1){
            return s1;
        }
        if(s1.length()<1){
            return s2;
        }
        
        String s = "";
        int i=s1.length()-1, j=s2.length()-1;
        while(i>=0&&j>=0){
            if(s1.charAt(i)>=s2.charAt(j)){
                s = s1.charAt(i)+s;
                i--;
            }else{
                s = s2.charAt(j)+s;
                j--;
            }
        }
        if(i>=0){
           while(i>=0){
             s = s1.charAt(i)+s;
                i--;  
           } 
        }
        
        if(j>=0){
            while(j>=0){
                s = s2.charAt(j)+s;
                j--;
            }
        }
        return s;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
