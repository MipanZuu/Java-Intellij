package Composition;

public class Student {
	private String nameStudent;
	private int studentID;
	
	public Student (String nameStudent, int studentID) {
		this.nameStudent = nameStudent;
		this.studentID = studentID;
	}
	
	public String getNameStudent() {
		return nameStudent;
	}
	
	public int getStudentID() {
		return studentID;
	}
}
