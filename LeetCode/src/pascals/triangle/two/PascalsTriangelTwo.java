package pascals.triangle.two;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangelTwo {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> l = new ArrayList<Integer>();
        if(rowIndex<0){
        	return l;
        }
        for(int i=0;i<=rowIndex;i++){
        	l.add(0,1);
        	for(int j=1;j<l.size()-1;j++){
        		l.set(j, l.get(j)+l.get(j+1));
        	}
        }
        return l;
    }
	public static void main(String[] args) {
		System.out.println(getRow(3));

		for(int i=0;i<10;i++){
			for(int j=0;j<10-i;j++){
				System.out.print("  ");
			}
			System.out.println(getRow(i));
		}
	}

}
