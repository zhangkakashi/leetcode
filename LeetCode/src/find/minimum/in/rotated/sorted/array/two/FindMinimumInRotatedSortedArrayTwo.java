package find.minimum.in.rotated.sorted.array.two;

public class FindMinimumInRotatedSortedArrayTwo {
	public static  int findMin(int[] num) {
        if(num.length<1){
            return 0;
        }
        if(num.length==1){
            return num[0];
        }
        int l = 0;
        int r = num.length-1;
        
        while(r>l){
            if(num[r]==num[l]){
                l++;
                continue;
            }
            if(num[l]<num[r]){
                break;
            }
            int mid = (l+r)/2;
             if (num[mid] < num[l]) {  
                r = mid;  
            } else {  
                l = mid + 1;; 
            }  
        }
        return num[l];
    }
	
	public static void main(String[] args){
		int[] num = {3,1};
		System.out.println(findMin(num));
	}
}
