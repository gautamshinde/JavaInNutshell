package design.usecase.multithreading.lazymandailyroutine.client;

import design.usecase.multithreading.lazymandailyroutine.ActivityProducer;
import design.usecase.multithreading.lazymandailyroutine.ActivityValidator;
import design.usecase.multithreading.lazymandailyroutine.DailyActivitiesRoutine;

public class DemoRunner {

	public static void main(String[] args) {
		DailyActivitiesRoutine routine = new DailyActivitiesRoutine();
		Thread producer = new Thread(new ActivityProducer(routine), "Producer");
		Thread consumer = new Thread(new ActivityValidator(routine), "Consumer");
		producer.start();
		consumer.start();	
	}
}
