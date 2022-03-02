package Enums;

public class Cell<T> {
	private T data;
	public void setValue(T celldata)
	{
		data = celldata;
	}//end method setValue
	public T getValue() {
		return data;
	}//end method get
}//end class Cell