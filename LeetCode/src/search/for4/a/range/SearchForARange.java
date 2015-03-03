package search.for4.a.range;

public class SearchForARange {
	public static int[] searchRange(int[] A, int target) {
		int[] res = {-1, -1};
        if(A==null||A.length<1){
            return res;
        }
        int s = 0;
        int e = A.length-1;
        while(e>=s){
            int mid = (s+e)/2;
            if(A[mid]==target){
                int x = mid;
                while(x-1>=0&&A[x-1]==target){
                    x--;
                }
                res[0] = x;
                x = mid; 
                while(x+1<=A.length-1&&A[x+1]==target){
                    x++;
                }
                res[1] = x;
                break;
            }
            else if(A[mid]<target){
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return res;
    }
	public static void main(String[] args){
		int[] A = {1,2,4,4,4,4,4,5};
		int[] num = searchRange(A, 4);
		for(int i: num){
			System.out.println(i);
		}
	}
}
