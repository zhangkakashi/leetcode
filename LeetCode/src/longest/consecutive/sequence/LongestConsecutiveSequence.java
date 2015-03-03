package longest.consecutive.sequence;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
        int res = 0;
        if(num.length<1){
            return res;
        }
        
        Map<Integer, Object> m = new HashMap<Integer, Object>();
        for(int i=0;i<num.length;i++){
            m.put(num[i],null);
        }
        for(int i=0;i<num.length;i++){
            if(!m.containsKey(num[i])){continue;}
            m.remove(num[i]);
            int count = 1;
            int temp = num[i];
            while(m.containsKey(temp-1)){
                
                temp--;
                count++;
                m.remove(temp);
            }
            temp = num[i];
            while(m.containsKey(temp+1)){
                
                temp++;
                count++;
                m.remove(temp);
            }
            if(count>res){
                res = count;
            }
        }
        return res;
    }
}
