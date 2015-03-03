package set.matrix.zeros;

public class SetMatrixZeros {
	 public void setZeroes(int[][] matrix) {
	        int m = matrix.length;
	        int n = matrix[0].length;
	        boolean mz = false;
	        boolean nz = false;
	        for(int i=0;i<m;i++){
	            if(matrix[i][0]==0){
	                mz = true;
	                break;
	            }
	        }
	        for(int i=0;i<n;i++){
	            if(matrix[0][i]==0){
	                nz = true;
	                break;
	            }
	        }
	        
	        for(int i=1;i<m;i++){
	            for(int j=1;j<n;j++){
	                if(matrix[i][j]==0){
	                    matrix[i][0] = 0;
	                    matrix[0][j] = 0;
	                    continue;
	                }
	            }
	        }
	        
	        for(int i=1;i<m;i++){
	            if(matrix[i][0]==0){
	                for(int j=1;j<n;j++){
	                    matrix[i][j] = 0;
	                }
	            }
	        }
	        
	        for(int i=1;i<n;i++){
	            if(matrix[0][i]==0){
	                for(int j=1;j<m;j++){
	                    matrix[j][i] = 0;
	                }
	            }
	        }
	        
	        if(mz){
	            for(int i=0;i<m;i++){
	                matrix[i][0]=0;
	            }
	        }
	        if(nz){
	            for(int i=0;i<n;i++){
	                matrix[0][i]=0;
	            }
	        }
	    }
}
