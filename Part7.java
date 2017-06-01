package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Queue;
import java.util.LinkedList;


public class Part7 {
	
	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		Queue<String> s = new LinkedList<String>();
		
		//Adds first 42 lines to clue
		for (int i = 0; i <42; i++){
			s.add(r.readLine());
		}
	
		//Reads rest of text, then if the string is blank "", ==0, it will print the head of the queue which is 
		//taken from above and updating.
		for (String nextLine = r.readLine(); nextLine != null; nextLine = r.readLine()) {
			
			s.add(nextLine);
			
			//Prints whatever it finds 42 lines back when a blank is found
			if(nextLine.length() == 0){
				w.println(s.element());
			}
			//Removes and does not print unless it is the 42nd line back from a blank
			s.remove();	 
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
