
public class Stack 
{
	private char[] arr;//A variable that creates the address where the space is created in memory
	private int top;
	
	public Stack(int size)//int size is index number
	{
		arr = new char[size];//we will store characters in the stack
		top = -1;//starts at -1 because we can't assume that something will be in position 0.
	}
	
	public void push(char c)
	{
		if(!isFull())//Not ideal because if we test something of size 10, the last char will be cut off
			arr[++top] = c;//pre-increment operator, top is increased before indexing (more common code)
		else
			System.out.println("Warning! Stack Full!");
	}
	
	public char pop()
	{
		if(!isEmpty())
			return arr[top--];//-- is done after the value is used for return
		else
			return '`';
	}
	
	public char peek()
	{
		if(!isEmpty())
			return arr[top];
		else
			return '`';
	}
	
	public boolean isEmpty()
	{
		return (top == -1);//if top is -1 then the stack is empty.
	}
	
	public boolean isFull()
	{
		return (top == arr.length - 1);//if top is at the max index, it is full.
	}
}
