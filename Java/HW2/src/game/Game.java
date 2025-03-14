package game;

import java.util.Scanner;

public class Game extends Board{
	// a class that represents a game
	protected Player[] players;
	protected Scanner s;
	
	public Game(int n, int m, Player p1, Player p2) {
		super(n, m);
		players = new Player[] {p1,p2};
		s = new Scanner(System.in);
	}
	
	protected boolean doesWin(int i, int j) {
		// the condition to win is to guess (0,0)
		return i==0 && j==0;
	}
	
	protected boolean onePlay(Player p) {
		// get every player choice and set it to board
		int x,y,i=0;
		do {
			if(i!=0)
				System.out.println("There is a piece there already...");
			System.out.printf("%s, please enter x and y: ",p.toString());
			x = s.nextInt();
			y = s.nextInt();
		} while (!set(x,y,p));
		return doesWin(x, y);
	}
	
	public Player play() {
		int turn=0;
		while (!isFull()) {
			if(onePlay(players[turn])) {
				System.out.println(super.toString());
				System.out.printf("%s Won!\n",players[turn]);
				return players[turn];
			}
			System.out.println(super.toString());			
			turn = 1 - turn; // switch between 0 and 1
		}
		System.out.println("It's a tie!");
		return null;
	}
}

