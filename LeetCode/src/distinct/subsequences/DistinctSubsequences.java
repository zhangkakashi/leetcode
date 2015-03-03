package distinct.subsequences;

public class DistinctSubsequences {
	public static int numDistinct(String S, String T) {
        int n = S.length();
        int m = T.length();
        if(m>n||m<0||n<0){
            return 0;
        }
        
        int[] arr = new int[m+1];
        arr[0] = 1;
        for(int i=0;i<n;i++){
            for(int j=m-1;j>=0;j--){
                if(S.charAt(i)==T.charAt(j)){
                   arr[j+1] += arr[j]; 
                }
            }
            for(int x: arr){
            	System.out.print(x+" ");
            }
            System.out.println();
        }
        return arr[m];
    }
	
	public static void main(String[] args) {
		//System.out.println(numDistinct("", ""));
		System.out.println(numDistinct("rabbbit", "rabbit"));

	}
}
