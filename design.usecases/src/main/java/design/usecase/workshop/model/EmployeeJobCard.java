package design.usecase.workshop.model;

import java.util.List;

public class EmployeeJobCard {
	private Employee employee;
	private List<Task> tasks;

	public EmployeeJobCard(Employee employee, List<Task> tasks) {
		super();
		this.employee = employee;
		this.tasks = tasks;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}	
}
