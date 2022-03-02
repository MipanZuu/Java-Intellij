package Stack;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		Scanner input = new Scanner(System.in);
		
		int lenght, in, search; 
		lenght = input.nextInt();
		for (int i = 0; i < lenght; i++) { 
			in = input.nextInt();
			stack.push(in);
		}
		System.out.println("Current stack: " + stack);
		System.out.println("Element that will be pop : " +stack.pop());
		System.out.println("Current stack: " + stack);
		System.out.println("Peek (print the value at top of the stack): " + stack.peek());
		System.out.println("Input the value that will be search: ");
		search = input.nextInt();
		System.out.println("Search value of: " + search + " there are " + stack.search(search));
		System.out.println("Size of stack: " + stack.size());
	}

}
