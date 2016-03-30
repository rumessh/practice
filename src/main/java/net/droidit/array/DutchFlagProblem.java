package net.droidit.array;

public class DutchFlagProblem
{
    private int[] array;
    private int pivotElement = 0;
    
    public DutchFlagProblem(int[] array, int pivotIndex)
    {
        this.array = array;
        this.pivotElement = array[pivotIndex];
    }
    
    public void dutchFlagPartition()
    {
        int i = 0;
        int n = array.length;
        int lastIndex = n;
        int firstIndex = 0;
        
        while(i < lastIndex)
        {
        	int element = array[i];
            if(element < pivotElement)
            {
                ArrayUtils.swap(array, i++, firstIndex++);
            }
            else if(element > pivotElement)
            {
                ArrayUtils.swap(array, i, --lastIndex);
            }
            else
            {
                i++;    
            }
        }
    }
    
    public boolean validatePartition()
    {
    	int i=0;
    	int n = array.length;
    	
    	while( i < n && array[i] < pivotElement) i++;
    	while( i < n && array[i] == pivotElement) i++;
    	while(i < n && array[i] > pivotElement) i++;
    	
    	return i == n;
    }
}