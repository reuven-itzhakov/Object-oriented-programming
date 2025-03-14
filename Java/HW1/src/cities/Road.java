package cities;

public class Road {
	// a class that represents a road between two cities
	private int length;
	private City city1;
	private City city2;
	
	public Road(City city1, City city2, int length) {
		this.length = length;
		this.city1 = city1;
		this.city2 = city2;
		this.city1.connect(this);
		this.city2.connect(this);	
	}
	
	public int getLength() {
		return this.length;
	}
	
	public City getCity1() {
		return this.city1;
	}
	
	public City getCity2() {
		return this.city2;
	}
}
