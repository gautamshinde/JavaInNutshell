package design.usecase.workshop.model;

public class Task {	
	private  TaskName name;
	private long timeTaken;
	private double fees;
	
	public Task(TaskName name, long timeTaken, double fees) {
		super();
		this.name = name;
		this.timeTaken = timeTaken;
		this.fees = fees;
	}

	public TaskName getName() {
		return name;
	}

	public void setName(TaskName name) {
		this.name = name;
	}

	public long getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(long timeTaken) {
		this.timeTaken = timeTaken;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}	
	
}

