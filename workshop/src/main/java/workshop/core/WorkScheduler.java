package workshop.core;

import java.util.Collections;

import workshop.model.EmployeeJobCard;
import workshop.model.Task;
import workshop.priority.PriorityStratergy;
import workshop.priority.StratergyFactory;
import workshop.priority.StratergyType;

public class WorkScheduler implements Runnable {
	
	private EmployeeJobCard jobCard;
	private StratergyType type;

	public WorkScheduler(EmployeeJobCard jobCard, StratergyType type) {
		super();
		this.jobCard = jobCard;
		this.type = type;
	}
	
	@Override
	public void run() {
		System.out.format("Employee %s started his/her work\n", jobCard.getEmployee().getName());		
		PriorityStratergy<Task> stratergy = StratergyFactory.createStratergy(type);		
		Collections.sort(jobCard.getTasks(), stratergy.buildStrategry(jobCard.getTasks().get(0)));
		for (Task task : jobCard.getTasks()) {
			System.out.format("%s - %s completed\n", jobCard.getEmployee().getName(), task.getName().getTaskName());
		}
		System.out.format("Employee %s completed his/her work\n", jobCard.getEmployee().getName());
	}

}
