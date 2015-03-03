package largest.rectangle.in.histogram;

public class LargestRevtangleInHistogram2 {
	public static int largestRectangleArea(int[] height) {
		int area = 0;  
		  java.util.Stack<Integer> stack = new java.util.Stack<Integer>();  
		  for (int i = 0; i < height.length; ) {  
		    if (stack.empty() || height[stack.peek()] <= height[i]) {  
		      stack.push(i++);  
		    } else {  
		    	System.out.println("stack: " + stack + " " + i);
		      int start = stack.pop();  
		      int width = stack.empty() ? i : i - stack.peek() - 1;  
		      area = Math.max(area, height[start] * width);  
		      System.out.println(area);
		      //i--;  
		    }  
		  }  
		  while (!stack.empty()) {  
		    int start = stack.pop();  
		    int width = stack.empty() ? height.length : height.length - stack.peek() - 1;  
		    area = Math.max(area, height[start] * width);        
		  }  
		  return area; 
    }
	public static void main(String[] args) {
		int [] area = {14,15,13,12,15,16};
		System.out.println(largestRectangleArea(area));

	}

}
