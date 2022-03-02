import java.util.Scanner;

/* 
 	DENTA BRAMASTA HIDAYAT
 	5025201116
 	INFORMATICS IUP 2020
 	PBO A (IUP)
*/


public class pboAssignment1 {
	public static void main(String[] args) {
	Scanner userInput = new Scanner(System.in);
	
	boolean loop = true;
	int length, modulo, numberA, numberB;
	int result;
	char operators, asking;
	System.out.println("\t\tAssignment PBO IUP CLASS");
	System.out.println("\tDenta Bramasta Hidayat");
	System.out.println("\t5025201116");
	System.out.println("\tPBO (A) IUP");
	System.out.println("\tInformatics 2020 IUP\n");
	
	System.out.println("Insert 2 numbers for make it simbols ");
	System.out.print("Insert a number for the length of integers = ");
	length = userInput.nextInt(); 
	System.out.print("Insert a number for the modulo = ");
	modulo = userInput.nextInt();	
	
	// using looping for
		for (int i = 1; i <= length; i++) {
			if(i % modulo == 0) {
				System.out.print("# ");
			} 
			else {
				System.out.print(i + " ");
			}
		}	
	System.out.print("\n");
	
	while (loop) {
		System.out.print("\n");
		System.out.print("Insert the first number = ");
		numberA = userInput.nextInt(); 
		System.out.print("Insert the second number = ");
		numberB = userInput.nextInt();
		System.out.print("Insert the operator \n+   -   *   %\nOpeerator = ");
		operators = userInput.next().charAt(0);
		
	
	//Switch case for day output
		System.out.print("\n");
		System.out.print("It's ");
		switch (operators) {
			case '+':
				result = numberA+numberB;
				System.out.println("Addition of " + numberA + " + " + numberB + " = " + result);
				break;
			case '-':
				result = numberA-numberB;
				System.out.println("Substraction of " + numberA + " - " + numberB + " = " + result);
				break;
			case '*':
				result = numberA*numberB;
				System.out.println("Multiplication of " + numberA + " * " + numberB + " = " + result);
				break;
			case '%':
				result = numberA%numberB;
				System.out.println("Modulo of " + numberA + " % " + numberB + " = " + result);
				break;
			case '/':
				result = numberA/numberB;
				System.out.println("Division of " + numberA + " / " + numberB + " = " + result);
				break;
			default:
				System.out.println("wrong, you should add operator in char ");
			}
		System.out.println("You want to continue? if yes input Y if no N ");
			asking = userInput.next().charAt(0);
			if (asking == 'Y') {
				continue;
			} else if (asking == 'N') {
				break;
			} else {
				break;
			}
		}
	
//		Scanner myInput = new Scanner(System.in); 
//		Scanner inputSec = new Scanner(System.in);
//		int integers;
//		String myString = null;
//		System.out.println("Insert a data type for converter = ");
//		System.out.print("int, string, char, double, float = ");
//		
//		
//		String convert = null;
//		convert = myInput.nextLine();
//		
//		if (convert.matches("int") || convert.matches("Int") || convert.matches("INT")) {
//			System.out.print("Enter an Integers = ");
//			integers = inputSec.nextInt();
//		} else if (convert == "string" || convert == "String" || convert == "STRING") {
//			System.out.print("Enter a string words = ");
//			myString = inputSec.nextLine();
//		}
		
	}
}

