package feature.jdk8.stream;

import static feature.jdk8.util.Utility.buildSonnet;
import static feature.jdk8.util.Utility.excuteAllStaticMethodWithPrefixSample;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;

public class CollectorsCascadingExample {
	//Classifier & Downstream
	public static void main(String[] args) throws Exception{
		excuteAllStaticMethodWithPrefixSample(CollectorsCascadingExample.class);
	}
	//counting downstream collector
	public static void sample1() {
		List<String> sonnet = buildSonnet();
		Map<String, Long> map  = sonnet.stream().collect(groupingBy(line -> line.substring(0, 1), counting()));
		System.out.println(map);
	}
	//mapping downstream collector
	public static void sample2() {
		
	}
}
