package net.droidit.array;

import java.util.Random;

public class ArrayUtils
{
    public static void swap(int arr[], int i1, int i2)
    {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
    
    public static int[] generateRandomArray(int size)
    {
    	Random random = new Random();
    	
    	int[] array = new int[size];
    	
    	for(int i=0 ; i< size; i++)
    	{
    		array[i] = random.nextInt();
    	}
    	
    	return array;
    }
}