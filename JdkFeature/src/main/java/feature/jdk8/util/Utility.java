package feature.jdk8.util;

import static java.util.stream.Collectors.toList;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import feature.jdk8.model.Person;

public class Utility {

	private Utility() {
	}

	public static void executeAllStaticMethods(Class<?> clazz, String methodNamePrefix) throws Exception {
		Method[] methods = clazz.getMethods();
		Predicate<Method> methodName = m -> m.getName().startsWith(methodNamePrefix);
		Predicate<Method> staticMethod = m -> (m.getModifiers() & Modifier.STATIC) != 0;
		List<Method> methodList = Arrays.stream(methods).filter(methodName.and(staticMethod)).collect(toList());
		if (methodList == null || methodList.isEmpty()) {
			System.out.println("Hey, you don't have implemented static method, pleasse do check !!");
			return;
		}
		Function<Method, String> sortOnMethodName = m -> m.getName();
		Comparator<Method> comp = Comparator.comparing(sortOnMethodName);
		Collections.sort(methodList, comp);
		for (Method method : methodList) {
			try {
			method.invoke(null, new Object[] {});
			} catch(Exception e) {
				System.out.println("Exception while invoking method "+method.getName()+" !!!!");
				//e.printStackTrace();
			}
		}
	}

	public static void excuteAllStaticMethodWithPrefixSample(Class<?> clazz) throws Exception {
		executeAllStaticMethods(clazz, "sample");
	}

	public static List<String> expand(String s) {
		List<String> list = s.codePoints().mapToObj(Character::toString).collect(toList());
		return list;
	}

	public static List<Person> buildPersonList() {
		List<Person> list = new ArrayList<>();
		list.add(new Person("Viman", "Nagar", 37));
		list.add(new Person("Elphinston", "Kirkee", 30));
		list.add(new Person("Kirkee", "Station", 4));
		list.add(new Person("Lohgad", "Fort", 24));
		list.add(new Person("Murud", "Fort", 26));
		return list;
	}

	public static List<String> buildSonnet() {
		List<String> list = List.of("Nature’s first green is gold", "Her hardest hue to hold",
				"Her early leaf’s a flower", "But only so an hour", "Then leaf subsides to leaf",
				"So Eden sank to grief", "So dawn goes down to day", "Nothing gold can stay");
		return list;
	}
}
