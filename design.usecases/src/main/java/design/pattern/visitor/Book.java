package design.pattern.visitor;
//Element
public class Book implements Postable {
	
	private String name;
	private double weight;
	private double price;
	
	public Book(String name, double weight, double price) {
		super();
		this.name = name;
		this.weight = weight;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
