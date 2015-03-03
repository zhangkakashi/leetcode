package merge.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	      public String toString(){
	    	  return "["+start+","+end+"]";
	      }
	  }
public class MergeIntervals {
	public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> l = new ArrayList<Interval>();
        if(intervals.size()<1){
            return l;
        }
        
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start-b.start;
            }
        });
        
        int max = 0;
        for(int i=0;i<intervals.size();i++){
            if(l.size()==0){
                l.add(intervals.get(i));
                max = intervals.get(i).end;
            }else{
                if(intervals.get(i).start>max){
                	System.out.println("sign2");
                    l.add(intervals.get(i));
                    max = intervals.get(i).end;
                }else if(intervals.get(i).start<=max&&intervals.get(i).end>max){
                	System.out.println("sign1");
                    l.get(l.size()-1).end = intervals.get(i).end;
                    max = intervals.get(i).end;
                }else{
                	System.out.println("sign3");
                    continue;
                }
            }
        }
        return l;
    }
	public static void main(String[] args) {
		Interval[] in = {new Interval(2,3),new Interval(2,2),new Interval(3,3),new Interval(1,3),new Interval(5,7),new Interval(2,2),new Interval(4,6)};
		List<Interval> l = new ArrayList<Interval>();
		for(Interval i:in){
			l.add(i);
		}
		System.out.println(merge(l));
	}

}
