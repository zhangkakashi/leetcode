package spiral.matrix.two;

public class SpiralMatrixTwo {
	public static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        if(n<1){
        	return arr;
        }
        int num = n*n;
        int lvl = 0;
        int length = num+1;
        while(num>1){
        	
        	for(int i=lvl;i<(n-lvl-1);i++){
        		System.out.println(length-num);
        		arr[lvl][i]=length-num;
        		num--;
        	}
        	
        	for(int i=lvl;i<(n-lvl-1);i++){
        		arr[i][n-lvl-1]=length-num;
        		num--;
        	}
        	
        	for(int i=(n-lvl-1);i>lvl;i--){
        		arr[(n-lvl-1)][i]=length-num;
        		num--;
        	}
        	
        	for(int i=(n-lvl-1);i>lvl;i--){
        		arr[i][lvl]=length-num;
        		num--;
        	}
        	
        	lvl++;
        }
        if(num==1){
         arr[lvl][lvl] = length-num;
        }
        return arr;
    }
	
	public static void main(String[] args){
		int [][] arr = generateMatrix(2);
		
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
