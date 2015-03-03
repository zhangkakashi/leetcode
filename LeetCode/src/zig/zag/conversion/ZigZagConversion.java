package zig.zag.conversion;

public class ZigZagConversion {
	public static String convert(String s, int nRows) {
        if(s.length()<1||nRows>s.length()||nRows<2){
            return s;
        }
        
        String res = "";
        boolean flag = true;
        int dis = 2*nRows - 2;
        int len = s.length();
        //System.out.println(dis);
        for(int i=0;i<nRows;i++){
            if(i==0||i==(nRows-1)){
                int j = i;
                while(j<len){
                    res = res + s.charAt(j);
                    j+=dis;
                } 
            }else{
                int j=i;
                while(j<len){
                	
                    res = res+s.charAt(j);
                    if(flag){
                        j = j+(dis-2*i);
                        flag = !flag;
                    }else{
                        j = j + 2*i;
                        flag = !flag;
                    }
                    System.out.println(j);
                }
                flag = true;
            }
        }
        return res;
    }
	public static void main(String[] args) {
		System.out.println(convert("ABCDE", 4));

	}

}
