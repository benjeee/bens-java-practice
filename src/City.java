import java.util.*;

public class City{
		
	private String name;
	
	private int population;
	
	private List<City> neighbors = new ArrayList<City>();
	
	public City(String name, int population) {
		super();
		this.name = name;
		this.population = population;
	}
	
	public static void addaddNeighborPair(final City c1, final City c2){
		c1.addNeighbor(c2);
		c2.addNeighbor(c1);
	}

	public void addNeighbor(City city){
		this.neighbors.add(city);
		city.neighbors.add(this);
	}
	
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public List<City> getNeighbors() {
		return neighbors;
	}
	public void setNeighbors(List<City> neighbors) {
		this.neighbors = neighbors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
	
	

	
	public static int getMaxTraffic(City city){
		
		int max = 0;
		for( City c : city.neighbors){
			max = Math.max(max, get(city, c));
		}
		
		return max;
	}
	
	public static int get(City gameCity, City city){
		int traffic = city.population;
		for(City neighbor : city.getNeighbors()){
			if( gameCity != neighbor ){
				traffic += get(city, neighbor);
			}
		}
		return traffic;
	}
	
	public static void main(String[] args){
		List<City> citylist = new ArrayList<City>();

		City c1 = new City("1", 1);
		City c2 = new City("2", 2);
		City c3 = new City("3", 3);
		City c4 = new City("4", 4);
		City c5 = new City("5", 5);
		City c15 = new City("15", 15);
		City c7 = new City("7", 7);
		
		c5.addNeighbor(c1);
		c5.addNeighbor(c2);
		c5.addNeighbor(c3);
		c5.addNeighbor(c4);
		
		c2.addNeighbor(c15);
		c2.addNeighbor(c7);
		

		citylist.add(c1);
		citylist.add(c2);
		citylist.add(c3);
		citylist.add(c4);
		citylist.add(c5);
		citylist.add(c7);
		citylist.add(c15);
		
		for(City c : citylist){
			System.out.println(c.getName() + ": " + getMaxTraffic(c));
		}
	}
}


