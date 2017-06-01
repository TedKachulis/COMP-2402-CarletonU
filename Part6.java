package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

public class Part6 {
	
	/**
	 * Read lines one at a time from r.  After reading all lines, output
	 * all lines to w, outputting duplicate lines only once.  Note: the order
	 * of the output is unspecified and may have nothing to do with the order
	 * that lines appear in r.
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
        //Creates a map, to what line is at what position. String is for the line info, integer for line number
		Map<String,Integer> s = new LinkedHashMap<String, Integer>();

		//Starts line numer at 0
        int position = 0;
        
        //Adds lines to map while adding and increasing the position of the string. Pairs the string to a position.
        for (String line = r.readLine(); line != null; line = r.readLine()) {
            s.put(line,position);
            //updates position of the string being added
            position++;
        }
        
        //If even number, print. If not even number, then it exits loop. Uses remainders to check.
        for (Map.Entry<String, Integer> pos :s.entrySet()){
        	String key = pos.getKey();
        	int keyValue = pos.getValue();
        	
        	if (keyValue % 2 == 0){
        		System.out.println(key);
        	}
        }
        
        //Prints the odd numbers, uses remainders to check again.
        for (Map.Entry<String, Integer> pos :s.entrySet()){
        	String key = pos.getKey();
        	int keyValue = pos.getValue();
        	
        	if (keyValue % 2 == 1){
        		System.out.println(key);
        	}
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