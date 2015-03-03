package palindrome.number;

public class PalindromeNumber {
	public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        if(x<10&&x>=0){
            return true;
        }
        
        int high = 1;
        while(x/high>=10){
            high *= 10;
        }
        int low = 10;
        while(high>=low){
        	//System.out.println(high);
        	//System.out.println(x/high/10%10 + "  " + (x%low/(low/10)));
            if(x/high%10 == x%low/(low/10)){
                high /= 10;
                low *= 10;
                //System.out.println(1);
            }else{
                return false;
            }
        }
        return true;
    }
	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(1410110141));
		System.out.println(isPalindrome(21));
		System.out.println(isPalindrome(111));
		System.out.println(isPalindrome(10));
		

	}

}
