package mines;

import java.util.Random;

public class Mines {
	private int height, width, numMines;
	private boolean showAll = false;
	private static Random rand = new Random();
	
	private byte[][] board;
	// every element holds the number of mines surrounding them
	// as well as 3 flag bits
	private static final byte NUM = 0b00001111;
	private static final byte MINE = 0b00010000;
	private static final byte FLAGGED = 0b00100000;
	private static final byte OPENED = 0b01000000;
	
	
	public Mines(int height, int width, int numMines) {
		this.height = height;
		this.width = width;
		// initialize board
		board = new byte[height][width];
		// scatter mines
		while(this.numMines<numMines) {
			int i = rand.nextInt(height);
			int j = rand.nextInt(width);
			addMine(i,j);
		}
	}
	
	
	public boolean addMine(int i, int j) {
		if((board[i][j] & MINE) == 0) {
			// place a mine by turning on the MINE bit
			board[i][j] |= MINE;
			// update the neighbors mine count
			for (int x = Math.max(0, i-1); x<Math.min(i+2, height); x++)
			for (int y = Math.max(0, j-1); y<Math.min(j+2, width); y++)
			if(x != i || y != j) board[x][y]++;
			
			// update the board mine count
			numMines++;
			return true;
		}
		return false;
	}
	public boolean open(int i, int j) {
		if((board[i][j] & OPENED) == OPENED) {
			return true;
		}
		if((board[i][j] & MINE) == MINE) {
			return false;
		}
		// open the cell
		board[i][j] |= OPENED;
		// if the number of mines surrounding is 0, recursively open the neighbors
		if((board[i][j] & NUM) == 0) {
			for (int x = Math.max(0, i-1); x<Math.min(i+2, height); x++)
				for (int y = Math.max(0, j-1); y<Math.min(j+2, width); y++)
					if(x != i || y != j) open(x,y);
		}
		return true;

	}
	public void toggleFlag(int x, int y) {
		// exploiting XOR properties
		board[x][y] ^= FLAGGED;
	}
	public boolean isDone() {
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				// if a cell is neither opened nor a mine then the board is not done
				if((board[i][j] & ( MINE | OPENED )) == 0) return false;
		return true;
	}
	public String get(int i, int j) {
		// if a cell is opened or showAll is set to true
		if(showAll || (board[i][j] & OPENED) == OPENED) {
			if ((board[i][j] & MINE) == MINE) // if a cell is a mine
				return "X";
			// return string representation of the numeric value of the 4 LSB using the NUM mask
			return String.valueOf(((board[i][j]&NUM) == 0)?" ":(board[i][j]&NUM));
		}
		return ((board[i][j] & FLAGGED) == FLAGGED)?"F":".";
	}
	public void setShowAll(boolean showAll) {
		this.showAll = showAll;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				sb.append(get(i,j));
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
