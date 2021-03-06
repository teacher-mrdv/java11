/*
 *	Practical Test #2 IB Computer Science MDV: Arrays, statistics
 */
import java.util.*;
import java.io.*;

public class PracticalTestQ3
{
	// Array size:
	public static int size(double[] array)
	{
		int result = array.length; // modify
		return result;
	}
	//------------------------------------------------------------------

	// Minimum:
	public static double min(double[] array)
	{
		double minimum = array[0]; // modify
		for(double x : array)
			if(x < minimum)
				minimum = x;
		return minimum;
	}
	//------------------------------------------------------------------

	// Maximum:
	public static double max(double[] array)
	{
		double maximum = array[0]; // modify
		for(double x : array)
			if(x > maximum)
				maximum = x;
		return maximum;
	}
	//------------------------------------------------------------------

	// Range
	public static double range(double[] array)
	{
		double range = max(array) - min(array);
		return range;
	}
	//------------------------------------------------------------------

	// Average:
	public static double average(double[] array)
	{
		double average = 0.0; // modify
		for(double x : array)
			average = average + x;
		return average/size(array);
	//	return average/array.length;	
	}
	//------------------------------------------------------------------

	// Mode:
	public static double mode(double array[])
	{
		double mode = 0.0;
		int maxCount = 0;
		for(int i = 0; i < array.length; i++)
		{	int count = 0;
			for(int j = 0; j < array.length; j++)
			{	if(array[i] == array[j])
					count++;
			}
			if(count > maxCount)
			{	maxCount = count;
				mode = array[i];
			}
		}
		return mode;
	}
	//------------------------------------------------------------------

	// For the median to work, the array double[] MUST BE SORTED
	public static double median(double[] array)
	{
		Arrays.sort(array); // DO NOT REMOVE THIS LINE, it sorts the array
		double median = 0.0;
		int middle = size(array) / 2;
		if(array.length % 2 == 0) // even length?
			// average of 2 elements in the middle of the array
			median = (array[middle-1]+array[middle]) / 2;
		else
			// middle element if length is odd
			median = array[middle];
		
		//your code goes here
		return median;
	}

	public static double formatDouble(double x, int decimals)
	{	double d = 10*decimals;
		double result = ((int)(x*d)) / d;
		return result;
	}
	
	public static String formatDouble(double x)
	{
		String result = String.format("%.2f\n", x);
		return result;
	}
	//------------------------------------------------------------------

	public static void main (String args[]) throws IOException
	{
		
		System.out.println("\n*** Statistical Analysis of Data Sets ***\n");

		double rainfall[]    = load("rainfall.txt");	// load data from files
		double temperature[] = load("temperature.txt"); // into arrays

		System.out.println( "\nSingapore Rainfall Statistics" );
		System.out.println( "Measurements   : " + size(rainfall) );
		System.out.printf( "Minimum   (0.2): " + formatDouble(min(rainfall)) );
		System.out.println( "Maximum (765.9): " + formatDouble(max(rainfall), 2) );
		System.out.println( "Range   (765.7): " + formatDouble(range(rainfall),2) );
		System.out.println( "Average(178.89): " + average(rainfall) );
		System.out.println( "Mode    (127.2): " + mode(rainfall) );
		System.out.println( "Median  (159.7): " + median(rainfall) );

		System.out.println( "\nSingapore Temperature Statistics" );
		
		// write the appropriate code to process the temperature array here

		System.out.println();
	}

	//------------------------------------------
	//- DO NOT MODIFY THE CODE BELOW THIS LINE -
	//------------------------------------------

    public static double[] load(String fileName) throws IOException
    {
        //System.out.println("<<< Loading data >>>");
        File file = new File(fileName);
        if (!file.exists())
        {
            System.out.println("ERROR - Data file not found. Download the file again.");
            return null;
        }
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr); //read mode
        String temp;
        int count = 0;
		double[] data = new double[countLines(fileName)];
		while ( br.ready() )
		{
            temp = br.readLine();
            data[count] = Double.parseDouble(temp);
            count++;
        }
        br.close();
        System.out.println(fileName + " file loaded.");// optional
        return data;
    }

    public static int countLines(String fileName) throws IOException
    {
        File file = new File(fileName);
        if ( !file.exists() )
        {
            System.out.println("ERROR - Data file not found. Download the file again.");
            return 0;
        }
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr); //read mode
        String temp;
        int count = 0;
		while ( br.ready() )
		{
			temp = br.readLine();
            count++;
        }
        br.close();
        return count;
    }


}


