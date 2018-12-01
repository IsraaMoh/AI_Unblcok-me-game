
package board;
public class par {
	public char id;
	public int col;
	public int row;
	public int len;
	public String Ori;
	par(char i,int r,int c,int l,String o){
		id=i;
		col=c;
		row=r;
		len=l;
		Ori=o;
	}
	public boolean advOk(char [][] board){
		if(Ori.equals("H")){
			if(col+len>=board[0].length || board[row][col+len]!=' ')
				return false;
		}
		else{
			if(row-1<0 || board[row-1][col]!=' ')
				return false;
		}
		return true;	
	}
	public boolean whtOk(char [][] board){
		if(Ori.equals("H")){
			if(col-1<0 || board[row][col-1]!=' ')
				return false;
		}
		else{
			if(row+len>=board.length || board[row+len][col]!=' ')
				return false;
		}
		return true;	
	}
	public void move(String dir){
		if(Ori.equals("H")){
			if(dir.equals("+"))
				col++;
			else 
				col--;
		}
		else{
			if(dir.equals("+"))
				row--;
			else 
				row++;
		}
	}
}