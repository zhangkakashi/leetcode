package wordbreak.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakTwo {

	public static List<String> wordBreak(String s, Set<String> dict) {
//        List<String> l = new ArrayList<String>();
//        if(s.length()==0||dict.size()==0){
//            return l;
//        }
//        doBreak( s, dict, "", l);
//        
//        return l;
		Map<Integer, List<String>> validMap = new HashMap<Integer, List<String>>();

        // initialize the valid values
        List<String> l = new ArrayList<String>();
        l.add("");
        validMap.put(s.length(), l);

        // generate solutions from the end
        for(int i = s.length() - 1; i >= 0; i--) {
            List<String> values = new ArrayList<String>();
            for(int j = i + 1; j <= s.length(); j++) {
                if (dict.contains(s.substring(i, j))) {
                    for(String word : validMap.get(j)) {
                    	//System.out.println(s.substring(i, j) + (word.isEmpty() ? "" : " ") + word);
                        values.add(s.substring(i, j) + (word.isEmpty() ? "" : " ") + word);
                    }
                }
            }
            System.out.println(validMap);
            validMap.put(i, values);
        }
        System.out.println(validMap);
        return validMap.get(0);
    }
    
    private static void doBreak(String s, Set<String> dict, String recent, List<String> l){
        for(int i=1;i<=s.length();i++){
            if(dict.contains(s.substring(0,i))){
                if(i==s.length()){
                    recent = recent+" "+ s.substring(0,i);
                    l.add(recent);
                    return;
                }
                System.out.println(s.substring(i,s.length()));
                doBreak(s.substring(i,s.length()), dict, recent+" "+ s.substring(0,i), l);
            }
        }
    }
	
	public static void main(String[] args) {
//		String [] ss = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
//		Set<String> set = new HashSet<String>();
//		for(String s:ss){
//			set.add(s);
//		}
//		
//		System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaa",set));
		
		String [] ss = {"cat", "cats", "and", "sand", "dog"};
		Set<String> set = new HashSet<String>();
		for(String s:ss){
			set.add(s);
		}
		
		System.out.println(wordBreak("catsanddog",set));

	}

}
