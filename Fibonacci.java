
public class Fibonacci 
{
	private static long[] arr = new long[100];
	public static void main(String[] args)
	{
		System.out.println(Fib2(50));
	}
	
	public static long Fib(int n)
	{
		if(n == 1 || n == 2)//Looking at the position, not the number value
			return n-1;
		else
			return Fib(n-1) + Fib(n-2);
	}
	
	public static long Fib2(int n)
	{
		if(arr[n]==0)//When an array is first created in java, the first element is 0
		{
			if(n == 1 || n == 2)//Looking at the position, not the number value
			{
				arr[n] = n-1;
				return n-1;
			}
			else
			{
				arr[n] = Fib2(n-1) + Fib2(n-2);
				return arr[n];
			}
		}
		else
			return arr[n];
	}
}
