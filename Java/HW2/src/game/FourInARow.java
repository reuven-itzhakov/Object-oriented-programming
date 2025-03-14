package game;

public class FourInARow extends Game{
	// a class that represents a four-in-a-row game
	
	// array of the current height for each column
	private int heights[];
	
	public FourInARow(String player1, String player2) {
		super(6, 7, new Player(player1,'W'), new Player(player2,'B'));
		heights = new int[7];
	}
			
	
	@Override
	protected boolean doesWin(int i, int j) {
		// you can win the game with more than 4 in a row
		// the maximum is 7 in a row.
		return super.maxLineContaining(i, j) >= 4;
	}
	
	@Override
	protected boolean onePlay(Player p) {
		int c,h;
		boolean setRet;
		do {
			System.out.printf("%s, please enter column: ",p.toString());
			c = s.nextInt();
			// get the height of the column
			h = heights[c];
			// decreasing the current height from the number of rows - 6 - [0-5]
			setRet = set(5-h,c,p);
			heights[c] += setRet? 1:0;
		} while (!setRet);
		return doesWin(5-h,c);
		
	}
}
