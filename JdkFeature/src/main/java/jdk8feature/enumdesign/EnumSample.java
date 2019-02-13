package jdk8feature.enumdesign;

import java.util.function.BiFunction;

public class EnumSample {
	public static void main(String[] args) {		
		System.out.println("Sum = "+ new PressureMeasureService().computePressure(Type.HIGH, 100));
	}
}

class PressureMeasureService{

	public String markHighPressure(int pressureReading) {
		return "High Pressure Recorded";		
	}

	public String markNormalPressure(int pressureReading) {
		return "Normal Pressure Recorded";		
	}

	public String markLowPressure(int pressureReading) {
		return "Low Pressure Recorded";		
	}
	
	public String computePressure(Type type, int pressureReading) {
		return type.measure(this, pressureReading);		
	}

}

enum Type {
	HIGH(PressureMeasureService::markHighPressure),
	NORMAL(PressureMeasureService::markNormalPressure),
	LOW(PressureMeasureService::markLowPressure);
	
	public final BiFunction<PressureMeasureService, Integer, String> pressureGuage;
	
	private Type(BiFunction<PressureMeasureService, Integer, String> pressureGuage) {
		this.pressureGuage = pressureGuage;
	}
	
	public String measure(PressureMeasureService service, int pressureReading) {
		return pressureGuage.apply(service, pressureReading);
	}
}