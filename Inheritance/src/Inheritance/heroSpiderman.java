package Inheritance;

public class heroSpiderman extends marvelHeroes{
	private String swings;
	
	protected void swings () {
		System.out.println("Spiderman can sings");
	}
	
	public heroSpiderman(String ability, String gender, int power, String customColour, String popularity, String swings) {
		this.ability = ability;
		this.gender = gender;
		this.power = power;
		this.customColour = customColour;
		this.popularity = popularity;
		this.swings = swings;
	}
	
	public String getAbility() {
		return ability;
	}
	
	public String getGender() {
		return gender;
	}
	
	public int getPower() {
		return power;
	}
	
	public String getCustom() {
		return customColour;
	}
	
	public String getPopularity() {
		return popularity;
	}
	
	public String getSwings() {
		return swings;
	}
	
}
