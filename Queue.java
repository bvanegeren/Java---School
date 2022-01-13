
public class Queue 
{
	private char [] data;
	private int front;
	private int rear;
	private int n; //to store # of items.
	private int maxSize;
	
	public Queue(int size)
	{
		maxSize = size;
		data = new char[size];
		front = 0;
		rear = -1;
		n = 0;//# of items is 0 in an empty queue
	}
	
	public void enqueue(char c)
	{

		System.out.println("front = " + front + ", rear = " + rear);
		if(!isFull())
		{
			if(rear < data.length - 1)//data.length - 1 is the last index
				data[++rear] = c;//rear is now at 1, and there is something at position 0 (now front).
			else//If it is not at the end of the queue
			{
				rear = 0;
				data[rear] = c;//Insert c at what we hope is the last index
			}
			n++;
		}
		else
			System.out.println("Warning! Queue is full!");
			
	}
	
	public char dequeue()
	{
		if(!isEmpty())
		{
			n--;
			if(front < data.length - 1)
				return data[++front];//Checks array data for value at position front and sets it aside for returning.
									 //Must include the front++ in the brackets because otherwise it won't ever get there.
									 //If you write the return statement before the ++, the program will never get there.
			else
			{ 
				char temp = data[front];
				front = 0;
				return(temp);
			}
		}
		else
			return '`';

	}
	
	public char peekFront()
	{
		return data[front];
	}
	
	public boolean isFull()
	{
		return(n==data.length);

	}
	
	public boolean isEmpty()
	{
		return (n==0);
	}
	
	public int numItems()
	{
		return n;
	}
	//No peekRear because we are not supposed to see what's at the end of the queue
	public String toString()
	{
		String s = "";
		for (char c:data)
			s += c;
		return s;
	}
	
	public void display()
	{
		System.out.println("First item to last item inserted: ");
		
		if(isEmpty())
			System.out.println("Nothing to be displayed. Queue is empty.");
		else if(rear < front)
		{
			for(int x = front; x<maxSize; x++)
				System.out.println(data[x]);
			for(int x = 0; x<= rear; x++)
				System.out.println(data[x]);
		}
		else if(rear >= front)
		{
			for(int x = front; x < maxSize; x++)
				System.out.println(data[x]);
		}
	}

}
