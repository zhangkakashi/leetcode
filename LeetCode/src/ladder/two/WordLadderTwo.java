package ladder.two;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class WordLadderTwo {

	static Map<String, Integer> path = new HashMap<String, Integer>();
	
	private static void bfs(String start, String end, Set<String> s){
		
		int step = 0;
		path.put(start, step);
		if(start.equals(end)){
			return;
			
		}
		Queue<String> q = new LinkedList<String>();
		q.add(start);
		while(!q.isEmpty()){
			String current = q.poll();
//			if(current.equals("dot")){
//				System.out.println( path.get(current));
//			}
			for(int i=0;i<current.length();i++){
				
				for(int j='a';j<='z';j++){
					char[] temp = current.toCharArray();
					if(j==temp[i]){
						continue;
					}
					temp[i] = (char) j;
					String newWord = new String(temp);
					
					if(!path.containsKey(newWord)&&(s.contains(newWord)||newWord.equals(end))){
						path.put(newWord, path.get(current)+1);
						q.add(newWord);
					}
					
				}
			}
		}
	}
	
	public static void dfs(String start, String end, List<String> l){
		l.add(start);
		if(start.equals(end)){
			ls.add(l);
			return;
		}
		//System.out.println(1);
		for(int i=0;i<start.length();i++){
			
			for(int j='a';j<='z';j++){
				char [] temp = start.toCharArray();
				if(j==temp[i]){
					continue;
				}
				temp[i] = (char) j;
				//System.out.println(path);
				String next = new String(temp);
				//System.out.println(next);
				if(path.containsKey(next)&&path.get(next)==(path.get(start)+1)){
					//System.out.println(2);
					dfs(next,end,new ArrayList<String>(l));
				}
				
			}
		}
		
	}
	
	static List<List<String>> ls = new ArrayList<List<String>>();
	
    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
        if(start.equals(end)){
        	List<String> l = new ArrayList<String>();
        	l.add(end);
        	ls.add(l);
        	return ls;
        }
    	if(dict.isEmpty()||dict.size()<1){
        	return ls;
        }
    	bfs(start,end, dict);
    	dfs(start, end, new ArrayList<String>());
    	return ls;
    }
	public static void main(String[] args) {
		Set<String> s = new HashSet<String>();
//		s.add("hot");
//		s.add("dot");
//		s.add("dog");
//		s.add("lot");
//		s.add("log");
		String [] ss = {"dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"};
		//s.addAll(arg0).addAll(Collections<String>ss);
		for(String str: ss){
			s.add(str);
		}
		//bfs("hit", "cog", s);
		
		System.out.println(findLadders("nape", "mild", s));
        System.out.println(path);
	}

}
