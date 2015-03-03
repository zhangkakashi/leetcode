package threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> ls = new ArrayList<List<Integer>>();
        if(num.length<3){
            return ls;
        }
        Arrays.sort(num);
        int a=0, b=0, c=0;
        
        for(int i=0;i<num.length-2;i++){
            a=num[i];
            if(a>0){
                break;
            }
            if(i>0&&a==num[i-1]){
                continue;
            }
            System.out.println("sign->"+1);
            for(int j=i+1, k=num.length-1;k>j;){
                b=num[j];
                if(j>(i+1)&&b==num[j-1]){
                    j++;
                    continue;
                }
                c=num[k];
                if(k<(num.length-1)&&c==num[k+1]){
                    k--;
                    continue;
                }
                System.out.println("sign->"+2);
                if((a+b+c)==0){
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(a);
                    l.add(b);
                    l.add(c);
                    ls.add(l);
                    System.out.println("sign->"+3);
                    j++;
                }else if((a+b+c)<0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return ls;
    }
	public static void main(String[] args) {
		int [] num = {0, 0, 0};
		System.out.println(threeSum(num));

	}

}
