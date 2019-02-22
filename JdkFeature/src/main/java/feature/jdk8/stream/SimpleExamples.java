package feature.jdk8.stream;

import static java.util.stream.Collectors.toList;

import java.util.List;

public class SimpleExamples {
	public static void main(String[] args) {
		sample1();
	}
	
	public static void sample1() {
		List<String> list = List.of("Java", "GoTo", "Scala","Python","Kotlin");	
		list.stream().forEach(System.out::println);
		//JDK 11
		String language = "GOLang";		
		List<String> list1  = language.codePoints().mapToObj(Character::toString).collect(toList());
		System.out.println(list1);
		//Map & Filter
		list.stream().map(String::toUpperCase).filter(s -> s.length() == 6).forEach(System.out::println);
		
	}
	
	public static void sample2() {
		
	}
}