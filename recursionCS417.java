
public class recursionCS417 
{
	public static int BinSrch(int A[], int Size, int Target)
	{
		int low = 0, hi = Size - 1;
		int mid;
		while (low <= hi)
		{
			mid = (low + hi) / 2;
			if(A[mid]==Target)
				return mid;
			else if (A[mid] < Target)
				low = mid + 1;
			else
				hi = mid - 1;
		}
		return - 1;
	}
	
	public static int binSrchRec(int[] a, int low, int high, int target)
	{
		if(low > high)
			return -1;
		int mid = (low + high) / 2;
		if(a[mid] == target)
			return mid;
		else if(a[mid] < target)
			return binSrchRec(a, mid+1, high, target);
		else
			return binSrchRec(a, low, mid - 1, target);
	}
	
	public static int binSrchRec2(int[] a, int target) //Makes program much more intuitive, we just need the array and target, not the low and high
	{
		return binSrchRec(a, 0, a.length - 1, target);
	}
	
	public static void main(String[] args)
	{
		int[] arr = {1,3,5,6,7,8,11,20};
		System.out.println(BinSrch(arr,8,3));
		System.out.println(binSrchRec2(arr, 3));
	}
	
	
}
