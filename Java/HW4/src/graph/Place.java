package graph;

public class Place {
	// Class that representing a place using x,y coordinates
	private int x, y;
	public Place(int x, int y, int bound) {
		if(x<0 || bound<=x || y<0 || bound<=y) {
			throw new IllegalArgumentException();
		}
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	@Override
	public int hashCode() {
		return 2*x + 3*y;
	}
	
	@Override
	public boolean equals(Object obj) {
		// compare between 2 places's x,y coordinates
		if (obj instanceof Place) {
			Place other = (Place)obj;
			return this.x == other.x && this.y == other.y;
		}
		return false;
	}
	
}
