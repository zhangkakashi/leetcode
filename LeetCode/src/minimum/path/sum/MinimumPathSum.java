package minimum.path.sum;

public class MinimumPathSum {

	public static int minPathSum(int[][] grid) {
		if(grid==null||grid.length==0||grid[0].length==0){
			return 0;
		}
		int[] res = new int[grid[0].length];
		res[0] = grid[0][0];
		for(int i=1;i<res.length;i++){
			res[i] = res[i-1] + grid[0][i];
		}
		for(int i=1;i<grid.length;i++){
			for(int j=0;j<res.length;j++){
				if(j==0){
					res[j] = res[j] + grid[i][j];
				}
				res[j] = Math.min(res[j], res[j-1]) + grid[i][j];
			}
		}
		
		return res[res.length-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
