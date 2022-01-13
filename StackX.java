
public class StackX  //FOR DFS CODE
{
	private final int SIZE = 20;
	private int[] st;
	private int top;
	
	public StackX()
	{
		st = new int[SIZE]; //Making the array
		top = -1;
	}
	
	public void push(int j) //Put item on stack
	{
		st[++top] = j;
	}
	
	public int pop() //Take item off stack
	{
		return st[top--];
	}
	
	public int peek()
	{
		return st[top];
	}
	
	public boolean isEmpty()
	{
		return top == -1;
	}
}
