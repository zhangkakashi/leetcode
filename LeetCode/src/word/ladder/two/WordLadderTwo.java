package word.ladder.two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadderTwo {

	
	    //记录每个单词所在的层数
	    static HashMap<String,Integer> path = new HashMap<String,Integer>();
	    //bfs生成path
	    static void bfs(String start, String end, HashSet<String> dict) {
	        Queue<String> queue = new LinkedList<String>();
	        queue.add(start);
	        path.put(start,0);
	        String current;
	        while(!queue.isEmpty()) {
	            current = (String)queue.poll();
	            if(current==end) {
	                continue;
	            }
	            for(int i=0;i<current.length();i++) {
	                char[] strCharArr = current.toCharArray();
	                for(char ch='a';ch<='z';ch++) {
	                    if(strCharArr[i]==ch) {
	                        continue;
	                    }
	                    strCharArr[i] = ch;
	                    String newWord = new String(strCharArr);
	                    if(newWord.equals(end)==true||dict.contains(newWord)) {
	                        //每个单词在path中只能出现一次，也就是每个单词只能出现在一层中，这样就很巧妙的解决了环的问题。
				if(path.get(newWord)==null) {
	                            int depth = (int)path.get(current);
	                            path.put(newWord,depth + 1);
	                            queue.add(newWord);
	                        }
	                    }
	                }
	            }
	        }
	        System.out.println(path);
	    }
	    //从目标单词往回找开始单词，记录所有路径
	    static void dfs(String start, String end, HashSet<String> dict, ArrayList<String> pathArray,ArrayList<ArrayList<String>> result) {
	        //找到了，需要reverse加入的所有单词
		if(start.equals(end)==true) {
	            pathArray.add(start);
	            Collections.reverse(pathArray);
	            result.add(pathArray);
	            return;
	        }
	        if(path.get(start)==null) {
	            return;
	        }
	        pathArray.add(start);
	        int nextDepth = (int)path.get(start) - 1;
	        for(int i=0;i<start.length();i++) {
	            char[] strCharArr = start.toCharArray();
	            for(char ch='a';ch<='z';ch++) {
	                if(strCharArr[i]==ch) {
	                    continue;
	                }
	                strCharArr[i] = ch;
	                String newWord = new String(strCharArr);
			//只相差一个字母同时这个单词所在的层数也是当前单词的上一层
	                if(path.get(newWord)!=null&&(path.get(newWord)==nextDepth)) {
	                    ArrayList<String> newPathArray = new ArrayList<String>(pathArray);
	                    dfs(newWord,end,dict,newPathArray,result);
	                }
	            }
	        }
	    }
	    
	    public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
	        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
	        ArrayList<String> path = new ArrayList<String>();
	        if(start==null||end==null||start.length()!=end.length()) {
	            return result;
	        }
	        bfs(start, end, dict);
	        dfs(end,start, dict, path, result);
	        return result;
	    }
	

	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("hot");
		hs.add("dot");
		hs.add("dog");
		hs.add("lot");
		hs.add("log");
		//hs.add("hit");
		System.out.println(findLadders("hit","cog",hs));
	}

}
