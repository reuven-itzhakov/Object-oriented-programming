package cities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class World {
	// Class that representing a world
	private Map<String, Country> countries;
	
	public World() {
		countries = new HashMap<>();
	}
	
	public void addCountry(String name) {
		if (countries.get(name) == null)
			countries.put(name, new Country(name));
	}

	public void addCity(String name, String countryName, int population) {
		Country c = countries.get(countryName);
		if (c == null) {
			throw new IllegalArgumentException();
		}
		c.addCity(new City(name, c, population));
	}

	public int population() {
		// get the population of the entire world
		int sum = 0;
		for(Country c:countries.values()) {
			sum += c.population();
		}
		return sum;
	}

	public List<City> smallCities(int under) {
		// returns a list of cities with population less then given
		List<City> ret = new ArrayList<>();
		for(Country c:new TreeSet<Country>(countries.values())) {
			ret.addAll(c.smallCities(under));
		}
		return ret;
	}

	public String report() {
		StringBuilder sb = new StringBuilder();
		for (Country c : new TreeSet<Country>(countries.values())) {
			sb.append(c.report()).append('\n');
		}
		sb.append("Total population is ");
		sb.append(population()).append('\n');
		return sb.toString();
	}

}

