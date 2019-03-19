package design.usecase.workshop.core;

import java.util.List;

import design.usecase.workshop.model.EmployeeJobCard;
import design.usecase.workshop.priority.StratergyType;

public interface Processor {
	public void process(List<EmployeeJobCard> jobCards,StratergyType type);
}
