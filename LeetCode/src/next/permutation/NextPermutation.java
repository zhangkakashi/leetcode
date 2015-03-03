package next.permutation;

public class NextPermutation {

	public static void nextPermutation(int[] num) {
		
        if(num.length<2){
            return;
        }
        
        int r = num.length-2;
        while(r>=0&&num[r]>num[r+1]){
        	System.out.println("1");
            r--;
        }
        if(r==(num.length-2)){
        	reverse(num, r, num.length-1);
        	return;
        }
        System.out.println("r->"+r);
        if(r>=0){
            int n = num.length-1;
            while(num[r]>=num[n]){
            	System.out.println(2);
                n--;
            }
            System.out.println("n->"+n);
            int temp = num[n];
            num[n] = num[r];
            num[r] = temp;
            reverse(num, r+1, num.length-1);
        }else{System.out.println(4);
            reverse(num, 0, num.length-1);
        }
        
    }
    
    private static void reverse(int[] num, int l, int r){
        while(r>l){
            int temp = num[r];
            num[r] = num[l];
            num[l] = temp;
            r--;
            l++;
        }
    }
    
	public static void main(String[] args) {
		int[] num = { 1,5,1};
		nextPermutation(num);
		for(int n: num){
			System.out.println(n);
		}

	}

}
