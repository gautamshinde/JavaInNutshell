package feature.jdk8.stream;

import static feature.jdk8.util.Utility.buildPersonList;
import static feature.jdk8.util.Utility.excuteAllStaticMethodWithPrefixSample;

import java.util.List;
import java.util.function.Predicate;

import feature.jdk8.model.Person;

public class PredicateExample {
	public static void main(String[] args) throws Exception {
		excuteAllStaticMethodWithPrefixSample(PredicateExample.class);
	}
	
	public static void sample1() {
		List<Person> list = buildPersonList();
		Predicate<Person> agePredicate =  p -> p.getAge() > 30; 
		list.stream().filter(agePredicate).forEach(System.out::println);
	}
	
	public static Predicate<Person> combine(List<Predicate<Person>> predicateList) {
		Predicate<Person> identity = p -> true;
		for (Predicate<Person> predicate : predicateList) {
			identity = identity.and(predicate);
		}
		return identity;
	}
	
}
