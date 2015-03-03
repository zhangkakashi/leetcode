package largest.rectangle.in.histogram;

public class LargestRevtangleInHistogram {
	public static int largestRectangleArea(int[] height) {
        if(height.length<1){
            return 0;
        }
        int max = 0;
        for(int i=0;i<height.length;i++){
        	int m = i-1;
            int n = i+1;
            int area = height[i];
            int temp = height[i];
            while(m>=0&&height[m]>temp){
                area += temp;
                m--;
            }
            while(n<height.length&&height[n]>=temp){
                area += temp;
                if(height[n]==temp){
                    i = n+1;
                }
                n++;
                
            }
            if(area>max){
                max = area;
            }
            //System.out.println(1);
        }
        return max;
    }
	public static void main(String[] args) {
		int [] area = {};
		System.out.println(largestRectangleArea(area));

	}

}
