package feature.jdk8.stream;

import java.math.BigInteger;
import java.util.stream.LongStream;

import feature.jdk8.util.Utility;

public class ReduceExample {
	public static void main(String[] args) throws Exception{
		Utility.excuteAllStaticMethodWithPrefixSample(ReduceExample.class);
	}
	
	public static void sample1() {
		BigInteger factorial = LongStream.range(1, 10).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);
		System.out.println("Factorial = "+factorial);
	}
}
