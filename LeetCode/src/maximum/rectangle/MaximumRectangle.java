package maximum.rectangle;

import java.util.Stack;

public class MaximumRectangle {

	public int maximalRectangle(char[][] matrix) {
		int m = matrix.length;
		if(m<1){
			return 0;
		}
		int n = matrix[0].length;
		if(n<1){
			return 0;
		}
		int[] h = new int[n+1];
		int max = 0;
		for(int i=0;i<m;i++){
			Stack<Integer> s = new Stack<Integer>();
			for(int j=0;j<=n;j++){
			    if(j<n){
				if(matrix[i][j]=='1'){
					h[j]++;
				}else{
					h[j] = 0;
				}
			    }
				if(s.isEmpty()||h[j]>=h[s.peek()]){
					s.push(j);
				}else{
					while(!s.isEmpty()&&h[j]<h[s.peek()]){
						int start = s.pop();
						max = Math.max(max, h[start]*(s.isEmpty()?j:j-s.peek()-1));
					}
					s.push(j);
				}
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
