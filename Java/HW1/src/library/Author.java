package library;

public class Author {
	// a class that represents an author
	private String name;
	private int birthYear;
	
	public Author(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getBirthYear() {
		return this.birthYear;
	}
	
	public int getAge(int thisYear) {
		return thisYear - this.birthYear;
	}
	
	
	public String toString() {		
		return String.format("%s(%d)", this.name, this.birthYear);
	}
	
	
}
