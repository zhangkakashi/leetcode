package permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//http://blog.csdn.net/tuantuanls/article/details/8717262
public class Permutations {

	static List<List<Integer>> ls = new ArrayList<List<Integer>>();
    static public List<List<Integer>> permute(int[] num) {
        if(num.length<1){
            return ls;
        }
        Arrays.sort(num);
        List<Integer> l = new ArrayList<Integer>();
        for(int i: num){
            l.add(i);
        }
        if(l.size()==1){
            ls.add(l);
            return ls;
        }
        ls.add(new ArrayList<Integer>(l));
        //System.out.println(ls);
        int r = l.size()-2;
        
        while(r>=0){
        	System.out.println("sign->" + 1);
            while(r>=0&&l.get(r)>l.get(r+1)){
                r--;
            }
            System.out.println("sign->" + 2);
            if(r>=0){
                int length = l.size()-1;
                while(l.get(r)>l.get(length)){
                    length--;
                }
                
                int temp = l.get(r);
                l.set(r, l.get(length));
                l.set(length, temp);
                reverse(l,r+1, l.size()-1);
                System.out.println("sign->" + 4);
                List<Integer> l1 = new ArrayList<Integer>(l);
                System.out.println(ls);
                System.out.println(l1);
                ls.add(l1);
                System.out.println(ls);
                r = l.size()-2;
                //System.out.println(r);
            }
            System.out.println("sign->" + 3);
        }
        return ls;
    }
    
    private static void reverse(List<Integer> list, int l, int r){
        while(r>l){
            int temp = list.get(r);
            list.set(r, list.get(l));
            list.set(l, temp);
            r--;
            l++;
        }
    }
	public static void main(String[] args) {
		int []num = {1,2,3};
		System.out.println(permute(num) );

	}

}
