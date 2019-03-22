package design.pattern.visitor;

public class PostageVisitor implements Visitor {

	private double totalPostage;
	
	@Override
	public void visit(Book book) {
		if(book.getPrice() > 5) {
			totalPostage += ((int)book.getPrice()/5);
		}
	}

	public double getTotalPostage() {
		return totalPostage;
	}

	public void setTotalPostage(double totalPostage) {
		this.totalPostage = totalPostage;
	}
	
}
