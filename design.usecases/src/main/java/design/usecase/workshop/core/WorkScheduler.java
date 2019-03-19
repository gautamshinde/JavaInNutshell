package design.usecase.workshop.core;

import java.util.Collections;

import design.usecase.workshop.model.EmployeeJobCard;
import design.usecase.workshop.model.Task;
import design.usecase.workshop.priority.PriorityStratergy;
import design.usecase.workshop.priority.StratergyFactory;
import design.usecase.workshop.priority.StratergyType;

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
