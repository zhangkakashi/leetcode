package test;

public class ReverseString {

	public static String reverse(String s, int i){
		if(i==0){
			return s.charAt(i)+"";
		}
		return s.charAt(i)+reverse(s,i-1);
	}
	public static void main(String[] args) {
		System.out.println(reverse("1234", 3));

	}

}
