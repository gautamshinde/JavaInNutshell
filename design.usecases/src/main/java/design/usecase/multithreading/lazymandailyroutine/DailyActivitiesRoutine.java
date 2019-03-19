package design.usecase.multithreading.lazymandailyroutine;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class DailyActivitiesRoutine {
	
	private BlockingQueue<String> activityGeneratorQueue = new ArrayBlockingQueue<>(12); 
	private String activitiesSequence = "EDSE";
	private volatile String prevActivity = "";
	
	
	public void produceActivities() throws Exception {
		int randomActivityIndex = 0;
		while (true) {
			randomActivityIndex = ThreadLocalRandom.current().nextInt(0,3);
			activityGeneratorQueue.put(String.valueOf(activitiesSequence.charAt(randomActivityIndex)));
		}
	}
	
	public void consumeActivitiesAndValidateCorrectOrder() throws Exception {
		String currentActivity = activityGeneratorQueue.take();
		if(prevActivity.isEmpty() && !currentActivity.equals(String.valueOf(activitiesSequence.charAt(0)))) {
			return;
		}
		if(activitiesSequence.contains(prevActivity+currentActivity)) {
			prevActivity = currentActivity;				
			System.out.println("Valid activity "+currentActivity);
			if(currentActivity.equals(String.valueOf(activitiesSequence.charAt(2)))) {
				System.out.println("====================");
			}
		}		
	}	
}
