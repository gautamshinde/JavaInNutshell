package design.usecase.multithreading.lazymandailyroutine;

public class ActivityConsumer implements Runnable {
	
	private DailyActivitiesRoutine routine;
		
	public ActivityConsumer(DailyActivitiesRoutine routine) {
		super();
		this.routine = routine;
	}

	public void run() {
		try {
			routine.consumeActivitiesAndValidateCorrectOrder();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
