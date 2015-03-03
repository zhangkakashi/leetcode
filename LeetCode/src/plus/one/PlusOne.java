package plus.one;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		
        int l = digits.length-1;
        int overflow = 0;
        digits[l] = digits[l]+1;
        while(l>=0){
            if(digits[l]+overflow>9){
                digits[l] = (digits[l]+overflow)%10;
                overflow = 1;
                l--;
            }else{
            	//System.out.println(digits[l]);
                digits[l] = digits[l] + overflow;
                
                return digits;
            }
        }
        int[] newD = new int[digits.length+1];
        //System.out.println(newD.length);
        newD[0] = 1;
        for(int i=0;i<digits.length;i++){
            newD[i+1] = digits[i];
        }
        
        return newD;
    }
	public static void main(String [] args){
		int[] arr = {9,9,9};
		PlusOne p = new PlusOne();
		for(int i: p.plusOne(arr)){
			System.out.println(i);
		}
	} 
}
