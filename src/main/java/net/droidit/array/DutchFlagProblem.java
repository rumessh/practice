package net.droidit.array;

public class DutchFlagProblem
{
    private int[] array;
    private int pivotIndex = 0;
    
    public DutchFlagProblem(int[] array, int pivotIndex)
    {
        this.array = array;
        this.pivotIndex = pivotIndex;
    }
    
    public void dutchFlagPartition()
    {
        int i = 0;
        int n = array.length;
        int pivot = array[pivotIndex];
        int lastIndex = n-1;
        int firstIndex = 0;
        
        while(i < lastIndex)
        {
        	int element = array[i];
            if(element < pivot)
            {
                ArrayUtils.swap(array, i++, firstIndex++);
            }
            else if(element > pivot)
            {
                ArrayUtils.swap(array, i, lastIndex--);
            }
            else
            {
                i++;    
            }
        }
    }
}