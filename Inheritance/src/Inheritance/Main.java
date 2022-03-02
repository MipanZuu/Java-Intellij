package Inheritance;

public class Main {

	public static void main(String[] args) {
		// overload
		
		
		
		heroSpiderman tomHolland = new heroSpiderman("spider webs", "Man", 100, "blue and red", "75%", "40mph");
		System.out.println("Spiderman ability : " + tomHolland.getAbility());
		System.out.println("Spiderman gender : " + tomHolland.getGender());
		System.out.println("Spiderman power : " + tomHolland.getPower());
		System.out.println("Spiderman custom : " + tomHolland.getCustom());
		System.out.println("Spiderman popularity : " + tomHolland.getPopularity());
		System.out.println("Spiderman swings speed : " + tomHolland.getSwings());
		
		System.out.println("\n===============================================================\n");
		
		heroHulk markRufallo = new heroHulk("physical power", "Man", 250, "green body", "71%", "3 miles in one jump");
		System.out.println("Hulk ability : " + markRufallo.getAbility());
		System.out.println("Hulk gender : " + markRufallo.getGender());
		System.out.println("Hulk power : " + markRufallo.getPower());
		System.out.println("Hulk custom : " + markRufallo.getCustom());
		System.out.println("Hulk popularity : " + markRufallo.getPopularity());
		System.out.println("Hulk jump : " + markRufallo.getJump());
		
		System.out.println("\n===============================================================\n");
		
		heroIronMan tonyStark = new heroIronMan("fire gun", "Man", 330, "red with armor body", "69%", "15.000 miles", "very strong");
		System.out.println("Ironman ability : " + tonyStark.getAbility());
		System.out.println("Ironman gender : " + tonyStark.getGender());
		System.out.println("Ironman power : " + tonyStark.getPower());
		System.out.println("Ironman custom : " + tonyStark.getCustom());
		System.out.println("Ironman popularity : " + tonyStark.getPopularity());
		System.out.println("Ironman fly : " + tonyStark.getFly());
		System.out.println("Ironman shield : " + tonyStark.getArmorShield());
	}

}
