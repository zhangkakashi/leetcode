package text.justification;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	public static List<String> fullJustify(String[] words, int L) {
		List<String> l = new ArrayList<String>();
        if(words.length<1){
            return l;
        }
        for(int i=0;i<words.length;){
            if(words[i].length()>L){
                l.add(words[i]);
                i++;
            }else{
                String s = words[i];
                //System.out.println(s);
                int now = i;
                int len = s.length();
                i++;
                //System.out.println("first->"+i);
                
                //System.out.println(len+words[i].length()+1<=L);
                while(i<words.length&&len+words[i].length()+1<=L){
                	
                    len = len+words[i].length()+1;
                    i++;
                    
                }
                //System.out.println(len);
                
                //System.out.println("last---->"+i);
                
                
                if(i==now+1){
                    for(int j=0;j<L-len;j++){
                        s +=" ";
                    }
                    l.add(s);
                }else if(len==L){
                    for(int j=now+1;j<i;j++){
                        s = s + " " + words[j];
                    }
                    l.add(s);
                }else if(len<L){
                	//System.out.println("sing1");
                    if(i<words.length){
                    	//System.out.println("sing2");
                    int dis = L-len;
                    int space = i-now -1;
                    int each = dis/space;
                    int more = dis%space;
                    for(int j=now+1;j<i;j++){
                        for(int k=0;k<each;k++){
                            s=s+" ";
                        }
                        if(more>0){
                            s=s+" ";
                            more--;
                        }
                        s = s+" " + words[j];
                    }
                    l.add(s);
                    }else {
                    	//System.out.println(len+1);
                        if(len<=L){
                            for(int j=now+1;j<i;j++){
                               s = s + " " + words[j];
                            }
                            int temp = s.length();
                            for(int j=0;j<L-temp;j++){
                            	s=s+" ";
                            }
                            l.add(s);
                        }else{
                        	int dis = L-len;
                            int space = i-now -1;
                            int each = dis/space;
                            int more = dis%space;
                            for(int j=now+1;j<i-1;j++){
                                for(int k=0;k<each;k++){
                                    s=s+" ";
                                }
                                if(more>0){
                                    s=s+" ";
                                    more--;
                                }
                                s = s+" " + words[j];
                            }
                            l.add(s);
                            s = words[i-1];
                            for(int j=0;j<L-words[i-1].length();j++){
                                s +=" ";
                            }
                            l.add(s);
                        }
                    }
                }
            }
        }
        return l;
    }
	public static void main(String[] args) {
		String[] ss = {"What","must","be","shall","be."};
		System.out.println(fullJustify(ss, 12));

	}

}
