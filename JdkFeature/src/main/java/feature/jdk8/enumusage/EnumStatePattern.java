package feature.jdk8.enumusage;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Validate;

public class EnumStatePattern {	

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		cart.addOrder("Spring book");
		cart.addOrder("Pencil");
		cart.setOrderNo("1");
		cart.order();
		
	}
	
}

class ShoppingCart{
	
	private String orderNo;
	private List<String> itemList = new ArrayList<>();
	private UpdateSate state = UpdateSate.UPDATABLE;
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		state.check(orderNo);
		this.orderNo = orderNo;
	}
	public void addOrder(String order) {
		state.check(order);
		itemList.add(order);
	}
	public void setItemList(List<String> itemList) {
		this.itemList = itemList;
	}
	
	public void order() {
		System.out.println("Order placed - no more item can be added");
		state = UpdateSate.READONLY;
		
	}		
}

enum UpdateSate {
	UPDATABLE(() -> Validate.validState(true)),
	READONLY(() -> Validate.validState(false));
	
	private final Runnable action;
	
	private UpdateSate(Runnable action ) {
		this.action = action;
	}
	
	public <T> T check(T value) {
		action.run();
		return value;
	}
		
}

