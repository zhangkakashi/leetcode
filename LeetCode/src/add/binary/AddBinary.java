package add.binary;

public class AddBinary {
	public static String addBinary(String a, String b) {
        int n = a.length()-1;
        int m = b.length()-1;
        if(n<0){
            return b;
        }
        if(m<0){
            return a;
        }
        if(m>n){
            int temp1 = n;
            n=m;
            m=temp1;
            String temps=a;
            a=b;
            b=temps;
        }
        
        String res = "";
        int temp = 0;
        while(n>=0){
            if(m>=0){
                int sum = temp+(a.charAt(n)-48)+(b.charAt(m)-48);
                res = sum%2+res;
                temp = sum/2;
                m--;
                n--;
            }else{
                int sum = temp+(a.charAt(n)-48);
                res = sum%2+res;
                temp = sum/2;
                n--;
            }
        }
        if(temp>0){
            res = 1+res;
        }
        return res;
    }
	public static void main(String[] args) {
		System.out.println(addBinary("1","11"));
		System.out.println(addBinary("11","11"));
		System.out.println(addBinary("11","1"));
		System.out.println(addBinary("1","10"));
		System.out.println(addBinary("1","1"));
		System.out.println(addBinary("1","1111111"));

	}

}
