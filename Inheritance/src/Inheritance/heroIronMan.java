package Inheritance;

public class heroIronMan extends marvelHeroes{
	private String fly;
	private String armorShield;
	
	public heroIronMan(String ability, String gender, int power, String customColour, String popularity, String fly, String armorShield) {
		this.ability = ability;
		this.gender = gender;
		this.power = power;
		this.customColour = customColour;
		this.popularity = popularity;
		this.fly = fly;
		this.armorShield = armorShield;
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
	
	public String getFly() {
		return fly;
	}
	
	public String getArmorShield() {
		return armorShield;
	}
}
