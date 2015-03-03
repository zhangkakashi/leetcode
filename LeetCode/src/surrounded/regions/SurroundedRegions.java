package surrounded.regions;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	static Queue<Integer> q = new LinkedList<Integer>();
	static int m, n;
    public static void solve(char[][] board) {
        m = board.length;
        if(m<3){
            return;
        }
        n = board[0].length;
        if(n<3){
            return;
        }
        
        for(int i=0;i<m;i++){
            traverse(i,0,board);
            traverse(i,n-1,board);
        }
        
        for(int i=1;i<n-1;i++){
            traverse(0,i,board);
            traverse(m-1,i,board);
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='Z'){
                    board[i][j]='O';
                }
            }
        }
        
    }
    
    private static void traverse(int x, int y, char[][] board){
        add(x,y,board,"a5");
        while(!q.isEmpty()){
            int num = q.poll();
            x = num/n;
            y = num%n;
            System.out.println(num);
            add(x,y-1,board,"a1");
            add(x,y+1,board,"a2");
            add(x-1,y,board,"a3");
            add(x+1,y,board,"a4");
            
        }
    }
    
    private static void add(int x, int y, char[][] board, String s){
        if(x>=0&&x<m&&y>=0&&y<n&&board[x][y]=='O'){
        	System.out.println(x+"  " + y + " " + s);
            board[x][y]='Z';
            q.add(x*n+y);
        }
    }
	public static void main(String[] args) {
		char[][] x = {"XOXOXO".toCharArray(),
				      "OXOXOX".toCharArray(),
				      "XOXOXO".toCharArray(),
				      "OXOXOX".toCharArray()};
		solve(x);
		for(int i=0;i<x.length;i++){
			for(int j=0;j<x[0].length;j++){
				System.out.print(x[i][j]);
			}
			System.out.println();
		}

	}

}
