package feature.jdk8.stream;

import static feature.jdk8.util.Utility.buildSonnet;
import static feature.jdk8.util.Utility.excuteAllStaticMethodWithPrefixSample;
import static feature.jdk8.util.Utility.expand;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class FlatMapExample {
	public static void main(String[] args) throws Exception {
		excuteAllStaticMethodWithPrefixSample(FlatMapExample.class);
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
	
	public static void sample2() {
		List<String> list = buildSonnet();
		List<List<String>> expandedList = list.stream().map(line -> expand(line)).collect(toList());
		System.out.println(expandedList);
	}
	
	public static void sample3() {
		List<String> list = buildSonnet();
		List<String> expandedList = list.stream().flatMap(line -> expand(line).stream())
				.filter(s -> !s.trim().isEmpty()).collect(toList());
		System.out.println(expandedList);
	}
	
	public static void sample4() {
		List<String> list = buildSonnet();
		List<String> expandedList = list.stream().flatMap(line -> Arrays.stream(line.split(" +")))
				.collect(toList());
		System.out.println(expandedList);
	}
}