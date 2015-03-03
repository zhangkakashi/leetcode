package compare.version.numbers;

public class CompareVersionNumbers {

	public static int compareVersion(String version1, String version2) {
		int a = 0, b = 0;
		
		while(a>=0||b>=0){
			a = version1.indexOf(".");
			b = version2.indexOf(".");
//			if(a>0&&b>0){
//				if(a>b){
//					return 1;
//				}else if(a<b){
//					return -1;
//				}
//			}
			
			//System.out.println("sign1");
			System.out.println(version1 + "||"+version2);
			int n1=0,n2=0;
			if(a>0){
				n1 = Integer.parseInt(version1.substring(0,a));
				version1 = version1.substring(a+1,version1.length());
			}else{
				n1 = Integer.parseInt(version1);
				version1 = "0";
			}
			
			if(b>0){
				n2 = Integer.parseInt(version2.substring(0,b));
				version2 = version2.substring(b+1,version2.length());
			}else{
				n2 = Integer.parseInt(version2);
				version2 = "0";
			}
			if(n1>n2){
				return 1;
			}else if(n1<n2){
				return -1;
			}
			
//			if(a==-1&&b>0){
//				return -1;
//			}else if(a>0&&b==-1){
//				return 1;
//			}else if(a==-1&&b==-1){
//				return 0;
//			}
		}
		
		
		
		
		
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(compareVersion("1.0", "1"));

	}

}
