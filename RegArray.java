
public class RegArray 
{
	protected long[] arr;//Reference/address to an array
	protected int numElements;
		
	public RegArray(int size)
	{
		arr = new long[size]; //Some number "size" will be stored in our array
		numElements = 0;
	}
	public void insert(long n)
	{
		if(numElements<arr.length)
			arr[numElements++] = n;
	}
	
	public void delete(long n)
	{
		int index = find(n); //Find the position that we want to find
		if(index > -1) //If the position is greater than -1
		{
			for(int x = index; x < numElements-1; x++) //Then we sort through the array
				arr[x] = arr[x+1];
			numElements--; //If it is not greater than -1, we decrease numElements
		}
	}
	
	public int find(long n)
	{
		for(int x = 0; x<numElements; x++)
		{
			if(arr[x]==n)
				return x;
		}
		return -1; //Only reach this line if we don't find anything.
	}
	
	public String toString()
	{
		String s = "";
		for(int x = 0; x<numElements; x++)
			s = s + arr[x] + " ";
		return s;
	}
	
	public int getLength()
	{
		return numElements;
	}

}
