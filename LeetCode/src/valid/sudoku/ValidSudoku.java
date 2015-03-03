package valid.sudoku;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {
	public static boolean isValidSudoku(char[][] board) {
        Map<Integer, Object> m = new HashMap<Integer, Object>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                	
                    if(m.containsKey(board[i][j]+0)){
                    	System.out.println("false1");
                        return false;
                    }else{
                        m.put(board[i][j]+0, null);
                    }
                }
                
            }
            
            m.clear();
        }
        
        for(int i=0;i<board[0].length;i++){
            for(int j=0;j<board.length;j++){
                if(board[j][i]!='.'){
                	
                    if(m.containsKey(board[j][i]+0)){
                    	System.out.println("false2");
                        return false;
                    }else{
                        m.put(board[j][i]+0, null);
                    }
                }
                
            }
            
            //System.out.println();
            //System.out.println();
            m.clear();
        }
        
        for(int k=0;k<9;k++){
            for(int i=k%3*3;i<k%3*3+3;i++){
                for(int j=k/3*3;j<k/3*3+3;j++){
                	//System.out.println(i+" "+j);
                    if(board[i][j]!='.'){
                    	
                    if(m.containsKey(board[i][j]+0)){
                    	//System.out.println("false3");
                        return false;
                    }else{
                        m.put(board[i][j]+0, null);
                    }
                }
                }
            }
            m.clear();
            //System.out.println("--------------------------");
        }
        
        
        
        return true;
    }
	public static void main(String[] args) {
		String [] str = {".9..4....",
				"1.....6..",
				"..3......",
				".........",
				"...7.....",
				"3...5....",
				"..7..4...",
				".........",
				"....7...."};
		char[][] board = new char[9][9];
		for(int i=0;i<9;i++){
			board[i] = str[i].toCharArray();
		}
//		char[][] board = {"..4...63.".toCharArray(),
//				          ".........".toCharArray(),
//				          "5......9.".toCharArray(),
//				          "...56....".toCharArray(),
//				          "4.3.....1".toCharArray(),
//				          "...7.....".toCharArray(),
//				          "...5.....".toCharArray(),
//				          ".........".toCharArray(),
//				          ".........".toCharArray()};

		System.out.println(isValidSudoku(board));
	}

}
