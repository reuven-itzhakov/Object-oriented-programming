package cards;

public class Card { 
	// a class that represents a playing card
	private int num;
	private int suit;
	
	public Card(int num, int suit) {
		this.num = num;
		this.suit = suit;
	}
	
	public int getNum() {
		return num;
	}
	
	public int getSuit() {
		return suit;
	}
	
	public String toString() {
		char suitLetter;
		// choose the letter based on the number of the suit
		switch(this.suit) {
		case 0:
			suitLetter = 'C';
			break;
		case 1:
			suitLetter = 'D';
			break;
		case 2:
			suitLetter = 'H';
			break;
		case 3:
			suitLetter = 'S';
			break;
		default:
			suitLetter=' ';
		}
		return String.format("%d%c", this.num, suitLetter);
	}
	
	public int compareTo(Card other) {
		// if the numbers aren't equal - return their difference
		if (this.num != other.num){
			return this.num - other.num;
		}
		// else return the difference of the suit number
		return this.suit - other.suit;
	}
}
