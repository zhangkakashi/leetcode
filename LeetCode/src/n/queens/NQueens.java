package n.queens;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	static List<String[]> res = new ArrayList<String[]>();
	static public List<String[]> solveNQueens(int n) {
        
        List<Boolean> l1 = new ArrayList<Boolean>();
        List<Boolean> l2 = new ArrayList<Boolean>();
        List<Boolean> l3 = new ArrayList<Boolean>();
        for(int i=0;i<n;i++){
            l1.add(true);
            l2.add(true);
            l3.add(true);
            if(i!=n-1){
            	l2.add(true);
                l3.add(true);
            }
        }
        //System.out.println(l3.size());
        solve(0, l1, l2, l3, new String[n]);
        return res;
    }
    
	static public void solve(int k, List<Boolean> l1, List<Boolean> l2, List<Boolean> l3, String[] ss ){
        int n = ss.length;
		for(int i=0;i<n;i++){
			//System.out.println((i)+" "+((k+i)/2)+" "+(n-k+i));
            if(l1.get(i)&&l3.get(k+i)&&l2.get(n-k+i-1)){
                
                String s = "";
                for(int j=0;j<n;j++){
                    if(j==i){
                        s = s+'Q';
                    }else{
                        s += '.';
                    }
                }
                ss[k] = s;
                if(k==n-1){
                    res.add(ss);
                }else{
                    List<Boolean> c1 = new ArrayList<Boolean>(l1);
                    List<Boolean> c2 = new ArrayList<Boolean>(l2);
                    List<Boolean> c3 = new ArrayList<Boolean>(l3);
                    c1.set(i,false);
                    c2.set(n-k+i-1,false);
                    c3.set(k+i,false);
                    String[] s2 = ss.clone();
                    solve(k+1,c1,c2,c3,s2);
                }
            }
        }
    }
	public static void main(String[] args) {
		List<String[]> l = solveNQueens(8);
		for(int i=0;i<l.size();i++){
			for(String s:l.get(i)){
				System.out.println(s);
			}
			System.out.println();
			//System.out.println();
			//System.out.println();
		}
		System.out.println(l.size());

	}

}
