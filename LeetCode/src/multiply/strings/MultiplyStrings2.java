package multiply.strings;

public class MultiplyStrings2 {

	public static String multiply(String num1, String num2) {
		if(num1.equals("0")||num2.equals("0")){
			return "0";
		}
		int l1 = num1.length();
		int l2 = num2.length();
		int [] r = new int[l1+l2];
		int a=0;
		int b=0;
		int temp;
		for(int i=l1-1;i>=0;i--){
			
			for(int j=l2-1;j>=0;j--){
				int sum = Integer.parseInt(num1.charAt(i)+"")*Integer.parseInt(num2.charAt(j)+"");
				a = sum%10;
				b = sum/10;
				temp = r[i+j+1] + a;
				r[i+j+1] = temp%10;
				r[i+j] = r[i+j] + b + temp/10;
			}
			
		}
		String res = "";
		for(int i=0;i<r.length;i++){
			res = res + r[i];
		}
		
		return res;
	}

	
	
	
	public static void main(String[] args) {
		
		System.out.println(multiply("9369162965141127216164882458728854782080715827760307787224298083754", "7204554941577564438"));
	}

}
