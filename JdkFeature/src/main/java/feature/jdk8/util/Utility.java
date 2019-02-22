package feature.jdk8.util;

import static java.util.stream.Collectors.toList;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Utility {
	
	private Utility() {
	}

	public static void executeAllStaticMethods(Class<?> clazz, String methodNamePrefix) throws Exception {
		Method[] methods = clazz.getMethods();	
		Function<Method, String> methodName = m -> m.getName(); 
		Comparator<Method> comp = Comparator.comparing(methodName);
		Arrays.sort(methods, comp);
		for (Method method : methods) {
			if(method.getName().startsWith(methodNamePrefix)) {
				method.invoke(null, new Object[] {});
			}
		}	
	}
	
	public static void excuteAllStaticMethodWithPrefixSample(Class<?> clazz) throws Exception {
		executeAllStaticMethods(clazz, "sample");
	}
	
	public static List<String> expand(String s){
		List<String> list = s.codePoints().mapToObj(Character::toString).collect(toList());
		return list;
	}
}
