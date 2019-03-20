package design.usecase.multithreading.lazymandailyroutine.client;

import design.usecase.multithreading.lazymandailyroutine.ActivityProducer;
import design.usecase.multithreading.lazymandailyroutine.ActivityConsumer;
import design.usecase.multithreading.lazymandailyroutine.DailyActivitiesRoutine;

public class DemoRunner {

	public static void main(String[] args) {
		DailyActivitiesRoutine routine = new DailyActivitiesRoutine();
		Thread producer = new Thread(new ActivityProducer(routine), "Producer");
		Thread consumer = new Thread(new ActivityConsumer(routine), "Consumer");
		producer.start();
		consumer.start();	
	}
}
