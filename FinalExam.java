import java.util.*;

public class FinalExam 
{
	public static int[] findIntersection(int [] array1, int[] array2)
	{
		int matches = -1; //to count similar numbers
		//int k = 0;

		int j = 0;
		int i = 0;
		int [] finalArr = new int[array1.length];
		
		while(i < array1.length && j < array2.length)
		{
			if(array1[i] < array2[j])
				i++;
			else if(array1[i] > array2[j])
				j++;
			else
			{
				matches++;
				finalArr[matches] = array1[i];
				i++;
				j++;
			}
		}
			
		return finalArr;
	}
	public static int Mode(int[] arr)
	{
		int index = 0;
		int arrMax = 0;

		for(int j = 0; j< arr.length; j++)
		{
			if(arr[j] > arrMax)
				arrMax = arr[j];
		}
		
		int [] freqArr = new int[arrMax + 1];

		int freqArrMax = 0;
		
		for(int i = 0; i < arr.length; i++)
		{			
			freqArr[arr[i]] += 1;
		}
		
		for(int i = 0; i < freqArr.length; i++)
		{
			if(freqArr[i] > freqArrMax)
			{
				freqArrMax = freqArr[i];
				index = i;
			}
		}

		return index;
		
	}
	static void printArray(int arr[]) 
	{
		int n = arr.length; 
		for (int i=0; i<n; ++i)
			System.out.println(arr[i] + "  ");
		System.out.println(); 
	}
	
	public static void main(String[] args)
	{
		int [] arr1 = {1, 3, 4, 5,  7,  9, 9};
		int [] arr2 = {1, 4, 6, 7, 8, 10};
		
		int [] newArr = findIntersection(arr1, arr2);
		int mode = Mode(arr1);
		
		//System.out.println(Mode(arr1));

		
		printArray(newArr);
	}
	
	public int noEdges(int[][] adjMatrix)
	{
		int counter = 0;
		for(int i = 0; i < adjMatrix.length; i++)
		{
			for(int k = 0; k < adjMatrix.length; k++)
			{
				if(adjMatrix[i][k] == 0)
					counter++;
				if(counter == adjMatrix.length)
					return i;
			}
		}
		return -1;
	}
	

}
