package feature.jdk8.stream;

import static feature.jdk8.util.Utility.buildSonnet;
import static feature.jdk8.util.Utility.excuteAllStaticMethodWithPrefixSample;
import static java.util.stream.Collectors.toMap;

import java.util.List;
import java.util.Map;

public class CollectorsExample {

	public static void main(String[] args) throws Exception {
		excuteAllStaticMethodWithPrefixSample(CollectorsExample.class);
	}

	// toMap - don't allow duplicate key
	public static void sample1() {
		List<String> sonnet = buildSonnet();
		sonnet.stream().collect(toMap(line -> line.substring(0, 1), line -> line));
	}
	// merge function
	public static void sample2() {
		List<String> sonnet = buildSonnet();
		Map<String, String> map = sonnet.stream()
				.collect(toMap(line -> line.substring(0, 1), line -> line, (line1, line2) -> line1));
		System.out.println(map);
	}

	public static void sample3() {
		List<String> sonnet = buildSonnet();
		Map<String, String> map = sonnet.stream()
				.collect(toMap(line -> line.substring(0, 1), line -> line, (line1, line2) -> line2));
		System.out.println(map);
	}
    // merege concate duplicate lines
	public static void sample4() {
		List<String> sonnet = buildSonnet();
		Map<String, String> map = sonnet.stream()
				.collect(toMap(line -> line.substring(0, 1), line -> line, (line1, line2) -> line1+System.lineSeparator()+line2));
		System.out.println(map);
	}
}
