//Joel Simrose
//160052
//CMPT 370
//Assignment 1
//September 18, 2018

import java.util.*;
import java.lang.*;

/**
*This class is used to test different sorting algorithms and compare their times 
*for random data, sorted data, and reverse sorted data.
*/
public class sortAlgorithmsTest{


	/**
	*This is a method to selection sort an array
	*@param randArray takes the array to be sorted
	*/
	public static long SelectionSort(int[] randArray)		
	{	
		long startTime = PrintTime();	//get starting time for selection sort

		int count = 0;		

		for(int i=0; i<randArray.length-1; i++)			//set looping variant
		{

			int current = i;
			
			for(int j=i+1; j<randArray.length; j++)		//compare looping variant to array values
			{

				if(randArray[j] < randArray[current])
				{
					current = j;
				}

			}

			int temp = randArray[current];		//swap looping variant and next smallest number
			randArray[current] = randArray[i];
			randArray[i] = temp;			
			count++;					//increment pass number 

		}

		long endTime = PrintTime();			//get the finishing run time
		long runTime = endTime - startTime;		//get total running time for selection sort

		return runTime;
	}

	/**
	*This is a method to bubble sort an array
	*@param randArray takes the array to be sorted
	*/
	public static long BubbleSort(int[] randArray)
	{
		long startTime = PrintTime();	//get starting time for bubble sort

		int current;
		int count = 0;
		int size = randArray.length;

		for(int i=randArray.length; i>=0; i--)
		{

			for (int j=0; j<randArray.length-1; j++)
			{
				
				current = j+1;

				if(randArray[j] > randArray[current])
				{

					int temp = randArray[j];
					randArray[j] = randArray[current];
					randArray[current] = temp;

				}
				
			}

			count++;

		}

		long endTime = PrintTime();			//get the finishing run time
		long runTime = endTime - startTime;		//get total running time for bubble sort

		return runTime;
	}

	/**
	*This is a method to insertion sort an array
	*@param randArray takes the array to be sorted
	*/
	public static long InsertionSort(int[] randArray)
	{
		
		long startTime = PrintTime();	//get starting time for insertion sort
		
		for(int i=1; i<randArray.length; i++)
		{
			int value = randArray[i];

			int j = i-1;

			while((j > -1) && (randArray[j] > value))
			{
				randArray[j+1] = randArray[j];
				j--;

			}

			randArray[j+1] = value;
			
		}

		long endTime = PrintTime();			//get the finishing run time
		long runTime = endTime - startTime;		//get total running time for insertion sort

		return runTime;
	}

	/**
	*This is a method to quick sort an array
	*@param randArray takes the array to be sorted
	*@param low find lower number than pivot
	*@param high find higher number than pivot
	*/
	public static long QuickSort(int[] randArray, int low, int high)
	{
		
		long startTime = PrintTime();	//get starting time for quick sort

		int left = low;
		int right =  high;	
		int pivot = randArray[low+(high-low)/2];

		//System.out.println("Pivot "+pivot);

		while(left <= right)		//go through all of array
		{
			
			/**
			*find a number that is less than pivot number and a number that is greater
			*than pivot and then switch them.
			*/
			while(randArray[left] < pivot)	
			{
				left++;
			}


			while(randArray[right] > pivot)
			{
				right--;
			}


			if(left <= right)
			{
				int temp = randArray[left];		//swap number on left and on right
				randArray[left] = randArray[right];
				randArray[right] = temp;
				left++;							//increment index 
				right--;
				
			}				

		}	

		//Print(randArray,1);

		if(low < right)		//recurse and sort each side of array
		{	
			QuickSort(randArray, low, right);
		}

		if(high > left)
		{
			QuickSort(randArray, left, high);
		}

		long endTime = PrintTime();			//get the finishing run time
		long runTime = endTime - startTime;		//get total running time for quick sort

		return runTime;
		
	}



	/**
	*This is a method to merge sort an array
	*@param randArray takes the array to be sorted
	*/
	public static long Sort(int[] randArray)
	{
		
		long startTime = PrintTime();	//get starting time for merge sort

		if(randArray.length <= 1)
		{
			return 0;
		}

		int[] temp1 = new int[randArray.length/2];		//split up array
		int[] temp2 = new int[randArray.length-temp1.length];

		
		for(int i=0; i < temp1.length; i++)
		{
			temp1[i] = randArray[i];
		}

		
		for (int i=0; i < temp2.length; i++)
		{
			temp2[i] = randArray[temp1.length+i];
		}

		Sort(temp1);					//recurse through and sort
		Sort(temp2);
	 	Merge(randArray, temp1, temp2);

	 	long endTime = PrintTime();			//get the finishing run time
		long runTime = endTime - startTime;		//get total running time for merge sort

		return runTime;


	}

