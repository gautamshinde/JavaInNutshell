package feature.jdk8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
	public static void main(String[] args) {
		simple1();
		simple2();
		simple3();
	}

	public static void simple1() {
		Consumer<String> c1 = s -> System.out.println(s);
		c1.accept("Hi simple consumer");
		Consumer<String> c2 = System.out::println;
		c2.accept("Hi consumer using method reference");
	}

	public static void simple2() {
		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		Consumer<List<Integer>> c1 = list -> list.clear();
		Consumer<List<Integer>> c2 = List::clear;
		c1.accept(list1);
		c2.accept(list1);
		System.out.println("Is Empty list = " + list1.isEmpty());
	}
	
	public static void simple3() {
		Consumer<List<Integer>> c1 = list1 -> list1.add(1); 
		Consumer<List<Integer>> c2 = list1 -> list1.add(2);		
		Consumer<List<Integer>> c3 = c1.andThen(c2);
		List<Integer> list = new ArrayList<>();
		list.add(0);
		c3.accept(list);
		System.out.println("List = "+list);
	}
}

@FunctionalInterface
interface MyConsumer<T>{	
	public void accept(T t);
	
	public default MyConsumer<T> andThen(MyConsumer<T> consumer){
		
		return t -> {this.accept(t); consumer.accept(t);};
	}	
}
