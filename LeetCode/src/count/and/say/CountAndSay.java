package count.and.say;

public class CountAndSay {
	public static String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String s = "1";
        for(int i=2;i<=n;i++){
            String temp = "";
            int j=0;
            int count = 0;
            char now = ' ';
            while(j<s.length()){
                if(s.charAt(j)!=now){
                    if(count!=0){
                        temp = temp+count+now;
                    }
                    count = 1;
                    now = s.charAt(j);
                    j++;
                }else{
                    count++;
                    j++;
                }
            }
            temp = temp+count+now;
            s = temp;
        }
        return s;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
