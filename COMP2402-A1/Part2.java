package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeSet;

public class Part2 {
	
	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
        
		//Enter into a TreeSet, which sorts the lines.
		TreeSet<String> s = new TreeSet<String>();
		
		/*((line1, line2) -> {
            int ignoreCapital = String.CASE_INSENSITIVE_ORDER.compare(line1, line2);
            	return ignoreCapital == 0 ? line1.compareTo(line2) : ignoreCapital;
        });
        //////////////////////////////////////////////////////////////////////////////
        The above commented out code is for use should the user want output to be/////
        purely alphabetical, not affected by capitalization. For purposes of this/////
        assignement, it shall remain the natural sort order of my interface (TreeSet)/
        as specified in the assignement pdf. *////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////
        
		//Adds
        for (String line = r.readLine(); line != null; line = r.readLine()) {
            s.add(line);
        }

        for (String text : s) {
            w.println(text);
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
