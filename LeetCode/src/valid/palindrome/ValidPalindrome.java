package valid.palindrome;

public class ValidPalindrome {

	public static boolean isPalindrome(String s) {
        int r = s.length()-1;
        if(r<1){
            return true;
        }
        boolean flag = true;
        String temp = s.toLowerCase();
        int l = 0;
        //int r = s.length()-1;
        while(r>l){
        	System.out.println("l->"+l+"  r->"+r);
            if(temp.charAt(l)==temp.charAt(r)){
                r--;
                l++;
            }else{
            	System.out.println("l->"+(temp.charAt(l))+"  r->"+(temp.charAt(r)));
                if(temp.charAt(l)<97&&temp.charAt(l)>122&&temp.charAt(l)<48&&temp.charAt(l)>57){
                    l++;
                    continue;
                }
                if((temp.charAt(r)<97&&temp.charAt(r)>122)&&(temp.charAt(r)<48&&temp.charAt(r)>57)){
                    r--;
                    
                    continue;
                }
                flag = false;
                break;
            }
            
        }
        
        
        
        
        return flag;
    }
	public static void main(String[] args) {
		System.out.println(isPalindrome("a.-"));

	}

}
