package academicSystem;

public class Student extends School {
	  private String id;
	  private String name;
	  private String grade;
	  
	  public Student(String id, String name, String grade){
	    this.id = id;	
	    this.name = name;
        this.grade = grade;
	  }
	  public String getId() {
	        return id;
	  }
	    
	  public String getName() {
	        return name;
	  }

	  public String getGrade() {
	        return grade;
	  }
	   @Override
	   public String toString() {
	       return "Name of the Student is: " + name
	                +"\nID of the Student is: "
	                + id + "\n";
	    }
}
