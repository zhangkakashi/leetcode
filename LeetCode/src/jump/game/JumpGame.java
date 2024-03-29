package jump.game;

public class JumpGame {
	
	public static boolean canJump(int[] A) {
        if(A.length<2){
            return true;
        }
        if(A[0]<=0){
            return false;
        }
        return check(A, A.length-1);
        
    }
    
    private static boolean check(int[] A, int last){
        if(last<1){
            return true;
        }
        boolean res = false;
        for(int i=last-1;i>=0;i--){
            if(A[i]>=last-i){
                res = res||check(A, i);
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] A = {2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6};
		System.out.println(canJump(A));
	}
}
