package kmp;

public class KMP {

	public static int[] getNext(String pattern){
		int[] next = new int[pattern.length()];
        int k = -1;
        int j = 0;
        next[0] = -1;

        while(j < pattern.length() - 1){
            if(-1 == k || pattern.charAt(j) == pattern.charAt(k)){
                k++;
                j++;
                if(pattern.charAt(j) == pattern.charAt(k)){
                    next[j] = next[k];
                }
                else{
                    next[j] = k;
                }
            }
            else{
                k = next[k];
            }
        }
        return next;
    }
	public static void main(String[] args) {
		String s = "abaaaabxbxbc";
		int[] num = getNext(s);
		System.out.print(" ");
		for(int i=0;i<s.length();i++){
			System.out.print(s.charAt(i)+" ");
		}
		System.out.println();
		for(int i:num){
			System.out.print(i+" ");
		}

	}

}
