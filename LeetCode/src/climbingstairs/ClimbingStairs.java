package climbingstairs;

public class ClimbingStairs {

	public static int climbStairs(int n) {
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }else{
            //return climbStairs(n-1) + climbStairs(n-2);
            int c1=1;
            int c2=2;
            for(int i=3;i<=n;i++){
                c2 = c1 + c2;
                c1 = c2 - c1;
            }
            return c2;
        }
    }
	
	public static void main(String[] args) {
		System.out.println(climbStairs(3));
		
	}

}
