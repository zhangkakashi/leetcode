package remove.duplicates.from.sorted.array.two;

public class RemoveDuplicatesFromSortedArrayTwo {

	static int [] number = {1,1,1,1,3,3};
	public static int removeDuplicates(int[] A) {
        if(A.length<3){
            return A.length;
        }
        int i=1;
        int count = 1;
        int sum = 1;
        boolean change = false;
        while(i<A.length){
            if(A[i]==A[i-1]){
                if(count==1){
                	if(change){
                		A[sum] = A[i];
                		
                	}
                    count++;
                    sum++;
                }else{
                    if(!change){
                    	change = true;
                    }
                }
            }else{
            	if(change){
            		A[sum] = A[i];
            		
            	}
                count=1;
                sum++;
            }
            i++;
        }
        return sum;
    }
	public static void main(String[] args) {
		System.out.println(removeDuplicates(number));
		for(int i:number){
			System.out.println(i);
		}

	}

}
