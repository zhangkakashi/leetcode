package edit.distance;

public class EditDistance {

	public int minDistance(String word1, String word2) {
        if(word1.equals(word2)){
            return 0;
        }
        
        int l1 = word1.length();
        int l2 = word2.length();
        if(l1==0){
            return l2;
        }else if(l2 ==0){
            return l1;
        }
        
        int [][] dp = new int[l1+1][l2+1];
        for(int i=1;i<=l1;i++){
            dp[i][0] = i;
        }
        for(int i=1;i<=l2;i++){
            dp[0][i] = i;
        }
        
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1],dp[i-1][j]))+1;
                }
            }
        }
        
        return dp[l1][l2];
         
    }
	public static void main(String[] args) {
		
	}

}
