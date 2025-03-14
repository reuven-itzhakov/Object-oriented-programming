package cities;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;

public class Country implements Comparable<Country>{
	// Class that represents a country
	private SortedSet<City> cities; // cities of the country are stored as a set
	private String name;
	public Country(String name) {
		this.name = name;
		cities = new TreeSet<City>();
	}
	private City get(String name) {
		// return the city with the given name
		for (City c:cities) {
			if(name.equals(c.getName())) return c;
		}
		return null;
	}
	
	public void addCity(City city) {
		if (get(city.getName()) == null) // if the city doesn't already exist
			if(city.getCountry().equals(this)) // if the city's country is this country
				cities.add(city);
			else
				throw new IllegalArgumentException();
	}
	public int population() {
		// calculates the population of the country
		int pop=0;
		for(City c: cities) {
			pop += c.getPopulation();
		}
		return pop;
	}
	public String toString() {
		return name;
	}
	public List<City> smallCities(int under){
		// returns a list of cities with population less then given
		List<City> lst = new ArrayList<>();
		for(City city:cities) {
			if(city.getPopulation()<under) {
				lst.add(city);
			}
		}
		return lst;
	}
	
	public String report() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%s(%d) : ", name,population()));
		int i = 0;
		for(City city:cities) {
			if(i++!=0) sb.append(", ");
			sb.append(String.format("%s(%d)", city.getName(),city.getPopulation()));
		}
		return sb.toString();
	}
	@Override
	public int compareTo(Country o) {
		return name.compareTo(o.name);
	}

}
