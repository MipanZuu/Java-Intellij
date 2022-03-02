package Composition;

public class Department {
	private String nameDepartment;
	private int departmentID;
	
	public Department (String nameDepartment, int departmentID) {
		this.nameDepartment = nameDepartment;
		this.departmentID = departmentID;
	}
	
	public String getNameDepartment() {
		return nameDepartment;
	}
	
	public int getDepartmentID() {
		return departmentID;
	}
}
