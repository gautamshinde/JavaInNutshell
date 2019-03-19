package workshop.priority;

import java.util.Comparator;

public interface PriorityStratergy<Task> {
	public Comparator<Task> buildStrategry(Task task);

}
