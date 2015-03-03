package spiral.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if(m<1){
            return new ArrayList<Integer>();
        }
        int n = matrix[0].length;
        if(n<1){
            return new ArrayList<Integer>();
        }
        List<Integer> l = new ArrayList<Integer>();
        if(m==1){
            for(int i=0;i<n;i++){
                l.add(matrix[0][i]);
            }
            return l;
        }else if(n==1){
            for(int i=0;i<m;i++){
                l.add(matrix[i][0]);
            }
            return l;
        }
        int lvl = Math.min(m,n);
        int j = 1;
        
        while(j<=lvl/2){
            for(int i=j-1;i<n-j;i++){
                l.add(matrix[j-1][i]);
            }
            for(int i=j-1;i<m-j;i++){
                l.add(matrix[i][n-j]);
            }
            for(int i=n-j;i>j-1;i--){
                l.add(matrix[m-j][i]);
            }
            for(int i=m-j;i>j-1;i--){
                l.add(matrix[i][j-1]);
            }
            j++;
        }
        if(lvl%2==1){
            //l.add(matrix[m/2][n/2]);
            if(lvl==m){
                for(int i=j-1;i<=n-j;i++){
                    l.add(matrix[m/2][i]);
                }
            }else if(lvl==n){
                for(int i=j-1;i<=m-j;i++){
                    l.add(matrix[i][n/2]);
                }
            }
        }
        return l;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
