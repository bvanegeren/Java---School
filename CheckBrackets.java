import java.util.Scanner;
public class CheckBrackets 
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a series of parentheses including any other characters: ");
		String string = scan.nextLine();
		System.out.println("You entered: " + "\n" + string);
		
		Stack stack = new Stack(string.length());
		
		boolean isBalanced = true;
		int counterOpen = 0;
		int counterClose = 0;

		
		for(int x = 0; x<string.length(); x++)
		{
			char ch = string.charAt(x);
			if (ch == '(')
			{
				stack.push(ch);
				counterOpen++;
			}
			else if(ch == ')')
			{
				if(!stack.isEmpty())
				{
					stack.pop();
					counterClose++;
				}
				else
				{
					System.out.println("Stack is empty, you cannot pop anymore.");
					isBalanced = false;
					break;
				}
			}
			

		}
		if(isBalanced && counterOpen == counterClose)
			System.out.println("Congrats, your string is balanced.");
		else
			System.out.println("Error: Unbalanced parentheses");

	}
}
