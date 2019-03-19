package workshop.model;

public enum Designation {
	TRAINEE("Trainee"),
	EXPERT("Expert"),
	EMPLOYEE("Employee");
	
	private final String designation;
	Designation(String designation) {
		this.designation = designation;
	}
	
	@Override
	public String toString() {	
		return designation;
	}	
}
