package Composition;

public class Main {

	public static void main(String[] args) {
		Student denta = new Student("Denta Bramasta Hidayat", 1116);
		Teacher agus = new Teacher("Agus Budi Raharjo", 1111);
		Kelas pbo = new Kelas("PBO");
		Department If = new Department("Informatika", 5025);
		University its = new University("ITS", If, pbo, agus, denta);
		
		System.out.println("Name of University : " + its.getNameUniversity());
		System.out.println("Name of Department : " + its.getDepartment().getNameDepartment() + " " + its.getDepartment().getDepartmentID());
		System.out.println("Name of Class : " + its.getKelas().getNameKelas());
		System.out.println("Name of Teacher : " + its.getTeacher().getNameTeacher() + " " + its.getTeacher().getTeacherID());
		System.out.println("Name of Student : " + its.getStudent().getNameStudent() + " " + its.getStudent().getStudentID());
	}

}
