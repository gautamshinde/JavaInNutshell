package design.usecase.workshop.priority;

import java.util.Comparator;

import design.usecase.workshop.model.Task;

public class ByTimeTakenPriorityStratergy implements PriorityStratergy<Task>{

	@Override
	public Comparator<Task> buildStrategry(Task task) {		 
		return Comparator.comparing(Task::getTimeTaken);
	}
	
}
