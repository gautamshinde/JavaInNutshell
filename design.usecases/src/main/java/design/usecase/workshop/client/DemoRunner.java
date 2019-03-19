package design.usecase.workshop.client;

import java.util.Arrays;
import java.util.List;

import design.usecase.workshop.core.Processor;
import design.usecase.workshop.core.WorkshopScheduleProcessor;
import design.usecase.workshop.model.Designation;
import design.usecase.workshop.model.Employee;
import design.usecase.workshop.model.EmployeeJobCard;
import design.usecase.workshop.model.Task;
import design.usecase.workshop.model.TaskName;
import design.usecase.workshop.priority.StratergyType;

public class DemoRunner {

	public static void main(String[] args) throws Exception{
		System.out.println("Demo workshop scheduling and processing by Fees stratergy");
		processWorkshopScheduleByFees();	
		
		Thread.sleep(10000);		
		
		System.out.println("\nDemo workshop scheduling and processing by Time taken stratergy");
		processWorkshopScheduleByTimeTaken();		
	}
	
	private static void processWorkshopScheduleByFees() {
		 Processor workshopScheduleProcessor = new WorkshopScheduleProcessor();
		 workshopScheduleProcessor.process(buildWorkshopSchedule(), StratergyType.BY_FEES);
	}
	
	private static void processWorkshopScheduleByTimeTaken() {
		 Processor workshopScheduleProcessor = new WorkshopScheduleProcessor();
		 workshopScheduleProcessor.process(buildWorkshopSchedule(), StratergyType.BY_TIME_TAKEN);
	}
	
	private static List<EmployeeJobCard> buildWorkshopSchedule() {
		Employee emp1 = new Employee("Joe", Designation.TRAINEE.toString());
		Employee emp2 = new Employee("Smith", Designation.EXPERT.toString());
		Employee emp3 = new Employee("Walker", Designation.EMPLOYEE.toString());		
		List<Task> traineeTasks = Arrays.asList(new Task(TaskName.WASHING, 2, 100), new Task(TaskName.REPAIR, 5, 1000), new Task(TaskName.PAINTING, 4, 1100));
		List<Task> expertTasks = Arrays.asList(new Task(TaskName.REPAIR, 5, 1000));
		List<Task> employeeTasks = Arrays.asList(new Task(TaskName.REPAIR, 5, 1000), new Task(TaskName.PAINTING, 4, 1100));		
		List<EmployeeJobCard> jobcards = Arrays.asList(new EmployeeJobCard(emp1, traineeTasks), new EmployeeJobCard(emp2, expertTasks), new EmployeeJobCard(emp3, employeeTasks));
		return jobcards;
	}

}
