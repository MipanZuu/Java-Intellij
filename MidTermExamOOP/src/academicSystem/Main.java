package academicSystem;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		School ITS = new School();
		Scanner input = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
            System.out.println("1 For Display all Teacher and Student\n2 For Add teacher\n3 Quit");
            int in = input.nextInt();
            if (in == 1 || in == 2 || in == 3) {
            switch (in) {
                case 1:
                    System.out.println(ITS.toString());
                    break;

                case 2:
                    add();
                    break;
                case 3:
                    loop = false;
                    break;
            }
		}
            else {
    			throw new RuntimeException("NO!!");
    		}
		}
		
	}
	   private static void add() {
		   School ITS = new School();
	       Scanner scan = new Scanner(System.in);
	       String teacherName, teacherID, studentName, studentID, studentGrade;

	       System.out.println("Teacher name : ");
	       teacherName = scan.next();

	       System.out.println("Teacher ID : ");
	       teacherID = scan.next();

	       System.out.println("Student name : ");
	       studentName = scan.next();

	       System.out.println("Student ID : ");
	       studentID = scan.next();
	       
	       System.out.println("Student Grade : ");
	       studentGrade = scan.next();
	       
	       Teacher A = new Teacher(teacherID, teacherName);
	       Student B = new Student(studentID, studentName, studentGrade);
	       ITS.addTeacher(A);
	       ITS.addStudent(B);
	        
	       System.out.print(A);
	       System.out.println(B);
	    }
}
