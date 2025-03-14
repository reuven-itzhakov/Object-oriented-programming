package library;

public class Library {
	// a class to handle a collection of books
	private Book[] books;
	
	public Library(int size) {
		this.books = new Book[size];
	}
	
	public void setBook(int bookNum, String title, Author auth) {
		this.books[bookNum] = new Book(title,auth);
	}
	
	public Book getBook(int bookNum) {
		return this.books[bookNum];
	}
}
