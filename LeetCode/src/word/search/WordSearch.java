package word.search;

public class WordSearch {
	public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        if(word.length()<1||word.length()>m*n){
            return false;
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(word.charAt(0)==board[i][j]){
                    boolean[][] check = new boolean[m][n];
                    System.out.println(i+"  " + j);
                    boolean toCheck = check(board, check,i, j,0 , word);
                    if(toCheck){
                        return true;
                    }
                }
            }
        }
        
        return false;
        
        
        
    }
    
    private static boolean check(char[][] board, boolean[][] check, int x, int y, int j, String w){
    	//System.out.println(w.length()==j);
    	if(j>=w.length()){
            return true;
        }
    	
        if(x>=board.length||x<0||y>=board[0].length||y<0||check[x][y]){
        	/*System.out.println("board  " + board.length+"  " + board[0].length);
        	System.out.println("return  " + x+"  " + y);
        	System.out.println();
        	System.out.println();*/
            return false;
        }
        
        System.out.println(x+"  " + y + "  "+board[x][y]+"    " + j + "  " + w.charAt(j));
        
        char temp = w.charAt(j);
        //System.out.println(temp==board[x][y]);
        if(temp==board[x][y]){
            check[x][y] = true;
            boolean c1 = check(board, check, x-1, y, j+1, w);
            if(c1){
            	System.out.println("sign1");
                return c1;
            }
            c1 = check(board, check, x, y-1, j+1, w);
            if(c1){
            	System.out.println("sign2");
                return c1;
            }
            c1 = check(board, check, x, y+1, j+1, w);
            if(c1){
            	System.out.println("sign3");
                return c1;
            }
            c1 = check(board, check, x+1, y, j+1, w);
            check[x][y] = false;
            return c1;
//            return check(board, check, x-1, y, j+1, w)||
//            		check(board, check, x, y-1, j+1, w)||
//            		check(board, check, x, y+1, j+1, w)||
//            		check(board, check, x+1, y, j+1, w);
        }else{
        	System.out.println("sign4");
            return false;
        }
        
    }
	public static void main(String[] args) {
		char[][] board = {"ABCE".toCharArray(),
				          "SFES".toCharArray(),
				          "ADEE".toCharArray()};
		System.out.println(exist(board, "ABCESEEEFS"));

	}

}
