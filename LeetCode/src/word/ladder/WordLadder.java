package word.ladder;

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
        m.put(end,0);
        bfs(start, end, dict);
        
        return m.get(end);
    }
    
    private static void bfs(String start, String end, Set<String> dict){
        //boolean flag=false;
    	Queue<String> q = new LinkedList<String>();
    	q.add(start);
    	while(!q.isEmpty()){
    		String cur = q.poll();
    		for(int i=0;i<cur.length();i++){
                
                for(char j='a';j<='z';j++){
                    char[] arr = cur.toCharArray();
                    if(j==arr[i]){
                        continue;
                    }else{
                        arr[i] = j;
                        String newWord = new String(arr);
                        if(newWord.equals(end)){
                        	m.put(newWord, m.get(cur)+1);
                        	q.clear();
                        	break;
                        }
                        else if(!m.containsKey(newWord)&&(dict.contains(newWord))){
                            m.put(newWord, m.get(cur)+1);
                            q.add(newWord);
                            //System.out.println(newWord);
                        }
                    }
                }
            }
    	}
        
    }
    
	public static void main(String[] args) {
		String[] ar = {"a","b","c"};
		Set<String> set = new HashSet<String>();
		for(String s:ar){
			set.add(s);
		}
		System.out.println(ladderLength("a", "c", set));
		System.out.println(m);
	}

}
