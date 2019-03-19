package design.usecase.workshop.core;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import design.usecase.workshop.model.EmployeeJobCard;
import design.usecase.workshop.priority.StratergyType;

public class WorkshopScheduleProcessor implements Processor {

	@Override
	public void process(List<EmployeeJobCard> jobCards,StratergyType type) {
		if(jobCards.isEmpty()) {
			System.out.println("Empty jobcards - could not processed");
			return;
		}
		ExecutorService executor = Executors.newFixedThreadPool(jobCards.size());
		WorkScheduleBuilder builder = new WorkScheduleBuilder();
		List<WorkScheduler> workSchedulers = builder.builder(jobCards, type);
		
		for (WorkScheduler workScheduler : workSchedulers) {
			executor.execute(workScheduler);
		}		
		executor.shutdown();		
	}
}
