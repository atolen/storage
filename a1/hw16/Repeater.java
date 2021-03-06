/* Anna Tolen
APCS1 pd10
HW16 -- Do I repeat myself? Very well, then I repeat myself
2015-10-15 */

public class Repeater {
    public static String fenceW( int posts ) { // while loop
	String retStr = "|";
	String post = "--|";

	if( posts == 0 ) {
	    retStr = ""; // returns empty string if 0 posts
	}
	else {
	    int count = 1;
	    while (count < posts) { 
		retStr += post; // adds posts
		count += 1; 	
	    } // end loop
	} // end else block
	return retStr;
    } // end method
	
       

    public static String fenceR( int posts ) { // recursion
	 String retStr = "";
	 if( posts > 1 ) {
	     retStr += "|--";
	     retStr += fenceR( posts - 1 );
	 } // end if block
	 else if( posts == 1 ) {
	     retStr += "|";
	 } // end else if 
	 return retStr;
    } // end method
	
     public static void main( String [] args ) {
	 System.out.println(fenceW(0));
	 System.out.println(fenceW(1));
	 System.out.println(fenceW(2));	 
	 System.out.println(fenceW(3));
	 System.out.println(fenceW(6));	 	 	 

	 System.out.println(fenceR(0));	 
	 System.out.println(fenceR(1));
	 System.out.println(fenceR(2));
	 System.out.println(fenceR(3));
	 System.out.println(fenceR(6));	 	 
	
     } // end main
} // end class
