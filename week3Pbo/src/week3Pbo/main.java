package week3Pbo;

public class main {
	public static void main(String[] args) {
		Vehicle myCar = new Vehicle();
		
		Vehicle Innova = new Vehicle();
		Innova = new Vehicle("Toyota", 10);
		System.out.println("My car type is: " + Innova.Make() + " " + Innova.mpg());
		Innova.setMilesPerGallon(1000);
		System.out.print("My car type is: " + Innova.Make() + " " + Innova.mpg());
	}
}