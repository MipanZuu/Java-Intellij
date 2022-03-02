package week3Pbo;

public class Vehicle {
		private String make;
		private int MilesPerGallon;
		
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

	public Vehicle(String make, int mpg) {
		this.setMake(make);
		this.setMilesPerGallon(mpg);
	}
	public String Make() {
        return getMake() + " " + getMilesPerGallon();
    }
	
	public int mpg () {
		return getMilesPerGallon();
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public int getMilesPerGallon() {
		return MilesPerGallon;
	}

	public void setMilesPerGallon(int milesPerGallon) {
		MilesPerGallon = milesPerGallon;
	}

}
