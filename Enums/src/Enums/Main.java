package Enums;

public class Main {

	 public static void main(String[] args) {
		  Cell<Integer> integerCell = new Cell<Integer>();
		  Cell<String> stringCell = new Cell<String>();
		  integerCell.setValue(1);
		  stringCell.setValue("One");
		  int num = integerCell.getValue();
		  String str = stringCell.getValue();
		  System.out.println("Integer Value: " + num);
		  System.out.println("String Value : " + str);
		 }//end method main
}
