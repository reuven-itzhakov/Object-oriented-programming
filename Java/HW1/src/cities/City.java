package cities;

public class City {
	// a class that represents a city
	private Road[] roads;
	private int numRoads;
	private String name;
	
	public City(String name) {
		this.roads = new Road[10];
		this.numRoads = 0;
		this.name = name;
	}
	
	public void connect(Road r) {
		if(r!=null) {
			this.roads[this.numRoads] = r;
			this.numRoads++;
		}
	}
	
	public City nearestCity() {
		if(this.numRoads == 0) {
			return null;
		}	
		int minLengthIndex = 0;
		for(int i = 1; i < this.numRoads; i++) {
			// find minimum
			minLengthIndex = this.roads[minLengthIndex].getLength() < this.roads[i].getLength() ?
					minLengthIndex : i;
		}
		Road shortestRoad = this.roads[minLengthIndex];
		// return the city on the other end of the shortest road
		return shortestRoad.getCity1() == this ? shortestRoad.getCity2() : shortestRoad.getCity1();
	}
	
	public String toString() {
		return this.name;
	}
}
