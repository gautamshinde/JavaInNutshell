package workshop.priority;

import java.util.Comparator;

import workshop.model.Task;

public class ByFeesPriorityStratergy implements PriorityStratergy<Task> {

	@Override
	public Comparator<Task> buildStrategry(Task task) {
		return Comparator.comparing(Task::getFees);
	}

}
