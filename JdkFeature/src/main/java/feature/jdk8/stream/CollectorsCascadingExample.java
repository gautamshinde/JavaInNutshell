package feature.jdk8.stream;

import static feature.jdk8.util.Utility.buildSonnet;
import static feature.jdk8.util.Utility.excuteAllStaticMethodWithPrefixSample;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectorsCascadingExample {
	//Classifier & Downstream
	public static void main(String[] args) throws Exception{
		excuteAllStaticMethodWithPrefixSample(CollectorsCascadingExample.class);
	}
	//simple grouping 
	public static void sample1() {
		List<String> sonnet = buildSonnet();
		Map<String, List<String>> map  = sonnet.stream().collect(groupingBy(line -> line.substring(0, 1)));
		System.out.println(map);
	}
	//default implementation of groupingBy collector using mapping
	public static void sample2() {
		List<String> sonnet = buildSonnet();
		Map<String, List<String>> map  = sonnet.stream().collect(groupingBy(line -> line.substring(0, 1), mapping(line -> line, toList())));
		System.out.println(map);
	}
	//mapping downstream collector
	public static void sample3() {
		List<String> sonnet = buildSonnet();
		Map<String, Long> map  = sonnet.stream().collect(groupingBy(line -> line.substring(0, 1), counting()));
		System.out.println(map);
	}
	// mapping function used for reduction
	public static void sample4() {
		List<String> sonnet = buildSonnet();
		Map<String, List<Integer>> map  = sonnet.stream().collect(groupingBy(line -> line.substring(0, 1), mapping(String::length, toList())));
		System.out.println(map);
	}
	
	public static void sample5() {
		List<String> sonnet = buildSonnet();
		Map<String, List<String>> map  = sonnet.stream().collect(groupingBy(line -> line.substring(0, 1), mapping(line -> line.split(" +")[0], toList())));
		System.out.println(map);
	}
	
	public static void sample6() {
		List<String> sonnet = buildSonnet();
		Map<String, Set<String>> map  = sonnet.stream().collect(groupingBy(line -> line.substring(0, 1), mapping(line -> line.split(" +")[0], toSet())));
		System.out.println(map);
	}
	//flatMapping 
	public static void sample7() {
		List<String> sonnet = buildSonnet();
		Map<String, Set<String>> map  = sonnet.stream().collect(groupingBy(line -> line.substring(0, 1), flatMapping(line -> Arrays.stream(line.split(" +")), toSet())));
		System.out.println(map);
	}
}
