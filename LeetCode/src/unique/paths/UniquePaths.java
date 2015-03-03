package unique.paths;

public class UniquePaths {

	public static int uniquePaths(int m, int n) {
        int x = m+n-2;
        int y = m-1;
        
        int up=1;
        int down=1;
        int res = 1;
        for(int i=1;i<=y;i++){
            res = res*(x-y+i)/i;
        }
        int [] arr = new int [m+1];
        arr[0]=1;
        for(int i=0;i<n;i++){
        	for(int j=1;j<=m;j++){
        		arr[j] = arr[j-1]+arr[j];
        	}
        }
        //System.out.println(up);
        return arr[m];
    }
	
	public static void main(String[] args) {
		System.out.println(uniquePaths(36,7));

	}

}
