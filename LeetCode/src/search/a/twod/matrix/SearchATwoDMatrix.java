package search.a.twod.matrix;

public class SearchATwoDMatrix {

	public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length<1){
            return false;
        }
        int first = 0;
        int last = matrix.length-1;
        int row = 0;
        if(last>0){
        while(last>first){
            int mid = (first + last) / 2;
            if(matrix[mid][0]==target){
                return true;
            }else if(matrix[mid][0]<target){
                first++;
            }else{
                last--;
            }
        }
        row = first-1;
        }
        first = 0;
        last = matrix[row].length-1;
        while(last>=first){
            int mid = (first + last) / 2;
            //System.out.println(matrix[row][mid]);
            if(matrix[row][mid]==target){
            	//System.out.println("sign->"+1);
                return true;
            }else if(matrix[row][mid]<target){
            	//System.out.println("sign->"+2);
                first++;
            }else{
            	//System.out.println("sign->"+3);
                last--;
            }
        }
        
        return false;
    }
	public static void main(String[] args) {
		//int [][] num = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		int [][] num = {{1,2,3}};
		System.out.println(searchMatrix(num,0));
	}

}
