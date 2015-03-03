package insert.interval;

import java.util.ArrayList;
import java.util.List;

class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	      public String toString(){
	    	  return "[" + start + ", " + end + "]";
	      }
	  }
public class InsertInterval {

	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(newInterval==null){
            return intervals;
        }
        if(intervals == null||intervals.size()<1){
            List<Interval> l1 = new ArrayList<Interval>();
            l1.add(newInterval);
            return l1;
        }
        
        int l = 0;
        int r = intervals.size()-1;
        int llocation = -1;
        boolean lflag = false;
        boolean rflag = false;
        if(newInterval.end<intervals.get(0).start){
            List<Interval> l1 = new ArrayList<Interval>();
            l1.add(newInterval);
            for(int i=0;i<r+1;i++){
                l1.add(intervals.get(i));
            }
            return l1;
        }
        
        
        for(int i=0;i<intervals.size();i++){
            if((newInterval.start<intervals.get(i).end)&&!lflag){
                intervals.get(i).start = Math.min(intervals.get(i).start, newInterval.start);
                System.out.println(4);
                if(newInterval.end<intervals.get(i).end){
                	System.out.println(3);
                    return intervals;
                }
                lflag = true;
                llocation = i;
                
            }
            System.out.println("lflag->" + lflag + "  intervals.get(i).end->"+ intervals.get(i).end + "  i->"+i+"  llocation->"+llocation);
            if(lflag&&newInterval.end>intervals.get(i).end&&i!=llocation){
            	System.out.println(intervals.get(i));
                intervals.remove(i);
                i--;
            }else if(newInterval.end>intervals.get(i).end&&(i+1)>=intervals.size()&&i==llocation){
            	intervals.get(llocation).end = newInterval.end;
            	System.out.println(2);
                return intervals;
            }else if(newInterval.end<=intervals.get(i).end){
                if(intervals.get(i).start>newInterval.end){
                    intervals.get(llocation).end = newInterval.end;
                    System.out.println(5);
                    return intervals;
                }else {
                	System.out.println(1);
                    intervals.get(llocation).end = intervals.get(i).end;
                    intervals.remove(i);
                    return intervals;
                
                }
            }
        }
        System.out.println(6);
        if(!lflag){
        intervals.add(newInterval);
        }else{
        	intervals.get(llocation).end = newInterval.end;
        }
        return intervals;
    }
	
	public static void main(String[] args) {
		List<Interval> l = new ArrayList<Interval>();
		l.add(new Interval(1,5));
		//l.add(new Interval(2,8));
		//l.add(new Interval(9,12));
		System.out.println(insert(l, new Interval(6,8)) );

	}

}
