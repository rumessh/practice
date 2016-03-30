package net.droidit.array;

public class DutchFlagProblem
{
    private int[] array;
    private int pivotElement = 0;
    private int firstKey = 0;
    private int secondKey = 0;
    private int thirdKey = 0;
    
    public DutchFlagProblem(int[] array, int pivotIndex)
    {
        this.array = array;
        this.pivotElement = array[pivotIndex];
    }
    
    public DutchFlagProblem(int[] array, int k1, int k2, int k3)
    {
    	this.array = array;
    	this.firstKey = k1;
    	this.secondKey = k2;
    	this.thirdKey = k3;
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
    
    public void dutchPartitionBasedKeys()
    {
    	int i = 0;
    	int firstIndex = 0;
    	int lastIndex = array.length;

    	while( i < lastIndex)
    	{
    		if( array[i] == firstKey)
    		{
    			ArrayUtils.swap(array, i++, firstIndex++);
    		}
    		else if(array[i] == secondKey)
    		{
    			i++;
    		}
    		else if(array[i] == thirdKey)
    		{
    			ArrayUtils.swap(array, i, --lastIndex);
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
    
    public boolean validateThreeKeyPartition()
    {
    	int i=0;
    	int n = array.length;
    	
    	while( i < n && array[i] == firstKey) i++;
    	while( i < n && array[i] == secondKey) i++;
    	while(i < n && array[i] == thirdKey) i++;
    	
    	return i == n;
    }
}