package game;

public class TicTacToe extends Game{
	// a class that represents a tic-tac-toe game
	public TicTacToe(String player1, String player2) {
		super(3, 3, new Player(player1,'X'), new Player(player2,'O'));
	}
	
	@Override
	protected boolean doesWin(int i, int j) {
		// the condition to win is to make a 3 in a row
		return maxLineContaining(i, j) == 3;
	}
}
