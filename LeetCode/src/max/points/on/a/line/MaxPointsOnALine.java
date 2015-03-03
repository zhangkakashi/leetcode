package max.points.on.a.line;

import java.util.HashMap;
import java.util.Map;

class Point {
	      int x;
	      int y;
	      Point() { x = 0; y = 0; }
	      Point(int a, int b) { x = a; y = b; }
	  }

public class MaxPointsOnALine {

	public static int maxPoints(Point[] points) {
		if(points.length<3){
            return points.length;
        }
        
        int max=1;
        for(int i=0;i<points.length-1;i++){
            int tmax = 0;
            int same = 0;
            Map<Double, Integer> m = new HashMap<Double, Integer>();
            for(int j=0;j<points.length;j++){
                if((points[i].y==points[j].y)&&(points[i].x==points[j].x)){
                    same++;
                    continue;
                }
                double k = (points[i].y-points[j].y)*1.0/(points[i].x-points[j].x);
                if(m.containsKey(k)){
                    int cur = m.get(k)+1;
                    m.put(k, cur);
                    
                    if(cur>tmax){
                        tmax = cur;
                    }
                    System.out.println(tmax);
                }else{
                    m.put(k,1);
                    if(tmax<1){
                        tmax++;
                    }
                }
            }
            System.out.println("tmas->" + tmax + "  same->" + same);
            tmax = tmax+same;
            if(tmax>max){
                max = tmax;
            }
        }
        return max;
    }
	
	public static void main(String[] args) {
		Point p1 = new Point(0,0);
		Point p2 = new Point(1,1);
		Point p3 = new Point(1,-1);

		Point[] ps = {p1, p2, p3};
		System.out.println(maxPoints(ps));
		
	}

}
