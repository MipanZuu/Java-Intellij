package IfElseFor;
import java.util.Scanner;

/* 
 	DENTA BRAMASTA HIDAYAT
 	5025201116
 	INFORMATICS IUP 2020
 	PBO A (IUP)
*/


public class IfElseFor {
	public static void main(String[] args) {
	Scanner userInput = new Scanner(System.in);
	
	boolean loop = true;
	int length, modulo, numberA, numberB;
	int result;
	char operators, asking;
	System.out.println("\t\t\t##### Assignment PBO IUP CLASS #####");
	System.out.println("\t\t\t\tDenta Bramasta Hidayat");
	System.out.println("\t\t\t\t5025201116");
	System.out.println("\t\t\t\tPBO (A) IUP");
	System.out.println("\t\t\t\tInformatics 2020 IUP\n\n");
	
	// use modulo for make it symbol *
	System.out.println("\t\t\t##### SYMBOL USING MODULO #####\n");
	System.out.println("Insert 2 numbers for make it simbols ");
	System.out.print("Insert a number for the length of integers = ");
	length = userInput.nextInt(); 
	System.out.print("Insert a number for the modulo = ");
	modulo = userInput.nextInt();	
	
	// using looping for the length
		for (int i = 1; i <= length; i++) {
			if(i % modulo == 0) {
				System.out.print("* ");
			} 
			else {
				System.out.print(i + " ");
			}
		}	
	System.out.println("\n");
	
	//aritmetic Opertation +, -, *, %, /
	System.out.println("\t\t\t##### ARITMETIC OPERATION #####");
	while (loop) {
		System.out.println("");
		System.out.print("Insert the first number = ");
		numberA = userInput.nextInt(); 
		System.out.print("Insert the second number = ");
		numberB = userInput.nextInt();
		System.out.print("Insert the operator \n+   -   *   %\nOperator = ");
		operators = userInput.next().charAt(0);
		
	
	//Switch case for aritmetic output
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
	
	
	System.out.println("\t\t\t##### CONVERT DATA TYPE & TYPE CASTING #####");
	Scanner myInput = new Scanner(System.in); 
	Scanner inputSec = new Scanner(System.in);
	Scanner inputChar = new Scanner(System.in);
	Scanner inputConvert = new Scanner(System.in);
	int integers, tempInt;
	double myDouble, tempDouble;
	float myFloat, tempFloat;
	char myChar, yesOrNo, tempChar;
	String myString = null;
	String convert = null;
	String convertTo = null;
	boolean yes = true;
	
	
	while (yes) {
	System.out.println("\nInsert a data type for converter");
	System.out.print("int, char, double, float || 'stop' for break the loop = ");
	convert = myInput.nextLine();
	
		if (convert.matches("int") || convert.matches("Int") || convert.matches("INT")) {
			System.out.print("Enter an Integers = ");
			integers = inputSec.nextInt();
			tempDouble = (double)integers;
			System.out.println("Double = " + tempDouble);
			tempFloat = (float)integers;
			System.out.println("Float = " + tempFloat);
			tempChar = (char)integers;
			System.out.println("Char = " + tempChar);
		} else if (convert.matches("double") || convert.matches("Double") || convert.matches("DOUBLE")) {
			System.out.print("Enter a Double = ");
			myDouble = inputSec.nextDouble();
			tempInt = (int)myDouble;
			System.out.println("Int = " + tempInt);
			tempFloat = (float)myDouble;
			System.out.println("Float = " + tempFloat);
			tempChar = (char)myDouble;
			System.out.println("Char = " + tempChar);
		} else if (convert.matches("float") || convert.matches("Float") || convert.matches("FLOAT")) {
			System.out.print("Enter a Float = ");
			myFloat = inputSec.nextFloat();
			tempInt = (int)myFloat;
			System.out.println("Int = " + tempInt);
			tempChar = (char)myFloat;
			System.out.println("Char = " + tempChar);
			tempDouble = (double)myFloat;
			System.out.println("Double = " + tempDouble);
			
		} else if (convert.matches("char") || convert.matches("Char") || convert.matches("CHAR")) {
			System.out.print("Enter a Char = ");
			myChar = inputSec.next().charAt(0);
			tempInt = (int)myChar;
			System.out.println("Int = " + tempInt);
			tempFloat = (float)myChar;
			System.out.println("Float = " + tempFloat);
			tempDouble = (double)myChar;
			System.out.println("Double = " + tempDouble);
			
		} else if (convert.matches("stop") ||convert.matches("Stop") || convert.matches("STOP")) {
			break;
		} else {
			System.out.println("ERROR. You should input (int, string, char, double, float) in string");
		}
	}
		System.out.println("\n\n\t\t\t##### THANK YOU :) #####");
	}
}

