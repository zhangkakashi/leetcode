package threesum.closest;

import java.util.Arrays;

public class ThreeSumClosest {
	public static int threeSumClosest(int[] num, int target) {
        if(num.length<3){
            return 0;
        }
        Arrays.sort(num);
        int res = Integer.MAX_VALUE-1;
        System.out.println("sing1");
        for(int i=0;i<num.length-2;i++){
            int s = i+1, e = num.length-1;
            System.out.println("sing2");
            while(e>s){
                int temp = num[i]+num[s]+num[e];
                if(temp==target){
                	System.out.println("sing3");
                    return target;
                }else {
                	System.out.println(Math.abs(target-temp)+"  "+Math.abs(target-res));
                    if(Math.abs(target-temp)<Math.abs(target-res)){
                    	
                        res = temp;
                    }
                    
                    if(temp>target){
                    	System.out.println("sing5");
                        e--;
                    }else{
                    	System.out.println("sing6");
                        s++;
                    }
                }
            }
            
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		int[] num={-3,-2,-5,3,-4};
		System.out.println(threeSumClosest(num, -1));
	}
}
