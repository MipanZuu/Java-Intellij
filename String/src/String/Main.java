package String;

public class Main {

	public static void main(String[] args) {
		String str = "The character originated in stories told by Carroll to entertain the Liddell sisters while rowing on the Isis with his friend Robinson Duckworth, and on subsequent rowing trips. Although she shares her given name with Alice Liddell, scholars disagree about the extent to which she was based upon Liddell. Characterized by Carroll as \"loving and gentle\", \"courteous to all\", \"trustful\", and \"wildly curious\",[1] Alice has been variously seen as clever, well-mannered, and sceptical of authority, although some commentators find more negative aspects of her personality. Her appearance changed from Alice's Adventures Under Ground, the first draft of Alice's Adventures in Wonderland, to political cartoonist John Tenniel's illustrations of her in the two Alice books.";
//		displayString(str);
//		displayStringBackward(str);
//		searchString(str); 
//		String index = str.indexOf("Wonderland");
//		String touppercase = str.toUppercase();
		System.out.println(str.toUpperCase());
	}
		
	static void displayString(String str)
	{
		//printing the String as it is
		System.out.println(str);
		//printing each character on a separate line
		for(int index=0;index<str.length();index++){
		System.out.println(str.charAt(index));
		}
	}//end method displayString
	
	
	static void displayStringBackward(String str)
	{ //create a local String variable
	String strBackwards = "";
	//read the array backwards and store the characters in strBackwards
	for(int i=str.length()-1; i>=0 ; i--){
	strBackwards+=str.substring(i,i+1);
	}//endfor
	System.out.println(strBackwards);
	}//end method displayStringBackward
	
	
	static void searchString(String str, char c) {
		int count=0;
		for(int i=0; i<str.length(); i++){
		if(str.indexOf("Wonderland" == 1))
		count++;
		//endif
		}//endfor
		System.out.println("The character " + c
		+ " appears in the text "
		+ count + " times.");
		}//end method searchString
	static void searchString(String str) {
		int count=0;
		for(int i=0; i<str.length(); i++){
		if(str.indexOf("Wonderland") == 1)
		count++;
		//endif
		}//endfor
		System.out.println("The character "
		+ " appears in the text "
		+ count + " times.");
		}//end method searchString
}
	
