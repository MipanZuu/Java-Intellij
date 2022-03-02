package week6;

public class Account implements InterfaceBankAccount{
private String/*No type specified!*/ balance, ;
   //end method getBankName
private String/*No type specified!*/ bankName, ;
	private String AccHolder;
	private final String AccNum;
	private int AccBalance = 0;
	
	public Account(String name, String number) {
		this.AccHolder = name;
		this.AccNum = number;
	}//end class Account
	
	public void deposit(int amt){ 
		this.AccBalance = this.AccBalance + amt;
	}
	public void withdraw(int amt)
	{
		if (this.AccBalance - amt > 0) {
			this.AccBalance = this.AccBalance - amt;
		}
		else {
			System.out.println("Less Than 0");
		}
	}
	
	public void print()
	{
	System.out.println("\nBank Name : " + getBankName() +
	"\nAccount Holder : " + AccHolder +
	"\nAccount Number : " + AccNum +
	"\nAccount balance: " + AccBalance);
	}//end method print
}