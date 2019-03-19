package workshop.core;

import java.util.List;

import workshop.model.EmployeeJobCard;
import workshop.priority.StratergyType;

public interface Processor {
	public void process(List<EmployeeJobCard> jobCards,StratergyType type);
}
