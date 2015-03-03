package foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourSum {

	public static List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> ls = new ArrayList<List<Integer>>();
        if(num.length<4){
            return ls;
        }
        Arrays.sort(num);
        Map<Integer, List<Integer>> m = new HashMap<Integer, List<Integer>>();
        for(int i=0;i<num.length-3;i++){
        	if(i>0&&num[i]==num[i-1]){
        		continue;
        	}
        	for(int j=i+1;j<num.length-2;j++){
        		if(j>(i+1)&&num[j]==num[j-1]){
        			continue;
        		}
        		int sum = num[i]+num[j];
        		if(!m.containsKey(target-sum)){
        			List<Integer> l = new ArrayList<Integer>();
        			l.add(i);
        			l.add(j);
        			m.put(target-sum, l);
        		}else{
        			m.get(target-sum).add(i);
        			m.get(target-sum).add(j);
        		}
        	}
        }
        System.out.println(m);
        for(int i=num.length-1;i>=3;i--){
        	if(i<num.length-1&&num[i]==num[i+1]){
        		continue;
        	}
        	for(int j=i-1;j>=2;j--){
        		if(j<i-1&&num[j]==num[j+1]){
        			continue;
        		}
        		
        		int sum = num[i]+num[j];
        		
        		System.out.println("sum->"+sum + "  num[i]->"+num[i]+"   num[j]->"+num[j]);
        		if(m.containsKey(sum)){
        			List<Integer> temp = m.get(sum);
        			
        			for(int k=1;k<temp.size();k=k+2){
        				if(sum==1){
            				System.out.println(i+"-"+num[i]+"  "+j+"-"+ num[j]);
            				System.out.println(temp.get(k));
            			}
        				if(j>temp.get(k)){
        					
        					List<Integer> l = new ArrayList<Integer>();
        					
        					l.add(num[temp.get(k-1)]);
        					l.add(num[temp.get(k)]);
        					
        					l.add(num[j]);
        					l.add(num[i]);
        					ls.add(l);
        				}
        			}
        		}
        	}
        }
        
        return ls;
    }
	public static void main(String[] args) {
		//int [] num = {-4,-3,-2,-1,0,0,1,2,3,4};
		int [] num = {-1,2,2,-5,0,-1,4};
		System.out.println(fourSum(num, 3));

	}

}
