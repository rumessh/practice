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
    
    public static int[] generateRandomArray(int limit)
    {
    	return new Random()
    			.ints()
    			.limit(limit)
    			.toArray();
    }
    
    public static int[] generateRandomShuffledArray(int limit, int start, int bound)
    {
    	return new Random()
    			.ints(limit, start, bound)
    			.toArray();
    }
}