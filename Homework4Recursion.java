//Implemented the code for displaying negative numbers
public class Homework4Recursion 
{
	public static void main (String[] args)
	{
		System.out.println(intToString(987));
	}

	public static String intToString(int num)
	{
		String[] digits = new String []{ "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		
		if (num < 10)
		{
			if (num > 0)
				return digits[num];
			else
			{
				int temp = num*(-1);
				return "minus " + digits[temp/10];
			}
		}
		else
		{
			if (num < 0)
				return ("minus" + digits[num%10] + intToString(num/10));
			else
			{
				int temp = num;
				return digits[temp/10] + intToString(num%10);
			}
		}
	}
	
}
