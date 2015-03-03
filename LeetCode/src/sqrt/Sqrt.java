package sqrt;

public class Sqrt {

	private static int sqrt(int x) {
	    if (x == 0) return 0;
	    double last = 0;
	    double res = 1;
	    while (res != last)
	    {
	        last = res;
	        res = (res + x / res) / 2;
	        System.out.println("last->"+last);
	        System.out.println("res->"+res);
	    }
	    return (int) res;
	}
	
	public static void main(String[] args) {
		System.out.println(sqrt(100001));

	}

}
