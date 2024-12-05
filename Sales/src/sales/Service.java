package sales;

import java.util.ArrayList;

public class Service implements Saleable {

	private int price;
	private String name;
	

	//Service constructor to create a service object
	public Service(String name, int price) {
		this.name = name;
		this.price = price;
		
	}
	
	//Getter method to get name which will override the parent classes (Saleable) method of the same name
	@Override
	public String getName() {
		return name;
	}
	
	//Getter method for price which will override the parent classes (Saleable) method of the same name
	@Override
	public int getPrice() {
		return price;
	}
	
}
