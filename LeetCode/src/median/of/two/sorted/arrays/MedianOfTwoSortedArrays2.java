package median.of.two.sorted.arrays;

public class MedianOfTwoSortedArrays2 {
	public static double findMedianSortedArrays(int A[], int B[]) {
        int la = A.length;
        int lb = B.length;
        //if((la+lb)%2!=0){
        	
        if(la>lb){
        	System.out.println("sign1");
            return findMedianSortedArrays(B,A);
        }
        
        int k = (la+lb-1)/2;
        int l = 0, r = Math.min(k, la);
        while(r>l){
        	int mida = (l+r)/2;
        	int midb = k-mida;
        	if(A[mida]<B[midb]){
        		l = mida+1;
        	}else{
        		r = mida;
        	}
        }
        
        int a = Math.max(l > 0 ? A[l - 1] : Integer.MIN_VALUE, k - l >= 0 ? B[k - l] : Integer.MIN_VALUE);
        if (((la + lb) & 1) == 1)
            return (double) a;

        
        int b = Math.min(l < la ? A[l] : Integer.MAX_VALUE, k - l + 1 < lb ? B[k - l + 1] : Integer.MAX_VALUE);
        return (a + b) / 2.0;
    }
	public static void main(String[] args) {
		int[] A = {1};
		int[] B = {1,2,3,};
		System.out.println(findMedianSortedArrays( A, B));

	}

}
