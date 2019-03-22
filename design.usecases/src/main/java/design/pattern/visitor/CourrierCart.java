package design.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class CourrierCart {
	List<Postable> courrierList = new ArrayList<>();
	
	public void addItem(Postable item){
		courrierList.add(item);
	}
	
	public double calculateTotalPostageCharges() {
		PostageVisitor visitor = new PostageVisitor();
		courrierList.stream().forEach(item -> item.accept(visitor));
		return visitor.getTotalPostage();
	}
	
}
