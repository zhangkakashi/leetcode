package multiply.strings;

public class MultiplyStrings {

	public static String multiply(String num1, String num2) {
		if(num1.equals("0")||num2.equals("0")){
			return "0";
		}
		int l = num2.length()-1;
		int zero = 0;
		String res = "";
//		for(int i=l;i>=0;i--){
//			String temp = mulChar(num1, num2.charAt(i));
//			while(zero>0){
//				temp = temp + "0";
//				zero--;
//			}
//			zero = l-i+1;
//			//System.out.println(temp);
//			res = add(temp, res);
//		}
		for(int i=0;i<l+1;i++){
			//System.out.println(i+ "----->" +res);
			String temp = mulChar(num1, num2.charAt(i));
			//System.out.println(i+ "----->" + "mulChar(num1, num2.charAt(i))");
			res = res+"0";
			//System.out.println("temp->" + temp + "    res->"+res);
			res = add(temp, res);
			//System.out.println(i+ "----->" + "add(temp, res)");
		}
		return res;
	}

	
	private static String mulChar(String c1, char c2){
		//int n1 = Integer.parseInt(c1);
		if(c2=='0'){
			return "0";
		}
		int n = Integer.parseInt(c2+"");
		int l = c1.length()-1;
		String res = "";
		int j = 0;
		while(l>=0){
			int n1 = Integer.parseInt(c1.charAt(l)+"");
			int temp = n1 * n+j;
			j=0;
			if(temp>=10){
				j=temp/10;
				temp = temp%10;
			}
			res = temp + res;
			l--;
		}
		if(j>0){
		res = j + res;}
		return res;
	}
	
	
	private static String add(String c1, String c2){
		if(c1.equals("0")){
			return c2;
		}else if(c2.equals("0")){
			return c1;
		}
		int l1 = c1.length()-1;
		int l2 = c2.length()-1;
		String res = "";
		int j = 0;
		while(l1>=0&&l2>=0){
			int n1 = Integer.parseInt(c1.charAt(l1)+"");
			int n2 = Integer.parseInt(c2.charAt(l2)+"");
			int cur = n1 + n2 + j;
			j = 0;
			if(cur>=10){
				j=1;
				cur = cur%10;
			}
			//System.out.println("cur->"+cur);
			res = cur + res;
			l1--;
			l2--;
		}
		//System.out.println(1);
		//System.out.println("l1->" + l1 + "   l2->" + l2);
		if(l1>=0){
			while(j==1&&l1>=0){
				int cur = Integer.parseInt(c1.charAt(l1)+"") + j;
				j=0;
				if(cur>=10){
					j=1;
					cur = cur%10;
				}
				res = cur + res;
				l1--;
			}
			if(j==1&&l1<0){
				res = 1 + res;
			}else{
				res = c1.substring(0, l1+1) + res;
			}
			//System.out.println(2);
		}else if(l2>=0){
			//System.out.println(1);
			while(j==1&&l2>=0){
				int cur = Integer.parseInt(c2.charAt(l2)+"") + j;
				j=0;
				if(cur>=10){
					j=1;
					cur = cur%10;
				}
				res = cur + res;
				l2--;
			}
			//System.out.println(2);
			if(j==1&&l2<0){
				res = 1 + res;
			}else{
				res = c2.substring(0, l2+1) + res;
			}//System.out.println(3);
		}else{
			if(j==1){
				res = 1 + res;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		//System.out.println(add("24", "90"));
		//System.out.println(mulChar("11", '2'));
		//System.out.println(multiply("3", "38"));
		System.out.println(multiply("9369162965141127216164882458728854782080715827760307787224298083754", "7204554941577564438"));
	}

}
