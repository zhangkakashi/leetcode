package triangle;

import java.util.List;
import java.util.Stack;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==1){
            return triangle.get(0).get(0);
        }
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=1;i<triangle.size();i++){
            for(int j=0;j<triangle.get(i).size();j++){
                if(j==0){
                    triangle.get(i).set(j,triangle.get(i-1).get(j) + triangle.get(i).get(j));
                }else if(j==triangle.get(i).size()-1){
                    triangle.get(i).set(j,triangle.get(i-1).get(j-1) + triangle.get(i).get(j));
                }else{
                    triangle.get(i).set(j,Math.min((triangle.get(i-1).get(j-1) + triangle.get(i).get(j)), triangle.get(i-1).get(j) + triangle.get(i).get(j)));
                }
                if(i==triangle.size()-1){
                    if(stack.isEmpty()||triangle.get(i).get(j)<stack.peek()){
                        stack.push(triangle.get(i).get(j));
                    }
                }
            }
        }
        return stack.peek();
        
    }
}
