package cards;

public class Deck {
	// a class to handle a collection of cards
	private Card[] cards;
	private int numCards;
	
	public Deck(int num) {
		this.cards = new Card[num*4];
		this.numCards = 0;
		// build a deck with the first num cards
		for(int i = 0; i < num; i++) {
			for (int j = 0; j < 4; j++, this.numCards++) {
				this.cards[this.numCards] = new Card(i,j);
			}
		}
	}
	
	public Deck(Deck from, int num) {
		this.cards = new Card[num];
		this.numCards = 0;
		// takes num cards from "from" deck to new deck
		for (int i = 0; i < num; i++) {
			Card temp = from.takeOne();
			if(temp == null) {
				break;
			}
			this.cards[i] = temp;
			this.numCards++;
		}
	}
	
	public Deck(Deck first, Deck second) {
		this.cards = new Card[first.numCards + second.numCards];
		this.numCards = 0;
		// take cards from first and second
		while(first.numCards + second.numCards > 0) {
			// first card from "first" deck, second card from "second" deck
			Card temp = first.takeOne();
			if(temp!=null) {
				this.cards[this.numCards] = temp;
				this.numCards++;
			}
			temp = second.takeOne();
			if(temp!=null) {
				this.cards[this.numCards] = temp;
				this.numCards++;
			}
		}
	}
	public Card takeOne() {
		if (this.numCards==0) {
			return null;
		}
		// reducing the number of the cards
		this.numCards--;
		return this.cards[this.numCards];
	}
	
	public int getNumCards() {
		return this.numCards;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < this.numCards; i++) {
			sb.append(this.cards[i].toString());
			if(i != this.numCards-1) {
				sb.append(", ");
			}else {
				sb.append("]");
			}
		}
		return sb.toString();
	}
	
	public void sort() {
		// bubble sort
		for (int i = 0; i < this.numCards-1; i++) {
			for (int j = 0; j < this.numCards-1-i; j++) {
				if(this.cards[j].compareTo(this.cards[j+1])>0) {
					Card temp = this.cards[j];
					this.cards[j] = this.cards[j+1];
					this.cards[j+1] = temp;
				}
			}
		}
	}
	
	
}
