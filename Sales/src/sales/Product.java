package sales;



public class Product implements Saleable {

	private int price;
	private int weight;
	private String name;
	
	
	//Product constructor to create a product object
	public Product(String name, int weight, int price) {
		this.name = name;
		this.weight = weight;
		this.price = price;
	}
	
	//Getter to get name which will override the method of the same name in the parent class (Saleable)
	@Override
	public String getName() {
		return name;
	}
	
	//Setter method to set name
	public void setName(String name) {
		this.name = name;
	}
	
	//Getter method to get price that will override the method of the same name in the parent class (Saleable)
	@Override
	public int getPrice() {
		return price;
	}
	
	//Setter to set price
	public void setPrice(int price) {
		this.price = price;
	}
	
	//Getter to get weight of item
	public int getWeight() {
		return weight;
	}
	
	//Setter to set weight of item
	public void setWeight(int weight) {
		this.weight = weight;
	} 
	
	//Method to calculate the delivery cost based on the weight of the item
	public int calculateDelivery() {
		  if (weight < 100) {
			  return 0;
		  } else if (weight >= 100 && weight < 1000) {
		    return (int) (weight * 0.20);
		  } else {
		    return (int) ((weight - 1000) * 0.10 + (1000 * 0.20));
		  }
	 }
	
	//Method to display the name of the item, how much it weighs and the cost of delivery using the calculate delivery method
	public void deliveryDetails() {
		System.out.println("Your item " + name + " weighs " + weight + "g and the delivery cost is " + calculateDelivery() + "p");
	}
	
	//Method to return the item name, weight and price of the item. Override allows the returned information to be in a readable format
	@Override
	public String toString() {
		return "Product name: " + name + ", Weight: " + weight + "g, Price: " + price + "p";
	}
	
}
