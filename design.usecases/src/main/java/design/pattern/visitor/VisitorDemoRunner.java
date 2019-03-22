package design.pattern.visitor;

public class VisitorDemoRunner {

	public static void main(String[] args) {
		CourrierCart cart = new CourrierCart();
		cart.addItem(new Book("Core Java", 1.0, 6));
		cart.addItem(new Book("Spring", 1.0, 12));		
		System.out.println("Total postal charges - "+cart.calculateTotalPostageCharges());
	}
}
