package academicSystem;

public class Teacher extends School {
	private String id;
    private String name;

    
    public Teacher(String teacherID, String name){
        this.id = teacherID;
        this.name = name;
    }
    
    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Name of the Teacher is: " + name
                +"\nID of the Teacher is "
                + id + "\n";
    }

}
