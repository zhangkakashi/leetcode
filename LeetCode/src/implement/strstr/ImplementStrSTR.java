package implement.strstr;

public class ImplementStrSTR {

	public static int strStr(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();
        if(h<1){
            return -1;
        }
        if(n<1){
            return 0;
        }
        
        int temp = 0;
        int j=0,i=0;
        while(temp<=h-n){
            i=temp;
            j=0;
            System.out.println(temp);
            while(i<h&&j<n&&haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }
            if(j==n){
                return temp;
            }
            temp++;
        }
        return -1;
    }
	public static void main(String[] args) {
		System.out.println(strStr("a", "a"));

	}

}
