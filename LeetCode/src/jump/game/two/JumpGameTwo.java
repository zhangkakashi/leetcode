package jump.game.two;

public class JumpGameTwo {

	public int jump(int[] A) {
        if(A.length<1){
            return 0;
        }
        int step = 0;
        int max = A[0];
        int last = 0;
        for(int i=1;i<A.length;i++){
            if(last<i){
                step++;
                last = max;
                if(last>=A.length-1){
                    return step;
                }
            }
            max = Math.max(max, A[i]+i);
            if(max<=i){
                return -1;
            }
        }
        return step;
    }

}
