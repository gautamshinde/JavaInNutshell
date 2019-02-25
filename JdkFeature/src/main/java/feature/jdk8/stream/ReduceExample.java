package feature.jdk8.stream;

import static feature.jdk8.util.Utility.excuteAllStaticMethodWithPrefixSample;
import static java.util.function.IntUnaryOperator.identity;

import java.math.BigInteger;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.LongStream;

public class ReduceExample {
	public static void main(String[] args) throws Exception{
		excuteAllStaticMethodWithPrefixSample(ReduceExample.class);
	}
	
	public static void sample1() {
		BigInteger factorial = LongStream.range(1, 10).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);
		System.out.println("Factorial = "+factorial);
	}
	
	public static IntUnaryOperator combine(List<IntUnaryOperator> operators) {
		 return operators.stream().reduce(identity(), IntUnaryOperator::andThen);
	}
	
	public static void sample2() {
		IntUnaryOperator operator = combine(List.of(i -> i+1, i -> i*2, i -> i+3));
		System.out.println("Operation value = "+operator.applyAsInt(5));
	}
}
