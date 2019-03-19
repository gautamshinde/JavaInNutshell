package design.usecase.workshop.priority;

import design.usecase.workshop.model.Task;

public class StratergyFactory {
	public static PriorityStratergy<Task> createStratergy(StratergyType type) {
		PriorityStratergy<Task> ps = null;		
		if(type == StratergyType.BY_FEES) {
			ps = new ByFeesPriorityStratergy();
		} else if (type == StratergyType.BY_TIME_TAKEN) {
			ps = new ByTimeTakenPriorityStratergy();
		}  
		return ps;		
	}	
}
