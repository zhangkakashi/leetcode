package word.ladder.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderTwo2 {

	static Map<String, Integer> m = new HashMap<String, Integer>();
	static List<List<String>> ls = new ArrayList<List<String>>();
    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
        if(dict==null||dict.isEmpty()){
            return ls;
        }
        if(start.equals(end)){
            List<String> l = new ArrayList<String>();
            l.add(start);
            l.add(end);
            ls.add(l);
            return ls;
        }
        m.put(start, 0);
        bfs(start,end,dict);
        List<String> l = new ArrayList<String>();
        l.add(start);
        dfs(start,end,l,0);
        return ls;
        
    }
    
    private static void bfs(String start, String end, Set<String> dict){
        
        Queue<String> q = new LinkedList<String>();
        q.add(start);
        boolean isEnd = false;
        while(!q.isEmpty()){
            String temp = q.poll();
            for(int i=0;i<temp.length();i++){
                
                for(char j='a';j<='z';j++){
                    char[] ct = temp.toCharArray();
                    if(j==ct[i]){
                        continue;
                    }
                    ct[i] = j;
                    String word = new String(ct);
                    if(word.equals(end)||dict.contains(word)&&(!m.containsKey(word))){
                        m.put(word,m.get(temp)+1);
                        if(word.equals(end)){
                            isEnd = true;
                        }
                        if(!isEnd){
                            q.add(word);
                        }
                    }
                }
            }
        }
    }
    
    private static void dfs(String start, String end, List<String> l,int step){
        if(start.equals(end)){
            ls.add(l);
            return;
        }
        for(int i=0;i<start.length();i++){
            for(char j='a';j<='z';j++){
                char[] temp = start.toCharArray();
                if(j==temp[i]){
                    continue;
                }
                temp[i]=j;
                String word = new String(temp);
                if(m.containsKey(word)&&m.get(word)==step+1){
                    List<String> l1 = new ArrayList<String>(l);
                    l1.add(word);
                    dfs(word,end,l1,step+1);
                }
            }
        }
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
        System.out.println(m);
	}

}
