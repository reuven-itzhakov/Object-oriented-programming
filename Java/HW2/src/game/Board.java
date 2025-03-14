package game;

public class Board {
	// a class that represents a game board
	protected Player[][] board;
	protected int n,m;
	public Board(int n, int m) {
		board = new Player[n][m];
		this.n=n;
		this.m=m;
	}
	protected boolean set(int i, int j, Player p) {
		// check if the coordinates are in bounds
		if(!inBounds(i, j))
			return false;
		// check if there is no player on the coordinates
		if(!isEmpty(i, j))
			return false;
		// assign the player to the coordinates
		board[i][j]=p;
		return true;
	}
	public boolean isEmpty(int i, int j) {
		return board[i][j] == null;
	}
	public Player get(int i, int j) {
		// if the coordinates not in bound - return null
		// else return the player in that coordinates
		if(!inBounds(i, j))
			return null;
		return board[i][j];
	}
	public boolean isFull() {
		// go through the board and check if there is
		// an empty place
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(isEmpty(i, j))
					return false;
			}
		}
		return true;
	}
	public String toString() {
		// using StringBuilder to get the string of the board
		StringBuilder sb =new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(isEmpty(i, j))
					sb.append('.');
				else
					sb.append(board[i][j].getMark());
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	protected int maxLineContaining(int i, int j) {
		// check the amount of marks in a row for every direction
		int horizontal = rayLength(i, j, 0, -1) + rayLength(i, j, 0, 1);
		int vertical = rayLength(i, j, -1, 0) + rayLength(i, j, 1, 0);
		int diag = rayLength(i, j, -1, -1) + rayLength(i, j, 1, 1);
		int backdiag = rayLength(i, j, -1, 1) + rayLength(i, j, 1, -1);
		
		// get the maximum between the horizontal and vertical
		// and the diagonal and back-diagonal
		int maxRook = Math.max(horizontal, vertical);
		int maxBishop = Math.max(diag, backdiag);
		
		// return the maximum of them and increasing
		// by 1 because of the center that didn't counted
		return 1 + Math.max(maxBishop,maxRook);
	}
	
	private boolean inBounds(int i, int j) {
		// check if the coordinates is in bounds
		return 0<=i && i<n && 0<=j && j<m;
	}
	
	private int rayLength(int x,int y,int dx,int dy) {
		// return the number of mark in a row of the same player
		// in specific direction
		Player p = get(x, y);
		if(p==null)
			return 0;
		int ret=0;
		while(inBounds(x+dx,y+dy)) {
			x+=dx;
			y+=dy;
			ret += (get(x, y) == p) ? 1 : 0;
			if (get(x, y) != p) break;
		}
		return ret;
	}
}
