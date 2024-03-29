package string;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if((l1<=0&&l2<=0&&l3<=0)){
            return true;
        }
        if(l1+l2!=l3){
            return false;
        }
        
        boolean[][] dp = new boolean[l1+1][l2+1];
        
        for(int i=1;i<=l1;i++){
            if(s1.charAt(i-1)==s3.charAt(i-1)){
                dp[i][0] = true;
            }
        }
        
        for(int i=1;i<=l2;i++){
            if(s2.charAt(i-1)==s3.charAt(i-1)){
                dp[0][i] = true;
            }
        }
        
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                int k = i + j;
                if(s1.charAt(i-1)==s3.charAt(k-1)){
                    dp[i][j] = dp[i][j]||dp[i-1][j];
                }
                if(s2.charAt(j-1)==s3.charAt(k-1)){
                    dp[i][j] = dp[i][j]||dp[i][j-1];
                }
            }
        }
        return dp[l1][l2];
    }
}
