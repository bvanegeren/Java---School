
public class OrdArray extends RegArray
{
	public OrdArray(int size) //Constructor
	{
		super(size);
	}
	
	public void insert(long n) //Re-write the insert because it changes for ordered arrays
	{
		if(numElements<arr.length)
		{
			int current = numElements - 1; //numElements - 1 is the position of the last element
			numElements++; //We increase the number of elements after we go through it's values
			while(current>=0)
			{
				if (arr[current] <= n)
				{
					arr[current+1] = n;
					return;//return only when everything has been gone through
				}
				else
					arr[current + 1] = arr[current];
				current--;
			}
			arr[0] = n;
		}
	}
	
	public int find(long n)
	{
		return binSearch(n, 0, numElements-1);//Will use recursive binary search code
	}
	
	private int binSearch(long n, int low, int high)
	{
		if(low <= high)
		{
			int mid = (int) ((low + high) / 2);
			if(arr[mid] == n)//Base case for recursion
				return mid;
			else if(arr[mid] > n)
			{
				high = mid - 1;
				return binSearch(n, low, high);
			}
			else
			{
				low = mid + 1;
				return binSearch(n, low, high);
			}
		}
		else//Also a base case for recursion
			return -1;
	}
}
