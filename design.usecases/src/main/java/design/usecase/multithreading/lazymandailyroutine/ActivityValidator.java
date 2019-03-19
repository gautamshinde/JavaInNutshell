package design.usecase.multithreading.lazymandailyroutine;

public class ActivityValidator implements Runnable {
	
	private DailyActivitiesRoutine routine;
		
	public ActivityValidator(DailyActivitiesRoutine routine) {
		super();
		this.routine = routine;
	}

	public void run() {
		try {
			while(true) {
				routine.consumeActivitiesAndValidateCorrectOrder();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
