package factorial.trailing.zeroes;

public class FactorialTrailingZeroes {

	public static int trailingZeroes(int n) {

		int res = 0;
		if (n < 5) {
			return res;
		}
		int temp = 5;
		while (n>=temp&&Integer.MAX_VALUE/temp>=5) {
			res += n / temp;
			temp *= 5;
		}
		if(n>=temp+5){
			res++;
		}
		
		return res;
	}

	public static void main(String[] args) {
		System.out.println(trailingZeroes(1808548329));

	}

}
