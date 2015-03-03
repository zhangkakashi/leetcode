package ladder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	static Map<String, Integer> m = new HashMap<String, Integer>();
    public static int ladderLength(String start, String end, Set<String> dict) {
        if(start.equals(end)){
            return 1;
        }
        
        m.put(start,1);
        Queue<String> q = new LinkedList<String>();
        q.add(start);
        
        while(!q.isEmpty()){
            String word = q.poll();
            if(word.equals(end)){
                return m.get(word);
            }
            System.out.println("sign1");
            
            
            for(int i=0;i<word.length();i++){
            	char[] temp = word.toCharArray();
                for(char j='a';j<='z';j++){
                    if(j==temp[i]){
                        continue;
                    }
                    temp[i] = j;
                    String newWord = new String(temp);
                    System.out.println(newWord);
                    if(!m.containsKey(newWord)&&(dict.contains(newWord)||newWord.equals(end))){
                    	System.out.println("sign2");
                    	m.put(newWord, m.get(word)+1);
                        q.add(newWord);
                    }
                }
            }
            
        }
        System.out.println(m);
        return m.get(end);
        
    }
	public static void main(String[] args) {
		String[] ss = {"a","b","c"};
		Set<String> set = new HashSet<String>();
		for(String s: ss){
			set.add(s);
		}
		
		System.out.println(ladderLength("a","c",set));
		
	}

}