	/**
	*This is a method to merge sort an array
	*@param randArray takes the array to be sorted
	*@param temp1 half of array which has been split
	*@param temp2 other half of array which has been split
	*/
	public static void Merge(int[] randArray, int[] temp1, int[] temp2)
	{
		int first = 0;
		int second = 0;
		int next = 0;

		while(first < temp1.length && second < temp2.length)
		{
			if(temp1[first] < temp2[second])
			{
				randArray[next] = temp1[first];
				first++;
			}

			else
			{
				randArray[next] = temp2[second];
				second++;
			}

			next++;

		}

		while(first < temp1.length)
		{
			
			randArray[next] = temp1[first];
			first++;
			next++;

		}

		while(second < temp2.length)
		{
			
			randArray[next] = temp2[second];
			second++;
			next++;

		}

	}

	/**
	*This is a method to return the current time in milliseconds
	*/
	public static long PrintTime()
	{
		return System.currentTimeMillis();		//return current time 
	}


	/**
	*This is a method sort the array to pass in to algorithms for testing
	*@param randArray takes an array to sort
	*/
	public static int[] SortArray(int[] randArray)
	{
		for(int i=1; i<randArray.length; i++)
		{
			int value = randArray[i];

			int j = i;

			while(j > 0 && randArray[j-1] > value)
			{
				randArray[j] = randArray[j-1];
				j--;

			}

			randArray[j] = value;
			
		}

		return randArray;
	}

	/**
	*This is a method to reverse sort an array
	*@param array takes an array to reverse 
	*/
	public static int[] ReverseSort(int[] array)
	{
		for(int i=0; i < array.length/2; i++)
		{
				
			int temp = array[i];
			array[i] = array[array.length-i-1];
			array[array.length-i-1] = temp;

		}

		return array;
	}

	/**
	*This is a method to reset the random array to what it was before it is sorted.
	*@param randArray takes the random array which has been sorted
	*@param tempReset takes the copy of the original random array to to reset randArray
	*/
	public static int[] ResetRand(int[] randArray, int[] tempReset)
	{
		for(int i=0; i<tempReset.length; i++)
		{
			randArray[i] = tempReset[i];
		}

		return randArray;
	}

	
	/**
	*This is a method to reset the sorted array
	*@param sortedArray takes the random array which has been sorted
	*@param tempSort takes the copy of the sorted array to to reset 
	*/
	public static int[] ResetSorted(int[] sortedArray, int[] tempSort)
	{
		for(int i=0; i<tempSort.length; i++)
		{
			sortedArray[i] = tempSort[i];
		}

		return sortedArray;
	}

	/**
	*This is a method to reset the reverse sorted array to what it was before it is sorted.
	*@param reverseArray takes the reverse array which has been sorted
	*@param tempReverse takes the copy of the reverse array to reset
	*/
	public static int[] ResetReverse(int[] reverseArray, int[] tempReverse)
	{
		for(int i=0; i<tempReverse.length; i++)
		{
			reverseArray[i] = tempReverse[i];
		}

		return reverseArray;
	}


