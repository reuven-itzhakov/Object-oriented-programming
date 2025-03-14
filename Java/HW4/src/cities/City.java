package cities;

public class City implements Comparable<City>{
	// Class that represents a city
	private String name;
	private Country country;
	private int population;
	
	public City(String name, Country country, int population) {
		this.name = name;
		this.country = country;
		this.population = population;
	}
	public String getName() {
		return name;
	}
	public Country getCountry() {
		return country;
	}
	public int getPopulation() {
		return population;
	}
	public String toString() {
		return String.format("%s (of %s)",name,country.toString());
	}
	@Override
	public int compareTo(City o) {
		if(!country.equals(o.country)) {
			return country.compareTo(o.country);
		}
		return name.compareTo(o.name);
	}
	@Override
	public boolean equals(Object obj) {
		// check the equality of two cities
		if (!(obj instanceof City))
			return false;
		City city = (City)obj;
		if(country.equals(city.country)) {
			return name.equals(city.name);
		}
		return false;
	}
}
