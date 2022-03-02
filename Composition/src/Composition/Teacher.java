package Composition;

public class Teacher {
	private String nameTeacher;
	private int teacherID;
	
	public Teacher (String nameTeacher, int teacherID) {
		this.nameTeacher = nameTeacher;
		this.teacherID = teacherID;
	}
	
	public String getNameTeacher() {
		return nameTeacher;
	}
	
	public int getTeacherID() {
		return teacherID;
	}
}
