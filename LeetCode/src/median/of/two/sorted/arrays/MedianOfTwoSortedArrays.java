package median.of.two.sorted.arrays;

public class MedianOfTwoSortedArrays {
	public static double findMedianSortedArrays(int A[], int B[]) {
        int la = A.length;
        int lb = B.length;
        if((la+lb)%2!=0){
        	System.out.println("sign4");
            return find(A, 0, B, 0, (la+lb+1)/2);
        }else{
        	System.out.println("sign5");
            return (find(A, 0, B, 0, (la+lb)/2)+find(A, 0, B, 0, (la+lb)/2+1))/2.0;
        }
    }
    
    private static double find(int A[], int as, int B[], int bs, int target){
        if(A.length>B.length){
        	System.out.println("sign1");
            return find(B,bs,A,as,target);
        }
        if(as==A.length){
        	System.out.println("sign2");
            return (double)B[target-1];
        }
        if(target==1){
        	System.out.println("sign3");
            return (double)Math.min(A[as],B[bs]);
        }
        
        int mida = Math.min(target/2, A.length);
        int midb = target - mida;
        System.out.println(mida+"  " + midb + "  " + target);
        if(A[mida-1]<B[midb-1]){
        	System.out.println("sign6");
            return find(A,mida,B,bs,target-mida);
        }else if(A[mida-1]>B[midb-1]){
        	System.out.println("sign7");
            return find(A,as,B,bs,target-midb);
        }else{
        	System.out.println("sign8");
            return (double)A[mida-1];
        }
        
    }
	public static void main(String[] args) {
		int[] A = {1,2,3,4};
		int[] B = {1,2,3,4};
		System.out.println(findMedianSortedArrays( A, B));

	}

}
