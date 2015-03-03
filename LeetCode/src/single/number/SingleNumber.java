package single.number;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

	/**
	 * @param args
	 */

	public static int singleNumber(int[] A) {
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for(int i:A){
			if(!m.containsKey(i)){
				m.put(i, 1);
			}else{
				m.remove(i);
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(2^3^2);

	}

}
