package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
public class Part5 {
	
	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	 
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		//Add into a list, so that duplicates are not deleted
		List<String> lengthSortedS = new ArrayList<String>();
		//Comparator for string length
		Comparator<String> length = new Comparator<String>(){
		
			public int compare(String s1, String s2){
				//depending on string length, the length value is updated to be given proper position 
				if (s1.length() > s2.length())
					return 1;
				if (s2.length() > s1.length())
					return -1;
				else
					return 0;
			}
		};
		
		//Adds lines to the new list and outputs, this is in order
		for (String line = r.readLine(); line !=null; line =r.readLine()){
			lengthSortedS.add(line);
		}
		
		//gets sorted, and compare values used, to together create the appropriate list
		Collections.sort(lengthSortedS);
		Collections.sort(lengthSortedS, length);
				
		for (String lines : lengthSortedS){
			w.println(lines);
		}
	}
	

	/**
	 * The driver.  Open a BufferedReader and a PrintWriter, either from System.in
	 * and System.out or from filenames specified on the command line, then call doIt.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader r;
			PrintWriter w;
			if (args.length == 0) {
				r = new BufferedReader(new InputStreamReader(System.in));
				w = new PrintWriter(System.out);
			} else if (args.length == 1) {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(System.out);				
			} else {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(new FileWriter(args[1]));
			}
			long start = System.nanoTime();
			doIt(r, w);
			w.flush();
			long stop = System.nanoTime();
			System.out.println("Execution time: " + 10e-9 * (stop-start));
		} catch (IOException e) {
			System.err.println(e);
			System.exit(-1);
		}
	}
}
