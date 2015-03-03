package words.in.a.string;

public class ReverseWordsInAString {
	public String reverseWords(String s) {
        String res = "";
        
        int i = s.length()-1;
        int e = -1;
        int b = -1;
        while(i>=0){
            while(i>=0&&s.charAt(i)==' '){
                i--;
            }
            e = i;
            if(e<0){
                break;
            }
            while(i>=0&&s.charAt(i)!=' '){
                i--;
            }
            b = i;
            if(!res.equals("")){
                res  = res +" ";
            }
            if(e==b){
                res = res + s.charAt(b);
            }else{
            res = res + s.substring(b+1,e+1);
            }
            
        }
        
        return res;
    }
}
