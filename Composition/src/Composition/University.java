package Composition;

public class University {
	private String nameUniversity;
	private Department Department;
	private Kelas ClassIF;
	private Teacher Teacher;
	private Student Student;
	
	public University(String nameUniversity, Department Department, Kelas ClassIF, Teacher Teacher, Student Student) {
		this.nameUniversity = nameUniversity;
		this.Department = Department;
		this.ClassIF = ClassIF;
		this.Teacher = Teacher;
		this.Student = Student;
	}
	
	public String getNameUniversity() {
		return nameUniversity;
	}
	
	public Department getDepartment() {
		return Department;
	}
	
	public Kelas getKelas() {
		return ClassIF;
	}
	
	public Teacher getTeacher() {
		return Teacher;
	}
	
	public Student getStudent() {
		return Student;
	}
}
