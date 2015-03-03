package pascals.triangle;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ls = new ArrayList<List<Integer>>();
        if(numRows<1){
            return ls;
        }
        
        for(int i=0;i<numRows;i++){
            List<Integer> l = new ArrayList<Integer>();
            for(int j=0;j<(i+1);j++){
                if(j==0||j==i){
                    l.add(1);
                }else{
                    l.add(ls.get(i-1).get(j-1)+ls.get(i-1).get(j));
                }
            }
            ls.add(l);
        }
        return ls;
    }
}
