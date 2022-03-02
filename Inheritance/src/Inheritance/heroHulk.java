package Inheritance;

public class heroHulk extends marvelHeroes{
	private String jump;
	
	public heroHulk(String ability, String gender, int power, String customColour, String popularity, String jump) {
		this.ability = ability;
		this.gender = gender;
		this.power = power;
		this.customColour = customColour;
		this.popularity = popularity;
		this.jump = jump;
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
	
	public String getJump() {
		return jump;
	}
}
