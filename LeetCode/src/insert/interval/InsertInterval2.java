package insert.interval;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class InsertInterval2 {

	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(newInterval==null){
            return intervals;
        }
        if(intervals == null||intervals.size()<1){
            List<Interval> l1 = new ArrayList<Interval>();
            l1.add(newInterval);
            return l1;
        }
       
        
        int e = newInterval.end;
        int s = newInterval.start;
        //boolean flag = false;
        ListIterator<Interval> it = intervals.listIterator();
        while(it.hasNext()){
        	Interval in = it.next();
        	if(e<in.start){
        	    it.previous();
        	    it.add(new Interval(s, e));
        	    return intervals;
        	}
        	
        	if(s<=in.end){
        	    s = Math.min(s, in.start);
        	    e = Math.max(e, in.end);
        	    it.remove();
        	    System.out.println("s->"+s+"  e->"+e);
        	}
        }
        intervals.add(new Interval(s,e));
        return intervals;
    }
	
	public static void main(String[] args) {
		List<Interval> l = new ArrayList<Interval>();
		l.add(new Interval(1,5));
		//l.add(new Interval(2,7));
		//l.add(new Interval(17,18));
		//l.add(new Interval(9,12));
		System.out.println(insert(l, new Interval(5,7)) );

	}

}
