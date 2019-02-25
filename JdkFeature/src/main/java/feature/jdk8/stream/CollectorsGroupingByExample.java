package feature.jdk8.stream;

import static feature.jdk8.util.Utility.buildSonnet;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import feature.jdk8.util.Utility;

public class CollectorsGroupingByExample {
	//Stream<T> -> Map<K, List<V>>
	public static void main(String[] args) throws Exception{
		Utility.excuteAllStaticMethodWithPrefixSample(CollectorsGroupingByExample.class);
	}
	//without groupby 
	public static void sample1() {
		List<String> sonnet = buildSonnet();
		Map<String, List<String>> map  = sonnet.stream().collect(toMap(line -> line.substring(0,1),
				line -> new ArrayList<>(asList(line)),
				(list1, list2)-> {list1.addAll(list2); return list1;}));
		System.out.println(map);
	}
	//group by
	public static void sample2() {
		List<String> sonnet = buildSonnet();
		Map<String, List<String>> map  = sonnet.stream().collect(groupingBy(line -> line.substring(0, 1)));
		System.out.println(map);
	}	
}
