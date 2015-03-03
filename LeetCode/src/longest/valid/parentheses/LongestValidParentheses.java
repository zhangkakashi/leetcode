package longest.valid.parentheses;

import java.util.Stack;

public class LongestValidParentheses {

	public int longestValidParentheses(String s) {
        if(s.length()<2){
            return 0;
        }
        Stack<Integer> st = new Stack<Integer>();
        int max = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }else{
                if(!st.isEmpty()&&s.charAt(st.peek())=='('){
                    st.pop();
                    int cur = -1;//in case ()
                    if(!st.isEmpty()){
                        cur = st.peek();
                    }
                    cur = i-cur;
                    max = Math.max(max, cur);
                }else{
                    st.push(i);
                }
            }
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
