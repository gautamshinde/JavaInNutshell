package feature.jdk8.lambda;

import static feature.jdk8.util.Utility.buildPersonList;
import static feature.jdk8.util.Utility.excuteAllStaticMethodWithPrefixSample;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import feature.jdk8.model.Person;

public class ComparatorExample {
	public static void main(String[] args) throws Exception {
		excuteAllStaticMethodWithPrefixSample(ComparatorExample.class);
	}


	public static void sample1() {
		List<Person> list = buildPersonList();
		Collections.sort(list, new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				int comp = p1.getLastname().compareTo(p2.getLastname());
				if (comp == 0) {
					comp = p1.getFirstname().compareTo(p2.getFirstname());
					if (comp == 0) {
						return Integer.compare(p1.getAge(), p2.getAge());
					} else {
						return comp;
					}
				} else {
					return comp;
				}
			}
		});
		System.out.println("Sorted List " + list);
	}

	public static void sample2() {
		Comparator<Person> cmp = Comparator.comparing(Person::getLastname).thenComparing(Person::getFirstname)
				.thenComparing(Person::getAge);
		List<Person> list = buildPersonList();
		Collections.sort(list, cmp);
		System.out.println("Sorted List " + list);
	}

	public static void sample3() {
		System.out.println("***** Sample3 *****");
		List<Person> list = buildPersonList();
		Function<Person, String> getLastname = s -> s.getLastname();
		// Function<Person, String> getFirstname = s -> s.getFirstname();
		Comparator1<Person> c = Comparator1.comparing(getLastname).thenComparing((Person p) -> p.getLastname());
		System.out.println("Compare = " + c.compare(list.get(0), list.get(1)));
	}
}

@FunctionalInterface
interface Comparator1<T> {
	int compare(T t1, T t2);

	static <T, U extends Comparable<? super U>> Comparator1<T> comparing(Function<T, U> keyExtr) {
		Objects.requireNonNull(keyExtr);
		return (p1, p2) -> {
			U u1 = keyExtr.apply(p1);
			U u2 = keyExtr.apply(p2);
			return u1.compareTo(u2);
		};
	}

	default <U extends Comparable<? super U>> Comparator1<T> thenComparing(Function<T, U> keyExtr) {
		Objects.requireNonNull(keyExtr);
		return (p1, p2) -> {
			int cmp = this.compare(p1, p2);
			if (cmp == 0) {
				Comparator1<T> other = comparing(keyExtr);
				return other.compare(p1, p2);
			} else {
				return cmp;
			}
		};
	}
}
