package palindrome.partitioning.two;

public class PalindromePartitioningTwo {
	public int minCut(String s) {
        if(s.length()<2){
            return 0;
        }
        int len = s.length();
        int [] res = new int[len+1];
        for(int i=0;i<=len;i++){
            res[len-i] = i;
        }
        
        boolean [][] rout = new boolean[len][len];
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(s.charAt(i)==s.charAt(j)&&(j-i<2||rout[i+1][j-1])){
                    rout[i][j] = true;
                    res[i] = Math.min(res[i],res[j+1]+1);
                }
            }
        }
        return res[0]-1;
    }
}
