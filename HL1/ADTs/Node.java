/*
 * Node (element) class: building block of ADTs,
 * specifically for linked (list) implementations
 */
 
public class Node
{
	int  data;
	Node next; // (self-reference)
/*	
	public Node(int d)	// constructor <- allows you to create
	{					// a node and initialise its data at
		data = d;		// the same time.
		next = null;
	}
*/	
	public boolean hasNext()
	{
		if(next == null)
			return false;
		else
			return true;
			
		// OR // return next != null;
	}

/*
	public String toString()
	{
		return "" + data;
	}
*/

}

