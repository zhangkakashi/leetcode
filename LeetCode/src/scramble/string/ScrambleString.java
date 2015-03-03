package scramble.string;

public class ScrambleString {
	public static boolean isScramble(String s1, String s2) {
//		int l1 = s1.length();
//		int l2 = s2.length();
//		if(l1!=l2){
//			return false;
//		}
//		
//		boolean[][][] dp = new boolean[l1][l2][l1];
//		
//		for(int k=1; k<=l1;k++){
//			for(int i=0;i<=l1-k;i++){
//				for(int j=0;j<=l1-k;j++){
//					if(k==1){
//						dp[i][j][k] = s1.charAt(i)==s2.charAt(j);
//					}else{
//						for(int l=1;l<k;l++){
//							if((dp[i][j][l]&&dp[i+1][j+l][k-l])||(dp[i][j+k-1][l]&&dp[i+l][j][k-l])){
//								dp[i][j][k] = true;
//								break;
//							}
//						}
//					}
//				}
//			}
//		}
//		
//		
//		return dp[0][0][l1-1];
		
		
		
		int len = s1.length();
        if(len!=s2.length()){
            return false;
        }
        if(len==0){
            return true;
        }
        
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        boolean[][][] result = new boolean[len][len][len];
        for(int i=0;i<len;++i){
            for(int j=0;j<len;++j){
                result[0][i][j] = (c1[i]==c2[j]);
                System.out.print(result[0][i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
        for(int k=2;k<=len;++k){
            for(int i=len-k;i>=0;--i){
              for(int j=len-k;j>=0;--j){
                  boolean r = false;
                  for(int m=1;m<k && !r;++m){
                      r = (result[m-1][i][j] && result[k-m-1][i+m][j+m]) 
                    		  || (result[m-1][i][j+k-m] && result[k-m-1][i+m][j]);
                  }
                  result[k-1][i][j] = r;
                  
                  
              }
            }
            
        }
        
        
        for(int k=0;k<len;k++){
        	for(int x=0;x<len;x++){
          	  for(int y=0;y<len;y++){
          		  System.out.print(result[k][x][y] + " ");
          	  }
          	  System.out.println();
            }
        	System.out.println();
            System.out.println();
            System.out.println();
        }
        
        
        return result[len-1][0][0];
	}

	public static void main(String[] args) {
		System.out.println(isScramble("great", "rgtae"));

	}

}
