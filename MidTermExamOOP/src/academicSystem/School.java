package academicSystem;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class School implements Serializable {
	// using list, so we can add name of teachers/students.
	private List<Teacher> Teachers;
    private List<Student> Students;
    
    public School() {
    	Teachers = new ArrayList<Teacher>();
    	Students = new ArrayList<Student>();
    }
    
    public List<Teacher> getTeachers() {
        return Teachers;
    }
    
    public List<Student> getStudents() {
        return Students;
    }
    
    public void addTeacher(Teacher Teach){
        Teachers.add(Teach);
    }
    
    public void addStudent(Student Stud){
        Students.add(Stud);
    }
    
    @Override
    public String toString() {
        return "Teachers: " + getTeachers() + " Student: " + getStudents();
    }
}


