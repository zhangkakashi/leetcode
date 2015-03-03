package sort.colors;

public class SortColors {

	/**
	 * @param args
	 */
	
	static int[] arr = {1, 0};
	
	public static void sortColors(int[] A) {
        if(A.length<=1){
            return;
        }
        int zero = 0; 
        int two = A.length-1;
        for(int i=0;i<=two;i++){
            if(A[i]==0){
            	System.out.println("A[zero] " + A[zero]);
            	System.out.println("A[i] " + A[i]);
                int temp = A[zero];
                A[zero] = A[i];
                A[i] = temp;
                
                zero++;
                
                for(int j: A)
            		System.out.println(j);
            }else if(A[i]==2){
                int temp = A[two];
                A[two] = A[i];
                A[i] = temp;
                two--;
                i--;
            }
        }
    }
	
	
	public static void main(String[] args) {
		sortColors(arr);
		for(int i: arr)
		System.out.println(i);

	}

}
