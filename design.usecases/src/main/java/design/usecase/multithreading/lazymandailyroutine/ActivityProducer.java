package design.usecase.multithreading.lazymandailyroutine;

public class ActivityProducer implements Runnable {
	
	private DailyActivitiesRoutine routine;
	
	public ActivityProducer(DailyActivitiesRoutine routine) {
		super();
		this.routine = routine;
	}

	public void run() {
		try {
			routine.produceActivities();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
