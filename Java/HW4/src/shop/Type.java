package shop;

public enum Type {
	// enum that representing types of guitar
	ACOUSTIC, ELECTRIC, CLASSICAL;
	
	@Override
	public String toString() {
		return this.name().substring(0,1) + this.name().substring(1).toLowerCase();
	}
}
