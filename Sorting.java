
public class Sorting 
{
	public static void bubbleSort(int[] arr)
	{
		for(int i = 0; i<arr.length; i++)//Outer loop runs N-1 times.
			for(int j = 0; j < arr.length-i-1; j++)//arr.length-i because you no longer need to account 
			{//for i previously found (not necessary, just more efficient) and -1 because otherwise it will go out of bounds
				if(arr[j] > arr[j+1])//arr[j+1] is why we need arr.length-1
					swap(arr, j, j+1);
			}
	}
	
	public static void selectionSort(int[] arr)
	{
		for(int x = 0; x<arr.length-1; x++)//Start at 0 and sort through the element before the last one(the last one is already sorted?)
		{//Could also do x<=arr.length - 2
			int minIndex = x;
			for(int y = x; y<arr.length; y++)//we follow along with where x is, and find the smallest # along the way. We ignore what x was previously.
			{
				if(arr[y]<arr[minIndex])
					minIndex = y;
			}
			swap(arr,x,minIndex);
		}
	}
	
	public static void insertionSort(int[] arr)
	{
		for(int y = 1; y<arr.length; y++)
		{
			int index = arr[y];//Need to store arr[y] as index, otherwise it will change when y changes elsewhere
			int x = y - 1;
			while(x >= 0 && arr[x] > index)
			{
				arr[x+1] = arr[x];//Moving through the array
				x = x  - 1;
			}
			arr[x + 1] = index;//When we exit the loop, we want the index to move to the next position
		}
	}
	
	public static int[] merge(int[] a, int[] b)
	{
		int[] c = new int[a.length+b.length];
		int aptr = 0, bptr=0, cptr=0;
		while(aptr<a.length && bptr<b.length)
		{
			if(a[aptr]<=b[bptr])
			{
				c[cptr++]=a[aptr++];
			}
			else
			{
				c[cptr++]=b[bptr++];
			}
		}
		for(;aptr<a.length;aptr++)
			c[cptr++] = a[aptr];
		for(;bptr<b.length;bptr++)
			c[cptr++] = b[bptr];
		
		return c;
	}
	
	public void mergeSort(long[] arr)
	{
		//mergeSortRec(arr, 0, arr.length);
	}
	
	/*private void mergeSortRec(long[] arr, int low, int high)
	{
		if(low >= high)
			return;
		else
		{
			//Split into two parts
			int mid = (high - low) / 2;
			
			//Mergesort these parts
			return(mergeSort(mergeSortRec(arr, low, mid-1), mergeSortRec(arr, mid, high);
			mergeSortRec(arr, mid, high);
			//Merge them
			arr = mergeSort();
		}
	}*/
	
	public static void radixSort(long[] arr)
	{
		LinkedList[] buckets = new LinkedList[10];//Create a linked list of "buckets" with 10 digits
		for(int i = 0; i< arr.length; i++)
		{
			long n =  arr[i];//Read the element from the ith position
			long digit = n%10;// We retrieve the digit in the last position. Now we decide which bucket it goes in to
			//buckets[digit].insertLast(n); //Placing the element from the ith position into a bucket at the specific digit
		}
		int count = 0;
		for(int i = 0; i<buckets.length; i++)//Run through the entire length of the bucket, and it counts through the buckets
		{
			while(!buckets[i].isEmpty())//This while loop counts through the elements in whichever bucket we are in.
			{
				//arr[count++] = buckets[i].removeFirst();
			}
		}
	}
	
	public static void reverse(int arr[])
	{
		for(int x = 0; x<arr.length-1; x++)
		{
			int minIndex = x;
			for(int y = x; y<arr.length; y++)
			{
				if(arr[y]>arr[minIndex])//Same as selectionSort except we check to see if the element is bigger, bring it to the front of the array.
					minIndex = y;
			}
			swap(arr,x,minIndex);
		}

	}
	
	private static void swap(int[] arr, int x, int y)
	{
		int temp = arr[x];
		arr[x]  = arr[y]; //Passing an array by value - creating a copy and storing it in x and y.
		arr[y] = temp;//changing x and y will not change j.
	}//But when you pass an object, the original address changes as well.
	
	public static boolean isSorted(int[] a)
	{
		for (int i = 0; i < a.length - 1; i++)
			if (a[i] > a[i + 1])
				return false;
		return true;
	}
	
	public static int count(char[][]in)
	{
		int track = 0;
		for (int i = 0; i<in.length; i++)
		{
			for (int j = 0; j<in[i].length; j++)
			{
				if (in[i][j] >=0 && in[i][j] <= 9)
					{
						track++;
					}
				
			}
		}
		return track;
	}

}