	public static void main(String[] args)
	{

		int[] randArray = RandomArrayGen(150);		//create random array

		
		int[] temp1 = new int[randArray.length]; 	//create temp array

		for(int i=0; i < temp1.length; i++)
		{
			temp1[i] = randArray[i];
		}

		int[] tempReset = new int[randArray.length]; 	//create temp array to reset random

		for(int i=0; i < tempReset.length; i++)
		{
			tempReset[i] = randArray[i];
		}



		int[] sortedArray = SortArray(temp1);	//create sorted array

		
		int[] temp2 = new int[sortedArray.length];	//create temp array

		for(int i=0; i < temp2.length; i++)
		{
			temp2[i] = sortedArray[i];
		}



		int[] tempSort = new int[sortedArray.length];	//create temp array for sorted array

		for(int i=0; i < tempSort.length; i++)
		{
			tempSort[i] = sortedArray[i];
		}


		
		int[] reverseArray = ReverseSort(temp2);		//create reverse order array
		

		int[] tempReverse = new int[sortedArray.length];	//create temp array for reverse sort

		for(int i=0; i < tempReverse.length; i++)
		{
			tempReverse[i] = reverseArray[i];
		}



		int low = 0;			//for quicksort
		int high = randArray.length-1; 		//for quicksort
		

		//Used for outputting the time it takes for each algorithm 
		
		long selectionTimeRand = SelectionSort(randArray);	//call Selection Sort and pass in the array
		System.out.println("Selection Sort run time for random set: "+selectionTimeRand+" milliseconds");
		
		randArray = ResetRand(randArray, tempReset);

		long bubbleTimeRand = BubbleSort(randArray);	//call Bubble Sort and pass in the array
		System.out.println("Bubble Sort run time for random set: "+bubbleTimeRand+" milliseconds.");
		
		randArray = ResetRand(randArray, tempReset);

		long insertionTimeRand = InsertionSort(randArray);		//insertion sort
		System.out.println("Insertion Sort run time for random set: "+insertionTimeRand+" milliseconds.");
		
		randArray = ResetRand(randArray, tempReset);

		long quickTimeRand = QuickSort(randArray, low, high);	//quick sort return ending time
		System.out.println("Quick Sort run time for random set: "+quickTimeRand+" milliseconds.");

		randArray = ResetRand(randArray, tempReset);

		long mergeTimeRand = Sort(randArray);		//merge sort
		System.out.println("Merge Sort run time for random set: "+mergeTimeRand+" milliseconds");

		randArray = ResetRand(randArray, tempReset);



	
		System.out.println("");

		long selectionTimeSorted = SelectionSort(sortedArray);
		System.out.println("Selection Sort run time for sorted set: "+selectionTimeSorted+" milliseconds");

		sortedArray = ResetSorted(sortedArray, tempSort);

		long bubbleTimeSorted = BubbleSort(sortedArray);
		System.out.println("Bubble Sort run time for sorted set: "+bubbleTimeSorted+" milliseconds");
	
		sortedArray = ResetSorted(sortedArray, tempSort);

		long insertionTimeSorted = InsertionSort(sortedArray);
		System.out.println("Insertion Sort run time for sorted set: "+insertionTimeSorted+" milliseconds");

		sortedArray = ResetSorted(sortedArray, tempSort);

		long quickTimeSorted = QuickSort(sortedArray, low, high);
		System.out.println("Quick Sort run time for sorted set: "+quickTimeSorted+" milliseconds");

		sortedArray = ResetSorted(sortedArray, tempSort);

		long mergeTimeSorted = Sort(sortedArray);
		System.out.println("Merge Sort run time for sorted set: "+mergeTimeSorted+" milliseconds");

		sortedArray = ResetSorted(sortedArray, tempSort);

		System.out.println("");


		long selectionTimeRevSort = SelectionSort(reverseArray);
		System.out.println("Selection Sort run time for reverse sorted set: "+selectionTimeRevSort+" milliseconds");

		reverseArray = ResetReverse(reverseArray, tempReverse);

		long bubbleTimeRevSort = BubbleSort(reverseArray);
		System.out.println("Bubble Sort run time for reverse sorted set: "+bubbleTimeRevSort+" milliseconds");


		reverseArray = ResetReverse(reverseArray, tempReverse);

		long insertionTimeRevSort = InsertionSort(reverseArray);
		System.out.println("Insertion Sort run time for reverse sorted set: "+insertionTimeRevSort+" milliseconds");


		reverseArray = ResetReverse(reverseArray, tempReverse);

		long quickTimeRevSort = QuickSort(reverseArray, low, high);
		System.out.println("Quick Sort run time for reverse sorted set: "+quickTimeRevSort+" milliseconds");


		reverseArray = ResetReverse(reverseArray, tempReverse);

		long mergeTimeRevSort = Sort(reverseArray);
		System.out.println("Merge Sort run time for reverse sorted set: "+mergeTimeRevSort+" milliseconds");


		reverseArray = ResetReverse(reverseArray, tempReverse);

	}

	/**
	*This is a function to print the arrays 
	*@param randArray array to print
	*/

	public static void Print(int[] randArray)	
	{
	
		for(int i=0; i < randArray.length; i++)	//print the array with formatting
		{

			System.out.print(randArray[i]);
			System.out.print(", ");

		}

		System.out.print("\n");
	}

	/**
	*This is a function to create a random number array of the specified size of numbers between 0 and 20.
	*@param takes an integer to specify the size of array 
	*/
	public static int[] RandomArrayGen(int size)
	{
		int[] randArray = new int[size];	//initialize array

		for(int i=0; i<size; i++)	
		{

			Random number = new Random();		//get a random number and add it to the array
			randArray[i] = number.nextInt(20); 

		}

		return randArray;

	}
}
