package workshop.model;

public enum TaskName {
	WASHING("Washing"), PAINTING("Painting"), REPAIR("Repair");	
	private final String taskName;	
	private TaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskName() {
		return taskName;
	}	
}
