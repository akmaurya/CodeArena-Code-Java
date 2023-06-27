package beans;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Collections {
	private List fruits;
	private Set cricketers;
	private Map countryCapital;
	
	public List getFruits() {
		return fruits;
	}
	public void setFruits(List fruits) {
		this.fruits = fruits;
	}
	public Set getCricketers() {
		return cricketers;
	}
	public void setCricketers(Set cricketers) {
		this.cricketers = cricketers;
	}
	public Map getCountryCapital() {
		return countryCapital;
	}
	public void setCountryCapital(Map countryCapital) {
		this.countryCapital = countryCapital;
	}
	
	public void displayCollections(){
		System.out.println("Fruits:- "+fruits);
		System.out.println("Cricketers:- "+cricketers);
		System.out.println("Country Capital:- "+countryCapital);
	}
}
