package feature.jdk8.lambda;

import java.util.Objects;
import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {
		sample1();
		sample2();
	}

	public static void sample1() {
		Predicate<String> p = String::isEmpty;		
		System.out.println("Is Empty "+p.test(""));		
	}
	
	public static void sample2(){
		Predicate1<String> p1 = String::isEmpty;
		Predicate1<String> p2 = String::isEmpty;
		p1.and(p2).test(" ");
		
		Predicate1<String> p3 = p1.and(null);
		
		System.out.println("And operation = "+p3.test(""));
	}
}

@FunctionalInterface
interface Predicate1<T> {
	public boolean test(T t);
	
	public default Predicate1<T> negate() {
		return t -> !this.test(t);
	}
	
	public default Predicate1<T> and(Predicate1<T> other){
		Objects.requireNonNull(other);
		return t -> this.test(t) && other.test(t);
	}
}