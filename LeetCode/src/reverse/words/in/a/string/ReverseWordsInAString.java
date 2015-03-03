package reverse.words.in.a.string;

public class ReverseWordsInAString {

	/**
	 * @param args
	 */
	
	public static String reverseWords(String s) {
		if(s.equals("")){
			return "";
		}
		String word = "";
		String res = "";
		
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==' '){
				if(!word.equals("")&&!res.equals("")){
					res = word + " " + res;
					word = "";
				}
				if(!word.equals("")&&res.equals("")){
					res = word;
					word = "";
				}
				if(!word.equals("")){
					res = word + " " + res;
					word = "";
				}
			}else{
				word = word + s.charAt(i);
			}
		}
		if(!word.equals("")&&!res.equals("")){
		    res = word + " " + res;
		}
		if(res.equals("")&&!word.equals("")){
		    res = word;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWords(" rewerg ewrkgwerjoi0e9r 0w e90riw 9"));
	}

}
