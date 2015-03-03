package trapping.rain.water;

import java.util.Stack;

public class TrappingRainWater {
	public static int trap(int[] A) {
        if(A==null||A.length<2){
            return 0;
        }
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        int max = 0;
        for(int i=0;i<A.length;i++){
            if(A[i]>=max){
                s1.push(i);
                max = A[i];
            }
        }
        max = 0;
        for(int i=A.length-1;i>=0;i--){
            if(A[i]>=max){
                s2.push(i);
                max = A[i];
            }
        }
        int res = 0;
        //System.out.println(s1);
        //System.out.println(s2);
        int tempA = s1.peek();
        //System.out.println(s1);
        do{
        	int temp = s1.pop();
            
            if(!s1.isEmpty()&&temp!=s1.peek()){
            	//System.out.println(temp+"  " + s1.peek());
                int peak = s1.peek();
                for(int i=temp-1;i>peak;i--){
                	//System.out.println(A[peak]-A[i]);
                    res = res + (A[peak]-A[i]);
                }
            }
            //System.out.println("s1");
        }while(!s1.isEmpty());
        //System.out.println(res);
        //System.out.println(s2);
        while(s2.peek()<tempA){
        	s2.pop();
        }
        while(!s2.isEmpty()){
            int temp = s2.pop();
            if(!s2.isEmpty()&&temp!=s2.peek()){
            	System.out.println(temp+"  " + s2.peek());
                int peak = s2.peek();
                for(int i=temp+1;i<peak;i++){
                    res = res + (A[peak]-A[i]);
                }
            }
            //System.out.println(s2);
        }
        
        return res;
    }
	public static void main(String[] args){
		//int[] A={4,2,3};
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		//int[] A={2,0,2};
		System.out.println(trap(A));
	}
}
