//package Huffman;

//This code is used to encode a message into binary and then decode the message while tracking the size in bits.

import java.util.PriorityQueue;

public class EncodeDecode 
{
	private static String[][] symTable;
	private static CharNode finalTree;

	public static void main(String[] args) 
	{
		String message = "SUSIE SAYS IT IS EASY.";
		System.out.println("Original message:" + message);
		System.out.println("Size = "+message.length()*2*8+" bits.");
		String enc = encode(message);
		System.out.println("Encoded message:" + enc);
		System.out.println("Size = "+enc.length()+" bits.");
		String dec = decode(enc);
		System.out.println("Decoded message:" + dec);
	}

	public static String encode(String message)
	{
		char[] chars = new char[50];
		int[] freqs = new int[50];
		for(int i = 0; i<message.length(); i++)
		{
			int j;
			for(j = 0; freqs[j]>0; j++)
			{
				if(chars[j]==message.charAt(i))
				{
					freqs[j]++;
					break;
				}
			}
			if(freqs[j]==0)
			{
				chars[j] = message.charAt(i);
				freqs[j] = 1;
			}
		}
		int count = 0;
		for(int x = 0; x<50; x++)//Counting the real number of the table
		{
			if(freqs[x]==0)
				break;
			count++;
		}

		PriorityQueue<CharNode> pq = new PriorityQueue<CharNode>();
		for(int i = 0; freqs[i]>0; i++)
		{
			CharNode temp = new CharNode(chars[i],freqs[i]);
			pq.add(temp);		

		}
		while(pq.size()>1)
		{
			CharNode n1 = pq.remove();
			CharNode n2 = pq.remove();
			CharNode temp = new CharNode(n1.getData()+n2.getData());
			temp.setLeft(n1);
			temp.setRight(n2);
			pq.add(temp);
		}
		finalTree = pq.remove();	
		
		// Traversing the tree
		symTable = new String[count][2];
		int charNum  =0;
		for(int i = 0; charNum<count; i++)
		{
			CharNode current = finalTree;
			String code = "";
			while(!(current.getLeft()==null && current.getRight()==null) 
					&& !(current.getLeft().isDone() && current.getRight().isDone()))
			{
				//System.out.println(charNum + ":" + code + "   " + current + "   " + current.getLeft()+ "   " + current.getLeft().isDone()+ "   " +current.getRight()+ "   " +current.getRight().isDone());
				if(current.getLeft()!=null && !current.getLeft().isDone())
				{
					current = current.getLeft();
					code += "0";

				}
				else if(current.getRight()!=null && !current.getRight().isDone())
				{
					current = current.getRight();
					code += "1";
				}
				else
				{
					current.markDone();
					break;
				}
					
				
			}
			if(current.getLetter()!='`')
			{
				symTable[charNum][0] = current.getLetter()+"";
				symTable[charNum++][1] = code;
			}
			current.markDone();
		}
		String output = "";
		for(int i = 0; i<message.length(); i++)
		{
			String currentChar = ""+message.charAt(i);
			for(int j=0; j<symTable.length;j++)
				if(symTable[j][0].equals(currentChar))
				{
					output += symTable[j][1];
					break;
				}

		}
		return output;
	}
	
	public static String decode(String message)
	{
		String output = "";
		CharNode current = finalTree;
		for(int i=0; i<message.length(); i++)
		{
			char currentChar = message.charAt(i);
			if(currentChar=='0')
				current = current.getLeft();
			else
				current = current.getRight();
			if(current.getLetter()!='`')
			{
				output += current.getLetter();
				current = finalTree;
			}
			
		}

		return output;
	}
	 
}