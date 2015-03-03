package decode.ways;

public class DecodeWays {
	public static int numDecodings(String s) {
		if(s==null||s.length()<1||s.charAt(0)=='0'){
            return 0;
        }
        int n1 = 1, n2 = 1;
        
        
        
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='0'){
                if(s.charAt(i-1)=='0'){
                    return 0;
                }
                n1=0;
            }
        	if(((s.charAt(i-1)=='1')||(s.charAt(i-1)=='2'&&s.charAt(i)<='6'))){
                n1 = n1 + n2;
                n2 = n1 - n2;
            }else{
                n2 = n1;
            }
        }
        return n1;
    }
	public static void main(String[] args) {
		System.out.println(numDecodings("110"));
		System.out.println(numDecodings("026123"));

	}

}
