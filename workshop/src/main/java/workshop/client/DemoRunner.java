package workshop.client;

import java.util.Arrays;
import java.util.List;

import workshop.core.Processor;
import workshop.core.WorkshopScheduleProcessor;
import workshop.model.Designation;
import workshop.model.Employee;
import workshop.model.EmployeeJobCard;
import workshop.model.Task;
import workshop.model.TaskName;
import workshop.priority.StratergyType;

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
