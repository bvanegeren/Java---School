//package huffman

public class CharNode implements Comparable<CharNode>
{
	private int data;
	private char letter;
	private CharNode left;
	private CharNode right;
	private boolean done;
	
	public CharNode(int d)//Constructor with just the frequency
	{
		data = d;
		letter = '`';//use something that you will likely never see in a message
		done = false;
	}
	
	public CharNode (char l, int d)//Constructor with character and frequency
	{
		data = d;
		letter = l;
		done = false;
	}
	
	public void setLeft(CharNode n)//Set left child to another node
	{
		left = n;
	}
	
	public void setRight(CharNode n)//Set the right child to another node
	{
		right = n;
	}
	
	public CharNode getLeft()//Return left child
	{
		return left;
	}
	
	public CharNode getRight()//Return right child
	{
		return right;
	}
	
	public void setData (int d)//Set data to particular frequency
	{
		data = d;
	}
	
	public int getData()//Get the data
	{
		return data;
	}
	
	public char getLetter()//Get the letter/character
	{
		return letter;
	}
	
	public void setLetter(char l)//Change/set the letter
	{
		letter = l;
	}
	
	public String toString()
	{
		return getLetter() + ":" + getData();
	}
	
	public int compareTo(CharNode n2)//Comparing the frequency of 2 different letters or nodes
	{
		return (int)(this.data - n2.data);
	}
	
	public boolean isDone()//Returns the done variable
	{
		return done;
	}
	
	public void markDone()//We can mark a node as being done
	{
		done = true;
	}
}
