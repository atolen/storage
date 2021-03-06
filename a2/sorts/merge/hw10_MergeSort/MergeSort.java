/* Anna Tolen
APCS2 pd9
HW09 -- Mergers and Acquisitions
2016-03-06 */
/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 
-split multi-element list until it has been converted into a set of single-element lists, which are inherently sorted
-smallest elements of both lists will be compared. smaller element is placed in a new list.
-top elements from each list continue to be compared to one another, with the smaller of the two placed as the next element in the new list. items are compared until one list is exhausted, in which case all elements from the remaining list are placed in the new list (works because each of the two lists is sorted within itself)
-merge merge merge!
-sorted list whoo!

  ======================================*/

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {
	int[] ret = new int[a.length + b.length];
	int aCtr = 0;
	int bCtr = 0;

	for( int i = 0; i < ret.length; i++ ) {
	    if( aCtr == a.length ) { 
		ret[i] = b[bCtr];
		bCtr++;
	    }

	    else if( bCtr == b.length ) {
		ret[i] = a[aCtr];
		aCtr++;
	    }

	    else if( a[aCtr] < b[bCtr] ) {
		ret[i] = a[aCtr];
		aCtr++;
	    }

	    else {
		ret[i] = b[bCtr];
		bCtr++;
	    }
	}
	return ret;

    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     * precond: arr.length > 0
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
	int pos = arr.length / 2;
	int ctr = 0;
	if( arr.length != 1 ) {
	    int[] tempA = new int[pos];
	    int[] tempB = new int[arr.length - pos];
	    for( int i = 0; i < pos; i++ ) {
		tempA[i] = arr[i];
	    }
	    for( int i = pos; i < arr.length; i++ ) {
		tempB[ctr] = arr[i];
		ctr++;
	    }
	    
	    return merge(sort(tempA),sort(tempB));
	}
	else {
	    return arr;
	}
    }//end sort()
   

    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    //Everything is a 0!
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {


	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};
	
	/*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );
	

	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );

	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );
	/*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class MergeSort
