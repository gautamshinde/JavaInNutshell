package feature.jdk8.stream;

import static feature.jdk8.util.Utility.excuteAllStaticMethodWithPrefixSample;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class FlatMapSample {
	public static void main(String[] args) throws Exception {
		excuteAllStaticMethodWithPrefixSample(FlatMapSample.class);
	}

	public static void sample1() {
		List<String> list = List.of("Java", "GoTo", "Scala", "Python", "Kotlin");
		list.stream().forEach(System.out::println);
		// JDK 11
		String language = "GOLang";
		System.out.println(expand(language));
		// Map & Filter
		list.stream().map(String::toUpperCase).filter(s -> s.length() == 6).forEach(System.out::println);
	}

	public static List<String> expand(String s){
		List<String> list = s.codePoints().mapToObj(Character::toString).collect(toList());
		return list;
	}
	
	public static void sample2() {
		List<String> list = initialize();
		List<List<String>> expandedList = list.stream().map(line -> expand(line)).collect(toList());
		System.out.println(expandedList);
	}
	
	public static void sample3() {
		List<String> list = initialize();
		List<String> expandedList = list.stream().flatMap(line -> expand(line).stream())
				.filter(s -> !s.trim().isEmpty()).collect(toList());
		System.out.println(expandedList);
	}
	
	public static void sample4() {
		List<String> list = initialize();
		List<String> expandedList = list.stream().flatMap(line -> Arrays.stream(line.split(" +")))
				.collect(toList());
		System.out.println(expandedList);
	}
	
	public static List<String> initialize () {
		List<String> list = List.of("Nature’s first green is gold", 
									"Her hardest hue to hold",
									"Her early leaf’s a flower",
									"But only so an hour",
									"Then leaf subsides to leaf",
									"So Eden sank to grief",
									"So dawn goes down to day",
									"Nothing gold can stay");
		return list;
	} 
	
}