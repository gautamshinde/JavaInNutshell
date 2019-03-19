package workshop.core;

import java.util.List;
import java.util.stream.Collectors;

import workshop.model.EmployeeJobCard;
import workshop.priority.StratergyType;

public class WorkScheduleBuilder {
	public List<WorkScheduler> builder(List<EmployeeJobCard> jobCards,StratergyType type) {		
		return jobCards.stream().map(jobCard -> new WorkScheduler(jobCard, type) ).collect(Collectors.toList());
	}
}
