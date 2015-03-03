package longest.substring.withoout.repeating.characters;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()<1){
            return 0;
        }
        int res = 0;
        Map<String, Integer> m = new HashMap<String, Integer>();
        int first = 0;
        for(int i=0;i<s.length();i++){
           if(m.containsKey(s.charAt(i)+"")){
        	
        	   int loc = m.get(s.charAt(i)+"");
        	    if(loc>=first){
        		   res = Math.max(res, i-first);
        		   first = loc+1;
        		   //System.out.println("sign1->"+i);
        	   }
           }
           m.put(s.charAt(i)+"", i);
         
        }
        res = Math.max(res, s.length()-first);
        //System.out.println(res);
        return res;
//		int n = s.length();
//        if (n == 0) return 0;
//
//        int start = 0;
//        int max = 0;
//        Map<Character, Integer> lastSeens = new HashMap<Character, Integer>();
//        for (int i = 0; i < n; i++) {
//            Integer lastSeen = lastSeens.get(s.charAt(i));
//
//            if (lastSeen != null)  {
//                if (lastSeen >= start) {
//                    max = Math.max(max, i - start);
//                    start = lastSeen + 1;
//                }
//            }
//            lastSeens.put(s.charAt(i), i);
//        }
//        max = Math.max(max, n - start);
//
//        return max;
    }
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));

	}

}
